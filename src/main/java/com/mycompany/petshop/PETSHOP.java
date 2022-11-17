/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.petshop;

import com.mycompany.petshop.model.classes.Agendamento;
import com.mycompany.petshop.model.classes.Cliente;
import com.mycompany.petshop.model.classes.Animal;
import com.mycompany.petshop.model.classes.Servico;
import com.mycompany.petshop.model.classes.Agenda;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.LocalDate;

/**
 *
 * @author Rhuan
 */
public class PETSHOP {

    public static void main(String[] args) {
        Cliente cliente = new Cliente("José");

        Animal gato = new Animal("Gatinho");
        Animal cachorro = new Animal("Doguinho");
        
        Servico tosa = new Servico("Tosa", 20.00f);

        cliente.addAnimal(gato);
        cliente.addAnimal(cachorro);

        cliente.listAnimais();
        
        
        LocalDateTime hora = LocalDateTime.of(LocalDate.of(2022, 11, 20), LocalTime.of(9,30,0,0));
        Agendamento a1 = new Agendamento(hora, gato, tosa);
        LocalDateTime hora2 = LocalDateTime.of(LocalDate.of(2022, 11, 20), LocalTime.of(10,30,0,0));
        Agendamento a2 = new Agendamento(hora2, cachorro, tosa);
        
        Agenda agenda = new Agenda();
        agenda.agendar(a1);
        agenda.agendar(a2);
        
        agenda.listAgendamentos();
        
    }
}
