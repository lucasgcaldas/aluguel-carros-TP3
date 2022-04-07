package controller;

import jdk.jfr.Description;
import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AluguelControllerTest {

    private AluguelController aluguelController = new AluguelController();
    private Aluguel aluguel1 = new Aluguel();
    private Cliente cliente1 = new Cliente();

    @BeforeEach
    @Description("Carrega dados pre definidos no sistema antes de cada funcao testada")
    public void start() {
        Carro carro1 = new Carro("Fiat", "Argo", "KNI-1234", "2018", 90.00);

        CarroController carroController = new CarroController();
        carroController.cadastrarCarro(carro1);

        cliente1 = new Cliente("Lucas", "123.456.789-10",
                "lucas@email.com", "1234",
                "Luziania", CatHabEnum.B);

        Funcionario funcionario1 = new Funcionario("Joao", "145.999.466-53", "maria@email.com", "1234", 800.00, CargoEnum.ESTAGIARIO);

        aluguel1 = new Aluguel(1, funcionario1, cliente1, carro1, "Asa Sul", 3, "Asa Sul");

        aluguelController.cadastrarAluguel(aluguel1);
    }

    @Test
    @Description("Testa se a funcao retorna o valor total do aluguel")
    void valorTotalAluguel() {
        assertEquals(270, aluguelController.valorTotalAluguel(aluguel1));
    }

    @Test
    @Description("Testa se a funcao retorna uma string com o nome do cliente e o valor total do aluguel")
    void pagarAluguel() {
        String s = "O cliente " + cliente1.getNome() + " pagou um total de R$ " + aluguelController.valorTotalAluguel(aluguel1);
        assertEquals(s, aluguelController.pagarAluguel(cliente1, aluguel1));
    }
}