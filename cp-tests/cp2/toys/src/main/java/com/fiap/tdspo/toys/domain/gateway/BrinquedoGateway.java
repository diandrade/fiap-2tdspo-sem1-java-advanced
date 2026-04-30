package com.fiap.tdspo.toys.domain.gateway;

import com.fiap.tdspo.toys.domain.entity.Brinquedo;
import com.fiap.tdspo.toys.domain.exception.CommitException;
import com.fiap.tdspo.toys.domain.exception.IdNaoEncontradoException;

import java.util.List;

public interface BrinquedoGateway {
    Brinquedo salvar(Brinquedo brinquedo) throws CommitException; // Já faz INSERT e UPDATE.
    Brinquedo buscarPorId(Integer id) throws IdNaoEncontradoException;
    List<Brinquedo> listarTodas();
    void deletar(Integer id) throws IdNaoEncontradoException, CommitException;
}
