package buscaemlargura.estrutura;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import lombok.Getter;

@Getter
public class No<T> {

    private final T valor;
    private final Set<No<T>> vizinhos;

    public No(T valor) {
        this.valor = valor;
        this.vizinhos = new HashSet<>();
    }

    public Set<No<T>> getVizinhos() {
        return Collections.unmodifiableSet(vizinhos);
    }

    public void connect(No<T> no) {
        if (this == no) {
            throw new IllegalArgumentException("Não é possível conectar um nó a si mesmo");
        }

        this.vizinhos.add(no);
        no.vizinhos.add(this);
    }

}
