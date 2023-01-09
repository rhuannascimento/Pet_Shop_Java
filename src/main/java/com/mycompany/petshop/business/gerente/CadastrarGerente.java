/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.business.gerente;

import com.mycompany.petshop.model.classes.Funcionario;
import com.mycompany.petshop.model.exceptions.GerenteExp;
import com.mycompany.petshop.repository.FuncionarioRep;
import java.sql.Time;
import java.util.ArrayList;

/**
 *
 * @author Rhuan
 */
public class CadastrarGerente {

    public CadastrarGerente(int id, String nome, String startTime, String endTime, String cargo, String username, String password, String Cargo,Funcionario logado) throws GerenteExp {
    
        if(logado.getCargo().equalsIgnoreCase("Gerente")){
            
            Funcionario f = new Funcionario(id,nome, Time.valueOf(startTime), Time.valueOf(endTime), cargo, username, password);
        
            FuncionarioRep fr = new FuncionarioRep();
        
            ArrayList<Funcionario> l = fr.getByUsername(f.getUsername());
            
            if(!l.isEmpty()){
                throw new GerenteExp("Este Username esta em uso");
            }
            
            fr.insertOne(f);
          
        }else{
            throw new GerenteExp("Ação não permitida para este cargo!");
        }
        
        
    }
    
    
    
}
