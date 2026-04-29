package br.com.fiap.tdspo.biblioteca.infrastructure.persistence.mapper;

import br.com.fiap.tdspo.biblioteca.domain.entity.Editora;
import br.com.fiap.tdspo.biblioteca.domain.entity.Livro;
import br.com.fiap.tdspo.biblioteca.infrastructure.persistence.entity.EditoraJpaEntity;
import br.com.fiap.tdspo.biblioteca.infrastructure.persistence.entity.LivroJpaEntity;
import java.util.ArrayList;
import java.util.List;

public class EditoraMapper {
    public static EditoraJpaEntity toJpaEntity(Editora domain) {
        if (domain == null) return null;
        EditoraJpaEntity entity = new EditoraJpaEntity();
        entity.setCodigo(domain.getCodigo());
        entity.setNome(domain.getNome());
        return entity;
    }

    public static Editora toDomain(EditoraJpaEntity entity) {
        if (entity == null) return null;
        Editora editora = new Editora(entity.getCodigo(), entity.getNome());
        if (entity.getLivros() != null && !entity.getLivros().isEmpty()) {
            List<Livro> livros = new ArrayList<>();
            for (LivroJpaEntity livroEntity : entity.getLivros()) {
                Livro livro = new Livro(livroEntity.getCodigo(), livroEntity.getTitulo(), livroEntity.getNumeroPaginas());
                livro.setEditora(editora);
                livros.add(livro);
            }
            editora.setLivros(livros);
        }
        return editora;
    }
}