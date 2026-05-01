package com.fiap.tdspo.toys.domain.service;

import com.fiap.tdspo.toys.api.dto.request.BrinquedoRequestDTO;
import com.fiap.tdspo.toys.api.dto.response.BrinquedoResponseDTO;

import java.util.List;

public interface BrinquedoService {
    List<BrinquedoResponseDTO> listarTodos();
    BrinquedoResponseDTO buscarPorId(Long id);
    BrinquedoResponseDTO cadastrar(BrinquedoRequestDTO dto);
    BrinquedoResponseDTO atualizar(Long id, BrinquedoRequestDTO dto);
    void deletar(Long id);
}