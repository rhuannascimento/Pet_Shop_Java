package com.mycompany.petshop.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tela extends JFrame {

    private JPanel painelPrincipal;
    private JPanel painelHome;
    private JPanel painelFuncionarios;
    private JPanel painelClientes;
    private JPanel painelItens;

    public Tela() {
        super("Pet Shop");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void renderiza() {

        painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new CardLayout());

        // Cria páginas para cada classe
        painelHome = new JPanel();
        painelHome.add(new JLabel("Home"));
        painelPrincipal.add(painelHome, "Home");

        painelFuncionarios = new JPanel();
        painelFuncionarios.add(new JLabel("Funcionários"));
        painelPrincipal.add(painelFuncionarios, "Funcionários");

        painelClientes = new JPanel();
        painelClientes.add(new JLabel("Clientes"));
        painelPrincipal.add(painelClientes, "Clientes");

        painelItens = new JPanel();
        painelItens.add(new JLabel("Itens"));
        painelPrincipal.add(painelItens, "Itens");

        // Barra de botões
        JPanel barraBotoes = new JPanel();

        JButton botaoHome = new JButton("Home");
        barraBotoes.add(botaoHome);

        JButton botaoFuncionarios = new JButton("Funcionários");
        barraBotoes.add(botaoFuncionarios);

        JButton botaoClientes = new JButton("Clientes");
        barraBotoes.add(botaoClientes);

        JButton botaoItens = new JButton("Itens");
        barraBotoes.add(botaoItens);

        // Tamanho dos botões
        botaoHome.setPreferredSize(new Dimension(120, 25));
        botaoFuncionarios.setPreferredSize(new Dimension(120, 25));
        botaoClientes.setPreferredSize(new Dimension(120, 25));
        botaoItens.setPreferredSize(new Dimension(120, 25));

        // Troca de página quando clica nos botões
        botaoHome.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) painelPrincipal.getLayout();
            cardLayout.show(painelPrincipal, "Home");
        });
        botaoFuncionarios.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) painelPrincipal.getLayout();
            cardLayout.show(painelPrincipal, "Funcionários");
        });
        botaoClientes.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) painelPrincipal.getLayout();
            cardLayout.show(painelPrincipal, "Clientes");
        });
        botaoItens.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) painelPrincipal.getLayout();
            cardLayout.show(painelPrincipal, "Itens");
        });

        add(painelPrincipal, BorderLayout.CENTER);

        add(barraBotoes, BorderLayout.SOUTH);

        this.setSize(700, 400);
        setVisible(true);
    }
}
