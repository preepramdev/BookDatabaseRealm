package com.pram.bookdatabaserealm.model;

import android.os.Parcel;
import android.os.Parcelable;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Book extends RealmObject implements Parcelable {
    /**
     * @Required กำหนดให้ Field นั้น ห้ามมีค่า null
     * @PrimaryKey กำหนดให้ Field นั้นเป็น primary key
     * @Ignore เป็นการกำหนดว่า Field นั้นไม่ต้องการเก็บลงใน Database
     * @Index เป็นการเพิ่ม Search index ให้กับ Field นั้นๆ ใช้สำหรับการ Query
     */

    @PrimaryKey
    private Integer id;

    private String title;

    private String author;

    private String pages;

    public Book() {
    }

    public Book(String title, String author, String pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    protected Book(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        title = in.readString();
        author = in.readString();
        pages = in.readString();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        dest.writeString(title);
        dest.writeString(author);
        dest.writeString(pages);
    }
}
