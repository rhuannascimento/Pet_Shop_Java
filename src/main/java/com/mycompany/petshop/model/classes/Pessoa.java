package com.mycompany.petshop.model.classes;

public class Pessoa extends Cliente {
    private String email;
    private String telefone;

    public Pessoa() {
    }

    public Pessoa(int id, String nome, String cpf, String tipo, String email, String telefone) {
        super(id, nome, cpf, "animal");
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

}
