package com.mycompany.petshop.view.agendamento;

import com.mycompany.petshop.business.agendamento.ExibirAgendamentos;
import com.mycompany.petshop.business.cliente.BuscarCliente;
import com.mycompany.petshop.business.item.BuscaItem;
import com.mycompany.petshop.controller.AgendamentoCtrl;
import com.mycompany.petshop.model.classes.Agendamento;
import com.mycompany.petshop.model.classes.Animal;
import com.mycompany.petshop.model.classes.Cliente;
import com.mycompany.petshop.model.classes.Item;
import com.mycompany.petshop.model.classes.Servico;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class editarAgendamento extends JFrame {

    private JTextField nome;
    private JTextField servico;
    private JTextField horario;
    private JTextField id;

    
    private ArrayList<Agendamento> listaAgendamento;
    
    public editarAgendamento(Agendamento selected, ArrayList<Agendamento> listaAgendamento) {
        super("Agendamento de " + selected.getA());
        
        
        this.listaAgendamento = listaAgendamento;
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    public void desenha(Agendamento selected, DefaultTableModel tableModel) {
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
        painel.add(new JLabel("Id do Animal"), c);

        c.gridx = 0;
        c.gridy = 3;
        nome = new JTextField();
        painel.add(nome, c);

        c.gridx = 0;
        c.gridy = 4;
        painel.add(new JLabel("Id do Serviço"), c);

        c.gridx = 0;
        c.gridy = 5;
        servico = new JTextField();
        painel.add(servico, c);


        c.gridx = 0;
        c.gridy = 6;
        painel.add(new JLabel("Data e Horário: yyyy-mm-dd hh:mm:ss"), c);

        c.gridx = 0;
        c.gridy = 7;
        horario = new JTextField(selected.getData_hora().toString());
        painel.add(horario, c);

        JButton salvar = new JButton("Salvar");
        JButton excluir = new JButton("Excluir");
        JButton cancelar = new JButton("Cancelar");

        // IMPLEMENTAÇÃO DO CONTROLLER
        
        
        salvar.addActionListener(e -> {
            
            Cliente cliente = new BuscarCliente(Integer.parseInt(nome.getText())).getCliente();
            Item item = new BuscaItem(Integer.parseInt(servico.getText())).getItem();
            
            Animal a = (Animal) cliente;
            Servico s = (Servico) item;
            
            AgendamentoCtrl fc = new AgendamentoCtrl();
            fc.atualizarAgendamento(Integer.parseInt(id.getText()),
                    Timestamp.valueOf(horario.getText()), a, s);

            selected.setId(Integer.parseInt(id.getText()));
            selected.setData_hora(Timestamp.valueOf(horario.getText()));
            selected.setAnimal(a);
            selected.setServico(s);
            
            tableModel.setRowCount(0);

            ArrayList<Agendamento> listaAgendamento = fc.exibirAgendamentos();

            for (Agendamento f : listaAgendamento) {
                tableModel
                        .addRow(new Object[] { f.getAnimal().getNome(), f.getServico().getNome(), f.getData_hora().toString()});
            }

            this.dispose();
            
        });
        

        excluir.addActionListener(e -> {
            
            AgendamentoCtrl fc = new AgendamentoCtrl();
            fc.excluir(selected.getId());

            listaAgendamento.remove(selected);

            listaAgendamento = fc.exibirAgendamentos();
            tableModel.setRowCount(0);

            for (Agendamento f : listaAgendamento) {
                tableModel.addRow(new Object[] {f.getAnimal().getNome(), f.getServico().getNome(), f.getData_hora().toString() });
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

    public JTextField getServico() {
        return servico;
    }

 

    public JTextField getHorario() {
        return horario;
    }
}
