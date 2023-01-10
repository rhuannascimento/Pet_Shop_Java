/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.repository;

import com.mycompany.petshop.model.classes.Funcionario;
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
public class FuncionarioRep implements DataAcessObject<Funcionario> {

    @Override
    public boolean insertOne(Funcionario valor) {
        System.out.println("Inserindo o funcionário "+valor);
        PreparedStatement ps = null;
        Connection con = null;
        int affected = 0;
        try{
            con = MyConnector.connect();
            
            String sql = "INSERT INTO funcionario(nome, horario_inicio, horario_fim, cargo, usuario, senha) VALUES (?,?,?,?,?,?)";
            
            ps = con.prepareStatement(sql);
            
            ps.setString(1, valor.getNome());
            ps.setTime(2, valor.getStartTime());
            ps.setTime(3, valor.getEndTime());
            ps.setString(4, valor.getCargo());
            ps.setString(5, valor.getUsername());
            ps.setString(6, valor.getPassword());
            
            affected = ps.executeUpdate();
            
            
        }catch(SQLException e){
            e.printStackTrace();
        }catch(NullPointerException e){
            e.printStackTrace();
        }
        
        return affected != 0;
    }

    @Override
    public boolean update(Funcionario valor) {
        System.out.println("Atualizando o funcionário "+valor);
        int affected = 0;
        
        try{
            Connection con = MyConnector.connect();
            
            String sql = "UPDATE funcionario set nome = ?, horario_inicio = ?, horario_fim = ? , cargo = ?, usuario = ?, senha = ? WHERE id = ?;";
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, valor.getNome());
            ps.setTime(2, valor.getStartTime());
            ps.setTime(3, valor.getEndTime());
            ps.setString(4, valor.getCargo());
            ps.setString(5, valor.getUsername());
            ps.setString(6, valor.getPassword());
            ps.setInt(7, valor.getId());
            
            affected = ps.executeUpdate();
            
        }catch(SQLException e){
            e.printStackTrace();
        }catch(NullPointerException e){
            e.printStackTrace();
        }
        
        return affected != 0;
    }

    @Override
    public boolean delete(Funcionario valor) {
        System.out.println("Deletando o funcionário "+valor);
        int affected = 0;
        
        try{
            Connection con = MyConnector.connect();
            
            String sql = "DELETE FROM funcionario WHERE id = ?";
            
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
        System.out.println("Deletando o funcionário "+id);
        int affected = 0;
        
        try{
            Connection con = MyConnector.connect();
            
            String sql = "DELETE FROM funcionario WHERE id = ?";
            
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
    public ArrayList<Funcionario> getAll() {
        System.out.println("Listando todos os funcionários");
        ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
        
        try{
            Connection con = MyConnector.connect();
            
            String sql = "SELECT * FROM funcionario;";
            
            PreparedStatement ps = con.prepareStatement(sql);
                        
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                Time horario_inicio = rs.getTime("horario_inicio");
                Time horario_fim = rs.getTime("horario_fim");
                String cargo = rs.getString("cargo");
                String usuario = rs.getString("usuario");
                String senha = rs.getString("senha");
                Funcionario f = new Funcionario(id, nome, horario_inicio, horario_fim, cargo, usuario, senha);
                lista.add(f);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }catch(NullPointerException e){
            e.printStackTrace();
        }
        
        return lista;
    }

    @Override
    public Funcionario getById(int id_busca) {
        System.out.println("Buscando o funcionário "+id_busca);
        Funcionario f = null;
        try{
            Connection con = MyConnector.connect();
            
            String sql = "SELECT * FROM funcionario WHERE id = ?;";
            
            PreparedStatement ps = con.prepareStatement(sql);
                        
            ps.setInt(1, id_busca);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                Time horario_inicio = rs.getTime("horario_inicio");
                Time horario_fim = rs.getTime("horario_fim");
                String cargo = rs.getString("cargo");
                String usuario = rs.getString("usuario");
                String senha = rs.getString("senha");
                f = new Funcionario(id, nome, horario_inicio, horario_fim, cargo,usuario, senha);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }catch(NullPointerException e){
            e.printStackTrace();
        }
        
        return f;
    }

    @Override
    public ArrayList<Funcionario> getByNome(String nome_busca) {
        System.out.println("Buscando o funcionário "+nome_busca);
        ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
        Funcionario f = null;
        try{
            Connection con = MyConnector.connect();
            
            String sql = "SELECT * FROM funcionario WHERE nome like '%" + nome_busca.toLowerCase() + "%';";
            
            Statement ps = con.createStatement();
            
            ResultSet rs = ps.executeQuery(sql);
            
            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                Time horario_inicio = rs.getTime("horario_inicio");
                Time horario_fim = rs.getTime("horario_fim");
                String cargo = rs.getString("cargo");
                String usuario = rs.getString("usuario");
                String senha = rs.getString("senha");
                f = new Funcionario(id, nome, horario_inicio, horario_fim, cargo, usuario, senha);
                lista.add(f);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }catch(NullPointerException e){
            e.printStackTrace();
        }
        
        return lista;
    }

    public ArrayList<Funcionario> getByUsername(String nome_busca) {
        nome_busca = nome_busca.toLowerCase();
        System.out.println("Buscando o funcionário "+nome_busca);
        ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
        Funcionario f = null;
        try{
            Connection con = MyConnector.connect();
            
            String sql = "SELECT * FROM funcionario WHERE usuario = ?;";
            
            PreparedStatement ps = con.prepareStatement(sql);
                        
            ps.setString(1, nome_busca);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                Time horario_inicio = rs.getTime("horario_inicio");
                Time horario_fim = rs.getTime("horario_fim");
                String cargo = rs.getString("cargo");
                String usuario = rs.getString("usuario");
                String senha = rs.getString("senha");
                f = new Funcionario(id, nome, horario_inicio, horario_fim, cargo, usuario, senha);
                lista.add(f);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }catch(NullPointerException e){
            e.printStackTrace();
        }
        
        return lista;
    }
    
}
