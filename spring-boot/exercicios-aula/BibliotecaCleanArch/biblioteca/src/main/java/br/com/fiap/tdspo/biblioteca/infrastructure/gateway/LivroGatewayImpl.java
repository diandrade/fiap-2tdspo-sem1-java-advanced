package br.com.fiap.tdspo.biblioteca.infrastructure.gateway;

import br.com.fiap.tdspo.biblioteca.domain.entity.Livro;
import br.com.fiap.tdspo.biblioteca.domain.exception.CommitException;
import br.com.fiap.tdspo.biblioteca.domain.exception.IdNaoEncontradoException;
import br.com.fiap.tdspo.biblioteca.domain.gateway.LivroGateway;
import br.com.fiap.tdspo.biblioteca.infrastructure.persistence.dao.LivroJpaDao;
import br.com.fiap.tdspo.biblioteca.infrastructure.persistence.entity.LivroJpaEntity;
import br.com.fiap.tdspo.biblioteca.infrastructure.persistence.mapper.LivroMapper;
import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

public class LivroGatewayImpl implements LivroGateway {
    private LivroJpaDao livroDao;
    private EntityManager em;

    public LivroGatewayImpl(EntityManager em) {
        this.em = em;
        this.livroDao = new LivroJpaDao(em);
    }

    @Override
    public Livro salvar(Livro livro) throws CommitException {
        LivroJpaEntity entity = LivroMapper.toJpaEntity(livro);
        if (entity.getEditora() != null && entity.getEditora().getCodigo() != null) {
            entity.setEditora(em.find(br.com.fiap.tdspo.biblioteca.infrastructure.persistence.entity.EditoraJpaEntity.class, entity.getEditora().getCodigo()));
        }
        LivroJpaEntity saved = livroDao.salvar(entity);
        return LivroMapper.toDomain(saved);
    }

    @Override
    public Livro buscarPorId(Integer id) throws IdNaoEncontradoException {
        LivroJpaEntity entity = livroDao.buscar(id);
        return LivroMapper.toDomain(entity);
    }

    @Override
    public List<Livro> listarTodos() {
        return livroDao.listarTodos().stream()
                .map(LivroMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deletar(Integer id) throws IdNaoEncontradoException, CommitException {
        livroDao.remover(id);
    }
}