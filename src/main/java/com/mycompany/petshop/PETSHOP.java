/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.petshop;

import com.mycompany.petshop.model.classes.*;
import com.mycompany.petshop.model.parser.*;
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
        }
        if(args.length == 1){
            if(args[0].equalsIgnoreCase("migrate")) m.migrate();
            if(args[0].equalsIgnoreCase("seed")) s.seed();
        }
        
        
        FuncionarioRep rep = new FuncionarioRep();
        
        Funcionario f = new Funcionario(0, "claudio", Time.valueOf("08:00:00"), Time.valueOf("18:00:00"), "mypassword");
        
        rep.insertOne(f);
        
        ResultSet rs = rep.selectAll();

        FuncionarioParser fp = new FuncionarioParser();
        
        ArrayList<Funcionario> listaaa = fp.getList(rs);
        
        for(Funcionario f2 : listaaa){
            System.out.println("f2: "+f2);
            
        }
        
        
    }
}
