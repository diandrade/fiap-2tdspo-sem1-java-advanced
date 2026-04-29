package br.com.fiap.tdspo.biblioteca.application.usecase.livro;

import br.com.fiap.tdspo.biblioteca.domain.entity.Livro;
import br.com.fiap.tdspo.biblioteca.domain.exception.IdNaoEncontradoException;
import br.com.fiap.tdspo.biblioteca.domain.gateway.LivroGateway;
import java.util.List;

public class BuscarLivroUseCase {
    private final LivroGateway livroGateway;

    public BuscarLivroUseCase(LivroGateway livroGateway) {
        this.livroGateway = livroGateway;
    }

    public Livro buscarPorId(Integer id) throws IdNaoEncontradoException {
        return livroGateway.buscarPorId(id);
    }

    public List<Livro> listarTodos() {
        return livroGateway.listarTodos();
    }
}