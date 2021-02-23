package com.example.gestion_contact;

public class Contact {


    private int id;
    private String nom,numero;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public Contact() {
    }

    public Contact( String nom, String numero) {
        this.numero = numero;
        this.nom = nom;
    }

    public Contact(int id, String numero, String nom) {
        this.id = id;
        this.numero = numero;
        this.nom = nom;
    }
}
