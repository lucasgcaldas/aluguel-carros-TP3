package controller;

import model.Aluguel;
import model.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class AluguelController {

    public static List<Aluguel> aluguelList = new ArrayList<>(); // Lista de alugueis

    public int totalAlugueis(Funcionario funcionario) {
        int totalAlugueis = 0;
        for (Aluguel aluguel : AluguelController.aluguelList) {
            if (aluguel.getFuncionario().getCpf().equals(funcionario.getCpf())) {
                totalAlugueis++;
            }
        }
        return totalAlugueis;
    }

    public void cadastrarAluguel(Aluguel aluguel) {
        AluguelController.aluguelList.add(aluguel);
    }

    public Aluguel lerAluguel(int id) {
        for (Aluguel aluguel : AluguelController.aluguelList) {
            if (id == aluguel.getId()) {
                return aluguel;
            }
        }
        System.out.println("model.Carro nao encontrado!");
        return null;
    }

    public void atualizaAluguel(Aluguel aluguel, int totalDias, String localDevolucao) {
        aluguel.setTotalDias(totalDias);
        aluguel.setLocalDevolucao(localDevolucao);
    }

    public boolean deletarAluguel(Aluguel aluguel) {
        AluguelController.aluguelList.remove(aluguel);
        return true;
    }
}
