package br.com.fiap.tdspo.biblioteca.domain.exception;

public class IdNaoEncontradoException extends Exception {
    public IdNaoEncontradoException() {
        super("Erro ao localizar o ID");
    }

    public IdNaoEncontradoException(String msg) {
        super(msg);
    }
}