public class Application {
    public static void main(String[] args) {

        // Carregando dados aleatorios no sistema - Pessoa -> Cliente ou Funcionario
        Cliente c1 = new Cliente("Lucas", "123.456.789-10",
                "lucas@email.com", "1234",
                "Luziania", CatHabEnum.B);

        Cliente c2 = new Cliente("Bianca", "745.894.365-12",
                "bianca@email.com", "1234",
                "Goiania", CatHabEnum.AB);

        Funcionario f1 = new Funcionario("Joao", "145.999.466-53",
                "maria@email.com", "1234",
                800.00, CargoEnum.ESTAGIARIO);

        Funcionario f2 = new Funcionario("Maria", "145.788.466-96",
                "maria@email.com", "1234",
                3500.00, CargoEnum.GERENTE);

        // Cadastrando Pessoa
        c1.cadastrarPessoa();
        c2.cadastrarPessoa();
        f1.cadastrarPessoa();
        f2.cadastrarPessoa();

        // Lendo Pessoa
        System.out.println(f1.lerPessoa("123.456.789-10"));
        System.out.println(f2.lerPessoa("745.894.365-12"));

        // Atualziar Pessoa
        f1.atualizaPessoa("123.456.789-10", "Lucas Gomes", null, null);
        f2.atualizaPessoa("745.894.365-12", "Bianca Roriz", null, null);

        // Deletar Pessoa
        f1.deletarPessoa("123.456.789-10");

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
        Aluguel aluguel1 = new Aluguel(1, f1, c1, carro1, "Asa Sul", 3, "Asa Sul");
        Aluguel aluguel2 = new Aluguel(2, f2, c2, carro2, "Guara 2", 3, "Asa Sul");

        // Cadastra Aluguel
        aluguel1.cadastrarAluguel();
        aluguel2.cadastrarAluguel();

        // Ler Aluguel
        System.out.println(aluguel1.lerAluguel(2));

        // Atualiza Aluguel
        aluguel1.atualizaAluguel(2, 5);

        // Deleta Aluguel
        aluguel1.deletarAluguel(2);

        // Valor total de um determindado aluguel
        System.out.println(aluguel1.valorTotal(1));

        // Pagar determidado aluguel
        aluguel1.pagarAluguel(1);

        System.out.println();
        // Total de Carros Alugados
        System.out.println("Total de carros alugados = " + carro3.totalCarrosAlugados());

        // Total de Carros disponiveis
        carro3.totalCarrosDisp();
    }
}
