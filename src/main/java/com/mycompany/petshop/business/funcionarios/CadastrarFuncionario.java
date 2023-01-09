/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.business.funcionarios;

import com.mycompany.petshop.model.classes.Funcionario;
import com.mycompany.petshop.repository.FuncionarioRep;
import java.util.ArrayList;

/**
 *
 * @author Rhuan
 */
public class CadastrarFuncionario {
    
    public CadastrarFuncionario(Funcionario f) throws FuncionarioExp{
    
        FuncionarioRep fr = new FuncionarioRep();
        
        ArrayList<Funcionario> l = fr.getByNome(f.getNome());
        ArrayList<Funcionario> l2 = fr.getByUsername(f.getNome());
        
        if(l.size() == 1){
            if(l.get(0).getNome().equalsIgnoreCase(f.getNome())){
                throw new FuncionarioExp("Funcionario com este nome já existe!");
            }
        }
        
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
