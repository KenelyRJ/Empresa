package br.edu.ifms.empresa.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.empresa.dto.AlmoxarifadoDto;
import br.edu.ifms.empresa.model.Almoxarifado;
import br.edu.ifms.empresa.repository.RepositoryAlmoxarifado;
import br.edu.ifms.empresa.service.exception.ObjectNotFoundException;
@Service
public class AlmoxarifadoService {
	@Autowired
	private RepositoryAlmoxarifado repositoryAlmoxarifado;

	public List<Almoxarifado> buscarTodos() {
		return repositoryAlmoxarifado.findAll();
	}

	public Almoxarifado buscarId(Integer id) {
		Optional<Almoxarifado> almoxarifado = repositoryAlmoxarifado.findById(id);
		return almoxarifado.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrada:" +id+",Tipo:"+Almoxarifado.class.getName()));
	}

	public Almoxarifado cadastrar(Almoxarifado almoxarifado) {
		almoxarifado.setId(null);
		return repositoryAlmoxarifado.save(almoxarifado);
	}

	public Almoxarifado atualizar(Almoxarifado almoxarifado) {
		Almoxarifado almox = buscarId(almoxarifado.getId());
		almox.setNome(almoxarifado.getNome());
		return repositoryAlmoxarifado.save(almoxarifado);
	}
		
		
		
		public Almoxarifado fromDto(AlmoxarifadoDto almoxarifadoDto) {
			return new Almoxarifado(almoxarifadoDto.getId(), almoxarifadoDto.getNome());

	}

	public void remover(Integer id) {
		buscarId(id);
		repositoryAlmoxarifado.deleteById(id);
	}
}
