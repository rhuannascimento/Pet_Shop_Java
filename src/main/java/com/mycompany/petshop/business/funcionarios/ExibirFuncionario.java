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
public class ExibirFuncionario {

    private ArrayList<Funcionario> f = new ArrayList();
    
    
    public ExibirFuncionario() {
        
        FuncionarioRep fr = new FuncionarioRep(); 
        
        this.f = fr.getAll();
        
    }

    public ArrayList<Funcionario> getF() {
        return f;
    }
          
    
}
