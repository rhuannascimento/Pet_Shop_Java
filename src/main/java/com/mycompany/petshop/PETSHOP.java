/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.petshop;

import com.mycompany.petshop.business.funcionarios.ExibirFuncionario;
import com.mycompany.petshop.model.classes.*;
import com.mycompany.petshop.repository.*;
import com.mycompany.petshop.view.Tela;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rhuan
 */
public class PETSHOP {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {
        Migrator m = new Migrator();
        Seeder s = new Seeder();

        boolean bmigrate = false, bseed = false, btest = false;

        for (String arg : args) {
            if (arg.equalsIgnoreCase("migrate")) {
                bmigrate = m.migrate();
            }
            if (arg.equalsIgnoreCase("seed")) {
                bseed = s.seed();
            }
            if (arg.equalsIgnoreCase("test")) {
                btest = testar();
            }
        }

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n-----------" + ANSI_BLUE + "resultados: \n");
        if (bmigrate) {
            System.out.println(ANSI_GREEN + "MIGRAÇÃO: CONCLUÍDA!");
        } else {
            System.out.println(ANSI_RED + "MIGRAÇÃO: NÃO EXECUTADO!");
        }
        if (bmigrate) {
            System.out.println(ANSI_GREEN + "SEED: CONCLUÍDA!");
        } else {
            System.out.println(ANSI_RED + "SEED: NÃO EXECUTADO!");
        }
        if (bmigrate) {
            System.out.println(ANSI_GREEN + "TESTE: CONCLUÍDA!");
        } else {
            System.out.println(ANSI_RED + "TESTE: NÃO EXECUTADO!");
        }
        System.out.println(ANSI_RESET);

        Funcionario l = new Funcionario(123, "Lucas", new Time(0, 0, 0), new Time(0, 0, 0), "gerente", "lc", "123");

        Tela tela = new Tela(l);
        tela.renderiza();
    }

    static boolean testar() {
        boolean RES = false;
        try {
            // SEGUE ABAIXO EXEMPLO DE COMO USAR O REPOSITORY
            // Repository Funcionario
            System.out.println(ANSI_CYAN + "\n\n\n----------TESTANDO REPOSITORIO FUNCIONARIO" + ANSI_RESET);
            FuncionarioRep rep = new FuncionarioRep();

            // lista funcionários
            System.out.println(ANSI_PURPLE + "\n Listando todos os funcionários" + ANSI_RESET);
            ArrayList<Funcionario> funcionarios = listarFuncionarios();

            // atualiza primeiro funcionário da lista
            System.out.println(ANSI_PURPLE + "\n Buscando funcionario de id 3" + ANSI_RESET);
            Funcionario toUpdate = funcionarios.get(3);
            toUpdate.setNome("Teste testado");
            System.out.println(ANSI_PURPLE + "\n Atualizando funcionario de id 1" + ANSI_RESET);
            rep.update(toUpdate);

            // insere funcionário novo
            System.out.println(ANSI_PURPLE + "\n Criando novo funcionário" + ANSI_RESET);
            rep.insertOne(new Funcionario(0, "Novo funcionario tal", Time.valueOf("08:00:00"), Time.valueOf("12:00:00"),
                    "funcionario", "user.name", "senhacaio"));

            // lista dnv
            System.out.println(ANSI_PURPLE + "\n Listando todos os funcionários" + ANSI_RESET);
            funcionarios = listarFuncionarios();

            // deleta o funcionário de id 1, e tbm o 3° funcionário da lista
            System.out.println(ANSI_PURPLE + "\n Buscando funcionario de id 2" + ANSI_RESET);
            Funcionario toDelete = funcionarios.get(2);
            System.out.println(ANSI_PURPLE + "\n Atualizando funcionario de id 1 e 2" + ANSI_RESET);
            rep.deleteById(1);
            rep.delete(toDelete);

            System.out.println(ANSI_PURPLE + "\n Listando todos os funcionários" + ANSI_RESET);
            funcionarios = listarFuncionarios();
            System.out.println(ANSI_PURPLE + "\n Buscando o usuário lucas duarte" + ANSI_RESET);
            ArrayList<Funcionario> lista = rep.getByUsername("lucas.duarte");

            if (lista.size() == 0) {
                System.out.println(ANSI_PURPLE + "Não existe funcionário com esse username!" + ANSI_RESET);
            } else {
                System.out.println(ANSI_PURPLE + "Existe funcionário com esse username!" + ANSI_RESET);
            }

            System.out.println(ANSI_PURPLE + "\n Buscando pelo nome 'Ca' " + ANSI_RESET);
            System.out.println(ANSI_PURPLE + rep.getByNome("Ca"));

            // Repository Cliente
            System.out.println(ANSI_CYAN + "\n\n\n----------TESTANDO REPOSITORIO CLIENTE" + ANSI_RESET);
            ClienteRep cr = new ClienteRep();

            System.out.println(ANSI_PURPLE + "\n Listando clientes" + ANSI_RESET);
            ArrayList<Cliente> clientes = listarClientes();

            System.out.println(ANSI_PURPLE + "\n Listando cliente 1" + ANSI_RESET);
            Cliente c = clientes.get(1);
            c.setNome("Claudim buxexa");
            System.out.println(ANSI_PURPLE + "\n Atualizando cliente 1" + ANSI_RESET);
            cr.update(c);

            System.out.println(ANSI_PURPLE + "\n Inserindo animal" + ANSI_RESET);
            Animal a = new Animal(0, "Cachorro do claudim", c.getCpf(), "Cachorro");

            cr.insertOne(a);

            System.out.println(ANSI_PURPLE + "\n Deletando animal id 2" + ANSI_RESET);
            cr.deleteById(2);

            System.out.println(ANSI_PURPLE + "\n Listando clientes" + ANSI_RESET);
            clientes = listarClientes();

            System.out.println(ANSI_PURPLE + "\n Listando clientes com nome Ca" + ANSI_RESET);
            System.out.println(ANSI_PURPLE + cr.getByNome("Ca"));

            // Repository Itens
            System.out.println(ANSI_CYAN + "\n\n\n----------TESTANDO REPOSITORIO ITEMS" + ANSI_RESET);
            System.out.println(ANSI_PURPLE + "\n Listando items" + ANSI_RESET);
            ArrayList<Item> itens = listarItens();

            System.out.println(ANSI_PURPLE + "\n Listando item 1" + ANSI_RESET);
            Item a2s = itens.get(0);
            System.out.println(a2s);
            Servico s2 = null;
            if (a2s.getTipo().equalsIgnoreCase("servico")) {
                s2 = (Servico) a2s;
            }

            s2.setDuracao(90);// minutos

            ItemRep ir = new ItemRep();

            System.out.println(ANSI_PURPLE + "\n Atualizando servico 2" + ANSI_RESET);
            ir.update(s2);

            System.out.println(ANSI_PURPLE + "\n apagando item id 5" + ANSI_RESET);
            ir.delete(itens.get(4));

            System.out.println(ANSI_PURPLE + "\n listando item id 1" + ANSI_RESET);
            System.out.println(ir.getById(1));

            System.out.println(ANSI_PURPLE + "\n Listando items por nome roup" + ANSI_RESET);
            System.out.println(ir.getByNome("roup"));

            //
            AgendamentoRep ar = new AgendamentoRep();

            System.out.println(ANSI_CYAN + "\n\n\n----------TESTANDO REPOSITORIO ITEMS" + ANSI_RESET);
            System.out.println(ANSI_PURPLE + "\n\nExibindo tudo" + ANSI_RESET);
            imprimirListaAgendamento(ar.getAll());

            System.out.println(ANSI_PURPLE + "\n\nobtendo animal 3" + ANSI_RESET);
            Animal an1 = (Animal) cr.getById(3);

            System.out.println(ANSI_PURPLE + "\n\nobtendo serv 1" + ANSI_RESET);
            Servico s1 = (Servico) ir.getById(1);

            System.out.println(ANSI_PURPLE + "\n\nfazendo agendamento 1" + ANSI_RESET);
            Agendamento a1 = new Agendamento(0, new Timestamp(2023, 2, 14, 14, 0, 0, 0), an1, s1);

            System.out.println(ANSI_PURPLE + "\n\n inserindo agendamento 1" + ANSI_RESET);
            ar.insertOne(a1);

            System.out.println(ANSI_PURPLE + "\n\n buscando agendamentos 3 e 4" + ANSI_RESET);
            Agendamento ag2 = ar.getById(3);
            Agendamento a3 = ar.getById(4);

            System.out.println(ANSI_PURPLE + "\n\n atualizando agendamento 3" + ANSI_RESET);
            ag2.setAnimal(an1);

            ar.update(ag2);

            System.out.println(ANSI_PURPLE + "\n\n apagando agendamento 4 e 5" + ANSI_RESET);
            ar.delete(a3);

            ar.deleteById(5);

            System.out.println(ANSI_PURPLE + "\n\nExibindo por serviço 6" + ANSI_RESET);
            imprimirListaAgendamento(ar.getByServico(6));

            System.out.println(ANSI_PURPLE + "\n\nExibindo por animal 3" + ANSI_RESET);
            imprimirListaAgendamento(ar.getByAnimal(3));

            System.out.println(ANSI_PURPLE + "\n\nExibindo por timestamp 26/1/22" + ANSI_RESET);
            imprimirListaAgendamento(ar.getByDate(new Timestamp(2023, 1, 26, 0, 0, 0, 0)));

            System.out.println(ANSI_PURPLE + "\n\nExibindo por data 26/1/22" + ANSI_RESET);
            imprimirListaAgendamento(ar.getByDate(new Date(2023, 1, 26)));

            System.out.println(ANSI_GREEN + "----------- TESTES FINALIZADOS, RESETANDO BANCO DE DADOS!" + ANSI_RESET);
            RES = true;
        } catch (Exception ex) {
            ex.printStackTrace();

        } finally {
            Seeder s = new Seeder();
            s.reset();
        }
        return RES;
    }

    static ArrayList<Funcionario> listarFuncionarios() {
        FuncionarioRep rep = new FuncionarioRep();
        ArrayList<Funcionario> funcionarios = rep.getAll();
        for (Funcionario f : funcionarios) {
            System.out.println(f);
        }
        System.out.println("\n\n");
        return funcionarios;
    }

    static void imprimirListaAgendamento(ArrayList<Agendamento> lista) {
        System.out.println(lista);
        for (Agendamento a : lista) {
            System.out.println(a);
        }
    }

    static ArrayList<Item> listarItens() {
        ItemRep rep = new ItemRep();
        ArrayList<Item> itens = rep.getAll();
        for (Item f : itens) {
            System.out.println(f);
        }
        System.out.println("\n\n");
        return itens;
    }

    static ArrayList<Cliente> listarClientes() {
        ClienteRep cr = new ClienteRep();
        ArrayList<Cliente> clientes = cr.getAll();
        for (Cliente f : clientes) {
            System.out.println(f);
        }
        System.out.println("\n\n");
        return clientes;
    }
}
