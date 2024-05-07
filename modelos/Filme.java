package modelos;

import java.io.Serializable;

public class Filme implements Serializable{
    
    private String titulo;
    private Integer classificacao;
    private int duracao;
    
    public Filme(String titulo, Integer classificacao, int duracao) {
        this.titulo = titulo;
        this.classificacao = classificacao;
        this.duracao = duracao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Integer classificacao) {
        this.classificacao = classificacao;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    @Override
    public String toString() {
        return "Filme [titulo=" + titulo + ", classificacao=" + classificacao + ", duracao=" + duracao + "]";
    }

}
