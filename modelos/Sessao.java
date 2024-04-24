package modelos;

import java.sql.Date;

public class Sessao {

    private Filme filme;
    private Date horario;
    private int sala;
    
    public Sessao(Filme filme, Date horario, int sala) {
        this.filme = filme;
        this.horario = horario;
        this.sala = sala;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    @Override
    public String toString() {
        return "Sessao [filme=" + filme + ", horario=" + horario + ", sala=" + sala + "]";
    }
    
}
