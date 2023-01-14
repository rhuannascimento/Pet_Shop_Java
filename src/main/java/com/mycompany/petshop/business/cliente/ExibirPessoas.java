/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.business.cliente;

import com.mycompany.petshop.model.classes.Cliente;
import com.mycompany.petshop.model.classes.Pessoa;
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
public class ExibirPessoas {
    
    private ArrayList<Cliente> pessoas = new ArrayList();
    
    
    public ExibirPessoas() throws ClienteExp {
        
        ClienteRep cr = new ClienteRep(); 
        
        ArrayList<Cliente> l =  cr.getAll();
        
        
        if(!l.isEmpty()){
            for (int i = 0; i < l.size(); i++) {

                if(l.get(i) instanceof Pessoa){
                    this.pessoas.add(l.get(i));
                }


            }
        }else{
            throw new ClienteExp("Não exitse clientes cadastrados!");
        }
        
    }

    public ArrayList<Cliente> getPessoas() {
        return this.pessoas;
    }
    
    
}
