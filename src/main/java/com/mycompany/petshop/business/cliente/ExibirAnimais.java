/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.business.cliente;

import com.mycompany.petshop.model.classes.Animal;
import com.mycompany.petshop.model.classes.Cliente;
import com.mycompany.petshop.model.exceptions.ClienteExp;
import com.mycompany.petshop.repository.ClienteRep;
import java.util.ArrayList;

/**
 *
 * @author Rhuan
 */
public class ExibirAnimais {

    private ArrayList<Cliente> animais;

    public ExibirAnimais() throws ClienteExp {
        
        animais = new ArrayList<>();
        
        ClienteRep cr = new ClienteRep();
        ArrayList<Cliente> l = cr.getAll();
       
        if (!l.isEmpty()) {
            for (int i = 0; i < l.size(); i++) {
                if (l.get(i) instanceof Animal) {
                    this.animais.add(l.get(i));
                }

            }
        } else {
            throw new ClienteExp("Não existem clientes cadastrados!");
        }

    }

    public ArrayList<Cliente> getAnimais() {
        return this.animais;
    }

}
