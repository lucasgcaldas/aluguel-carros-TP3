package controller;

import jdk.jfr.Description;
import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarroControllerTest {

    private CarroController carroController = new CarroController();

    @BeforeEach
    @Description("Carrega dados pre definidos no sistema antes de cada funcao testada")
    public void start() {
        Carro carro1 = new Carro("Fiat", "Argo", "KNI-1234", "2018", 90.00);
        Carro carro2 = new Carro("VW", "Gol", "JJK-1234", "2019", 90.00);
        Carro carro3 = new Carro("Hyunday", "HB20", "ABC-1234", "2017", 75.00);

        carroController.cadastrarCarro(carro1);
        carroController.cadastrarCarro(carro2);
        carroController.cadastrarCarro(carro3);

        Cliente cliente1 = new Cliente("Lucas", "123.456.789-10",
                "lucas@email.com", "1234",
                "Luziania", CatHabEnum.B);

        Cliente cliente2 = new Cliente("Bianca", "745.894.365-12",
                "bianca@email.com", "1234",
                "Goiania", CatHabEnum.AB);

        Funcionario funcionario1 = new Funcionario("Joao", "145.999.466-53", "maria@email.com", "1234", 800.00, CargoEnum.ESTAGIARIO);

        Funcionario funcionario2 = new Funcionario("Maria", "145.788.466-96", "maria@email.com", "1234", 3500.00, CargoEnum.GERENTE);

        Aluguel aluguel1 = new Aluguel(1, funcionario1, cliente1, carro1, "Asa Sul", 3, "Asa Sul");
        Aluguel aluguel2 = new Aluguel(2, funcionario2, cliente2, carro2, "Guara 2", 3, "Asa Sul");

        AluguelController aluguelController = new AluguelController();
        aluguelController.cadastrarAluguel(aluguel1);
        aluguelController.cadastrarAluguel(aluguel2);
    }

    @Test
    @Description("Testa se a funcao realmente cadastra um carro, retornando um elemento a mais na lista")
    void cadastrarCarro() {
        Carro carro4 = new Carro("Volvo", "XC-60", "CCC-1234", "2019", 350.00);
        carroController.cadastrarCarro(carro4);
        assertEquals(4, CarroController.carroList.size());
    }

    @Test
    @Description("Testa se a funcao retorna o total de carros cadastrados no sistema")
    void totalCarros() {
        assertEquals(3, carroController.totalCarros());
    }

    @Test
    @Description("Testa se a funcao retorna o total de carros que foram alugados no sistema")
    void totalCarrosAlugados() {
        Aluguel aluguel3 = new Aluguel();
        AluguelController aluguelController = new AluguelController();
        aluguelController.cadastrarAluguel(aluguel3);
        assertEquals(3, carroController.totalCarrosAlugados());
    }

    @Test
    @Description("Testa se a funcao retorna o total de carros que estao disponiveis para serem alugados")
    void totalCarrosDisp() {
        assertEquals(1, carroController.totalCarrosDisp());
    }
}