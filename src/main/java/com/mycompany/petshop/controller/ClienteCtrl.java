/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.controller;

import com.mycompany.petshop.business.cliente.AtualizarAnimal;
import com.mycompany.petshop.business.cliente.AtualizarPessoa;
import com.mycompany.petshop.business.cliente.BuscarCliente;
import com.mycompany.petshop.business.cliente.CadastrarCliente;
import com.mycompany.petshop.business.cliente.ExcluirCliente;
import com.mycompany.petshop.business.cliente.ExibirAnimais;
import com.mycompany.petshop.business.cliente.ExibirCliente;
import com.mycompany.petshop.business.cliente.ExibirClientePorId;
import com.mycompany.petshop.business.cliente.ExibirPessoas;
import com.mycompany.petshop.business.item.ExibirItem;
import com.mycompany.petshop.model.classes.Animal;
import com.mycompany.petshop.model.classes.Cliente;
import com.mycompany.petshop.model.classes.Pessoa;
import com.mycompany.petshop.model.exceptions.ClienteExp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author beort
 */
public class ClienteCtrl {
    private ExibirCliente exibir;
    private ExibirPessoas exibirPessoa;
    private ExibirAnimais exibirAnimal;
    private BuscarCliente buscarCliente;
    private CadastrarCliente cadastrarCliente;
    private ExcluirCliente excluirCliente;
    private AtualizarPessoa atualizarPessoa;
    private AtualizarAnimal atualizarAnimal;
    private ExibirClientePorId exibirClientePorId;

    public ArrayList<Cliente> exibirAnimais() {
        try {
            this.exibirAnimal = new ExibirAnimais();
        } catch (ClienteExp ex) {
            
        }

        ArrayList<Cliente> lista = this.exibirAnimal.getAnimais();


        return lista;

    }
    
    public ArrayList<Cliente> exibirAnimais(String cpf) {
        ArrayList<Cliente> lista = new ArrayList<>();
        
        if(cpf.length() == 11){
            try {
                this.buscarCliente = new BuscarCliente();
                lista = this.buscarCliente.obterAnimaisPorCpf(cpf);
            } catch (ClienteExp ex) {}
        }else{
            try {
                this.exibirAnimal = new ExibirAnimais();
            } catch (ClienteExp ex) {}
            lista = this.exibirAnimal.getAnimais();
        }

        return lista;

    }

    public ArrayList<Cliente> exibirPessoas() {
        ArrayList<Cliente> lista = new ArrayList<>();
        try {
            this.exibirPessoa = new ExibirPessoas();
            lista = this.exibirPessoa.getPessoas();
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

            
        } catch (ClienteExp ex) {
            Logger.getLogger(ClienteCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public void cadastrarCliente(int id, String nome, String cpf, String tipo, String telefone, String email,
            String especie) {

        try {
            cadastrarCliente = new CadastrarCliente(id, nome, cpf, tipo, telefone, email, especie);
        } catch (ClienteExp ex) {
            Logger.getLogger(ClienteCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    
    public Cliente  exibirCliente(int id) {
        exibirClientePorId = new ExibirClientePorId();
        return exibirClientePorId.obter(id);
    }

    public Cliente getUltimo() {

        try {
            this.exibir = new ExibirCliente();
        } catch (Exception ex) {

        }

        try {
            return exibir.getUltimo();
        } catch (Exception ex) {

        }

        return null;
    }

}