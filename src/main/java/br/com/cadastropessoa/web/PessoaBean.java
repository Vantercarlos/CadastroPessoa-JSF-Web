package br.com.cadastropessoa.web;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.cadastropessoa.entity.Pessoa;
import br.com.cadastropessoa.service.PessoaService;

@Named(value = "pessoaBean")
@ViewScoped
public class PessoaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB(beanName = "PessoaService")
    private PessoaService pessoaService;
	
	private List<Pessoa> pessoas;
    private Pessoa novaPessoa;
    private Pessoa pessoaSelecionada;
    
    public PessoaBean() {
        novaPessoa = new Pessoa();
    }

    public List<Pessoa> getPessoas() {
        if (pessoas == null) {
            atualizarListaPessoas();
        }
        return pessoas;
    }
    
    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public void adicionarPessoa() {
        pessoaService.adicionarPessoa(novaPessoa);
        novaPessoa = new Pessoa();
        atualizarListaPessoas();
    }

    public void excluirPessoa(Pessoa pessoa) {
        pessoaService.removerPessoa(pessoa);
        atualizarListaPessoas();
    }

    public void atualizarPessoa() {
        pessoaService.atualizarPessoa(pessoaSelecionada);
        atualizarListaPessoas();
    }

    public void atualizarListaPessoas() {
        pessoas = pessoaService.listarPessoas();
    }

    public Pessoa getNovaPessoa() {
        return novaPessoa;
    }

    public void setNovaPessoa(Pessoa novaPessoa) {
        this.novaPessoa = novaPessoa;
    }

    public Pessoa getPessoaSelecionada() {
        return pessoaSelecionada;
    }

    public void setPessoaSelecionada(Pessoa pessoaSelecionada) {
        this.pessoaSelecionada = pessoaSelecionada;
    }

	public void setPessoaService(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}
}
