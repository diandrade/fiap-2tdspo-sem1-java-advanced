package br.com.fiap.ProgramaBibliotecaV3.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import br.com.fiap.ProgramaBibliotecaV3.dao.*;
import br.com.fiap.ProgramaBibliotecaV3.entity.Biblioteca;
import br.com.fiap.ProgramaBibliotecaV3.entity.Editora;
import br.com.fiap.ProgramaBibliotecaV3.entity.Endereco;
import br.com.fiap.ProgramaBibliotecaV3.entity.Livro;
import br.com.fiap.ProgramaBibliotecaV3.exception.CommitException;
import br.com.fiap.ProgramaBibliotecaV3.singleton.EntityManagerFactorySingleton;
import jakarta.persistence.EntityManager;

public class ExemploCadastro {

    public static void main(String[] args) {
        //Instanciar um Entity Manager
        EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
        //Instanciar um EnderecoDao
        EnderecoDao enderecoDao = new EnderecoDaoImpl(em);
        //Instaciar uma BibliotecaDao
        BibliotecaDao bibliotecaDao = new BibliotecaDaoImpl(em);
        //Instanciar um Endereco
        Endereco enderecoCalmo = new Endereco("Av Lins de Vasconcelos, 1234", "12345-67");
        //Instanciar uma Biblioteca
        Biblioteca b = new Biblioteca("FIAP Tranquila",
                new GregorianCalendar(1950, Calendar.JANUARY, 20), enderecoCalmo);

        try {
            //Cadastrar a Biblioteca
            bibliotecaDao.salvar(b);
            bibliotecaDao.commit();
        } catch (CommitException e) {
            e.printStackTrace();
        }

        //Cadastrar um livro e uma editora
        //Instanciar 2 livros
        Livro cosmos = new Livro("Cosmos Tranquilo", 520);
        Livro harry = new Livro("Harry Potter e a Tranquilidade", 1000);

        //Instanciar a Editora
        Editora editora = new Editora("Calma e Tranquilidade");

        editora.addLivro(cosmos);
        editora.addLivro(harry);

        //Cadastrar a editora e os livros em cascata
        EditoraDao editoraDao = new EditoraDaoImpl(em);
        try {
            editoraDao.salvar(editora);
            editoraDao.commit();
            System.out.println("Editora e livros cadastrados!");
        }catch(CommitException e) {
            System.err.println(e.getMessage());
        }

        //Cadastrar a relação N:M
        List<Livro> livros = new ArrayList<Livro>();
        livros.add(harry);
        livros.add(cosmos);

        b.setLivros(livros);

        try {
            bibliotecaDao.salvar(b);
            bibliotecaDao.commit();
            System.out.println("Deu certo!");
        } catch (CommitException e) {
            System.out.println(e.getMessage());
        }

    }//main
}//class
