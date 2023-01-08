/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.repository;

import java.sql.ResultSet;

/**
 *
 * @author viier
 * @param <T>
 */
public interface InterfaceRep<T> {
    public abstract boolean insertOne(T objeto);
    
    public abstract boolean update(T objeto);
    
    public abstract boolean delete(T objeto);
    
    public abstract ResultSet selectAll();
    
    public abstract ResultSet selectByID(int id);
    
    public abstract ResultSet selectByName(String name);
    
    
    
}
