package com.mycompany.petshop.business.item;
import com.mycompany.petshop.model.classes.Item;
import com.mycompany.petshop.model.classes.Racao;
import com.mycompany.petshop.repository.ItemRep;
import java.sql.Time;
import java.util.ArrayList;

public class CadastrarRacao {
    
    public CadastrarRacao(int estoque, String fornecedor, int id, String nome, float preco, String tipo,
            boolean disponivel, String especie, String sabor, int idade_recomendada){
        Item i;
        i = new Racao(estoque, fornecedor, id, nome, preco, tipo,disponivel,especie,sabor, idade_recomendada);
        ItemRep ir = new ItemRep();
        ir.insertOne(i);
    }
}
