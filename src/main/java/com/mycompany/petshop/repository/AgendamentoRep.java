/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.repository;

import com.mycompany.petshop.model.classes.Agendamento;
import com.mycompany.petshop.model.classes.Animal;
import com.mycompany.petshop.model.classes.Cliente;
import com.mycompany.petshop.model.classes.Pessoa;
import com.mycompany.petshop.model.classes.Servico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author viier
 */
public class AgendamentoRep implements DataAcessObject<Agendamento>{

    @Override
    public boolean insertOne(Agendamento valor) {
        System.out.println("Inserindo o agendamento "+valor);
        PreparedStatement ps = null;
        Connection con = null;
        int affected = 0;
        try{
            con = MyConnector.connect();
            
            String sql = "INSERT INTO agendamento(data_hora, id_animal, id_servico) VALUES (?,?,?)";
            
            ps = con.prepareStatement(sql);
            
            ps.setTimestamp(1, valor.getData_hora());
            ps.setInt(2, valor.getAnimal().getId());
            ps.setInt(3, valor.getServico().getId());
            
            affected = ps.executeUpdate();
            
            
        }catch(SQLException e){
            e.printStackTrace();
        }catch(NullPointerException e){
            e.printStackTrace();
        }
        
        return affected != 0;
    }

    @Override
    public boolean update(Agendamento valor) {
        System.out.println("Atualizando o agendamento "+valor+", definindo os valores: "+valor);
        int affected = 0;
        
        try{
            Connection con = MyConnector.connect();
            
            String sql = "UPDATE agendamento set data_hora = ?, id_animal = ?, id_servico = ? WHERE id = ?;";
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            
            ps.setTimestamp(1, valor.getData_hora());
            ps.setInt(2, valor.getAnimal().getId());
            ps.setInt(3, valor.getServico().getId());
            ps.setInt(4, valor.getId());
            
            affected = ps.executeUpdate();
            
        }catch(SQLException e){
            e.printStackTrace();
        }catch(NullPointerException e){
            e.printStackTrace();
        }
        
        return affected != 0;
    }

    @Override
    public boolean delete(Agendamento valor) {
        System.out.println("deletando o agendamento "+valor);
        int affected = 0;
        
        try{
            Connection con = MyConnector.connect();
            
            String sql = "DELETE FROM agendamento WHERE id = ?;";
            
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
    
    public boolean deleteById(int id_todelete) {
        System.out.println("deletando o agendamento "+id_todelete);
        int affected = 0;
        
        try{
            Connection con = MyConnector.connect();
            
            String sql = "DELETE FROM agendamento WHERE id = ?;";
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, id_todelete);
            
            affected = ps.executeUpdate();
            
        }catch(SQLException e){
            e.printStackTrace();
        }catch(NullPointerException e){
            e.printStackTrace();
        }
        
        return affected != 0;
    }

    @Override
    public ArrayList<Agendamento> getAll() {
        System.out.println("Listando todos os agendamentos");
        ArrayList<Agendamento> lista = new ArrayList<Agendamento>();
        
        try{
            Connection con = MyConnector.connect();
            
            String sql = "SELECT * FROM agendamento ORDER BY data_hora ASC";
            
            PreparedStatement ps = con.prepareStatement(sql);
                        
            ResultSet rs = ps.executeQuery();
            
            ClienteRep cr = new ClienteRep();
            ItemRep ir = new ItemRep();
            
            while(rs.next()){
                int id = rs.getInt("id");
                Timestamp data_hora = rs.getTimestamp("data_hora");
                int id_servico = rs.getInt("id_servico");
                int id_animal = rs.getInt("id_animal");
                
                Animal a = (Animal) cr.getById(id_animal);
                Servico s = (Servico) ir.getById(id_servico);
                
                Agendamento c = new Agendamento(id, data_hora, a, s);
                lista.add(c);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }catch(NullPointerException e){
            e.printStackTrace();
        }
        
        return lista;
    }
    
    public ArrayList<Agendamento> getAllStartingToday() {
        System.out.println("Listando todos os agendamentos a partir de hoje");
        ArrayList<Agendamento> lista = new ArrayList<Agendamento>();
        
        try{
            Connection con = MyConnector.connect();
            
            String sql = "SELECT * FROM agendamento WHERE data_hora >= ? ORDER BY data_hora ASC";
            
            PreparedStatement ps = con.prepareStatement(sql);
            LocalDate today = LocalDate.now();
            Timestamp inicio = new Timestamp(today.getYear(), today.getMonthValue(), today.getDayOfMonth(), 00, 00, 0, 0);
            
            ps.setTimestamp(1, inicio);
                        
            ResultSet rs = ps.executeQuery();
            
            ClienteRep cr = new ClienteRep();
            ItemRep ir = new ItemRep();
            
            while(rs.next()){
                int id = rs.getInt("id");
                Timestamp data_hora = rs.getTimestamp("data_hora");
                int id_servico = rs.getInt("id_servico");
                int id_animal = rs.getInt("id_animal");
                
                Animal a = (Animal) cr.getById(id_animal);
                Servico s = (Servico) ir.getById(id_servico);
                
                Agendamento c = new Agendamento(id, data_hora, a, s);
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
    public Agendamento getById(int id_busca) {
        System.out.println("Listando todos os agendamentos");
        ArrayList<Agendamento> lista = new ArrayList<Agendamento>();
        
        try{
            Connection con = MyConnector.connect();
            
            String sql = "SELECT * FROM agendamento where id = ?";
            
            PreparedStatement ps = con.prepareStatement(sql);
                        
            ps.setInt(1, id_busca);
            
            ResultSet rs = ps.executeQuery();
            
            ClienteRep cr = new ClienteRep();
            ItemRep ir = new ItemRep();
            
            while(rs.next()){
                int id = rs.getInt("id");
                Timestamp data_hora = rs.getTimestamp("data_hora");
                int id_servico = rs.getInt("id_servico");
                int id_animal = rs.getInt("id_animal");
                
                Animal a = (Animal) cr.getById(id_animal);
                Servico s = (Servico) ir.getById(id_servico);
                
                Agendamento c = new Agendamento(id, data_hora, a, s);
                lista.add(c);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }catch(NullPointerException e){
            e.printStackTrace();
        }
        
        return lista.get(0);
    }

    public ArrayList<Agendamento> getByAnimal(int id_animal_busca) {
        System.out.println("Listando todos os agendamentos");
        ArrayList<Agendamento> lista = new ArrayList<Agendamento>();
        
        try{
            Connection con = MyConnector.connect();
            
            String sql = "SELECT * FROM agendamento where id_animal = ?;";
            
            PreparedStatement ps = con.prepareStatement(sql);
                        
            ps.setInt(1, id_animal_busca);
            
            ResultSet rs = ps.executeQuery();
            
            ClienteRep cr = new ClienteRep();
            ItemRep ir = new ItemRep();
            
            while(rs.next()){
                int id = rs.getInt("id");
                Timestamp data_hora = rs.getTimestamp("data_hora");
                int id_servico = rs.getInt("id_servico");
                int id_animal = rs.getInt("id_animal");
                
                Animal a = (Animal) cr.getById(id_animal);
                Servico s = (Servico) ir.getById(id_servico);
                
                Agendamento c = new Agendamento(id, data_hora, a, s);
                lista.add(c);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }catch(NullPointerException e){
            e.printStackTrace();
        }
        
        return lista;
    }
    public ArrayList<Agendamento> getByServico(int id_servico_busca) {
        System.out.println("Listando todos os agendamentos");
        ArrayList<Agendamento> lista = new ArrayList<Agendamento>();
        
        try{
            Connection con = MyConnector.connect();
            
            String sql = "SELECT * FROM agendamento where id_servico = ?;";
            
            PreparedStatement ps = con.prepareStatement(sql);
                        
            ps.setInt(1, id_servico_busca);
            
            ResultSet rs = ps.executeQuery();
            
            ClienteRep cr = new ClienteRep();
            ItemRep ir = new ItemRep();
            
            while(rs.next()){
                int id = rs.getInt("id");
                Timestamp data_hora = rs.getTimestamp("data_hora");
                int id_servico = rs.getInt("id_servico");
                int id_animal = rs.getInt("id_animal");
                
                Animal a = (Animal) cr.getById(id_animal);
                Servico s = (Servico) ir.getById(id_servico);
                
                Agendamento c = new Agendamento(id, data_hora, a, s);
                lista.add(c);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }catch(NullPointerException e){
            e.printStackTrace();
        }
        
        return lista;
    }
    
    public ArrayList<Agendamento> getByTimestamp(Timestamp ts) {
        System.out.println("Listando todos os agendamentos TIMESTAMP");
        ArrayList<Agendamento> lista = new ArrayList<Agendamento>();
        
        Timestamp inicio = new Timestamp(ts.getYear(), ts.getMonth(), ts.getDate(), 00,00,00,00);
        System.out.println(ts.getYear()+ "/" + ts.getMonth() + "/" + ts.getDate() + " " + 00+ ":"+00+ ":"+00+ ":"+00);
        Timestamp fim = new Timestamp(ts.getYear(), ts.getMonth(), ts.getDate(), 23,59,59,00);
        System.out.println(ts.getYear()+ "/" + ts.getMonth() + "/" + ts.getDate() + " " + 23+ ":"+59+ ":"+59+ ":"+00);
        
        
        try{
            Connection con = MyConnector.connect();
            
            String sql = "SELECT * FROM agendamento where data_hora BETWEEN ? AND ? ORDER BY data_hora ASC;";
            
            PreparedStatement ps = con.prepareStatement(sql);
                        
            ps.setTimestamp(1, inicio);
            ps.setTimestamp(2, fim);
            
            ResultSet rs = ps.executeQuery();
            
            ClienteRep cr = new ClienteRep();
            ItemRep ir = new ItemRep();
            
            while(rs.next()){
                int id = rs.getInt("id");
                Timestamp data_hora = rs.getTimestamp("data_hora");
                int id_servico = rs.getInt("id_servico");
                int id_animal = rs.getInt("id_animal");
                
                Animal a = (Animal) cr.getById(id_animal);
                Servico s = (Servico) ir.getById(id_servico);
                
                Agendamento c = new Agendamento(id, data_hora, a, s);
                lista.add(c);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }catch(NullPointerException e){
            e.printStackTrace();
        }
        
        return lista;
    }
    public ArrayList<Agendamento> getByDate(Date ts) {
        System.out.println("Listando todos os agendamentos entre DATES ");
        ArrayList<Agendamento> lista = new ArrayList<Agendamento>();
        
        Timestamp inicio = new Timestamp(ts.getYear(), ts.getMonth(), ts.getDate(), 00,00,00,00);
        System.out.println(ts.getYear()+ "/" + ts.getMonth() + "/" + ts.getDate() + "/ " + 00+ ":"+00+ ":"+00+ ":"+00);
        Timestamp fim = new Timestamp(ts.getYear(), ts.getMonth(), ts.getDate(), 23,59,59,00);
        System.out.println(ts.getYear()+ "/" + ts.getMonth() + "/" + ts.getDate() + "/ " + 23+ ":"+59+ ":"+59+ ":"+00);
        
        try{
            Connection con = MyConnector.connect();
            
            String sql = "SELECT * FROM agendamento where data_hora BETWEEN ? AND ? ORDER BY data_hora ASC;";
            
            PreparedStatement ps = con.prepareStatement(sql);
                        
            ps.setTimestamp(1, inicio);
            ps.setTimestamp(2, fim);
            
            ResultSet rs = ps.executeQuery();
            
            ClienteRep cr = new ClienteRep();
            ItemRep ir = new ItemRep();
            
            while(rs.next()){
                int id = rs.getInt("id");
                Timestamp data_hora = rs.getTimestamp("data_hora");
                int id_servico = rs.getInt("id_servico");
                int id_animal = rs.getInt("id_animal");
                
                Animal a = (Animal) cr.getById(id_animal);
                Servico s = (Servico) ir.getById(id_servico);
                
                Agendamento c = new Agendamento(id, data_hora, a, s);
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
    public boolean deleteAll() {
        System.out.println("deletando os agendamentos");
        int affected = 0;
        
        try{
            Connection con = MyConnector.connect();
            
            String sql = "DELETE FROM agendamento;";
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            affected = ps.executeUpdate();
            
        }catch(SQLException e){
            e.printStackTrace();
        }catch(NullPointerException e){
            e.printStackTrace();
        }
        
        return affected != 0;
    }
    
    
}
