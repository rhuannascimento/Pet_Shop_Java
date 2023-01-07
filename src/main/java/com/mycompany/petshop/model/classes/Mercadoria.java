package com.mycompany.petshop.model.classes;

public abstract class Mercadoria extends Item {
    private int estoque;
    private String fornecedor;
    private String categoria;

    public Mercadoria() {
    }

    public Mercadoria(int estoque, String fornecedor, String categoria) {
        this.estoque = estoque;
        this.fornecedor = fornecedor;
        this.categoria = categoria;
    }

    public int getEstoque() {
        return this.estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public String getFornecedor() {
        return this.fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

}
