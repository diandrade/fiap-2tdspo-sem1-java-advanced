package br.com.fiap.cpum.dao;

import br.com.fiap.cpum.entity.Funcionario;

public interface FuncionarioDAO {
    void create(Funcionario funcionario);
    void update(Funcionario funcionario);
    void remove(Long id);
    Funcionario findById(Long id);
    void commit();
}
