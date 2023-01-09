package com.mycompany.petshop.model.classes;

public class Remedio extends Mercadoria {

    private String utilidade;
    private String orientacao;

    public Remedio() {
    }

    public Remedio(int estoque, String fornecedor, String categoria, int id, String nome, float preco, String tipo,
            boolean disponivel, String utilidade, String orientacao) {

        super(estoque, fornecedor, categoria, id, nome, preco, tipo, disponivel);
        this.utilidade = utilidade;
        this.orientacao = orientacao;

    }

    public String getUtilidade() {
        return this.utilidade;
    }

    public void setUtilidade(String utilidade) {
        this.utilidade = utilidade;
    }

    public String getOrientacao() {
        return this.orientacao;
    }

    public void setOrientacao(String orientacao) {
        this.orientacao = orientacao;
    }

}