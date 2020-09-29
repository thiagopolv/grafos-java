package dijkstra.aplicacoes;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

import dijkstra.Dijkstra;
import dijkstra.estrutura.Grafo;
import dijkstra.estrutura.No;

public class CidadesDoTriangulo {

    public static void main(String[] args) {

        final String ERROR_MESSAGE = "Erro: Entrada inválida.";

        Grafo grafo = new Grafo();

        No capinopolis = new No("Capinópolis");
        No ituiutaba = new No("Ituiutaba");
        No itumbiara = new No("Itumbiara");
        No centralina = new No("Centralina");
        No tupaciguara = new No("Tupaciguara");
        No monteAlegre = new No("Monte Alegre de Minas");
        No douradinhos = new No("Douradinhos");
        No uberlandia = new No("Uberlândia");
        No araguari = new No("Araguari");
        No cascalhoRico = new No("Cascalho Rico");
        No indianopolis = new No("Indianópolis");
        No grupiara = new No("Grupiara");
        No estrelaDoSul = new No("Estrela Do Sul");
        No santaJuliana = new No("Santa Juliana");
        No irai = new No("Iraí de Minas");

        capinopolis.adicionarDestino(centralina, 40);
        capinopolis.adicionarDestino(ituiutaba, 30);

        ituiutaba.adicionarDestino(capinopolis, 30);
        ituiutaba.adicionarDestino(monteAlegre, 85);
        ituiutaba.adicionarDestino(douradinhos, 90);

        itumbiara.adicionarDestino(tupaciguara, 55);
        itumbiara.adicionarDestino(centralina, 20);

        centralina.adicionarDestino(itumbiara, 20);
        centralina.adicionarDestino(capinopolis, 40);
        centralina.adicionarDestino(monteAlegre, 75);

        tupaciguara.adicionarDestino(itumbiara, 55);
        tupaciguara.adicionarDestino(monteAlegre, 44);
        tupaciguara.adicionarDestino(uberlandia, 60);

        monteAlegre.adicionarDestino(centralina, 75);
        monteAlegre.adicionarDestino(ituiutaba, 85);
        monteAlegre.adicionarDestino(douradinhos, 28);
        monteAlegre.adicionarDestino(tupaciguara, 44);
        monteAlegre.adicionarDestino(uberlandia, 60);

        douradinhos.adicionarDestino(monteAlegre, 28);
        douradinhos.adicionarDestino(ituiutaba, 90);
        douradinhos.adicionarDestino(uberlandia, 63);

        uberlandia.adicionarDestino(tupaciguara, 60);
        uberlandia.adicionarDestino(monteAlegre, 60);
        uberlandia.adicionarDestino(douradinhos, 63);
        uberlandia.adicionarDestino(araguari, 30);
        uberlandia.adicionarDestino(irai, 78);
        uberlandia.adicionarDestino(indianopolis, 45);

        araguari.adicionarDestino(cascalhoRico, 28);
        araguari.adicionarDestino(estrelaDoSul, 34);
        araguari.adicionarDestino(uberlandia, 30);

        cascalhoRico.adicionarDestino(grupiara, 32);
        cascalhoRico.adicionarDestino(araguari, 28);

        indianopolis.adicionarDestino(uberlandia, 45);
        indianopolis.adicionarDestino(santaJuliana, 40);

        grupiara.adicionarDestino(cascalhoRico, 32);
        grupiara.adicionarDestino(estrelaDoSul, 38);

        estrelaDoSul.adicionarDestino(grupiara, 38);
        estrelaDoSul.adicionarDestino(araguari, 34);
        estrelaDoSul.adicionarDestino(irai, 27);

        irai.adicionarDestino(estrelaDoSul, 27);
        irai.adicionarDestino(uberlandia, 78);
        irai.adicionarDestino(santaJuliana, 28);

        santaJuliana.adicionarDestino(irai, 28);
        santaJuliana.adicionarDestino(indianopolis, 40);

        grafo.adicionarNo(capinopolis);
        grafo.adicionarNo(ituiutaba);
        grafo.adicionarNo(itumbiara);
        grafo.adicionarNo(centralina);
        grafo.adicionarNo(tupaciguara);
        grafo.adicionarNo(monteAlegre);
        grafo.adicionarNo(douradinhos);
        grafo.adicionarNo(uberlandia);
        grafo.adicionarNo(araguari);
        grafo.adicionarNo(cascalhoRico);
        grafo.adicionarNo(indianopolis);
        grafo.adicionarNo(grupiara);
        grafo.adicionarNo(estrelaDoSul);
        grafo.adicionarNo(santaJuliana);
        grafo.adicionarNo(irai);

        boolean quit = false;
        Scanner scanner = new Scanner(System.in);

        while (!quit) {
            System.out.println("______________________________________________________________");
            System.out.println();
            System.out.println("Cidades do Triângulo Mineiro:");
            System.out.println("");
            System.out.println("Selecione uma opção: (Ex: 1)");
            System.out.println("1 - Listar cidades");
            System.out.println("2 - Calcular rota");
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
                    grafo.getNos().forEach(no -> System.out.println(no.getNome()));
                    System.out.println(System.lineSeparator());
                    break;
                case 2:
                    System.out.println("Escolha uma cidade de origem: (Digite sem acentos)b");
                    String origem = scanner.nextLine();
                    Optional<No> noOrigem = grafo.encontrarNoPorNome(origem);

                    if (!noOrigem.isPresent()) {
                        System.out.println(ERROR_MESSAGE);
                        break;
                    }

                    System.out.println("Escolha uma cidade de destino: (Digite sem acentos)");
                    String destino = scanner.nextLine();
                    System.out.println();

                    Optional<No> noDestino = grafo.encontrarNoPorNome(destino);

                    if (!noDestino.isPresent()) {
                        System.out.println(ERROR_MESSAGE);
                        break;
                    }

                    Dijkstra.calcularCaminhoMaisCurtoDaOrigem(grafo, noOrigem.get());

                    System.out.println(noDestino.get().caminhoMaisCurtoToString());
                    System.out.println("Unidade de distância: km" + System.lineSeparator());
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
