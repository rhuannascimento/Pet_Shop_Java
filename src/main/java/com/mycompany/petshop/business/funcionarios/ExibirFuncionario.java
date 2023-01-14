/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.business.funcionarios;

import com.mycompany.petshop.model.classes.Funcionario;
import com.mycompany.petshop.model.exceptions.FuncionarioExp;
import com.mycompany.petshop.repository.FuncionarioRep;
import java.util.ArrayList;
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
public class ExibirFuncionario {

    private ArrayList<Funcionario> funcionarios = new ArrayList();
    
    
    public ExibirFuncionario() {
        
        FuncionarioRep fr = new FuncionarioRep(); 
        
        this.funcionarios = fr.getAll();
        
    }
    
    public Funcionario getUltimo() throws FuncionarioExp{
        
       
       if(this.funcionarios.size() > 0){
           
           return funcionarios.get(funcionarios.size()-1);
           
       }else{
           throw new FuncionarioExp("Não há funcionarios cadastrados!");
       }
              
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }
    
    
    public Funcionario porId(int id){
        FuncionarioRep fr = new FuncionarioRep(); 
        return fr.getById(id);
    }      
    
}
