/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.business.item;
import com.mycompany.petshop.model.classes.Item;
import com.mycompany.petshop.model.classes.Roupa;
import com.mycompany.petshop.repository.ItemRep;
/**
 *
 * @author beort
 */
public class AtualizarRoupa {
    public AtualizarRoupa(int estoque, String fornecedor, int id, String nome, float preco, String tipo,
            boolean disponivel, String tamanho, String especie, String cor){
        Item i;
        i = new Roupa(estoque, fornecedor, id, nome, preco, tipo,disponivel,tamanho,especie, cor);
        ItemRep ir = new ItemRep();
        ir.update(i);
    }
    
    public AtualizarRoupa(Roupa r){
        Item i;
        i = r;
        ItemRep ir = new ItemRep();
        ir.update(i);
    }
}
