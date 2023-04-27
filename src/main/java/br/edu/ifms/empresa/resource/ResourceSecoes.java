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

import br.edu.ifms.empresa.dto.SecoesDto;
import br.edu.ifms.empresa.model.Secoes;
import br.edu.ifms.empresa.service.SecoesService;

@RestController
@RequestMapping(value = "/secoes")
public class ResourceSecoes {


		@Autowired
		SecoesService secoes;

		@RequestMapping(value = "/{id}", method = RequestMethod.GET)
		public ResponseEntity<Secoes> find(@PathVariable Integer id) {
			Secoes obj = secoes.buscarId(id);
			return ResponseEntity.ok().body(obj);
		}

		@RequestMapping(method = RequestMethod.POST)
		public ResponseEntity<Void> insert(@Validated @RequestBody SecoesDto objDto) {
			Secoes obj = secoes.fromDto(objDto);
			obj = secoes.cadastrar(obj);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
			return ResponseEntity.created(uri).build();
		}

		@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
		public ResponseEntity<Void> update(@Validated @RequestBody SecoesDto objDto, @PathVariable Integer id) {
			Secoes obj = secoes.fromDto(objDto);
			obj.setId(id);
			obj = secoes.atualizar(obj);
			return ResponseEntity.noContent().build();
		}

		@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
		public ResponseEntity<Void> delete(@RequestBody Secoes obj, @PathVariable Integer id) {
			secoes.remover(id);
			return ResponseEntity.noContent().build();
		}

		@RequestMapping(method = RequestMethod.GET)
		public ResponseEntity<List<SecoesDto>> findAll() {
			List<Secoes> list = secoes.buscarTodos();
			List<SecoesDto> listDto = list.stream().map(obj -> new SecoesDto(obj.getId(), obj.getNomeSecao(), obj.getAlmoxarifado()))
					.collect(Collectors.toList());
			return ResponseEntity.ok().body(listDto);
		}

	}


