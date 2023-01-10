/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.petshop;

import com.mycompany.petshop.model.classes.*;
import com.mycompany.petshop.repository.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rhuan
 */
public class PETSHOP {

    public static void main(String[] args) {
        Migrator m = new Migrator();
        Seeder s = new Seeder();
        
        if(args.length == 2){
            m.migrate();
            s.seed();
        }else if(args.length == 1){
            if(args[0].equalsIgnoreCase("migrate")) m.migrate();
            if(args[0].equalsIgnoreCase("seed")) s.seed();
        }else{
            // SEGUE ABAIXO EXEMPLO DE COMO USAR O REPOSITORY
            // Repository Funcionario
            FuncionarioRep rep = new FuncionarioRep();

            // lista funcionários
            ArrayList<Funcionario> funcionarios = listarFuncionarios();

            // atualiza primeiro funcionário da lista
            Funcionario toUpdate = funcionarios.get(0);
            toUpdate.setNome("Teste testado");
            rep.update(toUpdate);

            // insere funcionário novo
            rep.insertOne(new Funcionario(0, "Novo funcionario tal", Time.valueOf("08:00:00"), Time.valueOf("12:00:00"), "funcionario", "user.name", "senhacaio"));

            // lista dnv
            funcionarios = listarFuncionarios();

            // deleta o funcionário de id 1, e tbm o 3° funcionário da lista
            Funcionario toDelete = funcionarios.get(2);
            rep.deleteById(1);
            rep.delete(toDelete);
            
            
            funcionarios = listarFuncionarios();
            ArrayList<Funcionario> lista = rep.getByUsername("caio.costaa");

            if(lista.size() == 0) System.out.println("Não existe funcionário com esse username!");
            else System.out.println("Existe funcionário com esse username!");

            
            
            // Repository Cliente
            ClienteRep cr = new ClienteRep();
            
            ArrayList<Cliente> clientes = listarClientes();
            
            Cliente c = clientes.get(0);
            c.setNome("Claudim buxexa");
            cr.update(c);
            
            Animal a = new Animal(0, "Cachorro do claudim", c.getCpf(), "Cachorro");
            
            cr.insertOne(a);
            
            
            
            cr.deleteById(2);
            
            clientes = listarClientes();
            
            //Repository Itens
            ArrayList<Item> itens = listarItens();

            Item a2 = itens.get(0);
            Servico s2 = null;
            if(a2.getTipo().equalsIgnoreCase("servico")) s2 = (Servico) a2;
            s2.setDuracao(90);// minutos

            ItemRep ir = new ItemRep();

            ir.update(s2);

            ir.delete(itens.get(5));

            System.out.println(ir.getById(1));

            System.out.println(ir.getByNome("roup"));

        }
        
        
        
    }
    
    static ArrayList<Funcionario> listarFuncionarios(){
        FuncionarioRep rep = new FuncionarioRep();
        ArrayList<Funcionario> funcionarios = rep.getAll();
        for(Funcionario f: funcionarios) System.out.println(f);
        System.out.println("\n\n");
        return funcionarios;
    }
    
    static ArrayList<Item> listarItens(){
        ItemRep rep = new ItemRep();
        ArrayList<Item> itens = rep.getAll();
        for(Item f: itens) System.out.println(f);
        System.out.println("\n\n");
        return itens;
    }
    
    static ArrayList<Cliente> listarClientes(){
        ClienteRep cr = new ClienteRep();
        ArrayList<Cliente> clientes = cr.getAll();
        for(Cliente f: clientes) System.out.println(f);
        System.out.println("\n\n");
        return clientes;
    }
}
