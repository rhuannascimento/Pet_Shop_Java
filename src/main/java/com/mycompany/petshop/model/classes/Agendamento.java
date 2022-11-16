package com.mycompany.petshop.model.classes;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Agendamento {
  private int id;
  private LocalDateTime data_hora;
  private Animal animal;
  private Servico servico;

    public Agendamento(int id, LocalDateTime data_hora, Animal animal, Servico servico) {
        this.id = id;
        this.data_hora = data_hora;
        this.animal = animal;
        this.servico = servico;
    }

    public LocalDateTime getData_hora() {
        return data_hora;
    }

    public void setData_hora(LocalDateTime data_hora) {
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

    public void printAgendamento() {
        DateTimeFormatter data_formatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter hora_formatada = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println(this.animal.getNome() + " está agendado para fazer " + this.servico.getNome() + " às " + hora_formatada + " do dia " + data_formatada);
    }
    
}