package controller;

import model.Cliente;
import model.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class ClienteController {

    public static List<Cliente> clienteList = new ArrayList<>(); // Lista de clientes

    private Cliente cliente;

    public void cadastrarCliente() {
        clienteList.add(cliente);
        System.out.println("O cliente " + cliente.getNome() + " foi cadastrado!");
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

    public void atualizaCliente(String cpf, String novoNome, String novoEmail, String novaSenha) {
        for (Cliente cliente : clienteList) {
            if (cpf.equals(cliente.getCpf())) {
                if (novoNome != null) {
                    cliente.setNome(novoNome);
                }
                if (novoEmail != null) {
                    cliente.setEmail(novoEmail);
                }
                if (novaSenha != null) {
                    cliente.setSenha(novaSenha);
                }
                System.out.println("Os dados do cliente " + cliente.getNome() + " estao atualziados!");
            }
        }
    }

    public String deletarCliente(String cpf) {
        for (Cliente cliente : clienteList) {
            if (cpf.equals(cliente.getCpf())) {
                clienteList.remove(cliente);
                return "O cliente " + cliente.getNome() + " foi removido!";
            }
        }

        return "Cliente não encontrado!";
    }

    public void pagarAluguel(int id) {
        Double valor = cliente.valorTotalAluguel(id);
        System.out.println("model.Aluguel de R$" + valor + " foi pago pelo(a) cliente(a) " + cliente.getNome());
    }
}
