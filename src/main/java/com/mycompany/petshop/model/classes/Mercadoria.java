package com.mycompany.petshop.model.classes;
/*
    Caio Henrique Vieira Costa - 202176020
    Rhuan Nascimento - 202176033
    Bernardo Ortiz - ?
    Lucas Duarte - 202176012
*/
public abstract class Mercadoria extends Item {
    private int estoque;
    private String fornecedor;
    private String categoria;

    public Mercadoria() {
    }

    public Mercadoria(int estoque, String fornecedor, String categoria, int id, String nome, float preco, String tipo,
            boolean disponivel) {

        super(id, nome, preco, tipo, disponivel, categoria);
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

}
