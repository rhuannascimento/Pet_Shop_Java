/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.controller;

import com.mycompany.petshop.business.cliente.AtualizarAnimal;
import com.mycompany.petshop.business.cliente.AtualizarPessoa;
import com.mycompany.petshop.business.cliente.CadastrarCliente;
import com.mycompany.petshop.business.cliente.ExcluirCliente;
import com.mycompany.petshop.business.cliente.ExibirAnimais;
import com.mycompany.petshop.business.cliente.ExibirPessoas;
import com.mycompany.petshop.model.classes.Animal;
import com.mycompany.petshop.model.classes.Cliente;
import com.mycompany.petshop.model.classes.Pessoa;
import com.mycompany.petshop.model.exceptions.ClienteExp;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author beort
 */
public class ClienteCtrl {
    private ExibirPessoas exibirPessoa;
    private ExibirAnimais exibirAnimal;
    private CadastrarCliente cadastrarCliente;
    private ExcluirCliente excluirCliente;
    private AtualizarPessoa atualizarPessoa;
    private AtualizarAnimal atualizarAnimal;

    public DefaultTableModel exibirAnimais() throws ClienteExp {
        this.exibirAnimal = new ExibirAnimais();

        String col[] = { "ID", "Nome", "cpf", "especie" };

        DefaultTableModel dtm = new DefaultTableModel(col, 0);

        try {
            ArrayList<Cliente> lista = this.exibirAnimal.getAnimais();

            for (Cliente c : lista) {
                Object[] data = { c.getId(), c.getNome(), c.getCpf(), ((Animal)c).getEspecie() };
                dtm.addRow(data);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return dtm;

    }
    
       public DefaultTableModel exibirPessoas() throws ClienteExp {
        this.exibirPessoa = new ExibirPessoas();

        String col[] = { "ID", "Nome", "cpf", "E-mail", "Telefone" };

        DefaultTableModel dtm = new DefaultTableModel(col, 0);

        try {
            ArrayList<Cliente> lista = this.exibirAnimal.getAnimais();

            for (Cliente c : lista) {
                Object[] data = { c.getId(), c.getNome(), c.getCpf(), ((Pessoa)c).getEmail(), ((Pessoa)c).getTelefone() };
                dtm.addRow(data);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return dtm;

    }

}
