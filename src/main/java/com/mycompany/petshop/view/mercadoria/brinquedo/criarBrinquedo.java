package com.mycompany.petshop.view.mercadoria.brinquedo;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class criarBrinquedo extends JFrame {

    private JTextField nome;
    private JComboBox cargo;
    private JTextField login;
    private JTextField senha;

    public criarBrinquedo() {
        super("Registrar brinquedo");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void desenha() {
        JPanel painel = new JPanel();
        painel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.insets = new Insets(3, 3, 3, 3); // espaçamento entre os componentes
        c.fill = GridBagConstraints.HORIZONTAL;

        c.gridwidth = 2;

        c.gridx = 0;
        c.gridy = 0;
        painel.add(new JLabel("Nome"), c);

        c.gridx = 0;
        c.gridy = 1;
        nome = new JTextField();
        painel.add(nome, c);

        c.gridx = 0;
        c.gridy = 2;
        painel.add(new JLabel("Cargo"), c);

        c.gridx = 0;
        c.gridy = 3;
        cargo = new JComboBox();
        painel.add(cargo, c);

        c.gridx = 0;
        c.gridy = 4;
        painel.add(new JLabel("Login"), c);

        c.gridx = 0;
        c.gridy = 5;
        login = new JTextField();
        painel.add(login, c);

        c.gridx = 0;
        c.gridy = 6;
        painel.add(new JLabel("Senha"), c);

        c.gridx = 0;
        c.gridy = 7;
        senha = new JTextField();
        painel.add(senha, c);

        JButton cadastrar = new JButton("Cadastrar");
        JButton cancelar = new JButton("Cancelar");

        // IMPLEMENTAÇÃO CONTROLLER
        // cadastrar.addActionListener(cadastrarFuncionario(this));
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

    public JTextField getLogin() {
        return login;
    }

    public JTextField getSenha() {
        return senha;
    }

}
