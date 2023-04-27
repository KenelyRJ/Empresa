package br.edu.ifms.empresa.dto;

import br.edu.ifms.empresa.model.Produtos;
import br.edu.ifms.empresa.model.Secoes;

public class ProdutosDto {
	private Integer id;
	private String nome;
	private String marca;
	private Secoes secoes;
	


public ProdutosDto(Integer id, String nome, String marca, Secoes secoes) {
		super();
		this.id = id;
		this.nome = nome;
		this.marca = marca;
		this.secoes = secoes;
	}

public ProdutosDto(Produtos produtos) {
	super();
	this.id = produtos.getId();
	this.nome = produtos.getNome();
	this.marca = produtos.getMarca();
	this.secoes = produtos.getSecoes();
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public String getMarca() {
	return marca;
}

public void setMarca(String marca) {
	this.marca = marca;
}

public Secoes getSecoes() {
	return secoes;
}

public void setSecoes(Secoes secoes) {
	this.secoes = secoes;
}







}
