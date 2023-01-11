/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.petshop.business.cliente;
import com.mycompany.petshop.model.classes.Animal;
import com.mycompany.petshop.model.classes.Cliente;
import com.mycompany.petshop.repository.ClienteRep;

/**
 *
 * @author beort
 */
public class AtualizarAnimal {
    public AtualizarAnimal (int id, String nome, String cpf, String especie){
        ClienteRep cr = new ClienteRep();
        
        Cliente animal = new Animal(id, nome, cpf, especie);
        
        cr.update(animal);
    }
}
