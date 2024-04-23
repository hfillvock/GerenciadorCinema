import java.util.ArrayList;
import java.util.List;
import modelos.*;

public class GerenciadorCinema {

    private List<Filme> filmes;
    private List<Sessao> sessoes;
    private List<Ingresso> ingressos;
    private List<Cliente> clientes;

    public GerenciadorCinema() {
        filmes = new ArrayList<>();
        sessoes = new ArrayList<>();
        ingressos = new ArrayList<>();
        clientes = new ArrayList<>();
    }

    // Métodos para adicionar, remover, pesquisar, listar filmes, sessoes, ingressos e clientes

    public void adicionarFilme(Filme filmeAdicionado) {
        filmes.add(filmeAdicionado);
    }

    public void removerFilme(int indice) {
        filmes.remove(indice);
    }

    public void pesquisarFilme() {
        
    }
}
