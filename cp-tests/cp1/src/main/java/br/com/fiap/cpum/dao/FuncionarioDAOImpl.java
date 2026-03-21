package br.com.fiap.cpum.dao;

import br.com.fiap.cpum.entity.Funcionario;
import jakarta.persistence.EntityManager;

public class FuncionarioDAOImpl implements FuncionarioDAO {
    
    private EntityManager em;
    
    public FuncionarioDAOImpl(EntityManager em) {
        this.em = em;
    }
    
    @Override
    public void create(Funcionario funcionario) {
        em.persist(funcionario);
    }

    @Override
    public void update(Funcionario funcionario) {
        findById(funcionario.getId());
        em.merge(funcionario);
    }

    @Override
    public void remove(Long id) {
        Funcionario funcionario = em.getReference(Funcionario.class, id);
        em.remove(funcionario);
    }

    @Override
    public Funcionario findById(Long id) {
        return em.find(Funcionario.class, id);
    }

    @Override
    public void commit() {
        try {
            em.getTransaction().begin();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }
}
