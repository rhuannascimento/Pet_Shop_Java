package com.mycompany.petshop.view.funcionario;

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

import com.mycompany.petshop.controller.FuncionarioCtrl;
import com.mycompany.petshop.model.classes.Funcionario;
import com.mycompany.petshop.view.Tela;

public class editarFuncionario extends JFrame {
    private JTextField id;
    private JTextField nome;
    private JTextField startTime;
    private JTextField endTime;
    private JTextField cargo;
    private JTextField login;
    private JPasswordField senha;

    private Funcionario logado;

    public editarFuncionario(Funcionario selected, Funcionario logado) {
        super(selected.getNome());
        this.logado = logado;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    public void desenha(Funcionario selected, DefaultTableModel tableModel) {

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
        id = new JTextField(Integer.toString(selected.getId()));
        painel.add(id, c);

        c.gridx = 0;
        c.gridy = 2;
        painel.add(new JLabel("Nome"), c);

        c.gridx = 0;
        c.gridy = 3;
        nome = new JTextField(selected.getNome());
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
        startTime = new JTextField(selected.getStartTime().toString());
        painel.add(startTime, c);

        c.gridx = 2;
        c.gridy = 5;
        endTime = new JTextField(selected.getEndTime().toString());
        painel.add(endTime, c);

        c.gridwidth = 3;

        c.gridx = 0;
        c.gridy = 7;
        painel.add(new JLabel("Cargo"), c);

        c.gridx = 0;
        c.gridy = 8;
        cargo = new JTextField(selected.getCargo());
        painel.add(cargo, c);

        c.gridx = 0;
        c.gridy = 9;
        painel.add(new JLabel("Login"), c);

        c.gridx = 0;
        c.gridy = 10;
        login = new JTextField(selected.getUsername());
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

        salvar.addActionListener(e -> {
            FuncionarioCtrl fc = new FuncionarioCtrl(logado);
            fc.atualizar(Integer.parseInt(id.getText()), nome.getText(), startTime.getText(), endTime.getText(),
                    cargo.getText(), login.getText(), new String(senha.getPassword()));

            tableModel.setRowCount(0);

            tableModel.fireTableDataChanged();

            ArrayList<Funcionario> listaFuncionarios = fc.exibir();

            for (Funcionario f : listaFuncionarios) {
                tableModel
                        .addRow(new Object[] { f.getId(), f.getNome(), f.getStartTime(),
                                f.getEndTime(), f.getCargo(),
                                f.getUsername() });
            }
            this.dispose();

            tableModel.fireTableDataChanged();

        });

        excluir.addActionListener(e -> {
            FuncionarioCtrl fc = new FuncionarioCtrl(logado);
            fc.excluir(selected.getId());
            tableModel.setRowCount(0);

            tableModel.fireTableDataChanged();

            ArrayList<Funcionario> listaFuncionarios = fc.exibir();

            for (Funcionario f : listaFuncionarios) {
                tableModel
                        .addRow(new Object[] { f.getId(), f.getNome(), f.getStartTime(),
                                f.getEndTime(), f.getCargo(),
                                f.getUsername() });
            }

            this.dispose();
        });

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
