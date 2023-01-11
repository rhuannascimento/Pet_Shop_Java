/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.business.funcionarios;

import com.mycompany.petshop.model.exceptions.FuncionarioExp;
import com.mycompany.petshop.model.classes.Funcionario;
import com.mycompany.petshop.repository.FuncionarioRep;
import java.sql.Time;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Rhuan
 */
public class CadastrarFuncionario {
    private boolean done;
    public CadastrarFuncionario(Funcionario f, boolean isGerente) throws FuncionarioExp{
        done = false;
        if(isGerente){
            boolean confirma = (JOptionPane.showConfirmDialog(null, "Deseja mesmo cadastrar o funcionário "+f.getNome()+"?") == JOptionPane.OK_OPTION);
            if(confirma){
                FuncionarioRep fr = new FuncionarioRep();
        
                ArrayList<Funcionario> l = fr.getByUsername(f.getUsername());

                if(!l.isEmpty()){
                    throw new FuncionarioExp("Este Username esta em uso");
                }

                this.done = fr.insertOne(f);
            }
        }else{
            throw new FuncionarioExp("Você não tem permissão para isso!");
        }
    }
    
    public boolean status(){
        return this.done;
    }

    
}
