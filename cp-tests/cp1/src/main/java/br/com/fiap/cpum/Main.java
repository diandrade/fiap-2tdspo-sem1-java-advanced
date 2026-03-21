package br.com.fiap.cpum;

import br.com.fiap.cpum.anotation.Description;
import br.com.fiap.cpum.dao.FuncionarioDAO;
import br.com.fiap.cpum.dao.FuncionarioDAOImpl;
import br.com.fiap.cpum.entity.Funcionario;
import br.com.fiap.cpum.entity.Junior;
import br.com.fiap.cpum.entity.Senior;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    static void main(String[] Args) {
        // EM
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("FUNCIONARIO_ORACLE");
        EntityManager em = factory.createEntityManager();

        // DAO
        FuncionarioDAO dao = new FuncionarioDAOImpl(em);

        try {
            // CADASTRO
            System.out.println("\n--- CADASTRANDO FUNCIONÁRIOS ---");
            Funcionario senior = new Senior("Rodrigo Barros", 100, 50, 500.0);
            dao.create(senior);
            dao.commit();
            System.out.println(STR."Senior cadastrado com ID: \{senior.getId()}");

            // BUSCA
            System.out.println("\n--- PESQUISANDO FUNCIONÁRIO ---");
            Long idBusca = senior.getId();
            Funcionario busca = dao.findById(idBusca);

            if (busca != null) {
                Description anotacao = busca.getClass().getAnnotation(Description.class);
                if (anotacao != null) {
                    System.out.println(STR."INFO DA TABELA: \{anotacao.descricao()}");
                }
                System.out.println(busca.imprimirInformacao());
            }

            // ATUALIZAÇÃO
            System.out.println("\n--- ATUALIZANDO FUNCIONÁRIO ---");
            if (busca != null) {
                busca.setNome("Rodrigo Barros Editado");
                busca.setHorasTrabalhadas(120);
                dao.update(busca);
                dao.commit();
                System.out.println("Dados atualizados com sucesso!");
                System.out.println(busca.imprimirInformacao());
            }

            // REMOÇÃO
            System.out.println("\n--- REMOVENDO FUNCIONÁRIO ---");
            Junior temp = new Junior("Funcionario Saida", 10, 20, 0);
            dao.create(temp);
            dao.commit();

            dao.remove(temp.getId());
            dao.commit();
            System.out.println(STR."Funcionário ID \{temp.getId()} removido.");

        } catch (Exception e) {
            System.err.println(STR."Erro durante a execução: \{e.getMessage()}");
            e.printStackTrace();
        } finally {
            em.close();
            factory.close();
        }
    }
}