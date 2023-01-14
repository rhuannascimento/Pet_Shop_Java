package com.mycompany.petshop.business.cliente;

import com.mycompany.petshop.model.classes.Cliente;
import com.mycompany.petshop.model.exceptions.ClienteExp;
import com.mycompany.petshop.repository.ClienteRep;
/*
    Caio Henrique Vieira Costa - 202176020
    Rhuan Nascimento - 202176033
    Bernardo Ortiz - ?
    Lucas Duarte - 202176012
*/
import java.util.ArrayList;

/**
 *
 * @author Rhuan
 */
public class ExibirCliente {

    private ArrayList<Cliente> clientes = new ArrayList();

    public ExibirCliente() {

        ClienteRep cr = new ClienteRep();

        this.clientes = cr.getAll();

    }

    public Cliente getUltimo() throws ClienteExp {

        if (this.clientes.size() > 0) {

            return clientes.get(clientes.size() - 1);

        } else {
            throw new ClienteExp("Não há clientes cadastrados!");
        }

    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

}