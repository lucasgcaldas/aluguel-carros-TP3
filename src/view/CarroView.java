package view;

import controller.CarroController;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe responsavel por ser a view referente ao carro
 *
 * @author Lucas Gomes - 212005426
 */
public class CarroView implements ActionListener, ListSelectionListener {

    private JFrame janela;
    private JLabel titulo;
    private JLabel totalCarros;
    private JLabel totalCarrosDisp;
    private JButton cadastroCarro;
    private JList<String> listaCarrosCadastrados;
    private String[] arrayNomesCarros = new String[50];
    private int posicao = 0;

    private CarroController carroController = new CarroController();

    /**
     * Metodo responsavel por mostrar dados de carros cadastrados
     * por meio de um JList
     */
    public void mostraCarros() {
        for (int i = 0; i < CarroController.carroList.size(); i++) {
            arrayNomesCarros[i] = CarroController.carroList.get(i).getMarca() + " " + CarroController.carroList.get(i).getModelo() + ": " + CarroController.carroList.get(i).getPlaca();
        }
        listaCarrosCadastrados = new JList<>(arrayNomesCarros);
        janela = new JFrame("Carros");
        titulo = new JLabel("Carros Cadastrados");
        totalCarros = new JLabel("Total de carros: " + carroController.totalCarros());
        totalCarrosDisp = new JLabel("Total de carros disponiveis: " + carroController.totalCarrosDisp());
        cadastroCarro = new JButton("Cadastrar");

        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        totalCarros.setFont(new Font("Arial", Font.BOLD, 10));
        totalCarrosDisp.setFont(new Font("Arial", Font.BOLD, 10));
        titulo.setBounds(90, 10, 250, 30);
        totalCarros.setBounds(20, 40, 250, 30);
        totalCarrosDisp.setBounds(20, 70, 250, 30);
        listaCarrosCadastrados.setBounds(20, 100, 350, 120);
        listaCarrosCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        listaCarrosCadastrados.setVisibleRowCount(10);

        cadastroCarro.setBounds(140, 227, 100, 30);

        janela.setLayout(null);

        janela.add(titulo);
        janela.add(totalCarros);
        janela.add(totalCarrosDisp);
        janela.add(listaCarrosCadastrados);
        janela.add(cadastroCarro);

        janela.setSize(400, 300);
        janela.setVisible(true);

        cadastroCarro.addActionListener(this);
        listaCarrosCadastrados.addListSelectionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        //Cadastro de novo Carro
        if (src == cadastroCarro) {
            new DetalheCarroView().inserirEditar(1, posicao);
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
