package view;

import controller.CarroController;
import controller.ClienteController;
import controller.FuncionarioController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DetalheCarroView implements ActionListener {

    private JFrame janela;
    private JLabel labelMarca = new JLabel("Marca: ");
    private JTextField valorMarca;
    private JLabel labelModel = new JLabel("Modelo: ");
    private JTextField valorModel;
    private JLabel labelAnoFab = new JLabel("Ano Fabricacao: ");
    private JTextField valorAnoFab;
    private JLabel labelPlaca = new JLabel("Placa: ");
    private JTextField valorPlaca;
    private JLabel labelValDia = new JLabel("Valor Diaria: ");
    private JTextField valorValDia;

    private JButton botaoExcluir = new JButton("Excluir");
    private JButton botaoSalvar = new JButton("Salvar");

    private String seleciona;
    private int opcao = 0;
    private int posicao = 0;

    public void inserirEditar(int opcao, int posicao) {

        this.opcao = opcao;
        this.posicao = posicao;

        if (opcao == 1) seleciona = "Cadastro de Carro";
        if (opcao == 2) seleciona = "Detalhe de Carro";

        janela = new JFrame(seleciona);

        //Preenche dados com dados do Carro clicado
        if (opcao == 2) {
            valorMarca = new JTextField(CarroController.carroList.get(posicao).getMarca(), 200);
            valorModel = new JTextField(CarroController.carroList.get(posicao).getModelo(), 200);
            valorPlaca = new JTextField(CarroController.carroList.get(posicao).getPlaca(), 200);
            valorAnoFab = new JTextField(CarroController.carroList.get(posicao).getAnoFabricacao(), 200);
            valorValDia = new JTextField(CarroController.carroList.get(posicao).getValorDiaria().toString(), 200);
        } else { //Não preenche com dados

            valorMarca = new JTextField(200);
            valorPlaca = new JTextField(200);
            valorAnoFab = new JTextField(200);
            valorModel = new JTextField(200);
            valorValDia = new JTextField(200);

            botaoSalvar.setBounds(245, 205, 115, 30);
        }

        labelMarca.setBounds(30, 20, 150, 25);
        valorMarca.setBounds(180, 20, 180, 25);
        labelPlaca.setBounds(30, 50, 150, 25);
        valorPlaca.setBounds(180, 50, 180, 25);
        labelAnoFab.setBounds(30, 80, 180, 25);
        valorAnoFab.setBounds(180, 80, 180, 25);
        labelModel.setBounds(30, 110, 150, 25);
        valorModel.setBounds(180, 110, 180, 25);
        labelValDia.setBounds(30, 140, 150, 25);
        valorValDia.setBounds(180, 140, 180, 25);

        //Coloca os campos relacionados a endereco se aluno
        if (opcao == 1 || opcao == 2) {
            janela.add(labelMarca);
            janela.add(valorMarca);
            janela.add(labelPlaca);
            janela.add(valorPlaca);
            janela.add(labelAnoFab);
            janela.add(valorAnoFab);
            janela.add(labelModel);
            janela.add(valorModel);
            janela.add(labelValDia);
            janela.add(valorValDia);

            labelValDia.setBounds(30, 140, 150, 25);
            valorValDia.setBounds(180, 140, 180, 25);
        }

        //Coloca botoes de excluir e salvar
        if (opcao == 2) {
            botaoSalvar.setBounds(120, 210, 115, 30);
            botaoExcluir.setBounds(245, 210, 115, 30);
            janela.add(botaoExcluir);
        }

        janela.add(botaoSalvar);

        janela.setLayout(null);

        janela.setSize(400, 290);
        janela.setVisible(true);

        botaoSalvar.addActionListener(this);
        botaoExcluir.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == botaoSalvar) {
            try {
                boolean res;
                if (opcao == 1) { // cadastro de Funcionario

                } else if (opcao == 2) { // cadastro de Cliente

                } else { // Edicao de dado existente

                }

                if (opcao == 1 || opcao == 3) {
//                    novoDado[2] = valorSenha.getText();
//                    res = dados.inserirEditarAluno(novoDado);
                } else {
//                    novoDado[2] = valorEmail.getText();
//                    res = dados.inserirEditarProf(novoDado);
                }

//                if (res) {
//                    mensagemSucessoCadastro();
//                } else mensagemErroCadastro();

            } catch (NullPointerException | NumberFormatException exc1) {
                mensagemErroCadastro();
            }
        }

        if (src == botaoExcluir) {
            boolean res = false;

            if (opcao == 3) {//exclui aluno
//                res = dados.removerAluno(posicao);
//                if (res) mensagemSucessoExclusao();
//                else mensagemErroExclusaoAluno();
            }

            if (opcao == 4) { //exclui professor
//                res = dados.removerProfessor(posicao);
//                if (res) mensagemSucessoExclusao();
//                else mensagemErroExclusaoProf();
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
                        + "1. Nem todos os campos foram preenchidos \n"
                        + "2. CPF, identidade, DDD e telefone não contém apenas números", null,
                JOptionPane.ERROR_MESSAGE);
    }

    public void mensagemErroExclusaoAluno() {
        JOptionPane.showMessageDialog(null, "Ocorreu um erro ao excluir o dado.\n "
                        + "Verifique se o aluno está matriculado\n"
                        + "em alguma disciplina. Se sim, cancele\n "
                        + "a matricula e tente novamente.", null,
                JOptionPane.ERROR_MESSAGE);
    }

    public void mensagemErroExclusaoProf() {
        JOptionPane.showMessageDialog(null, "Ocorreu um erro ao excluir o dado.\n "
                        + "Verifique se o professor está responsável\n"
                        + "por alguma disciplina. Se sim, substitua\n "
                        + "o professor e tente novamente.", null,
                JOptionPane.ERROR_MESSAGE);
    }
}
