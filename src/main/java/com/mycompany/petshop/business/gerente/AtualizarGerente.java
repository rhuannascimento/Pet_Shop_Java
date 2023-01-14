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
/*
    Caio Henrique Vieira Costa - 202176020
    Rhuan Nascimento - 202176033
    Bernardo Ortiz - ?
    Lucas Duarte - 202176012
*/
/**
 *
 * @author Rhuan
 */
public class AtualizarGerente {

    public AtualizarGerente(Funcionario atualizar, String username) throws GerenteExp, FuncionarioExp{
    
        Funcionario logado = new BuscarFuncionario(username).getFuncionario();
        
        if(logado.getCargo().equalsIgnoreCase("Gerente")){
        
        FuncionarioRep fr = new FuncionarioRep();
        
        fr.update(atualizar);
        
        }else{
            throw new GerenteExp("Ação não permitida para este cargo!");
        }
    
    }
    
    
    
}
