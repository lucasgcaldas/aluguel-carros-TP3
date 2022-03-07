public class Application {
    public static void main(String[] args) {

        // Carregando dados aleatorios no sistema - Pessoa -> Cliente ou Funcionario
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

        // Cadastrando Funcionario -> O proprio funcionario pode se cadastrar
        funcionario1.cadastrarFuncionario();
        funcionario2.cadastrarFuncionario();
        funcionario3.cadastrarFuncionario();

        // Cadastrando Cliente -> Somente o funcionario pode cadastrar clientes
        funcionario1.cadastrarCliente(cliente1);
        funcionario2.cadastrarCliente(cliente2);

        // Lendo Pessoa
        System.out.println(funcionario1.lerPessoa("123.456.789-10"));
        System.out.println(funcionario2.lerPessoa("745.894.365-12"));

        // Atualzizando Cliente
        funcionario1.atualizaCliente("123.456.789-10", "Lucas Gomes", null, null);
        funcionario2.atualizaCliente("745.894.365-12", "Bianca Roriz", null, null);

        // Atualizando Funcionario
        funcionario3.atualizaFuncionario("145.999.466-53", null, null, null, 1500.00, CargoEnum.SECRETARIO);

        // Deletar Pessoa
        System.out.println(funcionario1.deletarPessoa("123.456.789-10"));
        System.out.println(funcionario2.deletarPessoa("707.788.466-55"));
        System.out.println(funcionario2.deletarPessoa("123.888.975-00"));

        System.out.println();
        // Carregando dados aleatorios no sistema - Carro
        Carro carro1 = new Carro("Fiat", "Argo", "KNI-1234", "2018", 90.00);
        Carro carro2 = new Carro("VW", "Gol", "JJK-1234", "2019", 90.00);
        Carro carro3 = new Carro("Hyunday", "HB20", "ABC-1234", "2017", 75.00);
        Carro carro4 = new Carro("Renault", "Kwid", "CCT-1234", "2020", 75.00);
        Carro carro5 = new Carro("Chevrolet", "Onix", "AAB-1234", "2020", 100.00);

        // Cadastra Carro
        carro1.cadastrarCarro();
        carro2.cadastrarCarro();
        carro3.cadastrarCarro();
        carro4.cadastrarCarro();
        carro5.cadastrarCarro();

        // Ler Carro
        System.out.println(carro1.lerCarro("CCT-1234"));
        System.out.println(carro1.lerCarro("AAB-1234"));
        System.out.println(carro1.lerCarro("JJK-1234"));

        // Atualiza Carro
        carro1.atualizaCarro("AAB-1234", 108.00);
        carro1.atualizaCarro("ABC-1234", 80.00);

        // Deleta Carro
        carro1.deletarCarro("KNI-1234");

        // Total de Carros existentes
        carro2.totalCarros();

        System.out.println();
        // Carregando dados aleatorios no sistema - Aluguel
        Aluguel aluguel1 = new Aluguel(1, funcionario1, cliente1, carro1, "Asa Sul", 3, "Asa Sul");
        Aluguel aluguel2 = new Aluguel(2, funcionario2, cliente2, carro2, "Guara 2", 3, "Asa Sul");

        // Cadastra Aluguel
        funcionario1.cadastrarAluguel(aluguel1);
        funcionario2.cadastrarAluguel(aluguel2);

        // Ler Aluguel
        System.out.println(funcionario2.lerAluguel(2));

        // Atualiza Aluguel
        funcionario2.atualizaAluguel(2, 5);

        // Deleta Aluguel
        funcionario2.deletarAluguel(2);

        // Valor total de um determindado aluguel
        System.out.println(funcionario2.valorTotalAluguel(1));
        System.out.println(cliente2.valorTotalAluguel(2));

        // Pagar determidado aluguel
        cliente2.pagarAluguel(1);

        System.out.println();
        // Total de Carros Alugados
        System.out.println("Total de carros alugados = " + carro3.totalCarrosAlugados());

        // Total de Carros disponiveis
        carro3.totalCarrosDisp();

        System.out.println();
        // Total de alugueis dos funcionarios
        System.out.println("Total de alugueis do funcionario 1 = " + funcionario1.totalAlugueis());
        System.out.println("Total de alugueis do funcionario 2 = " + funcionario2.totalAlugueis());
        System.out.println("Total de alugueis do funcionario 3 = " + funcionario3.totalAlugueis());
    }
}
