import java.util.Scanner;

public class Uni4Exe27 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entrada de dados
        System.out.print("Digite a hora de chegada: ");
        int horaChegada = scanner.nextInt();
        System.out.print("Digite os minutos de chegada: ");
        int minChegada = scanner.nextInt();

        System.out.print("Digite a hora de saída: ");
        int horaSaida = scanner.nextInt();
        System.out.print("Digite os minutos de saída: ");
        int minSaida = scanner.nextInt();

        // Validação dos dados
        if (horaChegada < 0 || horaChegada > 23 || minChegada < 0 || minChegada > 59 ||
            horaSaida < 0 || horaSaida > 23 || minSaida < 0 || minSaida > 59 ||
            (horaSaida < horaChegada) || (horaSaida == horaChegada && minSaida < minChegada)) {
            System.out.println("Horário inválido! Certifique-se de que a saída ocorre após a chegada.");
            return;
        }

        // Cálculo do tempo total
        int totalMinutosChegada = horaChegada * 60 + minChegada;
        int totalMinutosSaida = horaSaida * 60 + minSaida;
        int tempoEstacionado = totalMinutosSaida - totalMinutosChegada;

        // Arredondamento do tempo
        int horasCobradas = tempoEstacionado / 60;
        int minutosRestantes = tempoEstacionado % 60;
        if (minutosRestantes >= 30) {
            horasCobradas++;
        }
        if (horasCobradas == 0) {
            horasCobradas = 1; // Cobrança mínima de 1 hora
        }

        // Cálculo do preço
        int preco = 0;
        for (int i = 1; i <= horasCobradas; i++) {
            if (i <= 2) {
                preco += 5;
            } else if (i <= 4) {
                preco += 7.5;
            } else {
                preco += 10;
            }
        }

        // Exibir resultados
        System.out.println("Tempo estacionado: " + (tempoEstacionado / 60) + " horas e " + (tempoEstacionado % 60) + " minutos.");
        System.out.println("Valor a pagar: R$ " + preco);
    }
}
