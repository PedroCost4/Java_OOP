package test;

import Classes.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.BeforeEach;

public class agendaTest {
    
    private Agenda agenda;

    @BeforeEach
    void preparaAgenda() {
        agenda = new Agenda();
    }

    @Test
    void testCadastroContato() {
        agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
        assertEquals("Matheus Gaudencio\n(83) 99999-0000" , agenda.getContato(1).toString());
        agenda.cadastraContato(1, "Pedro", "Silva", "(84) 98888-1111");
        assertEquals("Pedro Silva\n(84) 98888-1111" , agenda.getContato(1).toString());
    }

    @Test
    void testCadastroContato2() {
        agenda.cadastraContato(100, "Matheus", "Gaudencio", "(83) 99999-0000");
        assertEquals("Matheus Gaudencio\n(83) 99999-0000" , agenda.getContato(100).toString());
    }

    @Test
    void testAdicionaFavorito() {
        agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
        agenda.adicionaFavorito(1, 0);
        assertTrue(agenda.getContato(1).isFavorito());
    }

    @Test
    void testRemoveContato() {
        agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
        assertEquals("Matheus Gaudencio\n(83) 99999-0000" , agenda.getContato(1).toString());
        agenda.adicionaFavorito(1, 0);
        agenda.delContato(7);
        assertEquals(null, agenda.getContato(7));
        assertEquals(null, agenda.getFavorito(0));
    }

    @Test
    void testRemoveFavorito() {
        agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
        assertEquals("Matheus Gaudencio\n(83) 99999-0000" , agenda.getContato(1).toString());
        agenda.adicionaFavorito(1, 0);
        assertTrue(agenda.getContato(1).isFavorito());
        agenda.removeFavorito(8, 1);
        assertFalse(agenda.getContato(8).isFavorito());
    }

}
