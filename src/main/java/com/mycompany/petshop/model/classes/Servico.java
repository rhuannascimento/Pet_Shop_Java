package com.mycompany.petshop.model.classes;

public class Servico extends Item {
    private int duracao;
    private int idResponsavel;

    public Servico() {
    }

    public String getCategoria() {
        return categoria;
    }

    public Servico(int id, String nome, float preco, String tipo, boolean disponivel, int duracao,
            int idResponsavel) {
        super(id, nome, preco, tipo, disponivel, "servico");
        this.duracao = duracao;
        this.idResponsavel = idResponsavel;
    }

    public int getDuracao() {
        return this.duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public int getIdResponsavel() {
        return this.idResponsavel;
    }

    public void setIdResponsavel(int idResponsavel) {
        this.idResponsavel = idResponsavel;
    }

}