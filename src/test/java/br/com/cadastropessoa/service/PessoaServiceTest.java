package br.com.cadastropessoa.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.cadastropessoa.dao.PessoaDAO;
import br.com.cadastropessoa.entity.Pessoa;

public class PessoaServiceTest {

    private PessoaDAO pessoaDAO;
    private PessoaService pessoaService;

    @Before
    public void setUp() {
        pessoaDAO = mock(PessoaDAO.class);
        pessoaService = new PessoaService();
        pessoaService.setPessoaDAO(pessoaDAO);
    }

    @Test
    public void testAdicionarPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoaService.adicionarPessoa(pessoa);
        verify(pessoaDAO).adicionarPessoa(pessoa);
    }

    @Test
    public void testAtualizarPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoaService.atualizarPessoa(pessoa);
        verify(pessoaDAO).atualizarPessoa(pessoa);
    }

    @Test
    public void testRemoverPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoaService.removerPessoa(pessoa);
        verify(pessoaDAO).removerPessoa(pessoa);
    }

    @Test
    public void testBuscarPorId() {
        Long id = 1L;
        Pessoa pessoa = new Pessoa();
        pessoa.setId(id);
        when(pessoaDAO.buscarPorId(id)).thenReturn(pessoa);

        Pessoa result = pessoaService.buscarPorId(id);

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

        when(pessoaDAO.listarPessoas()).thenReturn(pessoas);

        List<Pessoa> result = pessoaService.listarPessoas();

        assertNotNull(result);
        assertEquals(pessoas.size(), result.size());
    }
}
