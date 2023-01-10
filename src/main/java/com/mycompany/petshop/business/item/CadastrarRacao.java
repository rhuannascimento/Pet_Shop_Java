package com.mycompany.petshop.business.item;
import com.mycompany.petshop.model.classes.Animal;
import com.mycompany.petshop.model.classes.Item;
import com.mycompany.petshop.model.classes.Pessoa;
import com.mycompany.petshop.repository.ItemRep;
import java.sql.Time;
import java.util.ArrayList;

public class CadastrarRacao {
    
    public CadastrarRacao(int estoque, String fornecedor, String categoria, String nome, String sabor ,boolean disponivel, String especie,
     float preco, String tipo, int id){
        Item i;
      
        i = new Item(estoque, fornecedor, categoria, id, nome, preco, tipo,disponivel,especie,sabor);
        
        ItemRep uir = new ItemRep();
       ir.insertOne(i);
    }
}
