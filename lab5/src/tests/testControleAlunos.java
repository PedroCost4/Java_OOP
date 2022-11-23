package tests;

import Classes.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;


public class testControleAlunos {

    private ControleDeAlunos controle;

    @BeforeEach
    public void setUp() {
        controle = new ControleDeAlunos();
        controle.cadastrarAluno("250", "Gabriel Reyes", "Computação");
        controle.cadastrarAluno("200", "Lili Camposh", "Computação");
        controle.cadastrarAluno("202", "Angela Ziegler", "Medicina");
        controle.cadastrarAluno("201", "Tobjorn Lindholm", "Engenharia Mecânica");
    }


    @Test
    public void testCadastrarGrupoSemRestricao() {
        assertEquals("Grupo Cadastrado com sucesso!",controle.cadastrarGrupo("Grupo 1", null));
    }

    @Test
    public void testCadastrarGrupoComRestricao() {
        assertEquals("Grupo Cadastrado com sucesso!",controle.cadastrarGrupo("Grupo 2", 2));
    }

    @Test
    public void testCadastrarGrupoExistente() {
        controle.cadastrarGrupo("Listas", null);
        assertThrows(IllegalArgumentException.class, () -> controle.cadastrarGrupo("Listas",null));
    }

    @Test
    public void testAlocarAluno() {
        controle.cadastrarGrupo("Programação OO", null);
        assertEquals("Aluno Alocado com sucesso!", controle.alocarAluno("200", "Programação OO"));
        assertEquals("Aluno Alocado com sucesso!", controle.alocarAluno("202", "Programação OO"));
    }

    @Test
    public void testAlocarAlunoJaAlocado() {
        controle.cadastrarGrupo("Programação OO", null);
        assertEquals("Aluno Alocado com sucesso!", controle.alocarAluno("200", "Programação OO"));
        assertThrows(IllegalArgumentException.class, () -> controle.alocarAluno("200", "Programação OO"));
    }

    @Test
    public void testAlocarAlunoInexistente() {
        controle.cadastrarGrupo("Programação OO", null);
        assertThrows(IllegalArgumentException.class, () -> controle.alocarAluno("100", "Programação OO"));
    }

    @Test
    public void testAlocarAlunoGrupoInexistente() {
        assertThrows(IllegalArgumentException.class, () -> controle.alocarAluno("200", "Programação OO"));
    }

    @Test
    public void testAlocarAlunoGrupoCheio() {
        controle.cadastrarGrupo("Programação OO", 1);
        controle.alocarAluno("200", "Programação OO");
        assertThrows(IllegalArgumentException.class, () -> controle.alocarAluno("202", "Programação OO"));
    }

    @Test
    public void testPertinenciaGrupo() {
        controle.cadastrarGrupo("Listas", null);
        controle.alocarAluno("250", "Listas");
        assertTrue(controle.pertinenciaGrupo("250", "Listas"));
    }

    @Test
    public void testPertinenciaGrupoInexistente() {
        assertThrows(IllegalArgumentException.class, () -> controle.pertinenciaGrupo("202", "Listas"));
    }

    @Test
    public void testPertinenciaAlunoInexistente() {
        controle.cadastrarGrupo("Programação OO", null);
        assertThrows(IllegalArgumentException.class, () -> controle.pertinenciaGrupo("100", "Programação OO"));
    }

    @Test
    public void testExibirGruposDeAlunoSemGrupo() {
        assertEquals("Aluno não pertence a nenhum grupo.", controle.gruposDoAluno("202"));
    }

    @Test
    public void testExibirGruposdeAluno() {
        controle.cadastrarGrupo("Programação OO", null);
        controle.cadastrarGrupo("Listas", null);
        controle.alocarAluno("250", "Programação OO");
        controle.alocarAluno("250", "Listas");
        assertEquals("Programação OO 1/∞\nListas 1/∞\n", controle.gruposDoAluno("250"));
    }
}
