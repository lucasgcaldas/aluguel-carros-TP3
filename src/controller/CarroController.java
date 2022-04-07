package controller;

import model.Carro;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe de carro responsavel por intermediar a model com a view
 *
 * @author Lucas Gomes - 212005426
 */
public class CarroController {

    public static List<Carro> carroList = new ArrayList<>(); // Lista de Carros

    /**
     * Metodo responsavel por cadastrar um carro adicionando o carro a lista
     *
     * @param carro
     */
    public void cadastrarCarro(Carro carro) {
        carroList.add(carro);
    }

    /**
     * Metodo responsavel por ler um carro por meio da placa informada
     *
     * @param placa
     * @return Carro lido
     */
    public Carro lerCarro(String placa) {
        for (Carro carro : carroList) {
            if (placa.equals(carro.getPlaca())) {
                return carro;
            }
        }
        System.out.println("model.Carro nao encontrado!");
        return null;
    }

    /**
     * Metodo responsavel por atualizar um carro informado com uma nova placa e/ou um
     * novo valor da diaria
     *
     * @param carro
     * @param placa
     * @param valorDiaria
     */
    public void atualizaCarro(Carro carro, String placa, Double valorDiaria) {
        carro.setPlaca(placa);
        carro.setValorDiaria(valorDiaria);
    }

    /**
     * Metodo responsavel por deletar um carro, removendo ele da lista
     *
     * @param carro
     * @return true, caso seja deletado com sucesso
     */
    public boolean deletarCarro(Carro carro) {
        carroList.remove(carro);
        return true;
    }

    /**
     * Metodo responsavel por retornar o total de carros
     *
     * @return int com o total de carros da lista
     */
    public int totalCarros() {
        return carroList.size();
    }

    /**
     * Metodo responsavel por retornar o total de carros alugados
     *
     * @return int com o total de carros alugados
     */
    public int totalCarrosAlugados() {
        return AluguelController.aluguelList.size();
    }

    /**
     * Metodo responsavel por retornar o total de carros disponivies para aluguel
     *
     * @return int com o total de carros disponiveis
     */
    public int totalCarrosDisp() {
        return (totalCarros() - totalCarrosAlugados());
    }
}
