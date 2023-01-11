/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.business.funcionarios;

import com.mycompany.petshop.model.classes.Funcionario;
import com.mycompany.petshop.model.exceptions.FuncionarioExp;
import com.mycompany.petshop.repository.FuncionarioRep;
import java.util.ArrayList;

/**
 *
 * @author Rhuan
 */
public class BuscarFuncionario {

    Funcionario f;
    
    public BuscarFuncionario(String username) throws FuncionarioExp{
    
        FuncionarioRep fr = new FuncionarioRep();
        
        ArrayList<Funcionario> l = new ArrayList(); 
        
        l = fr.getByUsername(username);
        
        if(!l.isEmpty()){
            for (int i = 0; i < l.size(); i++) {
                if(l.get(i).getUsername().equals(username)){
                    this.f = l.get(i);
                }
            }
        }else{
            throw new FuncionarioExp("Funcionario com esse username não existe!");
        }
    
    }

    public Funcionario getFuncionario() {
        return f;
    }
    
}
