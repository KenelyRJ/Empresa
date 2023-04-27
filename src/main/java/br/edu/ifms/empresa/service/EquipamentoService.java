package br.edu.ifms.empresa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.empresa.dto.EquipamentoDto;
import br.edu.ifms.empresa.model.Equipamento;
import br.edu.ifms.empresa.repository.RepositoryEquipamento;
import br.edu.ifms.empresa.service.exception.ObjectNotFoundException;

@Service
public class EquipamentoService {

	
		@Autowired
		private RepositoryEquipamento repositoryEquipamento;

		public List<Equipamento> buscarTodos() {
			return repositoryEquipamento.findAll();
		}

		public Equipamento buscarId(Integer id) {
			Optional<Equipamento> equipamento = repositoryEquipamento.findById(id);
			return equipamento.orElseThrow(() -> new ObjectNotFoundException(
					"Objeto não encontrada:" +id+",Tipo:"+Equipamento.class.getName()));
		}

		public Equipamento cadastrar(Equipamento equipamento) {
			equipamento.setId(null);
			return repositoryEquipamento.save(equipamento);
		}

		public Equipamento atualizar(Equipamento equipamento) {
			Equipamento equi = buscarId(equipamento.getId());
			equi.setNomeEqui(equipamento.getNomeEqui());
			return repositoryEquipamento.save(equipamento);
		}
			
		/*this.id = equipamento.getId();
		this.nomeEqui = equipamento.getNomeEqui();
		this.modelo = equipamento.getModelo();
		this.marcaEqui = equipamento.getMarcaEqui();
		this.peso = equipamento.getPeso();
			//
*/			public Equipamento fromDto(EquipamentoDto equipamentoDto) {
				return new Equipamento(equipamentoDto.getId(), equipamentoDto.getNomeEqui(), equipamentoDto.getModelo(),equipamentoDto.getMarcaEqui(), equipamentoDto.getPeso());

		}

		public void remover(Integer id) {
			buscarId(id);
			repositoryEquipamento.deleteById(id);
		}
	}

	


