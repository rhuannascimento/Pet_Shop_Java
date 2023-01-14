/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.business.cliente;

import com.mycompany.petshop.model.classes.Animal;
import com.mycompany.petshop.model.classes.Cliente;
import com.mycompany.petshop.model.exceptions.ClienteExp;
import com.mycompany.petshop.repository.ClienteRep;
import java.util.ArrayList;
/*
    Caio Henrique Vieira Costa - 202176020
    Rhuan Nascimento - 202176033
    Bernardo Ortiz - ?
    Lucas Duarte - 202176012
*/
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
    
    public BuscarCliente(){ 
    }

    public Cliente getCliente() {
        return f;
    }
    
    public ArrayList<Cliente> obterAnimaisPorCpf(String cpf) throws ClienteExp{
        ClienteRep fr = new ClienteRep();
        ArrayList<Cliente> l = fr.getByCpf(cpf);
        
        ArrayList<Cliente> l2 = new ArrayList<>();
        
        if (!l.isEmpty()) {
            for (int i = 0; i < l.size(); i++) {
                if (l.get(i) instanceof Animal) {
                    l2.add(l.get(i));
                }

            }
        } else {
            throw new ClienteExp("Não exitse clientes cadastrados!");
        }
        return l2;
        
    }
    
    
}
