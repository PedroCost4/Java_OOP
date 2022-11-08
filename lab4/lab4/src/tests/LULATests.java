package tests;

import main.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;

public class LULATests {
    
    private LULA lula;
    
    @BeforeEach
    public void setUp() {
        lula = new LULA();
    }
    
    @Test
    public void testCadastraLocal() { 
        lula.cadastraLocal("BG", "Sala de Reuniões", "1234");
        assertEquals("BG - Sala de Reuniões - 1234", lula.getLocais()[0].toString());
    }

    @Test
    public void testCadastraComitiva() {
        lula.cadastraComitiva(0, "Comitiva 1", 10, "1234");
        assertEquals("ID: 0\nComitiva: Comitiva 1\nIntegrantes: 10\nContato: 1234", lula.getComitivas()[0].toString());
    }

    @Test
    public void testExibeLocal() {
        lula.cadastraLocal("BG", "Sala de Reuniões", "1234");
        assertEquals("BG - Sala de Reuniões - 1234", lula.exibeLocal("BG"));
    }

    @Test
    public void testExibeComitiva() {
        lula.cadastraComitiva(0, "Comitiva 1", 10, "1234");
        lula.cadastraComitiva(1, "Comitiva 2", 20, "12345");
        assertEquals("ID: 0\nComitiva: Comitiva 1\nIntegrantes: 10\nContato: 1234", lula.exibeComitiva(0));
        assertEquals("ID: 1\nComitiva: Comitiva 2\nIntegrantes: 20\nContato: 12345", lula.exibeComitiva(1));
    }

}
