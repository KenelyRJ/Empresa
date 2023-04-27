package br.edu.ifms.empresa.dto;

import br.edu.ifms.empresa.model.Almoxarifado;
import br.edu.ifms.empresa.model.Secoes;

public class SecoesDto {
	private Integer id;
	private String nomeSecao;
	private Almoxarifado almoxarifado;



	public SecoesDto(Integer id, String nomeSecao, Almoxarifado almoxarifado) {
		super();
		this.id = id;
		this.nomeSecao = nomeSecao;
		this.almoxarifado= almoxarifado;
	
	}

	public SecoesDto(Secoes obj) {
		super();
		
		this.id = obj.getId();
		this.nomeSecao = obj.getNomeSecao();
		this.almoxarifado = obj.getAlmoxarifado();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeSecao() {
		return nomeSecao;
	}

	public void setNomeSecao(String nomeSecao) {
		this.nomeSecao = nomeSecao;
	}

	public Almoxarifado getAlmoxarifado() {
		return almoxarifado;
	}

	public void setAlmoxarifado(Almoxarifado almoxarifado) {
		this.almoxarifado = almoxarifado;
	}
	

	
}
