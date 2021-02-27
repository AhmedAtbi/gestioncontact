package com.example.gestion_contact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listContact;
    private Button btn_add;
    private ArrayList<Contact> contact_array;
    private ContactSqlLiteDB db;
    private AdapterClass adapterClass;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listContact = findViewById(R.id.listContact);
        ArrayList<Contact> contact_array = new ArrayList<>();
        btn_add = findViewById(R.id.addBtn);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,AjoutActivity.class);
                startActivity(i);
            }
        });


        db = new ContactSqlLiteDB(MainActivity.this);


        for (Contact c : db.ReadAllContact())
        {
            Log.d("TAG", "onCreate: "+c.getNom());


        }
       // contact_array = db.ReadAllContact();


//          adapterClass = new AdapterClass(MainActivity.this,contact_array);
//        listContact.setAdapter(adapterClass);
//
//        //adapterClass.notifyDataSetChanged();
//
//
//        listContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Contact c = (Contact)parent.getItemAtPosition(position);
//                Intent i = new Intent(MainActivity.this,EditActivity.class);
//
//                i.putExtra("nom",c.getNom());
//                i.putExtra("num",c.getNumero());
//                i.putExtra("id",c.getId());
//
//                startActivity(i);
//
//
//            }
//        });
//
//
//        listContact.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                Contact c = (Contact) parent.getItemAtPosition(position);
//
//                Toast.makeText(MainActivity.this, "Item Long click"+position+"\nnom : "+c.getNom() , Toast.LENGTH_SHORT).show();
//
//                return false;
//            }
//        });
//

    }
}