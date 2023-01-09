package com.mycompany.petshop.model.classes;

import java.sql.Time;

public class Funcionario {
    private int id;
    private String nome, password;
    private Time startTime;
    private Time endTime;

    public Funcionario() {
    }

    public Funcionario(int id, String nome, Time startTime, Time endTime, String password) {
        this.id = id;
        this.nome = nome;
        this.startTime = startTime;
        this.endTime = endTime;
        this.password = password;
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
        return (this.id + " -> " +this.nome + " - " + this.startTime + " - " + this.endTime);
    }

}
