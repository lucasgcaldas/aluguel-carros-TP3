package controller;

import model.CatHabEnum;
import model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteController {

    public static List<Cliente> clienteList = new ArrayList<>(); // Lista de clientes

    private Cliente cliente;

    public void cadastrarCliente(Cliente cliente) {
        clienteList.add(cliente);
    }

    public Cliente lerPessoa(String cpf) {
        for (Cliente cliente : clienteList) {
            if (cpf.equals(cliente.getCpf())) {
                return cliente;
            }
        }
        System.out.println("Cliente não encontrado!");
        return null;
    }

    public void atualizaCliente(Cliente cliente, String novoNome, String novoEmail, String novaSenha, CatHabEnum catHabEnum) {
        cliente.setNome(novoNome);
        cliente.setEmail(novoEmail);
        cliente.setSenha(novaSenha);
        cliente.setCategoriaHabilitacao(catHabEnum);
    }

    public boolean deletarCliente(Cliente cliente) {
        clienteList.remove(cliente);
        return true;
    }
}
