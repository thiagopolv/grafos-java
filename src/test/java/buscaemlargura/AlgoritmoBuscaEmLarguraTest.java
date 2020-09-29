package buscaemlargura;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import javax.xml.soap.Node;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Nested;

import buscaemlargura.estrutura.Arvore;
import buscaemlargura.estrutura.No;

class AlgoritmoBuscaEmLarguraTest {

    private Arvore<Integer> raiz;
    private Arvore<Integer> raizNo1;
    private Arvore<Integer> raizNo2;
    private Arvore<Integer> raizNo3;
    private Arvore<Integer> raizNo4;
    private Arvore<Integer> raizNo5;

    private No<Integer> inicio;
    private No<Integer> no1;
    private No<Integer> no2;
    private No<Integer> no3;
    private No<Integer> no4;
    private No<Integer> no5;


    @BeforeEach
    void setUp() {
        iniciarNos();
    }

    @Test
    void quandoBuscarPor10DeNo2EntaoRetornaInicio() {
        assertEquals(Optional.of(inicio), AlgoritmoBuscaEmLargura.procurar(10, no2));
    }

    @Test
    void quandoBuscarPor4DeNo1EntaoRetornaNo4() {
        assertEquals(Optional.of(no4), AlgoritmoBuscaEmLargura.procurar(4, no1));
    }

    @Test
    void quandoBuscarPor5DeNo1EntaoRetornaNo5() {
        assertEquals(Optional.of(no5), AlgoritmoBuscaEmLargura.procurar(5, no1));
    }

    @Test
    void quandoBuscarPor2DeNo3EntaoRetornaNo2() {
        assertEquals(Optional.of(no2), AlgoritmoBuscaEmLargura.procurar(2, no3));
    }

    @Test
    void quandoBuscarPor3DeNo4EntaoRetornaNo3() {
        assertEquals(Optional.of(no3), AlgoritmoBuscaEmLargura.procurar(3, no4));
    }

    private void iniciarNos() {
        inicio = new No<>(10);
        no1 =  new No<>(1);
        inicio.connect(no1);

        no2 =  new No<>(2);
        no1.connect(no2);

        no3 =  new No<>(3);
        no3.connect(no2);
        inicio.connect(no3);

        no4 =  new No<>(4);
        inicio.connect(no4);

        no5 =  new No<>(5);
        no4.connect(no5);
        no5.connect(inicio);
    }

    private void iniciarArvore() {
        raiz = Arvore.of(10);
        raizNo1 = raiz.adicionarFilho(1);
        raizNo3 = raiz.adicionarFilho(3);
        raizNo4 = raiz.adicionarFilho(4);
        raizNo2 = raizNo1.adicionarFilho(2);
        raizNo5 = raizNo4.adicionarFilho(5);
    }
}