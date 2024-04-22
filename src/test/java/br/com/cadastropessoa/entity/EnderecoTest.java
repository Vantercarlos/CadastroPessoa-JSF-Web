package br.com.cadastropessoa.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class EnderecoTest {

    private Endereco endereco;

    @Before
    public void setUp() {
        endereco = new Endereco(1, "São Paulo", "São Paulo", "Rua ABC", 123, "12345-678", 1);
    }

    @Test
    public void testGettersAndSetters() {
        assertEquals(Integer.valueOf(1), endereco.getId());
        assertEquals("São Paulo", endereco.getEstado());
        assertEquals("São Paulo", endereco.getCidade());
        assertEquals("Rua ABC", endereco.getLogradouro());
        assertEquals(Integer.valueOf(123), endereco.getNumero());
        assertEquals("12345-678", endereco.getCep());
        assertEquals(Integer.valueOf(1), endereco.getId_pessoa());

        endereco.setId(2);
        endereco.setEstado("Rio de Janeiro");
        endereco.setCidade("Rio de Janeiro");
        endereco.setLogradouro("Avenida XYZ");
        endereco.setNumero(456);
        endereco.setCep("98765-432");
        endereco.setId_pessoa(2);

        assertEquals(Integer.valueOf(2), endereco.getId());
        assertEquals("Rio de Janeiro", endereco.getEstado());
        assertEquals("Rio de Janeiro", endereco.getCidade());
        assertEquals("Avenida XYZ", endereco.getLogradouro());
        assertEquals(Integer.valueOf(456), endereco.getNumero());
        assertEquals("98765-432", endereco.getCep());
        assertEquals(Integer.valueOf(2), endereco.getId_pessoa());
    }
}
