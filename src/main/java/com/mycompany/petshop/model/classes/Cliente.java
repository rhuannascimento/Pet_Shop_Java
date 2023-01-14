package com.mycompany.petshop.model.classes;
/*
    Caio Henrique Vieira Costa - 202176020
    Rhuan Nascimento - 202176033
    Bernardo Ortiz - ?
    Lucas Duarte - 202176012
*/
public abstract class Cliente {
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
  
  public String toString(){
      String s = this.id + " - " + this.cpf + " - " + this.nome;
      return s;
  }

}