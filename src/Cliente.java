import java.util.HashSet;
import java.util.Set;

public class Cliente extends Pessoa {

    private String cidade;
    private CatHabEnum categoriaHabilitacao;
    public static Set<Cliente> clienteSet = new HashSet<>(); // Set para nao permitir clientes duplicados

    public Cliente(String nome, String cpf, String email, String senha, String cidade, CatHabEnum categoriaHabilitacao) {
        super(nome, cpf, email, senha);
        this.cidade = cidade;
        this.categoriaHabilitacao = categoriaHabilitacao;
    }

    public void pagarAluguel(int id) {
        Double valor = valorTotalAluguel(id);
        System.out.println("Aluguel de R$" + valor + " foi pago pelo(a) cliente(a) " + this.getNome());
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
