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
    }

    @Test
    public void testAdicionaAcao() { 
        meuDesafioMinhaVida.adicionaDesafio("Desafio 1", "Descricao 1");
        meuDesafioMinhaVida.adicionaAcao(1, "01/01/2020", 1);
        assertEquals("1 - 01/01/2020 - Desafio 1 - Progresso 0\n", meuDesafioMinhaVida.listarAcoes());
    }

    @Test
    public void testAtualizaProgresso() {
        meuDesafioMinhaVida.adicionaDesafio("Desafio 1", "Descricao 1");
        meuDesafioMinhaVida.adicionaAcao(1, "01/01/2020", 1);
        meuDesafioMinhaVida.atualizaProgressoAcao(1, 100);
        assertEquals("1 - 01/01/2020 - Desafio 1 - Progresso 100", meuDesafioMinhaVida.listarAcoes());
    }
        

    @Test
    public void testAdicionaDesafio() {
        meuDesafioMinhaVida.adicionaDesafio("Desafio 1", "Descricao 1");
        assertEquals("Titulo: Desafio 1\n0 execuções", meuDesafioMinhaVida.exibeDesafio(1));
    }

    @Test
    public void testAtualizaProgressoDesafio() {
        meuDesafioMinhaVida.adicionaDesafio("Desafio 1", "Descricao 1");
        meuDesafioMinhaVida.adicionaAcao(1, "01/01/2020", 1);
        meuDesafioMinhaVida.adicionarAcaoDesafio(1, 1);
        meuDesafioMinhaVida.atualizaProgresso(1, 1, 100);
        assertEquals("Titulo: Desafio 1\n1 execuções", meuDesafioMinhaVida.exibeDesafio(1));
    }

    @Test
    public void testlistarAcoes() {
        meuDesafioMinhaVida.adicionaDesafio("Desafio 1", "Descricao 1");
        meuDesafioMinhaVida.adicionaAcao(1, "01/01/2020", 1);
        meuDesafioMinhaVida.adicionaAcao(2, "02/01/2022", 1);
        meuDesafioMinhaVida.adicionarAcaoDesafio(1, 1);
        meuDesafioMinhaVida.atualizaProgresso(1, 1, 30);

        assertEquals("2 - 02/01/2022 - Desafio 1 - Progresso 0\n1 - 01/01/2020 - Desafio 1 - Progresso 30"
        , meuDesafioMinhaVida.listarAcoes());
    }
}
