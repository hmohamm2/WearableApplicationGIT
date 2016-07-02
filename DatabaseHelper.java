package com.example.wearableapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.view.View;

/**
 * Created by hanaa on 7/1/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String TAG = "database"; //used for logging

    //database version
    public static final int DATABASE_VERSION = 1;
    //database file name
    public static final String DATABASE_NAME = "inputData2";
    //table details
    public static final String TABLE_DATA = "number"; //table title
    public static final String DATES = "dates"; //primary key
    public static final String NumMove = "movements";

    //query of creating number of movements table
    public static final String CREATE_MOVEMENTS_TABLE =  "CREATE TABLE " + TABLE_DATA +
            " (" + DATES + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NumMove + " TEXT" + ")";

    //query string to delete table
    public static final String DELETE_TABLES = "DROP TABLE IF EXISTS " + TABLE_DATA +";";

    //constructor method, takes context and passes it to create the database
    public DatabaseHelper(Context context) {
        //creates database w/ given info
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //line executes query made earlier to create user table
        db.execSQL(CREATE_MOVEMENTS_TABLE);

        //Log table creation for debugging
        Log.i(TAG, TABLE_DATA + " has been created.");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //execute delete query
        db.execSQL(DELETE_TABLES);
        //explicit call to onCreate
        onCreate(db);
    }

}
