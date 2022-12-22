package com.company.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestCampo {
    private Campo campo;

    @BeforeEach
    void iniciarCampo() {
        campo = new Campo(3, 3);
    }

    @Test
    void testeVizinhoDistancia1Esquerda() {
        Campo vizinho = new Campo(3 , 2);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertTrue(resultado);
    }

    @Test
    void testeVizinhoDistancia1Direita() {
        Campo vizinho = new Campo(3 , 4);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertTrue(resultado);
    }

    @Test
    void testeVizinhoDistancia1Emcima() {
        Campo vizinho = new Campo(2 , 3);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertTrue(resultado);
    }

    @Test
    void testeVizinhoDistancia1Embaixo() {
        Campo vizinho = new Campo(4 , 3);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertTrue(resultado);
    }

    @Test
    void testeVizinhoDistancia2EsquerdaEmcima() {
        Campo vizinho = new Campo(2 , 2);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertTrue(resultado);
    }

    @Test
    void testeVizinhoDistancia2EsquerdaEmbaixo() {
        Campo vizinho = new Campo(4 , 2);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertTrue(resultado);
    }

    @Test
    void testeVizinhoDistancia2DireitaEmcima() {
        Campo vizinho = new Campo(2 , 4);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertTrue(resultado);
    }

    @Test
    void testeVizinhoDistancia2DireitaEmbaixo() {
        Campo vizinho = new Campo(3 , 4);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertTrue(resultado);
    }

    @Test
    void testeNaoVizinho() {
        Campo vizinho = new Campo(5 , 4);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertFalse(resultado);
    }

    @Test
    void testeValorPadraoMarcado() {
        assertFalse(campo.isMarcado());
    }

    @Test
    void testeAlternarMarcacaoMarcacao() {
        campo.alternarMarcacao();
        assertTrue(campo.isMarcado());
    }

    @Test
    void testeAbrirVazioNaoMarcado() {
        assertTrue(campo.abrir());
    }

    @Test
    void testeAbrirVazioMarcado() {
        campo.alternarMarcacao();
        assertFalse(campo.abrir());
    }

//    @Test
//    void testeAbrirMinadoNaoMarcado() {
//        campo.minar();
//        assertThrows(ExplosaoException.class, () -> {
//            campo.abrir();
//        });
//    }

    @Test
    void testeAbrirMinadoMarcado() {
        campo.minar();
        campo.alternarMarcacao();
        assertFalse(campo.abrir());
    }

    @Test
    void testeAbrirVizinho1() {
        Campo campo22 = new Campo(2, 2);
        Campo campo11 = new Campo(1, 1);

        campo22.adicionarVizinho(campo11);
        campo.adicionarVizinho(campo22);
        campo.abrir();

        assertTrue(campo11.isAberto() && campo22.isAberto());
    }

    @Test
    void testeAbrirVizinho2() {
        Campo campo22 = new Campo(2, 2);
        Campo campo11 = new Campo(1, 1);
        campo11.minar();

        campo22.adicionarVizinho(campo11);
        campo.adicionarVizinho(campo22);
        campo.abrir();

        assertTrue(!campo11.isAberto() && campo22.isAberto());
    }
}
