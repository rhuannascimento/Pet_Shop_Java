/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.business.agendamento;
/*
    Caio Henrique Vieira Costa - 202176020
    Rhuan Nascimento - 202176033
    Bernardo Ortiz - ?
    Lucas Duarte - 202176012
*/
import com.mycompany.petshop.model.classes.Agendamento;
import com.mycompany.petshop.repository.AgendamentoRep;

/**
 *
 * @author beort
 */
public class ExcluirAgendamento {
    public ExcluirAgendamento(int id){
        AgendamentoRep ar = new AgendamentoRep();
        ar.deleteById(id);
    }
}