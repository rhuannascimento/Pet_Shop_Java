/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.business.item;

import com.mycompany.petshop.model.classes.Item;
import com.mycompany.petshop.model.classes.Mercadoria;
import com.mycompany.petshop.repository.ItemRep;
import java.util.ArrayList;

/**
 *
 * @author Rhuan
 *//*
    Caio Henrique Vieira Costa - 202176020
    Rhuan Nascimento - 202176033
    Bernardo Ortiz - ?
    Lucas Duarte - 202176012
*/
public class ListarProdutos {
    
    private ArrayList<Item> produtos = new ArrayList();

    public ListarProdutos() {
    
        ItemRep ir = new ItemRep();
    
        ArrayList<Item> itens = new ArrayList();
    
        itens = ir.getAll();
    
        for (int i = 0; i < itens.size(); i++) {
            
           if(!itens.get(i).getCategoria().equalsIgnoreCase("servico")){
               produtos.add(itens.get(i));
           }
                        
        }
            
    }

    public ArrayList<Item> getProdutos() {
        return produtos;
    }
             
}
