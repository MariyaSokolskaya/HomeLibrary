package com.example.homelibrary;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {
    //перечень констант с именами базы, таблиц и полей таблиц
    public final static String DATABASE_NAME = "library.db";
    public final static int DATABASE_VERSION = 1;
    //TODO написать все константы с именами таблиц и полей таблиц для библиотеки
    public final static String TABLEAUTHORS = "authors";
    public final static String COL_NAME = "name";
    public final static String COL_SURNAME = "surname";
    public final static String COL_YEARS = "yearsOfLife";
    public final static String TABLEBOOKS = "books";
    public final static String COL_TITLE = "title";
    public final static String COL_ID_AUTHOR = "id_author";
    public final static String COL_YEAR = "year";
    public final static String COL_ANNOT = "annotation";

    public DataBaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
