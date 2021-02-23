package com.example.gestion_contact;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AdapterClass extends ArrayAdapter {


        private TextView contact_nom,contact_num,contact_logo;


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.model_item,parent,false);


        Contact contact = (Contact) getItem((position));


        contact_nom = convertView.findViewById(R.id.nom);
        contact_num = convertView.findViewById(R.id.numero);
        contact_logo = convertView.findViewById(R.id.contact_logo);


        contact_nom.setText(contact.getNom());
        contact_num.setText(contact.getNumero());
        char logo = contact_nom.getText().charAt(0);
        contact_logo.setText(logo+"");


        return convertView;

    }

    public AdapterClass(@NonNull Context context, @NonNull List objects) {
        super(context, R.layout.model_item, objects);
    }
}
