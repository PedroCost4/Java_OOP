package test;

import Classes.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;

public class agendaExceptionTests {

    private Agenda agenda;
    private Throwable exception;

    @BeforeEach
    void preparaAgenda() {
        agenda = new Agenda();
        agenda.cadastraContato(7, "Pedro", "Costa", "(83) 99999-9999"); // para verificar se o contato já existe.
    }

    @Test
    void testCadastroExceptions() {
        exception = assertThrows(IllegalArgumentException.class, () -> {
            agenda.cadastraContato(10, "", "Emma", "98888-8888");
        });
        assertEquals("CONTATO INVALIDO", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            agenda.cadastraContato(11, "    ", "Jose", "9777-8888");
        });
        assertEquals("CONTATO INVALIDO", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            agenda.cadastraContato(7, "Pedro", "Costa", "(83) 99999-9999");
        });
        assertEquals("CONTATO JA CADASTRADO", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            agenda.cadastraContato(112, "Pedro", "Evandro", "56767867");
        });
        assertEquals("POSIÇÃO INVÁLIDA", exception.getMessage());
    }

    @Test
    void testDeleteExceptions() {
        exception = assertThrows(IllegalArgumentException.class, () -> {
            agenda.cadastraContato(10, "John", "Emma", "98888-8888");
            agenda.delContato(1001);
        });
        assertEquals("POSIÇÃO INVÁLIDA", exception.getMessage());
    }

    @Test
    void testAdicionaFavoritoException() {
        exception = assertThrows(IllegalArgumentException.class, () -> {
            agenda.adicionaFavorito(77, 5);
        });
        assertEquals("CONTATO NAO CADASTRADO", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            agenda.adicionaFavorito(2, 20);
        });
        assertEquals("POSIÇÃO INVÁLIDA", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            agenda.adicionaFavorito(7, 20);
        });
        assertEquals("POSIÇÃO INVÁLIDA", exception.getMessage());
    }

    @Test
    void testRemoveFavoritoException() {
        exception = assertThrows(IllegalArgumentException.class, () -> {
            agenda.removeFavorito(77, 5);
        });
        assertEquals("CONTATO NAO CADASTRADO", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            agenda.removeFavorito(2, 20);
        });
        assertEquals("POSIÇÃO INVÁLIDA", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            agenda.removeFavorito(105, 2);
        });
        assertEquals("POSIÇÃO INVÁLIDA", exception.getMessage());
    }
}
