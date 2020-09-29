package buscaemlargura;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;

import buscaemlargura.estrutura.Arvore;
import buscaemlargura.estrutura.No;

public class AlgoritmoBuscaEmLargura {

    public static <T> Optional<Arvore<T>> procurar(T valor, Arvore<T> raiz) {
        Queue<Arvore<T>> fila = new ArrayDeque<>();
        fila.add(raiz);

        Arvore<T> noAtual;
        while (!fila.isEmpty()) {
            noAtual = fila.remove();
            System.out.printf("Visitou nó com o valor: %s%n", noAtual.toString());

            if (noAtual.getValor().equals(valor)) {
                return Optional.of(noAtual);
            } else {
                fila.addAll(noAtual.getFilhos());
            }
        }

        return Optional.empty();
    }

    public static <T> Optional<No<T>> procurar(T valor, No<T> comeco) {
        Queue<No<T>> fila = new ArrayDeque<>();
        fila.add(comeco);

        No<T> noAtual;
        Set<No<T>> nosJaVisitados = new HashSet<>();

        while (!fila.isEmpty()) {
            noAtual = fila.remove();
            System.out.printf("Visitou nó com o valor: %s%n", noAtual.getValor().toString());

            if (noAtual.getValor().equals(valor)) {
                return Optional.of(noAtual);
            } else {
                nosJaVisitados.add(noAtual);
                fila.addAll(noAtual.getVizinhos());
                fila.removeAll(nosJaVisitados);
            }
        }

        return Optional.empty();
    }

}
