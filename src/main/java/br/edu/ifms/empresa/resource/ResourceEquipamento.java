package br.edu.ifms.empresa.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.ifms.empresa.dto.EquipamentoDto;
import br.edu.ifms.empresa.model.Equipamento;
import br.edu.ifms.empresa.service.EquipamentoService;

@RestController
@RequestMapping(value = "/equipamento")
public class ResourceEquipamento {
	
		@Autowired
		EquipamentoService equipamento;

		@RequestMapping(value = "/{id}", method = RequestMethod.GET)
		public ResponseEntity<Equipamento> find(@PathVariable Integer id) {
			Equipamento obj = equipamento.buscarId(id);
			return ResponseEntity.ok().body(obj);
		}

		@RequestMapping(method = RequestMethod.POST)
		public ResponseEntity<Void> insert(@Validated @RequestBody EquipamentoDto objDto) {
			Equipamento obj = equipamento.fromDto(objDto);
			obj = equipamento.cadastrar(obj);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
			return ResponseEntity.created(uri).build();
		}

		@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
		public ResponseEntity<Void> update(@Validated @RequestBody EquipamentoDto objDto, @PathVariable Integer id) {
			Equipamento obj = equipamento.fromDto(objDto);
			obj.setId(id);
			obj = equipamento.atualizar(obj);
			return ResponseEntity.noContent().build();
		}

		@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
		public ResponseEntity<Void> delete(@RequestBody Equipamento obj, @PathVariable Integer id) {
			equipamento.remover(id);
			return ResponseEntity.noContent().build();
		}
//Integer id, String nomeEqui, String modelo, String marcaEqui, String peso
		@RequestMapping(method = RequestMethod.GET)
		public ResponseEntity<List<EquipamentoDto>> findAll() {
			List<Equipamento> list = equipamento.buscarTodos();
			List<EquipamentoDto> listDto = list.stream().map(obj -> new EquipamentoDto(obj.getId(), obj.getNomeEqui(), obj.getModelo(), obj.getMarcaEqui(), obj.getPeso()))
					.collect(Collectors.toList());
			return ResponseEntity.ok().body(listDto);
		}

	}


