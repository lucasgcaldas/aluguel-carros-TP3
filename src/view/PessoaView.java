package view;

import controller.ClienteController;
import controller.FuncionarioController;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe responsavel por ser a view referente a pessoa
 *
 * @author Lucas Gomes - 212005426
 */
public class PessoaView implements ActionListener, ListSelectionListener {

    private JFrame janela;
    private JLabel titulo;
    private JButton cadastroFuncionario;
    private JButton cadastroCliente;
    private JList<String> listaFuncionariosCadastrados;
    private JList<String> listaClientesCadastrados;
    private String[] arrayNomesFuncionario = new String[50];
    private String[] arrayNomesClientes = new String[50];
    private int posicao = 0;

    /**
     * Metodo responsavel por selecioar a opcao desejada pelo usuario
     * (1) Mostrar dados de Funcionarios cadastrados (JList)
     * (2) Mostrar dados de Clientes cadastrados (JList)
     *
     * @param opcao
     */
    public void menuPersonalizado(int opcao) {
        switch (opcao) {
            case 1 -> {// Mostrar dados de Funcionarios cadastrados (JList)
                for (int i = 0; i < FuncionarioController.funcionarioList.size(); i++) {
                    arrayNomesFuncionario[i] = FuncionarioController.funcionarioList.get(i).getNome();
                }
                listaFuncionariosCadastrados = new JList<>(arrayNomesFuncionario);
                janela = new JFrame("Funcionarios");
                titulo = new JLabel("Funcionarios Cadastrados");
                cadastroFuncionario = new JButton("Cadastrar");
                titulo.setFont(new Font("Arial", Font.BOLD, 20));
                titulo.setBounds(90, 10, 250, 30);
                listaFuncionariosCadastrados.setBounds(20, 50, 350, 120);
                listaFuncionariosCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
                listaFuncionariosCadastrados.setVisibleRowCount(10);
                cadastroFuncionario.setBounds(150, 177, 100, 30);
                janela.setLayout(null);
                janela.add(titulo);
                janela.add(listaFuncionariosCadastrados);
                janela.add(cadastroFuncionario);
                janela.setSize(400, 250);
                janela.setVisible(true);
                cadastroFuncionario.addActionListener(this);
                listaFuncionariosCadastrados.addListSelectionListener(this);
            }
            case 2 -> {// Mostrar dados de Clientes cadastrados (JList)
                for (int i = 0; i < ClienteController.clienteList.size(); i++) {
                    arrayNomesClientes[i] = ClienteController.clienteList.get(i).getNome();
                }
                listaClientesCadastrados = new JList<>(arrayNomesClientes);
                janela = new JFrame("Clientes");
                titulo = new JLabel("Clientes Cadastrados");
                cadastroCliente = new JButton("Cadastrar");
                titulo.setFont(new Font("Arial", Font.BOLD, 20));
                titulo.setBounds(90, 10, 250, 30);
                listaClientesCadastrados.setBounds(20, 50, 350, 120);
                listaClientesCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
                listaClientesCadastrados.setVisibleRowCount(10);
                cadastroCliente.setBounds(140, 177, 100, 30);
                janela.setLayout(null);
                janela.add(titulo);
                janela.add(listaClientesCadastrados);
                janela.add(cadastroCliente);
                janela.setSize(400, 250);
                janela.setVisible(true);
                cadastroCliente.addActionListener(this);
                listaClientesCadastrados.addListSelectionListener(this);
            }
            default -> JOptionPane.showMessageDialog(null, "Opção não encontrada!", null,
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        // Cadastro de novo Funcionario
        if (src == cadastroFuncionario) {
            new DetalhePessoaView().inserirEditar(1, posicao);
        }

        // Cadastro de novo Clientes
        if (src == cadastroCliente) {
            new DetalhePessoaView().inserirEditar(2, posicao);
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        Object src = e.getSource();
        if (e.getValueIsAdjusting() && src == listaFuncionariosCadastrados) {
            posicao = listaFuncionariosCadastrados.getSelectedIndex();
            new DetalhePessoaView().inserirEditar(3, posicao);
        }

        if (e.getValueIsAdjusting() && src == listaClientesCadastrados) {
            posicao = listaClientesCadastrados.getSelectedIndex();
            new DetalhePessoaView().inserirEditar(4, posicao);
        }
    }
}
