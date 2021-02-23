package com.example.gestion_contact;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ListView listContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listContact = findViewById(R.id.listContact);
        ArrayList<Contact> contact_array = new ArrayList<>();

        contact_array.add(new Contact("Ahmed Atbi","+21622222222"));
        contact_array.add(new Contact("Aymen Ben Amine","+21622333333"));
        contact_array.add(new Contact("Mohamed Aymen","+21622244444"));
        contact_array.add(new Contact("Maryem Hassan","+21625555555"));
        contact_array.add(new Contact("Yassine Gadri","+21622666666"));
        contact_array.add(new Contact("AAAaaa Atbi","+21622777777"));
        contact_array.add(new Contact("Ahmed Atbi","+21622222222"));

        AdapterClass adapterClass = new AdapterClass(MainActivity.this,contact_array);
        listContact.setAdapter(adapterClass);


    }
}