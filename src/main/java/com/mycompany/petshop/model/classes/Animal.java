package com.mycompany.petshop.model.classes;

public class Animal {
    private int id;
    private Cliente cliente
    private String nome;

    public Animal(int id, Cliente cliente, String nome) {
        this.id = id;
        this.cliente = cliente;
        this.nome = nome;
    }

    public Animal(Cliente cliente, String nome) {
        this.cliente = cliente;
        this.nome = nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
  
}