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

/**
 *
 * @author viier
 */
public class FuncionarioRep implements InterfaceRep<Funcionario> {
    
    public FuncionarioRep(){
        
    }
    @Override
    public boolean insertOne(Funcionario f) {
        int affected = 0;
        Connection con = MyConnector.connect();;
        try{
            SqlRunner run = new SqlRunner();
            
            String sql = "INSERT INTO funcionario (nome, horario_inicio, horario_fim, cargo, senha) VALUES (?, ?, ?, ?, ?);";
        
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, f.getNome());
            ps.setTime(2, f.getStartTime());
            ps.setTime(3, f.getEndTime());
            ps.setString(4, f.getNome());
            ps.setString(5, f.getPassword());
            
            affected = run.runUpdateQuery(ps);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(con != null) con.close();
                
            }catch(SQLException e){
                e.printStackTrace();
            }
            return affected != 0;
        }
        
    }

    @Override
    public boolean update(Funcionario f) {
        int affected = 0;
        Connection con = MyConnector.connect();
        try{
            SqlRunner run = new SqlRunner();
            
            String sql = "UPDATE TABLE funcionario SET nome = ?, horario_inicio = ?, horario_fim = ?, cargo = ?;";
        
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, f.getNome());
            ps.setTime(2, f.getStartTime());
            ps.setTime(3, f.getEndTime());
            ps.setString(4, f.getNome());
            
            affected = run.runUpdateQuery(ps);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(con != null) con.close();
                
            }catch(SQLException e){
                e.printStackTrace();
            }
            return affected != 0;
        }
        
    }

    @Override
    public boolean delete(Funcionario f) {
        int affected = 0;
        Connection con = MyConnector.connect();;
        try{
            SqlRunner run = new SqlRunner();
            
            String sql = "DELETE FROM funcionario WHERE id = ?;";
        
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, f.getId());
            
            affected = run.runUpdateQuery(ps);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(con != null) con.close();
                
            }catch(SQLException e){
                e.printStackTrace();
            }
            return affected != 0;
        }
    }

    @Override
    public ResultSet selectAll() {
        ResultSet results = null;
        Connection con = MyConnector.connect();
        PreparedStatement ps = null;
        try{
            SqlRunner run = new SqlRunner();
            
            String sql = "SELECT * FROM funcionario;";
        
            ps = con.prepareStatement(sql);

            results = run.runListQuery(ps);
            

        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        return results;
        
    }

    @Override
    public ResultSet selectByID(int id) {
        ResultSet results = null;
        Connection con = MyConnector.connect();;
        try{
            SqlRunner run = new SqlRunner();
            
            String sql = "SELECT * FROM funcionario WHERE id = ?;";
        
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, id);
            
            results = run.runListQuery(ps);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(con != null) con.close();
                
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        
        return results;
    }

    @Override
    public ResultSet selectByName(String name) {
        ResultSet results = null;
        Connection con = MyConnector.connect();;
        try{
            SqlRunner run = new SqlRunner();
            
            String sql = "SELECT * FROM funcionario WHERE nome = ?;";
        
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, name);
            
            results = run.runListQuery(ps);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(con != null) con.close();
                
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        
        return results;
    }
    
}
