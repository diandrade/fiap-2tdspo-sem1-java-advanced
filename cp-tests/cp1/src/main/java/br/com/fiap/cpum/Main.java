package br.com.fiap.cpum;

import br.com.fiap.cpum.anotation.Description;
import br.com.fiap.cpum.dao.FuncionarioDAO;
import br.com.fiap.cpum.dao.FuncionarioDAOImpl;
import br.com.fiap.cpum.entity.Funcionario;
import br.com.fiap.cpum.entity.Junior;
import br.com.fiap.cpum.entity.Pleno;
import br.com.fiap.cpum.entity.Senior;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    static void main(String[] args) {
        // EM
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("FUNCIONARIO_ORACLE");
        EntityManager em = factory.createEntityManager();

        // DAO
        FuncionarioDAO dao = new FuncionarioDAOImpl(em);

        try {
            // OBJETOS CRIADOS
            Senior funcionarioSenior1 = new Senior("Rodrigo Barros", 92, 25, 90);
            Senior funcionarioSenior2 = new Senior("Jana Matilde", 120, 10, 52);

            Pleno funcionarioPleno1 = new Pleno("Diego Andrade", 72, 12, 50);
            Pleno funcionarioPleno2 = new Pleno("Vitória Esperança", 145, 18, 75);

            Junior funcionarioJunior1 = new Junior("Isabella Ramos", 90, 22, 130);
            Junior funcionarioJunior2 = new Junior("Luiza Marques", 65, 34, 55);

            // CADASTRO
            System.out.println("\n---------- SCRIPT SQL GERADO (CADASTRO) ----------");
            dao.create(funcionarioSenior1);
            dao.create(funcionarioSenior2);
            dao.create(funcionarioPleno1);
            dao.create(funcionarioPleno2);
            dao.create(funcionarioJunior1);
            dao.create(funcionarioJunior2);
            dao.commit();
            System.out.println("Funcionários cadastrados com sucesso!");

            // BUSCA
            System.out.println("\n---------- SCRIPT SQL GERADO (LEITURA) ----------");
            Long idBusca = funcionarioSenior1.getId();
            Funcionario busca = dao.findById(idBusca);

            if (busca != null) {
                Description anotacao = busca.getClass().getAnnotation(Description.class);
                if (anotacao != null) {
                    System.out.println(STR."INFO DA TABELA: \{anotacao.descricao()}");
                }
                System.out.println(busca.imprimirInformacao());
            }

            // ATUALIZAÇÃO
            System.out.println("\n---------- SCRIPT SQL GERADO (ATUALIZAÇÃO) ----------");
            if (busca != null) {
                // Alterações Desejadas
                busca.setNome("Vinicius de Moraes");
                busca.setHorasTrabalhadas(48);
                busca.setValorHora(72);

                dao.update(busca);
                dao.commit();

                System.out.println("\n=== DADOS APÓS ATUALIZAÇÃO ===");
                System.out.println(busca.imprimirInformacao());
            }

            // REMOÇÃO
            System.out.println("\n---------- SCRIPT SQL GERADO (REMOÇÃO) ----------");

            dao.remove(funcionarioSenior1.getId());
            dao.remove(funcionarioSenior2.getId());
            dao.remove(funcionarioPleno1.getId());
            dao.remove(funcionarioPleno2.getId());
            dao.remove(funcionarioJunior1.getId());
            dao.remove(funcionarioJunior2.getId());
            dao.commit();

            System.out.println("Todos os funcionários foram removidos com sucesso!");

        } catch (Exception e) {
            System.err.println(STR."Erro durante a execução: \{e.getMessage()}");
            e.printStackTrace();
        } finally {
            em.close();
            factory.close();
        }
    }
}