package br.edu.ifms.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifms.empresa.model.Secoes;
@Repository
public interface RepositorySecoes extends JpaRepository<Secoes, Integer>{
	

}
