package controller;

import model.CargoEnum;
import model.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioController {

    public static List<Funcionario> funcionarioList = new ArrayList<>(); // Lista de funcionarios

    private Funcionario funcionario;

    public void cadastrarFuncionario(Funcionario funcionario) {
        funcionarioList.add(funcionario);
    }

    public Funcionario lerFuncionario(String cpf) {
        for (Funcionario funcionario : funcionarioList) {
            if (cpf.equals(funcionario.getCpf())) {
                return funcionario;
            }
        }

        System.out.println("Funcionario não encontrado!");
        return null;
    }

    public boolean atualizaFuncionario(Funcionario funcionario, String novoNome, String novoEmail, String novaSenha, Double novoSalario, CargoEnum novoCargo) {
        funcionario.setNome(novoNome);
        funcionario.setEmail(novoEmail);
        funcionario.setSenha(novaSenha);
        funcionario.setSalario(novoSalario);
        funcionario.setCargo(novoCargo);
        return true;
    }

    public boolean deletarFuncionario(Funcionario funcionario) {
        funcionarioList.remove(funcionario);
        return true;
    }
}
