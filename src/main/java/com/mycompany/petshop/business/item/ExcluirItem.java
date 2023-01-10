/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.business.item;

import com.mycompany.petshop.repository.ItemRep;

/**
 *
 * @author Rhuan
 */
public class ExcluirItem {

    public ExcluirItem(int id) {
        
        new ItemRep().deleteById(id);
        
    }
          
}
