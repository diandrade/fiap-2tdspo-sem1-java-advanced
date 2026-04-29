package br.com.fiap.tdspo.biblioteca.application.usecase.livro;

import br.com.fiap.tdspo.biblioteca.domain.entity.Biblioteca;
import br.com.fiap.tdspo.biblioteca.domain.entity.Livro;
import br.com.fiap.tdspo.biblioteca.domain.exception.CommitException;
import br.com.fiap.tdspo.biblioteca.domain.exception.IdNaoEncontradoException;
import br.com.fiap.tdspo.biblioteca.domain.gateway.BibliotecaGateway;
import br.com.fiap.tdspo.biblioteca.domain.gateway.LivroGateway;
import java.util.ArrayList;
import java.util.List;

public class VincularLivrosBibliotecaUseCase {
    private final BibliotecaGateway bibliotecaGateway;
    private final LivroGateway livroGateway;

    public VincularLivrosBibliotecaUseCase(BibliotecaGateway bibliotecaGateway, LivroGateway livroGateway) {
        this.bibliotecaGateway = bibliotecaGateway;
        this.livroGateway = livroGateway;
    }

    public Biblioteca executar(Integer bibliotecaId, List<Integer> livroIds) throws IdNaoEncontradoException, CommitException {
        Biblioteca biblioteca = bibliotecaGateway.buscarPorId(bibliotecaId);
        List<Livro> livros = new ArrayList<>();
        for (Integer id : livroIds) {
            Livro livro = livroGateway.buscarPorId(id);
            livros.add(livro);
        }
        biblioteca.getLivros().clear();
        biblioteca.getLivros().addAll(livros);
        return bibliotecaGateway.salvar(biblioteca);
    }
}