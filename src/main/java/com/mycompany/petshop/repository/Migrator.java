/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author viier
 */
public class Migrator {
    private SqlRunner db;
    private Connection connection;
    public void migrate(){
        this.db = new SqlRunner();
        this.connection = MyConnector.connect();
       
        createCliente();
    }
    
    private void createCliente(){
        String sql = "CREATE TABLE IF NOT EXISTS cliente (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT NOT NULL, cpf TEXT NOT NULL, tipo TEXT NOT NULL, especie TEXT, email TEXT, telefone TEXT);";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            
            db.runUpdateQuery(statement);
            
            System.out.println("Tabela Cliente Criada.");
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
    }
}
