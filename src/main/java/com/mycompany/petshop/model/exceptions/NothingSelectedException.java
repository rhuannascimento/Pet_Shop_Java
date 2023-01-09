/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.model.exceptions;

import java.sql.SQLWarning;

/**
 *
 * @author viier
 */
public class NothingSelectedException extends Exception {

    public NothingSelectedException(SQLWarning warning) {
        super("Não foram encontrados resultados para essa consulta! Motivo: "+warning.getMessage());
    }
    
}
