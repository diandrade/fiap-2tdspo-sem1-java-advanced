package br.com.fiap.tdspo.biblioteca.infrastructure.persistence.mapper;

import br.com.fiap.tdspo.biblioteca.domain.entity.Endereco;
import br.com.fiap.tdspo.biblioteca.infrastructure.persistence.entity.EnderecoJpaEntity;

public class EnderecoMapper {
    public static EnderecoJpaEntity toJpaEntity(Endereco domain) {
        if (domain == null) return null;
        EnderecoJpaEntity entity = new EnderecoJpaEntity();
        entity.setCodigo(domain.getCodigo());
        entity.setLogradouro(domain.getLogradouro());
        entity.setCep(domain.getCep());
        return entity;
    }

    public static Endereco toDomain(EnderecoJpaEntity entity) {
        if (entity == null) return null;
        return new Endereco(entity.getCodigo(), entity.getLogradouro(), entity.getCep());
    }
}