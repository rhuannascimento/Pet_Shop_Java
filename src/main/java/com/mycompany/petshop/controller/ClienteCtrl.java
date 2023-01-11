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

    public ArrayList<Cliente> exibirAnimais() throws ClienteExp {
        this.exibirAnimal = new ExibirAnimais();

        ArrayList<Cliente> lista = this.exibirAnimal.getAnimais();

        // String col[] = { "ID", "Nome", "cpf", "especie" };

        // DefaultTableModel dtm = new DefaultTableModel(col, 0);

        // try {
        // ArrayList<Cliente> lista = this.exibirAnimal.getAnimais();

        // for (Cliente c : lista) {
        // Object[] data = { c.getId(), c.getNome(), c.getCpf(),
        // ((Animal)c).getEspecie() };
        // dtm.addRow(data);
        // }

        // } catch (Exception ex) {
        // ex.printStackTrace();
        // }

        return lista;

    }

    public ArrayList<Cliente> exibirPessoas() throws ClienteExp {
        this.exibirPessoa = new ExibirPessoas();
        ArrayList<Cliente> lista = this.exibirPessoa.getPessoas();
        // String col[] = { "ID", "Nome", "cpf", "E-mail", "Telefone" };

        // DefaultTableModel dtm = new DefaultTableModel(col, 0);

        // try {
        // ArrayList<Cliente> lista = this.exibirAnimal.getAnimais();

        // for (Cliente c : lista) {
        // Object[] data = { c.getId(), c.getNome(), c.getCpf(), ((Pessoa)
        // c).getEmail(),
        // ((Pessoa) c).getTelefone() };
        // dtm.addRow(data);
        // }

        // } catch (Exception ex) {
        // ex.printStackTrace();
        // }

        return lista;

    }

    public void cadastrarCliente(int id, String nome, String cpf, String tipo, String telefone, String email,
            String especie) throws ClienteExp {

        cadastrarCliente = new CadastrarCliente(id, nome, cpf, tipo, telefone, email, especie);
    }

    public void atualizarAnimal(int id, String nome, String cpf, String especie) {

        atualizarAnimal = new AtualizarAnimal(id, nome, cpf, especie);

    }

    public void atualizarPessoa(int id, String nome, String cpf, String email, String telefone) {

        atualizarPessoa = new AtualizarPessoa(id, nome, cpf, email, telefone);

    }

    public void excluirCliente(int id) {
        excluirCliente = new ExcluirCliente(id);
    }

}
