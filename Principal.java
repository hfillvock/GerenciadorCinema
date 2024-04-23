import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        char aux = ' ';

        separador();
        System.out.println("\nSistema de Gerenciamento de Cinema");

        while(aux != 's') {

            separador();
            System.out.println("\nEscolha uma opção:\n[a]gendar sessão\n[v]ender ingresso\n[g]erenciar assentos em sala de exibição\n[c]alcular vendas de ingresso\n[s]air");

            aux = scanner.next().toLowerCase().charAt(0);

            switch (aux) {
                case 'a':
                    System.out.println("agendando sessao.");
                    break;

                case 'v':
                    System.out.println("vendendo ingresso.");
                    break;

                case 'g':
                    System.out.println("gerenciando assentos.");
                    break;

                case 'c':
                    System.out.println("calculando vendas de ingressos.");
                    break;

                case 's':
                    System.out.println("saindo.");
                    break;

                default:
                    System.out.println("opção inválida, perguntando denovo.");
                    break;
            }
        }

        scanner.close();

    }

    public static void separador() {

        System.out.println();

        for (int i = 0; i < 36; i++) {
            System.out.print("#");
        }

        System.out.println();
    }
}
