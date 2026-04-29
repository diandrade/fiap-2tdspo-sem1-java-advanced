package br.com.fiap.tdspo.biblioteca.infrastructure.persistence.dao;

import br.com.fiap.tdspo.biblioteca.domain.exception.CommitException;
import br.com.fiap.tdspo.biblioteca.domain.exception.IdNaoEncontradoException;

public interface GenericDao<T, K> {
    T salvar(T entidade);
    void remover(K id) throws IdNaoEncontradoException;
    T buscar(K id) throws IdNaoEncontradoException;
    void commit() throws CommitException;
}