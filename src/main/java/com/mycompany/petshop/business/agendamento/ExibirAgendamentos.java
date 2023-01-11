package com.mycompany.petshop.business.agendamento;

import java.util.ArrayList;

import com.mycompany.petshop.model.classes.Agendamento;
import com.mycompany.petshop.repository.*;
import java.util.ArrayList;

public class ExibirAgendamentos {
    private ArrayList<Agendamento> agendamentos = new ArrayList();

    public ExibirAgendamentos() {

        AgendamentoRep ar = new AgendamentoRep();

        this.agendamentos = ar.getAll();

    }

    public ArrayList<Agendamento> getAgendamentos() {
        return agendamentos;
    }
}
