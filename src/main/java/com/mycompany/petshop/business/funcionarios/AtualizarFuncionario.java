/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.business.funcionarios;

import com.mycompany.petshop.model.classes.Funcionario;
import com.mycompany.petshop.model.exceptions.FuncionarioExp;
import com.mycompany.petshop.repository.FuncionarioRep;
import java.sql.Time;
import java.util.ArrayList;
import javax.swing.JOptionPane;
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
public class AtualizarFuncionario {
    private boolean done;

    public AtualizarFuncionario(Funcionario f, boolean isGerente) throws FuncionarioExp {
        done = false;
        if (isGerente) {
            boolean confirma = (JOptionPane.showConfirmDialog(null,
                    "Editar funcionário " + f.getNome() + "?") == JOptionPane.OK_OPTION);
            if (confirma) {
                done = false;
                FuncionarioRep fr = new FuncionarioRep();

                done = fr.update(f);
            }
        }else{
            throw new FuncionarioExp("Você não tem permissão para isso!");
        }

    }

    public boolean status() {
        return this.done;
    }

}
