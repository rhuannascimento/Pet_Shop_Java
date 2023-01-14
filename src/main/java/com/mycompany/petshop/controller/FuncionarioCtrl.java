/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.controller;

import com.mycompany.petshop.business.funcionarios.*;
import com.mycompany.petshop.model.classes.Funcionario;
import com.mycompany.petshop.model.exceptions.FuncionarioExp;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author viier
 *//*
    Caio Henrique Vieira Costa - 202176020
    Rhuan Nascimento - 202176033
    Bernardo Ortiz - ?
    Lucas Duarte - 202176012
*/
public class FuncionarioCtrl {
    private boolean isGerente;
    private ExibirFuncionario exibir;
    private BuscarFuncionario buscar;
    private CadastrarFuncionario cadastrar;
    private ExcluirFuncionario excluir;
    private AtualizarFuncionario atualizar;
 
    
    
    
    public FuncionarioCtrl(Funcionario logado) {
        this.isGerente = logado.getCargo().equalsIgnoreCase("gerente");
    }
    
    

    public Funcionario getUltimo(){
        
        try{
            this.exibir = new ExibirFuncionario();
        }catch(Exception ex){
                                   
        }
        
        try{
            return  exibir.getUltimo();
        }catch(Exception ex){
            
        }    
         
        return null;
    }
    
    public ArrayList<Funcionario> exibir() {
        

        this.exibir = new ExibirFuncionario();

        ArrayList<Funcionario> lista = this.exibir.getFuncionarios();

        /*
         * String col[] = { "ID", "Nome", "Horário de início", "Horário de fim",
         * "Cargo", "Username" };
         * 
         * DefaultTableModel dtm = new DefaultTableModel(col, 0);
         * 
         * try {
         * ArrayList<Funcionario> lista = this.exibir.getFuncionarios();
         * 
         * for (Funcionario f : lista) {
         * Object[] data = { f.getId(), f.getNome(), f.getStartTime(), f.getEndTime(),
         * f.getCargo(),
         * f.getUsername() };
         * dtm.addRow(data);
         * }
         * 
         * } catch (Exception ex) {
         * ex.printStackTrace();
         * }
         */

        return lista;

    }

    public Funcionario buscar(String username) {
        try {
            this.buscar = new BuscarFuncionario(username);

        } catch (FuncionarioExp ex) {
            ex.printStackTrace();
        }
        return this.buscar.getFuncionario();
    }

    public boolean cadastrar(int id, String nome, String inicio, String fim, String cargo, String username,
            String password) {
        Time startTime = Time.valueOf(inicio);
        Time endTime = Time.valueOf(fim);
        try {
            Funcionario f = new Funcionario(id, nome, startTime, endTime, cargo, username, password);
            cadastrar = new CadastrarFuncionario(f, this.isGerente);
        } catch (FuncionarioExp ex) {
            ex.printStackTrace();
        }

        return cadastrar.status();

    }

    public boolean excluir(int id) {
        try {
            excluir = new ExcluirFuncionario(id, this.isGerente);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return excluir.status();
    }

    public boolean atualizar(int id, String nome, String inicio, String fim, String cargo, String username,
            String password) {
                
        boolean res = false;
        
        if(password != null && !password.equalsIgnoreCase("")){
            Time startTime = Time.valueOf(inicio);
            Time endTime = Time.valueOf(fim);
            try {
                Funcionario f = new Funcionario(id, nome, startTime, endTime, cargo, username, password);
                atualizar = new AtualizarFuncionario(f, this.isGerente);
                res = atualizar.status();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return res;
    }
    
    public Funcionario exibirPorId(int id){
        
        try{
            this.exibir = new ExibirFuncionario();
        }catch(Exception ex){
                                   
        }
        
        try{
            return  exibir.porId(id);
        }catch(Exception ex){
            
        }    
         
        return null;
    }
}
