package modelos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorCinema {

    static Scanner scanner = new Scanner(System.in);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");  

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

        if (FileManager.getArquivoSessoes().exists()) {
            sessoes = FileManager.carregarSessoes(FileManager.carregarDados(FileManager.getArquivoSessoes()), this);
        }

        ingressos = new ArrayList<>();
        
        clientes = new ArrayList<>();

        if (FileManager.getArquivoClientes().exists()) {
            clientes = FileManager.carregarClientes(FileManager.carregarDados(FileManager.getArquivoClientes()));
        }
    }

    // Métodos para adicionar, remover, pesquisar, listar filmes, sessoes, ingressos e clientes

    // métodos de Filme

    public void adicionarFilme() {
        System.out.println();
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

        System.out.println("Filme adicionado.");
        System.out.println();
    }

    public void removerFilme() {
        System.out.println();
        System.out.println("Pesquise o título do filme: ");
        int indice = pesquisarFilme(null);
        
        if (indice == -1) {
            System.out.println("Cancelando remoção do filme.");
            System.out.println();
            return;
        }

        Filme filmeRemovido = filmes.get(indice);

        try {
            filmes.remove(indice);    
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();        
        }

        System.out.println(filmeRemovido + " removido.");
        System.out.println();
    }

    /**
     * Pesquisa incidência do filme por meio do título.
     * @return -1 caso não exista um filme com o mesmo título; índice do filme caso exista.
     */
    public int pesquisarFilme(String tituloPesquisado) {
        if (tituloPesquisado == null) {
            System.out.println();
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

        int indice = 0;

        for (Filme filme : filmes) {
            if (filme.getTitulo().equals(tituloPesquisado)) {
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
        System.out.println();
        int indice = 0;

        for (Filme filme : filmes) {
            System.out.println(indice + ": " + filme);

            indice++;
        }

        System.out.println();
    }

    // métodos de Cliente

    public void adicionarCliente() {
        System.out.println();
        System.out.println("Insira o nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.println();

        System.out.println("Insira o email do cliente: ");
        String email = scanner.nextLine();
        System.out.println();

        System.out.println("Insira a idade do cliente: ");
        int idade = scanner.nextInt();
        scanner.nextLine();
        System.out.println();

        Cliente clienteAdicionado = new Cliente(nome, email, idade);
        clientes.add(clienteAdicionado);

        System.out.println("Cliente adicionado.");
        System.out.println();
    }


    public void removerCliente() {
        System.out.println();
        System.out.println("Pesquise o nome do cliente: ");
        int indice = pesquisarCliente();

        if (indice == -1) {
            System.out.println("Cancelando remoção do cliente.");
            System.out.println();
            return;
        }

        Cliente clienteRemovido = clientes.get(indice);

        try {
            clientes.remove(indice);    
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();        
        }

        System.out.println(clienteRemovido + " removido.");
        System.out.println();
    }

    /**
     * Pesquisa incidência do cliente por meio do nome.
     * @return -1 caso não exista um cliente com o mesmo nome; índice do cliente caso exista.
     */
    public int pesquisarCliente() {
        System.out.println();
        System.out.println("Insira o nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.println();

        int indice = 0;

        for (Cliente cliente : clientes) {
            if (cliente.getNome().equals(nome)) {
                System.out.println("Cliente encontrado: \n" + indice + ": " + cliente.toString());
                System.out.println();
                return indice;
            }

            indice++;
        }

        System.out.println("Cliente não encontrado.");
        System.out.println();
        return -1;
    }
    
    public void listarClientes() {
        System.out.println();
        int indice = 0;

        for (Cliente cliente : clientes) {
            System.out.println(indice + ": " + cliente);

            indice++;
        }

        System.out.println();
    }

    // métodos de Sessao

    public void adicionarSessao() {
        System.out.println();
        System.out.println("Pesquise o filme (nome) para a sessão: ");

        int indiceFilme = pesquisarFilme(null);

        if (indiceFilme < 0) {
            System.out.println("Filme inválido. Cancelando adição da sessão.");
            return;
        }
        
        Filme filme = filmes.get(indiceFilme);

        System.out.println();
        System.out.println("Insira a data da sessão (dd/mm/yyyy): ");
        String stringData = scanner.next();
        
        LocalDate data = null;

        try {
            data = LocalDate.parse(stringData, formatter);
        } catch (DateTimeParseException e) {
            e.printStackTrace();
        }
        System.out.println();

        System.out.println("Insira a sala da sessão: ");
        int sala = scanner.nextInt();
        scanner.nextLine();
        System.out.println();

        Sessao sessaoAdicionada = new Sessao(filme, data, sala);
        sessoes.add(sessaoAdicionada);

        System.out.println("Sessão adicionada.");
        System.out.println();
    }

    public void removerSessao() {
        System.out.println();
        System.out.println("Insira o índice da sessão: ");
        int indice = scanner.nextInt();
        scanner.nextLine();
        System.out.println();

        Sessao sessaoRemovida = sessoes.get(indice);

        try {
            sessoes.remove(indice);    
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();        
        }

        System.out.println(sessaoRemovida + " removida.");
        System.out.println();
    }
    
    public void listarSessoes() {
        System.out.println();
        int indice = 0;

        for (Sessao sessao : sessoes) {
            System.out.println(indice + ": " + sessao);

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
