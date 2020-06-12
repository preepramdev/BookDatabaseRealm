package com.pram.bookdatabaserealm.db;

import com.pram.bookdatabaserealm.model.Book;

import io.realm.Realm;
import io.realm.RealmResults;

public class BookDatabaseManager {
    private final Realm realm;
    private static BookDatabaseManager instance;

    public BookDatabaseManager() {
        realm = Realm.getDefaultInstance();
    }

    public static BookDatabaseManager getInstance() {
        if (instance == null) {
            instance = new BookDatabaseManager();
        }

        return instance;
    }

    public Realm getRealm() {
        return realm;
    }

    public RealmResults<Book> getAllBooks() {
        return realm.where(Book.class).findAll();
    }

    /*public RealmResults<Book> getBook(int bookId) {
        return realm.where(Book.class).equalTo("id", bookId).findAll();
    }*/

    public Book getBook(int bookId) {
        return realm.where(Book.class).equalTo("id", bookId).findFirst();
    }

    public void createBook(Book book) {
        book.setId(nextId());
        realm.beginTransaction();
        realm.insert(book);
        realm.commitTransaction();
    }

    private int nextId() {
        Number student = realm.where(Book.class).max("id");
        if (student == null)
            return 0;
        else
            return student.intValue() + 1;
    }

    public void updateBook(Book book) {
        realm.beginTransaction();
        realm.insertOrUpdate(book);
        realm.commitTransaction();
    }

    public void removeBook(int bookId) {
        realm.beginTransaction();
        realm.where(Book.class)
                .equalTo("id", bookId)
                .findFirst()
                .deleteFromRealm();
        realm.commitTransaction();
    }
}
