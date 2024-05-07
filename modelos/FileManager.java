package modelos;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class FileManager implements Serializable {

    public static void salvarArquivos(CinemaManager gerenciadorCinema) {

        try {
            FileOutputStream fileFilmes = new FileOutputStream("filmes.ser");
            ObjectOutputStream outFilmes = new ObjectOutputStream(fileFilmes);

            outFilmes.writeObject(gerenciadorCinema.getFilmes());
            outFilmes.close();

            FileOutputStream fileClientes = new FileOutputStream("clientes.ser");
            ObjectOutputStream outClientes = new ObjectOutputStream(fileClientes);

            outClientes.writeObject(gerenciadorCinema.getClientes());
            outClientes.close();

            FileOutputStream fileSessoes = new FileOutputStream("sessoes.ser");
            ObjectOutputStream outSessoes = new ObjectOutputStream(fileSessoes);

            outSessoes.writeObject(gerenciadorCinema.getSessoes());
            outSessoes.close();

            FileOutputStream fileIngressos = new FileOutputStream("ingressos.ser");
            ObjectOutputStream outIngressos = new ObjectOutputStream(fileIngressos);

            outIngressos.writeObject(gerenciadorCinema.getIngressos());
            outIngressos.close();

        } catch(IOException e) {
            e.getLocalizedMessage();
        }
        
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void carregarArquivos(CinemaManager gerenciadorCinema) {

        List<Filme> filmes = null;
        List<Cliente> clientes = null;
        List<Sessao> sessoes = null;
        List<Ingresso> ingressos = null;

        try {
            FileInputStream fileFilmes = new FileInputStream("filmes.ser");
            ObjectInputStream inFilmes = new ObjectInputStream(fileFilmes);

            filmes = (ArrayList) inFilmes.readObject();
            inFilmes.close();

            FileInputStream fileClientes = new FileInputStream("clientes.ser");
            ObjectInputStream inClientes = new ObjectInputStream(fileClientes);

            clientes = (ArrayList) inClientes.readObject();
            inClientes.close();

            FileInputStream fileSessoes = new FileInputStream("sessoes.ser");
            ObjectInputStream inSessoes = new ObjectInputStream(fileSessoes);

            sessoes = (ArrayList) inSessoes.readObject();
            inSessoes.close();

            FileInputStream fileIngressos = new FileInputStream("ingressos.ser");
            ObjectInputStream inIngressos = new ObjectInputStream(fileIngressos);

            ingressos = (ArrayList) inIngressos.readObject();
            inIngressos.close();

        } catch(IOException e) {
            e.getLocalizedMessage();
        } catch (ClassNotFoundException e) {
            e.getLocalizedMessage();
        }

        gerenciadorCinema.setFilmes(filmes);
        gerenciadorCinema.setClientes(clientes);
        gerenciadorCinema.setSessoes(sessoes);
        gerenciadorCinema.setIngressos(ingressos);
    }
}


