package com.mycompany.petshop.model.classes;
/*
    Caio Henrique Vieira Costa - 202176020
    Rhuan Nascimento - 202176033
    Bernardo Ortiz - ?
    Lucas Duarte - 202176012
*/
public class Pessoa extends Cliente {
    private String email;
    private String telefone;

    public Pessoa() {
    }

    public Pessoa(int id, String nome, String cpf, String email, String telefone) {
        super(id, nome, cpf, "pessoa");
        this.email = email;
        this.telefone = telefone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String toString(){
        String s = super.toString() + " - " + this.email + " - " + this.telefone;
        return s;
    }
    
}
