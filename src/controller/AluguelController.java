package controller;

import model.Aluguel;

import java.util.ArrayList;
import java.util.List;

public class AluguelController {

    public static List<Aluguel> aluguelList = new ArrayList<>(); // Lista de alugueis

    public int totalAlugueis() {
        return aluguelList.size();
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

    public Double valorTotalAluguel(Aluguel aluguel) {
        return aluguel.getCarro().getValorDiaria() * aluguel.getTotalDias();
    }
}
