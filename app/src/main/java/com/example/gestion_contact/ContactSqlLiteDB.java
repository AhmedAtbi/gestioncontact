package com.example.gestion_contact;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ContactSqlLiteDB extends SQLiteOpenHelper {


    public ContactSqlLiteDB(@Nullable Context context) {
        super(context, "db_contact",null , 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        String req1 = "CREATE DATABASE IF NOT EXISTS db_contact";
//        db.execSQL(req1);
        String req = "CREATE TABLE contact (id integer PRIMARY KEY,contactnom varchar(255),contactnum varchar(255))";
        db.execSQL(req);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String delete_db = "DROP TABLE IF EXISTS contact";
        db.execSQL(delete_db);
        onCreate(db);

    }

    public void createContact(Contact c){

        SQLiteDatabase db = getWritableDatabase();
        ContentValues data = new ContentValues();
        data.put("contactnom",c.getNom());
        data.put("contactnum",c.getNumero());
        db.insert("contact",null,data);
    }

    public ArrayList<Contact> ReadAllContact(){
        ArrayList<Contact> contact_array = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();
        String sql_getAll = "SELECT * FROM contact";
        Cursor cursor = db.rawQuery(sql_getAll,null);
        if (cursor.moveToFirst())
        {
            do
            {
                int id = cursor.getInt(0);
                String c_nom = cursor.getString(1);
                String c_num = cursor.getString(2);
                contact_array.add(new Contact(id,c_nom,c_num));

            }while(cursor.moveToNext());
        }


            return contact_array;
    }


    public void UpdateContact (Contact c)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues data = new ContentValues();
        data.put("contactnom",c.getNom());
        data.put("contactnum",c.getNumero());
        db.update("contact",data,"id = ?",new String[]{String.valueOf(c.getId())});
    }



}
