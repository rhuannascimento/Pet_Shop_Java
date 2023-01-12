package com.mycompany.petshop.controller;

import com.mycompany.petshop.business.agendamento.*;
import com.mycompany.petshop.model.classes.Agenda;
import com.mycompany.petshop.model.classes.Agendamento;
import com.mycompany.petshop.model.classes.Animal;
import com.mycompany.petshop.model.classes.Servico;
import com.mycompany.petshop.model.exceptions.AgendamentoExp;
import java.sql.Timestamp;
import java.util.ArrayList;

public class AgendamentoCtrl {

    private ExibirAgendamentos exibirAgendamentos;
    private CadastrarAgendamento cadastrarAgendamento;
    private ExcluirAgendamento excluirAgendamento;
    private AtualizarAgendamento atualizarAgendamento;

    public ArrayList<Agendamento> exibirAgendamentos() {
        this.exibirAgendamentos = new ExibirAgendamentos();

        ArrayList<Agendamento> lista = this.exibirAgendamentos.getAgendamentos();

        

        return lista;

    }
    
     public Agendamento getUltimo(){
        
       
            this.exibirAgendamentos = new ExibirAgendamentos();
        
        
       
            return  exibirAgendamentos.getUltimo();
         
         
       
    }

    public void cadastrarAgendamento(int id, Timestamp data_hora, Animal animal, Servico servico)
            { 
        cadastrarAgendamento = new CadastrarAgendamento(id, data_hora, animal, servico);
    }

    public void atualizarAgendamento(int id, Timestamp data_hora, Animal animal, Servico servico) {
    
        atualizarAgendamento = new AtualizarAgendamento(id, data_hora,animal, servico);

    }

    public void excluirCliente(int id) {
   
        excluirAgendamento = new ExcluirAgendamento(id);
    }
}