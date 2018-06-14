package br.com.padaria.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.padaria.domain.Funcionario;

@Repository
//@Transactional
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>  {

}
