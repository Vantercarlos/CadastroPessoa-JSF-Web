package br.com.cadastropessoa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import br.com.cadastropessoa.entity.Endereco;
import br.com.cadastropessoa.entity.Pessoa;

public class PessoaDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void adicionarPessoa(Pessoa pessoa) {
        entityManager.persist(pessoa);
    }

    @Transactional
    public Pessoa atualizarPessoa(Pessoa pessoa) {
        return entityManager.merge(pessoa);
    }

    @Transactional
    public void removerPessoa(Pessoa pessoa) {
        entityManager.remove(entityManager.merge(pessoa));
    }

    public Pessoa buscarPorId(Long id) {
        return entityManager.find(Pessoa.class, id);
    }

    public List<Pessoa> listarPessoas() {
    	CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Pessoa> cq = cb.createQuery(Pessoa.class);
        Root<Pessoa> pessoaRoot = cq.from(Pessoa.class);
        cq.select(pessoaRoot);
        return entityManager.createQuery(cq).getResultList();
    }
    
    public List<Pessoa> listaPessoasEnderecos() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Pessoa> cq = cb.createQuery(Pessoa.class);
        Root<Pessoa> pessoaRoot = cq.from(Pessoa.class);
        Join<Pessoa, Endereco> enderecoJoin = pessoaRoot.join("enderecos", JoinType.LEFT);
        cq.select(pessoaRoot).distinct(true);
        return entityManager.createQuery(cq).getResultList();
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
