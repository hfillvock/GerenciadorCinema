package modelos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    
    private static final String FILMES_FILENAME = "filmes.txt";
    private static final String SESSOES_FILENAME = "sessoes.txt";
    private static final String INGRESSOS_FILENAME = "ingressos.txt";
    private static final String CLIENTES_FILENAME = "clientes.txt";

    public static void salvarFilmes(List<Filme> filmes) {
        salvarDados(filmes, FILMES_FILENAME);
    }

    public static void salvarSessoes(List<Sessao> sessoes) {
        salvarDados(sessoes, SESSOES_FILENAME);
    }

    public static void salvarIngressos(List<Ingresso> ingressos) {
        salvarDados(ingressos, INGRESSOS_FILENAME);
    }

    public static void salvarClientes(List<Cliente> clientes) {
        salvarDados(clientes, CLIENTES_FILENAME);
    }
    
    private static void salvarDados(List<?> dados, String filename) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));

            for (Object item : dados) {
                writer.write(item.toString());
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> carregarDados(String filename) { 
        List<String> dados = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));

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
}
