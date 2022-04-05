package view;

import controller.AluguelController;
import controller.CarroController;
import controller.ClienteController;
import controller.FuncionarioController;
import model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DetalheAluguelView implements ActionListener {

    private JFrame janela;
    private JLabel labelID = new JLabel("ID: ");
    private JLabel valorID = new JLabel("Automatico ");;
    private JLabel valorIDLabel;
    private JLabel labelFuncionario = new JLabel("Funcionario: ");
    private JTextField valorFuncionario;
    private JLabel valorFuncionarioLabel;
    private JLabel labelCliente = new JLabel("Cliente: ");
    private JTextField valorCliente;
    private JLabel valorClienteLabel;
    private JLabel labelCarro = new JLabel("Carro: ");
    private JTextField valorCarro;
    private JLabel valorCarroLabel;
    private JLabel labelLocalRetirada = new JLabel("Local de retirada: ");
    private JTextField valorLocalRetirada;
    private JLabel valorLocalRetiradaLabel;
    private JLabel labelTotalDias = new JLabel("Total de dias: ");
    private JTextField valorTotalDias;
    private JLabel labelLocalDevolucao = new JLabel("Local de devolucao: ");
    private JTextField valorLocalDevolucao;

    private JButton botaoExcluir = new JButton("Excluir");
    private JButton botaoSalvar = new JButton("Salvar");

    private JComboBox funcionarioBox;
    private JComboBox clienteBox;
    private JComboBox carroBox;

    private String[] comboFuncionario = new String[50];
    private String[] comboCliente = new String[50];
    private String[] comboCarro = new String[50];
    private String boxNameFuncionario;
    private String boxNameCliente;
    private String boxNameCarro;

    private String seleciona;
    private int opcao = 0;
    private int posicao = 0;

    private AluguelController aluguelController = new AluguelController();

    public void inserirEditar(int opcao, int posicao) {

        this.opcao = opcao;
        this.posicao = posicao;

        if (opcao == 1) seleciona = "Cadastro de Aluguel";
        if (opcao == 2) seleciona = "Detalhe de Aluguel";

        janela = new JFrame(seleciona);

        //Preenche dados com dados do Aluguel clicado
        if (opcao == 1) {

            for (int i = 0; i < FuncionarioController.funcionarioList.size(); i++) {
                comboFuncionario[i] = FuncionarioController.funcionarioList.get(i).getNome();
            }

            funcionarioBox = new JComboBox<>(comboFuncionario);
            funcionarioBox.setSelectedItem(1);
            funcionarioBox.addActionListener(e -> {
                JComboBox cb = (JComboBox) e.getSource();
                boxNameFuncionario = (String) cb.getSelectedItem();
                System.out.println(boxNameFuncionario);
            });

            for (int i = 0; i < ClienteController.clienteList.size(); i++) {
                comboCliente[i] = ClienteController.clienteList.get(i).getNome();
            }

            clienteBox = new JComboBox<>(comboCliente);
            clienteBox.setSelectedItem(1);
            clienteBox.addActionListener(e -> {
                JComboBox cb = (JComboBox) e.getSource();
                boxNameCliente = (String) cb.getSelectedItem();
                System.out.println(boxNameCliente);
            });

            for (int i = 0; i < CarroController.carroList.size(); i++) {
                comboCarro[i] = CarroController.carroList.get(i).getModelo();
            }

            carroBox = new JComboBox<>(comboCarro);
            carroBox.setSelectedItem(1);
            carroBox.addActionListener(e -> {
                JComboBox cb = (JComboBox) e.getSource();
                boxNameCarro = (String) cb.getSelectedItem();
                System.out.println(boxNameCarro);
            });

            valorFuncionario = new JTextField(200);
            valorCarro = new JTextField(200);
            valorCliente = new JTextField(200);
            valorLocalRetirada = new JTextField(200);
            valorTotalDias = new JTextField(200);
            valorLocalDevolucao = new JTextField(200);

            labelID.setBounds(30, 20, 150, 25);
            valorID.setBounds(180, 20, 180, 25);
            labelCarro.setBounds(30, 50, 150, 25);
            carroBox.setBounds(180, 50, 180, 25);
            labelCliente.setBounds(30, 80, 180, 25);
            clienteBox.setBounds(180, 80, 180, 25);
            labelFuncionario.setBounds(30, 110, 150, 25);
            funcionarioBox.setBounds(180, 110, 180, 25);
            labelLocalRetirada.setBounds(30, 140, 150, 25);
            valorLocalRetirada.setBounds(180, 140, 180, 25);
            labelTotalDias.setBounds(30, 170, 180, 25);
            valorTotalDias.setBounds(180, 170, 180, 25);
            labelLocalDevolucao.setBounds(30, 200, 180, 25);
            valorLocalDevolucao.setBounds(180, 200, 180, 25);

            botaoSalvar.setBounds(245, 265, 115, 30);

            janela.add(labelID);
            janela.add(valorID);
            janela.add(labelCarro);
            janela.add(carroBox);
            janela.add(labelCliente);
            janela.add(clienteBox);
            janela.add(labelFuncionario);
            janela.add(funcionarioBox);
            janela.add(labelLocalRetirada);
            janela.add(valorLocalRetirada);
            janela.add(labelTotalDias);
            janela.add(valorTotalDias);
            janela.add(labelLocalDevolucao);
            janela.add(valorLocalDevolucao);

            janela.add(botaoSalvar);

        } else if (opcao == 2){ //Não preenche com dados para criar Aluguel

            valorIDLabel = new JLabel(String.valueOf(AluguelController.aluguelList.get(posicao).getId()));
            valorFuncionarioLabel = new JLabel(AluguelController.aluguelList.get(posicao).getFuncionario().getNome());
            valorCarroLabel = new JLabel(AluguelController.aluguelList.get(posicao).getCarro().getModelo());
            valorClienteLabel = new JLabel(AluguelController.aluguelList.get(posicao).getCliente().getNome());
            valorLocalRetiradaLabel = new JLabel(AluguelController.aluguelList.get(posicao).getLocalRetirada());
            valorTotalDias = new JTextField(String.valueOf(AluguelController.aluguelList.get(posicao).getTotalDias()), 200);
            valorLocalDevolucao = new JTextField(AluguelController.aluguelList.get(posicao).getLocalRetirada(), 200);

            labelID.setBounds(30, 20, 150, 25);
            valorIDLabel.setBounds(180, 20, 180, 25);
            labelCarro.setBounds(30, 50, 150, 25);
            valorCarroLabel.setBounds(180, 50, 180, 25);
            labelCliente.setBounds(30, 80, 180, 25);
            valorClienteLabel.setBounds(180, 80, 180, 25);
            labelFuncionario.setBounds(30, 110, 150, 25);
            valorFuncionarioLabel.setBounds(180, 110, 180, 25);
            labelLocalRetirada.setBounds(30, 140, 150, 25);
            valorLocalRetiradaLabel.setBounds(180, 140, 180, 25);
            labelTotalDias.setBounds(30, 170, 180, 25);
            valorTotalDias.setBounds(180, 170, 180, 25);
            labelLocalDevolucao.setBounds(30, 200, 180, 25);
            valorLocalDevolucao.setBounds(180, 200, 180, 25);

            botaoSalvar.setBounds(120, 270, 115, 30);
            botaoExcluir.setBounds(245, 270, 115, 30);

            janela.add(labelID);
            janela.add(valorIDLabel);
            janela.add(labelCarro);
            janela.add(valorCarroLabel);
            janela.add(labelCliente);
            janela.add(valorClienteLabel);
            janela.add(labelFuncionario);
            janela.add(valorFuncionarioLabel);
            janela.add(labelLocalRetirada);
            janela.add(valorLocalRetiradaLabel);
            janela.add(labelTotalDias);
            janela.add(valorTotalDias);
            janela.add(labelLocalDevolucao);
            janela.add(valorLocalDevolucao);

            janela.add(botaoSalvar);
            janela.add(botaoExcluir);
        }

        janela.setLayout(null);

        janela.setSize(400, 355);
        janela.setVisible(true);

        botaoSalvar.addActionListener(this);
        botaoExcluir.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == botaoSalvar) {
            try {
                if (opcao == 1){
                    Aluguel aluguel = new Aluguel();
                    aluguel.setId(AluguelController.aluguelList.size() + 1);

                    for (Funcionario funcionario : FuncionarioController.funcionarioList){
                        if(funcionario.getNome().equals(boxNameFuncionario)){
                            aluguel.setFuncionario(funcionario);
                            break;
                        }
                    }

                    for (Cliente cliente : ClienteController.clienteList){
                        if(cliente.getNome().equals(boxNameCliente)){
                            aluguel.setCliente(cliente);
                            break;
                        }
                    }

                    for (Carro carro : CarroController.carroList){
                        if(carro.getModelo().equals(boxNameCarro)){
                            aluguel.setCarro(carro);
                            break;
                        }
                    }

                    aluguel.setLocalRetirada(valorLocalRetirada.getText());
                    aluguel.setTotalDias(Integer.parseInt(valorTotalDias.getText()));
                    aluguel.setLocalDevolucao(valorLocalDevolucao.getText());
                    aluguelController.cadastrarAluguel(aluguel);
                    mensagemSucessoCadastro();
                } else {

                    aluguelController.atualizaAluguel(AluguelController.aluguelList.get(posicao), Integer.parseInt(valorTotalDias.getText()), valorLocalDevolucao.getText());
                    mensagemSucessoCadastro();
                }
            } catch (NullPointerException | NumberFormatException exc1) {
                mensagemErroCadastro();
            }
        }

        if (src == botaoExcluir) {
            boolean res;
            res = aluguelController.deletarAluguel(AluguelController.aluguelList.get(posicao));
            if (res) {
                mensagemSucessoExclusao();
            } else {
                mensagemErroExclusaoCarro();
            }
        }
    }

    public void mensagemSucessoExclusao() {
        JOptionPane.showMessageDialog(null, "Os dados foram excluidos com sucesso!", null,
                JOptionPane.INFORMATION_MESSAGE);
        janela.dispose();
    }

    public void mensagemSucessoCadastro() {
        JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso!", null,
                JOptionPane.INFORMATION_MESSAGE);
        janela.dispose();
    }

    public void mensagemErroCadastro() {
        JOptionPane.showMessageDialog(null, "ERRO AO SALVAR OS DADOS!\n "
                        + "Pode ter ocorrido um dos dois erros a seguir:  \n"
                        + "1. Nem todos os campos foram preenchidos \n", null,
                JOptionPane.ERROR_MESSAGE);
    }

    public void mensagemErroExclusaoCarro() {
        JOptionPane.showMessageDialog(null, "Ocorreu um erro ao excluir o dado.\n "
                        + "Verifique se o aluno está cadastrado\n", null,
                JOptionPane.ERROR_MESSAGE);
    }
}
