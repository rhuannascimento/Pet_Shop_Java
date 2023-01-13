
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
public class BuscarAnimaisPorCpf {

    private ArrayList<Cliente> animais;
    private ClienteRep cr;

    public BuscarAnimaisPorCpf() throws ClienteExp {
        
        animais = new ArrayList<>();
        cr = new ClienteRep();
    }

    public ArrayList<Cliente> getAnimais(String cpf) throws ClienteExp {
        ArrayList<Cliente> l = cr.getByCpf(cpf);
       System.out.println("\nPreenchendo array de animais");
        if (!l.isEmpty()) {
            for (int i = 0; i < l.size(); i++) {
                if (l.get(i) instanceof Animal) {
                    System.out.println(l.get(i));
                    this.animais.add(l.get(i));
                }
            }
        } else {
            throw new ClienteExp("Não exitse clientes cadastrados!");
        }
        return this.animais;
    }

}

