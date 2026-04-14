package fiap.spring.biblioteca;

import java.time.temporal.Temporal;
import java.util.Calendar;
import java.util.List;

public class Biblioteca {
    private Integer codigo;
    private String nome;
    @Temporal(TemporalType.DATE)
    private Calendar dataAbertura;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "cd_endereco", nullable = false)
    private Endereco endereco;
    private List<Livro> livros;

    public Biblioteca() {

    }

    //TODO: Construir Construtor com todos os atributos
}
