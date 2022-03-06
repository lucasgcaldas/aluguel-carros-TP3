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
    }
}
