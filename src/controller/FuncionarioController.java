package controller;

import model.*;

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

    public void atualizaFuncionario(String cpf, String novoNome, String novoEmail, String novaSenha, Double novoSalario, CargoEnum novoCargo) {
        for (Funcionario funcionario : funcionarioList) {
            if (cpf.equals(funcionario.getCpf())) {
                if (novoNome != null) {
                    funcionario.setNome(novoNome);
                }
                if (novoEmail != null) {
                    funcionario.setEmail(novoEmail);
                }
                if (novaSenha != null) {
                    funcionario.setSenha(novaSenha);
                }
                if (novoSalario != null) {
                    funcionario.setSalario(novoSalario);
                }
                if (novoCargo != null) {
                    funcionario.setCargo(novoCargo);
                }
                System.out.println("Os dados do funcionario " + funcionario.getNome() + " estao atualziados!");
            }
        }
    }

    public String deletarFuncionario(String cpf) {
        for (Funcionario funcionario : funcionarioList) {
            if (cpf.equals(funcionario.getCpf())) {
                funcionarioList.remove(funcionario);
                return "O funcionario " + funcionario.getNome() + " foi removido!";
            }
        }
        return "Funcionario não encontrado!";
    }
}
