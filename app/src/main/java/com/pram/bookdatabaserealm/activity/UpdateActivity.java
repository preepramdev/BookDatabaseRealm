package com.pram.bookdatabaserealm.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.pram.bookdatabaserealm.R;
import com.pram.bookdatabaserealm.fragment.UpdateFragment;
import com.pram.bookdatabaserealm.model.Book;

public class UpdateActivity extends AppCompatActivity {

    private Book book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        initInstances();

        if (getIntent() != null) {
            book = getIntent().getParcelableExtra("book");
        }

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer, UpdateFragment.newInstance(book))
                    .commit();
        }
    }

    private void initInstances() {

    }
}
