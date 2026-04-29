package br.com.fiap.tdspo.biblioteca.infrastructure.persistence.dao;

import br.com.fiap.tdspo.biblioteca.infrastructure.persistence.entity.EnderecoJpaEntity;
import jakarta.persistence.EntityManager;

public class EnderecoJpaDao extends GenericDaoImpl<EnderecoJpaEntity, Integer> {
    public EnderecoJpaDao(EntityManager em) {
        super(em);
    }
}