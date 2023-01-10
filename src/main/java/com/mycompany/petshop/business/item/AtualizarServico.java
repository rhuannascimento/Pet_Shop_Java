/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.business.item;

import com.mycompany.petshop.model.classes.Item;
import com.mycompany.petshop.model.classes.Servico;
import com.mycompany.petshop.repository.ItemRep;

/**
 *
 * @author Rhuan
 */
public class AtualizarServico {

    public AtualizarServico(int id, String nome, float preco, String tipo, boolean disponivel, int duracao, int idResponsavel) {
    
        Item i = new Servico(id, nome, preco, tipo, disponivel, duracao, idResponsavel); 
    
        ItemRep ir = new ItemRep();
        
        ir.update(i);
        
    }
            
    
}
