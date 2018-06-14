package br.com.padaria.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.padaria.domain.Produto;

@Repository
//@Transactional
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {


}
