package com.mycompany.petshop.model.classes;

public class Racao extends Mercadoria {
    private String especie;
    private String sabor;

    public Racao() {
    }

    public Racao(int estoque, String fornecedor, int id, String nome, float preco, String tipo,
            boolean disponivel, String especie, String sabor) {

        super(estoque, fornecedor, "racao", id, nome, preco, tipo, disponivel);
        this.especie = especie;
        this.sabor = sabor;

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
