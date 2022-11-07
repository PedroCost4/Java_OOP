package test;

import Classes.*; 

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.BeforeEach;


public class contatoTest {
 
    private Contato contatoBase1;
    private Contato contatoBase2;
 
    @BeforeEach
    void preparaContatos() {
        this.contatoBase1 = new Contato("Pedro", "Costa", "6789456");
        this.contatoBase2 = new Contato("Pedro", "Costa", "8594906");
        
    }

    @Test
    void testNomeCompleto() {
       assertEquals( "Pedro Costa", this.contatoBase1.nomeCompleto());
    }

    @Test
    void testEquals() {
        assertTrue(contatoBase1.equals(contatoBase2));
    }

    @Test
    void testAddFavorito() {
        this.contatoBase1.setFavorito(true);
        assertTrue(this.contatoBase1.isFavorito());
    }

    @Test
    void testDelFalvorito() {
        this.contatoBase1.setFavorito(false);
        assertFalse(this.contatoBase1.isFavorito());
    }

    @Test
    void testToString() {
        assertEquals("Pedro Costa\n6789456", this.contatoBase1.toString());
        this.contatoBase2.setFavorito(true);
        assertEquals("❤️  Pedro Costa\n8594906", this.contatoBase2.toString());
    }

}

