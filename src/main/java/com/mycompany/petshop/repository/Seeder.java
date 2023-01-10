/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.repository;

import com.mycompany.petshop.model.classes.*;
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
        Cliente c1 = new Pessoa(0, "José dos Campos", "'16112124645", "jose@campos.com", "31984685434");
        Cliente c2 = new Pessoa(0, "João Pessoa", "34572424532", "joao@pessoa.com", "31987233259");
        Cliente c3 = new Animal(0, "Aswolfo", "16112124645", "cachorro");
        Cliente c4 = new Animal(0, "Waldineliau", "16112124645", "gato");
        
        ClienteRep cr = new ClienteRep();
        
        boolean n1 = cr.insertOne(c1);
        boolean n2 = cr.insertOne(c2);
        boolean n3 = cr.insertOne(c3);
        boolean n4 = cr.insertOne(c4);
        
        if(n1) System.out.println("Cliente José cadastrado");
        if(n2) System.out.println("Cliente João cadastrado");
        if(n3) System.out.println("Cliente Aswolfo cadastrado");
        if(n4) System.out.println("Cliente Waldineliau cadastrado");
        
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
        Item i1 = new Servico(0, "Banho e Tosa", 20f, "Servico", true, 30, 2);
        Item i6 = new Servico(0, "Cortar unhas", 10f, "Servico", true, 15, 2);
        Item i11 = new Servico(0, "Castrar", 250f, "Servico", true, 360, 1);

        Item i2 = new Brinquedo(10, "Brinquedos & Cia", 0, "Ossinho", 10.0f, "brinquedo", true, "Cachorro", "Fibra");
        Item i7 = new Brinquedo(5, "Brinquedos & Cia", 0, "Pneu", 12.5f, "brinquedo", true, "Cachorro", "Borracha");
        Item i12 = new Brinquedo(7, "Brinquedos & Cia", 0, "Bola com pena", 15.75f, "brinquedo", true, "Gato", "Plástico");

        Item i3 = new Racao(41, "Pedigree", 0, "Ração premium", 25f, "racao", true, "Cachorro", "Chinelo", 2);
        Item i8 = new Racao(26, "Pedigree", 0, "Ração special", 30f, "racao", true, "Cachorro", "Plastico", 3);
        Item i13 = new Racao(64, "Whiskas", 0, "Peixinhos recheados", 32f, "racao", true, "Gato", "Peixes ao molho rosê", 1);

        Item i4 = new Remedio(36, "Farmacia dois irmãos", 0, "Dipirona", 4f, "remedio", true, "dor", "8 em 8 hrs");
        Item i9 = new Remedio(34, "Farmacia dois irmãos", 0, "Ibuprofeno", 5f, "remedio", true, "Infecção", "12 em 12 hrs");
        Item i14 = new Remedio(12, "Farmacia dois irmãos", 0, "Colírio", 6f, "remedio", true, "lubrificar olhos", "Conforme prescrição");

        Item i5 = new Roupa(4, "Hering", 0, "Roupinha 1", 100f, "roupa", true, "p", "cachorro", "amarelo");
        Item i10 = new Roupa(3, "Hering", 0, "Roupinha 2", 120f, "roupa", true, "pp", "gato", "azul");
        Item i15 = new Roupa(5, "Hering", 0, "Roupinha 3", 80f, "roupa", true, "m", "cachorro", "verde");
        
        ItemRep ir = new ItemRep();
        
        boolean n1 = ir.insertOne(i1);
        boolean n2 = ir.insertOne(i2);
        boolean n3 = ir.insertOne(i3);
        boolean n4 = ir.insertOne(i4);
        boolean n5 = ir.insertOne(i5);

        boolean n6 = ir.insertOne(i6);
        boolean n7 = ir.insertOne(i7);
        boolean n8 = ir.insertOne(i8);
        boolean n9 = ir.insertOne(i9);
        boolean n10 = ir.insertOne(i10);

        boolean n11 = ir.insertOne(i11);
        boolean n12 = ir.insertOne(i12);
        boolean n13 = ir.insertOne(i13);
        boolean n14 = ir.insertOne(i14);
        boolean n15 = ir.insertOne(i15);

        if(n1) System.out.println("Inserindo "+i1);
        if(n2) System.out.println("Inserindo "+i2);
        if(n3) System.out.println("Inserindo "+i3);
        if(n4) System.out.println("Inserindo "+i4);
        if(n5) System.out.println("Inserindo "+i5);
        if(n6) System.out.println("Inserindo "+i6);
        if(n7) System.out.println("Inserindo "+i7);
        if(n8) System.out.println("Inserindo "+i8);
        if(n9) System.out.println("Inserindo "+i9);
        if(n10) System.out.println("Inserindo "+i10);
        if(n11) System.out.println("Inserindo "+i11);
        if(n12) System.out.println("Inserindo "+i12);
        if(n13) System.out.println("Inserindo "+i13);
        if(n14) System.out.println("Inserindo "+i14);
        if(n15) System.out.println("Inserindo "+i15);
        
    }
    
}