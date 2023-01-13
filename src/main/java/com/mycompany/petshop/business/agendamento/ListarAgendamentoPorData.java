/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.business.agendamento;

import com.mycompany.petshop.model.classes.Agendamento;
import com.mycompany.petshop.repository.AgendamentoRep;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author viier
 */
public class ListarAgendamentoPorData {
    private ArrayList<Agendamento> agendamentos = new ArrayList();

    public ListarAgendamentoPorData(String data) {
        
        Date date = new Date(0, 0, 0);    
        
        if(data.equalsIgnoreCase("hoje")) {
            LocalDate today = LocalDate.now();
            date.setDate(today.getDayOfMonth());
            date.setMonth(today.getMonthValue());
            date.setYear(today.getYear());
        }else if(data.equalsIgnoreCase("amanha")){
            LocalDate today = LocalDate.now().plusDays(1);
            date.setDate(today.getDayOfMonth());
            date.setMonth(today.getMonthValue());
            date.setYear(today.getYear());
        }

        AgendamentoRep ar = new AgendamentoRep();

        this.agendamentos = ar.getByDate(date);

    }

    public ArrayList<Agendamento> getAgendamentos() {
        return agendamentos;
    }
}
