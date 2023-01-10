package com.mycompany.petshop.model.classes;

public class Brinquedo extends Mercadoria {

    private String especie, material;

    public Brinquedo() {
    }

    public Brinquedo(int estoque, String fornecedor, int id, String nome, float preco, String tipo,
            boolean disponivel, String especie, String material) {

        super(estoque, fornecedor, "brinquedo", id, nome, preco, tipo, disponivel);
        this.especie = especie;
        this.material = material;

    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getEspecie() {
        return this.especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

}
