package br.com.fiap.ProgramaBibliotecaV3.dao;

import br.com.fiap.ProgramaBibliotecaV3.entity.Editora;
import jakarta.persistence.EntityManager;

public class EditoraDaoImpl extends GenericDaoImpl<Editora, Integer> implements EditoraDao{

    public EditoraDaoImpl(EntityManager em) {
        super(em);
    }

}
