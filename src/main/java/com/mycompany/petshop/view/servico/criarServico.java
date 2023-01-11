package com.mycompany.petshop.view.servico;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class criarServico extends JFrame {

    private JTextField nome;
    private JTextField especie;
    private JTextField idade;
    private JTextField cpf;

    public criarServico() {
        super("Nova ficha");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void desenha() {

        JPanel painel = new JPanel();
        painel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.insets = new Insets(3, 3, 3, 3); // espaçamento entre componentes
        c.fill = GridBagConstraints.HORIZONTAL;

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        painel.add(new JLabel("Nome"), c);

        c.gridx = 0;
        c.gridy = 1;
        nome = new JTextField();
        painel.add(nome, c);

        c.gridx = 0;
        c.gridy = 2;
        painel.add(new JLabel("Espécie"), c);

        c.gridx = 0;
        c.gridy = 3;
        especie = new JTextField();
        painel.add(especie, c);

        c.gridx = 0;
        c.gridy = 4;
        painel.add(new JLabel("Idade (em anos)"), c);

        c.gridx = 0;
        c.gridy = 5;
        idade = new JTextField();
        painel.add(idade, c);

        c.gridx = 0;
        c.gridy = 6;
        painel.add(new JLabel("CPF do dono"), c);

        c.gridx = 0;
        c.gridy = 7;
        cpf = new JTextField();
        painel.add(cpf, c);

        JButton cadastrar = new JButton("Cadastrar");
        JButton cancelar = new JButton("Cancelar");

        // IMPLEMENTAÇÃO CONTROLLER
        // FuncionarioCtrl f = new FuncionarioCtrl();
        // f.cadastrar(passarJTextFields);
        // cadastrar.addActionListener(cadastrarServico(this));
        cancelar.addActionListener(e -> {
            this.dispose();
        });

        c.gridwidth = 1;

        c.gridx = 0;
        c.gridy = 8;
        painel.add(cadastrar, c);

        c.gridx = 1;
        c.gridy = 8;
        painel.add(cancelar, c);

        this.add(painel);
        this.setSize(300, 300);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public JTextField getNome() {
        return nome;
    }

    public JTextField getEspecie() {
        return especie;
    }

    public JTextField getIdade() {
        return idade;
    }

    public JTextField getCpf() {
        return cpf;
    }
}
