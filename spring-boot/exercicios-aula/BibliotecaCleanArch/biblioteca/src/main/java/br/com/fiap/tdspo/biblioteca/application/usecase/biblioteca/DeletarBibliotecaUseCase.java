package br.com.fiap.tdspo.biblioteca.application.usecase.biblioteca;

import br.com.fiap.tdspo.biblioteca.domain.exception.CommitException;
import br.com.fiap.tdspo.biblioteca.domain.exception.IdNaoEncontradoException;
import br.com.fiap.tdspo.biblioteca.domain.gateway.BibliotecaGateway;

public class DeletarBibliotecaUseCase {
    private final BibliotecaGateway bibliotecaGateway;

    public DeletarBibliotecaUseCase(BibliotecaGateway bibliotecaGateway) {
        this.bibliotecaGateway = bibliotecaGateway;
    }

    public void executar(Integer id) throws IdNaoEncontradoException, CommitException {
        bibliotecaGateway.buscarPorId(id);
        bibliotecaGateway.deletar(id);
    }
}