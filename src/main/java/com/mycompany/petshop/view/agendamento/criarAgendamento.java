package com.mycompany.petshop.view.agendamento;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class criarAgendamento extends JFrame {

    private JTextField nome;
    private JTextField servico;
    private JTextField data;
    private JTextField horario;

    public criarAgendamento() {
        super("Novo agendamento");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void desenha() {

        JPanel painel = new JPanel();
        painel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.insets = new Insets(3, 3, 3, 3); // espaçamento entre os componentes
        c.fill = GridBagConstraints.HORIZONTAL; // componente ocupa toda a largura da célula

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
        painel.add(new JLabel("Serviço"), c);

        c.gridx = 0;
        c.gridy = 3;
        servico = new JTextField();
        painel.add(servico, c);

        c.gridx = 0;
        c.gridy = 4;
        painel.add(new JLabel("Data"), c);

        c.gridx = 0;
        c.gridy = 5;
        data = new JTextField();
        painel.add(data, c);

        c.gridx = 0;
        c.gridy = 6;
        painel.add(new JLabel("Horário"), c);

        c.gridx = 0;
        c.gridy = 7;
        horario = new JTextField();
        painel.add(horario, c);

        JButton agendar = new JButton("Agendar");
        JButton cancelar = new JButton("Cancelar");

        // IMPLEMENTAÇÃO DO CONTROLLER
        // agendar.addActionListener(new CriarAgendamento(this));
        cancelar.addActionListener(e -> {
            this.dispose();
        });

        c.gridwidth = 1;

        c.gridx = 0;
        c.gridy = 8;
        painel.add(agendar, c);

        c.gridx = 1;
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

    public JTextField getServico() {
        return servico;
    }

    public JTextField getData() {
        return data;
    }

    public JTextField getHorario() {
        return horario;
    }
}
