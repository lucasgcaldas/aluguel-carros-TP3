package view;

import controller.CarroController;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarroView implements ActionListener, ListSelectionListener {

    private JFrame janela;
    private JLabel titulo;
    private JLabel totalCarros;
    private JLabel totalCarrosDisp;
    private JButton cadastroCarro;
    private JButton refreshCarro;
    private JList<String> listaCarrosCadastrados;
    private String[] arrayNomesCarros = new String[50];
    private int posicao = 0;

    private CarroController carroController = new CarroController();

    // Mostrar dados de Carros cadastrados (JList)
    public void mostraCarros() {
        for(int i = 0; i < CarroController.carroList.size(); i++){
            arrayNomesCarros[i] = CarroController.carroList.get(i).getMarca() + " " +CarroController.carroList.get(i).getModelo() + ": " + CarroController.carroList.get(i).getPlaca();
        }
        listaCarrosCadastrados = new JList<>(arrayNomesCarros);
        janela = new JFrame("Carros");
        titulo = new JLabel("Carros Cadastrados");
        totalCarros = new JLabel("Total de carros: " + carroController.totalCarros());
        totalCarrosDisp = new JLabel("Total de carros disponiveis: " + carroController.totalCarrosDisp());
        cadastroCarro = new JButton("Cadastrar");
        refreshCarro = new JButton("Atualizar");

        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        totalCarros.setFont(new Font("Arial", Font.BOLD, 10));
        totalCarrosDisp.setFont(new Font("Arial", Font.BOLD, 10));
        titulo.setBounds(90, 10, 250, 30);
        totalCarros.setBounds(20, 40, 250, 30);
        totalCarrosDisp.setBounds(20, 70, 250, 30);
        listaCarrosCadastrados.setBounds(20, 100, 350, 120);
        listaCarrosCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        listaCarrosCadastrados.setVisibleRowCount(10);

        cadastroCarro.setBounds(70, 227, 100, 30);
        refreshCarro.setBounds(200, 227, 100, 30);

        janela.setLayout(null);

        janela.add(titulo);
        janela.add(totalCarros);
        janela.add(totalCarrosDisp);
        janela.add(listaCarrosCadastrados);
        janela.add(cadastroCarro);
        janela.add(refreshCarro);

        janela.setSize(400, 300);
        janela.setVisible(true);

        cadastroCarro.addActionListener(this);
        refreshCarro.addActionListener(this);
        listaCarrosCadastrados.addListSelectionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        //Cadastro de novo Carro
        if (src == cadastroCarro) {
            new DetalheCarroView().inserirEditar(1, posicao);
        }

        // Atualiza a lista de nomes de Carro mostrada no JList
        if (src == refreshCarro) {
            for(int i = 0; i < CarroController.carroList.size(); i++){
                arrayNomesCarros[i] = CarroController.carroList.get(i).getMarca() + " " +CarroController.carroList.get(i).getModelo() + ": " + CarroController.carroList.get(i).getPlaca();
            }

            listaCarrosCadastrados = new JList<>(arrayNomesCarros);
            listaCarrosCadastrados.setListData(arrayNomesCarros);
            listaCarrosCadastrados.updateUI();
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        Object src = e.getSource();
        if (e.getValueIsAdjusting() && src == listaCarrosCadastrados) {
            posicao = listaCarrosCadastrados.getSelectedIndex();
            new DetalheCarroView().inserirEditar(2, posicao);
        }
    }
}
