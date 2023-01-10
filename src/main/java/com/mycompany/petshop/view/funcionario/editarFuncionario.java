package com.mycompany.petshop.view.funcionario;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mycompany.petshop.model.classes.Agendamento;

public class editarFuncionario extends JFrame {
    private JTextField nome;
    private JComboBox servico;
    private JDateChooser data;
    private JComboBox horario;

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
        painel.add(new JLabel("Nome"), c);

        c.gridx = 0;
        c.gridy = 1;
        nome = new JTextField();
        nome.setEditable(false);
        painel.add(nome, c);

        c.gridx = 0;
        c.gridy = 2;
        painel.add(new JLabel("Serviço"), c);

        c.gridx = 0;
        c.gridy = 3;
        servico = new JComboBox();
        painel.add(servico, c);

        c.gridx = 0;
        c.gridy = 4;
        painel.add(new JLabel("Data"), c);

        c.gridx = 0;
        c.gridy = 5;
        data = new JDateChooser();
        JTextFieldDateEditor editor = (JTextFieldDateEditor) data.getDateEditor();
        editor.setEditable(false);
        painel.add(data, c);

        c.gridx = 0;
        c.gridy = 6;
        painel.add(new JLabel("Horário"), c);

        c.gridx = 0;
        c.gridy = 7;
        horario = new JComboBox();
        painel.add(horario, c);

        JButton salvar = new JButton("Salvar");
        JButton excluir = new JButton("Excluir");
        JButton cancelar = new JButton("Cancelar");

        // IMPLEMENTAÇÃO DO CONTROLLER
        // salvar.addActionListener(editarFuncionario(this));
        // excluir.addActionListener(excluirFuncionario(this));
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

    public JComboBox getServico() {
        return servico;
    }

    public JDateChooser getData() {
        return data;
    }

    public JComboBox getHorario() {
        return horario;
    }
}
