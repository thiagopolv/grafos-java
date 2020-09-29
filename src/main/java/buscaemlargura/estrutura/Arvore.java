package buscaemlargura.estrutura;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.Getter;

@Getter
public class Arvore<T> {

    private final T valor;
    private final List<Arvore<T>> filhos;

    public Arvore(T valor) {
        this.valor = valor;
        this.filhos = new ArrayList<>();
    }

    public static <T> Arvore<T> of(T valor) {
        return new Arvore<>(valor);
    }

    public List<Arvore<T>> getFilhos() {
        return Collections.unmodifiableList(filhos);
    }

    public Arvore<T> adicionarFilho(T valor) {
        Arvore<T> novoFilho = new Arvore<>(valor);
        filhos.add(novoFilho);
        return novoFilho;
    }

}
