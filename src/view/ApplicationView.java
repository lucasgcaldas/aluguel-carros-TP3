package view;

import model.*;

public class ApplicationView {
    public static void main(String[] args) {

        // Carregando dados aleatorios no sistema - model.Pessoa -> model.Cliente ou model.Funcionario
        Cliente cliente1 = new Cliente("Lucas", "123.456.789-10",
                "lucas@email.com", "1234",
                "Luziania", CatHabEnum.B);

        Cliente cliente2 = new Cliente("Bianca", "745.894.365-12",
                "bianca@email.com", "1234",
                "Goiania", CatHabEnum.AB);

        Funcionario funcionario1 = new Funcionario("Joao", "145.999.466-53",
                "maria@email.com", "1234",
                800.00, CargoEnum.ESTAGIARIO);

        Funcionario funcionario2 = new Funcionario("Maria", "145.788.466-96",
                "maria@email.com", "1234",
                3500.00, CargoEnum.GERENTE);

        Funcionario funcionario3 = new Funcionario("Felipe", "707.788.466-55",
                "felipe@email.com", "1234",
                2500.00, CargoEnum.ATENDENTE);

        // Cadastrando model.Funcionario -> O proprio funcionario pode se cadastrar
        funcionario1.cadastrarFuncionario();
        funcionario2.cadastrarFuncionario();
        funcionario3.cadastrarFuncionario();

        // Cadastrando model.Cliente -> Somente o funcionario pode cadastrar clientes
        funcionario1.cadastrarCliente(cliente1);
        funcionario2.cadastrarCliente(cliente2);

        // Lendo model.Pessoa
        System.out.println(funcionario1.lerPessoa("123.456.789-10"));
        System.out.println(funcionario2.lerPessoa("745.894.365-12"));

        // Atualzizando model.Cliente
        funcionario1.atualizaCliente("123.456.789-10", "Lucas Gomes", null, null);
        funcionario2.atualizaCliente("745.894.365-12", "Bianca Roriz", null, null);

        // Atualizando model.Funcionario
        funcionario3.atualizaFuncionario("145.999.466-53", null, null, null, 1500.00, CargoEnum.SECRETARIO);

        // Deletar model.Pessoa
        System.out.println(funcionario1.deletarPessoa("123.456.789-10"));
        System.out.println(funcionario2.deletarPessoa("707.788.466-55"));
        System.out.println(funcionario2.deletarPessoa("123.888.975-00"));

        System.out.println();
        System.out.println("###############################################");
        System.out.println();
        // Carregando dados aleatorios no sistema - model.Carro
        Carro carro1 = new Carro("Fiat", "Argo", "KNI-1234", "2018", 90.00);
        Carro carro2 = new Carro("VW", "Gol", "JJK-1234", "2019", 90.00);
        Carro carro3 = new Carro("Hyunday", "HB20", "ABC-1234", "2017", 75.00);
        Carro carro4 = new Carro("Renault", "Kwid", "CCT-1234", "2020", 75.00);
        Carro carro5 = new Carro("Chevrolet", "Onix", "AAB-1234", "2020", 100.00);

        // Cadastra model.Carro
        funcionario1.cadastrarCarro(carro1);
        funcionario1.cadastrarCarro(carro2);
        funcionario1.cadastrarCarro(carro3);
        funcionario2.cadastrarCarro(carro4);
        funcionario2.cadastrarCarro(carro5);

        // Ler model.Carro
        System.out.println(funcionario1.lerCarro("CCT-1234"));
        System.out.println(funcionario1.lerCarro("AAB-1234"));
        System.out.println(funcionario2.lerCarro("JJK-1234"));

        // Atualiza model.Carro
        funcionario1.atualizaCarro("AAB-1234", 108.00);
        funcionario2.atualizaCarro("ABC-1234", 80.00);

        // Deleta model.Carro
        funcionario1.deletarCarro("KNI-1234");

        // Total de Carros existentes
        funcionario2.totalCarros();

        // Total de Carros disponiveis
        funcionario2.totalCarrosDisp();

        System.out.println();
        System.out.println("###############################################");
        System.out.println();
        // Carregando dados aleatorios no sistema - model.Aluguel
        Aluguel aluguel1 = new Aluguel(1, funcionario1, cliente1, carro1, "Asa Sul", 3, "Asa Sul");
        Aluguel aluguel2 = new Aluguel(2, funcionario2, cliente2, carro2, "Guara 2", 3, "Asa Sul");
        Aluguel aluguel3 = new Aluguel(3, funcionario1, cliente2, carro3, "Guara 1", 3, "Cruzeiro");
        Aluguel aluguel4 = new Aluguel(4, funcionario2, cliente2, carro4, "Taguatinga", 3, "Asa Norte");

        // Cadastra model.Aluguel
        funcionario1.cadastrarAluguel(aluguel1);
        funcionario2.cadastrarAluguel(aluguel2);
        funcionario1.cadastrarAluguel(aluguel3);
        funcionario2.cadastrarAluguel(aluguel4);

        // Ler model.Aluguel
        System.out.println(funcionario2.lerAluguel(2));

        // Atualiza model.Aluguel
        funcionario2.atualizaAluguel(2, 5);

        // Deleta model.Aluguel
        funcionario2.deletarAluguel(2);

        // Valor total de um determindado aluguel
        System.out.println("Valor total do aluguel 1= R$" + funcionario2.valorTotalAluguel(1));
        System.out.println("Valor total do aluguel 4 = R$" + cliente2.valorTotalAluguel(4));

        // Pagar determidado aluguel
        cliente2.pagarAluguel(1);

        // Total de Carros Alugados
        System.out.println("Total de carros alugados = " + funcionario1.totalCarrosAlugados());

        // Total de alugueis dos funcionarios
        System.out.println("Total de alugueis do funcionario 1 = " + funcionario1.totalAlugueis());
        System.out.println("Total de alugueis do funcionario 2 = " + funcionario2.totalAlugueis());
        System.out.println("Total de alugueis do funcionario 3 = " + funcionario3.totalAlugueis());
    }
}
