package br.com.padaria.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import br.com.padaria.domain.Funcionario;

@Repository
@Transactional(isolation = Isolation.DEFAULT)
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>  {

}
