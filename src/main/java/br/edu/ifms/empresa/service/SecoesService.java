package br.edu.ifms.empresa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.empresa.dto.SecoesDto;
import br.edu.ifms.empresa.model.Secoes;
import br.edu.ifms.empresa.repository.RepositorySecoes;
import br.edu.ifms.empresa.service.exception.ObjectNotFoundException;
@Service
public class SecoesService {
	
		@Autowired
		private RepositorySecoes repositorySecoes;

		public List<Secoes> buscarTodos() {
			return repositorySecoes.findAll();
		}

		public Secoes buscarId(Integer id) {
			Optional<Secoes> secoes = repositorySecoes.findById(id);
			return secoes.orElseThrow(() -> new ObjectNotFoundException(
					"Objeto não encontrada:" +id+",Tipo:"+Secoes.class.getName()));
		}

		public Secoes cadastrar(Secoes secoes) {
			secoes.setId(null);
			return repositorySecoes.save(secoes);
		}

		public Secoes atualizar(Secoes secoes) {
			Secoes sec = buscarId(secoes.getId());
			sec.setNomeSecao(secoes.getNomeSecao());
			return repositorySecoes.save(secoes);
		}
			
			
			
			public Secoes fromDto(SecoesDto secoesDto) {
				return new Secoes(secoesDto.getId(), secoesDto.getNomeSecao(), null);

		}

		public void remover(Integer id) {
			buscarId(id);
			repositorySecoes.deleteById(id);
		}
	}

	


