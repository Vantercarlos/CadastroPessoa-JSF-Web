package br.com.cadastropessoa.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.cadastropessoa.dao.PessoaDAO;
import br.com.cadastropessoa.entity.Pessoa;

@Stateless
public class PessoaService {
	
	 	@Inject
	    private PessoaDAO pessoaDAO;

	    public void adicionarPessoa(Pessoa pessoa) {
	        pessoaDAO.adicionarPessoa(pessoa);
	    }

	    public Pessoa atualizarPessoa(Pessoa pessoa) {
	        return pessoaDAO.atualizarPessoa(pessoa);
	    }

	    public void removerPessoa(Pessoa pessoa) {
	        pessoaDAO.removerPessoa(pessoa);
	    }

	    public Pessoa buscarPorId(Long id) {
	        return pessoaDAO.buscarPorId(id);
	    }

	    public List<Pessoa> listarPessoas() {
	        return pessoaDAO.listarPessoas();
	    }

		public void setPessoaDAO(PessoaDAO pessoaDAO) {
			this.pessoaDAO = pessoaDAO;
		}
}
