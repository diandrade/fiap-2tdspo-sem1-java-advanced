package br.com.fiap.tdspo.biblioteca.domain.gateway;

import br.com.fiap.tdspo.biblioteca.domain.entity.Endereco;
import br.com.fiap.tdspo.biblioteca.domain.exception.IdNaoEncontradoException;
import br.com.fiap.tdspo.biblioteca.domain.exception.CommitException;

public interface EnderecoGateway {
    Endereco salvar(Endereco endereco) throws CommitException;
    Endereco buscarPorId(Integer id) throws IdNaoEncontradoException;
    void deletar(Integer id) throws IdNaoEncontradoException, CommitException;
}