/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.business.cliente;

import com.mycompany.petshop.model.classes.Cliente;
import com.mycompany.petshop.model.exceptions.ClienteExp;
import com.mycompany.petshop.repository.ClienteRep;
import java.util.ArrayList;

/**
 *
 * @author Rhuan
 */
public class ExibirAnimais {

    private ArrayList<Cliente> animais = new ArrayList();
    
    public ExibirAnimais() throws ClienteExp {
        
        ClienteRep cr = new ClienteRep(); 
        
        ArrayList<Cliente> l =  cr.getAll();
        
        
        if(!l.isEmpty()){
            for (int i = 0; i < l.size(); i++) {

                if(l.get(i).getTipo().equalsIgnoreCase("animal")){
                    this.animais.add(l.get(i));
                }


            }
        }else{
            throw new ClienteExp("Não exitse clientes cadastrados!");
        }
        
    }

    public ArrayList<Cliente> getAnimais() {
        return this.animais;
    }
    
    
         
    
}
