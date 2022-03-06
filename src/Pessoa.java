import java.util.*;

public abstract class Pessoa {

    private String nome;
    private String cpf;
    private String email;
    private String senha;
    public static Set<Pessoa> pessoaSet = new HashSet<>(); // Set para nao permitir usuarios duplicados

    public Pessoa(String nome, String cpf, String email, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
    }

    public void cadastrarPessoa() {
        pessoaSet.add(this);
        System.out.println("A pessoa " + this.getNome() + " foi cadastrada!");
    }

    public Pessoa lerPessoa(String cpf){
        for (Pessoa pessoa : pessoaSet){
            if (cpf.equals(pessoa.getCpf())){
                return pessoa;
            }
        }
        System.out.println("Pessoa não encontrada!");
        return null;
    }

    public void atualizaPessoa(String cpf, String novoNome, String novoEmail, String novaSenha){
        for (Pessoa pessoa : pessoaSet){
            if (cpf.equals(pessoa.getCpf())){
                if (novoNome != null){
                    pessoa.setNome(novoNome);
                } if (novoEmail != null){
                    pessoa.setEmail(novoEmail);
                } if (novaSenha != null){
                    pessoa.setSenha(novaSenha);
                }
                System.out.println("A pessoa " + pessoa.getNome() + " esta atualziada!");
            }
        }
    }

    public void deletarPessoa(String cpf){
        for (Pessoa pessoa : pessoaSet){
            if (cpf.equals(pessoa.getCpf())){
               System.out.println("A pessoa " + pessoa.getNome() + " foi removida!");
               pessoaSet.remove(pessoa);
               break;
            }
        }
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
