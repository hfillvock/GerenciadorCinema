import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import modelos.*;

public class GerenciadorCinema {

    static Scanner scanner = new Scanner(System.in);

    private List<Filme> filmes;
    private List<Sessao> sessoes;
    private List<Ingresso> ingressos;
    private List<Cliente> clientes;

    /**
     * Constrói as listas de filmes, sessões, ingressos e clientes e recebe os conteúdos de seus arquivos respectivos caso já existam.
     */
    public GerenciadorCinema() {
        filmes = new ArrayList<>();

        if (FileManager.getArquivoFilmes().exists()) {
            filmes = FileManager.carregarFilmes(FileManager.carregarDados(FileManager.getArquivoFilmes()));
        }

        sessoes = new ArrayList<>();
        ingressos = new ArrayList<>();
        clientes = new ArrayList<>();
    }

    // Métodos para adicionar, remover, pesquisar, listar filmes, sessoes, ingressos e clientes

    public void adicionarFilme() {
        System.out.println("Insira o titulo do filme: ");
        String titulo = scanner.nextLine();

        System.out.println("Insira a classificação do filme: ");
        int classificacao = scanner.nextInt();

        System.out.println("Insira a duração do filme em minutos: ");
        int duracao = scanner.nextInt();

        Filme filmeAdicionado = new Filme(titulo, classificacao, duracao);
        filmes.add(filmeAdicionado);
    }

    public void removerFilme(int indice) {
        filmes.remove(indice);
    }

    public void pesquisarFilme() {
        
    }
    
    // getters e setters

    public List<Filme> getFilmes() {
        return filmes;
    }

    public List<Sessao> getSessoes() {
        return sessoes;
    }

    public List<Ingresso> getIngressos() {
        return ingressos;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }

    public void setSessoes(List<Sessao> sessoes) {
        this.sessoes = sessoes;
    }

    public void setIngressos(List<Ingresso> ingressos) {
        this.ingressos = ingressos;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
}
