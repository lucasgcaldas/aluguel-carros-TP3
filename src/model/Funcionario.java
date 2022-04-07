package model;

/**
 * Classe Funcionario responsavel por instanciar um funcionario
 *
 * @author Lucas Gomes - 212005426
 */
public class Funcionario extends Pessoa {

    private Double salario;
    private CargoEnum cargo;

    /**
     * Construtor padrao para instanciar funcionario
     *
     * @param nome
     * @param cpf
     * @param email
     * @param senha
     * @param salario
     * @param cargo
     */
    public Funcionario(String nome, String cpf, String email, String senha, Double salario, CargoEnum cargo) {
        super(nome, cpf, email, senha);
        this.salario = salario;
        this.cargo = cargo;
    }

    /**
     * Construtor vazio
     */
    public Funcionario() {
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public CargoEnum getCargo() {
        return cargo;
    }

    public void setCargo(CargoEnum cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "model.Funcionario{" +
                "nome=" + this.getNome() +
                ", cpf=" + this.getCpf() +
                ", email=" + this.getEmail() +
                ", salario=" + salario +
                ", cargo=" + cargo +
                '}';
    }
}
