package br.com.fiap.tdspo.biblioteca.application.usecase.biblioteca;

import br.com.fiap.tdspo.biblioteca.domain.entity.Biblioteca;
import br.com.fiap.tdspo.biblioteca.domain.exception.IdNaoEncontradoException;
import br.com.fiap.tdspo.biblioteca.domain.gateway.BibliotecaGateway;
import java.util.List;

public class BuscarBibliotecaUseCase {
    private final BibliotecaGateway bibliotecaGateway;

    public BuscarBibliotecaUseCase(BibliotecaGateway bibliotecaGateway) {
        this.bibliotecaGateway = bibliotecaGateway;
    }

    public Biblioteca buscarPorId(Integer id) throws IdNaoEncontradoException {
        return bibliotecaGateway.buscarPorId(id);
    }

    public List<Biblioteca> listarTodas() {
        return bibliotecaGateway.listarTodas();
    }
}