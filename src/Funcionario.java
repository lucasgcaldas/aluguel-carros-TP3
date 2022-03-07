import java.util.HashSet;
import java.util.Set;

public class Funcionario extends Pessoa {

    private Double salario;
    private CargoEnum cargo;
    public static Set<Funcionario> funcionarioSet = new HashSet<>(); // Set para nao permitir funcionarios duplicados

    public Funcionario(String nome, String cpf, String email, String senha, Double salario, CargoEnum cargo) {
        super(nome, cpf, email, senha);
        this.salario = salario;
        this.cargo = cargo;
    }

    public void cadastrarFuncionario() {
        funcionarioSet.add(this);
        System.out.println("O funcionario " + this.getNome() + " foi cadastrado!");
    }

    public void cadastrarCliente(Cliente cliente) {
        Cliente.clienteSet.add(cliente);
        System.out.println("O cliente " + this.getNome() + " foi cadastrado!");
    }

    public Pessoa lerPessoa(String cpf) {
        boolean ehCliente = true;

        while (ehCliente) {
            for (Funcionario funcionario : funcionarioSet) {
                if (cpf.equals(funcionario.getCpf())) {
                    return funcionario;
                } else {
                    ehCliente = false;
                }
            }
        }

        for (Cliente cliente : Cliente.clienteSet) {
            if (cpf.equals(cliente.getCpf())) {
                return cliente;
            }
        }
        System.out.println("Pessoa não encontrada!");
        return null;
    }

    public void atualizaFuncionario(String cpf, String novoNome, String novoEmail, String novaSenha, Double novoSalario, CargoEnum novoCargo) {
        for (Funcionario funcionario : funcionarioSet) {
            if (cpf.equals(funcionario.getCpf())) {
                if (novoNome != null) {
                    funcionario.setNome(novoNome);
                }
                if (novoEmail != null) {
                    funcionario.setEmail(novoEmail);
                }
                if (novaSenha != null) {
                    funcionario.setSenha(novaSenha);
                }
                if (novoSalario != null) {
                    funcionario.setSalario(novoSalario);
                }
                if (novoCargo != null) {
                    funcionario.setCargo(novoCargo);
                }
                System.out.println("Os dados do funcionario " + funcionario.getNome() + " estao atualziados!");
            }
        }
    }

    public void atualizaCliente(String cpf, String novoNome, String novoEmail, String novaSenha) {
        for (Cliente cliente : Cliente.clienteSet) {
            if (cpf.equals(cliente.getCpf())) {
                if (novoNome != null) {
                    cliente.setNome(novoNome);
                }
                if (novoEmail != null) {
                    cliente.setEmail(novoEmail);
                }
                if (novaSenha != null) {
                    cliente.setSenha(novaSenha);
                }
                System.out.println("Os dados do cliente " + cliente.getNome() + " estao atualziados!");
            }
        }
    }

    public String deletarPessoa(String cpf) {
        boolean ehCliente = true;

        while (ehCliente) {
            for (Funcionario funcionario : funcionarioSet) {
                if (cpf.equals(funcionario.getCpf())) {
                    funcionarioSet.remove(funcionario);
                    return "O funcionario " + funcionario.getNome() + " foi removido!";
                } else {
                    ehCliente = false;
                }
            }
        }

        for (Cliente cliente : Cliente.clienteSet) {
            if (cpf.equals(cliente.getCpf())) {
                Cliente.clienteSet.remove(cliente);
                return "O cliente " + cliente.getNome() + " foi removido!";
            }
        }

        return "Pessoa não encontrada!";
    }

    public void cadastrarCarro(Carro carro) {
        Carro.carroSet.add(carro);
        System.out.println("O carro " + carro.getModelo() + " foi cadastrado pelo(a) funcionario(a) " + this.getNome());
    }

    public Carro lerCarro(String placa) {
        for (Carro carro : Carro.carroSet) {
            if (placa.equals(carro.getPlaca())) {
                return carro;
            }
        }
        System.out.println("Carro nao encontrado!");
        return null;
    }

    public void atualizaCarro(String placa, Double valorDiaria) {
        for (Carro carro : Carro.carroSet) {
            if (placa.equals(carro.getPlaca())) {
                carro.setValorDiaria(valorDiaria);
                System.out.println("O valor da diariaria do carro " + carro.getModelo() + " esta atualziado pelo(a) funcionario(a) " + this.getNome());
            }
        }
    }

    public void deletarCarro(String placa) {
        for (Carro carro : Carro.carroSet) {
            if (placa.equals(carro.getPlaca())) {
                System.out.println("O carro " + carro.getModelo() + " foi removido pelo(a) funcionario(a) " + this.getNome());
                Carro.carroSet.remove(carro);
                break;
            }
        }
    }

    public int totalCarros() {
        return Carro.carroSet.size();
    }

    public int totalCarrosAlugados() {
        return Aluguel.aluguelList.size();
    }

    public void totalCarrosDisp() {
        int totalCarrosAlugados = totalCarrosAlugados();
        System.out.println("O total de carros disponiveis = " + (totalCarros() - totalCarrosAlugados));
    }

    public int totalAlugueis() {
        int totalAlugueis = 0;
        for (Aluguel aluguel : Aluguel.aluguelList) {
            if (aluguel.getFuncionario().getCpf().equals(this.getCpf())) {
                totalAlugueis++;
            }
        }
        return totalAlugueis;
    }

    public void cadastrarAluguel(Aluguel aluguel) {
        Aluguel.aluguelList.add(aluguel);
        System.out.println("O aluguel " + aluguel.getId() + " foi cadastrado pelo(a) funcionario(a) " + this.getNome());
    }

    public Aluguel lerAluguel(int id) {
        for (Aluguel aluguel : Aluguel.aluguelList) {
            if (id == aluguel.getId()) {
                return aluguel;
            }
        }
        System.out.println("Carro nao encontrado!");
        return null;
    }

    public void atualizaAluguel(int id, int totalDias) {
        for (Aluguel aluguel : Aluguel.aluguelList) {
            if (id == aluguel.getId()) {
                aluguel.setTotalDias(totalDias);
                System.out.println("O total de dias do aluguel " + aluguel.getId() + " esta atualziado pelo(a) funcionario(a) " + this.getNome());
            }
        }
    }

    public void deletarAluguel(int id) {
        for (Aluguel aluguel : Aluguel.aluguelList) {
            if (id == aluguel.getId()) {
                System.out.println("O aluguel " + aluguel.getId() + " foi removido pelo(a) funcionario(a) " + this.getNome());
                Aluguel.aluguelList.remove(aluguel);
                break;
            }
        }
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
        return "Funcionario{" +
                "nome=" + this.getNome() +
                ", cpf=" + this.getCpf() +
                ", email=" + this.getEmail() +
                ", salario=" + salario +
                ", cargo=" + cargo +
                '}';
    }
}
