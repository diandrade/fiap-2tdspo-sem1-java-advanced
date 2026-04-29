package br.com.fiap.tdspo.biblioteca.infrastructure.gateway;

import br.com.fiap.tdspo.biblioteca.domain.entity.Endereco;
import br.com.fiap.tdspo.biblioteca.domain.exception.CommitException;
import br.com.fiap.tdspo.biblioteca.domain.exception.IdNaoEncontradoException;
import br.com.fiap.tdspo.biblioteca.domain.gateway.EnderecoGateway;
import br.com.fiap.tdspo.biblioteca.infrastructure.persistence.dao.EnderecoJpaDao;
import br.com.fiap.tdspo.biblioteca.infrastructure.persistence.entity.EnderecoJpaEntity;
import br.com.fiap.tdspo.biblioteca.infrastructure.persistence.mapper.EnderecoMapper;
import jakarta.persistence.EntityManager;

public class EnderecoGatewayImpl implements EnderecoGateway {
    private EnderecoJpaDao enderecoDao;

    public EnderecoGatewayImpl(EntityManager em) {
        this.enderecoDao = new EnderecoJpaDao(em);
    }

    @Override
    public Endereco salvar(Endereco endereco) throws CommitException {
        EnderecoJpaEntity entity = EnderecoMapper.toJpaEntity(endereco);
        EnderecoJpaEntity saved = enderecoDao.salvar(entity);
        return EnderecoMapper.toDomain(saved);
    }

    @Override
    public Endereco buscarPorId(Integer id) throws IdNaoEncontradoException {
        EnderecoJpaEntity entity = enderecoDao.buscar(id);
        return EnderecoMapper.toDomain(entity);
    }

    @Override
    public void deletar(Integer id) throws IdNaoEncontradoException, CommitException {
        enderecoDao.remover(id);
    }
}