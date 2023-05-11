import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class JogosDados {
    static Scanner teclado = new Scanner(System.in);
    static Random gerador = new Random();

    public static void main(String[] args) {

       lacoRepeticao();
    }

    public static int verificarNumeroUsuario(int dado){
        if (dado <= 0 || dado >= 7){

            System.out.println("Numero invalido");
            System.out.println("Digite um novo numero de 1 a 6: ");
             return verificarNumeroUsuario(teclado.nextInt());
        }
        return numeroSorteado();
    }

    public static int numeroSorteado(){
        int numeroAleatorio = gerador.nextInt(6) + 1;
        System.out.println("Numero aleatorio gerado: " + numeroAleatorio);

        return numeroAleatorio;
    }

    public static int compararNumero (int numeroUsuario, int numeroAleatorio){
        int pontuacao=0;
        if (numeroUsuario == numeroAleatorio){
            System.out.println("Voce ganhou 10 pontos \n");
            pontuacao =10;
        }
        else if (numeroUsuario +1 == numeroAleatorio || numeroUsuario -1 == numeroAleatorio) {
            System.out.println("Seu numero é diferente em uma unidade, voce ganhou 5 pontos \n");
            pontuacao = 5;
        }
        else {
            System.out.println("Ops, não foi dessa vez \n");
        }
        return pontuacao;
    }
    public static void lacoRepeticao(){
        int rodadas = 3;
        int total = 0;

        List <Integer> numerosDeAcertos = new ArrayList<>();
        List <Integer> numeroDeErros = new ArrayList<>();

        for (int i = 0; i < rodadas; i++) {
            System.out.println("Digite um numero de 1 a 6");
            int numeroUsuario = teclado.nextInt();


            int numeroAleatorio = verificarNumeroUsuario(numeroUsuario);
            int pontuacao = compararNumero(numeroUsuario,numeroAleatorio);



            if (pontuacao == 0){
                numeroDeErros.add(numeroUsuario);
                System.out.println("Numeros errados: " + numeroDeErros.size());
            }

            else {
                numerosDeAcertos.add(numeroUsuario);
                System.out.println("Numeros acertados é: " + numerosDeAcertos.size());
            }


            total += pontuacao;
            System.out.println("Sua pontuação total foi: " + total);

            System.out.println("-------------------------------");
        }

    }


}