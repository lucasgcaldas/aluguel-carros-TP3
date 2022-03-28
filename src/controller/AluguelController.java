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

    public void cadastrarAluguel(Aluguel aluguel, Funcionario funcionario) {
        AluguelController.aluguelList.add(aluguel);
        System.out.println("O aluguel " + aluguel.getId() + " foi cadastrado pelo(a) funcionario(a) " + funcionario.getNome());
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

    public void atualizaAluguel(int id, int totalDias, Funcionario funcionario) {
        for (Aluguel aluguel : AluguelController.aluguelList) {
            if (id == aluguel.getId()) {
                aluguel.setTotalDias(totalDias);
                System.out.println("O total de dias do aluguel " + aluguel.getId() + " esta atualziado pelo(a) funcionario(a) " + funcionario.getNome());
            }
        }
    }

    public void deletarAluguel(int id, Funcionario funcionario) {
        for (Aluguel aluguel : AluguelController.aluguelList) {
            if (id == aluguel.getId()) {
                System.out.println("O aluguel " + aluguel.getId() + " foi removido pelo(a) funcionario(a) " + funcionario.getNome());
                AluguelController.aluguelList.remove(aluguel);
                break;
            }
        }
    }
}
