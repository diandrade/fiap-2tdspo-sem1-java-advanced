package br.com.fiap.tdspo.biblioteca.infrastructure.persistence.mapper;

import br.com.fiap.tdspo.biblioteca.domain.entity.Livro;
import br.com.fiap.tdspo.biblioteca.domain.entity.Editora;
import br.com.fiap.tdspo.biblioteca.infrastructure.persistence.entity.LivroJpaEntity;
import br.com.fiap.tdspo.biblioteca.infrastructure.persistence.entity.EditoraJpaEntity;

public class LivroMapper {
    public static LivroJpaEntity toJpaEntity(Livro domain) {
        if (domain == null) return null;
        LivroJpaEntity entity = new LivroJpaEntity();
        entity.setCodigo(domain.getCodigo());
        entity.setTitulo(domain.getTitulo());
        entity.setNumeroPaginas(domain.getNumeroPaginas());
        if (domain.getEditora() != null && domain.getEditora().getCodigo() != null) {
            EditoraJpaEntity editoraEntity = new EditoraJpaEntity();
            editoraEntity.setCodigo(domain.getEditora().getCodigo());
            editoraEntity.setNome(domain.getEditora().getNome());
            entity.setEditora(editoraEntity);
        }
        return entity;
    }

    public static Livro toDomain(LivroJpaEntity entity) {
        if (entity == null) return null;
        Livro livro = new Livro(entity.getCodigo(), entity.getTitulo(), entity.getNumeroPaginas());
        if (entity.getEditora() != null) {
            Editora editora = new Editora(entity.getEditora().getCodigo(), entity.getEditora().getNome());
            livro.setEditora(editora);
        }
        return livro;
    }
}