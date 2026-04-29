package br.com.fiap.ProgramaBibliotecaV3.view;

import br.com.fiap.ProgramaBibliotecaV3.dao.BibliotecaDao;
import br.com.fiap.ProgramaBibliotecaV3.dao.BibliotecaDaoImpl;
import br.com.fiap.ProgramaBibliotecaV3.entity.Biblioteca;
import br.com.fiap.ProgramaBibliotecaV3.entity.Livro;
import br.com.fiap.ProgramaBibliotecaV3.exception.IdNaoEncontradoException;
import br.com.fiap.ProgramaBibliotecaV3.singleton.EntityManagerFactorySingleton;
import jakarta.persistence.EntityManager;

public class ExemploPesquisa {

    public static void main(String[] args) {
        EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
        BibliotecaDao dao = new BibliotecaDaoImpl(em);

        try {
            Biblioteca b = dao.buscar(22);
            System.out.println(b.getNome());
            System.out.println(b.getEndereco().getLogradouro());
            //Exibir os livros da biblioteca e a editora de cada livro
            for (Livro livro :b.getLivros()) {
                System.out.println(livro.getTitulo() + " " +
                        livro.getEditora().getNome());
            }

        } catch (IdNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }
}
