/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.business.cliente;

import com.mycompany.petshop.model.classes.Cliente;
import com.mycompany.petshop.repository.ClienteRep;
import java.util.ArrayList;

/**
 *
 * @author Rhuan
 */
public class BuscarCliente {
    
    private Cliente f;
    
    public BuscarCliente(int id){
    
        ClienteRep fr = new ClienteRep();
        
        this.f = fr.getById(id); 
      
    }

    public Cliente getCliente() {
        return f;
    }
    
    
}
