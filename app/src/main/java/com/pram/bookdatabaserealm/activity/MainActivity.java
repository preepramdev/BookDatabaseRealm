package com.pram.bookdatabaserealm.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.pram.bookdatabaserealm.R;
import com.pram.bookdatabaserealm.db.BookDatabaseManager;
import com.pram.bookdatabaserealm.fragment.MainFragment;
import com.pram.bookdatabaserealm.model.Book;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initInstances();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer, MainFragment.newInstance())
                    .commit();
        }

        presetBook();
    }

    private void initInstances() {
    }

    private void presetBook() {
        List<Book> books = BookDatabaseManager.getInstance().getAllBooks();

        if (books.isEmpty()) {
            List<Book> presetBooks = new ArrayList<>();

            presetBooks.add(new Book(".NET Multithreading", "Alan Dennis", "360"));
            presetBooks.add(new Book("Unix Basic", "W. John Snow", "126"));
            presetBooks.add(new Book("Hello! Python", "Anthony Briggs", "352"));
            presetBooks.add(new Book("Software Requirements", "Benjamin L. Kovitz", "448"));

            for (Book presetBook : presetBooks) {
                BookDatabaseManager.getInstance().createBook(presetBook);
            }

            Log.e(TAG, "presetBook: " + presetBooks.toString());
        } else {
            Log.e(TAG, "books: " + books);
        }
    }
}