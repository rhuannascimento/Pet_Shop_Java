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
    private Connection connection;
    public void migrate(){
        this.connection = MyConnector.connect();
       
        createCliente();
        createItem();
        createFuncionario();
        closeConnection();
    }

    private void closeConnection() {
        try {
            if(connection != null) connection.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
    
    private void createCliente(){
        String sql = "CREATE TABLE IF NOT EXISTS cliente (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT NOT NULL, cpf TEXT NOT NULL, especie TEXT, email TEXT, telefone TEXT);";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            
            int result = statement.executeUpdate();
            
            if(result == 0) System.out.println("Tabela Cliente Criada.");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    
    private void createItem(){
        String sql = "CREATE TABLE IF NOT EXISTS item ( id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT NOT NULL, preco REAL NOT NULL, tipo TEXT NOT NULL, disponivel INTEGER NOT NULL, duracao INTEGER, funcionario_id INTEGER, estoque INTEGER, categoria TEXT, fornecedor TEXT, utilidade TEXT, orientacao TEXT, especie TEXT, cor TEXT, tamanho TEXT, material TEXT, sabor TEXT, idade_recomendada INTEGER);";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            
            int result = statement.executeUpdate();
            
            if(result == 0) System.out.println("Tabela Item Criada.");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    private void createFuncionario(){
        String sql = "CREATE TABLE IF NOT EXISTS funcionario (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT NOT NULL, horario_inicio TIME NOT NULL, horario_fim TIME NOT NULL, cargo TEXT NOT NULL, usuario TEXT NOT NULL, senha TEXT NOT NULL);";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            
            int result = statement.executeUpdate();
            
            if(result == 0) System.out.println("Tabela Funcionario Criada.");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
}
