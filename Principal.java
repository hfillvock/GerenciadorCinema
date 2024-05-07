import java.util.Scanner;
import modelos.*;

public class Principal {

    public static void main(String[] args) {

        GerenciadorCinema gerenciadorCinema = new GerenciadorCinema();        

        Scanner scanner = new Scanner(System.in);
        char aux = ' ';
        char aux2 = ' ';

        while(aux != 'v') {
            aux = ' ';

            limparTela();
            System.out.println("\nSistema de Gerenciamento de Cinema");
            separador();
            System.out.println("\nEscolha uma opção:\n\nGerenciar:\n[f]ilmes\n[c]lientes\n[s]essões\n[i]ngressos\n[v]azar e salvar");

            aux = scanner.next().toLowerCase().charAt(0);
            scanner.nextLine();

            switch (aux) {
                
                case 'f':                    
                    limparTela();

                    do {
                        aux2 = ' ';

                        System.out.println("Gerenciando filmes.\n\nEscolha uma opção:\n[a]dicionar\n[r]emover\n[p]esquisar\n[l]istar\n[c]ancelar");
                        aux2 = scanner.next().toLowerCase().charAt(0);
                        scanner.nextLine();

                        switch (aux2) {
                            case 'a':
                                gerenciadorCinema.adicionarFilme();
                                break;
                            
                            case 'r':
                                gerenciadorCinema.removerFilme();
                                break;
                            
                            case 'p':
                                gerenciadorCinema.pesquisarFilme(null);
                                break;
                            
                            case 'l':
                                gerenciadorCinema.listarFilmes();
                                break;
                            
                            case 'c':
                                System.out.println("\nCancelando.\n");
                                break;
    
                            default:
                                System.out.println("\nOpção inválida, perguntando denovo.\n");
                                break;
                        
                            }
                    } while(aux2 != 'c');
                    break;

                case 'c':
                    limparTela();

                    do {
                        aux2 = ' ';

                        System.out.println("Gerenciando clientes.\n\nEscolha uma opção:\n[a]dicionar\n[r]emover\n[p]esquisar\n[l]istar\n[c]ancelar");
                        aux2 = scanner.next().toLowerCase().charAt(0);
                        scanner.nextLine();

                        switch (aux2) {
                            case 'a':
                                gerenciadorCinema.adicionarCliente();
                                break;
                            
                            case 'r':
                                gerenciadorCinema.removerCliente();
                                break;
                            
                            case 'p':
                                gerenciadorCinema.pesquisarCliente();
                                break;
                            
                            case 'l':
                                gerenciadorCinema.listarClientes();
                                break;
                            
                            case 'c':
                                System.out.println("\nCancelando.\n");
                                break;
    
                            default:
                                System.out.println("\nOpção inválida, perguntando denovo.\n");
                                break;
                        
                            }
                    } while(aux2 != 'c');
                    break;

                case 's':
                    limparTela();

                    do {
                        aux2 = ' ';

                        System.out.println("Gerenciando sessões.\n\nEscolha uma opção:\n[a]dicionar\n[r]emover\n[l]istar\n[c]ancelar");
                        aux2 = scanner.next().toLowerCase().charAt(0);
                        scanner.nextLine();

                        switch (aux2) {
                            case 'a':
                                gerenciadorCinema.adicionarSessao();
                                break;
                            
                            case 'r':
                                gerenciadorCinema.removerSessao();
                                break;
                            
                            case 'l':
                                gerenciadorCinema.listarSessoes();
                                break;
                            
                            case 'c':
                                System.out.println("\nCancelando.\n");
                                break;

                            default:
                                System.out.println("\nOpção inválida, perguntando denovo.\n");
                                break;
                        
                            }
                    } while(aux2 != 'c');
                    break;

                case 'i':
                    limparTela();

                    do {
                        aux2 = ' ';

                        System.out.println("Gerenciando ingressos.\n\nEscolha uma opção:\n[v]ender\n[r]emover\n[l]istar\n[c]ancelar");
                        aux2 = scanner.next().toLowerCase().charAt(0);
                        scanner.nextLine();

                        switch (aux2) {
                            case 'a':
                                gerenciadorCinema.venderIngresso();
                                break;
                            
                            case 'r':
                                gerenciadorCinema.removerIngresso();
                                break;
                            
                            case 'l':
                                gerenciadorCinema.listarIngressos();
                                break;
                            
                            case 'c':
                                System.out.println("\nCancelando.\n");
                                break;

                            default:
                                System.out.println("\nOpção inválida, perguntando denovo.\n");
                                break;
                        
                            }
                    } while(aux2 != 'c');
                    break;

                case 'v':
                    limparTela();
                    System.out.println("Vazando e salvando.");
                    break;

                default:
                    limparTela();
                    System.out.println("Opção inválida, perguntando denovo.");
                    break;
            }
        }

        FileManager.salvarArquivos(gerenciadorCinema);

        scanner.close();
    }

    public static void separador() {
        System.out.println();

        for (int i = 0; i < 64; i++) {
            System.out.print("=");
        }

        System.out.println();
    }

    public static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
