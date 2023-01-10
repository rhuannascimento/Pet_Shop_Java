/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.business.cliente;

import com.mycompany.petshop.model.classes.Cliente;
import com.mycompany.petshop.model.classes.Pessoa;
import com.mycompany.petshop.repository.ClienteRep;

/**
 *
 * @author Rhuan
 */
public class AtualizarPessoa {
    public AtualizarPessoa (int id, String nome, String cpf, String email, String telefone){
        ClienteRep cr = new ClienteRep();
        
        Cliente pessoa = new Pessoa(id, nome, cpf, email, telefone);
        
        cr.update(pessoa);
    }
}
