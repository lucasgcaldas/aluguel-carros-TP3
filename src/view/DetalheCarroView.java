package view;

import controller.CarroController;
import model.Carro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe responsavel por detalhar a view referente ao carro
 *
 * @author Lucas Gomes - 212005426
 */
public class DetalheCarroView implements ActionListener {

    private JFrame janela;
    private JLabel labelMarca = new JLabel("Marca: ");
    private JTextField valorMarca;
    private JLabel valorMarcaLabel;
    private JLabel labelModel = new JLabel("Modelo: ");
    private JTextField valorModel;
    private JLabel valorModelLabel;
    private JLabel labelAnoFab = new JLabel("Ano Fabricacao: ");
    private JTextField valorAnoFab;
    private JLabel valorAnoFabLabel;
    private JLabel labelPlaca = new JLabel("Placa: ");
    private JTextField valorPlaca;
    private JLabel labelValDia = new JLabel("Valor Diaria: ");
    private JTextField valorValDia;

    private JButton botaoExcluir = new JButton("Excluir");
    private JButton botaoSalvar = new JButton("Salvar");

    private String seleciona;
    private int opcao = 0;
    private int posicao = 0;

    private CarroController carroController = new CarroController();

    /**
     * Metodo responsavel por selecionar a opcao desejada do usuario
     * (1) Cadastrar carro
     * (2) Detalhar carro
     *
     * @param opcao
     * @param posicao
     */
    public void inserirEditar(int opcao, int posicao) {

        this.opcao = opcao;
        this.posicao = posicao;

        if (opcao == 1) seleciona = "Cadastro de Carro";
        if (opcao == 2) seleciona = "Detalhe de Carro";

        janela = new JFrame(seleciona);

        //Preenche dados com dados do Carro clicado
        if (opcao == 1) {
            valorMarca = new JTextField(200);
            valorModel = new JTextField(200);
            valorPlaca = new JTextField(200);
            valorAnoFab = new JTextField(200);
            valorValDia = new JTextField(200);

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

            botaoSalvar.setBounds(245, 205, 115, 30);

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

            janela.add(botaoSalvar);

        } else if (opcao == 2) { //Não preenche com dados para criar Carro

            valorMarcaLabel = new JLabel(CarroController.carroList.get(posicao).getMarca());
            valorModelLabel = new JLabel(CarroController.carroList.get(posicao).getModelo());
            valorPlaca = new JTextField(CarroController.carroList.get(posicao).getPlaca(), 200);
            valorAnoFabLabel = new JLabel(CarroController.carroList.get(posicao).getAnoFabricacao());
            valorValDia = new JTextField(CarroController.carroList.get(posicao).getValorDiaria().toString(), 200);

            labelMarca.setBounds(30, 20, 150, 25);
            valorMarcaLabel.setBounds(180, 20, 180, 25);
            labelPlaca.setBounds(30, 50, 150, 25);
            valorPlaca.setBounds(180, 50, 180, 25);
            labelAnoFab.setBounds(30, 80, 180, 25);
            valorAnoFabLabel.setBounds(180, 80, 180, 25);
            labelModel.setBounds(30, 110, 150, 25);
            valorModelLabel.setBounds(180, 110, 180, 25);
            labelValDia.setBounds(30, 140, 150, 25);
            valorValDia.setBounds(180, 140, 180, 25);

            botaoSalvar.setBounds(120, 210, 115, 30);
            botaoExcluir.setBounds(245, 210, 115, 30);

            janela.add(labelMarca);
            janela.add(valorMarcaLabel);
            janela.add(labelPlaca);
            janela.add(valorPlaca);
            janela.add(labelAnoFab);
            janela.add(valorAnoFabLabel);
            janela.add(labelModel);
            janela.add(valorModelLabel);
            janela.add(labelValDia);
            janela.add(valorValDia);

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
        Object src = e.getSource();
        if (src == botaoSalvar) {
            try {
                if (opcao == 1) {
                    Carro carro = new Carro();
                    carro.setModelo(valorModel.getText());
                    carro.setMarca(valorMarca.getText());
                    carro.setPlaca(valorPlaca.getText());
                    carro.setAnoFabricacao(valorAnoFab.getText());
                    carro.setValorDiaria(Double.valueOf(valorValDia.getText()));
                    carroController.cadastrarCarro(carro);
                    mensagemSucessoCadastro();
                } else {

                    carroController.atualizaCarro(CarroController.carroList.get(posicao), valorPlaca.getText(), Double.valueOf(valorValDia.getText()));
                    mensagemSucessoCadastro();
                }
            } catch (NullPointerException | NumberFormatException exc1) {
                mensagemErroCadastro();
            }
        }

        if (src == botaoExcluir) {
            boolean res;
            res = carroController.deletarCarro(CarroController.carroList.get(posicao));
            if (res) {
                mensagemSucessoExclusao();
            } else {
                mensagemErroExclusaoCarro();
            }
        }
    }

    /**
     * Metodo responsavel por criar uma janela com mensagem de sucesso
     * ao excluir os dados
     */
    public void mensagemSucessoExclusao() {
        JOptionPane.showMessageDialog(null, "Os dados foram excluidos com sucesso!", null,
                JOptionPane.INFORMATION_MESSAGE);
        janela.dispose();
    }

    /**
     * Metodo responsavel por criar uma janela com mensagem de sucesso
     * ao cadastrar os dados
     */
    public void mensagemSucessoCadastro() {
        JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso!", null,
                JOptionPane.INFORMATION_MESSAGE);
        janela.dispose();
    }

    /**
     * Metodo responsavel por criar uma janela com mensagem de erro
     * ao salvar os dados
     */
    public void mensagemErroCadastro() {
        JOptionPane.showMessageDialog(null, "ERRO AO SALVAR OS DADOS!\n "
                        + "Pode ter ocorrido um dos dois erros a seguir:  \n"
                        + "1. Nem todos os campos foram preenchidos \n"
                        + "2. String onde deve ser numero \n"
                        + "3. Numero onde deve ser string \n", null,
                JOptionPane.ERROR_MESSAGE);
        janela.dispose();
    }

    /**
     * Metodo responsavel por criar uma janela com mensagem de erro
     * ao selecionar um carro invalido
     */
    public void mensagemErroExclusaoCarro() {
        JOptionPane.showMessageDialog(null, "Ocorreu um erro ao excluir o dado.\n "
                        + "Verifique se o carro está cadastrado\n", null,
                JOptionPane.ERROR_MESSAGE);
        janela.dispose();
    }
}
