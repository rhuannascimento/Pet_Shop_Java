package com.mycompany.petshop.model.classes;

public class Cliente {
  private int id;
  private String nome;
  private String cpf;
  private String tipo;

  public Cliente() {
  }

  public Cliente(int id, String nome, String cpf, String tipo) {
    this.id = id;
    this.nome = nome;
    this.cpf = cpf;
    this.tipo = tipo;
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCpf() {
    return this.cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getTipo() {
    return this.tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

}