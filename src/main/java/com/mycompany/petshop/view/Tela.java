package com.mycompany.petshop.view;

import com.mycompany.petshop.controller.AgendamentoCtrl;
import com.mycompany.petshop.controller.ClienteCtrl;
import com.mycompany.petshop.controller.FuncionarioCtrl;
import com.mycompany.petshop.controller.ItemCtrl;
import com.mycompany.petshop.model.classes.Agendamento;
import com.mycompany.petshop.model.classes.Animal;
import com.mycompany.petshop.model.classes.Cliente;
import com.mycompany.petshop.model.classes.Funcionario;
import com.mycompany.petshop.model.classes.Item;
import com.mycompany.petshop.model.classes.Pessoa;
import com.mycompany.petshop.model.classes.Servico;
import com.mycompany.petshop.view.agendamento.criarAgendamento;
import com.mycompany.petshop.view.agendamento.editarAgendamento;
import com.mycompany.petshop.view.cliente.criarCliente;
import com.mycompany.petshop.view.cliente.pessoa.editarPessoa;
import com.mycompany.petshop.view.funcionario.criarFuncionario;
import com.mycompany.petshop.view.funcionario.editarFuncionario;
import com.mycompany.petshop.view.mercadoria.brinquedo.criarBrinquedo;
import com.mycompany.petshop.view.mercadoria.brinquedo.editarBrinquedo;
import com.mycompany.petshop.view.mercadoria.racao.criarRacao;
import com.mycompany.petshop.view.mercadoria.racao.editarRacao;
import com.mycompany.petshop.view.mercadoria.remedio.criarRemedio;
import com.mycompany.petshop.view.mercadoria.remedio.editarRemedio;
import com.mycompany.petshop.view.mercadoria.roupa.criarRoupa;
import com.mycompany.petshop.view.mercadoria.roupa.editarRoupa;
import com.mycompany.petshop.view.servico.criarServico;
import com.mycompany.petshop.view.servico.editarServico;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serial;
import java.sql.Time;
import java.util.ArrayList;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.GridBagConstraints;

public class Tela extends JFrame {

    private JPanel painelPrincipal;
    private Funcionario logado;

    ArrayList<Cliente> listaClientes;

    public Tela(Funcionario logado) {
        super();
        this.setTitle("Pet Shop - User: " + logado.getUsername());
        listaClientes = new ArrayList<>();
        this.logado = logado;
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
        this.validate();
        this.repaint();
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

        DefaultTableModel tableModel = new DefaultTableModel(new String[] {
                "Nome", "Serviço", "Horário" }, 0);
        JTable tabela = new JTable(tableModel);

        AgendamentoCtrl fc = new AgendamentoCtrl();
        ArrayList<Agendamento> listaAgendamentos = fc.exibirAgendamentos();

        for (Agendamento f : listaAgendamentos) {
            tableModel
                    .addRow(new Object[] {

                            f.getAnimal().getNome(),
                            f.getServico().getNome(),
                            f.getData_hora().toString()

                    });
        }

        tabela.setDefaultEditor(Object.class, null);

        tabela.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                if (e.getClickCount() == 2) {
                    int row = tabela.rowAtPoint(e.getPoint());
                    int col = tabela.columnAtPoint(e.getPoint());
                    if (row >= 0 && col >= 0) {
                        Agendamento selected = listaAgendamentos.get(row);
                        editarAgendamento edit = new editarAgendamento(selected, listaAgendamentos);
                        edit.desenha(selected, tableModel);
                    }
                }
            }
        });

        JScrollPane sp = new JScrollPane(tabela);

        sp.setPreferredSize(new Dimension(this.getSize().width, this.getSize().height));

        agenda.add(sp);

        JButton agendarButton = new JButton("Novo Agendamento");
        agenda.add(agendarButton, BorderLayout.SOUTH);

        agendarButton.addActionListener(e -> {
            criarAgendamento a = new criarAgendamento(listaAgendamentos);
            a.desenha(tableModel);
        });

        return agenda;

    }

    public JPanel desenhaPendencias() {
        JPanel pendencias = new JPanel(new BorderLayout());
        pendencias.setBorder(BorderFactory.createTitledBorder("Pendências"));

        DefaultListModel listModel = new DefaultListModel();
        JList lista = new JList(listModel);

        JButton novaPend = adicionarPendencia(listModel);

        pendencias.add(lista, BorderLayout.CENTER);
        pendencias.add(novaPend, BorderLayout.SOUTH);

        return pendencias;
    }

    public JButton adicionarPendencia(DefaultListModel listModel) {
        JButton novaPend = new JButton("Adicionar");

        JFrame np = new JFrame("Nova pendência");
        JPanel painel = new JPanel();
        painel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.insets = new Insets(3, 3, 3, 3);
        c.fill = GridBagConstraints.HORIZONTAL;

        c.gridx = 0;
        c.gridy = 0;
        painel.add(new JLabel("Inserir"), c);

        c.gridx = 0;
        c.gridy = 1;
        JTextField input = new JTextField();
        painel.add(input, c);

        JButton adicionar = new JButton("Adicionar");

        adicionar.addActionListener(e -> {

            if (input.getText() == "") {
                np.dispose();
            } else {
                listModel.addElement(input.getText());
                np.dispose();
            }
        });

        c.gridx = 0;
        c.gridy = 3;
        painel.add(adicionar, c);

        np.add(painel);
        np.setSize(150, 140);
        np.setLocationRelativeTo(null);
        np.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        novaPend.addActionListener(e -> {
            np.setVisible(true);
        });

        return novaPend;
    }

    public void desenhaPaginaFuncionarios() {

        JPanel painelFuncionarios = new JPanel(new BorderLayout());
        painelFuncionarios.setBorder(BorderFactory.createTitledBorder("Funcionários"));

        DefaultTableModel tableModel = new DefaultTableModel(new String[] { "ID",
                "Nome", "Início exp.", "Fim exp", "Cargo", "Login" }, 0);
        JTable tabela = new JTable(tableModel);

        FuncionarioCtrl fc = new FuncionarioCtrl(logado);
        ArrayList<Funcionario> listaFuncionarios = fc.exibir();

        for (Funcionario f : listaFuncionarios) {
            tableModel
                    .addRow(new Object[] { f.getId(), f.getNome(), f.getStartTime(),
                            f.getEndTime(), f.getCargo(),
                            f.getUsername() });
        }

        tabela.setDefaultEditor(Object.class, null);

        tabela.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                if (e.getClickCount() == 2) {
                    int row = tabela.rowAtPoint(e.getPoint());
                    int col = tabela.columnAtPoint(e.getPoint());
                    if (row >= 0 && col >= 0) {
                        Funcionario selected = listaFuncionarios.get(row);
                        editarFuncionario edit = new editarFuncionario(selected, logado, listaFuncionarios);
                        edit.desenha(selected, tableModel);
                    }
                }
            }
        });

        JScrollPane sp = new JScrollPane(tabela);

        sp.setPreferredSize(new Dimension(this.getSize().width, this.getSize().height));

        painelFuncionarios.add(sp);

        JButton newFuncButton = new JButton("Cadastrar funcionário");

        newFuncButton.addActionListener(e -> {
            criarFuncionario cf = new criarFuncionario(logado, listaFuncionarios);
            cf.desenha(tableModel);

        });

        painelFuncionarios.add(newFuncButton, BorderLayout.SOUTH);

        painelPrincipal.add(painelFuncionarios, "Funcionários");
    }

    public void desenhaPaginaClientes() {

        JPanel painelClientes = new JPanel(new BorderLayout());
        painelClientes.setBorder(BorderFactory.createTitledBorder("Clientes"));

        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel pessoa = new JPanel(new BorderLayout());
        JScrollPane spPessoa = new JScrollPane(tabelaPessoas());
        pessoa.add(spPessoa);

        tabbedPane.addTab("Pessoas", pessoa);

        JPanel animais = new JPanel(new BorderLayout());
        JScrollPane spAnimais = new JScrollPane(tabelaAnimais());
        animais.add(spAnimais);

        tabbedPane.addTab("Animais", animais);

        tabbedPane.setPreferredSize(new Dimension(600, 300));

        JButton newClienteButton = new JButton("Nova ficha");
        newClienteButton.addActionListener(e -> {
            criarCliente c = new criarCliente();
            c.desenha();
        });

        painelClientes.add(newClienteButton, BorderLayout.SOUTH);

        painelClientes.add(tabbedPane);

        painelPrincipal.add(painelClientes, "Clientes");

    }

    public JTable tabelaPessoas() {

        DefaultTableModel tableModel = new DefaultTableModel(new String[] {
                "ID", "Nome", "CPF", "Email", "Telefone" }, 0);
        JTable tabela = new JTable(tableModel);

        ClienteCtrl cc = new ClienteCtrl();

        try {
            listaClientes = cc.exibirPessoas();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        ArrayList<Pessoa> listaPessoas = new ArrayList<>();

        for (Cliente c : listaClientes) {
            Pessoa p = (Pessoa) c;
            listaPessoas.add(p);
            tableModel
                    .addRow(new Object[] { p.getId(), p.getNome(), p.getCpf(),
                            p.getEmail(), p.getTelefone() });
        }

        tabela.setDefaultEditor(Object.class, null);

        tabela.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                if (e.getClickCount() == 2) {
                    int row = tabela.rowAtPoint(e.getPoint());
                    int col = tabela.columnAtPoint(e.getPoint());
                    if (row >= 0 && col >= 0) {
                        Pessoa selected = listaPessoas.get(row);
                        editarPessoa edit = new editarPessoa(selected);
                        edit.desenha(selected, tableModel, listaPessoas, row);
                    }
                }
            }
        });

        JScrollPane sp = new JScrollPane(tabela);

        sp.setPreferredSize(new Dimension(this.getSize().width, this.getSize().height));

        return tabela;

    }

    public JTable tabelaAnimais() {

        DefaultTableModel tableModel = new DefaultTableModel(new String[] { "ID",
                "Nome", "CPF do dono", "Éspecie" }, 0);
        JTable tabela = new JTable(tableModel);

        ClienteCtrl cc = new ClienteCtrl();

        ArrayList<Cliente> listaAnimais = new ArrayList<>();

        try {
            listaAnimais = cc.exibirAnimais();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        for (Cliente f : listaAnimais) {
            Animal p = (Animal) f;
            tableModel
                    .addRow(new Object[] { p.getId(), p.getNome(), p.getCpf(),
                            p.getEspecie(), });
        }

        tabela.setDefaultEditor(Object.class, null);

        return tabela;

    }

    public void desenhaPaginaServicos() {

        JPanel painelServicos = new JPanel(new BorderLayout());
        painelServicos.setBorder(BorderFactory.createTitledBorder("Serviços"));
        DefaultTableModel tableModel = new DefaultTableModel(new String[] { "Tipo",
                "Duração", "Valor" }, 0);
        JTable tabela = new JTable(tableModel);

        ItemCtrl ic = new ItemCtrl();
        ArrayList<Item> listaItens = ic.exibirServicos();
        ArrayList<Servico> listaServicos = new ArrayList<>();

        for (Item i : listaItens) {
            Servico s = (Servico) i;
            listaServicos.add(s);
            tableModel
                    .addRow(new Object[] { s.getNome(), s.getDuracao() + " min", "R$ " + (int) s.getPreco() + ",00" });
        }

        tabela.setDefaultEditor(Object.class, null);

        tabela.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                if (e.getClickCount() == 2) {
                    int row = tabela.rowAtPoint(e.getPoint());
                    int col = tabela.columnAtPoint(e.getPoint());
                    if (row >= 0 && col >= 0) {
                        Servico selected = listaServicos.get(row);
                        editarServico edit = new editarServico(selected);
                        edit.desenha(selected, tableModel, listaServicos, row);
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
            c.desenha(listaServicos, tableModel, logado);
        });

        painelServicos.add(newServButton, BorderLayout.SOUTH);

        painelPrincipal.add(painelServicos, "Serviços");

    }

    public void desenhaPaginaMercadorias() {
        JPanel painelMercadorias = new JPanel(new BorderLayout());
        painelMercadorias.setBorder(BorderFactory.createTitledBorder("Mercadorias"));

        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel racao = new JPanel(new BorderLayout());
        JScrollPane spRacao = new JScrollPane(tabelaRacao());
        racao.add(spRacao);
        JButton newRacaoButton = new JButton("Registrar ração");

        newRacaoButton.addActionListener(e -> {
            criarRacao c = new criarRacao();
            c.desenha();
        });
        racao.add(newRacaoButton, BorderLayout.SOUTH);

        tabbedPane.addTab("Ração", racao);

        JPanel roupas = new JPanel(new BorderLayout());
        JScrollPane spRoupas = new JScrollPane(tabelaRoupas());
        roupas.add(spRoupas);
        JButton newRoupaButton = new JButton("Registrar roupa");

        newRoupaButton.addActionListener(e -> {
            criarRoupa c = new criarRoupa();
            c.desenha();
        });
        roupas.add(newRoupaButton, BorderLayout.SOUTH);

        tabbedPane.addTab("Roupas", roupas);

        JPanel brinquedos = new JPanel(new BorderLayout());
        JScrollPane spBrinquedos = new JScrollPane(tabelaBrinquedos());
        brinquedos.add(spBrinquedos);
        JButton newBrinquedoButton = new JButton("Registrar brinquedo");

        newBrinquedoButton.addActionListener(e -> {
            criarBrinquedo c = new criarBrinquedo();
            c.desenha();
        });
        brinquedos.add(newBrinquedoButton, BorderLayout.SOUTH);

        tabbedPane.addTab("Brinquedos", brinquedos);

        JPanel remedios = new JPanel(new BorderLayout());
        JScrollPane spRemedios = new JScrollPane(tabelaRemedios());
        remedios.add(spRemedios);
        JButton newRemedioButton = new JButton("Registrar remédio");

        newRemedioButton.addActionListener(e -> {
            criarRemedio c = new criarRemedio();
            c.desenha();
        });
        remedios.add(newRemedioButton, BorderLayout.SOUTH);

        tabbedPane.addTab("Remédios", remedios);

        tabbedPane.setPreferredSize(new Dimension(600, 300));

        painelMercadorias.add(tabbedPane);

        painelPrincipal.add(painelMercadorias, "Mercadorias");

    }

    public JTable tabelaRacao() {

        DefaultTableModel tableModel = new DefaultTableModel(
                new String[] { "ID", "Nome", "Valor Un.", "Espécie", "Sabor", "Idade", "Disponível",
                        "Fornecedor", "Estoque" },
                0);

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
                        editarRacao edit = new editarRacao(a);
                        edit.desenha(a);
                    }
                }
            }
        });

        return tabela;
    }

    public JTable tabelaRoupas() {
        DefaultTableModel tableModel = new DefaultTableModel(
                new String[] { "ID", "Nome", "Valor Un.", "Espécie", "Tipo", "Tamanho", "Disponível",
                        "Fornecedor", "Estoque" },
                0);
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
                        editarRoupa edit = new editarRoupa(a);
                        edit.desenha(a);
                    }
                }
            }
        });

        return tabela;
    }

    public JTable tabelaBrinquedos() {
        DefaultTableModel tableModel = new DefaultTableModel(
                new String[] { "ID", "Nome", "Valor Un.", "Tipo", "Material", "Espécie", "Disponível",
                        "Fornecedor", "Estoque" },
                0);

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
                        editarBrinquedo edit = new editarBrinquedo(a);
                        edit.desenha(a);
                    }
                }
            }
        });

        return tabela;
    }

    public JTable tabelaRemedios() {
        DefaultTableModel tableModel = new DefaultTableModel(
                new String[] { "ID", "Nome", "Valor Un.", "Espécie", "Utilidade", "Orientação", "Tipo", "Disponível",
                        "Fornecedor", "Estoque" },
                0);

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
                        editarRemedio edit = new editarRemedio(a);
                        edit.desenha(a);
                    }
                }
            }
        });

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

}