package br.com.fiap.tdspo.biblioteca.infrastructure.gateway;

import br.com.fiap.tdspo.biblioteca.domain.entity.Editora;
import br.com.fiap.tdspo.biblioteca.domain.exception.CommitException;
import br.com.fiap.tdspo.biblioteca.domain.exception.IdNaoEncontradoException;
import br.com.fiap.tdspo.biblioteca.domain.gateway.EditoraGateway;
import br.com.fiap.tdspo.biblioteca.infrastructure.persistence.dao.EditoraJpaDao;
import br.com.fiap.tdspo.biblioteca.infrastructure.persistence.entity.EditoraJpaEntity;
import br.com.fiap.tdspo.biblioteca.infrastructure.persistence.mapper.EditoraMapper;
import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

public class EditoraGatewayImpl implements EditoraGateway {
    private EditoraJpaDao editoraDao;
    private EntityManager em;

    public EditoraGatewayImpl(EntityManager em) {
        this.em = em;
        this.editoraDao = new EditoraJpaDao(em);
    }

    @Override
    public Editora salvar(Editora editora) throws CommitException {
        EditoraJpaEntity entity = EditoraMapper.toJpaEntity(editora);
        EditoraJpaEntity saved = editoraDao.salvar(entity);
        editoraDao.commit();
        return EditoraMapper.toDomain(saved);
    }

    @Override
    public Editora buscarPorId(Integer id) throws IdNaoEncontradoException {
        EditoraJpaEntity entity = editoraDao.buscar(id);
        return EditoraMapper.toDomain(entity);
    }

    @Override
    public List<Editora> listarTodas() {
        return editoraDao.listarTodas().stream()
                .map(EditoraMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deletar(Integer id) throws IdNaoEncontradoException, CommitException {
        editoraDao.remover(id);
        editoraDao.commit();
    }
}