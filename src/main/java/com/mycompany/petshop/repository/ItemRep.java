/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.repository;

import com.mycompany.petshop.model.classes.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
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
            
            String sql = "INSERT INTO item(nome, preco, tipo, disponivel, duracao, funcionario_id, estoque, categoria, utilidade, orientacao, especie, cor, tamanho, material, sabor, idade_recomendada, fornecedor) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
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
                ps.setString(17, null);              // fornecedor
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
                ps.setString(17, s.getFornecedor());// fornecedor
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
                ps.setString(11, s.getEspecie());             // especie
                ps.setString(12, null);             // cor
                ps.setString(13, null);             // tamanho
                ps.setString(14, s.getMaterial());             // material
                ps.setString(15, null);             // sabor
                ps.setInt(16, 0);                   // idade recomendada
                ps.setString(17, s.getFornecedor());// fornecedor
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
                ps.setString(12, s.getCor()); 
                ps.setString(13, s.getTamanho());             // tamanho
                ps.setString(14, null);             // material
                ps.setString(15, null);             // sabor
                ps.setInt(16, 0);                   // idade recomendada
                ps.setString(17, s.getFornecedor());// fornecedor
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
                ps.setInt(16, s.getIdade_recomendada());  
                ps.setString(17, s.getFornecedor());// fornecedor
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
        System.out.println("Atualizando o item "+valor);
        int affected = 0;
        
        try{
            Connection con = MyConnector.connect();
            
            String sql = "UPDATE item set nome = ?, preco = ?, tipo = ?, disponivel = ?, duracao = ?, funcionario_id = ?, estoque = ?, categoria = ?, utilidade = ?, orientacao = ?, especie = ?, cor = ?, tamanho = ?, material = ?, sabor = ?, idade_recomendada = ?, fornecedor = ? WHERE id = ?;";
            
            PreparedStatement ps = con.prepareStatement(sql);
            
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
                ps.setString(17, null);// fornecedor
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
                ps.setString(17, s.getFornecedor());// fornecedor
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
                ps.setString(14, s.getMaterial());             // material
                ps.setString(15, null);             // sabor
                ps.setInt(16, 0);                   // idade recomendada
                ps.setString(17, s.getFornecedor());// fornecedor
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
                ps.setString(12, s.getCor());             // cor
                ps.setString(13, s.getTamanho());             // tamanho
                ps.setString(14, null);             // material
                ps.setString(15, null);             // sabor
                ps.setInt(16, 0);                   // idade recomendada
                ps.setString(17, s.getFornecedor());// fornecedor
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
                ps.setInt(16, s.getIdade_recomendada());                   // idade recomendada
                ps.setString(17, s.getFornecedor());// fornecedor
            }
            
            ps.setInt(18, valor.getId());
            
            affected = ps.executeUpdate();
            
        }catch(SQLException e){
            e.printStackTrace();
        }catch(NullPointerException e){
            e.printStackTrace();
        }
        
        return affected != 0;
        
        
        
        
    }
    
    public boolean deleteById(int id) {
        System.out.println("Deletando o Item "+id);
        int affected = 0;
        
        try{
            Connection con = MyConnector.connect();
            
            String sql = "DELETE FROM item WHERE id = ?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, id);
            
            affected = ps.executeUpdate();
            
        }catch(SQLException e){
            e.printStackTrace();
        }catch(NullPointerException e){
            e.printStackTrace();
        }
        
        return affected != 0;
    }

    @Override
    public boolean delete(Item valor) {
        System.out.println("Deletando o item "+valor);
        int affected = 0;
        
        try{
            Connection con = MyConnector.connect();
            
            String sql = "DELETE FROM item WHERE id = ?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, valor.getId());
            
            affected = ps.executeUpdate();
            
            
        }catch(SQLException e){
            e.printStackTrace();
        }catch(NullPointerException e){
            e.printStackTrace();
        }
        
        return affected != 0;
    }

    @Override
    public ArrayList<Item> getAll() {
        System.out.println("Listando todos os items");
        ArrayList<Item> lista = new ArrayList<Item>();
        
        try{
            Connection con = MyConnector.connect();
            
            String sql = "SELECT * FROM item;";
            
            PreparedStatement ps = con.prepareStatement(sql);
                        
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                float preco = rs.getFloat("preco");
                String tipo = rs.getString("tipo");
                boolean disponivel = rs.getBoolean("disponivel");
                int duracao = rs.getInt("duracao");
                int funcionario_id = rs.getInt("funcionario_id");
                int estoque = rs.getInt("estoque");
                String categoria = rs.getString("categoria");
                String fornecedor = rs.getString("fornecedor");
                String utilidade = rs.getString("utilidade");
                String orientacao = rs.getString("orientacao");
                String especie = rs.getString("especie");
                String cor = rs.getString("cor");
                String tamanho = rs.getString("tamanho");
                String material = rs.getString("material");
                String sabor = rs.getString("sabor");
                int idade_recomendada = rs.getInt("idade_recomendada");
                Item i = null;
                if(categoria.equalsIgnoreCase("servico")) i = new Servico(id, nome, preco, tipo, disponivel, duracao, funcionario_id);
                if(categoria.equalsIgnoreCase("brinquedo")) i = new Brinquedo(estoque, fornecedor, id, nome, preco, tipo, disponivel, especie, material);
                if(categoria.equalsIgnoreCase("roupa")) i = new Roupa(estoque, fornecedor, id, nome, preco, tipo, disponivel, tamanho, especie, cor);
                if(categoria.equalsIgnoreCase("remedio")) i = new Remedio(estoque, fornecedor, id, nome, preco, tipo, disponivel, utilidade, orientacao);
                if(categoria.equalsIgnoreCase("racao")) i = new Racao(estoque, fornecedor, id, nome, preco, tipo, disponivel, especie, sabor, idade_recomendada);
                
                lista.add(i);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }catch(NullPointerException e){
            e.printStackTrace();
        }
        
        return lista;
    }

    @Override
    public Item getById(int id_busca) {
        System.out.println("Listando item de id "+id_busca);
        ArrayList<Item> lista = new ArrayList<Item>();
        
        try{
            Connection con = MyConnector.connect();
            
            String sql = "SELECT * FROM item WHERE id = ?;";
            
            PreparedStatement ps = con.prepareStatement(sql);
                        
            ps.setInt(1, id_busca);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                float preco = rs.getFloat("preco");
                String tipo = rs.getString("tipo");
                boolean disponivel = rs.getBoolean("disponivel");
                int duracao = rs.getInt("duracao");
                int funcionario_id = rs.getInt("funcionario_id");
                int estoque = rs.getInt("estoque");
                String categoria = rs.getString("categoria");
                String fornecedor = rs.getString("fornecedor");
                String utilidade = rs.getString("utilidade");
                String orientacao = rs.getString("orientacao");
                String especie = rs.getString("especie");
                String cor = rs.getString("cor");
                String tamanho = rs.getString("tamanho");
                String material = rs.getString("material");
                String sabor = rs.getString("sabor");
                int idade_recomendada = rs.getInt("idade_recomendada");
                Item i = null;
                if(categoria.equalsIgnoreCase("servico")) i = new Servico(id, nome, preco, tipo, disponivel, duracao, funcionario_id);
                if(categoria.equalsIgnoreCase("brinquedo")) i = new Brinquedo(estoque, fornecedor, id, nome, preco, tipo, disponivel, especie, material);
                if(categoria.equalsIgnoreCase("roupa")) i = new Roupa(estoque, fornecedor, id, nome, preco, tipo, disponivel, tamanho, especie, cor);
                if(categoria.equalsIgnoreCase("remedio")) i = new Remedio(estoque, fornecedor, id, nome, preco, tipo, disponivel, utilidade, orientacao);
                if(categoria.equalsIgnoreCase("racao")) i = new Racao(estoque, fornecedor, id, nome, preco, tipo, disponivel, especie, sabor, idade_recomendada);
                
                lista.add(i);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }catch(NullPointerException e){
            e.printStackTrace();
        }
        System.out.println(lista);
        return lista.get(0);
    }

    public ArrayList<Item> getByNome(String nome_busca) {
        System.out.println("Listando item de nome "+nome_busca);
        ArrayList<Item> lista = new ArrayList<Item>();
        
        try{
            Connection con = MyConnector.connect();
            
            String sql = "SELECT * FROM item WHERE nome like '%" + nome_busca.toLowerCase() + "%';";
            
            Statement ps = con.createStatement();
            
            ResultSet rs = ps.executeQuery(sql);
            
            
            while(rs.next()){                
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                float preco = rs.getFloat("preco");
                String tipo = rs.getString("tipo");
                boolean disponivel = rs.getBoolean("disponivel");
                int duracao = rs.getInt("duracao");
                int funcionario_id = rs.getInt("funcionario_id");
                int estoque = rs.getInt("estoque");
                String categoria = rs.getString("categoria");
                String fornecedor = rs.getString("fornecedor");
                String utilidade = rs.getString("utilidade");
                String orientacao = rs.getString("orientacao");
                String especie = rs.getString("especie");
                String cor = rs.getString("cor");
                String tamanho = rs.getString("tamanho");
                String material = rs.getString("material");
                String sabor = rs.getString("sabor");
                int idade_recomendada = rs.getInt("idade_recomendada");
                Item i = null;
                if(categoria.equalsIgnoreCase("servico")) i = new Servico(id, nome, preco, tipo, disponivel, duracao, funcionario_id);
                if(categoria.equalsIgnoreCase("brinquedo")) i = new Brinquedo(estoque, fornecedor, id, nome, preco, tipo, disponivel, especie, material);
                if(categoria.equalsIgnoreCase("roupa")) i = new Roupa(estoque, fornecedor, id, nome, preco, tipo, disponivel, tamanho, especie, cor);
                if(categoria.equalsIgnoreCase("remedio")) i = new Remedio(estoque, fornecedor, id, nome, preco, tipo, disponivel, utilidade, orientacao);
                if(categoria.equalsIgnoreCase("racao")) i = new Racao(estoque, fornecedor, id, nome, preco, tipo, disponivel, especie, sabor, idade_recomendada);
                
                lista.add(i);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }catch(NullPointerException e){
            e.printStackTrace();
        }
        
        return lista;
    }
    
    public boolean deleteAll() {
        System.out.println("deletando os items");
        int affected = 0;
        
        try{
            Connection con = MyConnector.connect();
            
            String sql = "DELETE FROM item;";
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            affected = ps.executeUpdate();
            
        }catch(SQLException e){
            e.printStackTrace();
        }catch(NullPointerException e){
            e.printStackTrace();
        }
        
        return affected != 0;
    }
    
}
