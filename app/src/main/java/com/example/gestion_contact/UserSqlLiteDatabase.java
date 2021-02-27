package com.example.gestion_contact;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class UserSqlLiteDatabase extends SQLiteOpenHelper {
//constructeur
    // donner le context
    //le nom de la base
    // le curseur pour mapping de la base
    // version de la base de donnee


    public UserSqlLiteDatabase(@Nullable Context context) {
        super(context, "db_task", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "CREATE TABLE user (id integer PRIMARY KEY,name varchar(255),phone varchar(255))";
        db.execSQL(create);

    }


    //verification de la version de la base de données
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //delete oldBase
        //Create db => create tables
        String delete = "DROP TABLE IF EXISTS user";
        db.execSQL(delete);

    }

    public void ShowTask(){
        SQLiteDatabase db_task = getReadableDatabase();

        db_task.execSQL("SELECT * FROM tasks");
    }

    public void CreateTask(Contact c)
    {   // appel de la base
        SQLiteDatabase db_task = getWritableDatabase();
        ContentValues data = new ContentValues();
        // data.put("Column Name",value)
        data.put("Name",c.getNom());
        data.put("phone",c.getNumero());
        db_task.insert("user",null,data);


    }

}
