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
        m.migrate();

        Seeder s = new Seeder();
        s.seed();
        
        FuncionarioRep rep = new FuncionarioRep();
        
        Funcionario f = new Funcionario(0, "claudio", Time.valueOf("08:00:00"), Time.valueOf("18:00:00"), "mypassword");
        
        rep.insertOne(f);
        
        ResultSet rs = rep.selectAll();
        try {
            while (rs.next()) {
                int id;
                String nome = "";

                id = rs.getInt("id");
                nome = rs.getString("nome");

                System.out.println("ID: " + id + ", Nome: " + nome);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PETSHOP.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
