package br.com.cadastropessoa.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;

import br.com.cadastropessoa.entity.Endereco;

public class EnderecoDAOTest {

    private EntityManager entityManager;
    private EnderecoDAO enderecoDAO;

    @Before
    public void setUp() {
        entityManager = mock(EntityManager.class);
        enderecoDAO = new EnderecoDAO();
        enderecoDAO.setEntityManager(entityManager);
    }

    @Test
    public void testAdicionarEndereco() {
        Endereco endereco = new Endereco();
        enderecoDAO.adicionarEndereco(endereco);
        verify(entityManager).persist(endereco);
    }

    @Test
    public void testAtualizarEndereco() {
        Endereco endereco = new Endereco();
        enderecoDAO.atualizarEndereco(endereco);
        verify(entityManager).merge(endereco);
    }

    @Test
    public void testRemoverEndereco() {
        Endereco endereco = new Endereco();
        endereco.setId(1);
        when(entityManager.contains(endereco)).thenReturn(true);
        enderecoDAO.removerEndereco(endereco);
        verify(entityManager).remove(endereco);
    }

    @Test
    public void testBuscarPorId() {
        Integer id = 1;
        Endereco endereco = new Endereco();
        endereco.setId(id);
        when(entityManager.find(Endereco.class, id)).thenReturn(endereco);

        Endereco result = enderecoDAO.buscarPorId(id);

        assertNotNull(result);
        assertEquals(id, result.getId());
    }

    @Test
    public void testListarEnderecos() {
        List<Endereco> enderecos = new ArrayList<>();
        Endereco endereco1 = new Endereco();
        endereco1.setId(1);
        Endereco endereco2 = new Endereco();
        endereco2.setId(2);
        enderecos.add(endereco1);
        enderecos.add(endereco2);
        
        @SuppressWarnings("unchecked")
		TypedQuery<Endereco> query = mock(TypedQuery.class);
        when(query.getResultList()).thenReturn(enderecos);
        when(entityManager.createQuery("SELECT e FROM Endereco e", Endereco.class)).thenReturn(query);

        List<Endereco> result = enderecoDAO.listarEnderecos();

        assertNotNull(result);
        assertEquals(enderecos.size(), result.size());
    }
}
