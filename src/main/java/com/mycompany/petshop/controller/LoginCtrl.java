/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.controller;

import com.mycompany.petshop.business.funcionarios.RealizarLogin;
import com.mycompany.petshop.model.classes.Funcionario;
import javax.swing.JOptionPane;

/**
 *
 * @author Rhuan
 *//*
    Caio Henrique Vieira Costa - 202176020
    Rhuan Nascimento - 202176033
    Bernardo Ortiz - ?
    Lucas Duarte - 202176012
*/
public class LoginCtrl {

    public LoginCtrl() {
                     
    
    }
    
    
    public Funcionario fazerLogin(String username, String senha){
        
        RealizarLogin rl = new RealizarLogin(username, senha);
        System.out.println(username + " - " + senha);
        try{
            return rl.logar();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return null;        
    }
       
       
}
