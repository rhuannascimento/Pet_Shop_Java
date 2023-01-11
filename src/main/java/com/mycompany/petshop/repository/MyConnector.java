/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.repository;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author viier
 */
public class MyConnector {

    public MyConnector() {
    }

    public static Connection connect() {
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");

            connection = DriverManager.getConnection("jdbc:sqlite:banco.db");

            return connection;

        } catch (SQLException e) {
            System.out.println("Houve um erro ao realizar a conexão com o banco de dados:");
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            System.out.println("Houve um erro ao localizar o conector do SQLite:");
            e.printStackTrace();
        }

        return connection;
    }
}
