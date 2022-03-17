package controller;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioController {

    public static List<Funcionario> funcionarioList = new ArrayList<>(); // Lista de funcionarios

    private Funcionario funcionario;

    public void cadastrarFuncionario() {
        funcionarioList.add(funcionario);
        System.out.println("O funcionario " + funcionario.getNome() + " foi cadastrado!");
    }

    public void cadastrarCliente(Cliente cliente) {
        ClienteController.clienteList.add(cliente);
        System.out.println("O cliente " + funcionario.getNome() + " foi cadastrado!");
    }

    public Pessoa lerPessoa(String cpf) {
        boolean ehCliente = true;

        while (ehCliente) {
            for (Funcionario funcionario : funcionarioList) {
                if (cpf.equals(funcionario.getCpf())) {
                    return funcionario;
                } else {
                    ehCliente = false;
                }
            }
        }

        for (Cliente cliente : ClienteController.clienteList) {
            if (cpf.equals(cliente.getCpf())) {
                return cliente;
            }
        }
        System.out.println("model.Pessoa não encontrada!");
        return null;
    }

    public void atualizaFuncionario(String cpf, String novoNome, String novoEmail, String novaSenha, Double novoSalario, CargoEnum novoCargo) {
        for (Funcionario funcionario : funcionarioList) {
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
        for (Cliente cliente : ClienteController.clienteList) {
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
            for (Funcionario funcionario : funcionarioList) {
                if (cpf.equals(funcionario.getCpf())) {
                    funcionarioList.remove(funcionario);
                    return "O funcionario " + funcionario.getNome() + " foi removido!";
                } else {
                    ehCliente = false;
                }
            }
        }

        for (Cliente cliente : ClienteController.clienteList) {
            if (cpf.equals(cliente.getCpf())) {
                ClienteController.clienteList.remove(cliente);
                return "O cliente " + cliente.getNome() + " foi removido!";
            }
        }

        return "model.Pessoa não encontrada!";
    }

    public void cadastrarCarro(Carro carro) {
        CarroController.carroList.add(carro);
        System.out.println("O carro " + carro.getModelo() + " foi cadastrado pelo(a) funcionario(a) " + funcionario.getNome());
    }

    public Carro lerCarro(String placa) {
        for (Carro carro : CarroController.carroList) {
            if (placa.equals(carro.getPlaca())) {
                return carro;
            }
        }
        System.out.println("model.Carro nao encontrado!");
        return null;
    }

    public void atualizaCarro(String placa, Double valorDiaria) {
        for (Carro carro : CarroController.carroList) {
            if (placa.equals(carro.getPlaca())) {
                carro.setValorDiaria(valorDiaria);
                System.out.println("O valor da diariaria do carro " + carro.getModelo() + " esta atualziado pelo(a) funcionario(a) " + funcionario.getNome());
            }
        }
    }

    public void deletarCarro(String placa) {
        for (Carro carro : CarroController.carroList) {
            if (placa.equals(carro.getPlaca())) {
                System.out.println("O carro " + carro.getModelo() + " foi removido pelo(a) funcionario(a) " + funcionario.getNome());
                CarroController.carroList.remove(carro);
                break;
            }
        }
    }

    public int totalCarros() {
        return CarroController.carroList.size();
    }

    public int totalCarrosAlugados() {
        return AluguelController.aluguelList.size();
    }

    public void totalCarrosDisp() {
        int totalCarrosAlugados = totalCarrosAlugados();
        System.out.println("O total de carros disponiveis = " + (totalCarros() - totalCarrosAlugados));
    }

    public int totalAlugueis() {
        int totalAlugueis = 0;
        for (Aluguel aluguel : AluguelController.aluguelList) {
            if (aluguel.getFuncionario().getCpf().equals(funcionario.getCpf())) {
                totalAlugueis++;
            }
        }
        return totalAlugueis;
    }

    public void cadastrarAluguel(Aluguel aluguel) {
        AluguelController.aluguelList.add(aluguel);
        System.out.println("O aluguel " + aluguel.getId() + " foi cadastrado pelo(a) funcionario(a) " + funcionario.getNome());
    }

    public Aluguel lerAluguel(int id) {
        for (Aluguel aluguel : AluguelController.aluguelList) {
            if (id == aluguel.getId()) {
                return aluguel;
            }
        }
        System.out.println("model.Carro nao encontrado!");
        return null;
    }

    public void atualizaAluguel(int id, int totalDias) {
        for (Aluguel aluguel : AluguelController.aluguelList) {
            if (id == aluguel.getId()) {
                aluguel.setTotalDias(totalDias);
                System.out.println("O total de dias do aluguel " + aluguel.getId() + " esta atualziado pelo(a) funcionario(a) " + funcionario.getNome());
            }
        }
    }

    public void deletarAluguel(int id) {
        for (Aluguel aluguel : AluguelController.aluguelList) {
            if (id == aluguel.getId()) {
                System.out.println("O aluguel " + aluguel.getId() + " foi removido pelo(a) funcionario(a) " + funcionario.getNome());
                AluguelController.aluguelList.remove(aluguel);
                break;
            }
        }
    }
}
