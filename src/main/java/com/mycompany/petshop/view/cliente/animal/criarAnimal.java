package com.mycompany.petshop.view.cliente.animal;

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
import com.mycompany.petshop.model.classes.Animal;
import com.mycompany.petshop.model.exceptions.ClienteExp;

public class criarAnimal extends JFrame {

    private JTextField nome;
    private JTextField cpf;
    private JTextField especie;

    public criarAnimal() {
        super("Nova ficha");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void desenha(ArrayList<Animal> listaAnimais, DefaultTableModel tableModel) {

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
        painel.add(new JLabel("CPF do dono"), c);

        c.gridx = 0;
        c.gridy = 3;
        cpf = new JTextField();
        painel.add(cpf, c);

        c.gridx = 0;
        c.gridy = 4;
        painel.add(new JLabel("Espécie"), c);

        c.gridx = 0;
        c.gridy = 5;
        especie = new JTextField();
        painel.add(especie, c);

        JButton cadastrar = new JButton("Cadastrar");
        JButton cancelar = new JButton("Cancelar");

        cadastrar.addActionListener(e -> {
            ClienteCtrl cc = new ClienteCtrl();

            cc.cadastrarCliente(0, nome.getText(), cpf.getText(), "animal", "", "", especie.getText());

            Animal novo = (Animal) cc.getUltimo();
            listaAnimais.add(novo);

            tableModel
                    .addRow(new Object[] { novo.getId(), novo.getNome(), novo.getCpf(),
                            novo.getEspecie() });

            this.dispose();
        });

        cancelar.addActionListener(e -> {
            this.dispose();
        });

        c.gridwidth = 1;

        c.gridx = 0;
        c.gridy = 6;
        painel.add(cadastrar, c);

        c.gridx = 1;
        c.gridy = 6;
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

    public JTextField getEspecie() {
        return this.especie;
    }

}
