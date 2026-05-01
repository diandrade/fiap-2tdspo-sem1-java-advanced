package com.fiap.tdspo.toys.application.usecase;

import com.fiap.tdspo.toys.domain.entity.Brinquedo;
import com.fiap.tdspo.toys.domain.exception.IdNaoEncontradoException;
import com.fiap.tdspo.toys.domain.gateway.BrinquedoGateway;

import java.util.List;

public class BuscarBrinquedoUseCase {
    private final BrinquedoGateway brinquedoGateway;

    public BuscarBrinquedoUseCase(BrinquedoGateway brinquedoGateway) {
        this.brinquedoGateway = brinquedoGateway;
    }

    public Brinquedo buscarPorId(Integer id) throws IdNaoEncontradoException {
        return brinquedoGateway.buscarPorId(id);
    }

    public List<Brinquedo> listarTodas() {
        return brinquedoGateway.listarTodas();
    }
}
