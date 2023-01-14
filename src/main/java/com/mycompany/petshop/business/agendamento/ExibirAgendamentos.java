package com.mycompany.petshop.business.agendamento;

import java.util.ArrayList;

import com.mycompany.petshop.model.classes.Agendamento;
import com.mycompany.petshop.repository.*;
import java.util.ArrayList;
/*
    Caio Henrique Vieira Costa - 202176020
    Rhuan Nascimento - 202176033
    Bernardo Ortiz - ?
    Lucas Duarte - 202176012
*/
public class ExibirAgendamentos {
    private ArrayList<Agendamento> agendamentos = new ArrayList();

    public ExibirAgendamentos() {

        AgendamentoRep ar = new AgendamentoRep();

        this.agendamentos = ar.getAllStartingToday();

    }
    
    public Agendamento getUltimo(){
        
        return agendamentos.get(agendamentos.size()-1);

    }

    public ArrayList<Agendamento> getAgendamentos() {
        return agendamentos;
    }
}