package com.mycompany.petshop.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Tela extends JFrame {

    private JPanel painelPrincipal;
    private JPanel painelHome;
    private JPanel painelFuncionarios;
    private JPanel painelClientes;
    private JPanel painelServicos;
    private JPanel painelMercadorias;

    public Tela() {
        super("Pet Shop");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void renderiza() {

        painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new CardLayout());

        // Cria páginas para cada funcionalidade
        desenhaPaginaHome();
        desenhaPaginaFuncionarios();
        desenhaPaginaClientes();
        desenhaPaginaServiços();
        desenhaPaginaMercadorias();

        desenhaBarraBotoes();

        this.setSize(700, 300);
        this.pack();
        this.setVisible(true);
    }

    public void desenhaPaginaHome() {
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setDividerLocation(420);
        splitPane.setResizeWeight(0);
        splitPane.setEnabled(false);
        splitPane.setPreferredSize(new Dimension(700, 300));

        painelHome = new JPanel();

        painelHome.add(splitPane, BorderLayout.CENTER);

        // Agenda
        JPanel agenda = desenhaAgenda();

        JPanel pendencias = new JPanel();
        pendencias.setBorder(BorderFactory.createTitledBorder("Pendências"));

        splitPane.setLeftComponent(agenda);
        splitPane.setRightComponent(pendencias);

        painelPrincipal.add(painelHome, "Home");
    }

    public void desenhaPaginaFuncionarios() {
        painelFuncionarios = new JPanel();
        painelFuncionarios.add(new JLabel("Funcionários"));
        painelPrincipal.add(painelFuncionarios, "Funcionários");

        JButton newFuncButton = new JButton("Cadastrar funcionário");
        painelFuncionarios.add(newFuncButton);
        newFuncButton.addActionListener(e -> {
            cadastrarFuncionario();
        });
    }

    public void desenhaPaginaClientes() {
        painelClientes = new JPanel();
        painelClientes.add(new JLabel("Clientes"));
        painelPrincipal.add(painelClientes, "Clientes");
    }

    public void desenhaPaginaServiços() {
        painelServicos = new JPanel();
        painelServicos.add(new JLabel("Serviços"));
        painelPrincipal.add(painelServicos, "Serviços");
    }

    public void desenhaPaginaMercadorias() {
        painelMercadorias = new JPanel();
        painelMercadorias.add(new JLabel("Mercadorias"));
        painelPrincipal.add(painelMercadorias, "Mercadorias");
    }

    public void desenhaBarraBotoes() {
        // Barra de botões
        JPanel barraBotoes = new JPanel();

        JButton botaoHome = new JButton("Home");
        barraBotoes.add(botaoHome);

        JButton botaoFuncionarios = new JButton("Funcionários");
        barraBotoes.add(botaoFuncionarios);

        JButton botaoClientes = new JButton("Clientes");
        barraBotoes.add(botaoClientes);

        JButton botaoServicos = new JButton("Serviços");
        barraBotoes.add(botaoServicos);

        JButton botaoMercadorias = new JButton("Mercadorias");
        barraBotoes.add(botaoMercadorias);

        // Tamanho dos botões
        botaoHome.setPreferredSize(new Dimension(120, 25));
        botaoFuncionarios.setPreferredSize(new Dimension(120, 25));
        botaoClientes.setPreferredSize(new Dimension(120, 25));
        botaoServicos.setPreferredSize(new Dimension(120, 25));
        botaoMercadorias.setPreferredSize(new Dimension(120, 25));

        // Troca de página quando clica nos botões
        botaoHome.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) painelPrincipal.getLayout();
            cardLayout.show(painelPrincipal, "Home");
        });
        botaoFuncionarios.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) painelPrincipal.getLayout();
            cardLayout.show(painelPrincipal, "Funcionários");
        });
        botaoClientes.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) painelPrincipal.getLayout();
            cardLayout.show(painelPrincipal, "Clientes");
        });
        botaoServicos.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) painelPrincipal.getLayout();
            cardLayout.show(painelPrincipal, "Serviços");
        });
        botaoMercadorias.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) painelPrincipal.getLayout();
            cardLayout.show(painelPrincipal, "Mercadorias");
        });

        add(painelPrincipal, BorderLayout.CENTER);

        add(barraBotoes, BorderLayout.SOUTH);
    }

    public JPanel desenhaAgenda() {
        JPanel agenda = new JPanel(new BorderLayout());
        agenda.setBorder(BorderFactory.createTitledBorder("Agenda"));

        ArrayList<Agendamento> agendamentos = new ArrayList<>();

        agendamentos.add(new Agendamento("Lily", "Tosa", "16:00"));
        agendamentos.add(new Agendamento("Tom", "Banho", "17:00"));

        JList<Agendamento> list = new JList<>(agendamentos.toArray(new Agendamento[0]));

        agenda.add(list);

        JButton agendarButton = new JButton("Novo Agendamento");

        agenda.add(agendarButton, BorderLayout.SOUTH);

        agendarButton.addActionListener(e -> {
            criarAgendamento();
        });

        return agenda;
    }

    public void criarAgendamento() {
        JFrame frame = new JFrame("Novo agendamento");
        JPanel painel = new JPanel();
        painel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.insets = new Insets(3, 3, 3, 3);
        c.fill = GridBagConstraints.HORIZONTAL;

        c.gridx = 0;
        c.gridy = 0;
        painel.add(new JLabel("Nome"), c);

        c.gridx = 0;
        c.gridy = 1;
        JComboBox nome = new JComboBox();
        painel.add(nome, c);

        c.gridx = 0;
        c.gridy = 2;
        painel.add(new JLabel("Serviço"), c);

        c.gridx = 0;
        c.gridy = 3;
        JComboBox servico = new JComboBox();
        painel.add(servico, c);

        c.gridx = 0;
        c.gridy = 4;
        painel.add(new JLabel("Data"), c);

        c.gridx = 0;
        c.gridy = 5;
        JDateChooser data = new JDateChooser();
        JTextFieldDateEditor editor = (JTextFieldDateEditor) data.getDateEditor();
        editor.setEditable(false);
        painel.add(data, c);

        c.gridx = 0;
        c.gridy = 6;
        painel.add(new JLabel("Horário"), c);

        c.gridx = 0;
        c.gridy = 7;
        JComboBox horario = new JComboBox();
        painel.add(horario, c);

        JButton agendar = new JButton("Agendar");
        JButton cancelar = new JButton("Cancelar");

        cancelar.addActionListener(e -> {
            frame.dispose();
        });
        painel.add(agendar);
        painel.add(cancelar);

        frame.add(painel);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    public void cadastrarFuncionario() {

        JFrame frame = new JFrame("Cadastrar funcionário");
        JPanel painel = new JPanel();
        painel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.insets = new Insets(3, 3, 3, 3);
        c.fill = GridBagConstraints.HORIZONTAL;

        c.gridx = 0;
        c.gridy = 0;
        painel.add(new JLabel("Nome"), c);

        c.gridx = 0;
        c.gridy = 1;
        JTextField nome = new JTextField();
        painel.add(nome, c);

        c.gridx = 0;
        c.gridy = 2;
        painel.add(new JLabel("ID"), c);

        c.gridx = 0;
        c.gridy = 3;
        JTextField id = new JTextField();
        painel.add(id, c);

        JButton cadastrar = new JButton("Cadastrar");
        JButton cancelar = new JButton("Cancelar");

        cancelar.addActionListener(e -> {
            frame.dispose();
        });
        painel.add(cadastrar);
        painel.add(cancelar);

        frame.add(painel);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}
