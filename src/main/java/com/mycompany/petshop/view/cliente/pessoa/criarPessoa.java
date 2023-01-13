package com.mycompany.petshop.view.cliente.pessoa;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mycompany.petshop.controller.ClienteCtrl;
import com.mycompany.petshop.model.classes.Pessoa;
import com.mycompany.petshop.model.exceptions.ClienteExp;

public class criarPessoa extends JFrame {

    private JTextField nome;
    private JTextField cpf;
    private JTextField email;
    private JTextField telefone;

    public criarPessoa() {
        super("Novo cliente");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void desenha(ArrayList<Pessoa> listaPessoas, DefaultTableModel tableModel) {

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
        painel.add(new JLabel("CPF"), c);

        c.gridx = 0;
        c.gridy = 3;
        cpf = new JTextField();
        painel.add(cpf, c);

        c.gridx = 0;
        c.gridy = 4;
        painel.add(new JLabel("Email"), c);

        c.gridx = 0;
        c.gridy = 5;
        email = new JTextField();
        painel.add(email, c);

        c.gridx = 0;
        c.gridy = 6;
        painel.add(new JLabel("Telefone"), c);

        c.gridx = 0;
        c.gridy = 7;
        telefone = new JTextField();
        painel.add(telefone, c);

        JButton cadastrar = new JButton("Cadastrar");
        JButton cancelar = new JButton("Cancelar");

        cadastrar.addActionListener(e -> {
            ClienteCtrl cc = new ClienteCtrl();

            try {
                cc.cadastrarCliente(0, nome.getText(), cpf.getText(), "pessoa", telefone.getText(), email.getText(),
                        "pessoa");

                ;
            } catch (ClienteExp exp) {

            }

            Pessoa novo = (Pessoa) cc.getUltimo();
            listaPessoas.add(novo);

            tableModel
                    .addRow(new Object[] { novo.getId(), novo.getNome(), novo.getCpf(),
                            novo.getEmail(), novo.getTelefone() });

            this.dispose();
        });

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
        return this.nome;
    }

    public JTextField getCpf() {
        return this.cpf;
    }

    public JTextField getEmail() {
        return this.email;
    }

    public JTextField getTelefone() {
        return this.telefone;
    }

}
