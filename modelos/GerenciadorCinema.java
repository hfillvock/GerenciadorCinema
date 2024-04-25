package modelos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        System.out.println("Insira o título do filme: ");
        String titulo = scanner.nextLine();
        System.out.println();

        System.out.println("Insira a classificação do filme: ");
        int classificacao = scanner.nextInt();
        scanner.nextLine();
        System.out.println();

        System.out.println("Insira a duração do filme em minutos: ");
        int duracao = scanner.nextInt();
        scanner.nextLine();
        System.out.println();

        Filme filmeAdicionado = new Filme(titulo, classificacao, duracao);
        filmes.add(filmeAdicionado);
    }

    public void removerFilme() {
        System.out.println("Insira o índice do filme: ");
        int indice = scanner.nextInt();
        scanner.nextLine();
        System.out.println();

        filmes.remove(indice);
    }

    /**
     * Pesquisa incidência do filme por meio do título.
     * @return -1 caso não exista um filme com o mesmo título; índice do filme caso exista.
     */
    public int pesquisarFilme() {
        System.out.println("Insira o título do filme: ");
        String titulo = scanner.nextLine();
        System.out.println();

        int indice = 0;

        for (Filme filme : filmes) {
            if (filme.getTitulo().equals(titulo)) {
                System.out.println("Filme encontrado: \n" + indice + ": " + filme.toString());
                System.out.println();
                return indice;
            }

            indice++;
        }

        System.out.println("Filme não encontrado.");
        System.out.println();
        return -1;
    }
    
    public void listarFilmes() {
        int indice = 0;

        for (Filme filme : filmes) {
            System.out.println(indice + ": " + filme);

            indice++;
        }

        System.out.println();
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
