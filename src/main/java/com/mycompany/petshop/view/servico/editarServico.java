package com.mycompany.petshop.view.servico;

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

import com.mycompany.petshop.controller.ItemCtrl;
import com.mycompany.petshop.model.classes.Item;
import com.mycompany.petshop.model.classes.Servico;

public class editarServico extends JFrame {
    private JTextField nome;
    private JTextField duracao;
    private JTextField valor;

    public editarServico(Item selected) {
        super(selected.getNome());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void desenha(Servico selected, DefaultTableModel tableModel, ArrayList<Servico> listaServicos, int row) {

        JPanel painel = new JPanel();
        painel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.insets = new Insets(3, 3, 3, 3); // espaçamento entre os componentes
        c.fill = GridBagConstraints.HORIZONTAL;

        c.gridwidth = 3;

        c.gridx = 0;
        c.gridy = 0;
        painel.add(new JLabel("Tipo"), c);

        c.gridx = 0;
        c.gridy = 1;
        nome = new JTextField(selected.getNome());
        painel.add(nome, c);

        c.gridx = 0;
        c.gridy = 2;
        painel.add(new JLabel("Duração (em min)"), c);

        c.gridx = 0;
        c.gridy = 3;
        duracao = new JTextField(selected.getDuracao());
        painel.add(duracao, c);

        c.gridx = 0;
        c.gridy = 4;
        painel.add(new JLabel("Valor"), c);

        c.gridx = 0;
        c.gridy = 5;
        valor = new JTextField(Float.toString(selected.getPreco()));
        painel.add(valor, c);

        JButton salvar = new JButton("Salvar");
        JButton excluir = new JButton("Excluir");
        JButton cancelar = new JButton("Cancelar");

        salvar.addActionListener(e -> {
            ItemCtrl ic = new ItemCtrl();
            ic.atualizarServico(selected.getId(), nome.getText(), Float.parseFloat(valor.getText()), selected.getTipo(),
                    true,
                    Integer.parseInt(duracao.getText()), selected.getId());

            selected.setId(selected.getId());
            selected.setTipo(nome.getText());
            selected.setPreco(Float.parseFloat(valor.getText()));
            selected.setNome(selected.getTipo());
            selected.setDisponivel(true);
            selected.setDuracao(Integer.parseInt(duracao.getText()));
            selected.setIdResponsavel(selected.getId());

            tableModel.setRowCount(0);

            ArrayList<Item> list = ic.exibirServicos();

            for (Item i : list) {
                Servico s = (Servico) i;
                listaServicos.add(s);
            }

            for (Servico s : listaServicos) {
                tableModel
                        .addRow(new Object[] { s.getNome(), s.getDuracao(), s.getPreco(),
                        });
            }

            this.dispose();

        });

        excluir.addActionListener(e -> {
            ItemCtrl ic = new ItemCtrl();
            ic.excluirItem(selected.getId());

            ArrayList<Item> list = ic.exibirServicos();
            for (Item i : list) {
                Servico s = (Servico) i;
                listaServicos.add(s);
            }

            listaServicos.remove(selected);

            tableModel.removeRow(row);

            tableModel.fireTableDataChanged();
            this.dispose();
        });

        cancelar.addActionListener(e -> {
            this.dispose();
        });

        c.gridwidth = 1;

        c.gridx = 0;
        c.gridy = 6;

        painel.add(salvar, c);

        c.gridx = 1;
        c.gridy = 6;

        painel.add(excluir, c);

        c.gridx = 2;
        c.gridy = 6;

        painel.add(cancelar, c);

        this.add(painel);
        this.setSize(300, 300);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
