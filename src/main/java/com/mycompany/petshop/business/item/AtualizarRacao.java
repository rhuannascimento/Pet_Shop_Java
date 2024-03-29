package com.mycompany.petshop.business.item;
import com.mycompany.petshop.model.classes.Animal;
import com.mycompany.petshop.model.classes.Item;
import com.mycompany.petshop.model.classes.Pessoa;
import com.mycompany.petshop.model.classes.Racao;
import com.mycompany.petshop.repository.ItemRep;
import java.sql.Time;
import java.util.ArrayList;
/*
    Caio Henrique Vieira Costa - 202176020
    Rhuan Nascimento - 202176033
    Bernardo Ortiz - ?
    Lucas Duarte - 202176012
*/
public class AtualizarRacao {
    
    public AtualizarRacao(int estoque, String fornecedor, int id, String nome, float preco, String tipo,
            boolean disponivel, String especie, String sabor, int idade_recomendada){
        Item i;
        i = new Racao(estoque, fornecedor, id, nome, preco, tipo,disponivel,especie,sabor, idade_recomendada);
        ItemRep ir = new ItemRep();
        ir.update(i);    
    }
    
    public AtualizarRacao(Racao r){
        Item i;
        i = r;
        ItemRep ir = new ItemRep();
        ir.update(i);    
    }
}