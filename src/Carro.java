import java.util.HashSet;
import java.util.Set;

public class Carro {

    private String marca;
    private String modelo;
    private String anoFabricacao;
    private String placa;
    private Double valorDiaria;
    public static Set<Carro> carroSet = new HashSet<>(); // Set para nao permitir carros duplicados

    public Carro(String marca, String modelo, String placa, String anoFabricacao, Double valorDiaria) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.anoFabricacao = anoFabricacao;
        this.valorDiaria = valorDiaria;
    }

    public void cadastrarCarro() {
        carroSet.add(this);
        System.out.println("O carro " + this.getModelo() + " foi cadastrado!");
    }

    public void lerCarro(String placa) {
        for (Carro carro : carroSet) {
            if (placa.equals(carro.getPlaca())) {
                return;
            }
        }
        System.out.println("Carro nao encontrado!");
    }

    public void atualizaCarro(String placa, Double valorDiaria) {
        for (Carro carro : carroSet) {
            if (placa.equals(carro.getPlaca())) {
                carro.setValorDiaria(valorDiaria);
                System.out.println("O valor da diariaria do carro " + carro.getModelo() + " esta atualziado!");
            }
        }
    }

    public void deletarCarro(String placa) {
        for (Carro carro : carroSet) {
            if (placa.equals(carro.getPlaca())) {
                System.out.println("O carro " + carro.getModelo() + " foi removido!");
                carroSet.remove(carro);
                break;
            }
        }
    }

    public void totalCarros() {
        System.out.println("O total de carros existentes e: " + carroSet.size());
    }

    public void totalCarrosAlugados() {
        System.out.println("O total de carros alugados e: " + carroSet.size());
    }

    public void totalCarrosDisp() {
        System.out.println("O total de carros alugados e: " + carroSet.size());
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(String anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(Double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }
}
