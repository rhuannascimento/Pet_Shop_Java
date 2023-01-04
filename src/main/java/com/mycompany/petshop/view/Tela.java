package com.mycompany.petshop.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tela extends JFrame {

    private JPanel telaInicial;

    public Tela() {
        super("Pet Shop");
    }

    public void renderiza() {
        this.setSize(700, 400);

        this.telaInicial = new JPanel();

        this.telaInicial.setLayout(new BorderLayout());

        desenhaTelaInicial();

        this.add(this.telaInicial);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);

        this.repaint();
    }

    public void desenhaTelaInicial() {
        JPanel barraBotoes = new JPanel();
        JButton clientes = new JButton("Clientes");
        JButton itens = new JButton("Itens");
        JButton funcionarios = new JButton("Funcionários");

        clientes.setPreferredSize(new Dimension(120, 25));
        itens.setPreferredSize(new Dimension(120, 25));
        funcionarios.setPreferredSize(new Dimension(120, 25));

        barraBotoes.add(funcionarios);
        barraBotoes.add(clientes);
        barraBotoes.add(itens);

        telaInicial.add(barraBotoes, BorderLayout.SOUTH);
    }

}
