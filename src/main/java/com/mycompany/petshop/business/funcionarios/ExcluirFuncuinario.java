/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.business.funcionarios;

import com.mycompany.petshop.model.classes.Funcionario;
import com.mycompany.petshop.repository.FuncionarioRep;

/**
 *
 * @author Rhuan
 */
public class ExcluirFuncuinario {

    public ExcluirFuncuinario(Funcionario f) {
    
        FuncionarioRep fr = new FuncionarioRep();
        
        fr.delete(f);
    }
    
    
    
}
