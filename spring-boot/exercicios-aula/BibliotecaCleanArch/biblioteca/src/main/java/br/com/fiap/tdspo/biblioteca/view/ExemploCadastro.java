package br.com.fiap.tdspo.biblioteca.view;

import br.com.fiap.tdspo.biblioteca.application.usecase.biblioteca.CadastrarBibliotecaUseCase;
import br.com.fiap.tdspo.biblioteca.application.usecase.editora.CadastrarEditoraUseCase;
import br.com.fiap.tdspo.biblioteca.application.usecase.livro.CadastrarLivroUseCase;
import br.com.fiap.tdspo.biblioteca.application.usecase.livro.VincularLivrosBibliotecaUseCase;
import br.com.fiap.tdspo.biblioteca.domain.entity.Biblioteca;
import br.com.fiap.tdspo.biblioteca.domain.entity.Editora;
import br.com.fiap.tdspo.biblioteca.domain.entity.Endereco;
import br.com.fiap.tdspo.biblioteca.domain.entity.Livro;
import br.com.fiap.tdspo.biblioteca.domain.exception.CommitException;
import br.com.fiap.tdspo.biblioteca.domain.exception.IdNaoEncontradoException;
import br.com.fiap.tdspo.biblioteca.infrastructure.config.EntityManagerFactorySingleton;
import br.com.fiap.tdspo.biblioteca.infrastructure.gateway.BibliotecaGatewayImpl;
import br.com.fiap.tdspo.biblioteca.infrastructure.gateway.EditoraGatewayImpl;
import br.com.fiap.tdspo.biblioteca.infrastructure.gateway.EnderecoGatewayImpl;
import br.com.fiap.tdspo.biblioteca.infrastructure.gateway.LivroGatewayImpl;
import jakarta.persistence.EntityManager;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ExemploCadastro {
    public static void main(String[] args) {
        EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

        try {
            EnderecoGatewayImpl enderecoGateway = new EnderecoGatewayImpl(em);
            BibliotecaGatewayImpl bibliotecaGateway = new BibliotecaGatewayImpl(em);
            EditoraGatewayImpl editoraGateway = new EditoraGatewayImpl(em);
            LivroGatewayImpl livroGateway = new LivroGatewayImpl(em);

            CadastrarBibliotecaUseCase cadastrarBibliotecaUseCase = new CadastrarBibliotecaUseCase(bibliotecaGateway);
            CadastrarEditoraUseCase cadastrarEditoraUseCase = new CadastrarEditoraUseCase(editoraGateway);
            CadastrarLivroUseCase cadastrarLivroUseCase = new CadastrarLivroUseCase(livroGateway, editoraGateway);
            VincularLivrosBibliotecaUseCase vincularLivrosUseCase = new VincularLivrosBibliotecaUseCase(bibliotecaGateway, livroGateway);

            Endereco endereco = new Endereco("Av. Paulista, 1000", "01310100");
            Endereco enderecoSalvo = enderecoGateway.salvar(endereco);
            System.out.println("Endereco cadastrado com codigo: " + enderecoSalvo.getCodigo());

            Biblioteca biblioteca = new Biblioteca("Biblioteca Central", new GregorianCalendar(2024, Calendar.JANUARY, 15), enderecoSalvo);
            Biblioteca bibliotecaSalva = cadastrarBibliotecaUseCase.executar(biblioteca);
            System.out.println("Biblioteca cadastrada com codigo: " + bibliotecaSalva.getCodigo());

            Editora editora = new Editora("Editora TechBooks");
            Editora editoraSalva = cadastrarEditoraUseCase.executar(editora);
            System.out.println("Editora cadastrada com codigo: " + editoraSalva.getCodigo());

            Livro livro1 = new Livro("Clean Architecture", 400);
            Livro livro2 = new Livro("Domain Driven Design", 500);

            Livro livroSalvo1 = cadastrarLivroUseCase.executar(livro1, editoraSalva.getCodigo());
            Livro livroSalvo2 = cadastrarLivroUseCase.executar(livro2, editoraSalva.getCodigo());

            System.out.println("Livros cadastrados: " + livroSalvo1.getTitulo() + " e " + livroSalvo2.getTitulo());

            Biblioteca bibliotecaComLivros = vincularLivrosUseCase.executar(
                    bibliotecaSalva.getCodigo(),
                    Arrays.asList(livroSalvo1.getCodigo(), livroSalvo2.getCodigo())
            );

            System.out.println("Livros vinculados à biblioteca com sucesso!");
            System.out.println("Total de livros na biblioteca: " + bibliotecaComLivros.getLivros().size());

        } catch (CommitException e) {
            System.err.println("Erro no commit: " + e.getMessage());
        } catch (IdNaoEncontradoException e) {
            System.err.println("Entidade nao encontrada: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
            e.printStackTrace();
        } finally {
            em.close();
            EntityManagerFactorySingleton.getInstance().close();
        }
    }
}