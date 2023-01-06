package com.mycompany.petshop.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class Tela extends JFrame {

    private JPanel painelPrincipal;
    private JPanel painelHome;
    private JPanel painelFuncionarios;
    private JPanel painelClientes;
    private JPanel painelServicos;
    private JPanel painelMercadorias;

    public Tela() {
        super("Pet Shop");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void renderiza() {

        painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new CardLayout());

        // Cria páginas para cada funcionalidade
        desenhaPaginaHome();
        desenhaPaginaFuncionarios();
        desenhaPaginaClientes();
        desenhaPaginaServiços();
        desenhaPaginaMercadorias();

        desenhaBarraBotoes();

        this.setSize(700, 300);
        this.pack();
        this.setVisible(true);
    }

    public void desenhaPaginaHome() {
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setDividerLocation(420);
        splitPane.setResizeWeight(0);
        splitPane.setEnabled(false);
        splitPane.setPreferredSize(new Dimension(700, 300));

        painelHome = new JPanel();

        painelHome.add(splitPane, BorderLayout.CENTER);

        JPanel agenda = new JPanel();
        agenda.add(new JLabel("Agenda"));
        JButton agendarButton = new JButton("Novo Agendamento");
        agenda.add(agendarButton, BorderLayout.SOUTH);

        JPanel pendencias = new JPanel();
        pendencias.add(new JLabel("Pendências"));

        splitPane.setLeftComponent(agenda);
        splitPane.setRightComponent(pendencias);
        painelPrincipal.add(painelHome, "Home");
    }

    public void desenhaPaginaFuncionarios() {
        painelFuncionarios = new JPanel();
        painelFuncionarios.add(new JLabel("Funcionários"));
        painelPrincipal.add(painelFuncionarios, "Funcionários");
    }

    public void desenhaPaginaClientes() {
        painelClientes = new JPanel();
        painelClientes.add(new JLabel("Clientes"));
        painelPrincipal.add(painelClientes, "Clientes");
    }

    public void desenhaPaginaServiços() {
        painelServicos = new JPanel();
        painelServicos.add(new JLabel("Serviços"));
        painelPrincipal.add(painelServicos, "Serviços");
    }

    public void desenhaPaginaMercadorias() {
        painelMercadorias = new JPanel();
        painelMercadorias.add(new JLabel("Mercadorias"));
        painelPrincipal.add(painelMercadorias, "Mercadorias");
    }

    public void desenhaBarraBotoes() {
        // Barra de botões
        JPanel barraBotoes = new JPanel();

        JButton botaoHome = new JButton("Home");
        barraBotoes.add(botaoHome);

        JButton botaoFuncionarios = new JButton("Funcionários");
        barraBotoes.add(botaoFuncionarios);

        JButton botaoClientes = new JButton("Clientes");
        barraBotoes.add(botaoClientes);

        JButton botaoServicos = new JButton("Serviços");
        barraBotoes.add(botaoServicos);

        JButton botaoMercadorias = new JButton("Mercadorias");
        barraBotoes.add(botaoMercadorias);

        // Tamanho dos botões
        botaoHome.setPreferredSize(new Dimension(120, 25));
        botaoFuncionarios.setPreferredSize(new Dimension(120, 25));
        botaoClientes.setPreferredSize(new Dimension(120, 25));
        botaoServicos.setPreferredSize(new Dimension(120, 25));
        botaoMercadorias.setPreferredSize(new Dimension(120, 25));

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
        botaoServicos.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) painelPrincipal.getLayout();
            cardLayout.show(painelPrincipal, "Serviços");
        });
        botaoMercadorias.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) painelPrincipal.getLayout();
            cardLayout.show(painelPrincipal, "Mercadorias");
        });

        add(painelPrincipal, BorderLayout.CENTER);

        add(barraBotoes, BorderLayout.SOUTH);
    }
}
