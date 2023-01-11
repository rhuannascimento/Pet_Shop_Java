package com.mycompany.petshop.view.funcionario;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mycompany.petshop.model.classes.Agendamento;

public class editarFuncionario extends JFrame {
    private JTextField id;
    private JTextField nome;
    private JTextField startTime;
    private JTextField endTime;
    private JComboBox cargo;
    private JTextField login;
    private JPasswordField senha;

    public editarFuncionario(Agendamento selected) {
        super(selected.getA());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    public void desenha(Agendamento selected) {
        JPanel painel = new JPanel();
        painel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.insets = new Insets(3, 3, 3, 3); // espaçamento entre os componentes
        c.fill = GridBagConstraints.HORIZONTAL;

        c.gridwidth = 3;

        c.gridx = 0;
        c.gridy = 0;
        painel.add(new JLabel("ID"), c);

        c.gridx = 0;
        c.gridy = 1;
        id = new JTextField();
        id.setEditable(false);
        painel.add(id, c);

        c.gridx = 0;
        c.gridy = 2;
        painel.add(new JLabel("Nome"), c);

        c.gridx = 0;
        c.gridy = 3;
        nome = new JTextField();
        painel.add(nome, c);

        c.gridwidth = 1;

        c.gridx = 0;
        c.gridy = 4;
        painel.add(new JLabel("Início exp."), c);

        c.gridx = 2;
        c.gridy = 4;
        painel.add(new JLabel("Fim exp."), c);

        c.gridx = 0;
        c.gridy = 5;
        startTime = new JTextField();
        painel.add(startTime, c);

        c.gridx = 2;
        c.gridy = 5;
        endTime = new JTextField();
        painel.add(endTime, c);

        c.gridwidth = 3;

        c.gridx = 0;
        c.gridy = 7;
        painel.add(new JLabel("Cargo"), c);

        c.gridx = 0;
        c.gridy = 8;
        cargo = new JComboBox();
        painel.add(cargo, c);

        c.gridx = 0;
        c.gridy = 9;
        painel.add(new JLabel("Login"), c);

        c.gridx = 0;
        c.gridy = 10;
        login = new JTextField();
        painel.add(login, c);

        c.gridx = 0;
        c.gridy = 11;
        painel.add(new JLabel("Senha"), c);

        c.gridx = 0;
        c.gridy = 12;
        senha = new JPasswordField();
        painel.add(senha, c);

        JButton salvar = new JButton("Salvar");
        JButton excluir = new JButton("Excluir");
        JButton cancelar = new JButton("Cancelar");

        // CONTROLLER
        // salvar.addActionListener(e -> {
        // FuncionarioCtrl f = new FuncionarioCtrl(logado);
        // f.atualizar(id, nome.getText(), startTime.getText(), endTime.getText(),
        // cargo.getSelectedItem().toString(),
        // login.getText(), new String(senha.getPassword()));
        // });

        // excluir.addActionListener(e -> {
        // FuncionarioCtrl f = new FuncionarioCtrl(logado);
        // f.excluir(id);
        // });
        cancelar.addActionListener(e -> {
            this.dispose();
        });

        c.gridwidth = 1;

        c.gridx = 0;
        c.gridy = 13;

        painel.add(salvar, c);

        c.gridx = 1;
        c.gridy = 13;

        painel.add(excluir, c);

        c.gridx = 2;
        c.gridy = 13;

        painel.add(cancelar, c);

        this.add(painel);
        this.setSize(300, 400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
