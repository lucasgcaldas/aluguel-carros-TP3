package view;

import controller.AluguelController;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe responsavel por ser a view referente ao aluguel
 *
 * @author Lucas Gomes - 212005426
 */
public class AluguelView implements ActionListener, ListSelectionListener {

    private JFrame janela;
    private JLabel titulo;
    private JLabel totalAlugueis;
    private JButton cadastroAluguel;
    private JList<String> listaAlugueisCadastrados;
    private String[] arrayNomesAlugueis = new String[50];
    private int posicao = 0;

    private AluguelController aluguelController = new AluguelController();

    /**
     * Metodo responsavel por mostrar dados de alugueis cadastrados
     * por meio de um JList
     */
    public void mostraAluguel() {
        for (int i = 0; i < AluguelController.aluguelList.size(); i++) {
            arrayNomesAlugueis[i] = "Aluguel " + AluguelController.aluguelList.get(i).getId() + " - Valor total R$ " + aluguelController.valorTotalAluguel(AluguelController.aluguelList.get(i));
        }
        listaAlugueisCadastrados = new JList<>(arrayNomesAlugueis);
        janela = new JFrame("Alugueis");
        titulo = new JLabel("Alugueis Cadastrados");
        totalAlugueis = new JLabel("Total de alugueis: " + aluguelController.totalAlugueis());
        cadastroAluguel = new JButton("Cadastrar");

        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        totalAlugueis.setFont(new Font("Arial", Font.BOLD, 10));
        titulo.setBounds(90, 10, 250, 30);
        totalAlugueis.setBounds(20, 40, 250, 30);
        listaAlugueisCadastrados.setBounds(20, 100, 350, 120);
        listaAlugueisCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        listaAlugueisCadastrados.setVisibleRowCount(10);

        cadastroAluguel.setBounds(140, 227, 100, 30);

        janela.setLayout(null);

        janela.add(titulo);
        janela.add(totalAlugueis);
        janela.add(listaAlugueisCadastrados);
        janela.add(cadastroAluguel);

        janela.setSize(400, 300);
        janela.setVisible(true);

        cadastroAluguel.addActionListener(this);
        listaAlugueisCadastrados.addListSelectionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        //Cadastro de Aluguel
        if (src == cadastroAluguel) {
            new DetalheAluguelView().inserirEditar(1, posicao);
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
