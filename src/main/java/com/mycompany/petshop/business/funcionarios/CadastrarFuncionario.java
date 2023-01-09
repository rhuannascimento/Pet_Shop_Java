/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.business.funcionarios;

import com.mycompany.petshop.model.exceptions.FuncionarioExp;
import com.mycompany.petshop.model.classes.Funcionario;
import com.mycompany.petshop.repository.FuncionarioRep;
import java.sql.Time;
import java.util.ArrayList;

/**
 *
 * @author Rhuan
 */
public class CadastrarFuncionario {
    
    public CadastrarFuncionario(int id, String nome, Time startTime, Time endTime, String cargo, String username, String password) throws FuncionarioExp{
    
        Funcionario f = new Funcionario(id,nome, startTime, endTime, cargo, username, password);
        
        FuncionarioRep fr = new FuncionarioRep();
        
        ArrayList<Funcionario> l2 = fr.getByUsername(f.getNome());
        
        if(l2.size() >= 1){
            
            for (int i = 0; i < l2.size(); i++) {
                if(l2.get(i).getNome().equalsIgnoreCase(f.getNome())){
                    throw new FuncionarioExp("Funcionario com este nome já existe!");
                }
            }
            
        }
            
        fr.insertOne(f);
        
    
    }

    
}
