package com.fiap.tdspo.toys.application.usecase;

import com.fiap.tdspo.toys.domain.entity.Brinquedo;
import com.fiap.tdspo.toys.domain.exception.CommitException;
import com.fiap.tdspo.toys.domain.gateway.BrinquedoGateway;

public class SalvarBrinquedoUseCase {
    private final BrinquedoGateway brinquedoGateway;

    public SalvarBrinquedoUseCase(BrinquedoGateway brinquedoGateway) {
        this.brinquedoGateway = brinquedoGateway;
    }

    public Brinquedo executar(Brinquedo brinquedo) throws CommitException {
        return brinquedoGateway.salvar(brinquedo);
    }
}
