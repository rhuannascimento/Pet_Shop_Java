/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.repository;

import com.mycompany.petshop.model.classes.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author viier
 */
public class ClienteRep implements DataAcessObject<Cliente> {

    @Override
    public boolean insertOne(Cliente valor) {
        System.out.println("Inserindo o cliente "+valor);
        PreparedStatement ps = null;
        Connection con = null;
        int affected = 0;
        try{
            con = MyConnector.connect();
            
            String sql = "INSERT INTO cliente(nome, cpf, especie, email, telefone) VALUES (?,?,?,?,?)";
            
            ps = con.prepareStatement(sql);
            
            if(valor instanceof Animal){
                Animal a1 = (Animal) valor;
                
                ps.setString(1, a1.getNome());
                ps.setString(2, a1.getCpf());
                ps.setString(3, a1.getEspecie());
                ps.setString(4, null);
                ps.setString(5, null);
                
            }else{
                Pessoa p1 = (Pessoa) valor;
                
                ps.setString(1, p1.getNome());
                ps.setString(2, p1.getCpf());
                ps.setString(3, null);
                ps.setString(4, p1.getEmail());
                ps.setString(5, p1.getTelefone());
            }
            
            affected = ps.executeUpdate();
            
            
        }catch(SQLException e){
            e.printStackTrace();
        }catch(NullPointerException e){
            e.printStackTrace();
        }
        
        return affected != 0;
    }

    @Override
    public boolean update(Cliente valor) {
        System.out.println("Atualizando o cliente "+valor);
        int affected = 0;
        
        try{
            Connection con = MyConnector.connect();
            
            String sql = "UPDATE cliente set nome = ?, cpf = ?, especie = ? , email = ?, telefone = ? WHERE id = ?;";
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            if(valor instanceof Animal){
                Animal a1 = (Animal) valor;
                
                ps.setString(1, a1.getNome());
                ps.setString(2, a1.getCpf());
                ps.setString(3, a1.getEspecie());
                ps.setString(4, null);
                ps.setString(5, null);
                
            }else{
                Pessoa p1 = (Pessoa) valor;
                
                ps.setString(1, p1.getNome());
                ps.setString(2, p1.getCpf());
                ps.setString(3, null);
                ps.setString(4, p1.getEmail());
                ps.setString(5, p1.getTelefone());
            }
            
            ps.setInt(6, valor.getId());
            
            affected = ps.executeUpdate();
            
        }catch(SQLException e){
            e.printStackTrace();
        }catch(NullPointerException e){
            e.printStackTrace();
        }
        
        return affected != 0;
    }

    @Override
    public boolean delete(Cliente valor) {
        System.out.println("Deletando o cliente "+valor);
        int affected = 0;
        
        try{
            Connection con = MyConnector.connect();
            
            String sql = "DELETE FROM cliente WHERE id = ?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, valor.getId());
            
            affected = ps.executeUpdate();
            
            
        }catch(SQLException e){
            e.printStackTrace();
        }catch(NullPointerException e){
            e.printStackTrace();
        }
        
        return affected != 0;
    }
    
    public boolean deleteById(int id) {
        System.out.println("Deletando o cliente "+id);
        int affected = 0;
        
        try{
            Connection con = MyConnector.connect();
            
            String sql = "DELETE FROM cliente WHERE id = ?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, id);
            
            affected = ps.executeUpdate();
            
        }catch(SQLException e){
            e.printStackTrace();
        }catch(NullPointerException e){
            e.printStackTrace();
        }
        
        return affected != 0;
    }

    @Override
    public ArrayList<Cliente> getAll() {
        System.out.println("Listando todos os cliente");
        ArrayList<Cliente> lista = new ArrayList<Cliente>();
        
        try{
            Connection con = MyConnector.connect();
            
            String sql = "SELECT * FROM cliente;";
            
            PreparedStatement ps = con.prepareStatement(sql);
                        
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String especie = rs.getString("especie");
                String email = rs.getString("email");
                String telefone = rs.getString("telefone");
                
                Cliente c = null;
                if(especie == null){
                    c = new Animal(id, nome, cpf, especie);
                }else{
                    c = new Pessoa(id, nome, cpf, email, telefone);
                }
                
                lista.add(c);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }catch(NullPointerException e){
            e.printStackTrace();
        }
        
        return lista;
    }

    @Override
    public Cliente getById(int id_busca) {
        System.out.println("Buscando o cliente "+id_busca);
        Cliente f = null;
        try{
            Connection con = MyConnector.connect();
            
            String sql = "SELECT * FROM cliente WHERE id = ?;";
            
            PreparedStatement ps = con.prepareStatement(sql);
                        
            ps.setInt(1, id_busca);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String especie = rs.getString("especie");
                String email = rs.getString("email");
                String telefone = rs.getString("telefone");
                
                if(especie != null){
                    f = new Animal(id, nome, cpf, especie);
                }else{
                    f = new Pessoa(id, nome, cpf, email, telefone);
                }
                
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }catch(NullPointerException e){
            e.printStackTrace();
        }
        
        return f;
    }

    @Override
    public ArrayList<Cliente> getByNome(String nome_busca) {
        System.out.println("Buscando o cliente "+nome_busca);
        ArrayList<Cliente> lista = new ArrayList<Cliente>();
        Cliente f = null;
        try{
            Connection con = MyConnector.connect();
            
            String sql = "SELECT * FROM item WHERE nome like '%" + nome_busca.toLowerCase() + "%';";
            
            Statement ps = con.createStatement();
            
            ResultSet rs = ps.executeQuery(sql);
            
            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String especie = rs.getString("especie");
                String email = rs.getString("email");
                String telefone = rs.getString("telefone");
                
                Cliente c = null;
                if(especie != null){
                    c = new Animal(id, nome, cpf, especie);
                }else{
                    c = new Pessoa(id, nome, cpf, email, telefone);
                }
                
                lista.add(c);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }catch(NullPointerException e){
            e.printStackTrace();
        }
        
        return lista;
    }

    public ArrayList<Cliente> getByCpf(String cpf_busca) {
        System.out.println("Buscando o cliente "+cpf_busca);
        ArrayList<Cliente> lista = new ArrayList<Cliente>();
        Cliente f = null;
        try{
            Connection con = MyConnector.connect();
            
            String sql = "SELECT * FROM cliente WHERE cpf = ?;";
            
            PreparedStatement ps = con.prepareStatement(sql);
                        
            ps.setString(1, cpf_busca);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String especie = rs.getString("especie");
                String email = rs.getString("email");
                String telefone = rs.getString("telefone");
                
                Cliente c = null;
                if(especie != null){
                    c = new Animal(id, nome, cpf, especie);
                }else{
                    c = new Pessoa(id, nome, cpf, email, telefone);
                }
                
                lista.add(c);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }catch(NullPointerException e){
            e.printStackTrace();
        }
        
        return lista;
    }
    
}
