package br.com.cadastropessoa.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import br.com.cadastropessoa.entity.Endereco;
import br.com.cadastropessoa.entity.Pessoa;

@Stateless
public class EnderecoDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void adicionarEndereco(Endereco endereco) {
        entityManager.persist(endereco);
    }

    public Endereco atualizarEndereco(Endereco endereco) {
        return entityManager.merge(endereco);
    }

    public void removerEndereco(Endereco endereco) {
        entityManager.remove(entityManager.contains(endereco) ? endereco : entityManager.merge(endereco));
    }

    public Endereco buscarPorId(Integer id) {
        return entityManager.find(Endereco.class, id);
    }

    public List<Endereco> listarEnderecos() {
    	CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Endereco> cq = cb.createQuery(Endereco.class);
        Root<Endereco> enderecoRoot = cq.from(Endereco.class);
        cq.select(enderecoRoot);
        return entityManager.createQuery(cq).getResultList();
    }
    
    public List<Endereco> listarEnderecosPessoas() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Endereco> cq = cb.createQuery(Endereco.class);
        Root<Endereco> enderecoRoot = cq.from(Endereco.class);
        Join<Endereco, Pessoa> pessoaJoin = enderecoRoot.join("pessoas", JoinType.LEFT);
        cq.select(enderecoRoot).distinct(true);
        return entityManager.createQuery(cq).getResultList();
    }

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}
