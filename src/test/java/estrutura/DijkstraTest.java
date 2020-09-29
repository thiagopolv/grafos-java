package estrutura;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import dijkstra.Dijkstra;
import dijkstra.estrutura.Grafo;
import dijkstra.estrutura.No;


class DijkstraTest {

    @Test
    void dijkstraCalcularCaminhoMaisCurtoTest() {

        Grafo grafo = new Grafo();

        No noA = new No("A");
        No noB = new No("B");
        No noC = new No("C");
        No noD = new No("D");
        No noE = new No("E");

        noA.adicionarDestino(noB, 10);
        noA.adicionarDestino(noC, 5);
        noA.adicionarDestino(noD, 4);

        noB.adicionarDestino(noE, 1);

        noC.adicionarDestino(noB, 2);
        noC.adicionarDestino(noD, 3);
        noC.adicionarDestino(noE, 10);

        noD.adicionarDestino(noE, 8);

        grafo.adicionarNo(noA);
        grafo.adicionarNo(noB);
        grafo.adicionarNo(noC);
        grafo.adicionarNo(noD);
        grafo.adicionarNo(noE);

        Dijkstra.calcularCaminhoMaisCurtoDaOrigem(grafo, noA);

        List<No> caminhoMaisCurtoAteNoBErrado = Collections.singletonList(noA);
        List<No> caminhoMaisCurtoAteNoBCerto = Arrays.asList(noA, noC);
        List<No> caminhoMaisCurtoAteNoC = Collections.singletonList(noA);
        List<No> caminhoMaisCurtoAteNoD = Collections.singletonList(noA);
        List<No> caminhoMaisCurtoAteNoE = Arrays.asList(noA, noC, noB);

        assertNotEquals(caminhoMaisCurtoAteNoBErrado, noB.getCaminhoMaisCurto());
        assertEquals(caminhoMaisCurtoAteNoBCerto, noB.getCaminhoMaisCurto());
        assertEquals(caminhoMaisCurtoAteNoC, noC.getCaminhoMaisCurto());
        assertEquals(caminhoMaisCurtoAteNoD, noD.getCaminhoMaisCurto());
        assertEquals(caminhoMaisCurtoAteNoE, noE.getCaminhoMaisCurto());

        System.out.println(noB.caminhoMaisCurtoToString());
        System.out.println(noC.caminhoMaisCurtoToString());
        System.out.println(noD.caminhoMaisCurtoToString());
        System.out.println(noE.caminhoMaisCurtoToString());

    }

}