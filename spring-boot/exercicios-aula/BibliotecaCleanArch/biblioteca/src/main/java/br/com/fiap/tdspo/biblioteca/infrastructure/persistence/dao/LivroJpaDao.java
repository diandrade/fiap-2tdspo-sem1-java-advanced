package br.com.fiap.tdspo.biblioteca.infrastructure.persistence.dao;

import br.com.fiap.tdspo.biblioteca.infrastructure.persistence.entity.LivroJpaEntity;
import jakarta.persistence.EntityManager;
import java.util.List;

public class LivroJpaDao extends GenericDaoImpl<LivroJpaEntity, Integer> {
    public LivroJpaDao(EntityManager em) {
        super(em);
    }

    public List<LivroJpaEntity> listarTodos() {
        return em.createQuery("FROM LivroJpaEntity", LivroJpaEntity.class).getResultList();
    }
}