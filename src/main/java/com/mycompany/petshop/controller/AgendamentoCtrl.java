package com.mycompany.petshop.controller;

import com.mycompany.petshop.business.agendamento.*;
import com.mycompany.petshop.model.classes.Agenda;
import com.mycompany.petshop.model.classes.Agendamento;
import com.mycompany.petshop.model.classes.Animal;
import com.mycompany.petshop.model.classes.Servico;
import com.mycompany.petshop.model.exceptions.AgendamentoExp;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/*
    Caio Henrique Vieira Costa - 202176020
    Rhuan Nascimento - 202176033
    Bernardo Ortiz - ?
    Lucas Duarte - 202176012
*/
public class AgendamentoCtrl {

    private ExibirAgendamentos exibirAgendamentos;
    private ListarAgendamentoPorData listarPorData;
    private BuscarAgendamentoPorId listarPorId;
    private CadastrarAgendamento cadastrarAgendamento;
    private ExcluirAgendamento excluirAgendamento;
    private AtualizarAgendamento atualizarAgendamento;

    public ArrayList<Agendamento> exibirAgendamentos() {
        this.exibirAgendamentos = new ExibirAgendamentos();

        ArrayList<Agendamento> lista = this.exibirAgendamentos.getAgendamentos();

        return lista;
    }
    
   public ArrayList<Agendamento> exibirAgendamentos(String data) {
        ArrayList<Agendamento> lista;
        if(!data.equalsIgnoreCase("todos")){
            this.listarPorData = new ListarAgendamentoPorData(data);

            lista = this.listarPorData.getAgendamentos();
            
        }else{
            lista = this.exibirAgendamentos();
            
        }

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

    public void excluir(int id) {
        boolean confirma = JOptionPane.showConfirmDialog(null, "Deseja mesmo excluir o agendamento "+id+"?") == JOptionPane.OK_OPTION;
        if(confirma)
            excluirAgendamento = new ExcluirAgendamento(id);
    }
    
    public Agendamento exibirAgendamentoById(int id){
        listarPorId = new BuscarAgendamentoPorId(id);
        return listarPorId.getAgendamento();
    }
}