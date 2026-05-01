package com.fiap.tdspo.toys.domain.exception;

public class CommitException extends Exception {
    public CommitException() {
        super("Erro ao localizar o ID.");
    }
    public CommitException(String msg) {
        super(msg);
    }
}
