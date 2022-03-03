public class Funcionario extends Pessoa{

    private Double salario;
    private CargoEnum cargo;

    public Funcionario(String nome, String cpf, String email, String senha, Double salario, CargoEnum cargo) {
        super(nome, cpf, email, senha);
        this.salario = salario;
        this.cargo = cargo;
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
}
