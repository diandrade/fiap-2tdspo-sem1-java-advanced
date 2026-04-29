package br.com.fiap.tdspo.biblioteca.application.usecase.livro;

import br.com.fiap.tdspo.biblioteca.domain.entity.Editora;
import br.com.fiap.tdspo.biblioteca.domain.entity.Livro;
import br.com.fiap.tdspo.biblioteca.domain.exception.CommitException;
import br.com.fiap.tdspo.biblioteca.domain.exception.IdNaoEncontradoException;
import br.com.fiap.tdspo.biblioteca.domain.gateway.EditoraGateway;
import br.com.fiap.tdspo.biblioteca.domain.gateway.LivroGateway;

public class CadastrarLivroUseCase {
    private final LivroGateway livroGateway;
    private final EditoraGateway editoraGateway;

    public CadastrarLivroUseCase(LivroGateway livroGateway, EditoraGateway editoraGateway) {
        this.livroGateway = livroGateway;
        this.editoraGateway = editoraGateway;
    }

    public Livro executar(Livro livro, Integer editoraId) throws IdNaoEncontradoException, CommitException {
        Editora editora = editoraGateway.buscarPorId(editoraId);
        livro.setEditora(editora);
        return livroGateway.salvar(livro);
    }
}