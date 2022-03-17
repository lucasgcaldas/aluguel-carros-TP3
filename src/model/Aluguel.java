package model;

public class Aluguel {

    private int id;
    private Funcionario funcionario;
    private Cliente cliente;
    private Carro carro;
    private String localRetirada;
    private int totalDias;
    private String localDevolucao;

    public Aluguel(int id, Funcionario funcionario, Cliente cliente, Carro carro, String localRetirada, int totalDias, String localDevolucao) {
        this.id = id;
        this.funcionario = funcionario;
        this.cliente = cliente;
        this.carro = carro;
        this.localRetirada = localRetirada;
        this.totalDias = totalDias;
        this.localDevolucao = localDevolucao;
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
        return "model.Aluguel{" +
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
