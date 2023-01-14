/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.petshop.view;

import com.mycompany.petshop.controller.AgendamentoCtrl;
import com.mycompany.petshop.controller.ClienteCtrl;
import com.mycompany.petshop.controller.FuncionarioCtrl;
import com.mycompany.petshop.controller.ItemCtrl;
import com.mycompany.petshop.model.classes.Agendamento;
import com.mycompany.petshop.model.classes.Animal;
import com.mycompany.petshop.model.classes.Brinquedo;
import com.mycompany.petshop.model.classes.Cliente;
import com.mycompany.petshop.model.classes.Funcionario;
import com.mycompany.petshop.model.classes.Item;
import com.mycompany.petshop.model.classes.Pessoa;
import com.mycompany.petshop.model.classes.Racao;
import com.mycompany.petshop.model.classes.Remedio;
import com.mycompany.petshop.model.classes.Roupa;
import com.mycompany.petshop.model.classes.Servico;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.regex.Pattern;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author viier
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    
    Funcionario logado;
    
    CardLayout layout;
    
    private String caseListAgendamento, cpfCliente;
    private int idEditandoAgendamento, idEditandoCliente, idEditandoAnimal;
    private Agendamento anterior;
    private Funcionario responsavel;
    private Servico sAnterior;
    
    void inicializarTabelas(){
        tableAgendamentos.getTableHeader().setFont(new java.awt.Font("Liberation Sans", 0, 18));
        tableSelectServicoCadastrarAgendamento.getTableHeader().setFont(new java.awt.Font("Liberation Sans", 0, 18));
        tableSelectAnimalCadastrarAgendamento.getTableHeader().setFont(new java.awt.Font("Liberation Sans", 0, 18));
        tableFuncionarios.getTableHeader().setFont(new java.awt.Font("Liberation Sans", 0, 18));
        tableClientesAnimais.getTableHeader().setFont(new java.awt.Font("Liberation Sans", 0, 18));
        tableClientesPessoas.getTableHeader().setFont(new java.awt.Font("Liberation Sans", 0, 18));
        tableServicos.getTableHeader().setFont(new java.awt.Font("Liberation Sans", 0, 18));
        tableBrinquedos.getTableHeader().setFont(new java.awt.Font("Liberation Sans", 0, 18));
        tableRacoes.getTableHeader().setFont(new java.awt.Font("Liberation Sans", 0, 18));
        tableRemedios.getTableHeader().setFont(new java.awt.Font("Liberation Sans", 0, 18));
        tableRoupas.getTableHeader().setFont(new java.awt.Font("Liberation Sans", 0, 18));
        tableMercadorias.getTableHeader().setFont(new java.awt.Font("Liberation Sans", 0, 18));
        
        tableAgendamentos.getTableHeader().setOpaque(false);
        tableSelectServicoCadastrarAgendamento.getTableHeader().setOpaque(false);
        tableSelectAnimalCadastrarAgendamento.getTableHeader().setOpaque(false);
        tableFuncionarios.getTableHeader().setOpaque(false);
        tableClientesAnimais.getTableHeader().setOpaque(false);
        tableClientesPessoas.getTableHeader().setOpaque(false);
        tableServicos.getTableHeader().setOpaque(false);
        tableBrinquedos.getTableHeader().setOpaque(false);
        tableRacoes.getTableHeader().setOpaque(false);
        tableRemedios.getTableHeader().setOpaque(false);
        tableRoupas.getTableHeader().setOpaque(false);
        tableMercadorias.getTableHeader().setOpaque(false);
        
        tableAgendamentos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableSelectServicoCadastrarAgendamento.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableSelectAnimalCadastrarAgendamento.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableFuncionarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableClientesAnimais.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableClientesPessoas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableServicos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableBrinquedos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableRacoes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableRemedios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableRoupas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableMercadorias.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
    }
    
    void inicializarComponentes(){
        spinnerAnoCadastrarAgendamento.setValue(LocalDate.now().getYear());
        if(!this.logado.getCargo().equalsIgnoreCase("gerente")){
            buttonDeletarFuncionario.setEnabled(false);
            buttonEditarFuncionario.setEnabled(false);
        }
    }
    
    public TelaPrincipal(Funcionario logado) {
        initComponents();
        
        
        
        caseListAgendamento = "hoje";
        loadTableAgendamento(caseListAgendamento);
        
        layout = (CardLayout)(panelContent.getLayout());
        this.logado = logado;
        
        inicializarTabelas();
        inicializarComponentes();
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMenu = new javax.swing.JPanel();
        buttonInicio = new javax.swing.JButton();
        buttonFuncionarios = new javax.swing.JButton();
        buttonClientes = new javax.swing.JButton();
        buttonServicos = new javax.swing.JButton();
        buttonMercadorias = new javax.swing.JButton();
        panelContent = new javax.swing.JPanel();
        panelInicio = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableAgendamentos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        agendamentosExibirHoje = new javax.swing.JButton();
        agendamentosExibirAmanha = new javax.swing.JButton();
        agendamentosExibirTodos = new javax.swing.JButton();
        buttonCadastrarAgendamento = new javax.swing.JButton();
        buttonDeletarAgendamento = new javax.swing.JButton();
        buttonEditarAgendamento = new javax.swing.JButton();
        panelCadastrarAgendamento = new javax.swing.JPanel();
        title5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableSelectServicoCadastrarAgendamento = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableSelectAnimalCadastrarAgendamento = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textPesquisaCpfCadastrarAgendamento = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        spinnerDiaCadastrarAgendamento = new javax.swing.JSpinner(new SpinnerNumberModel(1, 1, 31, 1));
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        spinnerMesCadastrarAgendamento = new javax.swing.JSpinner(new SpinnerNumberModel(1, 1, 12, 1));
        jLabel9 = new javax.swing.JLabel();
        spinnerAnoCadastrarAgendamento = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        spinnerHoraCadastrarAgendamento = new javax.swing.JSpinner(new SpinnerNumberModel(0, 0, 31, 1));
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        spinnerMinutoCadastrarAgendamento = new javax.swing.JSpinner(new SpinnerNumberModel(0, 0, 59, 15));
        buttonEfetuarCadastroAgendamento = new javax.swing.JButton();
        buttonCancelarCadastroAgendamento = new javax.swing.JButton();
        panelEditarAgendamento = new javax.swing.JPanel();
        title6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableSelectServicoEditarAgendamento = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableSelectAnimalEditarAgendamento = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        textPesquisaCpfEditarAgendamento = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        spinnerDiaEditarAgendamento = new javax.swing.JSpinner(new SpinnerNumberModel(1, 1, 31, 1));
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        spinnerMesEditarAgendamento = new javax.swing.JSpinner(new SpinnerNumberModel(1, 1, 12, 1));
        jLabel20 = new javax.swing.JLabel();
        spinnerAnoEditarAgendamento = new javax.swing.JSpinner();
        jLabel21 = new javax.swing.JLabel();
        spinnerHoraEditarAgendamento = new javax.swing.JSpinner(new SpinnerNumberModel(1, 1, 31, 1));
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        spinnerMinutoEditarAgendamento = new javax.swing.JSpinner(new SpinnerNumberModel(0, 0, 59, 15));
        buttonEfetuarEditarAgendamento = new javax.swing.JButton();
        buttonCancelarEditarAgendamento = new javax.swing.JButton();
        panelFuncionarios = new javax.swing.JPanel();
        title1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableFuncionarios = new javax.swing.JTable();
        jLabel24 = new javax.swing.JLabel();
        buttonCadastrarFuncionario = new javax.swing.JButton();
        buttonEditarFuncionario = new javax.swing.JButton();
        buttonDeletarFuncionario = new javax.swing.JButton();
        panelCadastrarFuncionario = new javax.swing.JPanel();
        title7 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        spinnerHoraInicioCadastrarFuncionario = new javax.swing.JSpinner(new SpinnerNumberModel(8, 0, 23, 1));
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        spinnerMinutoInicioCadastrarFuncionario = new javax.swing.JSpinner(new SpinnerNumberModel(0, 0, 59, 15));
        buttonEfetuarCadastroFuncionario = new javax.swing.JButton();
        buttonCancelarCadastroFuncionario = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        textNomeCadastrarFuncionario = new javax.swing.JTextField();
        textUsuarioCadastrarFuncionario = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        textSenhaCadastrarFuncionario = new javax.swing.JPasswordField();
        comboCargoCadastrarFuncionario = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        spinnerMinutoFimCadastrarFuncionario = new javax.swing.JSpinner(new SpinnerNumberModel(0, 0, 59, 15));
        spinnerHoraFimCadastrarFuncionario = new javax.swing.JSpinner(new SpinnerNumberModel(18, 0, 23, 1));
        panelEditarFuncionario = new javax.swing.JPanel();
        title8 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        spinnerHoraInicioEditarFuncionario = new javax.swing.JSpinner(new SpinnerNumberModel(8, 0, 23, 1));
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        spinnerMinutoInicioEditarFuncionario = new javax.swing.JSpinner(new SpinnerNumberModel(0, 0, 59, 15));
        buttonEfetuarEditarFuncionario = new javax.swing.JButton();
        buttonCancelarEditarFuncionario = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        textNomeEditarFuncionario = new javax.swing.JTextField();
        textUsuarioEditarFuncionario = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        textSenhaEditarFuncionario = new javax.swing.JPasswordField();
        comboCargoEditarFuncionario = new javax.swing.JComboBox<>();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        spinnerMinutoFimEditarFuncionario = new javax.swing.JSpinner(new SpinnerNumberModel(0, 0, 59, 15));
        spinnerHoraFimEditarFuncionario = new javax.swing.JSpinner(new SpinnerNumberModel(8, 0, 23, 1));
        panelClientes = new javax.swing.JPanel();
        title9 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tableClientesPessoas = new javax.swing.JTable();
        buttonCadastrarCliente = new javax.swing.JButton();
        buttonEditarCliente = new javax.swing.JButton();
        buttonDeletarCliente = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        panelAnimal = new javax.swing.JPanel();
        title11 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tableClientesAnimais = new javax.swing.JTable();
        buttonCadastrarClienteAnimal = new javax.swing.JButton();
        buttonEditarClienteAnimal = new javax.swing.JButton();
        buttonDeletarClienteAnimal = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        panelCadastrarAnimal = new javax.swing.JPanel();
        title13 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        buttonCancelarCadastroAnimal = new javax.swing.JButton();
        buttonEfetuarCadastroAnimal = new javax.swing.JButton();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        nomeCadastrarAnimal = new javax.swing.JTextField();
        especieCadastrarAnimal = new javax.swing.JTextField();
        panelEditarAnimal = new javax.swing.JPanel();
        title14 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        buttonCancelarCadastroAnimal1 = new javax.swing.JButton();
        buttonEfetuarEditarAnimal = new javax.swing.JButton();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        nomeEditarAnimal = new javax.swing.JTextField();
        especieEditarAnimal = new javax.swing.JTextField();
        panelEditarCliente = new javax.swing.JPanel();
        title12 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        buttonEfetuarCadastroFuncionario2 = new javax.swing.JButton();
        buttonCancelarCadastroFuncionario2 = new javax.swing.JButton();
        jLabel56 = new javax.swing.JLabel();
        nomeEditarCliente = new javax.swing.JTextField();
        cpfEditarCliente = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        emailEditarCliente = new javax.swing.JTextField();
        telefoneEditarCliente = new javax.swing.JTextField();
        panelCadastrarCliente = new javax.swing.JPanel();
        title10 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        buttonEfetuarCadastroFuncionario1 = new javax.swing.JButton();
        buttonCancelarCadastroFuncionario1 = new javax.swing.JButton();
        jLabel52 = new javax.swing.JLabel();
        nomeCadastrarCliente = new javax.swing.JTextField();
        cpfCadastrarCliente = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        emailCadastrarCliente = new javax.swing.JTextField();
        telefoneCadastrarCliente = new javax.swing.JTextField();
        panelServicos = new javax.swing.JPanel();
        title15 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tableServicos = new javax.swing.JTable();
        buttonCadastrarServico = new javax.swing.JButton();
        buttonEditarServico = new javax.swing.JButton();
        buttonDeletarServico = new javax.swing.JButton();
        panelCadastrarServico = new javax.swing.JPanel();
        title18 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        buttonCancelarCadastroAnimal4 = new javax.swing.JButton();
        buttonEfetuarEdicao1 = new javax.swing.JButton();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        nomeCadastrarServico = new javax.swing.JTextField();
        precoCadastrarServico = new javax.swing.JTextField();
        jLabel79 = new javax.swing.JLabel();
        duracaoCadastrarServico = new javax.swing.JTextField();
        jScrollPane12 = new javax.swing.JScrollPane();
        tableResponsavelCadastrar = new javax.swing.JTable();
        jLabel80 = new javax.swing.JLabel();
        panelEditarServico = new javax.swing.JPanel();
        title16 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        buttonCancelarCadastroAnimal2 = new javax.swing.JButton();
        buttonEfetuarEdicao = new javax.swing.JButton();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        nomeEditarServico = new javax.swing.JTextField();
        precoEditarServico = new javax.swing.JTextField();
        jLabel69 = new javax.swing.JLabel();
        duracaoEditarServico = new javax.swing.JTextField();
        jScrollPane10 = new javax.swing.JScrollPane();
        tableResponsavel = new javax.swing.JTable();
        jLabel71 = new javax.swing.JLabel();
        painelMercadorias = new javax.swing.JPanel();
        title2 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tableMercadorias = new javax.swing.JTable();
        jLabel70 = new javax.swing.JLabel();
        agendamentosExibirHoje1 = new javax.swing.JButton();
        agendamentosExibirAmanha1 = new javax.swing.JButton();
        agendamentosExibirTodos1 = new javax.swing.JButton();
        buttonDeletarAgendamento1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        panelBrinquedo = new javax.swing.JPanel();
        title17 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        tableBrinquedos = new javax.swing.JTable();
        jLabel74 = new javax.swing.JLabel();
        agendamentosExibirHoje4 = new javax.swing.JButton();
        agendamentosExibirAmanha4 = new javax.swing.JButton();
        agendamentosExibirTodos4 = new javax.swing.JButton();
        buttonCadastrarAgendamento4 = new javax.swing.JButton();
        buttonDeletarAgendamento4 = new javax.swing.JButton();
        buttonEditarAgendamento4 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        panelRacao = new javax.swing.JPanel();
        title19 = new javax.swing.JLabel();
        jScrollPane16 = new javax.swing.JScrollPane();
        tableRacoes = new javax.swing.JTable();
        jLabel75 = new javax.swing.JLabel();
        agendamentosExibirHoje5 = new javax.swing.JButton();
        agendamentosExibirAmanha5 = new javax.swing.JButton();
        agendamentosExibirTodos5 = new javax.swing.JButton();
        buttonCadastrarAgendamento5 = new javax.swing.JButton();
        buttonDeletarAgendamento5 = new javax.swing.JButton();
        buttonEditarAgendamento5 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        panelRemedio = new javax.swing.JPanel();
        title4 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        tableRemedios = new javax.swing.JTable();
        jLabel73 = new javax.swing.JLabel();
        agendamentosExibirHoje3 = new javax.swing.JButton();
        agendamentosExibirAmanha3 = new javax.swing.JButton();
        agendamentosExibirTodos3 = new javax.swing.JButton();
        buttonCadastrarAgendamento3 = new javax.swing.JButton();
        buttonDeletarAgendamento3 = new javax.swing.JButton();
        buttonEditarAgendamento3 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        panelRoupa = new javax.swing.JPanel();
        title3 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        tableRoupas = new javax.swing.JTable();
        jLabel72 = new javax.swing.JLabel();
        agendamentosExibirHoje2 = new javax.swing.JButton();
        agendamentosExibirAmanha2 = new javax.swing.JButton();
        agendamentosExibirTodos2 = new javax.swing.JButton();
        buttonCadastrarAgendamento2 = new javax.swing.JButton();
        buttonDeletarAgendamento2 = new javax.swing.JButton();
        buttonEditarAgendamento2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelMenu.setBackground(new java.awt.Color(51, 51, 51));

        buttonInicio.setBackground(new java.awt.Color(51, 51, 51));
        buttonInicio.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        buttonInicio.setForeground(new java.awt.Color(255, 255, 255));
        buttonInicio.setText("Início");
        buttonInicio.setBorder(null);
        buttonInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInicioActionPerformed(evt);
            }
        });

        buttonFuncionarios.setBackground(new java.awt.Color(51, 51, 51));
        buttonFuncionarios.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        buttonFuncionarios.setForeground(new java.awt.Color(255, 255, 255));
        buttonFuncionarios.setText("Funcionários");
        buttonFuncionarios.setBorder(null);
        buttonFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFuncionariosActionPerformed(evt);
            }
        });

        buttonClientes.setBackground(new java.awt.Color(51, 51, 51));
        buttonClientes.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        buttonClientes.setForeground(new java.awt.Color(255, 255, 255));
        buttonClientes.setText("Clientes");
        buttonClientes.setBorder(null);
        buttonClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClientesActionPerformed(evt);
            }
        });

        buttonServicos.setBackground(new java.awt.Color(51, 51, 51));
        buttonServicos.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        buttonServicos.setForeground(new java.awt.Color(255, 255, 255));
        buttonServicos.setText("Serviços");
        buttonServicos.setBorder(null);
        buttonServicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonServicosActionPerformed(evt);
            }
        });

        buttonMercadorias.setBackground(new java.awt.Color(51, 51, 51));
        buttonMercadorias.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        buttonMercadorias.setForeground(new java.awt.Color(255, 255, 255));
        buttonMercadorias.setText("Mercadorias");
        buttonMercadorias.setBorder(null);
        buttonMercadorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMercadoriasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonMercadorias, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonServicos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonClientes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonFuncionarios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    .addComponent(buttonInicio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(buttonInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonServicos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonMercadorias, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(260, Short.MAX_VALUE))
        );

        getContentPane().add(panelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 620));

        panelContent.setLayout(new java.awt.CardLayout());

        title.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Início");

        tableAgendamentos.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tableAgendamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableAgendamentos.setFocusable(false);
        tableAgendamentos.setRowHeight(32);
        tableAgendamentos.setSelectionBackground(new java.awt.Color(81, 81, 81));
        tableAgendamentos.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tableAgendamentos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableAgendamentos);

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Agendamentos");

        agendamentosExibirHoje.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        agendamentosExibirHoje.setText("Exibir Hoje");
        agendamentosExibirHoje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agendamentosExibirHojeActionPerformed(evt);
            }
        });

        agendamentosExibirAmanha.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        agendamentosExibirAmanha.setText("Exibir Amanhã");
        agendamentosExibirAmanha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agendamentosExibirAmanhaActionPerformed(evt);
            }
        });

        agendamentosExibirTodos.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        agendamentosExibirTodos.setText("Exibir Todos");
        agendamentosExibirTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agendamentosExibirTodosActionPerformed(evt);
            }
        });

        buttonCadastrarAgendamento.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        buttonCadastrarAgendamento.setText("Cadastrar Novo");
        buttonCadastrarAgendamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCadastrarAgendamentoActionPerformed(evt);
            }
        });

        buttonDeletarAgendamento.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        buttonDeletarAgendamento.setForeground(new java.awt.Color(197, 0, 0));
        buttonDeletarAgendamento.setText("Deletar");
        buttonDeletarAgendamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeletarAgendamentoActionPerformed(evt);
            }
        });

        buttonEditarAgendamento.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        buttonEditarAgendamento.setText("Editar");
        buttonEditarAgendamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditarAgendamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelInicioLayout = new javax.swing.GroupLayout(panelInicio);
        panelInicio.setLayout(panelInicioLayout);
        panelInicioLayout.setHorizontalGroup(
            panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInicioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelInicioLayout.createSequentialGroup()
                        .addGroup(panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelInicioLayout.createSequentialGroup()
                                .addComponent(agendamentosExibirHoje, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(agendamentosExibirAmanha, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(buttonCadastrarAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(agendamentosExibirTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                        .addComponent(buttonEditarAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonDeletarAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelInicioLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        panelInicioLayout.setVerticalGroup(
            panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInicioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(agendamentosExibirAmanha, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(agendamentosExibirHoje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(agendamentosExibirTodos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonEditarAgendamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonDeletarAgendamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonCadastrarAgendamento, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelContent.add(panelInicio, "inicio");

        title5.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        title5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title5.setText("Início");

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Cadastrar novo Agendamento");

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Selecione o Serviço");

        tableSelectServicoCadastrarAgendamento.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tableSelectServicoCadastrarAgendamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableSelectServicoCadastrarAgendamento.setRowHeight(40);
        tableSelectServicoCadastrarAgendamento.getTableHeader().setResizingAllowed(false);
        tableSelectServicoCadastrarAgendamento.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tableSelectServicoCadastrarAgendamento);
        if (tableSelectServicoCadastrarAgendamento.getColumnModel().getColumnCount() > 0) {
            tableSelectServicoCadastrarAgendamento.getColumnModel().getColumn(0).setMinWidth(40);
            tableSelectServicoCadastrarAgendamento.getColumnModel().getColumn(0).setPreferredWidth(40);
            tableSelectServicoCadastrarAgendamento.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        tableSelectAnimalCadastrarAgendamento.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tableSelectAnimalCadastrarAgendamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableSelectAnimalCadastrarAgendamento.setRowHeight(40);
        tableSelectAnimalCadastrarAgendamento.getTableHeader().setResizingAllowed(false);
        tableSelectAnimalCadastrarAgendamento.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tableSelectAnimalCadastrarAgendamento);
        if (tableSelectAnimalCadastrarAgendamento.getColumnModel().getColumnCount() > 0) {
            tableSelectAnimalCadastrarAgendamento.getColumnModel().getColumn(0).setMinWidth(40);
            tableSelectAnimalCadastrarAgendamento.getColumnModel().getColumn(0).setPreferredWidth(40);
            tableSelectAnimalCadastrarAgendamento.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Selecione o Animal");

        jLabel5.setText("Buscar pelo CPF do dono:");

        textPesquisaCpfCadastrarAgendamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textPesquisaCpfCadastrarAgendamentoKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Selecione a Data");

        spinnerDiaCadastrarAgendamento.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Dia:");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Mês:");

        spinnerMesCadastrarAgendamento.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Ano:");

        spinnerAnoCadastrarAgendamento.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Selecione a Hora");

        spinnerHoraCadastrarAgendamento.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Hora:");

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Minuto:");

        spinnerMinutoCadastrarAgendamento.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N

        buttonEfetuarCadastroAgendamento.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        buttonEfetuarCadastroAgendamento.setForeground(new java.awt.Color(0, 153, 51));
        buttonEfetuarCadastroAgendamento.setText("Cadastrar");
        buttonEfetuarCadastroAgendamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEfetuarCadastroAgendamentoActionPerformed(evt);
            }
        });

        buttonCancelarCadastroAgendamento.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        buttonCancelarCadastroAgendamento.setForeground(new java.awt.Color(153, 0, 51));
        buttonCancelarCadastroAgendamento.setText("Cancelar");
        buttonCancelarCadastroAgendamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarCadastroAgendamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCadastrarAgendamentoLayout = new javax.swing.GroupLayout(panelCadastrarAgendamento);
        panelCadastrarAgendamento.setLayout(panelCadastrarAgendamentoLayout);
        panelCadastrarAgendamentoLayout.setHorizontalGroup(
            panelCadastrarAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCadastrarAgendamentoLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(panelCadastrarAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE))
                .addGap(43, 43, 43)
                .addGroup(panelCadastrarAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(textPesquisaCpfCadastrarAgendamento)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(43, 43, 43)
                .addGroup(panelCadastrarAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelCadastrarAgendamentoLayout.createSequentialGroup()
                        .addGroup(panelCadastrarAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(spinnerDiaCadastrarAgendamento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCadastrarAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(spinnerMesCadastrarAgendamento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCadastrarAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(spinnerAnoCadastrarAgendamento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelCadastrarAgendamentoLayout.createSequentialGroup()
                        .addGroup(panelCadastrarAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelCadastrarAgendamentoLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(spinnerHoraCadastrarAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCadastrarAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(spinnerMinutoCadastrarAgendamento))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelCadastrarAgendamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCadastrarAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCadastrarAgendamentoLayout.createSequentialGroup()
                        .addComponent(buttonCancelarCadastroAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonEfetuarCadastroAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelCadastrarAgendamentoLayout.setVerticalGroup(
            panelCadastrarAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCadastrarAgendamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelCadastrarAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCadastrarAgendamentoLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCadastrarAgendamentoLayout.createSequentialGroup()
                        .addGroup(panelCadastrarAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCadastrarAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelCadastrarAgendamentoLayout.createSequentialGroup()
                                .addGroup(panelCadastrarAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelCadastrarAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(panelCadastrarAgendamentoLayout.createSequentialGroup()
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(spinnerAnoCadastrarAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panelCadastrarAgendamentoLayout.createSequentialGroup()
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(panelCadastrarAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(spinnerMesCadastrarAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(spinnerDiaCadastrarAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(57, 57, 57)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelCadastrarAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelCadastrarAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(spinnerHoraCadastrarAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spinnerMinutoCadastrarAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCadastrarAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCadastrarAgendamentoLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textPesquisaCpfCadastrarAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCadastrarAgendamentoLayout.createSequentialGroup()
                        .addGap(0, 139, Short.MAX_VALUE)
                        .addGroup(panelCadastrarAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonCancelarCadastroAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonEfetuarCadastroAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        panelContent.add(panelCadastrarAgendamento, "cadastrarAgendamento");

        title6.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        title6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title6.setText("Início");

        jLabel13.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Editar Agendamento");

        jLabel14.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Selecione o Serviço");

        tableSelectServicoEditarAgendamento.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tableSelectServicoEditarAgendamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableSelectServicoEditarAgendamento.setRowHeight(40);
        tableSelectServicoEditarAgendamento.getTableHeader().setResizingAllowed(false);
        tableSelectServicoEditarAgendamento.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(tableSelectServicoEditarAgendamento);
        if (tableSelectServicoEditarAgendamento.getColumnModel().getColumnCount() > 0) {
            tableSelectServicoEditarAgendamento.getColumnModel().getColumn(0).setMinWidth(40);
            tableSelectServicoEditarAgendamento.getColumnModel().getColumn(0).setPreferredWidth(40);
            tableSelectServicoEditarAgendamento.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        tableSelectAnimalEditarAgendamento.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tableSelectAnimalEditarAgendamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableSelectAnimalEditarAgendamento.setRowHeight(40);
        tableSelectAnimalEditarAgendamento.getTableHeader().setResizingAllowed(false);
        tableSelectAnimalEditarAgendamento.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(tableSelectAnimalEditarAgendamento);
        if (tableSelectAnimalEditarAgendamento.getColumnModel().getColumnCount() > 0) {
            tableSelectAnimalEditarAgendamento.getColumnModel().getColumn(0).setMinWidth(40);
            tableSelectAnimalEditarAgendamento.getColumnModel().getColumn(0).setPreferredWidth(40);
            tableSelectAnimalEditarAgendamento.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        jLabel15.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Selecione o Animal");

        jLabel16.setText("Buscar pelo CPF do dono:");

        textPesquisaCpfEditarAgendamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textPesquisaCpfEditarAgendamentoKeyTyped(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Selecione a Data");

        spinnerDiaEditarAgendamento.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Dia:");

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Mês:");

        spinnerMesEditarAgendamento.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Ano:");

        spinnerAnoEditarAgendamento.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N

        jLabel21.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Selecione a Hora");

        spinnerHoraEditarAgendamento.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Hora:");

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Minuto:");

        spinnerMinutoEditarAgendamento.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N

        buttonEfetuarEditarAgendamento.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        buttonEfetuarEditarAgendamento.setForeground(new java.awt.Color(0, 153, 51));
        buttonEfetuarEditarAgendamento.setText("Salvar");
        buttonEfetuarEditarAgendamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEfetuarEditarAgendamentoActionPerformed(evt);
            }
        });

        buttonCancelarEditarAgendamento.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        buttonCancelarEditarAgendamento.setForeground(new java.awt.Color(153, 0, 51));
        buttonCancelarEditarAgendamento.setText("Cancelar");
        buttonCancelarEditarAgendamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarEditarAgendamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelEditarAgendamentoLayout = new javax.swing.GroupLayout(panelEditarAgendamento);
        panelEditarAgendamento.setLayout(panelEditarAgendamentoLayout);
        panelEditarAgendamentoLayout.setHorizontalGroup(
            panelEditarAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditarAgendamentoLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(panelEditarAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE))
                .addGap(43, 43, 43)
                .addGroup(panelEditarAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(textPesquisaCpfEditarAgendamento)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(43, 43, 43)
                .addGroup(panelEditarAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelEditarAgendamentoLayout.createSequentialGroup()
                        .addGroup(panelEditarAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(spinnerDiaEditarAgendamento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelEditarAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(spinnerMesEditarAgendamento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelEditarAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(spinnerAnoEditarAgendamento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelEditarAgendamentoLayout.createSequentialGroup()
                        .addGroup(panelEditarAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelEditarAgendamentoLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(spinnerHoraEditarAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelEditarAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(spinnerMinutoEditarAgendamento))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelEditarAgendamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEditarAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEditarAgendamentoLayout.createSequentialGroup()
                        .addComponent(buttonCancelarEditarAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonEfetuarEditarAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelEditarAgendamentoLayout.setVerticalGroup(
            panelEditarAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditarAgendamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelEditarAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEditarAgendamentoLayout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelEditarAgendamentoLayout.createSequentialGroup()
                        .addGroup(panelEditarAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelEditarAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelEditarAgendamentoLayout.createSequentialGroup()
                                .addGroup(panelEditarAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelEditarAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(panelEditarAgendamentoLayout.createSequentialGroup()
                                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(spinnerAnoEditarAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panelEditarAgendamentoLayout.createSequentialGroup()
                                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(panelEditarAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(spinnerMesEditarAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(spinnerDiaEditarAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(57, 57, 57)
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelEditarAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelEditarAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(spinnerHoraEditarAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spinnerMinutoEditarAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEditarAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEditarAgendamentoLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textPesquisaCpfEditarAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEditarAgendamentoLayout.createSequentialGroup()
                        .addGap(0, 139, Short.MAX_VALUE)
                        .addGroup(panelEditarAgendamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonCancelarEditarAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonEfetuarEditarAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        panelContent.add(panelEditarAgendamento, "editarAgendamento");

        title1.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        title1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title1.setText("Funcionários");

        tableFuncionarios.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tableFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableFuncionarios.setFocusable(false);
        tableFuncionarios.setRowHeight(32);
        tableFuncionarios.setSelectionBackground(new java.awt.Color(81, 81, 81));
        tableFuncionarios.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tableFuncionarios.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tableFuncionarios);

        jLabel24.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Funcionários");

        buttonCadastrarFuncionario.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        buttonCadastrarFuncionario.setText("Cadastrar Novo");
        buttonCadastrarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCadastrarFuncionarioActionPerformed(evt);
            }
        });

        buttonEditarFuncionario.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        buttonEditarFuncionario.setText("Editar");
        buttonEditarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditarFuncionarioActionPerformed(evt);
            }
        });

        buttonDeletarFuncionario.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        buttonDeletarFuncionario.setForeground(new java.awt.Color(197, 0, 0));
        buttonDeletarFuncionario.setText("Deletar");
        buttonDeletarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeletarFuncionarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelFuncionariosLayout = new javax.swing.GroupLayout(panelFuncionarios);
        panelFuncionarios.setLayout(panelFuncionariosLayout);
        panelFuncionariosLayout.setHorizontalGroup(
            panelFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFuncionariosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title1, javax.swing.GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelFuncionariosLayout.createSequentialGroup()
                        .addComponent(buttonCadastrarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonEditarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonDeletarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelFuncionariosLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );
        panelFuncionariosLayout.setVerticalGroup(
            panelFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFuncionariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(panelFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonCadastrarFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(buttonEditarFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonDeletarFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelContent.add(panelFuncionarios, "funcionarios");

        title7.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        title7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title7.setText("Funcionário");

        jLabel25.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Cadastrar novo Funcionário");

        jLabel33.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Selecione a Início do Expediente");

        spinnerHoraInicioCadastrarFuncionario.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N

        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Hora:");

        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Minuto:");

        spinnerMinutoInicioCadastrarFuncionario.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N

        buttonEfetuarCadastroFuncionario.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        buttonEfetuarCadastroFuncionario.setForeground(new java.awt.Color(0, 153, 51));
        buttonEfetuarCadastroFuncionario.setText("Cadastrar");
        buttonEfetuarCadastroFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEfetuarCadastroFuncionarioActionPerformed(evt);
            }
        });

        buttonCancelarCadastroFuncionario.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        buttonCancelarCadastroFuncionario.setForeground(new java.awt.Color(153, 0, 51));
        buttonCancelarCadastroFuncionario.setText("Cancelar");
        buttonCancelarCadastroFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarCadastroFuncionarioActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel26.setText("Nome");

        textNomeCadastrarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNomeCadastrarFuncionarioActionPerformed(evt);
            }
        });

        textUsuarioCadastrarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textUsuarioCadastrarFuncionarioActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel27.setText("Usuário");

        jLabel28.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel28.setText("Senha");

        comboCargoCadastrarFuncionario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel29.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel29.setText("Cargo");

        jLabel36.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("Selecione a Fim do Expediente");

        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Hora:");

        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("Minuto:");

        spinnerMinutoFimCadastrarFuncionario.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N

        spinnerHoraFimCadastrarFuncionario.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N

        javax.swing.GroupLayout panelCadastrarFuncionarioLayout = new javax.swing.GroupLayout(panelCadastrarFuncionario);
        panelCadastrarFuncionario.setLayout(panelCadastrarFuncionarioLayout);
        panelCadastrarFuncionarioLayout.setHorizontalGroup(
            panelCadastrarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCadastrarFuncionarioLayout.createSequentialGroup()
                .addGroup(panelCadastrarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCadastrarFuncionarioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelCadastrarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(title7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCadastrarFuncionarioLayout.createSequentialGroup()
                                .addComponent(buttonCancelarCadastroFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonEfetuarCadastroFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelCadastrarFuncionarioLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(panelCadastrarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addGroup(panelCadastrarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(textNomeCadastrarFuncionario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                .addComponent(textUsuarioCadastrarFuncionario, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(panelCadastrarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel26)
                                .addComponent(textSenhaCadastrarFuncionario)
                                .addComponent(jLabel29)
                                .addComponent(comboCargoCadastrarFuncionario, 0, 300, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelCadastrarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelCadastrarFuncionarioLayout.createSequentialGroup()
                                .addGroup(panelCadastrarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(spinnerHoraInicioCadastrarFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                                    .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelCadastrarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spinnerMinutoInicioCadastrarFuncionario)))
                            .addGroup(panelCadastrarFuncionarioLayout.createSequentialGroup()
                                .addGroup(panelCadastrarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(spinnerHoraFimCadastrarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelCadastrarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spinnerMinutoFimCadastrarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(69, 69, 69)))
                .addContainerGap())
        );
        panelCadastrarFuncionarioLayout.setVerticalGroup(
            panelCadastrarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCadastrarFuncionarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCadastrarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCadastrarFuncionarioLayout.createSequentialGroup()
                        .addComponent(textNomeCadastrarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textUsuarioCadastrarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCadastrarFuncionarioLayout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCadastrarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(panelCadastrarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spinnerHoraInicioCadastrarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerMinutoInicioCadastrarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCadastrarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCadastrarFuncionarioLayout.createSequentialGroup()
                        .addComponent(textSenhaCadastrarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboCargoCadastrarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                        .addGroup(panelCadastrarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonCancelarCadastroFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonEfetuarCadastroFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelCadastrarFuncionarioLayout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addGap(12, 12, 12)
                        .addGroup(panelCadastrarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCadastrarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spinnerHoraFimCadastrarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerMinutoFimCadastrarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        panelContent.add(panelCadastrarFuncionario, "cadastrarFuncionario");

        title8.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        title8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title8.setText("Funcionário");

        jLabel30.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Editar Funcionário");

        jLabel39.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("Selecione a Início do Expediente");

        spinnerHoraInicioEditarFuncionario.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N

        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("Hora:");

        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("Minuto:");

        spinnerMinutoInicioEditarFuncionario.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N

        buttonEfetuarEditarFuncionario.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        buttonEfetuarEditarFuncionario.setForeground(new java.awt.Color(0, 153, 51));
        buttonEfetuarEditarFuncionario.setText("Salvar");
        buttonEfetuarEditarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEfetuarEditarFuncionarioActionPerformed(evt);
            }
        });

        buttonCancelarEditarFuncionario.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        buttonCancelarEditarFuncionario.setForeground(new java.awt.Color(153, 0, 51));
        buttonCancelarEditarFuncionario.setText("Cancelar");
        buttonCancelarEditarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarEditarFuncionarioActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel31.setText("Nome");

        textNomeEditarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNomeEditarFuncionarioActionPerformed(evt);
            }
        });

        textUsuarioEditarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textUsuarioEditarFuncionarioActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel32.setText("Usuário");

        jLabel42.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel42.setText("Senha");

        comboCargoEditarFuncionario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel43.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel43.setText("Cargo");

        jLabel44.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("Selecione a Fim do Expediente");

        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText("Hora:");

        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText("Minuto:");

        spinnerMinutoFimEditarFuncionario.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N

        spinnerHoraFimEditarFuncionario.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N

        javax.swing.GroupLayout panelEditarFuncionarioLayout = new javax.swing.GroupLayout(panelEditarFuncionario);
        panelEditarFuncionario.setLayout(panelEditarFuncionarioLayout);
        panelEditarFuncionarioLayout.setHorizontalGroup(
            panelEditarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditarFuncionarioLayout.createSequentialGroup()
                .addGroup(panelEditarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEditarFuncionarioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelEditarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(title8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEditarFuncionarioLayout.createSequentialGroup()
                                .addComponent(buttonCancelarEditarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonEfetuarEditarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelEditarFuncionarioLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(panelEditarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32)
                            .addGroup(panelEditarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(textNomeEditarFuncionario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                .addComponent(textUsuarioEditarFuncionario, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel42, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(panelEditarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel31)
                                .addComponent(textSenhaEditarFuncionario)
                                .addComponent(jLabel43)
                                .addComponent(comboCargoEditarFuncionario, 0, 300, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelEditarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelEditarFuncionarioLayout.createSequentialGroup()
                                .addGroup(panelEditarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(spinnerHoraInicioEditarFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                                    .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelEditarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spinnerMinutoInicioEditarFuncionario)))
                            .addGroup(panelEditarFuncionarioLayout.createSequentialGroup()
                                .addGroup(panelEditarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(spinnerHoraFimEditarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel45, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelEditarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spinnerMinutoFimEditarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel44, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(69, 69, 69)))
                .addContainerGap())
        );
        panelEditarFuncionarioLayout.setVerticalGroup(
            panelEditarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditarFuncionarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEditarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEditarFuncionarioLayout.createSequentialGroup()
                        .addComponent(textNomeEditarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textUsuarioEditarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelEditarFuncionarioLayout.createSequentialGroup()
                        .addComponent(jLabel39)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelEditarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(panelEditarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spinnerHoraInicioEditarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerMinutoInicioEditarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jLabel42)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEditarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEditarFuncionarioLayout.createSequentialGroup()
                        .addComponent(textSenhaEditarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel43)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboCargoEditarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                        .addGroup(panelEditarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonCancelarEditarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonEfetuarEditarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelEditarFuncionarioLayout.createSequentialGroup()
                        .addComponent(jLabel44)
                        .addGap(12, 12, 12)
                        .addGroup(panelEditarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelEditarFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spinnerHoraFimEditarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerMinutoFimEditarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        panelContent.add(panelEditarFuncionario, "editarFuncionario");

        title9.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        title9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title9.setText("Clientes");

        jLabel47.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setText("Clientes");

        tableClientesPessoas.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tableClientesPessoas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableClientesPessoas.setFocusable(false);
        tableClientesPessoas.setRowHeight(32);
        tableClientesPessoas.setSelectionBackground(new java.awt.Color(81, 81, 81));
        tableClientesPessoas.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tableClientesPessoas.getTableHeader().setReorderingAllowed(false);
        jScrollPane7.setViewportView(tableClientesPessoas);

        buttonCadastrarCliente.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        buttonCadastrarCliente.setText("Cadastrar Novo");
        buttonCadastrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCadastrarClienteActionPerformed(evt);
            }
        });

        buttonEditarCliente.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        buttonEditarCliente.setText("Editar");
        buttonEditarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditarClienteActionPerformed(evt);
            }
        });

        buttonDeletarCliente.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        buttonDeletarCliente.setForeground(new java.awt.Color(197, 0, 0));
        buttonDeletarCliente.setText("Deletar");
        buttonDeletarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeletarClienteActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jButton1.setText("Listar Animais");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelClientesLayout = new javax.swing.GroupLayout(panelClientes);
        panelClientes.setLayout(panelClientesLayout);
        panelClientesLayout.setHorizontalGroup(
            panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelClientesLayout.createSequentialGroup()
                        .addComponent(buttonCadastrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonEditarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonDeletarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelClientesLayout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(title9, javax.swing.GroupLayout.PREFERRED_SIZE, 714, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 112, Short.MAX_VALUE))
                    .addGroup(panelClientesLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane7))
                    .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelClientesLayout.setVerticalGroup(
            panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonCadastrarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(buttonEditarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonDeletarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelContent.add(panelClientes, "clientes");

        title11.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        title11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title11.setText("Animais");

        jLabel49.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setText("Animais do cliente");

        tableClientesAnimais.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tableClientesAnimais.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableClientesAnimais.setFocusable(false);
        tableClientesAnimais.setRowHeight(32);
        tableClientesAnimais.setSelectionBackground(new java.awt.Color(81, 81, 81));
        tableClientesAnimais.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tableClientesAnimais.getTableHeader().setReorderingAllowed(false);
        jScrollPane8.setViewportView(tableClientesAnimais);

        buttonCadastrarClienteAnimal.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        buttonCadastrarClienteAnimal.setText("Cadastrar Novo");
        buttonCadastrarClienteAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCadastrarClienteAnimalActionPerformed(evt);
            }
        });

        buttonEditarClienteAnimal.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        buttonEditarClienteAnimal.setText("Editar");
        buttonEditarClienteAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditarClienteAnimalActionPerformed(evt);
            }
        });

        buttonDeletarClienteAnimal.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        buttonDeletarClienteAnimal.setForeground(new java.awt.Color(197, 0, 0));
        buttonDeletarClienteAnimal.setText("Deletar");
        buttonDeletarClienteAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeletarClienteAnimalActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jButton3.setText("Voltar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAnimalLayout = new javax.swing.GroupLayout(panelAnimal);
        panelAnimal.setLayout(panelAnimalLayout);
        panelAnimalLayout.setHorizontalGroup(
            panelAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAnimalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAnimalLayout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(title11, javax.swing.GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE)
                    .addComponent(jLabel49, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelAnimalLayout.createSequentialGroup()
                        .addComponent(buttonCadastrarClienteAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonEditarClienteAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonDeletarClienteAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelAnimalLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane8)))
                .addContainerGap())
        );
        panelAnimalLayout.setVerticalGroup(
            panelAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAnimalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonCadastrarClienteAnimal, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(buttonEditarClienteAnimal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonDeletarClienteAnimal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelContent.add(panelAnimal, "animais");

        title13.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        title13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title13.setText("Animais");

        jLabel51.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText("Cadastrar Animal");

        buttonCancelarCadastroAnimal.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        buttonCancelarCadastroAnimal.setForeground(new java.awt.Color(153, 0, 51));
        buttonCancelarCadastroAnimal.setText("Cancelar");
        buttonCancelarCadastroAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarCadastroAnimalActionPerformed(evt);
            }
        });

        buttonEfetuarCadastroAnimal.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        buttonEfetuarCadastroAnimal.setForeground(new java.awt.Color(0, 153, 51));
        buttonEfetuarCadastroAnimal.setText("Cadastrar");
        buttonEfetuarCadastroAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEfetuarCadastroAnimalActionPerformed(evt);
            }
        });

        jLabel60.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel60.setText("Nome:");

        jLabel61.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel61.setText("Espécie");

        javax.swing.GroupLayout panelCadastrarAnimalLayout = new javax.swing.GroupLayout(panelCadastrarAnimal);
        panelCadastrarAnimal.setLayout(panelCadastrarAnimalLayout);
        panelCadastrarAnimalLayout.setHorizontalGroup(
            panelCadastrarAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCadastrarAnimalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCadastrarAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCadastrarAnimalLayout.createSequentialGroup()
                        .addGroup(panelCadastrarAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(title13, javax.swing.GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE)
                            .addComponent(jLabel51, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCadastrarAnimalLayout.createSequentialGroup()
                        .addComponent(buttonCancelarCadastroAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonEfetuarCadastroAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(panelCadastrarAnimalLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(panelCadastrarAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(especieCadastrarAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomeCadastrarAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelCadastrarAnimalLayout.setVerticalGroup(
            panelCadastrarAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCadastrarAnimalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel60)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nomeCadastrarAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel61)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(especieCadastrarAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 336, Short.MAX_VALUE)
                .addGroup(panelCadastrarAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCancelarCadastroAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonEfetuarCadastroAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        panelContent.add(panelCadastrarAnimal, "cadastrarAnimal");

        title14.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        title14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title14.setText("Animais");

        jLabel62.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel62.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel62.setText("Editar Animal");

        buttonCancelarCadastroAnimal1.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        buttonCancelarCadastroAnimal1.setForeground(new java.awt.Color(153, 0, 51));
        buttonCancelarCadastroAnimal1.setText("Cancelar");
        buttonCancelarCadastroAnimal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarCadastroAnimal1ActionPerformed(evt);
            }
        });

        buttonEfetuarEditarAnimal.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        buttonEfetuarEditarAnimal.setForeground(new java.awt.Color(0, 153, 51));
        buttonEfetuarEditarAnimal.setText("Salvar");
        buttonEfetuarEditarAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEfetuarEditarAnimalActionPerformed(evt);
            }
        });

        jLabel63.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel63.setText("Nome:");

        jLabel64.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel64.setText("Espécie");

        javax.swing.GroupLayout panelEditarAnimalLayout = new javax.swing.GroupLayout(panelEditarAnimal);
        panelEditarAnimal.setLayout(panelEditarAnimalLayout);
        panelEditarAnimalLayout.setHorizontalGroup(
            panelEditarAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditarAnimalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEditarAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEditarAnimalLayout.createSequentialGroup()
                        .addGroup(panelEditarAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(title14, javax.swing.GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE)
                            .addComponent(jLabel62, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEditarAnimalLayout.createSequentialGroup()
                        .addComponent(buttonCancelarCadastroAnimal1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonEfetuarEditarAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(panelEditarAnimalLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(panelEditarAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(especieEditarAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomeEditarAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelEditarAnimalLayout.setVerticalGroup(
            panelEditarAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditarAnimalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel63)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nomeEditarAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel64)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(especieEditarAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 336, Short.MAX_VALUE)
                .addGroup(panelEditarAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCancelarCadastroAnimal1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonEfetuarEditarAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        panelContent.add(panelEditarAnimal, "editarAnimal");

        title12.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        title12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title12.setText("Clientes");

        jLabel50.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel50.setText("Cadastrar novo Cliente");

        buttonEfetuarCadastroFuncionario2.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        buttonEfetuarCadastroFuncionario2.setForeground(new java.awt.Color(0, 153, 51));
        buttonEfetuarCadastroFuncionario2.setText("Salvar");
        buttonEfetuarCadastroFuncionario2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEfetuarCadastroFuncionario2ActionPerformed(evt);
            }
        });

        buttonCancelarCadastroFuncionario2.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        buttonCancelarCadastroFuncionario2.setForeground(new java.awt.Color(153, 0, 51));
        buttonCancelarCadastroFuncionario2.setText("Cancelar");
        buttonCancelarCadastroFuncionario2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarCadastroFuncionario2ActionPerformed(evt);
            }
        });

        jLabel56.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel56.setText("Nome");

        nomeEditarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeEditarClienteActionPerformed(evt);
            }
        });

        cpfEditarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpfEditarClienteActionPerformed(evt);
            }
        });

        jLabel57.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel57.setText("CPF");

        jLabel58.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel58.setText("E-mail");

        jLabel59.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel59.setText("Telefone");

        javax.swing.GroupLayout panelEditarClienteLayout = new javax.swing.GroupLayout(panelEditarCliente);
        panelEditarCliente.setLayout(panelEditarClienteLayout);
        panelEditarClienteLayout.setHorizontalGroup(
            panelEditarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditarClienteLayout.createSequentialGroup()
                .addGroup(panelEditarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEditarClienteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelEditarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(title12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel50, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEditarClienteLayout.createSequentialGroup()
                                .addComponent(buttonCancelarCadastroFuncionario2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonEfetuarCadastroFuncionario2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelEditarClienteLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(panelEditarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel57)
                            .addComponent(jLabel56)
                            .addComponent(jLabel59)
                            .addComponent(nomeEditarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(cpfEditarCliente)
                            .addComponent(jLabel58)
                            .addComponent(emailEditarCliente)
                            .addComponent(telefoneEditarCliente))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelEditarClienteLayout.setVerticalGroup(
            panelEditarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditarClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel56)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nomeEditarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel57)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cpfEditarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel58)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailEditarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel59)
                .addGap(2, 2, 2)
                .addComponent(telefoneEditarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 170, Short.MAX_VALUE)
                .addGroup(panelEditarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCancelarCadastroFuncionario2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonEfetuarCadastroFuncionario2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        panelContent.add(panelEditarCliente, "editarCliente");

        title10.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        title10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title10.setText("Clientes");

        jLabel48.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel48.setText("Cadastrar novo Cliente");

        buttonEfetuarCadastroFuncionario1.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        buttonEfetuarCadastroFuncionario1.setForeground(new java.awt.Color(0, 153, 51));
        buttonEfetuarCadastroFuncionario1.setText("Cadastrar");
        buttonEfetuarCadastroFuncionario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEfetuarCadastroFuncionario1ActionPerformed(evt);
            }
        });

        buttonCancelarCadastroFuncionario1.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        buttonCancelarCadastroFuncionario1.setForeground(new java.awt.Color(153, 0, 51));
        buttonCancelarCadastroFuncionario1.setText("Cancelar");
        buttonCancelarCadastroFuncionario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarCadastroFuncionario1ActionPerformed(evt);
            }
        });

        jLabel52.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel52.setText("Nome");

        nomeCadastrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeCadastrarClienteActionPerformed(evt);
            }
        });

        cpfCadastrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpfCadastrarClienteActionPerformed(evt);
            }
        });

        jLabel53.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel53.setText("CPF");

        jLabel54.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel54.setText("E-mail");

        jLabel55.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel55.setText("Telefone");

        javax.swing.GroupLayout panelCadastrarClienteLayout = new javax.swing.GroupLayout(panelCadastrarCliente);
        panelCadastrarCliente.setLayout(panelCadastrarClienteLayout);
        panelCadastrarClienteLayout.setHorizontalGroup(
            panelCadastrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCadastrarClienteLayout.createSequentialGroup()
                .addGroup(panelCadastrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCadastrarClienteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelCadastrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(title10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel48, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCadastrarClienteLayout.createSequentialGroup()
                                .addComponent(buttonCancelarCadastroFuncionario1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonEfetuarCadastroFuncionario1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelCadastrarClienteLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(panelCadastrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel53)
                            .addComponent(jLabel52)
                            .addComponent(jLabel55)
                            .addComponent(nomeCadastrarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(cpfCadastrarCliente)
                            .addComponent(jLabel54)
                            .addComponent(emailCadastrarCliente)
                            .addComponent(telefoneCadastrarCliente))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelCadastrarClienteLayout.setVerticalGroup(
            panelCadastrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCadastrarClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel52)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nomeCadastrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel53)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cpfCadastrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel54)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailCadastrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel55)
                .addGap(2, 2, 2)
                .addComponent(telefoneCadastrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 170, Short.MAX_VALUE)
                .addGroup(panelCadastrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCancelarCadastroFuncionario1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonEfetuarCadastroFuncionario1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        panelContent.add(panelCadastrarCliente, "cadastrarCliente");

        title15.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        title15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title15.setText("Serviços");

        jLabel65.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel65.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel65.setText("Serviços");

        tableServicos.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tableServicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableServicos.setFocusable(false);
        tableServicos.setRowHeight(32);
        tableServicos.setSelectionBackground(new java.awt.Color(81, 81, 81));
        tableServicos.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tableServicos.getTableHeader().setReorderingAllowed(false);
        jScrollPane9.setViewportView(tableServicos);

        buttonCadastrarServico.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        buttonCadastrarServico.setText("Cadastrar Novo");
        buttonCadastrarServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCadastrarServicoActionPerformed(evt);
            }
        });

        buttonEditarServico.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        buttonEditarServico.setText("Editar");
        buttonEditarServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditarServicoActionPerformed(evt);
            }
        });

        buttonDeletarServico.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        buttonDeletarServico.setForeground(new java.awt.Color(197, 0, 0));
        buttonDeletarServico.setText("Deletar");
        buttonDeletarServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeletarServicoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelServicosLayout = new javax.swing.GroupLayout(panelServicos);
        panelServicos.setLayout(panelServicosLayout);
        panelServicosLayout.setHorizontalGroup(
            panelServicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelServicosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelServicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelServicosLayout.createSequentialGroup()
                        .addComponent(buttonCadastrarServico, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonEditarServico, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonDeletarServico, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelServicosLayout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(title15, javax.swing.GroupLayout.PREFERRED_SIZE, 714, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 112, Short.MAX_VALUE))
                    .addGroup(panelServicosLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane9))
                    .addComponent(jLabel65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelServicosLayout.setVerticalGroup(
            panelServicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelServicosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(panelServicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonCadastrarServico, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(buttonEditarServico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonDeletarServico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelContent.add(panelServicos, "servicos");

        title18.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        title18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title18.setText("Serviços");

        jLabel76.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel76.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel76.setText("Cadastrar Serviço");

        buttonCancelarCadastroAnimal4.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        buttonCancelarCadastroAnimal4.setForeground(new java.awt.Color(153, 0, 51));
        buttonCancelarCadastroAnimal4.setText("Cancelar");
        buttonCancelarCadastroAnimal4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarCadastroAnimal4ActionPerformed(evt);
            }
        });

        buttonEfetuarEdicao1.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        buttonEfetuarEdicao1.setForeground(new java.awt.Color(0, 153, 51));
        buttonEfetuarEdicao1.setText("Cadastrar");
        buttonEfetuarEdicao1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEfetuarEdicao1ActionPerformed(evt);
            }
        });

        jLabel77.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel77.setText("Nome");

        jLabel78.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel78.setText("Preço");

        jLabel79.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel79.setText("Duração (Em minutos)");

        tableResponsavelCadastrar.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tableResponsavelCadastrar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableResponsavelCadastrar.setRowHeight(40);
        tableResponsavelCadastrar.getTableHeader().setResizingAllowed(false);
        tableResponsavelCadastrar.getTableHeader().setReorderingAllowed(false);
        jScrollPane12.setViewportView(tableResponsavelCadastrar);
        if (tableResponsavelCadastrar.getColumnModel().getColumnCount() > 0) {
            tableResponsavelCadastrar.getColumnModel().getColumn(0).setMinWidth(40);
            tableResponsavelCadastrar.getColumnModel().getColumn(0).setPreferredWidth(40);
            tableResponsavelCadastrar.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        jLabel80.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel80.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel80.setText("Selecione o Responsável");

        javax.swing.GroupLayout panelCadastrarServicoLayout = new javax.swing.GroupLayout(panelCadastrarServico);
        panelCadastrarServico.setLayout(panelCadastrarServicoLayout);
        panelCadastrarServicoLayout.setHorizontalGroup(
            panelCadastrarServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCadastrarServicoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCadastrarServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCadastrarServicoLayout.createSequentialGroup()
                        .addGroup(panelCadastrarServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(title18, javax.swing.GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE)
                            .addComponent(jLabel76, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCadastrarServicoLayout.createSequentialGroup()
                        .addComponent(buttonCancelarCadastroAnimal4, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonEfetuarEdicao1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(panelCadastrarServicoLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(panelCadastrarServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(precoCadastrarServico, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                    .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomeCadastrarServico, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                    .addComponent(duracaoCadastrarServico)
                    .addComponent(jLabel79, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelCadastrarServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(113, 113, 113))
        );
        panelCadastrarServicoLayout.setVerticalGroup(
            panelCadastrarServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCadastrarServicoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelCadastrarServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel77)
                    .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCadastrarServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCadastrarServicoLayout.createSequentialGroup()
                        .addComponent(nomeCadastrarServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel78)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoCadastrarServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel79)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(duracaoCadastrarServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                .addGroup(panelCadastrarServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCancelarCadastroAnimal4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonEfetuarEdicao1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        panelContent.add(panelCadastrarServico, "cadastrarServico");

        title16.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        title16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title16.setText("Serviços");

        jLabel66.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel66.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel66.setText("Editar Serviço");

        buttonCancelarCadastroAnimal2.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        buttonCancelarCadastroAnimal2.setForeground(new java.awt.Color(153, 0, 51));
        buttonCancelarCadastroAnimal2.setText("Cancelar");
        buttonCancelarCadastroAnimal2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarCadastroAnimal2ActionPerformed(evt);
            }
        });

        buttonEfetuarEdicao.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        buttonEfetuarEdicao.setForeground(new java.awt.Color(0, 153, 51));
        buttonEfetuarEdicao.setText("Concluir");
        buttonEfetuarEdicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEfetuarEdicaoActionPerformed(evt);
            }
        });

        jLabel67.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel67.setText("Nome");

        jLabel68.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel68.setText("Preço");

        jLabel69.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel69.setText("Duração");

        tableResponsavel.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tableResponsavel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableResponsavel.setRowHeight(40);
        tableResponsavel.getTableHeader().setResizingAllowed(false);
        tableResponsavel.getTableHeader().setReorderingAllowed(false);
        jScrollPane10.setViewportView(tableResponsavel);
        if (tableResponsavel.getColumnModel().getColumnCount() > 0) {
            tableResponsavel.getColumnModel().getColumn(0).setMinWidth(40);
            tableResponsavel.getColumnModel().getColumn(0).setPreferredWidth(40);
            tableResponsavel.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        jLabel71.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel71.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel71.setText("Selecione o Responsável");

        javax.swing.GroupLayout panelEditarServicoLayout = new javax.swing.GroupLayout(panelEditarServico);
        panelEditarServico.setLayout(panelEditarServicoLayout);
        panelEditarServicoLayout.setHorizontalGroup(
            panelEditarServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditarServicoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEditarServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEditarServicoLayout.createSequentialGroup()
                        .addGroup(panelEditarServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(title16, javax.swing.GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE)
                            .addComponent(jLabel66, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEditarServicoLayout.createSequentialGroup()
                        .addComponent(buttonCancelarCadastroAnimal2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonEfetuarEdicao, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(panelEditarServicoLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(panelEditarServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(precoEditarServico, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                    .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomeEditarServico, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                    .addComponent(duracaoEditarServico))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelEditarServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(113, 113, 113))
        );
        panelEditarServicoLayout.setVerticalGroup(
            panelEditarServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditarServicoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelEditarServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel67)
                    .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEditarServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEditarServicoLayout.createSequentialGroup()
                        .addComponent(nomeEditarServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel68)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoEditarServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel69)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(duracaoEditarServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                .addGroup(panelEditarServicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCancelarCadastroAnimal2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonEfetuarEdicao, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        panelContent.add(panelEditarServico, "editarServico");

        title2.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        title2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title2.setText("Mercadorias");

        tableMercadorias.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tableMercadorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableMercadorias.setFocusable(false);
        tableMercadorias.setRowHeight(32);
        tableMercadorias.setSelectionBackground(new java.awt.Color(81, 81, 81));
        tableMercadorias.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tableMercadorias.getTableHeader().setReorderingAllowed(false);
        jScrollPane11.setViewportView(tableMercadorias);

        jLabel70.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel70.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel70.setText("Mercadorias");

        agendamentosExibirHoje1.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        agendamentosExibirHoje1.setText("Roupas");
        agendamentosExibirHoje1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agendamentosExibirHoje1ActionPerformed(evt);
            }
        });

        agendamentosExibirAmanha1.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        agendamentosExibirAmanha1.setText("Rações");
        agendamentosExibirAmanha1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agendamentosExibirAmanha1ActionPerformed(evt);
            }
        });

        agendamentosExibirTodos1.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        agendamentosExibirTodos1.setText("Remédios");
        agendamentosExibirTodos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agendamentosExibirTodos1ActionPerformed(evt);
            }
        });

        buttonDeletarAgendamento1.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        buttonDeletarAgendamento1.setForeground(new java.awt.Color(197, 0, 0));
        buttonDeletarAgendamento1.setText("Deletar");
        buttonDeletarAgendamento1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeletarAgendamento1ActionPerformed(evt);
            }
        });

        jButton2.setText("Brinquedos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("Tudo");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelMercadoriasLayout = new javax.swing.GroupLayout(painelMercadorias);
        painelMercadorias.setLayout(painelMercadoriasLayout);
        painelMercadoriasLayout.setHorizontalGroup(
            painelMercadoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelMercadoriasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelMercadoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel70, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painelMercadoriasLayout.createSequentialGroup()
                        .addComponent(agendamentosExibirHoje1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(agendamentosExibirAmanha1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(agendamentosExibirTodos1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelMercadoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelMercadoriasLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(buttonDeletarAgendamento1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painelMercadoriasLayout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 283, Short.MAX_VALUE)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(painelMercadoriasLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane11)))
                .addContainerGap())
        );
        painelMercadoriasLayout.setVerticalGroup(
            painelMercadoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelMercadoriasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelMercadoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(agendamentosExibirAmanha1, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(agendamentosExibirHoje1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(agendamentosExibirTodos1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonDeletarAgendamento1, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelContent.add(painelMercadorias, "mercadorias");

        title17.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        title17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title17.setText("Mercadorias");

        tableBrinquedos.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tableBrinquedos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableBrinquedos.setFocusable(false);
        tableBrinquedos.setRowHeight(32);
        tableBrinquedos.setSelectionBackground(new java.awt.Color(81, 81, 81));
        tableBrinquedos.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tableBrinquedos.getTableHeader().setReorderingAllowed(false);
        jScrollPane15.setViewportView(tableBrinquedos);

        jLabel74.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel74.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel74.setText("Brinquedos");

        agendamentosExibirHoje4.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        agendamentosExibirHoje4.setText("Roupas");
        agendamentosExibirHoje4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agendamentosExibirHoje4ActionPerformed(evt);
            }
        });

        agendamentosExibirAmanha4.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        agendamentosExibirAmanha4.setText("Rações");
        agendamentosExibirAmanha4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agendamentosExibirAmanha4ActionPerformed(evt);
            }
        });

        agendamentosExibirTodos4.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        agendamentosExibirTodos4.setText("Remédios");
        agendamentosExibirTodos4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agendamentosExibirTodos4ActionPerformed(evt);
            }
        });

        buttonCadastrarAgendamento4.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        buttonCadastrarAgendamento4.setText("Cadastrar Novo");
        buttonCadastrarAgendamento4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCadastrarAgendamento4ActionPerformed(evt);
            }
        });

        buttonDeletarAgendamento4.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        buttonDeletarAgendamento4.setForeground(new java.awt.Color(197, 0, 0));
        buttonDeletarAgendamento4.setText("Deletar");
        buttonDeletarAgendamento4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeletarAgendamento4ActionPerformed(evt);
            }
        });

        buttonEditarAgendamento4.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        buttonEditarAgendamento4.setText("Editar");
        buttonEditarAgendamento4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditarAgendamento4ActionPerformed(evt);
            }
        });

        jButton9.setText("Brinquedos");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("Tudo");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBrinquedoLayout = new javax.swing.GroupLayout(panelBrinquedo);
        panelBrinquedo.setLayout(panelBrinquedoLayout);
        panelBrinquedoLayout.setHorizontalGroup(
            panelBrinquedoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBrinquedoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBrinquedoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel74, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelBrinquedoLayout.createSequentialGroup()
                        .addGroup(panelBrinquedoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBrinquedoLayout.createSequentialGroup()
                                .addComponent(agendamentosExibirHoje4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(agendamentosExibirAmanha4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(buttonCadastrarAgendamento4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(agendamentosExibirTodos4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBrinquedoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBrinquedoLayout.createSequentialGroup()
                                .addGap(0, 127, Short.MAX_VALUE)
                                .addComponent(buttonEditarAgendamento4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonDeletarAgendamento4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBrinquedoLayout.createSequentialGroup()
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelBrinquedoLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane15)))
                .addContainerGap())
        );
        panelBrinquedoLayout.setVerticalGroup(
            panelBrinquedoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBrinquedoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBrinquedoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(agendamentosExibirAmanha4, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(agendamentosExibirHoje4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(agendamentosExibirTodos4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBrinquedoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonEditarAgendamento4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonDeletarAgendamento4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonCadastrarAgendamento4, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelContent.add(panelBrinquedo, "brinquedos");

        title19.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        title19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title19.setText("Mercadorias");

        tableRacoes.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tableRacoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableRacoes.setFocusable(false);
        tableRacoes.setRowHeight(32);
        tableRacoes.setSelectionBackground(new java.awt.Color(81, 81, 81));
        tableRacoes.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tableRacoes.getTableHeader().setReorderingAllowed(false);
        jScrollPane16.setViewportView(tableRacoes);

        jLabel75.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel75.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel75.setText("Rações");

        agendamentosExibirHoje5.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        agendamentosExibirHoje5.setText("Roupas");
        agendamentosExibirHoje5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agendamentosExibirHoje5ActionPerformed(evt);
            }
        });

        agendamentosExibirAmanha5.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        agendamentosExibirAmanha5.setText("Rações");
        agendamentosExibirAmanha5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agendamentosExibirAmanha5ActionPerformed(evt);
            }
        });

        agendamentosExibirTodos5.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        agendamentosExibirTodos5.setText("Remédios");
        agendamentosExibirTodos5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agendamentosExibirTodos5ActionPerformed(evt);
            }
        });

        buttonCadastrarAgendamento5.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        buttonCadastrarAgendamento5.setText("Cadastrar Novo");
        buttonCadastrarAgendamento5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCadastrarAgendamento5ActionPerformed(evt);
            }
        });

        buttonDeletarAgendamento5.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        buttonDeletarAgendamento5.setForeground(new java.awt.Color(197, 0, 0));
        buttonDeletarAgendamento5.setText("Deletar");
        buttonDeletarAgendamento5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeletarAgendamento5ActionPerformed(evt);
            }
        });

        buttonEditarAgendamento5.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        buttonEditarAgendamento5.setText("Editar");
        buttonEditarAgendamento5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditarAgendamento5ActionPerformed(evt);
            }
        });

        jButton11.setText("Brinquedos");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("Tudo");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRacaoLayout = new javax.swing.GroupLayout(panelRacao);
        panelRacao.setLayout(panelRacaoLayout);
        panelRacaoLayout.setHorizontalGroup(
            panelRacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel75, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelRacaoLayout.createSequentialGroup()
                        .addGroup(panelRacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRacaoLayout.createSequentialGroup()
                                .addComponent(agendamentosExibirHoje5, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(agendamentosExibirAmanha5, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(buttonCadastrarAgendamento5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(agendamentosExibirTodos5, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelRacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRacaoLayout.createSequentialGroup()
                                .addGap(0, 127, Short.MAX_VALUE)
                                .addComponent(buttonEditarAgendamento5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonDeletarAgendamento5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelRacaoLayout.createSequentialGroup()
                                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelRacaoLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane16)))
                .addContainerGap())
        );
        panelRacaoLayout.setVerticalGroup(
            panelRacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(agendamentosExibirAmanha5, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(agendamentosExibirHoje5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(agendamentosExibirTodos5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonEditarAgendamento5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonDeletarAgendamento5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonCadastrarAgendamento5, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelContent.add(panelRacao, "racoes");

        title4.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        title4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title4.setText("Mercadorias");

        tableRemedios.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tableRemedios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableRemedios.setFocusable(false);
        tableRemedios.setRowHeight(32);
        tableRemedios.setSelectionBackground(new java.awt.Color(81, 81, 81));
        tableRemedios.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tableRemedios.getTableHeader().setReorderingAllowed(false);
        jScrollPane14.setViewportView(tableRemedios);

        jLabel73.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel73.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel73.setText("Remédios");

        agendamentosExibirHoje3.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        agendamentosExibirHoje3.setText("Roupas");
        agendamentosExibirHoje3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agendamentosExibirHoje3ActionPerformed(evt);
            }
        });

        agendamentosExibirAmanha3.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        agendamentosExibirAmanha3.setText("Rações");
        agendamentosExibirAmanha3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agendamentosExibirAmanha3ActionPerformed(evt);
            }
        });

        agendamentosExibirTodos3.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        agendamentosExibirTodos3.setText("Remédios");
        agendamentosExibirTodos3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agendamentosExibirTodos3ActionPerformed(evt);
            }
        });

        buttonCadastrarAgendamento3.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        buttonCadastrarAgendamento3.setText("Cadastrar Novo");
        buttonCadastrarAgendamento3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCadastrarAgendamento3ActionPerformed(evt);
            }
        });

        buttonDeletarAgendamento3.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        buttonDeletarAgendamento3.setForeground(new java.awt.Color(197, 0, 0));
        buttonDeletarAgendamento3.setText("Deletar");
        buttonDeletarAgendamento3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeletarAgendamento3ActionPerformed(evt);
            }
        });

        buttonEditarAgendamento3.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        buttonEditarAgendamento3.setText("Editar");
        buttonEditarAgendamento3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditarAgendamento3ActionPerformed(evt);
            }
        });

        jButton7.setText("Brinquedos");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Tudo");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRemedioLayout = new javax.swing.GroupLayout(panelRemedio);
        panelRemedio.setLayout(panelRemedioLayout);
        panelRemedioLayout.setHorizontalGroup(
            panelRemedioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRemedioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRemedioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel73, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelRemedioLayout.createSequentialGroup()
                        .addGroup(panelRemedioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRemedioLayout.createSequentialGroup()
                                .addComponent(agendamentosExibirHoje3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(agendamentosExibirAmanha3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(buttonCadastrarAgendamento3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(agendamentosExibirTodos3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelRemedioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRemedioLayout.createSequentialGroup()
                                .addGap(0, 127, Short.MAX_VALUE)
                                .addComponent(buttonEditarAgendamento3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonDeletarAgendamento3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelRemedioLayout.createSequentialGroup()
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelRemedioLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane14)))
                .addContainerGap())
        );
        panelRemedioLayout.setVerticalGroup(
            panelRemedioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRemedioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRemedioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(agendamentosExibirAmanha3, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(agendamentosExibirHoje3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(agendamentosExibirTodos3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRemedioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonEditarAgendamento3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonDeletarAgendamento3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonCadastrarAgendamento3, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelContent.add(panelRemedio, "remedios");

        title3.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        title3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title3.setText("Mercadorias");

        tableRoupas.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        tableRoupas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableRoupas.setFocusable(false);
        tableRoupas.setRowHeight(32);
        tableRoupas.setSelectionBackground(new java.awt.Color(81, 81, 81));
        tableRoupas.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tableRoupas.getTableHeader().setReorderingAllowed(false);
        jScrollPane13.setViewportView(tableRoupas);

        jLabel72.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel72.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel72.setText("Roupas");

        agendamentosExibirHoje2.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        agendamentosExibirHoje2.setText("Roupas");
        agendamentosExibirHoje2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agendamentosExibirHoje2ActionPerformed(evt);
            }
        });

        agendamentosExibirAmanha2.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        agendamentosExibirAmanha2.setText("Rações");
        agendamentosExibirAmanha2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agendamentosExibirAmanha2ActionPerformed(evt);
            }
        });

        agendamentosExibirTodos2.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        agendamentosExibirTodos2.setText("Remédios");
        agendamentosExibirTodos2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agendamentosExibirTodos2ActionPerformed(evt);
            }
        });

        buttonCadastrarAgendamento2.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        buttonCadastrarAgendamento2.setText("Cadastrar Novo");
        buttonCadastrarAgendamento2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCadastrarAgendamento2ActionPerformed(evt);
            }
        });

        buttonDeletarAgendamento2.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        buttonDeletarAgendamento2.setForeground(new java.awt.Color(197, 0, 0));
        buttonDeletarAgendamento2.setText("Deletar");
        buttonDeletarAgendamento2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeletarAgendamento2ActionPerformed(evt);
            }
        });

        buttonEditarAgendamento2.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        buttonEditarAgendamento2.setText("Editar");
        buttonEditarAgendamento2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditarAgendamento2ActionPerformed(evt);
            }
        });

        jButton5.setText("Brinquedos");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Tudo");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRoupaLayout = new javax.swing.GroupLayout(panelRoupa);
        panelRoupa.setLayout(panelRoupaLayout);
        panelRoupaLayout.setHorizontalGroup(
            panelRoupaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoupaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRoupaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel72, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelRoupaLayout.createSequentialGroup()
                        .addGroup(panelRoupaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRoupaLayout.createSequentialGroup()
                                .addComponent(agendamentosExibirHoje2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(agendamentosExibirAmanha2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(buttonCadastrarAgendamento2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(agendamentosExibirTodos2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelRoupaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRoupaLayout.createSequentialGroup()
                                .addGap(0, 127, Short.MAX_VALUE)
                                .addComponent(buttonEditarAgendamento2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonDeletarAgendamento2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelRoupaLayout.createSequentialGroup()
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelRoupaLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane13)))
                .addContainerGap())
        );
        panelRoupaLayout.setVerticalGroup(
            panelRoupaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoupaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRoupaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(agendamentosExibirAmanha2, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(agendamentosExibirHoje2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(agendamentosExibirTodos2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRoupaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonEditarAgendamento2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonDeletarAgendamento2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonCadastrarAgendamento2, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelContent.add(panelRoupa, "roupas");

        getContentPane().add(panelContent, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 950, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadTableAgendamento(String caso){
        DefaultTableModel dtm = new DefaultTableModel(new String[] {"ID","Nome", "Serviço", "Horário"}, 0);
        
        AgendamentoCtrl fc = new AgendamentoCtrl();
        
        ArrayList<Agendamento> listaAgendamentos = fc.exibirAgendamentos(caso);

        for (Agendamento f : listaAgendamentos) {
            dtm.addRow(new Object[] {
                f.getId(),
                f.getAnimal().getNome(),
                f.getServico().getNome(),
                f.getDataHoraString()
            });
        }
        
        tableAgendamentos.setModel(dtm);
    }
    
    private void loadTableClientesPessoa(){
        DefaultTableModel dtm = new DefaultTableModel(new String[] {"ID","Nome", "CPF", "Email", "Telefone"}, 0);
        
        ClienteCtrl fc = new ClienteCtrl();
        
        ArrayList<Cliente> lista = fc.exibirPessoas();

        for (Cliente f : lista) {
            Pessoa p = (Pessoa) f;
            dtm.addRow(new Object[] {
                p.getId(),
                p.getNome(),
                p.getCpf(),
                p.getEmail(),
                p.getTelefone()
            });
        }
        
        tableClientesPessoas.setModel(dtm);
    }
    
    private void loadTableServico(JTable table){
        DefaultTableModel dtm = new DefaultTableModel(new String[] {"ID","Nome"}, 0);
        
        ItemCtrl ic = new ItemCtrl();
        
        ArrayList<Item> lista = ic.exibirServicos();

        for (Item f : lista) {
            dtm.addRow(new Object[] {
                f.getId(),
                f.getNome()
            });
        }
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setModel(dtm);
        table.getColumnModel().getColumn(0).setPreferredWidth(40);
        table.getColumnModel().getColumn(0).setMinWidth(40);
        table.getColumnModel().getColumn(0).setMaxWidth(40);
    }
    
    private void loadTableServicos(){
        DefaultTableModel dtm = new DefaultTableModel(new String[] {"ID","Nome", "Preco", "Responsavel", "Duração (minutos)"}, 0);
        
        ItemCtrl ic = new ItemCtrl();
        
        ArrayList<Item> lista = ic.exibirServicos();
        
        FuncionarioCtrl fc = new FuncionarioCtrl(logado);
        
        for (Item i : lista) {
            Servico f = (Servico) i;
            dtm.addRow(new Object[] {
                f.getId(),
                f.getNome(),
                f.getPreco(),
                fc.exibirPorId(f.getIdResponsavel()).getNome(),
                f.getDuracao()
            });
        }
        tableServicos.setModel(dtm);
    }
    
    
    private void loadTableMercadorias(){
        DefaultTableModel dtm = new DefaultTableModel(new String[] {"ID","Nome", "Preco", "Categoria"}, 0);
        
        ItemCtrl ic = new ItemCtrl();
        
        ArrayList<Item> lista = ic.exibirProdutos();
        
        FuncionarioCtrl fc = new FuncionarioCtrl(logado);
        
        for (Item f : lista) {
            dtm.addRow(new Object[] {
                f.getId(),
                f.getNome(),
                f.getPreco(),
                f.getCategoria()
            });
        }
        tableMercadorias.setModel(dtm);
    }
    
    private void loadTableRoupas(){
        DefaultTableModel dtm = new DefaultTableModel(new String[] {"ID","Nome", "Preco", "Tamanho", "Cor", "Especie"}, 0);
        
        ItemCtrl ic = new ItemCtrl();
        
        ArrayList<Item> lista = ic.exibirProdutos();
        
        FuncionarioCtrl fc = new FuncionarioCtrl(logado);
        
        for (Item r : lista) {
            if(r instanceof Roupa){
                Roupa f = (Roupa) r;
                dtm.addRow(new Object[] {
                    f.getId(),
                    f.getNome(),
                    f.getPreco(),
                    f.getTamanho(),
                    f.getCor(),
                    f.getEspecie()
                });
            }
            
        }
        tableRoupas.setModel(dtm);
    }
    
    private void loadTableRacoes(){
        DefaultTableModel dtm = new DefaultTableModel(new String[] {"ID","Nome", "Preco", "Sabor", "Idade Recomendada", "Especie"}, 0);
        
        ItemCtrl ic = new ItemCtrl();
        
        ArrayList<Item> lista = ic.exibirProdutos();
        
        FuncionarioCtrl fc = new FuncionarioCtrl(logado);
        
        for (Item r : lista) {
            if(r instanceof Racao){
                Racao f = (Racao) r;
                dtm.addRow(new Object[] {
                    f.getId(),
                    f.getNome(),
                    f.getPreco(),
                    f.getSabor(),
                    f.getIdade_recomendada(),
                    f.getEspecie()
                });
            }
        }
        tableRacoes.setModel(dtm);
    }
    
    private void loadTableRemedios(){
        DefaultTableModel dtm = new DefaultTableModel(new String[] {"ID","Nome", "Preco", "Utilidade", "Orientação"}, 0);
        
        ItemCtrl ic = new ItemCtrl();
        
        ArrayList<Item> lista = ic.exibirProdutos();
        
        FuncionarioCtrl fc = new FuncionarioCtrl(logado);
        
        for (Item r : lista) {
            if(r instanceof Remedio){
                Remedio f = (Remedio) r;
                dtm.addRow(new Object[] {
                    f.getId(),
                    f.getNome(),
                    f.getPreco(),
                    f.getUtilidade(),
                    f.getOrientacao()
                });
            }
        }
        tableRemedios.setModel(dtm);
    }
    
    private void loadTableBrinquedos(){
        DefaultTableModel dtm = new DefaultTableModel(new String[] {"ID","Nome", "Preco", "Espécie", "Material"}, 0);
        
        ItemCtrl ic = new ItemCtrl();
        
        ArrayList<Item> lista = ic.exibirProdutos();
        
        FuncionarioCtrl fc = new FuncionarioCtrl(logado);
        
        for (Item r : lista) {
            if(r instanceof Brinquedo){
                Brinquedo f = (Brinquedo) r;
                dtm.addRow(new Object[] {
                    f.getId(),
                    f.getNome(),
                    f.getPreco(),
                    f.getEspecie(),
                    f.getMaterial()
                });
            }
        }
        tableBrinquedos.setModel(dtm);
    }
    
    
    
    
    private void loadTableAnimal(JTable table, String cpfDono){
        DefaultTableModel dtm = new DefaultTableModel(new String[] {"ID","Nome"}, 0);
        
        ClienteCtrl cc = new ClienteCtrl();
        
        ArrayList<Cliente> lista = cc.exibirAnimais(cpfDono);

        for (Cliente f : lista) {
            dtm.addRow(new Object[] {
                f.getId(),
                f.getNome()
            });
        }
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setModel(dtm);
        table.getColumnModel().getColumn(0).setPreferredWidth(40);
        table.getColumnModel().getColumn(0).setMinWidth(40);
        table.getColumnModel().getColumn(0).setMaxWidth(40);
    }
    
    private void loadTableResponsavel(JTable table){
        DefaultTableModel dtm = new DefaultTableModel(new String[] {"ID","Nome"}, 0);
        
        FuncionarioCtrl cc = new FuncionarioCtrl(logado);
        
        ArrayList<Funcionario> lista = cc.exibir();

        for (Funcionario f : lista) {
            dtm.addRow(new Object[] {
                f.getId(),
                f.getNome()
            });
        }
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setModel(dtm);
        table.getColumnModel().getColumn(0).setPreferredWidth(40);
        table.getColumnModel().getColumn(0).setMinWidth(40);
        table.getColumnModel().getColumn(0).setMaxWidth(40);
    }
    
    private void loadTableClienteAnimal(String cpfDono){
        DefaultTableModel dtm = new DefaultTableModel(new String[] {"ID","Nome", "Espécie"}, 0);
        
        ClienteCtrl cc = new ClienteCtrl();
        
        ArrayList<Cliente> lista = cc.exibirAnimais(cpfDono);

        for (Cliente a : lista) {
            Animal f = (Animal) a;
            dtm.addRow(new Object[] {
                f.getId(),
                f.getNome(),
                f.getEspecie(),
            });
        }
        tableClientesAnimais.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableClientesAnimais.setModel(dtm);
    }
    
    private void loadTableFuncionario(){
        DefaultTableModel dtm = new DefaultTableModel(new String[] {"ID","Cargo", "Username", "Nome", "Início Expediente", "Fim Expediente"}, 0);
        
        FuncionarioCtrl fc = new FuncionarioCtrl(this.logado);
        
        ArrayList<Funcionario> lista = fc.exibir();

        for (Funcionario f : lista) {
            dtm.addRow(new Object[] {
                f.getId(),
                f.getCargo(),
                f.getUsername(),
                f.getNome(),
                f.getStartTime(),
                f.getEndTime()
            });
        }
        
        tableFuncionarios.setModel(dtm);
    }
    
    
    private boolean validarCpf(String cpf){
        if (cpf == null) {
            return false;
        }
        // removendo caracteres especiais
        cpf = cpf.replaceAll("[.-]", "");
        if (cpf.length() != 11 || cpf.equals("00000000000") || cpf.equals("11111111111") ||
            cpf.equals("22222222222") || cpf.equals("33333333333") || cpf.equals("44444444444") ||
            cpf.equals("55555555555") || cpf.equals("66666666666") || cpf.equals("77777777777") ||
            cpf.equals("88888888888") || cpf.equals("99999999999")) {
            return false;
        }
        char dig10, dig11;
        int sm, i, r, num, peso;
        try {
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                num = (int) (cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig10 = '0';
            } else {
                dig10 = (char) (r + 48);
            }
            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig11 = '0';
            } else {
                dig11 = (char) (r + 48);
            }
            if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10))) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
    
    private boolean validarEmail(String email){
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null) {
            return false;
        }
        return pat.matcher(email).matches();
    }
    
    private boolean validarTelefone(String phone){
        String phoneNumberRegex = "^\\(?([0-9]{2})\\)?[-.\\s]?([0-9]{5})[-.\\s]?([0-9]{4})$";
        Pattern pat = Pattern.compile(phoneNumberRegex);
        if (phone == null) {
            return false;
        }
        if(phone.length() == 11) {
            return true;
        }
        
        return pat.matcher(phone).matches();
    }
    
    private void buttonInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInicioActionPerformed
        // TODO add your handling code here:
        layout.show(panelContent, "inicio");
    }//GEN-LAST:event_buttonInicioActionPerformed

    private void buttonMercadoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMercadoriasActionPerformed
        // TODO add your handling code here:
        loadTableMercadorias();
        layout.show(panelContent, "mercadorias");
    }//GEN-LAST:event_buttonMercadoriasActionPerformed

    private void buttonFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFuncionariosActionPerformed
        // TODO add your handling code here:
        loadTableFuncionario();
        layout.show(panelContent, "funcionarios");
    }//GEN-LAST:event_buttonFuncionariosActionPerformed

    private void buttonClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClientesActionPerformed
        // TODO add your handling code here:
        loadTableClientesPessoa();
        layout.show(panelContent, "clientes");
    }//GEN-LAST:event_buttonClientesActionPerformed

    private void buttonServicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonServicosActionPerformed
        // TODO add your handling code here:
        loadTableServicos();
        layout.show(panelContent, "servicos");
    }//GEN-LAST:event_buttonServicosActionPerformed

    private void agendamentosExibirTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agendamentosExibirTodosActionPerformed
        caseListAgendamento = "todos";
        loadTableAgendamento(caseListAgendamento);
    }//GEN-LAST:event_agendamentosExibirTodosActionPerformed

    private void agendamentosExibirAmanhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agendamentosExibirAmanhaActionPerformed
        caseListAgendamento = "amanha";
        loadTableAgendamento(caseListAgendamento);
    }//GEN-LAST:event_agendamentosExibirAmanhaActionPerformed

    private void agendamentosExibirHojeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agendamentosExibirHojeActionPerformed
        caseListAgendamento = "hoje";
        loadTableAgendamento(caseListAgendamento);
    }//GEN-LAST:event_agendamentosExibirHojeActionPerformed

    private void buttonDeletarAgendamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeletarAgendamentoActionPerformed
        AgendamentoCtrl ac = new AgendamentoCtrl();

        int linhaSelecionada = tableAgendamentos.getSelectedRow();
        if (linhaSelecionada != -1) {
            DefaultTableModel model = (DefaultTableModel) tableAgendamentos.getModel();
            int id = (Integer) model.getValueAt(linhaSelecionada, 0); 
            ac.excluir(id);
            loadTableAgendamento(caseListAgendamento);
        }
        
    }//GEN-LAST:event_buttonDeletarAgendamentoActionPerformed

    private void buttonEditarAgendamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditarAgendamentoActionPerformed
        int linhaSelecionada = tableAgendamentos.getSelectedRow();
        int id = 0;
        if (linhaSelecionada != -1) {
            DefaultTableModel model = (DefaultTableModel) tableAgendamentos.getModel();
            id = (Integer) model.getValueAt(linhaSelecionada, 0);
            
            AgendamentoCtrl ac = new AgendamentoCtrl();
        
            this.anterior = ac.exibirAgendamentoById(id);
            
            //popula data
            spinnerAnoEditarAgendamento.setValue(anterior.getData_hora().getYear());
            spinnerMesEditarAgendamento.setValue(anterior.getData_hora().getMonth());
            spinnerDiaEditarAgendamento.setValue(anterior.getData_hora().getDate());
            spinnerHoraEditarAgendamento.setValue(anterior.getData_hora().getHours());
            spinnerMinutoEditarAgendamento.setValue(anterior.getData_hora().getMinutes());

            // carrega tabelas atualizadas
            loadTableServico(tableSelectServicoEditarAgendamento);
            loadTableAnimal(tableSelectAnimalEditarAgendamento, textPesquisaCpfEditarAgendamento.getText());

            // seleciona na tabela o animal p editar
            TableModel animal = tableSelectAnimalEditarAgendamento.getModel();
            int idLinhaSelecionada = 0, nLinhaSelecionada = 0;
            for(int i = 0; i < animal.getColumnCount(); i++){
                idLinhaSelecionada = (Integer) animal.getValueAt(i, 0);
                nLinhaSelecionada = i;
                if(this.anterior.getAnimal().getId() == idLinhaSelecionada) break; 
            }
            tableSelectAnimalEditarAgendamento.getSelectionModel().setSelectionInterval(nLinhaSelecionada, nLinhaSelecionada);
            
            // seleciona ma tabela o servico p editar
            TableModel servico = tableSelectServicoEditarAgendamento.getModel();
            idLinhaSelecionada = 0; 
            nLinhaSelecionada = 0;
            for(int i = 0; i < servico.getColumnCount(); i++){
                idLinhaSelecionada = (Integer) servico.getValueAt(i, 0);
                nLinhaSelecionada = i;
                if(anterior.getServico().getId() == idLinhaSelecionada) break; 
            }
            tableSelectServicoEditarAgendamento.getSelectionModel().setSelectionInterval(nLinhaSelecionada, nLinhaSelecionada);

            layout.show(panelContent, "editarAgendamento");

        }
        
        
    }//GEN-LAST:event_buttonEditarAgendamentoActionPerformed

    private void buttonCadastrarAgendamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCadastrarAgendamentoActionPerformed
        loadTableServico(tableSelectServicoCadastrarAgendamento);
        loadTableAnimal(tableSelectAnimalCadastrarAgendamento, textPesquisaCpfCadastrarAgendamento.getText());
        layout.show(panelContent, "cadastrarAgendamento");
        
    }//GEN-LAST:event_buttonCadastrarAgendamentoActionPerformed

    private void textPesquisaCpfCadastrarAgendamentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textPesquisaCpfCadastrarAgendamentoKeyTyped
        loadTableAnimal(tableSelectAnimalCadastrarAgendamento ,textPesquisaCpfCadastrarAgendamento.getText());
        
    }//GEN-LAST:event_textPesquisaCpfCadastrarAgendamentoKeyTyped

    private void buttonEfetuarCadastroAgendamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEfetuarCadastroAgendamentoActionPerformed
        
        Timestamp data_hora = new Timestamp((Integer) spinnerAnoCadastrarAgendamento.getValue(), (Integer) spinnerMesCadastrarAgendamento.getValue(), (Integer) spinnerDiaCadastrarAgendamento.getValue(), (Integer) spinnerHoraCadastrarAgendamento.getValue(), (Integer) spinnerMinutoCadastrarAgendamento.getValue(), 0, 0);

        int animal = 0, servico = 0;
        
        
        int linhaSelecionadaAnimal = tableSelectAnimalCadastrarAgendamento.getSelectedRow();
        if (linhaSelecionadaAnimal != -1) {
            DefaultTableModel model = (DefaultTableModel) tableSelectAnimalCadastrarAgendamento.getModel();
            animal = (Integer) model.getValueAt(linhaSelecionadaAnimal, 0);
        }
        
        int linhaSelecionadaServico = tableSelectServicoCadastrarAgendamento.getSelectedRow();
        if (linhaSelecionadaServico != -1) {
            DefaultTableModel model = (DefaultTableModel) tableSelectServicoCadastrarAgendamento.getModel();
            
            servico = (Integer) model.getValueAt(linhaSelecionadaServico, 0);
            System.out.println(servico);
        }
        
        if(animal != 0 && servico != 0){
            AgendamentoCtrl ac = new AgendamentoCtrl();
            ac.cadastrarAgendamento(0, data_hora, new Animal(animal), new Servico(servico));
        }else{
            JOptionPane.showMessageDialog(null, "Algo não estava correto, tente novamente.");
        }
        
        
        loadTableAgendamento(caseListAgendamento);
        layout.show(panelContent, "inicio");
    }//GEN-LAST:event_buttonEfetuarCadastroAgendamentoActionPerformed

    private void buttonCancelarCadastroAgendamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarCadastroAgendamentoActionPerformed
        layout.show(panelContent, "inicio");
    }//GEN-LAST:event_buttonCancelarCadastroAgendamentoActionPerformed

    private void textPesquisaCpfEditarAgendamentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textPesquisaCpfEditarAgendamentoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_textPesquisaCpfEditarAgendamentoKeyTyped

    private void buttonEfetuarEditarAgendamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEfetuarEditarAgendamentoActionPerformed
        Timestamp data_hora = new Timestamp((Integer) spinnerAnoEditarAgendamento.getValue(), (Integer) spinnerMesEditarAgendamento.getValue(), (Integer) spinnerDiaEditarAgendamento.getValue(), (Integer) spinnerHoraEditarAgendamento.getValue(), (Integer) spinnerMinutoEditarAgendamento.getValue(), 0, 0);
        
//        String s = "";
//        s = (String.format("%02d", data_hora.getDate()) + "/" + String.format("%02d", data_hora.getMonth())+ "/" + data_hora.getYear() + " " + data_hora.getHours()+ ":"+String.format("%02d", data_hora.getMinutes()));
//        System.out.println(s);
        
        int animal = 0, servico = 0;
        
        
        
        int linhaSelecionadaAnimal = tableSelectAnimalCadastrarAgendamento.getSelectedRow();
        if (linhaSelecionadaAnimal != -1) {
            DefaultTableModel model = (DefaultTableModel) tableSelectAnimalCadastrarAgendamento.getModel();
            animal = (Integer) model.getValueAt(linhaSelecionadaAnimal, 0);
        }else{
            animal = this.anterior.getAnimal().getId();
        }
        
        int linhaSelecionadaServico = tableSelectServicoCadastrarAgendamento.getSelectedRow();
        if (linhaSelecionadaServico != -1) {
            DefaultTableModel model = (DefaultTableModel) tableSelectServicoCadastrarAgendamento.getModel();
            
            servico = (Integer) model.getValueAt(linhaSelecionadaServico, 0);
            System.out.println(servico);
        }else{
            servico = this.anterior.getServico().getId();
        }
        
        System.out.println(this.anterior);
        System.out.println("Animal: " + animal);
        System.out.println("Servico: " + servico);
        
        if(animal != 0 && servico != 0){
            AgendamentoCtrl ac = new AgendamentoCtrl();
            ac.atualizarAgendamento(this.anterior.getId(), data_hora, new Animal(animal), new Servico(servico));
        }else{
            JOptionPane.showMessageDialog(null, "Algo não estava correto, tente novamente.");
        }
        
        
        loadTableAgendamento(caseListAgendamento);
        layout.show(panelContent, "inicio");
    }//GEN-LAST:event_buttonEfetuarEditarAgendamentoActionPerformed

    private void buttonCancelarEditarAgendamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarEditarAgendamentoActionPerformed
        layout.show(panelContent, "inicio");
    }//GEN-LAST:event_buttonCancelarEditarAgendamentoActionPerformed

    private void buttonCadastrarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCadastrarFuncionarioActionPerformed
        // TODO add your handling code here:
        
        comboCargoCadastrarFuncionario.setModel(new DefaultComboBoxModel(new String[]{"funcionario", "gerente"}));
        if(this.logado.getCargo().equalsIgnoreCase("funcionario")){
            comboCargoCadastrarFuncionario.setSelectedIndex(0);
            comboCargoCadastrarFuncionario.setEnabled(false);
        }
        layout.show(panelContent, "cadastrarFuncionario");
    }//GEN-LAST:event_buttonCadastrarFuncionarioActionPerformed

    private void buttonEditarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditarFuncionarioActionPerformed
        int linhaSelecionada = tableFuncionarios.getSelectedRow();
       
        comboCargoEditarFuncionario.setModel(new DefaultComboBoxModel(new String[]{"funcionario", "gerente"}));
        
        
        int id = 0;
        if (linhaSelecionada != -1) {
            DefaultTableModel model = (DefaultTableModel) tableFuncionarios.getModel();
            id = (Integer) model.getValueAt(linhaSelecionada, 0);
            
            FuncionarioCtrl fc = new FuncionarioCtrl(logado);
            
            Funcionario anterior = fc.exibirPorId(id);
            
            System.out.println(anterior);
            
            textNomeEditarFuncionario.setText(anterior.getNome());
            textUsuarioEditarFuncionario.setText(anterior.getUsername());
            textSenhaEditarFuncionario.setText("");
            
            int cargo = 0;
            if(anterior.getCargo().equalsIgnoreCase("gerente")) cargo = 1;
            comboCargoEditarFuncionario.setSelectedIndex(cargo);
            
            int horaInicio = anterior.getStartTime().getHours();
            int minutoInicio = anterior.getStartTime().getMinutes();
            int horaFim = anterior.getEndTime().getHours();
            int minutoFim = anterior.getEndTime().getMinutes();
            
            spinnerHoraInicioEditarFuncionario.setValue(horaInicio);
            spinnerHoraFimEditarFuncionario.setValue(horaFim);
            spinnerMinutoInicioEditarFuncionario.setValue(minutoInicio);
            spinnerMinutoInicioEditarFuncionario.setValue(minutoFim);
            
            layout.show(panelContent, "editarFuncionario");

        }
    }//GEN-LAST:event_buttonEditarFuncionarioActionPerformed

    private void buttonDeletarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeletarFuncionarioActionPerformed
        FuncionarioCtrl fc = new FuncionarioCtrl(logado);

        int linhaSelecionada = tableFuncionarios.getSelectedRow();
        if (linhaSelecionada != -1) {
            DefaultTableModel model = (DefaultTableModel) tableFuncionarios.getModel();
            int id = (Integer) model.getValueAt(linhaSelecionada, 0); 
            fc.excluir(id);
            loadTableFuncionario();
        }
        
        
    }//GEN-LAST:event_buttonDeletarFuncionarioActionPerformed

    private void buttonEfetuarCadastroFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEfetuarCadastroFuncionarioActionPerformed
        // TODO add your handling code here:
        
        
        FuncionarioCtrl fc = new FuncionarioCtrl(this.logado);
        
        String inicio = "" + String.format("%02d", spinnerHoraInicioCadastrarFuncionario.getValue()) + ":"+String.format("%02d", spinnerMinutoInicioCadastrarFuncionario.getValue())+":00";
        String fim = "" + String.format("%02d", spinnerHoraFimCadastrarFuncionario.getValue()) + ":"+String.format("%02d", spinnerMinutoFimCadastrarFuncionario.getValue())+":00";
        
        fc.cadastrar(0, textNomeCadastrarFuncionario.getText(), inicio, fim, (String) comboCargoCadastrarFuncionario.getSelectedItem(), textUsuarioCadastrarFuncionario.getText(), textSenhaCadastrarFuncionario.getText());
        loadTableFuncionario();
        layout.show(panelContent, "funcionarios");
    }//GEN-LAST:event_buttonEfetuarCadastroFuncionarioActionPerformed

    private void buttonCancelarCadastroFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarCadastroFuncionarioActionPerformed
        layout.show(panelContent, "funcionarios");
    }//GEN-LAST:event_buttonCancelarCadastroFuncionarioActionPerformed

    private void textNomeCadastrarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNomeCadastrarFuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNomeCadastrarFuncionarioActionPerformed

    private void textUsuarioCadastrarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textUsuarioCadastrarFuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textUsuarioCadastrarFuncionarioActionPerformed

    private void buttonEfetuarEditarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEfetuarEditarFuncionarioActionPerformed
        FuncionarioCtrl fc = new FuncionarioCtrl(this.logado);
        
        String inicio = "" + String.format("%02d", spinnerHoraInicioEditarFuncionario.getValue()) + ":"+String.format("%02d", spinnerMinutoInicioEditarFuncionario.getValue())+":00";
        String fim = "" + String.format("%02d", spinnerHoraFimEditarFuncionario.getValue()) + ":"+String.format("%02d", spinnerMinutoFimEditarFuncionario.getValue())+":00";
        
        
        int linhaSelecionada = tableFuncionarios.getSelectedRow(), id = 0;
        System.out.println(linhaSelecionada);
        if (linhaSelecionada != -1) {
            DefaultTableModel model = (DefaultTableModel) tableFuncionarios.getModel();
            id = (Integer) model.getValueAt(linhaSelecionada, 0);
            fc.atualizar(id, textNomeEditarFuncionario.getText(), inicio, fim, (String) comboCargoEditarFuncionario.getSelectedItem(), textUsuarioEditarFuncionario.getText(), textSenhaEditarFuncionario.getText());
        }
        
        
        loadTableFuncionario();
        layout.show(panelContent, "funcionarios");
    }//GEN-LAST:event_buttonEfetuarEditarFuncionarioActionPerformed

    private void buttonCancelarEditarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarEditarFuncionarioActionPerformed
        layout.show(panelContent, "funcionarios");
    }//GEN-LAST:event_buttonCancelarEditarFuncionarioActionPerformed

    private void textNomeEditarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNomeEditarFuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNomeEditarFuncionarioActionPerformed

    private void textUsuarioEditarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textUsuarioEditarFuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textUsuarioEditarFuncionarioActionPerformed

    private void buttonCadastrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCadastrarClienteActionPerformed
        // TODO add your handling code here:
        
        
        layout.show(panelContent, "cadastrarCliente");
        
        
    }//GEN-LAST:event_buttonCadastrarClienteActionPerformed

    private void buttonEditarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditarClienteActionPerformed
        // TODO add your handling code here:
        
        int linhaSelecionada = tableClientesPessoas.getSelectedRow();

        int id = 0;
        if (linhaSelecionada != -1) {
            DefaultTableModel model = (DefaultTableModel) tableClientesPessoas.getModel();
            id = (Integer) model.getValueAt(linhaSelecionada, 0);
            
            ClienteCtrl fc = new ClienteCtrl();
            
            Pessoa anterior = (Pessoa) fc.exibirCliente(id);
            
            System.out.println(anterior);
            
            nomeEditarCliente.setText(anterior.getNome());
            emailEditarCliente.setText(anterior.getEmail());
            cpfEditarCliente.setText(anterior.getCpf());
            telefoneEditarCliente.setText(anterior.getTelefone());
            
            idEditandoCliente = anterior.getId();
            
            layout.show(panelContent, "editarCliente");
        }
        
        
        
        
        
    }//GEN-LAST:event_buttonEditarClienteActionPerformed

    private void buttonDeletarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeletarClienteActionPerformed
        // TODO add your handling code here:
        ClienteCtrl fc = new ClienteCtrl();

        int linhaSelecionada = tableClientesPessoas.getSelectedRow();
        if (linhaSelecionada != -1) {
            DefaultTableModel model = (DefaultTableModel) tableClientesPessoas.getModel();
            int id = (Integer) model.getValueAt(linhaSelecionada, 0); 
            fc.excluirCliente(id);
            loadTableClientesPessoa();
        }
    }//GEN-LAST:event_buttonDeletarClienteActionPerformed

    private void buttonEfetuarCadastroFuncionario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEfetuarCadastroFuncionario1ActionPerformed
        // TODO add your handling code here:
        
        ClienteCtrl cc = new ClienteCtrl();
        
        String cpf = cpfCadastrarCliente.getText();
        String email = emailCadastrarCliente.getText();
        String telefone = telefoneCadastrarCliente.getText();
       
        boolean cpfValido = validarCpf(cpf);
        boolean emailValido = validarEmail(email);
        boolean telefoneValido = validarTelefone(telefone);
        
        if(!cpfValido){
            JOptionPane.showMessageDialog(null, "CPF Inválido!");
        }else if(!emailValido){
            JOptionPane.showMessageDialog(null, "Email Inválido!");
        }else if(!telefoneValido){
            JOptionPane.showMessageDialog(null, "Telefone Inválido!");
        }else{
            cc.cadastrarCliente(0, nomeCadastrarCliente.getText(), cpf, "pessoa", telefone, email, null);
            loadTableClientesPessoa();
            layout.show(panelContent, "clientes");
        }
    }//GEN-LAST:event_buttonEfetuarCadastroFuncionario1ActionPerformed

    private void buttonCancelarCadastroFuncionario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarCadastroFuncionario1ActionPerformed
        // TODO add your handling code here:
        layout.show(panelContent, "clientes");
    }//GEN-LAST:event_buttonCancelarCadastroFuncionario1ActionPerformed

    private void nomeCadastrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeCadastrarClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeCadastrarClienteActionPerformed

    private void cpfCadastrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpfCadastrarClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpfCadastrarClienteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int linhaSelecionada = tableClientesPessoas.getSelectedRow();
        if (linhaSelecionada != -1) {
            DefaultTableModel model = (DefaultTableModel) tableClientesPessoas.getModel();
            int id = (Integer) model.getValueAt(linhaSelecionada, 0); 
            
            ClienteCtrl cc = new ClienteCtrl();
            Cliente listar = cc.exibirCliente(id);
            
            cpfCliente = listar.getCpf();
            loadTableClienteAnimal(listar.getCpf());
            
            layout.show(panelContent, "animais");
            
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um cliente para listar seus animais!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void buttonCadastrarClienteAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCadastrarClienteAnimalActionPerformed
        // TODO add your handling code here:
        
        layout.show(panelContent, "cadastrarAnimal");
    }//GEN-LAST:event_buttonCadastrarClienteAnimalActionPerformed

    private void buttonEditarClienteAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditarClienteAnimalActionPerformed
        // TODO add your handling code here:
        
        int linhaSelecionada = tableClientesAnimais.getSelectedRow();

        int id = 0;
        if (linhaSelecionada != -1) {
            DefaultTableModel model = (DefaultTableModel) tableClientesAnimais.getModel();
            id = (Integer) model.getValueAt(linhaSelecionada, 0);
            
            ClienteCtrl fc = new ClienteCtrl();
            
            Animal anterior = (Animal) fc.exibirCliente(id);
            
            
            nomeEditarAnimal.setText(anterior.getNome());
            especieEditarAnimal.setText(anterior.getEspecie());
            
            idEditandoAnimal = anterior.getId();
            cpfCliente = anterior.getCpf();
            
            layout.show(panelContent, "editarAnimal");
        }
        
    }//GEN-LAST:event_buttonEditarClienteAnimalActionPerformed

    private void buttonDeletarClienteAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeletarClienteAnimalActionPerformed
        ClienteCtrl fc = new ClienteCtrl();

        int linhaSelecionada = tableClientesAnimais.getSelectedRow();
        if (linhaSelecionada != -1) {
            DefaultTableModel model = (DefaultTableModel) tableClientesAnimais.getModel();
            int id = (Integer) model.getValueAt(linhaSelecionada, 0); 
            fc.excluirCliente(id);
            loadTableClienteAnimal(cpfCliente);
        }
    }//GEN-LAST:event_buttonDeletarClienteAnimalActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        layout.show(panelContent, "clientes");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void buttonEfetuarCadastroFuncionario2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEfetuarCadastroFuncionario2ActionPerformed
        // TODO add your handling code here:
        String nome = nomeEditarCliente.getText();
        String email = emailEditarCliente.getText();
        String cpf = cpfEditarCliente.getText();
        String telefone = telefoneEditarCliente.getText();
        
        boolean cpfValido = validarCpf(cpf);
        boolean emailValido = validarEmail(email);
        boolean telefoneValido = validarTelefone(telefone);
        
        System.out.println(cpf + " - " + email + " - " + telefone);
        
        if(!cpfValido){
            JOptionPane.showMessageDialog(null, "CPF Inválido!");
        }else if(!emailValido){
            JOptionPane.showMessageDialog(null, "Email Inválido!");
        }else if(!telefoneValido){
            JOptionPane.showMessageDialog(null, "Telefone Inválido!");
        }else{
            ClienteCtrl cc = new ClienteCtrl();
            cc.atualizarPessoa(idEditandoCliente, nome, cpf, telefone, email);
            loadTableClientesPessoa();
            layout.show(panelContent, "clientes");
        }
        
        
    }//GEN-LAST:event_buttonEfetuarCadastroFuncionario2ActionPerformed

    private void buttonCancelarCadastroFuncionario2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarCadastroFuncionario2ActionPerformed
        // TODO add your handling code here:
        
        layout.show(panelContent, "clientes");
    }//GEN-LAST:event_buttonCancelarCadastroFuncionario2ActionPerformed

    private void nomeEditarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeEditarClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeEditarClienteActionPerformed

    private void cpfEditarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpfEditarClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpfEditarClienteActionPerformed

    private void buttonCancelarCadastroAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarCadastroAnimalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonCancelarCadastroAnimalActionPerformed

    private void buttonEfetuarCadastroAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEfetuarCadastroAnimalActionPerformed
        // TODO add your handling code here:
        ClienteCtrl cc = new ClienteCtrl();
        
        String nome = nomeCadastrarAnimal.getText();
        String especie = especieCadastrarAnimal.getText();
       
        
        cc.cadastrarCliente(0, nome, cpfCliente, "animal", null, null, especie);
        loadTableClienteAnimal(cpfCliente);
        layout.show(panelContent, "animais");
        
    }//GEN-LAST:event_buttonEfetuarCadastroAnimalActionPerformed

    private void buttonCancelarCadastroAnimal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarCadastroAnimal1ActionPerformed
        // TODO add your handling code here:
        layout.show(panelContent, "animais");
    }//GEN-LAST:event_buttonCancelarCadastroAnimal1ActionPerformed

    private void buttonEfetuarEditarAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEfetuarEditarAnimalActionPerformed
        // TODO add your handling code here:
        ClienteCtrl cc = new ClienteCtrl();
        
        String nome = nomeEditarAnimal.getText();
        String especie = especieEditarAnimal.getText();
       
        
        cc.atualizarAnimal(idEditandoAnimal, nome, cpfCliente, especie);
        loadTableClienteAnimal(cpfCliente);
        layout.show(panelContent, "animais");
        
        
        
        
    }//GEN-LAST:event_buttonEfetuarEditarAnimalActionPerformed

    private void buttonCadastrarServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCadastrarServicoActionPerformed
        // TODO add your handling code here:
        loadTableResponsavel(tableResponsavelCadastrar);
        layout.show(panelContent, "cadastrarServico");
    }//GEN-LAST:event_buttonCadastrarServicoActionPerformed

    private void buttonEditarServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditarServicoActionPerformed
        int linhaSelecionada = tableServicos.getSelectedRow();

        int id = 0;
        if (linhaSelecionada != -1) {
            DefaultTableModel model = (DefaultTableModel) tableServicos.getModel();
            id = (Integer) model.getValueAt(linhaSelecionada, 0);
            
            ItemCtrl fc = new ItemCtrl();
            
            this.sAnterior = (Servico) fc.exibirProdutos(id);
            
            nomeEditarServico.setText(sAnterior.getNome());
            precoEditarServico.setText(sAnterior.getPreco()+"");
            duracaoEditarServico.setText(sAnterior.getDuracao()+"");
            
            FuncionarioCtrl fun = new FuncionarioCtrl(logado);
            this.responsavel = fun.exibirPorId(sAnterior.getIdResponsavel());
            
            loadTableResponsavel(tableResponsavel);
            
            
            TableModel r = tableResponsavel.getModel();
            int idLinhaSelecionada = 0, nLinhaSelecionada = 0;
            for(int i = 0; i < r.getColumnCount(); i++){
                idLinhaSelecionada = (Integer) r.getValueAt(i, 0);
                nLinhaSelecionada = i;
                if(this.responsavel.getId() == idLinhaSelecionada) break; 
            }
            tableResponsavel.getSelectionModel().setSelectionInterval(nLinhaSelecionada, nLinhaSelecionada);
            
            
            
            layout.show(panelContent, "editarServico");
        }
    }//GEN-LAST:event_buttonEditarServicoActionPerformed

    private void buttonDeletarServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeletarServicoActionPerformed
        // TODO add your handling code here:
        
        ItemCtrl fc = new ItemCtrl();

        int linhaSelecionada = tableServicos.getSelectedRow();
        if (linhaSelecionada != -1) {
            DefaultTableModel model = (DefaultTableModel) tableServicos.getModel();
            int id = (Integer) model.getValueAt(linhaSelecionada, 0); 
            fc.excluirItem(id);
            loadTableServicos();
        }
        
        
        
        
    }//GEN-LAST:event_buttonDeletarServicoActionPerformed

    private void buttonCancelarCadastroAnimal2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarCadastroAnimal2ActionPerformed
        // TODO add your handling code here:
            layout.show(panelContent, "servicos");
    }//GEN-LAST:event_buttonCancelarCadastroAnimal2ActionPerformed

    private void buttonEfetuarEdicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEfetuarEdicaoActionPerformed
        // TODO add your handling code here:
        String nome = nomeEditarServico.getText();
        String preco = precoEditarServico.getText();
        String duracao = duracaoEditarServico.getText();
        
        int id = responsavel.getId();
        
        int selectedRow = tableResponsavel.getSelectedRow();
        if (selectedRow != -1) { // verifica se há uma linha selecionada
            id = (int) tableResponsavel.getModel().getValueAt(selectedRow, 0);
            
        }
        
        
        ItemCtrl ic = new ItemCtrl();
        ic.atualizarServico(this.sAnterior.getId(), nome, Float.parseFloat(preco), "servico", true, Integer.parseInt(duracao), id);
        
        loadTableServicos();
        layout.show(panelContent, "servicos");
        
    }//GEN-LAST:event_buttonEfetuarEdicaoActionPerformed

    private void buttonCancelarCadastroAnimal4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarCadastroAnimal4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonCancelarCadastroAnimal4ActionPerformed

    private void buttonEfetuarEdicao1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEfetuarEdicao1ActionPerformed
        ItemCtrl ic = new ItemCtrl();
        
        String nome = nomeCadastrarServico.getText();
        float preco = Float.parseFloat(precoCadastrarServico.getText());
        int duracao = Integer.parseInt(duracaoCadastrarServico.getText());
        
        int linhaSelecionada = tableResponsavelCadastrar.getSelectedRow();

        int id = 0;
        if (linhaSelecionada != -1) {
            DefaultTableModel model = (DefaultTableModel) tableResponsavelCadastrar.getModel();
            id = (Integer) model.getValueAt(linhaSelecionada, 0);
            
            FuncionarioCtrl fc = new FuncionarioCtrl(logado);
            
            Funcionario responsavel = fc.exibirPorId(id);
            
            int idResponsavel = responsavel.getId();
            
            ic.cadastraServico(0, nome, preco, "servico", true, duracao, idResponsavel);
            
            loadTableServicos();
            
            layout.show(panelContent, "servicos");
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um responsável");
        }
        
    }//GEN-LAST:event_buttonEfetuarEdicao1ActionPerformed

    private void agendamentosExibirHoje1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agendamentosExibirHoje1ActionPerformed
        // TODO add your handling code here:
        loadTableRoupas();
        layout.show(panelContent, "roupas");
    }//GEN-LAST:event_agendamentosExibirHoje1ActionPerformed

    private void agendamentosExibirAmanha1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agendamentosExibirAmanha1ActionPerformed
        // TODO add your handling code here:
        loadTableRacoes();
        layout.show(panelContent, "racoes");
    }//GEN-LAST:event_agendamentosExibirAmanha1ActionPerformed

    private void agendamentosExibirTodos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agendamentosExibirTodos1ActionPerformed
        // TODO add your handling code here:
        loadTableRemedios();
        layout.show(panelContent, "remedios");
    }//GEN-LAST:event_agendamentosExibirTodos1ActionPerformed

    private void buttonDeletarAgendamento1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeletarAgendamento1ActionPerformed
        // TODO add your handling code here:
        ItemCtrl fc = new ItemCtrl();

        int linhaSelecionada = tableMercadorias.getSelectedRow();
        if (linhaSelecionada != -1) {
            DefaultTableModel model = (DefaultTableModel) tableMercadorias.getModel();
            int id = (Integer) model.getValueAt(linhaSelecionada, 0); 
            fc.excluirItem(id);
            loadTableMercadorias();
        }
    }//GEN-LAST:event_buttonDeletarAgendamento1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        loadTableBrinquedos();
        layout.show(panelContent, "brinquedos");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void agendamentosExibirHoje2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agendamentosExibirHoje2ActionPerformed
        // TODO add your handling code here:
        loadTableRoupas();
        layout.show(panelContent, "roupas");
        
    }//GEN-LAST:event_agendamentosExibirHoje2ActionPerformed

    private void agendamentosExibirAmanha2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agendamentosExibirAmanha2ActionPerformed
        // TODO add your handling code here:
        loadTableRacoes();
        layout.show(panelContent, "racoes");
    }//GEN-LAST:event_agendamentosExibirAmanha2ActionPerformed

    private void agendamentosExibirTodos2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agendamentosExibirTodos2ActionPerformed
        // TODO add your handling code here:
        loadTableRemedios();
        layout.show(panelContent, "remedios");
    }//GEN-LAST:event_agendamentosExibirTodos2ActionPerformed

    private void buttonCadastrarAgendamento2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCadastrarAgendamento2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonCadastrarAgendamento2ActionPerformed

    private void buttonDeletarAgendamento2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeletarAgendamento2ActionPerformed
        // TODO add your handling code here:
        ItemCtrl fc = new ItemCtrl();

        int linhaSelecionada = tableRoupas.getSelectedRow();
        if (linhaSelecionada != -1) {
            DefaultTableModel model = (DefaultTableModel) tableRoupas.getModel();
            int id = (Integer) model.getValueAt(linhaSelecionada, 0); 
            fc.excluirItem(id);
            loadTableRoupas();
        }
    }//GEN-LAST:event_buttonDeletarAgendamento2ActionPerformed

    private void buttonEditarAgendamento2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditarAgendamento2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonEditarAgendamento2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        loadTableBrinquedos();
        layout.show(panelContent, "brinquedos");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void agendamentosExibirHoje3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agendamentosExibirHoje3ActionPerformed
        // TODO add your handling code here:
        loadTableRoupas();
        layout.show(panelContent, "roupas");
    }//GEN-LAST:event_agendamentosExibirHoje3ActionPerformed

    private void agendamentosExibirAmanha3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agendamentosExibirAmanha3ActionPerformed
        // TODO add your handling code here:
        loadTableRacoes();
        layout.show(panelContent, "racoes");
    }//GEN-LAST:event_agendamentosExibirAmanha3ActionPerformed

    private void agendamentosExibirTodos3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agendamentosExibirTodos3ActionPerformed
        // TODO add your handling code here:
        loadTableRemedios();
        layout.show(panelContent, "remedios");
    }//GEN-LAST:event_agendamentosExibirTodos3ActionPerformed

    private void buttonCadastrarAgendamento3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCadastrarAgendamento3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonCadastrarAgendamento3ActionPerformed

    private void buttonDeletarAgendamento3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeletarAgendamento3ActionPerformed
        // TODO add your handling code here:
        ItemCtrl fc = new ItemCtrl();

        int linhaSelecionada = tableRemedios.getSelectedRow();
        if (linhaSelecionada != -1) {
            DefaultTableModel model = (DefaultTableModel) tableRemedios.getModel();
            int id = (Integer) model.getValueAt(linhaSelecionada, 0); 
            fc.excluirItem(id);
            loadTableRemedios();
        }
    }//GEN-LAST:event_buttonDeletarAgendamento3ActionPerformed

    private void buttonEditarAgendamento3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditarAgendamento3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonEditarAgendamento3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        loadTableBrinquedos();
        layout.show(panelContent, "brinquedos");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void agendamentosExibirHoje4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agendamentosExibirHoje4ActionPerformed
        // TODO add your handling code here:
        loadTableRoupas();
        layout.show(panelContent, "roupas");
    }//GEN-LAST:event_agendamentosExibirHoje4ActionPerformed

    private void agendamentosExibirAmanha4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agendamentosExibirAmanha4ActionPerformed
        // TODO add your handling code here:
        loadTableRacoes();
        layout.show(panelContent, "racoes");
    }//GEN-LAST:event_agendamentosExibirAmanha4ActionPerformed

    private void agendamentosExibirTodos4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agendamentosExibirTodos4ActionPerformed
        // TODO add your handling code here:
        loadTableRemedios();
        layout.show(panelContent, "remedios");
    }//GEN-LAST:event_agendamentosExibirTodos4ActionPerformed

    private void buttonCadastrarAgendamento4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCadastrarAgendamento4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonCadastrarAgendamento4ActionPerformed

    private void buttonDeletarAgendamento4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeletarAgendamento4ActionPerformed
        // TODO add your handling code here:
        ItemCtrl fc = new ItemCtrl();

        int linhaSelecionada = tableBrinquedos.getSelectedRow();
        if (linhaSelecionada != -1) {
            DefaultTableModel model = (DefaultTableModel) tableBrinquedos.getModel();
            int id = (Integer) model.getValueAt(linhaSelecionada, 0); 
            fc.excluirItem(id);
            loadTableBrinquedos();
        }
    }//GEN-LAST:event_buttonDeletarAgendamento4ActionPerformed

    private void buttonEditarAgendamento4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditarAgendamento4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonEditarAgendamento4ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        loadTableBrinquedos();
        layout.show(panelContent, "brinquedos");
    }//GEN-LAST:event_jButton9ActionPerformed

    private void agendamentosExibirHoje5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agendamentosExibirHoje5ActionPerformed
        // TODO add your handling code here:
        loadTableRoupas();
        layout.show(panelContent, "roupas");
    }//GEN-LAST:event_agendamentosExibirHoje5ActionPerformed

    private void agendamentosExibirAmanha5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agendamentosExibirAmanha5ActionPerformed
        // TODO add your handling code here:
        loadTableRacoes();
        layout.show(panelContent, "racoes");
    }//GEN-LAST:event_agendamentosExibirAmanha5ActionPerformed

    private void agendamentosExibirTodos5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agendamentosExibirTodos5ActionPerformed
        // TODO add your handling code here:
        loadTableRemedios();
        layout.show(panelContent, "remedios");
    }//GEN-LAST:event_agendamentosExibirTodos5ActionPerformed

    private void buttonCadastrarAgendamento5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCadastrarAgendamento5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonCadastrarAgendamento5ActionPerformed

    private void buttonDeletarAgendamento5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeletarAgendamento5ActionPerformed
        // TODO add your handling code here:
        ItemCtrl fc = new ItemCtrl();

        int linhaSelecionada = tableRacoes.getSelectedRow();
        if (linhaSelecionada != -1) {
            DefaultTableModel model = (DefaultTableModel) tableRacoes.getModel();
            int id = (Integer) model.getValueAt(linhaSelecionada, 0); 
            fc.excluirItem(id);
            loadTableRacoes();
        }
    }//GEN-LAST:event_buttonDeletarAgendamento5ActionPerformed

    private void buttonEditarAgendamento5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditarAgendamento5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonEditarAgendamento5ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        loadTableBrinquedos();
        layout.show(panelContent, "brinquedos");
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        loadTableMercadorias();
        layout.show(panelContent, "mercadorias");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        loadTableMercadorias();
        layout.show(panelContent, "mercadorias");
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        loadTableMercadorias();
        layout.show(panelContent, "mercadorias");
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        loadTableMercadorias();
        layout.show(panelContent, "mercadorias");
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        loadTableMercadorias();
        layout.show(panelContent, "mercadorias");
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        Funcionario l = new Funcionario(1, "caio", Time.valueOf("08:00:00"), Time.valueOf("16:00:00"), "gerente", "abc", "123");
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal(l).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agendamentosExibirAmanha;
    private javax.swing.JButton agendamentosExibirAmanha1;
    private javax.swing.JButton agendamentosExibirAmanha2;
    private javax.swing.JButton agendamentosExibirAmanha3;
    private javax.swing.JButton agendamentosExibirAmanha4;
    private javax.swing.JButton agendamentosExibirAmanha5;
    private javax.swing.JButton agendamentosExibirHoje;
    private javax.swing.JButton agendamentosExibirHoje1;
    private javax.swing.JButton agendamentosExibirHoje2;
    private javax.swing.JButton agendamentosExibirHoje3;
    private javax.swing.JButton agendamentosExibirHoje4;
    private javax.swing.JButton agendamentosExibirHoje5;
    private javax.swing.JButton agendamentosExibirTodos;
    private javax.swing.JButton agendamentosExibirTodos1;
    private javax.swing.JButton agendamentosExibirTodos2;
    private javax.swing.JButton agendamentosExibirTodos3;
    private javax.swing.JButton agendamentosExibirTodos4;
    private javax.swing.JButton agendamentosExibirTodos5;
    private javax.swing.JButton buttonCadastrarAgendamento;
    private javax.swing.JButton buttonCadastrarAgendamento2;
    private javax.swing.JButton buttonCadastrarAgendamento3;
    private javax.swing.JButton buttonCadastrarAgendamento4;
    private javax.swing.JButton buttonCadastrarAgendamento5;
    private javax.swing.JButton buttonCadastrarCliente;
    private javax.swing.JButton buttonCadastrarClienteAnimal;
    private javax.swing.JButton buttonCadastrarFuncionario;
    private javax.swing.JButton buttonCadastrarServico;
    private javax.swing.JButton buttonCancelarCadastroAgendamento;
    private javax.swing.JButton buttonCancelarCadastroAnimal;
    private javax.swing.JButton buttonCancelarCadastroAnimal1;
    private javax.swing.JButton buttonCancelarCadastroAnimal2;
    private javax.swing.JButton buttonCancelarCadastroAnimal4;
    private javax.swing.JButton buttonCancelarCadastroFuncionario;
    private javax.swing.JButton buttonCancelarCadastroFuncionario1;
    private javax.swing.JButton buttonCancelarCadastroFuncionario2;
    private javax.swing.JButton buttonCancelarEditarAgendamento;
    private javax.swing.JButton buttonCancelarEditarFuncionario;
    private javax.swing.JButton buttonClientes;
    private javax.swing.JButton buttonDeletarAgendamento;
    private javax.swing.JButton buttonDeletarAgendamento1;
    private javax.swing.JButton buttonDeletarAgendamento2;
    private javax.swing.JButton buttonDeletarAgendamento3;
    private javax.swing.JButton buttonDeletarAgendamento4;
    private javax.swing.JButton buttonDeletarAgendamento5;
    private javax.swing.JButton buttonDeletarCliente;
    private javax.swing.JButton buttonDeletarClienteAnimal;
    private javax.swing.JButton buttonDeletarFuncionario;
    private javax.swing.JButton buttonDeletarServico;
    private javax.swing.JButton buttonEditarAgendamento;
    private javax.swing.JButton buttonEditarAgendamento2;
    private javax.swing.JButton buttonEditarAgendamento3;
    private javax.swing.JButton buttonEditarAgendamento4;
    private javax.swing.JButton buttonEditarAgendamento5;
    private javax.swing.JButton buttonEditarCliente;
    private javax.swing.JButton buttonEditarClienteAnimal;
    private javax.swing.JButton buttonEditarFuncionario;
    private javax.swing.JButton buttonEditarServico;
    private javax.swing.JButton buttonEfetuarCadastroAgendamento;
    private javax.swing.JButton buttonEfetuarCadastroAnimal;
    private javax.swing.JButton buttonEfetuarCadastroFuncionario;
    private javax.swing.JButton buttonEfetuarCadastroFuncionario1;
    private javax.swing.JButton buttonEfetuarCadastroFuncionario2;
    private javax.swing.JButton buttonEfetuarEdicao;
    private javax.swing.JButton buttonEfetuarEdicao1;
    private javax.swing.JButton buttonEfetuarEditarAgendamento;
    private javax.swing.JButton buttonEfetuarEditarAnimal;
    private javax.swing.JButton buttonEfetuarEditarFuncionario;
    private javax.swing.JButton buttonFuncionarios;
    private javax.swing.JButton buttonInicio;
    private javax.swing.JButton buttonMercadorias;
    private javax.swing.JButton buttonServicos;
    private javax.swing.JComboBox<String> comboCargoCadastrarFuncionario;
    private javax.swing.JComboBox<String> comboCargoEditarFuncionario;
    private javax.swing.JTextField cpfCadastrarCliente;
    private javax.swing.JTextField cpfEditarCliente;
    private javax.swing.JTextField duracaoCadastrarServico;
    private javax.swing.JTextField duracaoEditarServico;
    private javax.swing.JTextField emailCadastrarCliente;
    private javax.swing.JTextField emailEditarCliente;
    private javax.swing.JTextField especieCadastrarAnimal;
    private javax.swing.JTextField especieEditarAnimal;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextField nomeCadastrarAnimal;
    private javax.swing.JTextField nomeCadastrarCliente;
    private javax.swing.JTextField nomeCadastrarServico;
    private javax.swing.JTextField nomeEditarAnimal;
    private javax.swing.JTextField nomeEditarCliente;
    private javax.swing.JTextField nomeEditarServico;
    private javax.swing.JPanel painelMercadorias;
    private javax.swing.JPanel panelAnimal;
    private javax.swing.JPanel panelBrinquedo;
    private javax.swing.JPanel panelCadastrarAgendamento;
    private javax.swing.JPanel panelCadastrarAnimal;
    private javax.swing.JPanel panelCadastrarCliente;
    private javax.swing.JPanel panelCadastrarFuncionario;
    private javax.swing.JPanel panelCadastrarServico;
    private javax.swing.JPanel panelClientes;
    private javax.swing.JPanel panelContent;
    private javax.swing.JPanel panelEditarAgendamento;
    private javax.swing.JPanel panelEditarAnimal;
    private javax.swing.JPanel panelEditarCliente;
    private javax.swing.JPanel panelEditarFuncionario;
    private javax.swing.JPanel panelEditarServico;
    private javax.swing.JPanel panelFuncionarios;
    private javax.swing.JPanel panelInicio;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel panelRacao;
    private javax.swing.JPanel panelRemedio;
    private javax.swing.JPanel panelRoupa;
    private javax.swing.JPanel panelServicos;
    private javax.swing.JTextField precoCadastrarServico;
    private javax.swing.JTextField precoEditarServico;
    private javax.swing.JSpinner spinnerAnoCadastrarAgendamento;
    private javax.swing.JSpinner spinnerAnoEditarAgendamento;
    private javax.swing.JSpinner spinnerDiaCadastrarAgendamento;
    private javax.swing.JSpinner spinnerDiaEditarAgendamento;
    private javax.swing.JSpinner spinnerHoraCadastrarAgendamento;
    private javax.swing.JSpinner spinnerHoraEditarAgendamento;
    private javax.swing.JSpinner spinnerHoraFimCadastrarFuncionario;
    private javax.swing.JSpinner spinnerHoraFimEditarFuncionario;
    private javax.swing.JSpinner spinnerHoraInicioCadastrarFuncionario;
    private javax.swing.JSpinner spinnerHoraInicioEditarFuncionario;
    private javax.swing.JSpinner spinnerMesCadastrarAgendamento;
    private javax.swing.JSpinner spinnerMesEditarAgendamento;
    private javax.swing.JSpinner spinnerMinutoCadastrarAgendamento;
    private javax.swing.JSpinner spinnerMinutoEditarAgendamento;
    private javax.swing.JSpinner spinnerMinutoFimCadastrarFuncionario;
    private javax.swing.JSpinner spinnerMinutoFimEditarFuncionario;
    private javax.swing.JSpinner spinnerMinutoInicioCadastrarFuncionario;
    private javax.swing.JSpinner spinnerMinutoInicioEditarFuncionario;
    private javax.swing.JTable tableAgendamentos;
    private javax.swing.JTable tableBrinquedos;
    private javax.swing.JTable tableClientesAnimais;
    private javax.swing.JTable tableClientesPessoas;
    private javax.swing.JTable tableFuncionarios;
    private javax.swing.JTable tableMercadorias;
    private javax.swing.JTable tableRacoes;
    private javax.swing.JTable tableRemedios;
    private javax.swing.JTable tableResponsavel;
    private javax.swing.JTable tableResponsavelCadastrar;
    private javax.swing.JTable tableRoupas;
    private javax.swing.JTable tableSelectAnimalCadastrarAgendamento;
    private javax.swing.JTable tableSelectAnimalEditarAgendamento;
    private javax.swing.JTable tableSelectServicoCadastrarAgendamento;
    private javax.swing.JTable tableSelectServicoEditarAgendamento;
    private javax.swing.JTable tableServicos;
    private javax.swing.JTextField telefoneCadastrarCliente;
    private javax.swing.JTextField telefoneEditarCliente;
    private javax.swing.JTextField textNomeCadastrarFuncionario;
    private javax.swing.JTextField textNomeEditarFuncionario;
    private javax.swing.JTextField textPesquisaCpfCadastrarAgendamento;
    private javax.swing.JTextField textPesquisaCpfEditarAgendamento;
    private javax.swing.JPasswordField textSenhaCadastrarFuncionario;
    private javax.swing.JPasswordField textSenhaEditarFuncionario;
    private javax.swing.JTextField textUsuarioCadastrarFuncionario;
    private javax.swing.JTextField textUsuarioEditarFuncionario;
    private javax.swing.JLabel title;
    private javax.swing.JLabel title1;
    private javax.swing.JLabel title10;
    private javax.swing.JLabel title11;
    private javax.swing.JLabel title12;
    private javax.swing.JLabel title13;
    private javax.swing.JLabel title14;
    private javax.swing.JLabel title15;
    private javax.swing.JLabel title16;
    private javax.swing.JLabel title17;
    private javax.swing.JLabel title18;
    private javax.swing.JLabel title19;
    private javax.swing.JLabel title2;
    private javax.swing.JLabel title3;
    private javax.swing.JLabel title4;
    private javax.swing.JLabel title5;
    private javax.swing.JLabel title6;
    private javax.swing.JLabel title7;
    private javax.swing.JLabel title8;
    private javax.swing.JLabel title9;
    // End of variables declaration//GEN-END:variables
}
