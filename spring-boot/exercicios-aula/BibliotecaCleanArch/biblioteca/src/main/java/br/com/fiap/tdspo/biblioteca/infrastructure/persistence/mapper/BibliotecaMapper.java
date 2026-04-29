package br.com.fiap.tdspo.biblioteca.infrastructure.persistence.mapper;

import br.com.fiap.tdspo.biblioteca.domain.entity.Biblioteca;
import br.com.fiap.tdspo.biblioteca.infrastructure.persistence.entity.BibliotecaJpaEntity;

import java.util.stream.Collectors;

public class BibliotecaMapper {
    public static BibliotecaJpaEntity toJpaEntity(Biblioteca domain) {
        if (domain == null) return null;
        BibliotecaJpaEntity entity = new BibliotecaJpaEntity();
        entity.setCodigo(domain.getCodigo());
        entity.setNome(domain.getNome());
        entity.setDataAbertura(domain.getDataAbertura());
        entity.setEndereco(EnderecoMapper.toJpaEntity(domain.getEndereco()));
        if (domain.getLivros() != null && !domain.getLivros().isEmpty()) {
            entity.setLivros(domain.getLivros().stream()
                    .map(LivroMapper::toJpaEntity)
                    .collect(Collectors.toList()));
        }
        return entity;
    }

    public static Biblioteca toDomain(BibliotecaJpaEntity entity) {
        if (entity == null) return null;
        Biblioteca biblioteca = new Biblioteca(
                entity.getCodigo(),
                entity.getNome(),
                entity.getDataAbertura(),
                EnderecoMapper.toDomain(entity.getEndereco())
        );
        if (entity.getLivros() != null && !entity.getLivros().isEmpty()) {
            biblioteca.setLivros(entity.getLivros().stream()
                    .map(LivroMapper::toDomain)
                    .collect(Collectors.toList()));
        }
        return biblioteca;
    }
}