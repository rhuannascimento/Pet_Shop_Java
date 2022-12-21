package com.mycompany.petshop.model.classes;

public class Animal extends Cliente {
    private String especie;

    public Animal() {
    }

    public Animal(int id, String nome, String cpf, String tipo) {
        super(id, nome, cpf, "animal");
    }

    public String getEspecie() {
        return this.especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

}