package com.mycompany.petshop.view.funcionario;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mycompany.petshop.controller.FuncionarioCtrl;
import com.mycompany.petshop.model.classes.Funcionario;
import com.toedter.components.JSpinField;

public class criarFuncionario extends JFrame {
    private JTextField nome;
    private JTextField startTime;
    private JTextField endTime;
    private JTextField cargo;
    private JTextField login;
    private JPasswordField senha;

    private Funcionario logado;
    private ArrayList<Funcionario> listaFuncionarios;

    public criarFuncionario(Funcionario logado, ArrayList<Funcionario> listaFuncionarios) {
        super("Cadastrar funcionário");
        this.logado = logado;
        this.listaFuncionarios = listaFuncionarios;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    public void desenha(DefaultTableModel tableModel) {

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

        c.gridwidth = 1;

        c.gridx = 0;
        c.gridy = 3;
        painel.add(new JLabel("Início exp."), c);

        c.gridx = 1;
        c.gridy = 3;
        painel.add(new JLabel("Fim exp."), c);

        c.gridx = 0;
        c.gridy = 4;
        startTime = new JTextField();
        painel.add(startTime, c);

        c.gridx = 1;
        c.gridy = 4;
        endTime = new JTextField();
        painel.add(endTime, c);

        c.gridwidth = 2;

        c.gridx = 0;
        c.gridy = 5;
        painel.add(new JLabel("Cargo"), c);

        c.gridx = 0;
        c.gridy = 6;
        cargo = new JTextField();
        painel.add(cargo, c);

        c.gridx = 0;
        c.gridy = 7;
        painel.add(new JLabel("Login"), c);

        c.gridx = 0;
        c.gridy = 8;
        login = new JTextField();
        painel.add(login, c);

        c.gridx = 0;
        c.gridy = 9;
        painel.add(new JLabel("Senha"), c);

        c.gridx = 0;
        c.gridy = 10;
        senha = new JPasswordField();
        painel.add(senha, c);

        JButton cadastrar = new JButton("Cadastrar");
        JButton cancelar = new JButton("Cancelar");

        cadastrar.addActionListener(e -> {
            FuncionarioCtrl f = new FuncionarioCtrl(logado);

            f.cadastrar(0, nome.getText(), startTime.getText().toString(), endTime.getText().toString(),
                    cargo.getText(), login.getText(), new String(senha.getPassword()));

            // CORRIGIR
            /*
             * listaFuncionarios
             * .add(new Funcionario(0, nome.getText(), LoclTime.parse(startTime.getText()),
             * Time.parse(endTime.getText()), cargo.getText(),
             * login.getText(),
             * new String(senha.getPassword())));
             */

            tableModel
                    .addRow(new Object[] { 0, nome.getText().toString(), startTime.getText().toString(),
                            endTime.getText(),
                            cargo.getText(), login.getText(), new String(senha.getPassword()) });

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
        this.setSize(300, 330);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
