package modelos;

import java.time.LocalDate;

public class Sessao {

    private Filme filme;
    private LocalDate data;
    private int sala;
    
    public Sessao(Filme filme, LocalDate data, int sala) {
        this.filme = filme;
        this.data = data;
        this.sala = sala;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    @Override
    public String toString() {
        return "Sessao [filme=" + filme + ", data=" + data + ", sala=" + sala + "]";
    }
    
}
