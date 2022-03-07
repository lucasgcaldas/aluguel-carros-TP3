import java.util.ArrayList;
import java.util.List;

public class Aluguel {

    private int id;
    private Funcionario funcionario;
    private Cliente cliente;
    private Carro carro;
    private String localRetirada;
    private int totalDias;
    private String localDevolucao;
    public static List<Aluguel> aluguelList = new ArrayList<>(); // Lista de alugueis

    public Aluguel(int id, Funcionario funcionario, Cliente cliente, Carro carro, String localRetirada, int totalDias, String localDevolucao) {
        this.id = id;
        this.funcionario = funcionario;
        this.cliente = cliente;
        this.carro = carro;
        this.localRetirada = localRetirada;
        this.totalDias = totalDias;
        this.localDevolucao = localDevolucao;
    }

    public void cadastrarAluguel() {
        aluguelList.add(this);
        System.out.println("O aluguel " + this.getId() + " foi cadastrado!");
    }

    public Aluguel lerAluguel(int id) {
        for (Aluguel aluguel : aluguelList) {
            if (id == aluguel.getId()) {
                return aluguel;
            }
        }
        System.out.println("Carro nao encontrado!");
        return null;
    }

    public void atualizaAluguel(int id, int totalDias) {
        for (Aluguel aluguel : aluguelList) {
            if (id == aluguel.getId()) {
                aluguel.setTotalDias(totalDias);
                System.out.println("O total de dias do aluguel " + aluguel.getId() + " esta atualziado!");
            }
        }
    }

    public void deletarAluguel(int id) {
        for (Aluguel aluguel : aluguelList) {
            if (id == aluguel.getId()) {
                System.out.println("O aluguel " + aluguel.getId() + " foi removido!");
                aluguelList.remove(aluguel);
                break;
            }
        }
    }

    public Double valorTotal(int id) {
        for (Aluguel aluguel : aluguelList) {
            if (id == aluguel.getId()) {
                return aluguel.getCarro().getValorDiaria() * aluguel.getTotalDias();
            }
        }
        System.out.println("Aluguel invalido");
        return 0.0;
    }

    public void pagarAluguel(int id) {
        Double valor = valorTotal(id);
        System.out.println("Aluguel de R$" + valor + " foi pago");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public String getLocalRetirada() {
        return localRetirada;
    }

    public void setLocalRetirada(String localRetirada) {
        this.localRetirada = localRetirada;
    }

    public int getTotalDias() {
        return totalDias;
    }

    public void setTotalDias(int totalDias) {
        this.totalDias = totalDias;
    }

    public String getLocalDevolucao() {
        return localDevolucao;
    }

    public void setLocalDevolucao(String localDevolucao) {
        this.localDevolucao = localDevolucao;
    }

    @Override
    public String toString() {
        return "Aluguel{" +
                "id=" + id +
                ", funcionario=" + funcionario.getNome() +
                ", cliente=" + cliente.getNome() +
                ", carro=" + carro.getModelo() +
                ", localRetirada='" + localRetirada + '\'' +
                ", totalDias=" + totalDias +
                ", localDevolucao='" + localDevolucao + '\'' +
                '}';
    }
}
