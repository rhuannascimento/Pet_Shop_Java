package com.mycompany.petshop.view.agendamento;

import com.mycompany.petshop.business.cliente.BuscarCliente;
import com.mycompany.petshop.business.item.BuscaItem;
import com.mycompany.petshop.controller.AgendamentoCtrl;
import com.mycompany.petshop.controller.ClienteCtrl;
import com.mycompany.petshop.model.classes.Agendamento;
import com.mycompany.petshop.model.classes.Animal;
import com.mycompany.petshop.model.classes.Cliente;
import com.mycompany.petshop.model.classes.Item;
import com.mycompany.petshop.model.classes.Servico;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class criarAgendamento extends JFrame {

    private JTextField nome;
    private JTextField servico;

    private JTextField horario;
    
    private ArrayList<Agendamento> agendamentos;

    public criarAgendamento(ArrayList<Agendamento> agendamentos) {
        super("Novo agendamento");
        
        this.agendamentos = agendamentos;
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void desenha(DefaultTableModel tableModel) {

        JPanel painel = new JPanel();
        painel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.insets = new Insets(3, 3, 3, 3); // espaçamento entre os componentes
        c.fill = GridBagConstraints.HORIZONTAL; // componente ocupa toda a largura da célula

        c.gridwidth = 2;

        c.gridx = 0;
        c.gridy = 0;
        painel.add(new JLabel("Id do Animal"), c);

        c.gridx = 0;
        c.gridy = 1;
        nome = new JTextField();
        painel.add(nome, c);

        c.gridx = 0;
        c.gridy = 2;
        painel.add(new JLabel("Id do Serviço"), c);

        c.gridx = 0;
        c.gridy = 3;
        servico = new JTextField();
        painel.add(servico, c);

      

        c.gridx = 0;
        c.gridy = 6;
        painel.add(new JLabel("Data e Horário: yyyy-mm-dd hh:mm:ss"), c);

        c.gridx = 0;
        c.gridy = 7;
        horario = new JTextField();
        painel.add(horario, c);

        JButton agendar = new JButton("Agendar");
        JButton cancelar = new JButton("Cancelar");

        // IMPLEMENTAÇÃO DO CONTROLLER
        agendar.addActionListener( e -> {
            
            AgendamentoCtrl ac = new AgendamentoCtrl();
            
            Cliente cliente = new BuscarCliente(Integer.parseInt(nome.getText())).getCliente();
            Item item = new BuscaItem(Integer.parseInt(servico.getText())).getItem();
            
            Animal a = (Animal) cliente;
            Servico s = (Servico) item;
            
           
            ac.cadastrarAgendamento(0, Timestamp.valueOf(horario.getText()), a, s);
            
            
            
            Agendamento novo = ac.getUltimo();
            
            agendamentos.add(novo);
            
            tableModel.addRow(new Object[] {
                
                novo.getAnimal().getNome(), 
                novo.getServico().getNome(), 
                novo.getData_hora().toString()
            
            });
            
            this.dispose();
            
        });
        
        
        
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


    public JTextField getHorario() {
        return horario;
    }
}
