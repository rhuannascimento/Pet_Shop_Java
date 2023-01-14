package com.mycompany.petshop.model.classes;
/*
    Caio Henrique Vieira Costa - 202176020
    Rhuan Nascimento - 202176033
    Bernardo Ortiz - ?
    Lucas Duarte - 202176012
*/
public class Remedio extends Mercadoria {

    private String utilidade;
    private String orientacao;

    public Remedio() {
    }

    public Remedio(int estoque, String fornecedor, int id, String nome, float preco, String tipo,
            boolean disponivel, String utilidade, String orientacao) {

        super(estoque, fornecedor, "remedio", id, nome, preco, tipo, disponivel);
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
