/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.business.item;

import com.mycompany.petshop.model.classes.Item;
import com.mycompany.petshop.repository.ItemRep;

/**
 *
 * @author Rhuan
 */
public class BuscaItem {
    
    private Item f;
    
    public BuscaItem(int id){
    
        ItemRep fr = new ItemRep();
        
        this.f = fr.getById(id); 
      
    }

    public Item getItem() {
        return f;
    }
    
}
