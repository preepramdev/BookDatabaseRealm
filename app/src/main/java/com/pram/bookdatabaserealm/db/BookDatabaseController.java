package com.pram.bookdatabaserealm.db;

import android.content.Context;
import android.util.Log;

import com.pram.bookdatabaserealm.manager.Contextor;
import com.pram.bookdatabaserealm.model.Book;

import java.util.List;

public class BookDatabaseController {
    private static final String TAG = "BookDatabaseController";
    private Context mContext;
    private BookDatabaseManager databaseManager;

    private Object emptyResult = new Object();

    public BookDatabaseController() {
        mContext = Contextor.getInstance().getContext();
        databaseManager = BookDatabaseManager.getInstance();
    }

    public void getAllBooks(BookDatabaseCallBack callBack) {
        List<Book> books = databaseManager.getAllBooks();

        for (Book book : books) {
            Log.e(TAG, "-->");
            Log.e(TAG, "fetchDatabase bookId: " + book.getId());
            Log.e(TAG, "fetchDatabase bookTitle: " + book.getTitle());
            Log.e(TAG, "fetchDatabase bookAuthor: " + book.getAuthor());
            Log.e(TAG, "fetchDatabase bookPages: " + book.getPages());
            Log.e(TAG, "<--");
        }

        callBack.onCallBack(books);
    }

    public void getBook(int bookId, BookDatabaseCallBack callBack) {
        Book book = databaseManager.getBook(bookId);
        callBack.onCallBack(book);
    }

    public void createBook(Book book, BookDatabaseCallBack callBack) {
        databaseManager.createBook(book);
        callBack.onCallBack(emptyResult); // void
    }

    public void updateBook(Book book, BookDatabaseCallBack callBack) {
        databaseManager.updateBook(book);
        callBack.onCallBack(emptyResult); // void
    }

    public void removeBook(int bookId, BookDatabaseCallBack callBack) {
        databaseManager.removeBook(bookId);
        callBack.onCallBack(emptyResult); // void
    }
}
