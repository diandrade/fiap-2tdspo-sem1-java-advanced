package br.com.fiap.tdspo.biblioteca.infrastructure.gateway;

import br.com.fiap.tdspo.biblioteca.domain.entity.Biblioteca;
import br.com.fiap.tdspo.biblioteca.domain.exception.CommitException;
import br.com.fiap.tdspo.biblioteca.domain.exception.IdNaoEncontradoException;
import br.com.fiap.tdspo.biblioteca.domain.gateway.BibliotecaGateway;
import br.com.fiap.tdspo.biblioteca.infrastructure.persistence.dao.BibliotecaJpaDao;
import br.com.fiap.tdspo.biblioteca.infrastructure.persistence.entity.BibliotecaJpaEntity;
import br.com.fiap.tdspo.biblioteca.infrastructure.persistence.mapper.BibliotecaMapper;
import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

public class BibliotecaGatewayImpl implements BibliotecaGateway {
    private final BibliotecaJpaDao dao;
    private final EntityManager em;

    public BibliotecaGatewayImpl(EntityManager em) {
        this.em = em;
        this.dao = new BibliotecaJpaDao(em);
    }

    @Override
    public Biblioteca salvar(Biblioteca biblioteca) throws CommitException {
        try {
            dao.beginTransaction();
            BibliotecaJpaEntity entity = BibliotecaMapper.toJpaEntity(biblioteca);
            BibliotecaJpaEntity saved = dao.salvar(entity);
            dao.commit();

            return BibliotecaMapper.toDomain(saved);
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new CommitException("Erro ao salvar biblioteca: " + e.getMessage());
        }
    }

    @Override
    public Biblioteca buscarPorId(Integer id) throws IdNaoEncontradoException {
        BibliotecaJpaEntity entity = dao.buscar(id);
        return BibliotecaMapper.toDomain(entity);
    }

    @Override
    public List<Biblioteca> listarTodas() {
        return dao.listarTodos().stream()
                .map(BibliotecaMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deletar(Integer id) throws IdNaoEncontradoException, CommitException {
        try {
            dao.beginTransaction();
            dao.remover(id);
            dao.commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new CommitException("Erro ao deletar: " + e.getMessage());
        }
    }
}