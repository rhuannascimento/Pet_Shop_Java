/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.business.cliente;
/*
    Caio Henrique Vieira Costa - 202176020
    Rhuan Nascimento - 202176033
    Bernardo Ortiz - ?
    Lucas Duarte - 202176012
*/
import com.mycompany.petshop.model.classes.Cliente;
import com.mycompany.petshop.repository.ClienteRep;

/**
 *
 * @author viier
 */
public class ExibirClientePorId {
    public ExibirClientePorId(){
        
    }
    
    public Cliente obter(int id){
        ClienteRep cr = new ClienteRep();
      
        return cr.getById(id);
    }
}
