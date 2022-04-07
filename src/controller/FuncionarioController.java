package controller;

import model.CargoEnum;
import model.Funcionario;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe de funcionario responsavel por intermediar a model com a view
 *
 * @author Lucas Gomes - 212005426
 */
public class FuncionarioController {

    public static List<Funcionario> funcionarioList = new ArrayList<>(); // Lista de funcionarios

    private Funcionario funcionario;

    /**
     * Metodo responsavel por cadastrar um funcionario adicionando ele a lista
     *
     * @param funcionario
     */
    public void cadastrarFuncionario(Funcionario funcionario) {
        funcionarioList.add(funcionario);
    }

    /**
     * Metodo responsavel por ler uma pessoa por meio do cpf informado
     *
     * @param cpf
     * @return Funcionario lido
     */
    public Funcionario lerFuncionario(String cpf) {
        for (Funcionario funcionario : funcionarioList) {
            if (cpf.equals(funcionario.getCpf())) {
                return funcionario;
            }
        }

        System.out.println("Funcionario não encontrado!");
        return null;
    }

    /**
     * Metodo responsavel por atualizar um cliente informado com um novo nome e/ou um
     * novo email e/ou nova senha e/ou novo salario e/ou novo cargo
     *
     * @param funcionario
     * @param novoNome
     * @param novoEmail
     * @param novaSenha
     * @param novoSalario
     * @param novoCargo
     * @return true, caso seja deletado com sucesso
     */
    public boolean atualizaFuncionario(Funcionario funcionario, String novoNome, String novoEmail, String novaSenha, Double novoSalario, CargoEnum novoCargo) {
        funcionario.setNome(novoNome);
        funcionario.setEmail(novoEmail);
        funcionario.setSenha(novaSenha);
        funcionario.setSalario(novoSalario);
        funcionario.setCargo(novoCargo);
        return true;
    }

    /**
     * Metodo responsavel por deletar um funcionario, removendo ele da lista
     *
     * @param funcionario
     * @return true, caso seja deletado com sucesso
     */
    public boolean deletarFuncionario(Funcionario funcionario) {
        funcionarioList.remove(funcionario);
        return true;
    }
}
