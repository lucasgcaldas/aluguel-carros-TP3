public class Cliente extends Pessoa{

    private String cidade;
    private CatHabEnum categoriaHabilitacao;

    public Cliente(String nome, String cpf, String email, String senha, String cidade, CatHabEnum categoriaHabilitacao) {
        super(nome, cpf, email, senha);
        this.cidade = cidade;
        this.categoriaHabilitacao = categoriaHabilitacao;
    }
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public CatHabEnum getCategoriaHabilitacao() {
        return categoriaHabilitacao;
    }

    public void setCategoriaHabilitacao(CatHabEnum categoriaHabilitacao) {
        this.categoriaHabilitacao = categoriaHabilitacao;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome=" + this.getNome() +
                ", cpf=" + this.getCpf() +
                ", email=" + this.getEmail() +
                ", cidade='" + cidade + '\'' +
                ", categoriaHabilitacao=" + categoriaHabilitacao +
                '}';
    }
}
