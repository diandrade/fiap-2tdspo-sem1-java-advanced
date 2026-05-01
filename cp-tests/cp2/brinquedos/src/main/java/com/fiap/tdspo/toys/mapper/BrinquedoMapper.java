package com.fiap.tdspo.toys.mapper;

import com.fiap.tdspo.toys.api.dto.request.BrinquedoRequestDTO;
import com.fiap.tdspo.toys.api.dto.response.BrinquedoResponseDTO;
import com.fiap.tdspo.toys.domain.model.Brinquedo;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BrinquedoMapper {
    public Brinquedo toEntity(BrinquedoRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        Brinquedo brinquedo = new Brinquedo();
        brinquedo.setNome(dto.getNome());
        brinquedo.setTipo(dto.getTipo());
        brinquedo.setClassificacao(dto.getClassificacao());
        brinquedo.setTamanho(dto.getTamanho());
        brinquedo.setPreco(dto.getPreco());

        return brinquedo;
    }

    public BrinquedoResponseDTO toResponseDTO(Brinquedo brinquedo) {
        if (brinquedo == null) {
            return null;
        }

        return new BrinquedoResponseDTO(
                brinquedo.getId(),
                brinquedo.getNome(),
                brinquedo.getTipo(),
                brinquedo.getClassificacao(),
                brinquedo.getTamanho(),
                brinquedo.getPreco()
        );
    }

    public void updateEntityFromDTO(Brinquedo brinquedo, BrinquedoRequestDTO dto) {
        if (brinquedo == null || dto == null) {
            return;
        }

        brinquedo.setNome(dto.getNome());
        brinquedo.setTipo(dto.getTipo());
        brinquedo.setClassificacao(dto.getClassificacao());
        brinquedo.setTamanho(dto.getTamanho());
        brinquedo.setPreco(dto.getPreco());
    }

    public List<BrinquedoResponseDTO> toResponseDTOList(List<Brinquedo> brinquedos) {
        if (brinquedos == null) {
            return null;
        }

        return brinquedos.stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }
}