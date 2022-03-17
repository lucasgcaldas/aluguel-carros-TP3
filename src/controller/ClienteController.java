package controller;

import model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteController {

    public static List<Cliente> clienteList = new ArrayList<>(); // Lista de clientes

    private Cliente cliente;

    public void pagarAluguel(int id) {
        Double valor = cliente.valorTotalAluguel(id);
        System.out.println("model.Aluguel de R$" + valor + " foi pago pelo(a) cliente(a) " + cliente.getNome());
    }
}
