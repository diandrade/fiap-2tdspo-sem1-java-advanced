package com.fiap.tdspo.toys.application.usecase;

import com.fiap.tdspo.toys.domain.exception.CommitException;
import com.fiap.tdspo.toys.domain.exception.IdNaoEncontradoException;
import com.fiap.tdspo.toys.domain.gateway.BrinquedoGateway;

public class DeletarBrinquedoUseCase {
    private final BrinquedoGateway brinquedoGateway;

    public DeletarBrinquedoUseCase(BrinquedoGateway brinquedoGateway) {
        this.brinquedoGateway = brinquedoGateway;
    }

    public void executar(Integer id) throws IdNaoEncontradoException, CommitException {
        brinquedoGateway.buscarPorId(id);
        brinquedoGateway.deletar(id);
    }
}
