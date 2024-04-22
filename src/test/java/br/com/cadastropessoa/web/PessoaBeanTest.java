package br.com.cadastropessoa.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.cadastropessoa.entity.Pessoa;
import br.com.cadastropessoa.service.PessoaService;

public class PessoaBeanTest {

    private PessoaService pessoaService;
    private PessoaBean pessoaBean;

    @Before
    public void setUp() {
        pessoaService = mock(PessoaService.class);
        pessoaBean = new PessoaBean();
        pessoaBean.setPessoaService(pessoaService);
    }

    @Test
    public void testGetPessoas() {
        List<Pessoa> pessoas = new ArrayList<>();
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setId(1L);
        Pessoa pessoa2 = new Pessoa();
        pessoa2.setId(2L);
        pessoas.add(pessoa1);
        pessoas.add(pessoa2);
        
        when(pessoaService.listarPessoas()).thenReturn(pessoas);

        List<Pessoa> result = pessoaBean.getPessoas();

        assertNotNull(result);
        assertEquals(pessoas.size(), result.size());
    }

    @Test
    public void testAdicionarPessoa() {
        Pessoa novaPessoa = new Pessoa();
        pessoaBean.setNovaPessoa(novaPessoa);

        pessoaBean.adicionarPessoa();

        verify(pessoaService).adicionarPessoa(novaPessoa);
    }

    @Test
    public void testExcluirPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1L);
        pessoaBean.setPessoaSelecionada(pessoa);

        pessoaBean.excluirPessoa(pessoa);

        verify(pessoaService).removerPessoa(pessoa);
    }

    @Test
    public void testAtualizarPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1L);
        pessoaBean.setPessoaSelecionada(pessoa);

        pessoaBean.atualizarPessoa();

        verify(pessoaService).atualizarPessoa(pessoa);
    }

}
