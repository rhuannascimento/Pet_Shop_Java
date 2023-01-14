package com.mycompany.petshop.model.classes;
/*
    Caio Henrique Vieira Costa - 202176020
    Rhuan Nascimento - 202176033
    Bernardo Ortiz - ?
    Lucas Duarte - 202176012
*/
public class Roupa extends Mercadoria {

    private String tamanho;
    private String especie;
    private String cor;

    public Roupa() {
    }

    public Roupa(int estoque, String fornecedor, int id, String nome, float preco, String tipo,
            boolean disponivel, String tamanho, String especie, String cor) {

        super(estoque, fornecedor, "roupa", id, nome, preco, tipo, disponivel);
        this.tamanho = tamanho;
        this.especie = especie;
        this.cor = cor;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
    

    public String getTamanho() {
        return this.tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getEspecie() {
        return this.especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

}
