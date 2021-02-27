package com.example.gestion_contact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AjoutActivity extends AppCompatActivity {

    private Button btn_add;
    private EditText nom,numero;
    private ContactSqlLiteDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout);
        btn_add = findViewById(R.id.btn_note_add);
        nom = findViewById(R.id.add_name);
        numero = findViewById(R.id.add_num);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (nom.getText().toString().equals("")||numero.getText().toString().equals(""))
                {
                    Toast.makeText(AjoutActivity.this, "Add missing data", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Contact c = new Contact(nom.getText().toString(), numero.getText().toString());
                    db.createContact(c);
                    Intent i = new Intent(AjoutActivity.this,MainActivity.class);
                    startActivity(i);
                }




            }
        });


    }
}