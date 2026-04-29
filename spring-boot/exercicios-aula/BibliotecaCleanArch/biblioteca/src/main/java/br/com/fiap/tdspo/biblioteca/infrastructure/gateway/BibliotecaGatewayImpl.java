package br.com.fiap.tdspo.biblioteca.infrastructure.gateway;

import br.com.fiap.tdspo.biblioteca.domain.entity.Biblioteca;
import br.com.fiap.tdspo.biblioteca.domain.exception.CommitException;
import br.com.fiap.tdspo.biblioteca.domain.exception.IdNaoEncontradoException;
import br.com.fiap.tdspo.biblioteca.domain.gateway.BibliotecaGateway;
import br.com.fiap.tdspo.biblioteca.infrastructure.persistence.dao.BibliotecaJpaDao;
import br.com.fiap.tdspo.biblioteca.infrastructure.persistence.entity.BibliotecaJpaEntity;
import br.com.fiap.tdspo.biblioteca.infrastructure.persistence.mapper.BibliotecaMapper;
import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

public class BibliotecaGatewayImpl implements BibliotecaGateway {
    private BibliotecaJpaDao bibliotecaDao;
    private EntityManager em;

    public BibliotecaGatewayImpl(EntityManager em) {
        this.em = em;
        this.bibliotecaDao = new BibliotecaJpaDao(em);
    }

    @Override
    public Biblioteca salvar(Biblioteca biblioteca) throws CommitException {
        try {
            BibliotecaJpaEntity entity = BibliotecaMapper.toJpaEntity(biblioteca);
            if (entity.getEndereco() != null && entity.getEndereco().getCodigo() != null) {
                entity.setEndereco(em.find(br.com.fiap.tdspo.biblioteca.infrastructure.persistence.entity.EnderecoJpaEntity.class, entity.getEndereco().getCodigo()));
            }
            if (entity.getLivros() != null && !entity.getLivros().isEmpty()) {
                List<br.com.fiap.tdspo.biblioteca.infrastructure.persistence.entity.LivroJpaEntity> managedLivros = new java.util.ArrayList<>();
                for (br.com.fiap.tdspo.biblioteca.infrastructure.persistence.entity.LivroJpaEntity livro : entity.getLivros()) {
                    if (livro.getCodigo() != null) {
                        br.com.fiap.tdspo.biblioteca.infrastructure.persistence.entity.LivroJpaEntity managedLivro = em.find(
                                br.com.fiap.tdspo.biblioteca.infrastructure.persistence.entity.LivroJpaEntity.class,
                                livro.getCodigo()
                        );
                        if (managedLivro != null) {
                            managedLivros.add(managedLivro);
                        }
                    }
                }
                entity.setLivros(managedLivros);
            }
            BibliotecaJpaEntity saved = bibliotecaDao.salvar(entity);
            return BibliotecaMapper.toDomain(saved);
        } catch (Exception e) {
            throw new CommitException("Erro ao salvar biblioteca: " + e.getMessage());
        }
    }

    @Override
    public Biblioteca buscarPorId(Integer id) throws IdNaoEncontradoException {
        BibliotecaJpaEntity entity = bibliotecaDao.buscar(id);
        return BibliotecaMapper.toDomain(entity);
    }

    @Override
    public List<Biblioteca> listarTodas() {
        return bibliotecaDao.listarTodos().stream()
                .map(BibliotecaMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deletar(Integer id) throws IdNaoEncontradoException, CommitException {
        bibliotecaDao.remover(id);
    }
}