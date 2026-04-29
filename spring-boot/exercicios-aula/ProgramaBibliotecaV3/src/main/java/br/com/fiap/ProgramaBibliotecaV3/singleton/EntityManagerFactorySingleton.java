package br.com.fiap.ProgramaBibliotecaV3.singleton;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactorySingleton {

    // 1-Atributo estatico que armazena a unica instancia
    private static EntityManagerFactory unico;

    // 2-Construtor privado // new EntityManagerFactorySingleton()
    private EntityManagerFactorySingleton() {}

    // 3-Metodo estatico que cria e retorna a instancia se necessario
    public static EntityManagerFactory getInstance() {
        if (unico == null)
            unico = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
        return unico;
    }

}
