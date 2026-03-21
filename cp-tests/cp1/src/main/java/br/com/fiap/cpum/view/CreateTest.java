package br.com.fiap.cpum.view;

import br.com.fiap.cpum.dao.FuncionarioDAO;
import br.com.fiap.cpum.dao.FuncionarioDAOImpl;
import br.com.fiap.cpum.entity.Junior;
import br.com.fiap.cpum.entity.Pleno;
import br.com.fiap.cpum.entity.Senior;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CreateTest {
    static void main (String[] Args){
        // EM
        System.out.println("---------- SCRIPT SQL GERADO (TABELA) ----------");
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("FUNCIONARIO_ORACLE");
        EntityManager em = factory.createEntityManager();

        // DAO
        FuncionarioDAO funcionarioDAO = new FuncionarioDAOImpl(em);

        // OBJETOS CRIADOS
        Senior funcionarioSenior1 = new Senior("Rodrigo Barros", 92, 25, 90);
        Senior funcionarioSenior2 = new Senior("Jana Matilde", 120, 10, 52);

        Pleno funcionarioPleno1 = new Pleno("Diego Andrade", 72, 12, 50);
        Pleno funcionarioPleno2 = new Pleno("Vitória Esperança", 145, 18, 75);

        Junior funcionarioJunior1 = new Junior("Isabella Ramos", 90, 22, 130);
        Junior funcionarioJunior2 = new Junior("Luiza Marques", 65, 34, 55);

        // CADASTRO
        System.out.println("---------- SCRIPT SQL GERADO (CADASTRO) ----------");
        em.getTransaction().begin();
        funcionarioDAO.create(funcionarioSenior1);
        funcionarioDAO.create(funcionarioSenior2);
        funcionarioDAO.create(funcionarioPleno1);
        funcionarioDAO.create(funcionarioPleno2);
        funcionarioDAO.create(funcionarioJunior1);
        funcionarioDAO.create(funcionarioJunior2);
        em.getTransaction().commit();
        em.close();

        // IMPRESSÃO
        System.out.println(funcionarioSenior1.imprimirInformacao());
        System.out.println(funcionarioSenior2.imprimirInformacao());
        System.out.println(funcionarioPleno1.imprimirInformacao());
        System.out.println(funcionarioPleno2.imprimirInformacao());
        System.out.println(funcionarioJunior1.imprimirInformacao());
        System.out.println(funcionarioJunior2.imprimirInformacao());
    }
}
