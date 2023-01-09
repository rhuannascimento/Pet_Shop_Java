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
public class Seeder {
    private SqlRunner db;
    private Connection connection;
    public void seed(){
        this.db = new SqlRunner();
        this.connection = MyConnector.connect();
       
        populateCliente();
        populateFuncionario();
        populateItem();
        closeConnection();
    }

    private void closeConnection() {
        try {
            if(connection != null) connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
            
        }
    }
    
    private void populateCliente(){
        String sql = "INSERT INTO cliente (nome, cpf, especie, email, telefone) VALUES ('João da Silva', '123.456.789-00', '', 'joao@email.com', '11 1234-5678'), ('Maria da Silva', '987.654.321-00', '', 'maria@email.com', '11 5678-1234'), ('cachorro da maria', '987.654.321-00', 'cachorro', '', ''), ('gato da maria', '987.654.321-00', 'gato', '', '');";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            
            int result = db.runUpdateQuery(statement);
            
            if(result > 0) System.out.println(result + " valores inseridos dados na tabela cliente.");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    private void populateFuncionario(){
        String sql = "INSERT INTO funcionario (nome, horario_inicio, horario_fim, cargo, senha) VALUES ('João da Silva', '39600000', '75600000', 'Gerente', 'minhasenha123'), ('Maria da Silva', '39600000', '75600000', 'Atendente', 'suasenha123');";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            
            int result = db.runUpdateQuery(statement);
            
            if(result > 0) System.out.println(result + " valores inseridos dados na tabela funcionario.");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    private void populateItem(){
        String sql = "INSERT INTO item(nome,preco,tipo,disponivel,duracao,funcionario_id,estoque,categoria,fornecedor,utilidade,orientacao,especie,cor,tamanho,material,sabor,idade_recomendada)VALUES('Serviço1',10.50,'Serviço',1,30,1,10,'Categoria1','Fornecedor1','','','','','','','',null),('Remédio1',20.00,'Remédio',1,null,1,10,'Categoria2','Fornecedor2','dor','Vendalivre','','','','','',null),('Brinquedo',30.00,'Produto',1,null,1,10,'Categoria3','Fornecedor3','','','Cachorro','','','Borracha','',null),('Roupa1',40.00,'Produto',1,null,1,10,'Categoria4','Fornecedor4','','','Gato','Vermelho','P','','',null),('Ração1',50.00,'Produto',1,null,1,10,'Categoria5','Fornecedor5','','','','','','','peixe',2),('Petisco1',60.00,'Produto',1,null,1,10,'Categoria6','Fornecedor6','','','','','','','carne',2);";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            
            int result = db.runUpdateQuery(statement);
            
            if(result > 0) System.out.println(result + " valores inseridos dados na tabela item.");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }    
    }
    
}