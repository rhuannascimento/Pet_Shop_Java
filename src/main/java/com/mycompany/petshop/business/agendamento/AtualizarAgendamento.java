/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.business.agendamento;
import com.mycompany.petshop.model.classes.Animal;
import com.mycompany.petshop.model.classes.Servico;
import com.mycompany.petshop.model.classes.Agendamento;
import com.mycompany.petshop.repository.AgendamentoRep;
import java.sql.Timestamp;
import java.util.ArrayList;

public class AtualizarAgendamento {
    public AtualizarAgendamento(int id, Timestamp data_hora, Animal animal, Servico servico){


        Agendamento a;
        AgendamentoRep ar = new AgendamentoRep();
        a = new Agendamento(id,data_hora,animal,servico);
        
        
            ar.update(a);
        
        
    }
    
    
}
