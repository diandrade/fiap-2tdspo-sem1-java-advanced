package br.com.fiap.tdspo.biblioteca.infrastructure.persistence.dao;

import br.com.fiap.tdspo.biblioteca.domain.exception.CommitException;
import br.com.fiap.tdspo.biblioteca.domain.exception.IdNaoEncontradoException;
import java.lang.reflect.ParameterizedType;
import jakarta.persistence.EntityManager;

public abstract class GenericDaoImpl<T, K> implements GenericDao<T, K> {
    protected EntityManager em;
    private Class<T> clazz;

    @SuppressWarnings("all")
    public GenericDaoImpl(EntityManager em) {
        this.em = em;
        this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public T salvar(T entidade) {
        return em.merge(entidade);
    }

    @Override
    public void remover(K id) throws IdNaoEncontradoException {
        T entidade = buscar(id);
        em.remove(entidade);
    }

    @Override
    public T buscar(K id) throws IdNaoEncontradoException {
        T entidade = em.find(clazz, id);
        if (entidade == null) {
            throw new IdNaoEncontradoException("Entidade nao encontrada com id: " + id);
        }
        return entidade;
    }

    public void commit() throws CommitException {
        try {
            if (em.getTransaction().isActive()) {
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new CommitException(e.getMessage());
        }
    }

    public void beginTransaction() {
        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }
    }
}