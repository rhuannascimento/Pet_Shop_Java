package com.mycompany.petshop.view.cliente;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.mycompany.petshop.controller.ClienteCtrl;
import com.mycompany.petshop.model.classes.Cliente;
import com.mycompany.petshop.model.classes.Pessoa;

public class editarPessoa extends JFrame {
    private JTextField id;
    private JTextField nome;
    private JTextField cpf;
    private JTextField email;
    private JTextField telefone;

    private ArrayList<Cliente> listaClientes;

    public editarPessoa(Cliente selected, ArrayList<Cliente> listaClientes) {
        super(selected.getNome());
        this.listaClientes = listaClientes;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    public void desenha(Cliente selected, DefaultTableModel tableModel) {
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
        nome.setEditable(false);
        painel.add(id, c);

        c.gridx = 0;
        c.gridy = 2;
        painel.add(new JLabel("Nome"), c);

        c.gridx = 0;
        c.gridy = 3;
        nome = new JTextField();
        painel.add(nome, c);

        c.gridx = 0;
        c.gridy = 4;
        painel.add(new JLabel("CPF"), c);

        c.gridx = 0;
        c.gridy = 5;
        cpf = new JTextField();
        painel.add(cpf, c);

        c.gridx = 0;
        c.gridy = 6;
        painel.add(new JLabel("Email"), c);

        c.gridx = 0;
        c.gridy = 7;
        email = new JTextField();
        painel.add(email, c);

        c.gridx = 0;
        c.gridy = 8;
        painel.add(new JLabel("Telefone"), c);

        c.gridx = 0;
        c.gridy = 9;
        telefone = new JTextField();
        painel.add(telefone, c);

        JButton salvar = new JButton("Salvar");
        JButton excluir = new JButton("Excluir");
        JButton cancelar = new JButton("Cancelar");

        salvar.addActionListener(e -> {
            ClienteCtrl cc = new ClienteCtrl();
            cc.atualizarPessoa(Integer.parseInt(id.getText()), nome.getText(), cpf.getText(), email.getText(),
                    telefone.getText());
            ;

            tableModel.setRowCount(0);

            ArrayList<Cliente> listaClientes = new ArrayList<>();

            try {
                listaClientes = cc.exibirPessoas();

            } catch (Exception ex) {
                ex.printStackTrace();
            }

            for (Cliente z : listaClientes) {
                Pessoa p = (Pessoa) z;
                tableModel
                        .addRow(new Object[] { p.getId(), p.getNome(), p.getCpf(),
                                p.getEmail(), p.getTelefone() });
            }

            this.dispose();

        });

        excluir.addActionListener(e -> {
            ClienteCtrl cc = new ClienteCtrl();
            cc.excluirCliente(selected.getId());

            listaClientes.remove(selected);

            ArrayList<Cliente> listaClientes = new ArrayList<>();

            try {
                listaClientes = cc.exibirPessoas();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
            tableModel.setRowCount(0);

            for (Cliente z : listaClientes) {
                Pessoa p = (Pessoa) z;
                tableModel
                        .addRow(new Object[] { p.getId(), p.getNome(), p.getCpf(),
                                p.getEmail(), p.getTelefone() });
            }
            tableModel.fireTableDataChanged();
            this.dispose();
        });

        cancelar.addActionListener(e -> {
            this.dispose();
        });

        c.gridwidth = 1;

        c.gridx = 0;
        c.gridy = 8;

        painel.add(salvar, c);

        c.gridx = 1;
        c.gridy = 8;

        painel.add(excluir, c);

        c.gridx = 2;
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

    public JTextField getId() {
        return this.id;
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
