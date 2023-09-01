package com.example.day4_task2.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.day4_task2.data.Model;

import java.util.Scanner;

public class DataBaseAdapter {

    DataBaseHelper dataBaseHelper;

    public DataBaseAdapter(Context context) {

        dataBaseHelper = new DataBaseHelper(context);

    }

    public void insertRow(Model model) {

        SQLiteDatabase writeableDB = dataBaseHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DataBaseHelper.MOBILE_COL, model.getMobile());
        contentValues.put(DataBaseHelper.MESSAGE_COL, model.getMessage());

        writeableDB.insert(DataBaseHelper.TABLE_NAME, null, contentValues);

    }

    public Model getRow() {
        SQLiteDatabase readable = dataBaseHelper.getReadableDatabase();

        Model model = null;
        String[] cols = {DataBaseHelper.MOBILE_COL, DataBaseHelper.MESSAGE_COL};
        Cursor cursor = readable.query(DataBaseHelper.TABLE_NAME, cols, null, null, null, null, null);

        while (cursor.moveToNext()) {
            model = new Model(cursor.getString(0), cursor.getString(1));
        }

        cursor.close();
        return model;

    }

    static class DataBaseHelper extends SQLiteOpenHelper {

        private static final int DATABASE_VERSION = 1;

        private static final String DATABASE_NAME = "MOBILE_MESSAGE";

        private static final String TABLE_NAME = "TABLE_MOBILE_MESSAGE";

        private static final String ID_COL = "id";

        private static final String MOBILE_COL = "mobile";

        private static final String MESSAGE_COL = "message";

        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + MOBILE_COL + " TEXT, "
                + MESSAGE_COL + " TEXT );";

        public DataBaseHelper(@Nullable Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(query);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }

}
