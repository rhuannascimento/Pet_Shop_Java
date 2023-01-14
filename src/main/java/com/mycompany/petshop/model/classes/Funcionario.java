package com.mycompany.petshop.model.classes;

import java.sql.Time;
/*
    Caio Henrique Vieira Costa - 202176020
    Rhuan Nascimento - 202176033
    Bernardo Ortiz - ?
    Lucas Duarte - 202176012
*/
public class Funcionario {
    private int id;
    private String nome, password, cargo, username;
    private Time startTime;
    private Time endTime;

    public Funcionario() {
    }

    public Funcionario(int id, String nome, Time startTime, Time endTime, String cargo, String username, String password) {
        this.id = id;
        this.nome = nome;
        this.startTime = startTime;
        this.endTime = endTime;
        this.password = password;
        this.cargo = cargo;
        this.username = username.toLowerCase();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
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

    public Time getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }
    
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String newPass) {
        this.password = newPass;
    }
    
    public String toString(){
        return (this.id + " -> " +this.nome + " - " + this.startTime + " - " + this.endTime + " - " + this.username);
    }

}
