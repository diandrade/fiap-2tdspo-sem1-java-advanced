package br.com.fiap.tdspo.biblioteca.infrastructure.config;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactorySingleton {
    private static EntityManagerFactory unico;

    private EntityManagerFactorySingleton() {}

    public static EntityManagerFactory getInstance() {
        if (unico == null) {
            unico = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
        }
        return unico;
    }
}