package br.com.fiap.ProgramaBibliotecaV3.dao;

import br.com.fiap.ProgramaBibliotecaV3.entity.Biblioteca;
import jakarta.persistence.EntityManager;

public class BibliotecaDaoImpl extends GenericDaoImpl<Biblioteca, Integer> implements BibliotecaDao{

    public BibliotecaDaoImpl(EntityManager em) {
        super(em);
    }

}
