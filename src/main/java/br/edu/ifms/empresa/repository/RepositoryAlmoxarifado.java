package br.edu.ifms.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifms.empresa.model.Almoxarifado;

@Repository
public interface RepositoryAlmoxarifado extends JpaRepository<Almoxarifado, Integer> {

}
