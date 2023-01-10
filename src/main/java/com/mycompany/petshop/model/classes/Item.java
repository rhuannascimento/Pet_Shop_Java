package com.mycompany.petshop.model.classes;

public abstract class Item {
    private int id;
    private String nome;
    private float preco;
    private String tipo;
    private boolean disponivel;
    String categoria;

    public Item() {
    }

    public Item(int id, String nome, float preco, String tipo, boolean disponivel, String categoria) {
        this.id = id;
        this.nome = nome.toLowerCase();
        this.preco = preco;
        this.tipo = tipo.toLowerCase();
        this.disponivel = disponivel;
        this.categoria = categoria.toLowerCase();
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome.toLowerCase();
    }

    public void setNome(String nome) {
        this.nome = nome.toLowerCase();
    }

    public float getPreco() {
        return this.preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getTipo() {
        return this.tipo.toLowerCase();
    }

    public void setTipo(String tipo) {
        this.tipo = tipo.toLowerCase();
    }

    public boolean isDisponivel() {
        return this.disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString(){
        return this.categoria + " " + this.id + " -> " + this.tipo + " " + this.nome + " - ";
    }

}
