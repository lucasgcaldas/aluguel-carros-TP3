public abstract class Pessoa {

    private String nome;
    private String cpf;
    private String email;
    private String senha;

    public Pessoa(String nome, String cpf, String email, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
    }

    public Double valorTotalAluguel(int id) {
        for (Aluguel aluguel : Aluguel.aluguelList) {
            if (id == aluguel.getId()) {
                return aluguel.getCarro().getValorDiaria() * aluguel.getTotalDias();
            }
        }
        System.out.println("Aluguel invalido");
        return 0.0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
