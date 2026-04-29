package br.com.fiap.ProgramaBibliotecaV3.dao;

import br.com.fiap.ProgramaBibliotecaV3.exception.CommitException;
import br.com.fiap.ProgramaBibliotecaV3.exception.IdNaoEncontradoException;

public interface GenericDao<T,K> {

    T salvar(T entidade);

    void remover(K id) throws IdNaoEncontradoException;

    T buscar(K id) throws IdNaoEncontradoException;

    void commit() throws CommitException;

}
