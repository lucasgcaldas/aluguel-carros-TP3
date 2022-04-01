package controller;

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

    public void atualizaCliente(Cliente cliente, String novoNome, String novoEmail, String novaSenha) {
        cliente.setNome(novoNome);
        cliente.setEmail(novoEmail);
        cliente.setSenha(novaSenha);
    }

    public boolean deletarCliente(Cliente cliente) {
        clienteList.remove(cliente);
        return true;
    }

    public void pagarAluguel(int id) {
        Double valor = cliente.valorTotalAluguel(id);
        System.out.println("model.Aluguel de R$" + valor + " foi pago pelo(a) cliente(a) " + cliente.getNome());
    }
}
