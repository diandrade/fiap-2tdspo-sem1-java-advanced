package br.com.fiap.tdspo.biblioteca.domain.gateway;

import br.com.fiap.tdspo.biblioteca.domain.entity.Livro;
import br.com.fiap.tdspo.biblioteca.domain.exception.IdNaoEncontradoException;
import br.com.fiap.tdspo.biblioteca.domain.exception.CommitException;
import java.util.List;

public interface LivroGateway {
    Livro salvar(Livro livro) throws CommitException;
    Livro buscarPorId(Integer id) throws IdNaoEncontradoException;
    List<Livro> listarTodos();
    void deletar(Integer id) throws IdNaoEncontradoException, CommitException;
}