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

import br.edu.ifms.empresa.dto.ProdutosDto;
import br.edu.ifms.empresa.model.Produtos;
import br.edu.ifms.empresa.service.ProdutosService;

@RestController
@RequestMapping(value = "/produtos")
public class ResourceProdutos {


		@Autowired
		ProdutosService produtos;

		@RequestMapping(value = "/{id}", method = RequestMethod.GET)
		public ResponseEntity<Produtos> find(@PathVariable Integer id) {
			Produtos obj = produtos.buscarId(id);
			return ResponseEntity.ok().body(obj);
		}

		@RequestMapping(method = RequestMethod.POST)
		public ResponseEntity<Void> insert(@Validated @RequestBody ProdutosDto objDto) {
			Produtos obj = produtos.fromDto(objDto);
			obj = produtos.cadastrar(obj);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
			return ResponseEntity.created(uri).build();
		}

		@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
		public ResponseEntity<Void> update(@Validated @RequestBody ProdutosDto objDto, @PathVariable Integer id) {
			Produtos obj = produtos.fromDto(objDto);
			obj.setId(id);
			obj = produtos.atualizar(obj);
			return ResponseEntity.noContent().build();
		}

		@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
		public ResponseEntity<Void> delete(@RequestBody Produtos obj, @PathVariable Integer id) {
			produtos.remover(id);
			return ResponseEntity.noContent().build();
		}

		@RequestMapping(method = RequestMethod.GET)
		public ResponseEntity<List<ProdutosDto>> findAll() {
			List<Produtos> list = produtos.buscarTodos();
			List<ProdutosDto> listDto = list.stream().map(obj -> new ProdutosDto(obj.getId(), obj.getNome(),obj.getMarca(), obj.getSecoes()))
					.collect(Collectors.toList());
			return ResponseEntity.ok().body(listDto);
		}

	}
	


