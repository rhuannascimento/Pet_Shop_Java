package com.mycompany.petshop.model.classes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.sql.Date;
import java.sql.Timestamp;
/*
    Caio Henrique Vieira Costa - 202176020
    Rhuan Nascimento - 202176033
    Bernardo Ortiz - ?
    Lucas Duarte - 202176012
*/
public class Agendamento {
    private int id;
    private Timestamp data_hora;
    private Animal animal;
    private Servico servico;
    
    private String a;
    private String b;
    private String c;

    public Agendamento(String a, String b, String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    
    
    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }


    public Agendamento(int id, Timestamp data_hora, Animal animal, Servico servico) {
        this.id = id;
        this.data_hora = data_hora;
        this.animal = animal;
        this.servico = servico;
    }

 

    public Timestamp getData_hora() {
        return data_hora;
    }

    public String getDataHoraString() {
        String s = "";
        s = (String.format("%02d", this.data_hora.getDate()) + "/" + String.format("%02d", this.data_hora.getMonth())+ "/" + this.data_hora.getYear() + " " + this.data_hora.getHours()+ ":"+String.format("%02d", this.data_hora.getMinutes()));
        return s;
    }
    
    public void setData_hora(Timestamp data_hora) {
        this.data_hora = data_hora;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "id - " + id + ", data_hora - " + getDataHoraString() + ", animal - " + animal + ", servico - " + servico;
    }

    public void printAgendamento() {
        DateTimeFormatter data_formatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter hora_formatada = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println(this.animal.getNome() + " está agendado para fazer " + this.servico.getNome() + " às "
                + hora_formatada + " do dia " + data_formatada);
    }

}