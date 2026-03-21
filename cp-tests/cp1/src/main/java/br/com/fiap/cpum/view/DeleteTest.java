package br.com.fiap.cpum.view;

import br.com.fiap.cpum.dao.FuncionarioDAO;
import br.com.fiap.cpum.dao.FuncionarioDAOImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DeleteTest {
    static void main (String[] Args){
        // EM
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("FUNCIONARIO_ORACLE");
        EntityManager em = factory.createEntityManager();

        // DAO
        FuncionarioDAO funcionarioDAO = new FuncionarioDAOImpl(em);

        // REMOÇÃO
        System.out.println("---------- SCRIPT SQL GERADO (REMOÇÃO) ----------");
        em.getTransaction().begin();
        funcionarioDAO.remove(1L);
        funcionarioDAO.remove(2L);
        funcionarioDAO.remove(3L);
        funcionarioDAO.remove(4L);
        funcionarioDAO.remove(5L);
        funcionarioDAO.remove(6L);
        em.getTransaction().commit();
        em.close();

        // IMPRESSÃO
        System.out.println("Usuários Excluidos com sucesso.");
    }
}
