package br.edu.ifms.empresa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.empresa.dto.ProdutosDto;
import br.edu.ifms.empresa.model.Produtos;
import br.edu.ifms.empresa.repository.RepositoryProdutos;
import br.edu.ifms.empresa.service.exception.ObjectNotFoundException;

@Service
public class ProdutosService {
			
			@Autowired
			private RepositoryProdutos repositoryProdutos;

			public List<Produtos> buscarTodos() {
				return repositoryProdutos.findAll();
			}

			public Produtos buscarId(Integer id) {
				Optional<Produtos> produtos = repositoryProdutos.findById(id);
				return produtos.orElseThrow(() -> new ObjectNotFoundException(
						"Objeto não encontrada:" +id+",Tipo:"+Produtos.class.getName()));
			}

			public Produtos cadastrar(Produtos produtos) {
				produtos.setId(null);
				return repositoryProdutos.save(produtos);
			}

			public Produtos atualizar(Produtos produtos) {
				Produtos pro = buscarId(produtos.getId());
				pro.setNome(produtos.getNome());
				return repositoryProdutos.save(produtos);
			}
			
			/*this.id = id;
			this.nome = nome;
			this.marca = marca;
			this.secoes = secoes;*/
			
		public Produtos fromDto(ProdutosDto produtosDto) {
					return new Produtos(produtosDto.getId(), produtosDto.getNome(),produtosDto.getMarca(), produtosDto.getSecoes());

			}

			public void remover(Integer id) {
				buscarId(id);
				repositoryProdutos.deleteById(id);
			}
		}



