package br.com.fiap.tdspo.biblioteca.infrastructure.persistence.dao;

import br.com.fiap.tdspo.biblioteca.infrastructure.persistence.entity.EditoraJpaEntity;
import jakarta.persistence.EntityManager;
import java.util.List;

public class EditoraJpaDao extends GenericDaoImpl<EditoraJpaEntity, Integer> {
    public EditoraJpaDao(EntityManager em) {
        super(em);
    }

    public List<EditoraJpaEntity> listarTodas() {
        return em.createQuery("FROM EditoraJpaEntity", EditoraJpaEntity.class).getResultList();
    }
}