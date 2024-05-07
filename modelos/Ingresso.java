package modelos;

import java.io.Serializable;

public class Ingresso implements Serializable{

    private Sessao sessao;
    private int numeroAssento;
    private double preco;
    private static double vendas;
    
    public Ingresso(Sessao sessao, int numeroAssento, double preco) {
        this.sessao = sessao;
        this.numeroAssento = numeroAssento;
        this.preco = preco;
    }

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    public int getNumeroAssento() {
        return numeroAssento;
    }

    public void setNumeroAssento(int numeroAssento) {
        this.numeroAssento = numeroAssento;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public static double getVendas() {
        return vendas;
    }

    public static void setVendas(double vendas) {
        Ingresso.vendas = vendas;
    }

    @Override
    public String toString() {
        return "Ingresso [sessao=" + sessao + ", numeroAssento=" + numeroAssento + ", preco=" + preco + "]";
    }
  
}
