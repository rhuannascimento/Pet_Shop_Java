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
public class NothingUpdatedException extends Exception {

    public NothingUpdatedException(SQLWarning warning) {
        super("Não houveram atualizações para essa ação! Motivo: "+warning.getMessage());
    }
    
}
