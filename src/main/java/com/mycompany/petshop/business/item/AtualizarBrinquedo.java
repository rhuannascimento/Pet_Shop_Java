/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.business.item;
import com.mycompany.petshop.model.classes.Item;
import com.mycompany.petshop.model.classes.Brinquedo;
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
public class AtualizarBrinquedo {
    public AtualizarBrinquedo(int estoque, String fornecedor, int id, String nome, float preco, String tipo,
            boolean disponivel, String especie, String material){
            
        Item i;
        i = new Brinquedo(estoque, fornecedor, id, nome, preco, tipo,disponivel,especie,material);
        System.out.println(estoque + " - " + fornecedor+ " - " + id+ " - " + nome+ " - " + preco+ " - " + tipo+ " - " +disponivel+ " - " +especie+ " - " +material);
        ItemRep ir = new ItemRep();
        ir.update(i);

    }
    
    public AtualizarBrinquedo(Brinquedo b){
            
        Item i = b;
        ItemRep ir = new ItemRep();
        ir.update(i);

    }
}