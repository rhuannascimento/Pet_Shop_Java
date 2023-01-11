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
        System.out.println("exibindo pessoas 3");
        animais = new ArrayList<Cliente>();
        ClienteRep cr = new ClienteRep();

        System.out.println("exibindo pessoas 4 ");
        ArrayList<Cliente> l = cr.getAll();
        System.out.println("exibindo pessoas 5 ");

        System.out.println("l.isEmpty(): " + l.isEmpty());
        if (!l.isEmpty()) {
            for (int i = 0; i < l.size(); i++) {

                System.out.println("l.get(i): " + l.get(i));
                System.out.println("l.get(i).getTipo(): " + l.get(i).getTipo());
                if (l.get(i).getTipo().equalsIgnoreCase("animal")) {
                    this.animais.add(l.get(i));
                }

            }
        } else {
            throw new ClienteExp("Não exitse clientes cadastrados!");
        }

    }

    public ArrayList<Cliente> getAnimais() {
        return this.animais;
    }

}
