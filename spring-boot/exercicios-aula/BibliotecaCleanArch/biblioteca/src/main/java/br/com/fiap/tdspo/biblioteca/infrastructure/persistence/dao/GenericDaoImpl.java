package br.com.fiap.tdspo.biblioteca.infrastructure.persistence.dao;

import br.com.fiap.tdspo.biblioteca.domain.exception.CommitException;
import br.com.fiap.tdspo.biblioteca.domain.exception.IdNaoEncontradoException;
import java.lang.reflect.ParameterizedType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public abstract class GenericDaoImpl<T, K> implements GenericDao<T, K> {
    protected EntityManager em;
    private Class<T> clazz;

    @SuppressWarnings("all")
    public GenericDaoImpl(EntityManager em) {
        this.em = em;
        this.clazz = (Class<T>) ((ParameterizedType)
                getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public T salvar(T entidade) {
        EntityTransaction transaction = em.getTransaction();
        boolean wasActive = transaction.isActive();

        if (!wasActive) {
            transaction.begin();
        }

        try {
            T result = em.merge(entidade);
            if (!wasActive) {
                transaction.commit();
            }
            return result;
        } catch (Exception e) {
            if (!wasActive && transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    public void remover(K id) throws IdNaoEncontradoException {
        T entidade = buscar(id);
        EntityTransaction transaction = em.getTransaction();
        boolean wasActive = transaction.isActive();

        if (!wasActive) {
            transaction.begin();
        }

        try {
            em.remove(entidade);
            if (!wasActive) {
                transaction.commit();
            }
        } catch (Exception e) {
            if (!wasActive && transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

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
        } catch(Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new CommitException();
        }
    }
}