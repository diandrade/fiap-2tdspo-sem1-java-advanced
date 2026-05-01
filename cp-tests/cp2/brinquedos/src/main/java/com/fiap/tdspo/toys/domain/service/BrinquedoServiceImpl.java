package com.fiap.tdspo.toys.domain.service;

import com.fiap.tdspo.toys.api.dto.request.BrinquedoRequestDTO;
import com.fiap.tdspo.toys.api.dto.response.BrinquedoResponseDTO;
import com.fiap.tdspo.toys.domain.model.Brinquedo;
import com.fiap.tdspo.toys.domain.repository.BrinquedoRepository;
import com.fiap.tdspo.toys.mapper.BrinquedoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class BrinquedoServiceImpl implements BrinquedoService {

    @Autowired
    private BrinquedoRepository repository;

    @Autowired
    private BrinquedoMapper mapper;

    @Override
    public List<BrinquedoResponseDTO> listarTodos() {
        List<Brinquedo> brinquedos = repository.findAll();
        return mapper.toResponseDTOList(brinquedos);
    }

    @Override
    public BrinquedoResponseDTO buscarPorId(Long id) {
        Brinquedo brinquedo = buscarEntidadePorId(id);
        return mapper.toResponseDTO(brinquedo);
    }

    @Override
    @Transactional
    public BrinquedoResponseDTO cadastrar(BrinquedoRequestDTO dto) {
        Brinquedo brinquedo = mapper.toEntity(dto);
        Brinquedo salvo = repository.save(brinquedo);
        return mapper.toResponseDTO(salvo);
    }

    @Override
    @Transactional
    public BrinquedoResponseDTO atualizar(Long id, BrinquedoRequestDTO dto) {
        Brinquedo brinquedo = buscarEntidadePorId(id);
        mapper.updateEntityFromDTO(brinquedo, dto);
        Brinquedo atualizado = repository.save(brinquedo);
        return mapper.toResponseDTO(atualizado);
    }

    @Override
    @Transactional
    public void deletar(Long id) {
        Brinquedo brinquedo = buscarEntidadePorId(id);
        repository.delete(brinquedo);
    }

    private Brinquedo buscarEntidadePorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Brinquedo não encontrado com ID: " + id));
    }
}