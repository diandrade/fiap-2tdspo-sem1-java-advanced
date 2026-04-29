package br.com.fiap.tdspo.biblioteca.application.usecase.biblioteca;

import br.com.fiap.tdspo.biblioteca.domain.entity.Biblioteca;
import br.com.fiap.tdspo.biblioteca.domain.exception.CommitException;
import br.com.fiap.tdspo.biblioteca.domain.gateway.BibliotecaGateway;

public class CadastrarBibliotecaUseCase {
    private final BibliotecaGateway bibliotecaGateway;

    public CadastrarBibliotecaUseCase(BibliotecaGateway bibliotecaGateway) {
        this.bibliotecaGateway = bibliotecaGateway;
    }

    public Biblioteca executar(Biblioteca biblioteca) throws CommitException {
        return bibliotecaGateway.salvar(biblioteca);
    }
}