package com.mycompany.petshop.business.agendamento;

import com.mycompany.petshop.model.classes.Animal;
import com.mycompany.petshop.model.classes.Servico;
import com.mycompany.petshop.model.classes.Agendamento;
import com.mycompany.petshop.model.classes.Agenda;
import com.mycompany.petshop.repository.AgendamentoRep;
import java.sql.Timestamp;
import java.util.ArrayList;

public class CadastrarAgendamento {
    public CadastrarAgendamento(int id, Timestamp data_hora, Animal animal, Servico servico){
        ArrayList<Agendamento> lista1 = new ArrayList<Agendamento>();
         ArrayList<Agendamento> lista2 = new ArrayList<Agendamento>();
        Agendamento a;
        AgendamentoRep ar = new AgendamentoRep();
        a = new Agendamento(id,data_hora,animal,servico);
        lista1 = ar.getByDate(data_hora);
        lista2 = ar.getByTimestamp(data_hora);
        if(!lista1.isEmpty() && !lista2.isEmpty()){
            System.out.println("Horário já reservado");
        }else{
            ar.insertOne(a);
        }
        
    }
    
    
}
