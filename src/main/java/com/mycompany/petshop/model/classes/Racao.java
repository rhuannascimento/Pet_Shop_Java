package com.mycompany.petshop.model.classes;
/*
    Caio Henrique Vieira Costa - 202176020
    Rhuan Nascimento - 202176033
    Bernardo Ortiz - ?
    Lucas Duarte - 202176012
*/
public class Racao extends Mercadoria {
    private String especie;
    private String sabor;
    int idade_recomendada;

    public Racao() {
    }

    public Racao(int estoque, String fornecedor, int id, String nome, float preco, String tipo,
            boolean disponivel, String especie, String sabor, int idade_recomendada) {

        super(estoque, fornecedor, "racao", id, nome, preco, tipo, disponivel);
        this.especie = especie;
        this.sabor = sabor;
        this.idade_recomendada = idade_recomendada;

    }

    public int getIdade_recomendada() {
        return idade_recomendada;
    }

    public void setIdade_recomendada(int idade_recomendada) {
        this.idade_recomendada = idade_recomendada;
    }

    public String getEspecie() {
        return this.especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getSabor() {
        return this.sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

}
