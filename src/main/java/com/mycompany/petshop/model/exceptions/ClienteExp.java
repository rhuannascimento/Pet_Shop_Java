/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.model.exceptions;

import javax.swing.JOptionPane;

/**
 *
 * @author beort
 */
public class ClienteExp extends Exception{
       public ClienteExp(String message) {
        super(message);
        JOptionPane.showMessageDialog(null, message, "Erro de pesquisa", JOptionPane.WARNING_MESSAGE);
    }
}
