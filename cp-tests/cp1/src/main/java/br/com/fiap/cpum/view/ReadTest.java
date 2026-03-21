package br.com.fiap.cpum.view;

import br.com.fiap.cpum.entity.Funcionario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ReadTest {
    static void main(String[] Args) {
        long id;

        // EM
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("FUNCIONARIO_ORACLE");
        EntityManager em = factory.createEntityManager();

        try {
            // BUSCA
            id = 5L;
            Funcionario funcionario = em.find(Funcionario.class, id);

            // IMPRESSÃO
            if (funcionario != null) {
                System.out.println("=== DADOS DO FUNCIONÁRIO ===");
                System.out.println(funcionario.imprimirInformacao());
                System.out.println("\n---------- SCRIPT SQL GERADO (LEITURA) ----------");
            } else {
                System.out.printf("Funcionário com ID %s não encontrado.", id);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            factory.close();
        }
    }
}