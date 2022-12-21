package com.mycompany.petshop.model.classes;

import java.time.LocalDateTime;

public class Funcionario {
    private int id;
    private String nome;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Funcionario() {
    }

    public Funcionario(int id, String nome, LocalDateTime startTime, LocalDateTime endTime) {
        this.id = id;
        this.nome = nome;
        this.startTime = startTime;
        this.endTime = endTime;
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

    public LocalDateTime getStartTime() {
        return this.startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return this.endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

}
