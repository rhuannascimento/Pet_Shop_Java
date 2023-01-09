/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.repository;

import com.mycompany.petshop.model.classes.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author viier
 */
public class Seeder {
    private Connection connection;
    public void seed(){
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
            
            int result = statement.executeUpdate();
            
            if(result > 0) System.out.println(result + " valores inseridos dados na tabela cliente.");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    private void populateFuncionario(){
        Funcionario f1 = new Funcionario(0, "Caio Vieira", Time.valueOf("08:00:00"), Time.valueOf("16:00:00"), "gerente", "caio.costa", "senhacaio");
        Funcionario f2 = new Funcionario(0, "Rhuan Nascimento", Time.valueOf("10:00:00"), Time.valueOf("18:00:00"), "funcionario", "rhuan.nascimento", "senharhuan");
        Funcionario f3 = new Funcionario(0, "Bernardo Ortiz", Time.valueOf("09:00:00"), Time.valueOf("17:00:00"), "funcionario", "bernardo.ortiz", "senhabernardo");
        Funcionario f4 = new Funcionario(0, "Lucas Duarte", Time.valueOf("11:00:00"), Time.valueOf("19:00:00"), "funcionario", "lucas.duarte", "senhalucas");
        
        FuncionarioRep rp = new FuncionarioRep();
        boolean n1 = rp.insertOne(f1);
        boolean n2 = rp.insertOne(f2);
        boolean n3 = rp.insertOne(f3);
        boolean n4 = rp.insertOne(f4);
        
        if(n1) System.out.println("Funcionario Caio cadastrado");
        if(n2) System.out.println("Funcionario Rhuan cadastrado");
        if(n3) System.out.println("Funcionario Bernardo cadastrado");
        if(n4) System.out.println("Funcionario Lucas cadastrado");
        
    }

    private void populateItem(){
        String sql = "INSERT INTO item(nome,preco,tipo,disponivel,duracao,funcionario_id,estoque,categoria,fornecedor,utilidade,orientacao,especie,cor,tamanho,material,sabor,idade_recomendada)VALUES('Serviço1',10.50,'Serviço',1,30,1,10,'Categoria1','Fornecedor1','','','','','','','',null),('Remédio1',20.00,'Remédio',1,null,1,10,'Categoria2','Fornecedor2','dor','Vendalivre','','','','','',null),('Brinquedo',30.00,'Produto',1,null,1,10,'Categoria3','Fornecedor3','','','Cachorro','','','Borracha','',null),('Roupa1',40.00,'Produto',1,null,1,10,'Categoria4','Fornecedor4','','','Gato','Vermelho','P','','',null),('Ração1',50.00,'Produto',1,null,1,10,'Categoria5','Fornecedor5','','','','','','','peixe',2),('Petisco1',60.00,'Produto',1,null,1,10,'Categoria6','Fornecedor6','','','','','','','carne',2);";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            
            int result = statement.executeUpdate();
            
            if(result > 0) System.out.println(result + " valores inseridos dados na tabela item.");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }    
    }
    
}