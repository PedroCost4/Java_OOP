package tests;

import main.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;

public class LULATestsExceptions {
    private LULA lula;
    private Throwable exception;
    
    @BeforeEach
    public void setUp() {
        lula = new LULA();
    }

    @Test
    public void testCadastraLocalJaExistente() {
        exception = assertThrows(IllegalArgumentException.class, () -> {
            lula.cadastraLocal("BG", "Sala de Reuniões", "1234");
            lula.cadastraLocal("BG", "Sala de Reuniões", "1234");
        });
        assertEquals("Local já cadastrado", exception.getMessage());
    }

    @Test
    public void testCadastraComitivaJaExistente() {
        exception = assertThrows(IllegalArgumentException.class, () -> {
            lula.cadastraComitiva(0, "Comitiva 1", 10, "1234");
            lula.cadastraComitiva(0, "Comitiva 1", 10, "1234");
        });
        assertEquals("Comitiva já cadastrada", exception.getMessage());
    }

    @Test
    public void testCadastraComitivaIdInvalido() {
        exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            lula.cadastraComitiva(100, "Comitiva 1", 10, "1234");
        });
        assertEquals("ID inválido", exception.getMessage());
    }

    @Test
    public void testCadastraComitivaDescricaoInvalida() {
        exception = assertThrows(IllegalArgumentException.class, () -> {
            lula.cadastraComitiva(0, "", 10, "1234");
        });
        assertEquals("Descrição ou contato inválidos", exception.getMessage());
    }

    @Test
    public void testCadastraComitivaContatoInvalido() {
        exception = assertThrows(IllegalArgumentException.class, () -> {
            lula.cadastraComitiva(0, "Comitiva 1", 10, "   ");
        });
        assertEquals("Descrição ou contato inválidos", exception.getMessage());
    }

    @Test
    public void testCadastraComitivaIntegrantesInvalidos() {
        exception = assertThrows(IllegalArgumentException.class, () -> {
            lula.cadastraComitiva(0, "Comitiva 1", -5, "1234");
        });
        assertEquals("Número de integrantes inválido", exception.getMessage());
    }

    @Test
    public void testCadastraLocalDescricaoInvalida() {
        exception = assertThrows(IllegalArgumentException.class, () -> {
            lula.cadastraLocal("BG", "", "1234");
        });
        assertEquals("Local ou ramal inválidos", exception.getMessage());
    }

    @Test
    public void testCadastraLocalRamalInvalido() {
        exception = assertThrows(IllegalArgumentException.class, () -> {
            lula.cadastraLocal("BG", "Sala de Reuniões", "   ");
        });
        assertEquals("Local ou ramal inválidos", exception.getMessage());
    }

   
}
