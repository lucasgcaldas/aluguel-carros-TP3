package view;

import controller.AluguelController;
import controller.CarroController;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AluguelView implements ActionListener, ListSelectionListener {

    private JFrame janela;
    private JLabel titulo;
    private JButton cadastroAluguel;
    private JButton refreshAluguel;
    private JList<String> listaAlugueisCadastrados;
    private String[] arrayNomesAlugueis = new String[50];
    private int posicao = 0;

    private AluguelController aluguelController = new AluguelController();

    // Mostrar dados de Carros cadastrados (JList)
    public void mostraAluguel() {
        for(int i = 0; i < AluguelController.aluguelList.size(); i++){
            arrayNomesAlugueis[i] = "Aluguel " + AluguelController.aluguelList.get(i).getId();
        }
        listaAlugueisCadastrados = new JList<>(arrayNomesAlugueis);
        janela = new JFrame("Alugueis");
        titulo = new JLabel("Alugueis Cadastrados");
        cadastroAluguel = new JButton("Cadastrar");
        refreshAluguel = new JButton("Atualizar");

        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setBounds(90, 10, 250, 30);
        listaAlugueisCadastrados.setBounds(20, 100, 350, 120);
        listaAlugueisCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        listaAlugueisCadastrados.setVisibleRowCount(10);

        cadastroAluguel.setBounds(70, 227, 100, 30);
        refreshAluguel.setBounds(200, 227, 100, 30);

        janela.setLayout(null);

        janela.add(titulo);
        janela.add(listaAlugueisCadastrados);
        janela.add(cadastroAluguel);
        janela.add(refreshAluguel);

        janela.setSize(400, 300);
        janela.setVisible(true);

        cadastroAluguel.addActionListener(this);
        refreshAluguel.addActionListener(this);
        listaAlugueisCadastrados.addListSelectionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        //Cadastro de Aluguel
        if (src == cadastroAluguel) {
            new DetalheAluguelView().inserirEditar(1, posicao);
        }

        // Atualiza a lista dos nomes dos Alugueis mostrada no JList
        if (src == refreshAluguel) {
            for(int i = 0; i < AluguelController.aluguelList.size(); i++){
                arrayNomesAlugueis[i] = "Aluguel " + AluguelController.aluguelList.get(i).getId();
            }

            listaAlugueisCadastrados = new JList<>(arrayNomesAlugueis);
            listaAlugueisCadastrados.setListData(arrayNomesAlugueis);
            listaAlugueisCadastrados.updateUI();
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        Object src = e.getSource();
        if (e.getValueIsAdjusting() && src == listaAlugueisCadastrados) {
            posicao = listaAlugueisCadastrados.getSelectedIndex();
            new DetalheAluguelView().inserirEditar(2, posicao);
        }
    }
}
