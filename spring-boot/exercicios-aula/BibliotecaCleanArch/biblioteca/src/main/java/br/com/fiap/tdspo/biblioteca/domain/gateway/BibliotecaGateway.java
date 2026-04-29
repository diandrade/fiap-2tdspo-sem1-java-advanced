package br.com.fiap.tdspo.biblioteca.domain.gateway;

import br.com.fiap.tdspo.biblioteca.domain.entity.Biblioteca;
import br.com.fiap.tdspo.biblioteca.domain.exception.IdNaoEncontradoException;
import br.com.fiap.tdspo.biblioteca.domain.exception.CommitException;
import java.util.List;

public interface BibliotecaGateway {
    Biblioteca salvar(Biblioteca biblioteca) throws CommitException;
    Biblioteca buscarPorId(Integer id) throws IdNaoEncontradoException;
    List<Biblioteca> listarTodas();
    void deletar(Integer id) throws IdNaoEncontradoException, CommitException;
}