package br.com.cadastropessoa.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.cadastropessoa.entity.Endereco;

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
        TypedQuery<Endereco> query = entityManager.createQuery("SELECT e FROM Endereco e", Endereco.class);
        return query.getResultList();
    }

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}
