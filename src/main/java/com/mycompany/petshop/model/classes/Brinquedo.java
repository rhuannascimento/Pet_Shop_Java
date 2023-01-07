package com.mycompany.petshop.model.classes;

public class Brinquedo extends Mercadoria {

    private String especie;

    public Brinquedo() {
    }

    public Brinquedo(int estoque, String fornecedor, String categoria, int id, String nome, float preco, String tipo,
            boolean disponivel, String especie) {

        super(estoque, fornecedor, categoria, id, nome, preco, tipo, disponivel);
        this.especie = especie;

    }

    public String getEspecie() {
        return this.especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

}
