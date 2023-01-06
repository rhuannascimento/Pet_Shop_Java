/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.petshop;

import com.mycompany.petshop.model.classes.*;
import com.mycompany.petshop.repository.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.LocalDate;

/**
 *
 * @author Rhuan
 */
public class PETSHOP {

    public static void main(String[] args) {
        Migrator m = new Migrator();
        m.migrate();
        
    }
}
