// [EXTRA] Scanner e uma classe pronta do Java usada para ler o teclado.
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class JogoPesca {

    // [EXTRA] O metodo main e o ponto inicial de um programa Java.
    // String[] args faz parte do formato padrao do main.
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);    
        Random random = new Random();

        // Criacao de um objeto da classe Jogador usando o construtor.
        Jogador jogador = new Jogador("Pescador");

        Vara vara = new Vara();



        System.out.println("============================");
        System.out.println("       JOGO DE PESCA");
        System.out.println("============================");

        // [EXTRA] while repete o jogo ate o usuario escolher sair.
        while (true) {

            System.out.println("\n------ STATUS ------");
            jogador.mostrarStatus();
            vara.Status();

            System.out.println("\n1 - Pescar");
            System.out.println("2 - Evoluir vara | R$" + vara.GetCustoEvoluir());
            System.out.println("3 - Consertar vara | R$" + vara.GetCustoConserto());
            System.out.println("4 - Sair");
            System.out.print("Escolha: ");

            int opcao;

            try
            {
                opcao = teclado.nextInt();
            }
            catch (InputMismatchException e){
                System.out.println("\n A opcao deve ser um inteiro correspondente a uma das informacoes acima");
                teclado.nextLine();
                continue;
            }

            // [EXTRA] switch escolhe o que fazer de acordo com a opcao digitada.
            switch (opcao) {

                case 1:
                    // [EXTRA] if verifica se a vara ainda pode ser usada.
                    if (vara.GetDurabilidade() <= 0) {
                        System.out.println("Sua vara esta quebrada. Conserte primeiro!");
                        break;
                    }

                    int sorteio = random.nextInt(100) + 1;
                    Peixe peixe;

                    // O sorteio define qual objeto Peixe sera criado.
                    if (sorteio <= 70) {
                        peixe = new Peixe("Tilapia", "Comum", 10);
                    } else if (sorteio <= 90) {
                        peixe = new Peixe("Dourado", "Raro", 40);
                    } else if (sorteio <= 98) {
                        peixe = new Peixe("Atum", "Epico", 150);
                    } else {
                        peixe = new Peixe("Marlin", "Lendario", 600);
                    }

                    // Mutiplicar o valor do peixe pelo valor nivel da vara
                    int valorFinal = (int) (peixe.valor * (1.0 + (vara.GetNivel() * 0.10)));

                    jogador.receberDinheiro(valorFinal);
                    vara.Desgastar();

                    System.out.println("\nVoce pescou!\n");
                    System.out.println("Valor recebido: R$ " + valorFinal);
                    break;

                case 2:
                    if (jogador.dinheiro >= vara.GetCustoEvoluir()) {
                        jogador.dinheiro = jogador.dinheiro - vara.GetCustoEvoluir();
                        vara.Evoluir();

                        System.out.println("Vara evoluida!");
                        System.out.println("Novo nivel: " + vara.GetNivel());
                    } else {
                        System.out.println("Dinheiro insuficiente.");
                        System.out.println("Custo: R$ " + vara.GetCustoEvoluir());
                    }
                    break;

                case 3:
                    if (jogador.dinheiro >= vara.GetCustoConserto()) {
                        jogador.dinheiro = jogador.dinheiro - vara.GetCustoConserto();
                        vara.Consertar();

                        System.out.println("Vara consertada!");
                    } else {
                        System.out.println("Dinheiro insuficiente.");
                        System.out.println("Custo: R$ " + vara.GetCustoConserto());
                    }
                    break;

                case 4:
                    System.out.println("Obrigado por jogar!");
                    teclado.close();
                    return;

                default:
                    System.out.println("Opcao invalida.");
            }
        }
    }
}
