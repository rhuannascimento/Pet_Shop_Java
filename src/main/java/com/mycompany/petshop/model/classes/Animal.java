package com.mycompany.petshop.model.classes;

import java.sql.PreparedStatement;

public class Animal extends Cliente {
    private String especie;

    public Animal(int id) {
        super(id, "", "", "animal");
    }

    public Animal(int id, String nome, String cpf, String especie) {
        super(id, nome, cpf, "animal");
        if(especie != null) this.especie = especie.toLowerCase();
    }

    public String getEspecie() {
        return this.especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }
    
    public String toString(){
        String s = super.toString() + " - " + this.especie;
        return s;
    }
    
}