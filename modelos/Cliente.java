package modelos;

import java.io.Serializable;

public class Cliente implements Serializable{
    
    private String nome;
    private String email;
    private Integer idade;

    public Cliente(String nome, String email, Integer idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdade() {
        return idade;
    }
    
    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Cliente [nome=" + nome + ", email=" + email + ", idade=" + idade + "]";
    }

}
