package controller;

import model.CatHabEnum;
import model.Cliente;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe de cliente responsavel por intermediar a model com a view
 *
 * @author Lucas Gomes - 212005426
 */
public class ClienteController {

    public static List<Cliente> clienteList = new ArrayList<>(); // Lista de clientes

    private Cliente cliente;

    /**
     * Metodo responsavel por cadastrar um cliente adicionando ele a lista
     *
     * @param cliente
     */
    public void cadastrarCliente(Cliente cliente) {
        clienteList.add(cliente);
    }

    /**
     * Metodo responsavel por ler uma pessoa por meio do cpf informado
     *
     * @param cpf
     * @return Cliente lido
     */
    public Cliente lerPessoa(String cpf) {
        for (Cliente cliente : clienteList) {
            if (cpf.equals(cliente.getCpf())) {
                return cliente;
            }
        }
        System.out.println("Cliente não encontrado!");
        return null;
    }

    /**
     * Metodo responsavel por atualizar um cliente informado com um novo nome e/ou um
     * novo email e/ou nova senha e/ou nova categoria de habilitacao
     *
     * @param cliente
     * @param novoNome
     * @param novoEmail
     * @param novaSenha
     * @param catHabEnum
     */
    public void atualizaCliente(Cliente cliente, String novoNome, String novoEmail, String novaSenha, CatHabEnum catHabEnum) {
        cliente.setNome(novoNome);
        cliente.setEmail(novoEmail);
        cliente.setSenha(novaSenha);
        cliente.setCategoriaHabilitacao(catHabEnum);
    }

    /**
     * Metodo responsavel por deletar um cliente, removendo ele da lista
     *
     * @param cliente
     * @return true, caso seja deletado com sucesso
     */
    public boolean deletarCliente(Cliente cliente) {
        clienteList.remove(cliente);
        return true;
    }
}
