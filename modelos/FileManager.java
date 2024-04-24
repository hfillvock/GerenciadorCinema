package modelos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    
    private static String diretorioProjeto = System.getProperty("user.dir");

    private static File arquivoFilmes = new File(diretorioProjeto, "filmes.txt");
    private static File arquivoSessoes = new File(diretorioProjeto, "sessoes.txt");
    private static File arquivoClientes = new File(diretorioProjeto, "clientes.txt");
    private static File arquivoIngressos = new File(diretorioProjeto, "ingressos.txt");

    public FileManager() {
        inicializarArquivo(arquivoFilmes);
        inicializarArquivo(arquivoSessoes);
        inicializarArquivo(arquivoClientes);
        inicializarArquivo(arquivoIngressos);
    }

    public static boolean inicializarArquivo(File arquivo) {
        try {
            boolean criado = arquivo.createNewFile();

            if (criado) {
                System.out.println("Arquivo " + arquivo.getName() + " criado com sucesso.");
                return criado;
            } else {
                System.out.println("Arquivo " + arquivo.getName() + "já existe.");
                return criado;
            }

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void salvarFilmes(List<Filme> filmes) {
        salvarDados(filmes, arquivoFilmes);
    }

    public static void salvarSessoes(List<Sessao> sessoes) {
        salvarDados(sessoes, arquivoSessoes);
    }

    public static void salvarIngressos(List<Ingresso> ingressos) {
        salvarDados(ingressos, arquivoIngressos);
    }

    public static void salvarClientes(List<Cliente> clientes) {
        salvarDados(clientes, arquivoClientes);
    }
    
    /**
     * Salva os dados de uma lista para um arquivo.
     * @param dados lista cujos dados serão salvos.
     * @param arquivo arquivo onde os dados devem ser salvos.
     */
    private static void salvarDados(List<?> dados, File arquivo) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo));

            for (Object item : dados) {
                writer.write(item.toString());
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Filme> carregarFilmes(List<String> dadosCarregados) {
        List<Filme> filmesCarregados = new ArrayList<>();

        for (String representacao : dadosCarregados) {
            String[] params = representacao.substring(7, representacao.length() - 1).split(", ");

            String titulo = null;
            int classificacao = 0;
            int duracao = 0;

            for (String param : params) {
                String[] keyValue = param.split("=");
                String key = keyValue[0];
                String value = keyValue[1];

                switch (key) {
                    case "titulo":
                        titulo = value;
                        break;
                    case "classificacao":
                        classificacao = Integer.parseInt(value);
                        break;
                    case "duracao":
                        duracao = Integer.parseInt(value);
                        break;
                    default:
                        // Handle unknown key
                        System.out.println("ERRO: Chave inválida.");
                        break;
                }
            }

            Filme filme = new Filme(titulo, classificacao, duracao);
            filmesCarregados.add(filme);
        }

        return filmesCarregados;
    }

    /**
     * Carrega os dados de um arquivo para uma lista de strings, e a retorna.
     * @param arquivo arquivo a ter seu conteúdo carregado
     * @return lista de strings com o conteúdo do arquivo
     */
    public static List<String> carregarDados(File arquivo) { 
        List<String> dados = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(arquivo));

            String linha;
            
            while ((linha = reader.readLine()) != null) {
                dados.add(linha);
            }
            
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return dados;
    }

    // getters

    public static File getArquivoFilmes() {
        return arquivoFilmes;
    }

    public static File getArquivoSessoes() {
        return arquivoSessoes;
    }

    public static File getArquivoClientes() {
        return arquivoClientes;
    }

    public static File getArquivoIngressos() {
        return arquivoIngressos;
    }

}
