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
public class AtualizarCliente {
    public AtualizarCliente (Cliente cliente){
        ClienteRep cr = new ClienteRep();
        cr.update(cliente);
    }
}
