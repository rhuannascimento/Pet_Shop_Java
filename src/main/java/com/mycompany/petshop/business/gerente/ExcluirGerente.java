/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.business.gerente;

import com.mycompany.petshop.model.classes.Funcionario;
import com.mycompany.petshop.model.exceptions.GerenteExp;
import com.mycompany.petshop.repository.FuncionarioRep;

/**
 *
 * @author Rhuan
 */
public class ExcluirGerente {

    public ExcluirGerente(Funcionario logado, Funcionario excluir) throws GerenteExp{
    
        if(logado.getCargo().equalsIgnoreCase("Gerente")){
            FuncionarioRep fr = new FuncionarioRep();
            fr.delete(excluir);
        }else{
            throw new GerenteExp("Ação não permitida para este cargo!");
        }
        
    }
}
