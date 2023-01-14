package com.mycompany.petshop.model.classes;
/*
    Caio Henrique Vieira Costa - 202176020
    Rhuan Nascimento - 202176033
    Bernardo Ortiz - ?
    Lucas Duarte - 202176012
*/
public class Servico extends Item {
    private int duracao;
    private int idResponsavel;

    public Servico(int id) {
        super(id, "", 0f, "", true, "servico");
    }

    
    public Servico(){
        
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