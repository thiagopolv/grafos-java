package buscaemlargura.aplicacoes;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import buscaemlargura.AlgoritmoBuscaEmLargura;
import buscaemlargura.estrutura.No;

public class RoboAspirador {

    @SuppressWarnings({"unchecked", "rawtypes"})
    public static void main(String[] args) {

        final String ERROR_MESSAGE = "Erro: Entrada inválida.";

        No<String> cozinha = new No<>("Cozinha");
        No<String> salao = new No<>("Salão");
        cozinha.connect(salao);

        No<String> corredor = new No<>("Corredor");
        corredor.connect(salao);

        No<String> banho1 = new No<>("Banho 1");
        banho1.connect(corredor);

        No<String> quarto1 = new No<>("Quarto 1");
        quarto1.connect(corredor);

        No<String> quarto2 = new No<>("Quarto 2");
        quarto2.connect(corredor);

        No<String> suite = new No<>("Suite");
        suite.connect(corredor);

        No<String> banho2 = new No<>("Banho 2");
        banho2.connect(suite);

        List<No> nos = Arrays.asList(cozinha, salao, corredor, banho1, quarto1, quarto2, suite, banho2);

        boolean quit = false;
        Scanner scanner = new Scanner(System.in);

        while (!quit) {
            System.out.println("______________________________________________________________");
            System.out.println();
            System.out.println("Comandos do robô aspirador de pó:");
            System.out.println();
            System.out.println("Insira um comando: (Ex: 1)");
            System.out.println("1 - Listar cômodos");
            System.out.println("2 - Fazer limpeza");
            System.out.println("3 - Sair");

            System.out.println(">>> ");
            int opcao;
            try {
                opcao = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                opcao = 0;
            }

            switch (opcao) {

                case 1:
                    nos.forEach(no -> System.out.println(no.getValor()));
                    System.out.println(System.lineSeparator());
                    break;
                case 2:
                    System.out.println("Escolha o cômodo de partida:");
                    String partida = scanner.nextLine();
                    Optional<No> noPartida = nos.stream()
                            .filter(no -> no.getValor().equals(partida))
                            .findFirst();

                    if (!noPartida.isPresent()) {
                        System.out.println(ERROR_MESSAGE);
                        break;
                    }

                    System.out.println("Escolha o cômodo de destino:");
                    String destino = scanner.nextLine();
                    System.out.println();

                    Optional<No> noDestino = nos.stream()
                            .filter(no -> no.getValor().equals(destino))
                            .findFirst();

                    if (!noDestino.isPresent()) {
                        System.out.println(ERROR_MESSAGE);
                        break;
                    }

                    AlgoritmoBuscaEmLargura.procurar(destino, noPartida.get());
                    break;
                case 3:
                    quit = true;
                    break;
                default:
                    System.out.println(ERROR_MESSAGE);
                    break;
            }
        }
    }
}
