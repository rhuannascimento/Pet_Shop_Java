/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.repository;

import com.mycompany.petshop.model.classes.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author viier
 */
public class ItemRep implements DataAcessObject<Item> {

    @Override
    public boolean insertOne(Item valor) {
        System.out.println("Inserindo o item "+valor);
        PreparedStatement ps = null;
        Connection con = null;
        int affected = 0;
        try{
            con = MyConnector.connect();
            
            String sql = "INSERT INTO item(nome, preco, tipo, disponivel, duracao, funcionario_id, estoque, categoria, utilidade, orientacao, especie, cor, tamanho, material, sabor, idade_recomendada) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            ps = con.prepareStatement(sql);

            if(valor.getCategoria().equalsIgnoreCase("servico")){
                Servico s = (Servico) valor;

                ps.setString(1, s.getNome());       // nome
                ps.setFloat(2, s.getPreco());       // preco
                ps.setString(3, s.getTipo());       // tipo
                ps.setBoolean(4, s.isDisponivel()); // disponivel
                ps.setInt(5, s.getDuracao());       // duracao
                ps.setInt(6, s.getIdResponsavel()); // responsavel
                ps.setInt(7, -1);                   // estoque - infinito
                ps.setString(8, s.getCategoria());  // categoria
                ps.setString(9, null);              // utilidade
                ps.setString(10, null);             // orientacao
                ps.setString(11, null);             // especie
                ps.setString(12, null);             // cor
                ps.setString(13, null);             // tamanho
                ps.setString(14, null);             // material
                ps.setString(15, null);             // sabor
                ps.setInt(16, 0);                   // idade recomendada
            }
            if(valor.getCategoria().equalsIgnoreCase("remedio")){
                Remedio s = (Remedio) valor;

                ps.setString(1, s.getNome());       // nome
                ps.setFloat(2, s.getPreco());       // preco
                ps.setString(3, s.getTipo());       // tipo
                ps.setBoolean(4, s.isDisponivel()); // disponivel
                ps.setInt(5, -1);       // duracao
                ps.setInt(6, -1); // responsavel
                ps.setInt(7, s.getEstoque());                   // estoque
                ps.setString(8, s.getCategoria());  // categoria
                ps.setString(9, s.getUtilidade());              // utilidade
                ps.setString(10, s.getOrientacao());             // orientacao
                ps.setString(11, null);             // especie
                ps.setString(12, null);             // cor
                ps.setString(13, null);             // tamanho
                ps.setString(14, null);             // material
                ps.setString(15, null);             // sabor
                ps.setInt(16, 0);                   // idade recomendada
            }
            if(valor.getCategoria().equalsIgnoreCase("brinquedo")){
                Brinquedo s = (Brinquedo) valor;

                ps.setString(1, s.getNome());       // nome
                ps.setFloat(2, s.getPreco());       // preco
                ps.setString(3, s.getTipo());       // tipo
                ps.setBoolean(4, s.isDisponivel()); // disponivel
                ps.setInt(5, -1);       // duracao
                ps.setInt(6, -1); // responsavel
                ps.setInt(7, s.getEstoque());                   // estoque - infinito
                ps.setString(8, s.getCategoria());  // categoria
                ps.setString(9, null);              // utilidade
                ps.setString(10, null);             // orientacao
                ps.setString(11, null);             // especie
                ps.setString(12, null);             // cor
                ps.setString(13, null);             // tamanho
                ps.setString(14, null);             // material
                ps.setString(15, null);             // sabor
                ps.setInt(16, 0);                   // idade recomendada
            }
            if(valor.getCategoria().equalsIgnoreCase("roupa")){
                Roupa s = (Roupa) valor;

                ps.setString(1, s.getNome());       // nome
                ps.setFloat(2, s.getPreco());       // preco
                ps.setString(3, s.getTipo());       // tipo
                ps.setBoolean(4, s.isDisponivel()); // disponivel
                ps.setInt(5, -1);       // duracao
                ps.setInt(6, -1); // responsavel
                ps.setInt(7, s.getEstoque());                   // estoque - infinito
                ps.setString(8, s.getCategoria());  // categoria
                ps.setString(9, null);              // utilidade
                ps.setString(10, null);             // orientacao
                ps.setString(11, s.getEspecie());             // especie
                ps.setString(12, null);             // cor
                ps.setString(13, s.getTamanho());             // tamanho
                ps.setString(14, null);             // material
                ps.setString(15, null);             // sabor
                ps.setInt(16, 0);                   // idade recomendada
            }
            if(valor.getCategoria().equalsIgnoreCase("racao")){
                Racao s = (Racao) valor;

                ps.setString(1, s.getNome());       // nome
                ps.setFloat(2, s.getPreco());       // preco
                ps.setString(3, s.getTipo());       // tipo
                ps.setBoolean(4, s.isDisponivel()); // disponivel
                ps.setInt(5, -1);       // duracao
                ps.setInt(6, -1); // responsavel
                ps.setInt(7, s.getEstoque());                   // estoque - infinito
                ps.setString(8, s.getCategoria());  // categoria
                ps.setString(9, null);              // utilidade
                ps.setString(10, null);             // orientacao
                ps.setString(11, s.getEspecie());             // especie
                ps.setString(12, null);             // cor
                ps.setString(13, null);             // tamanho
                ps.setString(14, null);             // material
                ps.setString(15, s.getSabor());             // sabor
                ps.setInt(16, 0);                   // idade recomendada
            }
            
            
            
            affected = ps.executeUpdate();
            
            
        }catch(SQLException e){
            e.printStackTrace();
        }catch(NullPointerException e){
            e.printStackTrace();
        }
        
        return affected != 0;
    }

    @Override
    public boolean update(Item valor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(Item valor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Item> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Item getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Item> getByNome(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
