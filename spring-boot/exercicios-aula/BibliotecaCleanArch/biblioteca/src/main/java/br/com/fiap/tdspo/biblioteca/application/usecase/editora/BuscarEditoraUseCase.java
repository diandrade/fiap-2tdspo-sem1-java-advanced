package br.com.fiap.tdspo.biblioteca.application.usecase.editora;

import br.com.fiap.tdspo.biblioteca.domain.entity.Editora;
import br.com.fiap.tdspo.biblioteca.domain.exception.IdNaoEncontradoException;
import br.com.fiap.tdspo.biblioteca.domain.gateway.EditoraGateway;
import java.util.List;

public class BuscarEditoraUseCase {
    private final EditoraGateway editoraGateway;

    public BuscarEditoraUseCase(EditoraGateway editoraGateway) {
        this.editoraGateway = editoraGateway;
    }

    public Editora buscarPorId(Integer id) throws IdNaoEncontradoException {
        return editoraGateway.buscarPorId(id);
    }

    public List<Editora> listarTodas() {
        return editoraGateway.listarTodas();
    }
}