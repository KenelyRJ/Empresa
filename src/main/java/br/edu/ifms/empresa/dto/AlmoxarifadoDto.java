package br.edu.ifms.empresa.dto;

import br.edu.ifms.empresa.model.Almoxarifado;

public class AlmoxarifadoDto {
	
	private Integer id;
	private String nome;
	
	
	public AlmoxarifadoDto() {
		
	}
//construtor preenchido automatico
	public AlmoxarifadoDto(Almoxarifado obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		
	}

	

	public AlmoxarifadoDto(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
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
	
	
}

