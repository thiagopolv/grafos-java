package algoritmos;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import estrutura.Grafo;
import estrutura.No;

public class Dijkstra {

    public static Grafo calcularCaminhoMaisCurtoDaOrigem(Grafo grafo, No origem) {
        origem.setDistancia(0);

        Set<No> nosSetados = new HashSet<>();
        Set<No> nosNaoSetados = new HashSet<>();
        nosNaoSetados.add(origem);

        while(nosNaoSetados.size() != 0) {
            No noAtual = noDeMenorDistancia(nosNaoSetados);
            nosNaoSetados.remove(noAtual);

            for (Map.Entry<No, Integer> parAdjacente: noAtual.getNosAdjacentes().entrySet()) {

                No noAdjacente = parAdjacente.getKey();
                Integer pesoDoVertice = parAdjacente.getValue();

                if (!nosSetados.contains(noAdjacente)) {
                    calcularDistanciaMinima(noAdjacente, pesoDoVertice, noAtual);
                    nosNaoSetados.add(noAdjacente);
                }
            }

            nosSetados.add(noAtual);

        }
        return grafo;
    }

    private static void calcularDistanciaMinima(No noAvaliado, Integer pesoDoVertice, No noDeOrigem) {
        Integer distanciaDaOrigem = noDeOrigem.getDistancia();

        if (distanciaDaOrigem + pesoDoVertice < noAvaliado.getDistancia()) {
            noAvaliado.setDistancia(distanciaDaOrigem + pesoDoVertice);
            LinkedList<No> caminhoMaisCurto = new LinkedList<>(noDeOrigem.getCaminhoMaisCurto());
            caminhoMaisCurto.add(noDeOrigem);
            noAvaliado.setCaminhoMaisCurto(caminhoMaisCurto);
        }
    }

    private static No noDeMenorDistancia(Set<No> nosNaoSetados) {
        No noDeMenorDistancia = null;
        int menorDistancia = Integer.MAX_VALUE;

        for (No no: nosNaoSetados) {
            int distanciaDoNo = no.getDistancia();

            if (distanciaDoNo < menorDistancia) {
                menorDistancia = distanciaDoNo;
                noDeMenorDistancia = no;
            }
        }

        return noDeMenorDistancia;
    }

}
