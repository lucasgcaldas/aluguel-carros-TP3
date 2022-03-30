package view;

import controller.ClienteController;
import controller.FuncionarioController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DetalhePessoaView implements ActionListener {

    private JFrame janela;
    private JLabel labelNome = new JLabel("Nome: ");
    private JTextField valorNome;
    private JLabel labelCPF = new JLabel("CPF: ");
    private JTextField valorCPF;
    private JLabel labelEmail = new JLabel("Email: ");
    private JTextField valorEmail;
    private JLabel labelSenha = new JLabel("Senha: ");
    private JTextField valorSenha;

    // Funcionario
    private JLabel labelSalario = new JLabel("Salario: ");
    private JTextField valorSalario;
    private JLabel labelCargo = new JLabel("Cargo: ");
    private JTextField valorCargo;

    // Cliente
    private JLabel labelCidade = new JLabel("Cidade: ");
    private JTextField valorCidade;
    private JLabel labelCategoriaHabilitacao = new JLabel("Categoria Habilitacao: ");
    private JTextField valorCategoriaHabilitacao;

    private JButton botaoExcluir = new JButton("Excluir");
    private JButton botaoSalvar = new JButton("Salvar");

    private String seleciona;
    private int opcao = 0;
    private int posicao = 0;

    public void inserirEditar(int opcao, int posicao) {

        this.opcao = opcao;
        this.posicao = posicao;

        if (opcao == 1) seleciona = "Cadastro de Funcionario";
        if (opcao == 2) seleciona = "Cadastro de Cliente";
        if (opcao == 3) seleciona = "Detalhe de Funcionario";
        if (opcao == 4) seleciona = "Detalhe de Cliente";

        janela = new JFrame(seleciona);

        //Preenche dados com dados do funcionario clicado
        if (opcao == 3) {
            valorNome = new JTextField(FuncionarioController.funcionarioList.get(posicao).getNome(), 200);
            valorSenha = new JTextField(FuncionarioController.funcionarioList.get(posicao).getSenha(), 200);
            valorEmail = new JTextField(FuncionarioController.funcionarioList.get(posicao).getEmail(), 200);
            valorCPF = new JTextField(FuncionarioController.funcionarioList.get(posicao).getCpf(), 200);
            valorSalario = new JTextField(FuncionarioController.funcionarioList.get(posicao).getSalario().toString(), 200);
            valorCargo = new JTextField(FuncionarioController.funcionarioList.get(posicao).getCargo().toString(), 200);

            labelSalario.setBounds(30, 140, 150, 25);
            valorSalario.setBounds(180, 140, 180, 25);
            labelCargo.setBounds(30, 170, 150, 25);
            valorCargo.setBounds(180, 170, 180, 25);
        } else if (opcao == 4) { //Preenche dados com dados do clientes clicado
            valorNome = new JTextField(ClienteController.clienteList.get(posicao).getNome(), 200);
            valorSenha = new JTextField(ClienteController.clienteList.get(posicao).getSenha(), 200);
            valorEmail = new JTextField(ClienteController.clienteList.get(posicao).getEmail(), 200);
            valorCPF = new JTextField(ClienteController.clienteList.get(posicao).getCpf(), 200);
            valorCidade = new JTextField(ClienteController.clienteList.get(posicao).getCidade(), 200);
            valorCategoriaHabilitacao = new JTextField(ClienteController.clienteList.get(posicao).getCategoriaHabilitacao().toString(), 200);

            labelCidade.setBounds(30, 140, 150, 25);
            valorCidade.setBounds(180, 140, 180, 25);
            labelCategoriaHabilitacao.setBounds(30, 170, 150, 25);
            valorCategoriaHabilitacao.setBounds(180, 170, 180, 25);
        } else { //Não preenche com dados

            valorNome = new JTextField(200);
            valorSenha = new JTextField(200);
            valorEmail = new JTextField(200);
            valorCPF = new JTextField(200);
            valorSalario = new JTextField(200);
            valorCargo = new JTextField(200);
            valorCidade = new JTextField(200);
            valorCategoriaHabilitacao = new JTextField(200);

            botaoSalvar.setBounds(245, 205, 115, 30);
        }

        labelNome.setBounds(30, 20, 150, 25);
        valorNome.setBounds(180, 20, 180, 25);
        labelSenha.setBounds(30, 50, 150, 25);
        valorSenha.setBounds(180, 50, 180, 25);
        labelEmail.setBounds(30, 80, 180, 25);
        valorEmail.setBounds(180, 80, 180, 25);
        labelCPF.setBounds(30, 110, 150, 25);
        valorCPF.setBounds(180, 110, 180, 25);

        //Coloca os campos relacionados a endereco se aluno
        if (opcao == 1 || opcao == 3) {
            janela.add(labelNome);
            janela.add(valorNome);
            janela.add(labelSenha);
            janela.add(valorSenha);
            janela.add(labelEmail);
            janela.add(valorEmail);
            janela.add(labelCPF);
            janela.add(valorCPF);
            janela.add(labelSalario);
            janela.add(valorSalario);
            janela.add(labelCargo);
            janela.add(valorCargo);

            labelSalario.setBounds(30, 140, 150, 25);
            valorSalario.setBounds(180, 140, 180, 25);
            labelCargo.setBounds(30, 170, 150, 25);
            valorCargo.setBounds(180, 170, 180, 25);
        }

        //Coloca campos relacionados a valor hora/aula se professor
        if (opcao == 2 || opcao == 4) {
            janela.add(labelNome);
            janela.add(valorNome);
            janela.add(labelSenha);
            janela.add(valorSenha);
            janela.add(labelEmail);
            janela.add(valorEmail);
            janela.add(labelCPF);
            janela.add(valorCPF);
            janela.add(labelCidade);
            janela.add(valorCidade);
            janela.add(labelCategoriaHabilitacao);
            janela.add(valorCategoriaHabilitacao);

            labelCidade.setBounds(30, 140, 150, 25);
            valorCidade.setBounds(180, 140, 180, 25);
            labelCategoriaHabilitacao.setBounds(30, 170, 150, 25);
            valorCategoriaHabilitacao.setBounds(180, 170, 180, 25);
        }

        //Coloca botoes de excluir e salvar
        if (opcao == 3 || opcao == 4) {
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
