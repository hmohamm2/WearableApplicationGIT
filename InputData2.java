package com.example.wearableapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.AvoidXfermode;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.Display;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

/**
 * Created by hanaa on 7/1/16.
 */
public class InputData2 {
    SQLiteOpenHelper dbHelper;
    SQLiteDatabase dataBase;
    private final String TAG = "dataSource";

    //string array holding tables columns names which will be used by methods
    public static final String[] usersTableColumns = {
            DatabaseHelper.DATES,
            DatabaseHelper.NumMove
    };
    //constructor which receives activity context
    public InputData2(Context context) {
        //instantiate dbHelper object using DatabaseHelper class
        dbHelper = new DatabaseHelper(context);
    }
    public void open() {
        //opening database or creating table structures for the first time
        dataBase = dbHelper.getWritableDatabase();
        //logging
        Log.i(TAG, "database opened");
    }
    public boolean isOpen() {
        // checks if database is already open
        return dataBase.isOpen();
    }
    public void close() {
        //close database
        dataBase.close();
        Log.i(TAG, "database closed");
    }

    // insert movements into database
    public void insertValue(int numMovements) {
        //ContentValues implements map interface
        ContentValues values = new ContentValues();
        //put data you want into database
        values.put(DatabaseHelper.NumMove, numMovements);
        //pass string array and contentValues, inserts values corresponding with column dates
        // and returns date of inserted row
        long insertId = dataBase.insert(DatabaseHelper.TABLE_DATA, null, values);
        Log.i(TAG, "Added name id" + insertId);
    }
    public String getMovement(Date date) {

        String movement;

        //where clause which is our condition
        String whereClause = DatabaseHelper.DATES + " = ?";

        //arguments passed to where clause
        String[] whereArgs = {date+""};

        //create cursor to retrieve data. cursor will contain data when query is executed
        Cursor cursor = dataBase.query(DatabaseHelper.TABLE_DATA, usersTableColumns, whereClause,
                whereArgs, null, null, null);
        //log number of returned rows
        Log.i(TAG, "returned: " + cursor.getCount() + " movement rows .");

        //check if cursor is not null
        if(cursor.getCount() > 0) {
            cursor.moveToNext();

            movement = cursor.getString(cursor.getColumnIndex(DatabaseHelper.NumMove));
            Log.i(TAG, "data retrieved:" + movement);
            return movement;

        } else {
                //if cursor empty, no name found w given date so return null
            return null;
        }
    }

    // update function - enter in key (date), if key already exists update value but if it doesnt add amother key-value
    //if key-val already exist, update instead of creating a new one
    //Upgrading single movement



    public void deleteMovements(String date) {
        String whereClause = DatabaseHelper.NumMove + "=" + "?";
        String[] whereArgs = {date};
        int deleteDate = dataBase.delete(DatabaseHelper.TABLE_DATA, whereClause, whereArgs);
        Log.i(TAG, "deleted name id" + deleteDate);
    }

//    private SQLiteDatabase myDB;
//
//    public void InputData2() {
//        this.myDB = SQLiteDatabase.openOrCreateDatabase("STORAGE_DATABASE", null);
//        //this.myDB = SQLiteDatabase.openOrCreateDatabase("STORAGE_DATABASE", null, Context.MODE_PRIVATE);
//        this.myDB.execSQL("CREATE TABLE IF NOT EXISTS KV(Key VARCHAR, Value VARCHAR);");
//    }
//    public void setNumMovements(Date date, int numMovements) {
//        String myDate = String.valueOf(date);
//        String numMove = String.valueOf(numMovements);
//        String query = ("INSERT INTO KV VALUES (‘" + myDate + "','" + numMove + "');" );
//        this.myDB.execSQL(query);
//    }
//
//    public int getNumMovements(Date date) {
//        String myOtherDate = String.valueOf(date);
//        String query = ("SELECT * from KV WHERE Key = '" + myOtherDate + "';");
//        Cursor result = this.myDB.rawQuery(query, null);
//        result.moveToFirst();
//        String numMove = result.getString(1);
//        return Integer.getInteger(numMove);
//    }
//
//    public void delNumMovements(Date date) {
//        String delDate = String.valueOf(date);
//        String query = ("DELETE FROM KV WHERE Key = '" + delDate + "';");
//        this.myDB.execSQL(query);
//    }
}
