/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.model.classes;

import java.util.ArrayList;

/**
 *
 * @author viier
 *//*
    Caio Henrique Vieira Costa - 202176020
    Rhuan Nascimento - 202176033
    Bernardo Ortiz - ?
    Lucas Duarte - 202176012
*/
public class Agenda {
    private ArrayList<Agendamento> agenda;

    public Agenda() {
        this.agenda = new ArrayList<Agendamento>();
    }

    public void agendar(Agendamento a){
        this.agenda.add(a);
    }
    
    public void listAgendamentos(){
        System.out.println("Agendamentos:");
        for(Agendamento a : agenda){
            a.printAgendamento();
        }
    }

    
}