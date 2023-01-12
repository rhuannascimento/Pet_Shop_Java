package com.mycompany.petshop.view.servico;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mycompany.petshop.business.item.ListarServicos;
import com.mycompany.petshop.controller.FuncionarioCtrl;
import com.mycompany.petshop.controller.ItemCtrl;
import com.mycompany.petshop.model.classes.Funcionario;
import com.mycompany.petshop.model.classes.Servico;

public class criarServico extends JFrame {
    private JTextField nome;
    private JTextField preco;
    private JTextField duracao;

    public criarServico() {
        super("Registrar Serviço");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void desenha(ArrayList<Servico> listaServicos, DefaultTableModel tableModel, Funcionario logado) {

        JPanel painel = new JPanel();
        painel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.insets = new Insets(3, 3, 3, 3); // espaçamento entre os componentes
        c.fill = GridBagConstraints.HORIZONTAL;

        c.gridwidth = 2;

        c.gridx = 0;
        c.gridy = 1;
        painel.add(new JLabel("Nome"), c);

        c.gridx = 0;
        c.gridy = 2;
        nome = new JTextField();
        painel.add(nome, c);

        c.gridx = 0;
        c.gridy = 3;
        painel.add(new JLabel("Duração"), c);

        c.gridx = 1;
        c.gridy = 4;
        duracao = new JTextField();
        painel.add(duracao, c);

        c.gridwidth = 2;

        c.gridx = 0;
        c.gridy = 5;
        painel.add(new JLabel("Preço"), c);

        c.gridx = 0;
        c.gridy = 6;
        preco = new JTextField();
        painel.add(preco, c);

        JButton cadastrar = new JButton("Registrar");
        JButton cancelar = new JButton("Cancelar");

        cadastrar.addActionListener(e -> {
            ItemCtrl ic = new ItemCtrl();

            ic.cadastraServico(0, nome.getText(), Float.parseFloat(preco.getText()), "servico",
                    true, Integer.parseInt(duracao.getText()), logado.getId());

            Servico novo = (Servico) ic.getUltimo();
            listaServicos.add(novo);

            tableModel
                    .addRow(new Object[] { novo.getNome(), novo.getDuracao(), novo.getPreco(), });

            this.dispose();
        });

        cancelar.addActionListener(e -> {
            this.dispose();
        });

        c.gridwidth = 1;

        c.gridx = 0;
        c.gridy = 13;

        painel.add(cadastrar, c);

        c.gridx = 1;
        c.gridy = 13;

        painel.add(cancelar, c);

        this.add(painel);
        this.setSize(300, 370);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
