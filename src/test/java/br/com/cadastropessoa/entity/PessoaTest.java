package br.com.cadastropessoa.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class PessoaTest {

    private Pessoa pessoa1;
    private Pessoa pessoa2;

    @Before
    public void setUp() {
        pessoa1 = new Pessoa(1L, "João", 30, "Masculino");
        pessoa2 = new Pessoa(2L, "Maria", 25, "Feminino");
    }

    @Test
    public void testGettersAndSetters() {
        assertEquals(Long.valueOf(1), pessoa1.getId());
        assertEquals("João", pessoa1.getNome());
        assertEquals(Integer.valueOf(30), pessoa1.getIdade());
        assertEquals("Masculino", pessoa1.getSexo());

        pessoa1.setIdade(35);
        pessoa1.setNome("José");
        pessoa1.setSexo("Outro");
        pessoa1.setId(3L);

        assertEquals(Long.valueOf(3), pessoa1.getId());
        assertEquals("José", pessoa1.getNome());
        assertEquals(Integer.valueOf(35), pessoa1.getIdade());
        assertEquals("Outro", pessoa1.getSexo());
    }

    @Test
    public void testEquals() {
        Pessoa pessoa3 = new Pessoa(1L, "João", 30, "Masculino");
        assertTrue(pessoa1.equals(pessoa3));
        assertTrue(pessoa3.equals(pessoa1));

        assertFalse(pessoa1.equals(pessoa2));
        assertFalse(pessoa2.equals(pessoa1));

        assertTrue(pessoa1.equals(pessoa1));
    }

    @Test
    public void testHashCode() {
        assertEquals(pessoa1.hashCode(), pessoa1.hashCode());

        Pessoa pessoa3 = new Pessoa(1L, "João", 30, "Masculino");
        assertEquals(pessoa1.hashCode(), pessoa3.hashCode());

        assertFalse(pessoa1.hashCode() == pessoa2.hashCode());
    }
}
