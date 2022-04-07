package model;

/**
 * Classe abstrata Pessoa responsavel por ser a classe pai
 * de Funcionario e Cliente
 *
 * @author Lucas Gomes - 212005426
 */
public abstract class Pessoa {

    private String nome;
    private String cpf;
    private String email;
    private String senha;

    /**
     * Construtor padrao para instanciar pessoa
     *
     * @param nome
     * @param cpf
     * @param email
     * @param senha
     */
    public Pessoa(String nome, String cpf, String email, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
    }

    /**
     * Construtor vazio
     */
    public Pessoa() {

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
