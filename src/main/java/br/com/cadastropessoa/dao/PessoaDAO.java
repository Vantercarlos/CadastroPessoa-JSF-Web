package br.com.cadastropessoa.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.cadastropessoa.entity.Pessoa;

@Stateless
public class PessoaDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void adicionarPessoa(Pessoa pessoa) {
        entityManager.persist(pessoa);
    }

    public Pessoa atualizarPessoa(Pessoa pessoa) {
        return entityManager.merge(pessoa);
    }

    public void removerPessoa(Pessoa pessoa) {
        entityManager.remove(entityManager.contains(pessoa) ? pessoa : entityManager.merge(pessoa));
    }

    public Pessoa buscarPorId(Long id) {
        return entityManager.find(Pessoa.class, id);
    }

    public List<Pessoa> listarPessoas() {
        return entityManager.createQuery("SELECT p FROM Pessoa p", Pessoa.class).getResultList();
    }


	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
		
	}

}
