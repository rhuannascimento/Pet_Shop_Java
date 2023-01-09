package com.mycompany.petshop.model.classes;

public class Roupa extends Mercadoria {

    private String tamanho;
    private String especie;

    public Roupa() {
    }

    public Roupa(int estoque, String fornecedor, int id, String nome, float preco, String tipo,
            boolean disponivel, String tamanho, String especie) {

        super(estoque, fornecedor, "roupa", id, nome, preco, tipo, disponivel);
        this.tamanho = tamanho;
        this.especie = especie;

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
