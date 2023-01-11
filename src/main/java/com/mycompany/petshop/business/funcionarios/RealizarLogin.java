/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.business.funcionarios;

import com.mycompany.petshop.model.classes.Funcionario;
import com.mycompany.petshop.model.exceptions.FuncionarioExp;
import com.mycompany.petshop.repository.FuncionarioRep;

/**
 *
 * @author Rhuan
 */
public class RealizarLogin {

    private String user;
    private String senha;
    
    public RealizarLogin(String user, String senha) {
        
        this.user = user;
        this.senha = senha;
        
    }
    
    public String logar() throws FuncionarioExp{
        
        FuncionarioRep fr = new FuncionarioRep();
        
        if(!fr.login(this.user, this.senha)){
         
            throw new FuncionarioExp("Algo deu errado no login!");
            
        }
        
        BuscarFuncionario bf = new BuscarFuncionario(this.user);
        
        Funcionario f = bf.getFuncionario();
        
        return f.getCargo();
    }
          
}