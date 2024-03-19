package com.example.homelibrary;

import androidx.annotation.NonNull;

public class Book {
    String title;
    String author;
    Integer year;
    Integer cover;

    public Book(String title, String author, Integer year, Integer cover) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.cover = cover;
    }

    @NonNull
    @Override
    public String toString() {
        return author + ". " + title + ". " + "Год издания: " + year;
    }
}
