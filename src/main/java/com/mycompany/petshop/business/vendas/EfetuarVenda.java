/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.business.vendas;

import com.mycompany.petshop.model.classes.Brinquedo;
import com.mycompany.petshop.model.classes.Item;
import com.mycompany.petshop.model.classes.Mercadoria;
import com.mycompany.petshop.model.classes.Racao;
import com.mycompany.petshop.model.classes.Remedio;
import com.mycompany.petshop.model.classes.Roupa;
import com.mycompany.petshop.model.exceptions.ItemExp;
import com.mycompany.petshop.repository.ItemRep;

/**
 *
 * @author Rhuan
 */
public class EfetuarVenda {

    public EfetuarVenda(int id) throws ItemExp {
    
        ItemRep ir = new ItemRep();
        
        Item i = ir.getById(id);
        
        if(i.getCategoria().equalsIgnoreCase("servico")){
            //programa de agendamento
        }else if(i.getCategoria().equalsIgnoreCase("remedio")){
                             
            Remedio r = (Remedio) i;
            
            if(r.isDisponivel() && r.getEstoque() > 0){
            
                r.setEstoque(r.getEstoque()-1);
                
                if(r.getEstoque()==0){
                    r.setDisponivel(false);
                }
            
            }else{
                                               
                throw new ItemExp("Produto não esta disponivel");
                
            }
            
            
            
        }else if(i.getCategoria().equalsIgnoreCase("Roupa")){
                             
            Roupa r = (Roupa) i;
            
            if(r.isDisponivel() && r.getEstoque() > 0){
            
                r.setEstoque(r.getEstoque()-1);
                
                if(r.getEstoque()==0){
                    r.setDisponivel(false);
                }
            
            }else{
                               
                throw new ItemExp("Produto não esta disponivel");
                
            }
            
        }else if(i.getCategoria().equalsIgnoreCase("brinquedo")){
                             
            Brinquedo r = (Brinquedo) i;
            
            if(r.isDisponivel() && r.getEstoque() > 0){
            
                r.setEstoque(r.getEstoque()-1);
            
                if(r.getEstoque()==0){
                    r.setDisponivel(false);
                }
                
            }else{
                                                
                throw new ItemExp("Produto não esta disponivel");
                
            }
            
        }else if(i.getCategoria().equalsIgnoreCase("racao")){
                             
            Racao r = (Racao) i;
            
            if(r.isDisponivel() && r.getEstoque() > 0){
            
                r.setEstoque(r.getEstoque()-1);
            
                if(r.getEstoque()==0){
                    r.setDisponivel(false);
                }
                
            }else{
                                               
                throw new ItemExp("Produto não esta disponivel");
                
            }
            
        }
        
    }
           
    
}
