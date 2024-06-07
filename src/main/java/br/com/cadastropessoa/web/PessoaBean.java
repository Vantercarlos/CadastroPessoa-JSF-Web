package br.com.cadastropessoa.web;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import br.com.cadastropessoa.entity.Pessoa;
import br.com.cadastropessoa.entity.Endereco;
import br.com.cadastropessoa.service.PessoaService;

@Named(value = "pessoaBean")
@RequestScoped
public class PessoaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private PessoaService pessoaService;

    private List<Pessoa> pessoas;
    private List<Pessoa> pessoasComEnderecos;
    private List<Endereco> enderecosComPessoas;
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

    public List<Pessoa> getPessoasComEnderecos() {
        if (pessoasComEnderecos == null) {
            atualizarListaPessoasComEnderecos();
        }
        return pessoasComEnderecos;
    }

    public void setPessoasComEnderecos(List<Pessoa> pessoasComEnderecos) {
        this.pessoasComEnderecos = pessoasComEnderecos;
    }

    public List<Endereco> getEnderecosComPessoas() {
        if (enderecosComPessoas == null) {
            atualizarListaEnderecosComPessoas();
        }
        return enderecosComPessoas;
    }

    public void setEnderecosComPessoas(List<Endereco> enderecosComPessoas) {
        this.enderecosComPessoas = enderecosComPessoas;
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

    public void atualizarListaPessoasComEnderecos() {
        pessoasComEnderecos = pessoaService.listarPessoasComEnderecos();
    }

    public void atualizarListaEnderecosComPessoas() {
        enderecosComPessoas = pessoaService.listarEnderecosComPessoas();
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
