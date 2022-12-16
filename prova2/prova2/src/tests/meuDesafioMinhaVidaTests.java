package tests;

import meuDesafioMinhaVida.MeuDesafioMinhaVida;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;

public class meuDesafioMinhaVidaTests {
    
    public MeuDesafioMinhaVida meuDesafioMinhaVida;

    @BeforeEach
    public void setUp() {
        meuDesafioMinhaVida = new MeuDesafioMinhaVida();
        meuDesafioMinhaVida.adicionaDesafio("Desafio 1", "Descricao 1");
    }

    @Test
    public void testAdicionaDesafioPessoal() {
        meuDesafioMinhaVida.adicionaDesafio("30 dias sem açucar", "Descricao 1");
        assertEquals("Titulo: 30 dias sem açucar (Pessoal)\n0 execuções", meuDesafioMinhaVida.exibeDesafio("30 dias sem açucar"));
    }

    @Test
    public void testAdicionaDesafioMaterial() {
        meuDesafioMinhaVida.adicionaDesafioMaterial("Comprar um carro", "Descricao 1", 5000);
        assertEquals("Titulo: Comprar um carro (Material)\n0 execuções", meuDesafioMinhaVida.exibeDesafio("Comprar um carro"));
    }

    @Test void testAdicionaDesafioSocial() {
        meuDesafioMinhaVida.adicionaDesafioSocial("Fazer um amigo", "Descricao 1", 1);
        assertEquals("Titulo: Fazer um amigo (Social)\n0 execuções", meuDesafioMinhaVida.exibeDesafio("Fazer um amigo"));
    }

    @Test
    public void testAtualizaProgressoDesafio() {
        meuDesafioMinhaVida.adicionaAcao(1, "01/01/2020", "Desafio 1");
        meuDesafioMinhaVida.atualizaProgressoAcao(1, 100);
        assertEquals("Titulo: Desafio 1 (Pessoal)\n1 execuções", meuDesafioMinhaVida.exibeDesafio("Desafio 1"));
    }

    @Test
    public void testlistarAcoes() {
        meuDesafioMinhaVida.adicionaAcao(1, "01/01/2020", "Desafio 1");
        meuDesafioMinhaVida.adicionaAcao(2, "02/01/2022", "Desafio 1");
        meuDesafioMinhaVida.atualizaProgressoAcao(1, 30);
        meuDesafioMinhaVida.atualizaProgressoAcao(2);

        assertEquals("2 - 02/01/2022 - Desafio 1 - Progresso 10\n1 - 01/01/2020 - Desafio 1 - Progresso 30", meuDesafioMinhaVida.listarAcoes());
    }


    @Test 
    public void testSatisfacaoDesafioSocial() {
        meuDesafioMinhaVida.adicionaDesafioSocial("Fazer um amigo",75);
        meuDesafioMinhaVida.adicionaAcao(1, "01/01/2020", "Fazer um amigo");
        meuDesafioMinhaVida.atualizaProgressoAcao(1, 100);
        assertEquals("Titulo: Fazer um amigo (Social)\n1 execuções", meuDesafioMinhaVida.exibeDesafio("Fazer um amigo"));
        assertEquals(50, meuDesafioMinhaVida.pegarSatisfacao("Fazer um amigo"));
    }

    @Test
    public void testSatisfacaoDesafioMaterial() {
        meuDesafioMinhaVida.adicionaDesafioMaterial("Comprar um carro", 5000);
        meuDesafioMinhaVida.adicionaAcao(1, "01/01/2020", "Comprar um carro");
        meuDesafioMinhaVida.atualizaProgressoAcao(1, 100);
        assertEquals("Titulo: Comprar um carro (Material)\n1 execuções", meuDesafioMinhaVida.exibeDesafio("Comprar um carro"));
        assertEquals(500, meuDesafioMinhaVida.pegarSatisfacao("Comprar um carro"));
    }
}
