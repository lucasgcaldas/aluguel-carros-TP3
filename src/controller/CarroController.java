package controller;

import model.Carro;
import model.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class CarroController {

    public static List<Carro> carroList = new ArrayList<>(); // Lista de Carros

    public void cadastrarCarro(Carro carro, Funcionario funcionario) {
        carroList.add(carro);
        System.out.println("O carro " + carro.getModelo() + " foi cadastrado pelo(a) funcionario(a) " + funcionario.getNome());
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

    public void atualizaCarro(String placa, Double valorDiaria, Funcionario funcionario) {
        for (Carro carro : carroList) {
            if (placa.equals(carro.getPlaca())) {
                carro.setValorDiaria(valorDiaria);
                System.out.println("O valor da diariaria do carro " + carro.getModelo() + " esta atualziado pelo(a) funcionario(a) " + funcionario.getNome());
            }
        }
    }

    public void deletarCarro(String placa, Funcionario funcionario) {
        for (Carro carro : carroList) {
            if (placa.equals(carro.getPlaca())) {
                System.out.println("O carro " + carro.getModelo() + " foi removido pelo(a) funcionario(a) " + funcionario.getNome());
                carroList.remove(carro);
                break;
            }
        }
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
