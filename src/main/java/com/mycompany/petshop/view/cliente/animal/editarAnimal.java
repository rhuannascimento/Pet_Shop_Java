package com.mycompany.petshop.view.cliente.animal;

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
import com.mycompany.petshop.model.classes.Animal;

public class editarAnimal extends JFrame {
    private JLabel id;
    private JTextField nome;
    private JTextField cpf;
    private JTextField especie;

    public editarAnimal(Animal selected) {
        super(selected.getNome());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    public void desenha(Animal selected, DefaultTableModel tableModel, ArrayList<Animal> listaAnimais, int row) {
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
        id = new JLabel(String.valueOf(selected.getId()));
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
        painel.add(new JLabel("CPF do dono"), c);

        c.gridx = 0;
        c.gridy = 5;
        cpf = new JTextField();
        painel.add(cpf, c);

        c.gridx = 0;
        c.gridy = 6;
        painel.add(new JLabel("Espécie"), c);

        JButton salvar = new JButton("Salvar");
        JButton excluir = new JButton("Excluir");
        JButton cancelar = new JButton("Cancelar");

        salvar.addActionListener(e -> {
            ClienteCtrl cc = new ClienteCtrl();
            cc.atualizarAnimal(selected.getId(), nome.getText(), cpf.getText(), especie.getText());
            ;

            tableModel.setRowCount(0);

            ArrayList<Cliente> listaClientes = new ArrayList<>();

            try {
                listaClientes = cc.exibirAnimais();

            } catch (Exception ex) {
                ex.printStackTrace();
            }

            for (Cliente z : listaClientes) {
                Animal p = (Animal) z;
                tableModel
                        .addRow(new Object[] { p.getId(), p.getNome(), p.getCpf(),
                                p.getEspecie() });
            }

            this.dispose();

        });

        excluir.addActionListener(e -> {
            ClienteCtrl cc = new ClienteCtrl();
            cc.excluirCliente(selected.getId());

            listaAnimais.remove(selected);

            ArrayList<Cliente> listaClientes = new ArrayList<>();

            try {
                listaClientes = cc.exibirAnimais();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
            tableModel.setRowCount(0);

            for (Cliente z : listaClientes) {
                Animal p = (Animal) z;
                tableModel
                        .addRow(new Object[] { p.getId(), p.getNome(), p.getCpf(),
                                p.getCpf(), p.getEspecie() });
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

    public JTextField getCpf() {
        return this.cpf;
    }

    public JTextField getEspecie() {
        return this.especie;
    }

}
