package controller;

import model.Aluguel;
import model.Cliente;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe de aluguel responsavel por intermediar a model com a view
 *
 * @author Lucas Gomes - 212005426
 */
public class AluguelController {

    public static List<Aluguel> aluguelList = new ArrayList<>(); // Lista de alugueis

    /**
     * Metodo responsavel por retornar o total de alugueis
     *
     * @return int com tamanho do aluguelList
     */
    public int totalAlugueis() {
        return aluguelList.size();
    }

    /**
     * Metodo responsavel por cadastrar um aluguel adicionando o aluguel a lista
     *
     * @param aluguel
     */
    public void cadastrarAluguel(Aluguel aluguel) {
        AluguelController.aluguelList.add(aluguel);
    }

    /**
     * Metodo responsavel por ler um aluguel por meio de um id informado
     *
     * @param id
     * @return Aluguel lido
     */
    public Aluguel lerAluguel(int id) {
        for (Aluguel aluguel : AluguelController.aluguelList) {
            if (id == aluguel.getId()) {
                return aluguel;
            }
        }
        System.out.println("model.Carro nao encontrado!");
        return null;
    }

    /**
     * Metodo responsavel por atualizar um aluguel informado com um novo prazo de dias e/ou um
     * novo local de devolucao do veiculo
     *
     * @param aluguel
     * @param totalDias
     * @param localDevolucao
     */
    public void atualizaAluguel(Aluguel aluguel, int totalDias, String localDevolucao) {
        aluguel.setTotalDias(totalDias);
        aluguel.setLocalDevolucao(localDevolucao);
    }

    /**
     * Metodo responsavel por deletar um aluguel, removendo ele da lista
     *
     * @param aluguel
     * @return true, caso seja deletado com sucesso
     */
    public boolean deletarAluguel(Aluguel aluguel) {
        AluguelController.aluguelList.remove(aluguel);
        return true;
    }

    /**
     * Metodo reponsavel por calcaular o valor total do aluguel
     *
     * @param aluguel
     * @return Double com o valor total do aluguel
     */
    public Double valorTotalAluguel(Aluguel aluguel) {
        return aluguel.getCarro().getValorDiaria() * aluguel.getTotalDias();
    }

    /**
     * Metodo responsavel por pagar um aluguel
     *
     * @param cliente
     * @param aluguel
     * @return String com o cliente e o valor total pago
     */
    public String pagarAluguel(Cliente cliente, Aluguel aluguel) {
        double valorAluguel = valorTotalAluguel(aluguel);

        return "O cliente " + cliente.getNome() + " pagou um total de R$ " + valorAluguel;
    }
}
