/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.repository;

import com.mycompany.petshop.model.exceptions.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author viier
 */
public class SqlRunner {
    public int runUpdateQuery(PreparedStatement statement){    
        
        int numRows = 0;
        try {
            numRows = statement.executeUpdate();
            
            if(numRows == 0) throw new NothingUpdatedException(statement.getWarnings());
            
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NothingUpdatedException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
            return numRows;
        }
    }
    
    public ResultSet runListQuery(PreparedStatement statement){  
        ResultSet rows = null;
        try {
            rows = statement.executeQuery();
            
            if(!rows.isBeforeFirst()) throw new NothingSelectedException(statement.getWarnings());

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NothingSelectedException e) {
            e.printStackTrace();
        }
        return rows;
    }
}