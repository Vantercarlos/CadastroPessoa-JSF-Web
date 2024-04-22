package br.com.cadastropessoa.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;

import br.com.cadastropessoa.entity.Pessoa;

public class PessoaDAOTest {
	
	private EntityManager entityManager;
    private PessoaDAO pessoaDAO;

    @Before
    public void setUp() {
        entityManager = mock(EntityManager.class);
        pessoaDAO = new PessoaDAO();
        pessoaDAO.setEntityManager(entityManager);
    }

    @Test
    public void testAdicionarPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoaDAO.adicionarPessoa(pessoa);
        verify(entityManager).persist(pessoa);
    }

    @Test
    public void testAtualizarPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoaDAO.atualizarPessoa(pessoa);
        verify(entityManager).merge(pessoa);
    }

    @Test
    public void testRemoverPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoaDAO.removerPessoa(pessoa);
        verify(entityManager).remove(any());
    }

    @Test
    public void testBuscarPorId() {
        Long id = 1L;
        Pessoa pessoa = new Pessoa();
        pessoa.setId(id);
        when(entityManager.find(Pessoa.class, id)).thenReturn(pessoa);

        Pessoa result = pessoaDAO.buscarPorId(id);

        assertNotNull(result);
        assertEquals(id, result.getId());
    }

    @Test
    public void testListarPessoas() {
        List<Pessoa> pessoas = new ArrayList<>();
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setId(1L);
        Pessoa pessoa2 = new Pessoa();
        pessoa2.setId(2L);
        pessoas.add(pessoa1);
        pessoas.add(pessoa2);
        
        @SuppressWarnings("unchecked")
		TypedQuery<Pessoa> query = mock(TypedQuery.class);   
        when(query.getResultList()).thenReturn(pessoas);
        when(entityManager.createQuery("SELECT p FROM Pessoa p", Pessoa.class)).thenReturn(query);
        List<Pessoa> result = pessoaDAO.listarPessoas();
        assertNotNull(result);
        assertEquals(pessoas.size(), result.size());
    }
}
