package com.mycompany.petshop.controller;

import com.mycompany.petshop.model.classes.*;
import com.mycompany.petshop.business.item.*;
import java.util.ArrayList;

public class ItemCtrl {
    private ExibirItem exibir;
    private ListarProdutos exibirProdutos;
    private ListarServicos exibirServicos;
    private CadastrarRacao cadastrarRacao;
    private CadastrarBrinquedo cadastrarBrinquedo;
    private CadastrarRoupa cadastrarRoupa;
    private CadastrarRemedio cadastrarRemedio;
    private ExcluirItem excluirItem;
    private AtualizarRacao atualizarRacao;
    private AtualizarBrinquedo atualizarBrinquedo;
    private AtualizarRoupa atualizarRoupa;
    private AtualizarRemedio atualizarRemedio;
    private CadastrarServico cadastrarServico;
    private AtualizarServico atualizarServico;

    public ItemCtrl() {
    }

    public ArrayList<Item> exibirProdutos() {
        this.exibirProdutos = new ListarProdutos();

        ArrayList<Item> lista = this.exibirProdutos.getProdutos();

        // String col[] = { "ID", "Nome", "cpf", "especie" };

        // DefaultTableModel dtm = new DefaultTableModel(col, 0);

        // try {
        // ArrayList<Cliente> lista = this.exibirAnimal.getAnimais();

        // for (Cliente c : lista) {
        // Object[] data = { c.getId(), c.getNome(), c.getCpf(),
        // ((Animal)c).getEspecie() };
        // dtm.addRow(data);
        // }

        // } catch (Exception ex) {
        // ex.printStackTrace();
        // }

        return lista;

    }
    
    public Item exibirProdutos(int id) {
        this.exibir = new ExibirItem();

        Item lista = this.exibir.getProdutoById(id);

        

        return lista;

    }

    public ArrayList<Item> exibirServicos() {
        this.exibirServicos = new ListarServicos();

        ArrayList<Item> lista = this.exibirServicos.getServicos();

        // String col[] = { "ID", "Nome", "cpf", "especie" };

        // DefaultTableModel dtm = new DefaultTableModel(col, 0);

        // try {
        // ArrayList<Cliente> lista = this.exibirAnimal.getAnimais();

        // for (Cliente c : lista) {
        // Object[] data = { c.getId(), c.getNome(), c.getCpf(),
        // ((Animal)c).getEspecie() };
        // dtm.addRow(data);
        // }

        // } catch (Exception ex) {
        // ex.printStackTrace();
        // }

        return lista;

    }

    public void cadastrarRacao(int estoque, String fornecedor, int id, String nome, float preco, String tipo,
            boolean disponivel, String especie, String sabor, int idade_recomendada) {

        cadastrarRacao = new CadastrarRacao(estoque, fornecedor, id, nome, preco, tipo, disponivel, especie, sabor,
                idade_recomendada);
    }

    public void atualizarRacao(int estoque, String fornecedor, int id, String nome, float preco, String tipo,
            boolean disponivel, String especie, String sabor, int idade_recomendada) {

        atualizarRacao = new AtualizarRacao(estoque, fornecedor, id, nome, preco, tipo, disponivel, especie, sabor,
                idade_recomendada);

    }
    
    public void atualizarRacao(Racao r) {

        atualizarRacao = new AtualizarRacao(r);

    }

    public void cadastrarBrinquedo(int estoque, String fornecedor, int id, String nome, float preco, String tipo,
            boolean disponivel, String especie, String material) {

        cadastrarBrinquedo = new CadastrarBrinquedo(estoque, fornecedor, id, nome, preco, tipo, disponivel, especie,
                material);
    }

    public void atualizarBrinquedo(int estoque, String fornecedor, int id, String nome, float preco, String tipo,
            boolean disponivel, String especie, String material) {
        
        atualizarBrinquedo = new AtualizarBrinquedo(estoque, fornecedor, id, nome, preco, tipo, disponivel, especie,
                material);
    }
    
    public void atualizarBrinquedo(Brinquedo b) {
        atualizarBrinquedo = new AtualizarBrinquedo(b);
    }

    public void cadastrarRoupa(int estoque, String fornecedor, int id, String nome, float preco, String tipo,
            boolean disponivel, String tamanho, String especie, String cor) {

        cadastrarRoupa = new CadastrarRoupa(estoque, fornecedor, id, nome, preco, tipo, disponivel, tamanho, especie,
                cor);
    }

    public void atualizarRoupa(int estoque, String fornecedor, int id, String nome, float preco, String tipo,
            boolean disponivel, String tamanho, String especie, String cor) {

        atualizarRoupa = new AtualizarRoupa(estoque, fornecedor, id, nome, preco, tipo, disponivel, tamanho, especie,
                cor);
    }
    
    public void atualizarRoupa(Roupa r) {

        atualizarRoupa = new AtualizarRoupa(r);
    }

    public void cadastraRemedio(int estoque, String fornecedor, int id, String nome, float preco, String tipo,
            boolean disponivel, String utilidade, String orientacao) {

        cadastrarRemedio = new CadastrarRemedio(estoque, fornecedor, id, nome, preco, tipo, disponivel, utilidade,
                orientacao);
    }

    public void atualizarRemedio(int estoque, String fornecedor, int id, String nome, float preco, String tipo,
            boolean disponivel, String utilidade, String orientacao) {

        atualizarRemedio = new AtualizarRemedio(estoque, fornecedor, id, nome, preco, tipo, disponivel, utilidade,
                orientacao);

    }
    
    public void atualizarRemedio(Remedio r) {

        atualizarRemedio = new AtualizarRemedio(r);

    }

    public void cadastraServico(int id, String nome, float preco, String tipo, boolean disponivel, int duracao,
            int idResponsavel) {

        cadastrarServico = new CadastrarServico(id, nome, preco, tipo, disponivel, duracao, idResponsavel);
    }

    public void atualizarServico(int id, String nome, float preco, String tipo, boolean disponivel, int duracao,
            int idResponsavel) {

        atualizarServico = new AtualizarServico(id, nome, preco, tipo, disponivel, duracao, idResponsavel);

    }
    
    public void excluirItem(int id) {
        excluirItem = new ExcluirItem(id);
    }

    public void atualizarServico(String text, String text2, String text3) {
    }

    public Item getUltimo() {

        try {
            this.exibir = new ExibirItem();
        } catch (Exception ex) {

        }

        try {
            return exibir.getUltimo();
        } catch (Exception ex) {

        }

        return null;
    }

}
