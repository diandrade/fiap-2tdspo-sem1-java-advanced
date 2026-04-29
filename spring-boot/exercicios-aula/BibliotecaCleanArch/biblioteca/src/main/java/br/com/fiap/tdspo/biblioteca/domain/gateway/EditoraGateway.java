package br.com.fiap.tdspo.biblioteca.domain.gateway;

import br.com.fiap.tdspo.biblioteca.domain.entity.Editora;
import br.com.fiap.tdspo.biblioteca.domain.exception.IdNaoEncontradoException;
import br.com.fiap.tdspo.biblioteca.domain.exception.CommitException;
import java.util.List;

public interface EditoraGateway {
    Editora salvar(Editora editora) throws CommitException;
    Editora buscarPorId(Integer id) throws IdNaoEncontradoException;
    List<Editora> listarTodas();
    void deletar(Integer id) throws IdNaoEncontradoException, CommitException;
}