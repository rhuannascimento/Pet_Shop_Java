/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.business.funcionarios;

import com.mycompany.petshop.model.classes.Funcionario;
import com.mycompany.petshop.repository.FuncionarioRep;
import java.sql.Time;
import java.util.ArrayList;

/**
 *
 * @author Rhuan
 */
public class AtualizarFuncionario {

    public AtualizarFuncionario(int id, String nome, Time startTime, Time endTime, String cargo, String username, String password) {
        
        Funcionario f = new Funcionario(id, nome, startTime, endTime, cargo, username, password);
        
        FuncionarioRep fr = new FuncionarioRep();
        
        fr.update(f);
    }
    
    
    
    
}