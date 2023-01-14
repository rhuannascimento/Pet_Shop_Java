package com.mycompany.petshop.business.agendamento;

import com.mycompany.petshop.model.classes.Animal;
import com.mycompany.petshop.model.classes.Servico;
import com.mycompany.petshop.model.classes.Agendamento;
/*
    Caio Henrique Vieira Costa - 202176020
    Rhuan Nascimento - 202176033
    Bernardo Ortiz - ?
    Lucas Duarte - 202176012
*/
import com.mycompany.petshop.repository.AgendamentoRep;
import java.sql.Timestamp;


public class CadastrarAgendamento {
    public CadastrarAgendamento(int id, Timestamp data_hora, Animal animal, Servico servico) {
       
        Agendamento a = new Agendamento(id,data_hora,animal,servico);
        AgendamentoRep ar = new AgendamentoRep();
        
        ar.insertOne(a);
     
        
    }
    
    
}
