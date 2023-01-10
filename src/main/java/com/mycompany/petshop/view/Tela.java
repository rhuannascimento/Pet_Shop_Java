package com.mycompany.petshop.view;

import com.mycompany.petshop.model.classes.Agendamento;
import com.mycompany.petshop.view.agendamento.criarAgendamento;
import com.mycompany.petshop.view.agendamento.editarAgendamento;
import com.mycompany.petshop.view.cliente.criarCliente;
import com.mycompany.petshop.view.cliente.editarCliente;
import com.mycompany.petshop.view.funcionario.criarFuncionario;
import com.mycompany.petshop.view.funcionario.editarFuncionario;
import com.mycompany.petshop.view.servico.criarServico;
import com.mycompany.petshop.view.servico.editarServico;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Tela extends JFrame {

    private JPanel painelPrincipal;

    public Tela(String user) {
        super();
        this.setTitle("Pet Shop - User: " + user);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void renderiza() {

        painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new CardLayout());

        // Cria páginas para cada funcionalidade
        desenhaPaginaHome();
        desenhaPaginaFuncionarios();
        desenhaPaginaClientes();
        desenhaPaginaServicos();
        desenhaPaginaMercadorias();

        desenhaBarraBotoes();

        this.setSize(600, 300);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
    }

    public void desenhaPaginaHome() {
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setDividerLocation(360);
        splitPane.setResizeWeight(0);
        splitPane.setEnabled(false);
        splitPane.setPreferredSize(new Dimension(600, 300));

        JPanel painelHome = new JPanel();

        painelHome.add(splitPane, BorderLayout.CENTER);

        // Agenda
        JPanel agenda = desenhaAgenda();

        // Pendencias
        JPanel pendencias = desenhaPendencias();

        splitPane.setLeftComponent(agenda);
        splitPane.setRightComponent(pendencias);

        painelPrincipal.add(painelHome, "Home");
    }

    public JPanel desenhaAgenda() {
        JPanel agenda = new JPanel(new BorderLayout());
        agenda.setBorder(BorderFactory.createTitledBorder("Agenda"));

        DefaultTableModel tableModel = new DefaultTableModel(new String[] { "Nome", "Serviço", "Horário" }, 0);
        JTable tabela = new JTable(tableModel);

        ArrayList<Agendamento> listaAgendamentos = new ArrayList<>();

        listaAgendamentos.add(new Agendamento("Lily", "Tosa", "16:00"));
        listaAgendamentos.add(new Agendamento("Tom", "Banho", "17:00"));

        for (Agendamento agendamento : listaAgendamentos) {
            tableModel
                    .addRow(new Object[] { agendamento.getA(), agendamento.getB(), agendamento.getC() });
        }

        tabela.setDefaultEditor(Object.class, null);

        tabela.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int row = tabela.rowAtPoint(e.getPoint());
                    int col = tabela.columnAtPoint(e.getPoint());
                    if (row >= 0 && col >= 0) {
                        Agendamento a = listaAgendamentos.get(row);
                        editarAgendamento edit = new editarAgendamento(a);
                        edit.desenha(a);
                    }
                }
            }
        });

        JScrollPane sp = new JScrollPane(tabela);

        sp.setMaximumSize(new Dimension(this.getSize().width, this.getSize().height));

        agenda.add(sp);

        JButton agendarButton = new JButton("Novo Agendamento");
        agenda.add(agendarButton, BorderLayout.SOUTH);
        agendarButton.addActionListener((ActionEvent e) -> {
            criarAgendamento a = new criarAgendamento();
            a.desenha();
        });

        return agenda;

    }

    public JPanel desenhaPendencias() {
        JPanel pendencias = new JPanel(new BorderLayout());
        pendencias.setBorder(BorderFactory.createTitledBorder("Pendências"));

        // JList<Pendencia> list = new JList<>(pendencias.toArray(new Pendencia[0]));
        JButton adicionar = new JButton("Adicionar");

        pendencias.add(adicionar, BorderLayout.SOUTH);

        return pendencias;
    }

    public void desenhaPaginaFuncionarios() {
        JPanel painelFuncionarios = new JPanel(new BorderLayout());
        painelFuncionarios.setBorder(BorderFactory.createTitledBorder("Funcionários"));

        DefaultTableModel tableModel = new DefaultTableModel(new String[] { "ID", "Nome", "Cargo", "Horário" }, 0);
        JTable tabela = new JTable(tableModel);

        ArrayList<Agendamento> listaAgendamentos = new ArrayList<>();

        listaAgendamentos.add(new Agendamento("Lily", "Tosa", "16:00"));
        listaAgendamentos.add(new Agendamento("Tom", "Banho", "17:00"));

        for (Agendamento agendamento : listaAgendamentos) {
            tableModel
                    .addRow(new Object[] { agendamento.getA(), agendamento.getB(), agendamento.getC() });
        }

        tabela.setDefaultEditor(Object.class, null);

        tabela.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int row = tabela.rowAtPoint(e.getPoint());
                    int col = tabela.columnAtPoint(e.getPoint());
                    if (row >= 0 && col >= 0) {
                        Agendamento a = listaAgendamentos.get(row);
                        editarFuncionario edit = new editarFuncionario(a);
                        edit.desenha(a);
                    }
                }
            }
        });

        JScrollPane sp = new JScrollPane(tabela);

        sp.setPreferredSize(new Dimension(this.getSize().width, this.getSize().height));

        painelFuncionarios.add(sp);

        JButton newFuncButton = new JButton("Cadastrar funcionário");

        newFuncButton.addActionListener(e -> {
            criarFuncionario f = new criarFuncionario();
            f.desenha();
        });

        painelFuncionarios.add(newFuncButton, BorderLayout.SOUTH);

        painelPrincipal.add(painelFuncionarios, "Funcionários");

    }

    public void desenhaPaginaClientes() {
        JPanel painelClientes = new JPanel(new BorderLayout());
        painelClientes.setBorder(BorderFactory.createTitledBorder("Clientes"));

        DefaultTableModel tableModel = new DefaultTableModel(
                new String[] { "Nome", "Espécie", "Idade", "CPF do dono" }, 0);
        JTable tabela = new JTable(tableModel);

        ArrayList<Agendamento> listaAgendamentos = new ArrayList<>();

        listaAgendamentos.add(new Agendamento("Lily", "Tosa", "16:00"));
        listaAgendamentos.add(new Agendamento("Tom", "Banho", "17:00"));

        for (Agendamento agendamento : listaAgendamentos) {
            tableModel
                    .addRow(new Object[] { agendamento.getA(), agendamento.getB(), agendamento.getC() });
        }

        tabela.setDefaultEditor(Object.class, null);

        tabela.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int row = tabela.rowAtPoint(e.getPoint());
                    int col = tabela.columnAtPoint(e.getPoint());
                    if (row >= 0 && col >= 0) {
                        Agendamento a = listaAgendamentos.get(row);
                        editarCliente edit = new editarCliente(a);
                        edit.desenha(a);
                    }
                }
            }
        });

        JScrollPane sp = new JScrollPane(tabela);

        sp.setPreferredSize(new Dimension(this.getSize().width, this.getSize().height));

        painelClientes.add(sp);

        JButton newClienteButton = new JButton("Nova ficha");
        newClienteButton.addActionListener(e -> {
            criarCliente c = new criarCliente();
            c.desenha();
        });

        painelClientes.add(newClienteButton, BorderLayout.SOUTH);

        painelPrincipal.add(painelClientes, "Clientes");

    }

    public void desenhaPaginaServicos() {
        JPanel painelServicos = new JPanel(new BorderLayout());
        painelServicos.setBorder(BorderFactory.createTitledBorder("Serviços"));

        DefaultTableModel tableModel = new DefaultTableModel(new String[] { "Tipo", "Duração", "Valor" }, 0);
        JTable tabela = new JTable(tableModel);

        ArrayList<Agendamento> listaAgendamentos = new ArrayList<>();

        listaAgendamentos.add(new Agendamento("Lily", "Tosa", "16:00"));
        listaAgendamentos.add(new Agendamento("Tom", "Banho", "17:00"));

        for (Agendamento agendamento : listaAgendamentos) {
            tableModel
                    .addRow(new Object[] { agendamento.getA(), agendamento.getB(), agendamento.getC() });
        }

        tabela.setDefaultEditor(Object.class, null);

        tabela.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int row = tabela.rowAtPoint(e.getPoint());
                    int col = tabela.columnAtPoint(e.getPoint());
                    if (row >= 0 && col >= 0) {
                        Agendamento a = listaAgendamentos.get(row);
                        editarServico edit = new editarServico(a);
                        edit.desenha(a);
                    }
                }
            }
        });

        JScrollPane sp = new JScrollPane(tabela);
        sp.setPreferredSize(new Dimension(this.getSize().width, this.getSize().height));
        painelServicos.add(sp);

        JButton newServButton = new JButton("Novo serviço");
        newServButton.addActionListener(e -> {
            criarServico c = new criarServico();
            c.desenha();
        });

        painelServicos.add(newServButton, BorderLayout.SOUTH);

        painelPrincipal.add(painelServicos, "Serviços");

    }

    public void desenhaPaginaMercadorias() {
        JPanel painelMercadorias = new JPanel(new BorderLayout());
        painelMercadorias.setBorder(BorderFactory.createTitledBorder("Mercadorias"));

        JTabbedPane tabbedPane = new JTabbedPane();

        JScrollPane racao = new JScrollPane();
        racao.add(tabelaRacao());
        tabbedPane.addTab("Ração", racao);

        JPanel roupas = new JPanel();
        roupas.add(tabelaRoupas());
        tabbedPane.addTab("Roupas", roupas);

        JPanel brinquedos = new JPanel();
        brinquedos.add(tabelaBrinquedos());
        tabbedPane.addTab("Brinquedos", brinquedos);

        JPanel remedios = new JPanel();
        remedios.add(tabelaRemedios());
        tabbedPane.addTab("Remédios", remedios);

        tabbedPane.setPreferredSize(new Dimension(600, 300));

        painelMercadorias.add(tabbedPane);

        painelPrincipal.add(painelMercadorias, "Mercadorias");

    }

    public JTable tabelaRacao() {
        DefaultTableModel tableModel = new DefaultTableModel(
                new String[] { "Nome", "Valor Un.", "Fornecedor", "Estoque" }, 0);
        JTable tabela = new JTable(tableModel);

        ArrayList<Agendamento> listaAgendamentos = new ArrayList<>();

        listaAgendamentos.add(new Agendamento("Lily", "Tosa", "16:00"));
        listaAgendamentos.add(new Agendamento("Tom", "Banho", "17:00"));

        for (Agendamento agendamento : listaAgendamentos) {
            tableModel
                    .addRow(new Object[] { agendamento.getA(), agendamento.getB(), agendamento.getC() });
        }

        tabela.setDefaultEditor(Object.class, null);

        tabela.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int row = tabela.rowAtPoint(e.getPoint());
                    int col = tabela.columnAtPoint(e.getPoint());
                    if (row >= 0 && col >= 0) {
                        Agendamento a = listaAgendamentos.get(row);
                        JFrame f = new JFrame(a.getA());
                        f.setSize(300, 300);
                        f.setVisible(true);
                    }
                }
            }
        });

        return tabela;
    }

    public JTable tabelaRoupas() {
        DefaultTableModel tableModel = new DefaultTableModel(
                new String[] { "Nome", "Valor Un.", "Fornecedor", "Estoque" }, 0);
        JTable tabela = new JTable(tableModel);

        ArrayList<Agendamento> listaAgendamentos = new ArrayList<>();

        listaAgendamentos.add(new Agendamento("Lily", "Tosa", "16:00"));
        listaAgendamentos.add(new Agendamento("Tom", "Banho", "17:00"));

        for (Agendamento agendamento : listaAgendamentos) {
            tableModel
                    .addRow(new Object[] { agendamento.getA(), agendamento.getB(), agendamento.getC() });
        }

        tabela.setDefaultEditor(Object.class, null);

        return tabela;
    }

    public JTable tabelaBrinquedos() {
        DefaultTableModel tableModel = new DefaultTableModel(
                new String[] { "Nome", "Valor Un.", "Fornecedor", "Estoque" }, 0);
        JTable tabela = new JTable(tableModel);

        ArrayList<Agendamento> listaAgendamentos = new ArrayList<>();

        listaAgendamentos.add(new Agendamento("Lily", "Tosa", "16:00"));
        listaAgendamentos.add(new Agendamento("Tom", "Banho", "17:00"));

        for (Agendamento agendamento : listaAgendamentos) {
            tableModel
                    .addRow(new Object[] { agendamento.getA(), agendamento.getB(), agendamento.getC() });
        }

        tabela.setDefaultEditor(Object.class, null);

        return tabela;
    }

    public JTable tabelaRemedios() {
        DefaultTableModel tableModel = new DefaultTableModel(
                new String[] { "Nome", "Valor Un.", "Fornecedor", "Estoque" }, 0);
        JTable tabela = new JTable(tableModel);

        ArrayList<Agendamento> listaAgendamentos = new ArrayList<>();

        listaAgendamentos.add(new Agendamento("Lily", "Tosa", "16:00"));
        listaAgendamentos.add(new Agendamento("Tom", "Banho", "17:00"));

        for (Agendamento agendamento : listaAgendamentos) {
            tableModel
                    .addRow(new Object[] { agendamento.getA(), agendamento.getB(), agendamento.getC() });
        }

        tabela.setDefaultEditor(Object.class, null);

        return tabela;
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
        botaoHome.setPreferredSize(new Dimension(115, 25));
        botaoFuncionarios.setPreferredSize(new Dimension(115, 25));
        botaoClientes.setPreferredSize(new Dimension(115, 25));
        botaoServicos.setPreferredSize(new Dimension(115, 25));
        botaoMercadorias.setPreferredSize(new Dimension(115, 25));

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

    public static void main(String args[]) {

        Tela tela = new Tela("user");
        tela.renderiza();

    }
}
