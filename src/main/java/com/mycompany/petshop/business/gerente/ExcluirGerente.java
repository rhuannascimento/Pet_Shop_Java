/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.business.gerente;

import com.mycompany.petshop.business.funcionarios.BuscarFuncionario;
import com.mycompany.petshop.model.classes.Funcionario;
import com.mycompany.petshop.model.exceptions.FuncionarioExp;
import com.mycompany.petshop.model.exceptions.GerenteExp;
import com.mycompany.petshop.repository.FuncionarioRep;

/**
 *
 * @author Rhuan
 */
public class ExcluirGerente {

    public ExcluirGerente(String username, int id) throws GerenteExp, FuncionarioExp{
    
        Funcionario logado = new BuscarFuncionario(username).getFuncionario();
        
        if(logado.getCargo().equalsIgnoreCase("Gerente")){
            FuncionarioRep fr = new FuncionarioRep();
            fr.deleteById(id);
        }else{
            throw new GerenteExp("Ação não permitida para este cargo!");
        }
        
    }
}
