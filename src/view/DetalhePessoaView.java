package view;

import controller.ClienteController;
import controller.FuncionarioController;
import model.CargoEnum;
import model.CatHabEnum;
import model.Cliente;
import model.Funcionario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class DetalhePessoaView implements ActionListener {

    private JFrame janela;
    private JLabel labelNome = new JLabel("Nome: ");
    private JTextField valorNome;
    private JLabel labelCPF = new JLabel("CPF: ");
    private JLabel valorCPFLabel;
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
    private JComboBox cargoBox;
    private JComboBox catBox;

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

    private FuncionarioController funcionarioController = new FuncionarioController();
    private ClienteController clienteController = new ClienteController();

    private String[] comboCargo = {CargoEnum.ATENDENTE.name(), CargoEnum.ESTAGIARIO.name(),
            CargoEnum.GERENTE.name(), CargoEnum.RECEPCIONISTA.name(), CargoEnum.SECRETARIO.name()};
    private String[] comboHab = {CatHabEnum.A.name(), CatHabEnum.B.name(), CatHabEnum.C.name(),
            CatHabEnum.AB.name(), CatHabEnum.AC.name()};

    private String boxName;

    public void inserirEditar(int opcao, int posicao) {

        this.opcao = opcao;
        this.posicao = posicao;

        if (opcao == 1) seleciona = "Cadastro de Funcionario";
        if (opcao == 2) seleciona = "Cadastro de Cliente";
        if (opcao == 3) seleciona = "Detalhe de Funcionario";
        if (opcao == 4) seleciona = "Detalhe de Cliente";

        janela = new JFrame(seleciona);

        if (opcao == 1) { //Coloca os campos relacionados ao funcionario

            cargoBox = new JComboBox<>(comboCargo);
            cargoBox.setSelectedItem(1);
            cargoBox.addActionListener(e -> {
                JComboBox cb = (JComboBox) e.getSource();
                boxName = (String) cb.getSelectedItem();
                System.out.println(boxName);
            });

            valorNome = new JTextField(200);
            valorSenha = new JTextField(200);
            valorEmail = new JTextField(200);
            valorCPF = new JTextField(200);
            valorSalario = new JTextField(200);

            labelNome.setBounds(30, 20, 150, 25);
            valorNome.setBounds(180, 20, 180, 25);
            labelSenha.setBounds(30, 50, 150, 25);
            valorSenha.setBounds(180, 50, 180, 25);
            labelEmail.setBounds(30, 80, 180, 25);
            valorEmail.setBounds(180, 80, 180, 25);
            labelCPF.setBounds(30, 110, 150, 25);
            valorCPF.setBounds(180, 110, 180, 25);
            labelSalario.setBounds(30, 140, 150, 25);
            valorSalario.setBounds(180, 140, 180, 25);
            labelCargo.setBounds(30, 170, 150, 25);
            cargoBox.setBounds(180, 170, 180, 25);

            botaoSalvar.setBounds(245, 205, 115, 30);

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
            janela.add(cargoBox);
            janela.add(botaoSalvar);

        } else if (opcao == 2) { //Coloca os campos relacionados ao cliente

            catBox = new JComboBox<>(comboHab);
            catBox.setSelectedItem(1);
            catBox.addActionListener(e -> {
                JComboBox cb = (JComboBox) e.getSource();
                boxName = (String) cb.getSelectedItem();
                System.out.println(boxName);
            });

            valorNome = new JTextField(200);
            valorSenha = new JTextField(200);
            valorEmail = new JTextField(200);
            valorCPF = new JTextField(200);
            valorCidade = new JTextField(200);

            labelNome.setBounds(30, 20, 150, 25);
            valorNome.setBounds(180, 20, 180, 25);
            labelSenha.setBounds(30, 50, 150, 25);
            valorSenha.setBounds(180, 50, 180, 25);
            labelEmail.setBounds(30, 80, 180, 25);
            valorEmail.setBounds(180, 80, 180, 25);
            labelCPF.setBounds(30, 110, 150, 25);
            valorCPF.setBounds(180, 110, 180, 25);
            labelCidade.setBounds(30, 140, 150, 25);
            valorCidade.setBounds(180, 140, 180, 25);
            labelCategoriaHabilitacao.setBounds(30, 170, 150, 25);
            catBox.setBounds(180, 170, 180, 25);

            botaoSalvar.setBounds(245, 205, 115, 30);

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
            janela.add(catBox);
            janela.add(botaoSalvar);

        } else if (opcao == 3) { //Preenche dados com dados do funcionario clicado
            valorNome = new JTextField(FuncionarioController.funcionarioList.get(posicao).getNome(), 200);
            valorSenha = new JTextField(FuncionarioController.funcionarioList.get(posicao).getSenha(), 200);
            valorEmail = new JTextField(FuncionarioController.funcionarioList.get(posicao).getEmail(), 200);
            valorCPFLabel = new JLabel(FuncionarioController.funcionarioList.get(posicao).getCpf());
            valorSalario = new JTextField(FuncionarioController.funcionarioList.get(posicao).getSalario().toString(), 200);

            cargoBox = new JComboBox<>(comboCargo);
            cargoBox.setSelectedItem(FuncionarioController.funcionarioList.get(posicao).getCargo().toString());

            labelNome.setBounds(30, 20, 150, 25);
            valorNome.setBounds(180, 20, 180, 25);
            labelSenha.setBounds(30, 50, 150, 25);
            valorSenha.setBounds(180, 50, 180, 25);
            labelEmail.setBounds(30, 80, 180, 25);
            valorEmail.setBounds(180, 80, 180, 25);
            labelCPF.setBounds(30, 110, 150, 25);
            valorCPFLabel.setBounds(180, 110, 180, 25);
            labelSalario.setBounds(30, 140, 150, 25);
            valorSalario.setBounds(180, 140, 180, 25);
            labelCargo.setBounds(30, 170, 150, 25);
            cargoBox.setBounds(180, 170, 180, 25);

            janela.add(labelNome);
            janela.add(valorNome);
            janela.add(labelSenha);
            janela.add(valorSenha);
            janela.add(labelEmail);
            janela.add(valorEmail);
            janela.add(labelCPF);
            janela.add(valorCPFLabel);
            janela.add(labelSalario);
            janela.add(valorSalario);
            janela.add(labelCargo);
            janela.add(cargoBox);

            botaoSalvar.setBounds(120, 210, 115, 30);
            botaoExcluir.setBounds(245, 210, 115, 30);
            janela.add(botaoSalvar);
            janela.add(botaoExcluir);

        } else if (opcao == 4) { //Preenche dados com dados do clientes clicado
            valorNome = new JTextField(ClienteController.clienteList.get(posicao).getNome(), 200);
            valorSenha = new JTextField(ClienteController.clienteList.get(posicao).getSenha(), 200);
            valorEmail = new JTextField(ClienteController.clienteList.get(posicao).getEmail(), 200);
            valorCPFLabel = new JLabel(ClienteController.clienteList.get(posicao).getCpf());
            valorCidade = new JTextField(ClienteController.clienteList.get(posicao).getCidade(), 200);

            catBox = new JComboBox<>(comboHab);
            catBox.setSelectedItem(ClienteController.clienteList.get(posicao).getCategoriaHabilitacao().toString());

            labelNome.setBounds(30, 20, 150, 25);
            valorNome.setBounds(180, 20, 180, 25);
            labelSenha.setBounds(30, 50, 150, 25);
            valorSenha.setBounds(180, 50, 180, 25);
            labelEmail.setBounds(30, 80, 180, 25);
            valorEmail.setBounds(180, 80, 180, 25);
            labelCPF.setBounds(30, 110, 150, 25);
            valorCPFLabel.setBounds(180, 110, 180, 25);
            labelCidade.setBounds(30, 140, 150, 25);
            valorCidade.setBounds(180, 140, 180, 25);
            labelCategoriaHabilitacao.setBounds(30, 170, 150, 25);
            catBox.setBounds(180, 170, 180, 25);

            janela.add(labelNome);
            janela.add(valorNome);
            janela.add(labelSenha);
            janela.add(valorSenha);
            janela.add(labelEmail);
            janela.add(valorEmail);
            janela.add(labelCPF);
            janela.add(valorCPFLabel);
            janela.add(labelCidade);
            janela.add(valorCidade);
            janela.add(labelCategoriaHabilitacao);
            janela.add(catBox);

            botaoSalvar.setBounds(120, 210, 115, 30);
            botaoExcluir.setBounds(245, 210, 115, 30);
            janela.add(botaoSalvar);
            janela.add(botaoExcluir);
        }

        janela.setLayout(null);

        janela.setSize(400, 290);
        janela.setVisible(true);

        botaoSalvar.addActionListener(this);
        botaoExcluir.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton src = (JButton) e.getSource();

        if (src == botaoSalvar) {
            try {
                if (opcao == 1) { // cadastro de Funcionario

                    Funcionario funcionario = new Funcionario();

                    funcionario.setNome(valorNome.getText());
                    funcionario.setCpf(valorCPF.getText());
                    funcionario.setEmail(valorEmail.getText());
                    funcionario.setSenha(valorSenha.getText());
                    funcionario.setSalario(Double.valueOf(valorSalario.getText()));
                    funcionario.setCargo(CargoEnum.valueOf(boxName));

                    funcionarioController.cadastrarFuncionario(funcionario);
                    mensagemSucessoCadastro();
                } else if (opcao == 2) { // cadastro de Cliente

                    Cliente cliente = new Cliente();

                    cliente.setNome(valorNome.getText());
                    cliente.setCpf(valorCPF.getText());
                    cliente.setEmail(valorEmail.getText());
                    cliente.setSenha(valorSenha.getText());
                    cliente.setCidade(valorCidade.getText());
                    cliente.setCategoriaHabilitacao(CatHabEnum.valueOf(boxName));

                    clienteController.cadastrarCliente(cliente);
                    mensagemSucessoCadastro();
                } else if (opcao == 3) { // Edicao de dado existente Funcionario

                    funcionarioController.atualizaFuncionario(FuncionarioController.funcionarioList.get(posicao), valorNome.getText(), valorEmail.getText(), valorSenha.getText(), Double.valueOf(valorSalario.getText()), CargoEnum.valueOf(Objects.requireNonNull(cargoBox.getSelectedItem()).toString()));
                    mensagemSucessoCadastro();
                } else if (opcao == 4) { // Edicao de dado existente Cliente

                    clienteController.atualizaCliente(ClienteController.clienteList.get(posicao), valorNome.getText(), valorEmail.getText(), valorSenha.getText(), CatHabEnum.valueOf(Objects.requireNonNull(catBox.getSelectedItem()).toString()));
                    mensagemSucessoCadastro();
                }
            } catch (NullPointerException | NumberFormatException exc1) {
                mensagemErroCadastro();
            }
        }

        if (src == botaoExcluir) {
            if (opcao == 3) { // exclui funcionario
                boolean res;
                res = funcionarioController.deletarFuncionario(FuncionarioController.funcionarioList.get(posicao));
                if (res) {
                    mensagemSucessoExclusao();
                } else {
                    mensagemErroExclusaoPessoa();
                }
            }

            if (opcao == 4) { // exclui cliente
                boolean res;
                res = clienteController.deletarCliente(ClienteController.clienteList.get(posicao));
                if (res) {
                    mensagemSucessoExclusao();
                } else {
                    mensagemErroExclusaoPessoa();
                }
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

    public void mensagemErroExclusaoPessoa() {
        JOptionPane.showMessageDialog(null, "Ocorreu um erro ao excluir o dado.\n "
                        + "Verifique se a pessoa esta cadastrada\n", null,
                JOptionPane.ERROR_MESSAGE);
    }
}
