package com.mycompany.petshop.model.classes;

public class Animal {
    private int id, id_cliente;
    private String nome;

    public Animal(int id, int id_cliente, String nome) {
        this.id = id;
        this.id_cliente = id_cliente;
        this.nome = nome;
    }

    public Animal(int id_cliente, String nome) {
        this.id_cliente = id_cliente;
        this.nome = nome;
    }

    public void setid_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
    public int getId() {
        return id;
    }

    public int getid_cliente() {
        return id_cliente;
    }

    public String getNome() {
        return nome;
    }
  
}