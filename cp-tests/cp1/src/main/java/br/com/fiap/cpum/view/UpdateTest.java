package br.com.fiap.cpum.view;

import br.com.fiap.cpum.entity.Funcionario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UpdateTest {
     static void main(String[] Args) {
         long id;

        // EM
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("FUNCIONARIO_ORACLE");
        EntityManager em = factory.createEntityManager();

        try {
            // BUSCA
            id = 1;
            Funcionario funcionario = em.find(Funcionario.class, id);

            if (funcionario != null) {
                System.out.println("=== DADOS ANTES DA ATUALIZAÇÃO ===");
                System.out.println(funcionario.imprimirInformacao());

                // OBJETOS ALTERADOS
                funcionario.setNome("Vinicius de Moraes");
                funcionario.setHorasTrabalhadas(48);
                funcionario.setValorHora(72);

                // ATUALIZAÇÃO
                System.out.println("\n---------- SCRIPT SQL GERADO (ATUALIZAÇÃO) ----------");
                em.getTransaction().begin();
                em.getTransaction().commit();
                em.refresh(funcionario);

                // IMPRESSÃO
                System.out.println("\n=== DADOS APÓS ATUALIZAÇÃO ===");
                System.out.println(funcionario.imprimirInformacao());
            } else {
                System.out.printf("Funcionário com ID %s não encontrado.", id);
            }

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
            factory.close();
        }
    }
}