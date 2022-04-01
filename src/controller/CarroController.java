package controller;

import model.Carro;
import model.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class CarroController {

    public static List<Carro> carroList = new ArrayList<>(); // Lista de Carros

    public void cadastrarCarro(Carro carro) {
        carroList.add(carro);
    }

    public Carro lerCarro(String placa) {
        for (Carro carro : carroList) {
            if (placa.equals(carro.getPlaca())) {
                return carro;
            }
        }
        System.out.println("model.Carro nao encontrado!");
        return null;
    }

    public void atualizaCarro(Carro carro, String placa, Double valorDiaria) {
        carro.setPlaca(placa);
        carro.setValorDiaria(valorDiaria);
    }

    public boolean deletarCarro(Carro carro) {
        carroList.remove(carro);
        return true;
    }

    public int totalCarros() {
        return carroList.size();
    }

    public int totalCarrosAlugados() {
        return AluguelController.aluguelList.size();
    }

    public void totalCarrosDisp() {
        int totalCarrosAlugados = totalCarrosAlugados();
        System.out.println("O total de carros disponiveis = " + (totalCarros() - totalCarrosAlugados));
    }
}
