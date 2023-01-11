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

        // String col[] = { "ID", "Nome", "cpf", "especie" };

        // DefaultTableModel dtm = new DefaultTableModel(col, 0);

        // try {
        // ArrayList<Cliente> lista = this.exibirAnimal.getAnimais();

        // for (Cliente c : lista) {
        // Object[] data = { c.getId(), c.getNome(), c.getCpf(),
        // ((Animal)c).getEspecie() };
        // dtm.addRow(data);
        // }

        // } catch (Exception ex) {
        // ex.printStackTrace();
        // }

        return lista;

    }

    public void cadastrarAgendamento(int id, Timestamp data_hora, Animal animal, Servico servico)
            throws AgendamentoExp { 
        cadastrarAgendamento = new CadastrarAgendamento(id, data_hora, animal, servico);
    }

    public void atualizarAgendamento(int id, Timestamp data_hora, Animal animal, Servico servico) {
    
        atualizarAgendamento = new AtualizarAgendamento(id, data_hora,animal, servico);

    }

    public void excluirCliente(int id) {
   
        excluirAgendamento = new ExcluirAgendamento(id);
    }
}
