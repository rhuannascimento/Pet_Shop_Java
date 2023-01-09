/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.repository;

import java.util.ArrayList;

/**
 *
 * @author viier
 * @param <T>
 */
public interface DataAcessObject<T> {
    public boolean insertOne(T valor);
    public boolean update(T valor);
    public boolean delete(T valor);
    public ArrayList<T> getAll();
    public T getById(int id);
    public ArrayList<T> getByNome(String nome);
}
