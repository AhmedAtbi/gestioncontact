package com.example.gestion_contact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditActivity extends AppCompatActivity {

    private Button btn_edit;
    private EditText nom,num;
    private ContactSqlLiteDB db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        btn_edit = findViewById(R.id.btn_note_edit);
        nom = findViewById(R.id.edit_name);
        num = findViewById(R.id.edit_num);

        Intent i = getIntent();

        String nomd = i.getStringExtra("nom");
        String numd = i.getStringExtra("num");

        nom.setText(i.getStringExtra("nom"));
        num.setText(i.getStringExtra("num"));


        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {






              if (nom.getText().toString() == nomd && num.getText().toString() ==numd ||(nom.getText().toString().equals("")||num.getText().toString().equals("")))
                {
                    Toast.makeText(EditActivity.this, "No update", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(EditActivity.this,MainActivity.class);
                    startActivity(i);
                }

             else {
                  Contact c = new Contact(nom.getText().toString(), num.getText().toString());
                  db.UpdateContact(c);
                  Toast.makeText(EditActivity.this, "Contact updated", Toast.LENGTH_SHORT).show();
                  Intent i = new Intent(EditActivity.this,MainActivity.class);
                  startActivity(i);
              }
            }
        });


    }



}