package com.example.andriod.registrationformsqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Aneet Kashyap on 3/1/2018.
 */

public class DatebaseHelper extends SQLiteOpenHelper
{
    public  static final String DATABASE_NAME="register.db";
    public  static final String TABLE_NAME="registration";
    public  static final String COL_1 = "ID";
    public  static final String COL_2 = "F_Name";
    public  static final String COL_3 = "L_Name";
    public  static final String COL_4 = "Password";
    public  static final String COL_5 = "Email_Id";
    public  static final String COL_6 = "Phone_No";


    public DatebaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       // db.execSQL("Create Table " +TABLE_NAME+ (COL_1+"INTEGER PRIMARY KEY AUTO INCREMENT,"+COL_2+"TEXT," +COL_3+"TEXT,"+COL_4+"TEXT,"+COL_5+"TEXT,"+COL_6+"TEXT,"));
        db.execSQL(" Create Table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, F_Name TEXT, L_Name TEXT, Password TEXT, Email_Id TEXT, Phone_No TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
    onCreate(db);
    }
}
