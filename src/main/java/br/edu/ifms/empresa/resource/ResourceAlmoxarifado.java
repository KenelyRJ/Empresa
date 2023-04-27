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

import br.edu.ifms.empresa.dto.AlmoxarifadoDto;
import br.edu.ifms.empresa.model.Almoxarifado;
import br.edu.ifms.empresa.service.AlmoxarifadoService;

@RestController
@RequestMapping(value = "/almoxarifado")
public class ResourceAlmoxarifado {

	@Autowired
	AlmoxarifadoService almoxarifado;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Almoxarifado> find(@PathVariable Integer id) {
		Almoxarifado obj = almoxarifado.buscarId(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Validated @RequestBody AlmoxarifadoDto objDto) {
		Almoxarifado obj = almoxarifado.fromDto(objDto);
		obj = almoxarifado.cadastrar(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Validated @RequestBody AlmoxarifadoDto objDto, @PathVariable Integer id) {
		Almoxarifado obj = almoxarifado.fromDto(objDto);
		obj.setId(id);
		obj = almoxarifado.atualizar(obj);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@RequestBody Almoxarifado obj, @PathVariable Integer id) {
		almoxarifado.remover(id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<AlmoxarifadoDto>> findAll() {
		List<Almoxarifado> list = almoxarifado.buscarTodos();
		List<AlmoxarifadoDto> listDto = list.stream().map(obj -> new AlmoxarifadoDto(obj.getId(), obj.getNome()))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

}