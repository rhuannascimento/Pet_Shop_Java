package com.mycompany.petshop.model.classes;

public class Servico extends Item {
    private int duracao;
    private String idResponsavel;

    public Servico() {
    }

    public Servico(int id, String nome, float preco, String tipo, boolean disponivel, int duracao,
            String idResponsavel) {
        super(id, nome, preco, tipo, disponivel);
        this.duracao = duracao;
        this.idResponsavel = idResponsavel;
    }

    public int getDuracao() {
        return this.duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getIdResponsavel() {
        return this.idResponsavel;
    }

    public void setIdResponsavel(String idResponsavel) {
        this.idResponsavel = idResponsavel;
    }

}