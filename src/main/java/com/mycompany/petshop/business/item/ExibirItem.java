package com.mycompany.petshop.business.item;

import com.mycompany.petshop.model.classes.Funcionario;
import com.mycompany.petshop.model.classes.Item;
import com.mycompany.petshop.model.exceptions.FuncionarioExp;
import com.mycompany.petshop.model.exceptions.ItemExp;
import com.mycompany.petshop.repository.FuncionarioRep;
import com.mycompany.petshop.repository.ItemRep;

import java.util.ArrayList;

/**
 *
 * @author Rhuan
 */
public class ExibirItem {

    private ArrayList<Item> itens = new ArrayList();

    public ExibirItem() {

        ItemRep ir = new ItemRep();

        this.itens = ir.getAll();

    }

    public Item getUltimo() throws ItemExp {

        if (this.itens.size() > 0) {

            return itens.get(itens.size() - 1);

        } else {
            throw new ItemExp("Não há itens cadastrados!");
        }

    }

    public ArrayList<Item> getItens() {
        return itens;
    }

}