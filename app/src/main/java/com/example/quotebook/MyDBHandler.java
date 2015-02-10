package com.example.quotebook;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

public class MyDBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "quotes.db";
    public static final String TABLE_QUOTES = "quotes";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_QUOTETEXT = "quotetext";
    public static final String COLUMN_AUTHOR = "author";

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_QUOTES + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT " +
                COLUMN_QUOTETEXT + " TEXT " +
                COLUMN_AUTHOR + " TEXT " +
                ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUOTES);
        onCreate(db);
    }

    //add new quote to db
    public void addQuote(Quote quote) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_QUOTETEXT, quote.get_quotetext());
        values.put(COLUMN_AUTHOR, quote.get_author());

        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_QUOTES, null, values);
        db.close();
    }

    //delete quote form db
    public void deleteQuote(String quoteText) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_QUOTES + " WHERE " + COLUMN_QUOTETEXT + "=\"" + quoteText + "\";");
    }
}
