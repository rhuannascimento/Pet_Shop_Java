/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.model.exceptions;

import java.sql.SQLWarning;
import javax.swing.JOptionPane;
/*
    Caio Henrique Vieira Costa - 202176020
    Rhuan Nascimento - 202176033
    Bernardo Ortiz - ?
    Lucas Duarte - 202176012
*/
/**
 *
 * @author viier
 */
public class NothingSelectedException extends Exception {

    public NothingSelectedException(SQLWarning warning) {
        super("Não foram encontrados resultados para essa consulta!");
        JOptionPane.showMessageDialog(null, "Não foram encontrados resultados para essa consulta!");
    }
    
}
