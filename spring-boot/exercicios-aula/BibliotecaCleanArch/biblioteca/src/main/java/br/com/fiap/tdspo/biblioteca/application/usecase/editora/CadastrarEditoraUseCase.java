package br.com.fiap.tdspo.biblioteca.application.usecase.editora;

import br.com.fiap.tdspo.biblioteca.domain.entity.Editora;
import br.com.fiap.tdspo.biblioteca.domain.exception.CommitException;
import br.com.fiap.tdspo.biblioteca.domain.gateway.EditoraGateway;

public class CadastrarEditoraUseCase {
    private final EditoraGateway editoraGateway;

    public CadastrarEditoraUseCase(EditoraGateway editoraGateway) {
        this.editoraGateway = editoraGateway;
    }

    public Editora executar(Editora editora) throws CommitException {
        return editoraGateway.salvar(editora);
    }
}