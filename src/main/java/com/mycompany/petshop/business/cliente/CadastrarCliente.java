/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.business.cliente;
import com.mycompany.petshop.model.classes.Animal;
import com.mycompany.petshop.model.classes.Cliente;
import com.mycompany.petshop.model.classes.Pessoa;
import com.mycompany.petshop.repository.ClienteRep;
import java.sql.Time;
import java.util.ArrayList;
/**
 *
 * @author beort
 */
public class CadastrarCliente {
    
    public CadastrarCliente(int id, String nome, String cpf, String tipo, String telefone,String email, String especie) throws ClienteExp{
        Cliente c;
        if(tipo.equals("animal")){
            c = new Animal(id,nome,cpf,especie);
        }else{
            c = new Pessoa(id,nome,cpf,email,telefone);     
        }
        
        ClienteRep cr = new ClienteRep();
        ArrayList<Cliente> clienteList = cr.getByCpf(c.getCpf());
        
       if(!clienteList.isEmpty() && c.getTipo() == "pessoa"){
           throw new ClienteExp("Cliente já cadastrado!");
       }
       cr.insertOne(c);
    }
}
