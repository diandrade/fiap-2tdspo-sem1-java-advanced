package br.com.fiap.tdspo.biblioteca.infrastructure.persistence.dao;

import br.com.fiap.tdspo.biblioteca.infrastructure.persistence.entity.BibliotecaJpaEntity;
import jakarta.persistence.EntityManager;
import java.util.List;

public class BibliotecaJpaDao extends GenericDaoImpl<BibliotecaJpaEntity, Integer> {
    public BibliotecaJpaDao(EntityManager em) {
        super(em);
    }

    public List<BibliotecaJpaEntity> listarTodos() {
        return em.createQuery("FROM BibliotecaJpaEntity", BibliotecaJpaEntity.class).getResultList();
    }
}