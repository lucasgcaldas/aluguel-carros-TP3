package view;

import controller.AluguelController;
import controller.CarroController;
import controller.ClienteController;
import controller.FuncionarioController;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuView implements ActionListener {

    private static JFrame janela = new JFrame("Alguel de Carros");
    private static JLabel titulo = new JLabel("Menu Principal");
    private static JLabel escolha = new JLabel("Escolha uma opcao para iniciar:");
    private static JButton funcionario = new JButton("Funcionario");
    private static JButton cliente = new JButton("Cliente");
    private static JButton carro = new JButton("Carro");

    public MenuView() {
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        escolha.setFont(new Font("Arial", Font.PLAIN, 15));

        titulo.setBounds(120, 10, 150, 30);
        escolha.setBounds(85, 40, 250, 30);
        funcionario.setBounds(140, 80, 100, 30);
        cliente.setBounds(140, 130, 100, 30);
        carro.setBounds(140, 180, 100, 30);

        janela.setLayout(null);

        janela.add(titulo);
        janela.add(escolha);
        janela.add(funcionario);
        janela.add(cliente);
        janela.add(carro);

        janela.setSize(400, 300);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }

    public static void main(String[] args) {
        MenuView menu = new MenuView();

        cliente.addActionListener(menu);
        funcionario.addActionListener(menu);
        carro.addActionListener(menu);

        carregaDados(); // carrega dados no sistema de forma automatica
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == funcionario) {
            new PessoaView().menuPersonalizado(1);
        }

        if (src == cliente) {
            new PessoaView().menuPersonalizado(2);
        }

        if (src == carro) {
            new CarroView().mostraCarros();
        }
    }

    public static void carregaDados() {
        // Carregando dados no sistema
        Cliente cliente1 = new Cliente("Lucas", "123.456.789-10",
                "lucas@email.com", "1234",
                "Luziania", CatHabEnum.B);

        Cliente cliente2 = new Cliente("Bianca", "745.894.365-12",
                "bianca@email.com", "1234",
                "Goiania", CatHabEnum.AB);

        Funcionario funcionario1 = new Funcionario("Joao", "145.999.466-53",
                "maria@email.com", "1234",
                800.00, CargoEnum.ESTAGIARIO);

        Funcionario funcionario2 = new Funcionario("Maria", "145.788.466-96",
                "maria@email.com", "1234",
                3500.00, CargoEnum.GERENTE);

        Funcionario funcionario3 = new Funcionario("Felipe", "707.788.466-55",
                "felipe@email.com", "1234",
                2500.00, CargoEnum.ATENDENTE);

        Carro carro1 = new Carro("Fiat", "Argo", "KNI-1234", "2018", 90.00);
        Carro carro2 = new Carro("VW", "Gol", "JJK-1234", "2019", 90.00);
        Carro carro3 = new Carro("Hyunday", "HB20", "ABC-1234", "2017", 75.00);
        Carro carro4 = new Carro("Renault", "Kwid", "CCT-1234", "2020", 75.00);
        Carro carro5 = new Carro("Chevrolet", "Onix", "AAB-1234", "2020", 100.00);

        Aluguel aluguel1 = new Aluguel(1, funcionario1, cliente1, carro1, "Asa Sul", 3, "Asa Sul");
        Aluguel aluguel2 = new Aluguel(2, funcionario2, cliente2, carro2, "Guara 2", 3, "Asa Sul");
        Aluguel aluguel3 = new Aluguel(3, funcionario1, cliente2, carro3, "Guara 1", 3, "Cruzeiro");
        Aluguel aluguel4 = new Aluguel(4, funcionario2, cliente2, carro4, "Taguatinga", 3, "Asa Norte");

        ClienteController.clienteList.add(cliente1);
        ClienteController.clienteList.add(cliente2);

        FuncionarioController.funcionarioList.add(funcionario1);
        FuncionarioController.funcionarioList.add(funcionario2);
        FuncionarioController.funcionarioList.add(funcionario3);

        CarroController.carroList.add(carro1);
        CarroController.carroList.add(carro2);
        CarroController.carroList.add(carro3);
        CarroController.carroList.add(carro4);
        CarroController.carroList.add(carro5);

        AluguelController.aluguelList.add(aluguel1);
        AluguelController.aluguelList.add(aluguel2);
        AluguelController.aluguelList.add(aluguel3);
        AluguelController.aluguelList.add(aluguel4);
    }
}
