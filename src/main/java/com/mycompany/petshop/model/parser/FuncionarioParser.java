/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.model.parser;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.mycompany.petshop.model.classes.Funcionario;
import java.sql.SQLException;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author viier
 */
public class FuncionarioParser implements Parser {

    public FuncionarioParser() {
    }
    
    
    
    @Override
    public Funcionario getOne(ResultSet rs) {
        Funcionario f = null;
        try{
            if(!rs.next()) return null;
            
            int id = rs.getInt("id");
            String nome = rs.getString("nome"), password = rs.getString("senha");
            Time startTime = new Time(rs.getInt("horario_inicio"));
            Time endTime = new Time(rs.getInt("horario_fim"));
            
            f = new Funcionario(id, nome, startTime, endTime, password);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return f;
    }

    @Override
    public ArrayList<Funcionario> getList(ResultSet rs) {
        
        ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
        
        try{
            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome"), password = rs.getString("senha");
                Time startTime = new Time(rs.getInt("horario_inicio"));
                Time endTime = new Time(rs.getInt("horario_fim"));

                Funcionario f = new Funcionario(id, nome, startTime, endTime, password);
                System.out.println("f: "+f);
                
                lista.add(f);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("lista: "+lista);
        return lista;
    }
    
}
