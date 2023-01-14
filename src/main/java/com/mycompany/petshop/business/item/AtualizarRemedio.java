/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.business.item;
import com.mycompany.petshop.model.classes.Item;
import com.mycompany.petshop.model.classes.Remedio;
import com.mycompany.petshop.repository.ItemRep;
/**
 *
 * @author beort
 *//*
    Caio Henrique Vieira Costa - 202176020
    Rhuan Nascimento - 202176033
    Bernardo Ortiz - ?
    Lucas Duarte - 202176012
*/
public class AtualizarRemedio {
    public AtualizarRemedio(int estoque, String fornecedor, int id, String nome, float preco, String tipo,
    boolean disponivel, String utilidade, String orientacao){
    
       Item i;
       i = new Remedio(estoque, fornecedor, id, nome, preco, tipo,disponivel,utilidade,orientacao);
       ItemRep ir = new ItemRep();
       ir.update(i);
    }
    
    public AtualizarRemedio(Remedio r){
    
       Item i;
       i = r;
       ItemRep ir = new ItemRep();
       ir.update(i);
    }
}
