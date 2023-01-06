package com.mycompany.petshop.repository;

import java.sql.*;

class Connector {

    private static void connect() {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db")) {
            System.out.println("Conexão com o banco realizada com sucesso!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        connect();
    }
}