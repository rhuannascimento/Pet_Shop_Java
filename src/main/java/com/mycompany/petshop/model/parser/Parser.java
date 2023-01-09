/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.model.parser;

import com.mycompany.petshop.model.classes.*;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author viier
 * @param <T>
 */
public interface Parser<T> {
    public abstract T getOne(ResultSet rs);
    public abstract ArrayList<T> getList(ResultSet rs);
}
