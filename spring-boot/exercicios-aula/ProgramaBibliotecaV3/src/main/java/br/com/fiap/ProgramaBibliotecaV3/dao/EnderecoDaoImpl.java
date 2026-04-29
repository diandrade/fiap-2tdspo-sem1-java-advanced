package br.com.fiap.ProgramaBibliotecaV3.dao;

import br.com.fiap.ProgramaBibliotecaV3.entity.Endereco;
import jakarta.persistence.EntityManager;

public class EnderecoDaoImpl extends GenericDaoImpl<Endereco, Integer> implements EnderecoDao{

    public EnderecoDaoImpl(EntityManager em) {
        super(em);
    }

}
