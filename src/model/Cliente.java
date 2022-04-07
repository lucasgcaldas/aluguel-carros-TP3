package model;

/**
 * Classe Cliente responsavel por instanciar um cliente
 *
 * @author Lucas Gomes - 212005426
 */
public class Cliente extends Pessoa {

    private String cidade;
    private CatHabEnum categoriaHabilitacao;

    /**
     * Construtor padrao para instanciar cliente
     *
     * @param nome
     * @param cpf
     * @param email
     * @param senha
     * @param cidade
     * @param categoriaHabilitacao
     */
    public Cliente(String nome, String cpf, String email, String senha, String cidade, CatHabEnum categoriaHabilitacao) {
        super(nome, cpf, email, senha);
        this.cidade = cidade;
        this.categoriaHabilitacao = categoriaHabilitacao;
    }

    /**
     * Construtor vazio
     */
    public Cliente() {

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
        return "model.Cliente{" +
                "nome=" + this.getNome() +
                ", cpf=" + this.getCpf() +
                ", email=" + this.getEmail() +
                ", cidade='" + cidade + '\'' +
                ", categoriaHabilitacao=" + categoriaHabilitacao +
                '}';
    }
}
