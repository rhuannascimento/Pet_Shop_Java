/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.business.funcionarios;

import com.mycompany.petshop.model.classes.Funcionario;
import com.mycompany.petshop.repository.FuncionarioRep;
import java.sql.Time;
import javax.swing.JOptionPane;

/**
 *
 * @author Rhuan
 */
public class ExcluirFuncionario {
    private boolean done;
    public ExcluirFuncionario(int id, boolean isGerente) {
        done = false;
        if(isGerente){
            boolean confirma = (JOptionPane.showConfirmDialog(null, "Deseja mesmo excluir o funcionário "+id+"?") == JOptionPane.OK_OPTION);
            if(confirma){
                done = false;
                FuncionarioRep fr = new FuncionarioRep();
        
                done = fr.deleteById(id);
            }
        }
    }
    
    public boolean status(){
        return this.done;
    }
    
    
    
}
