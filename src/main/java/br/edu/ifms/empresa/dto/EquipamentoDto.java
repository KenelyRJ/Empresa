package br.edu.ifms.empresa.dto;

import br.edu.ifms.empresa.model.Equipamento;

public class EquipamentoDto {
	 private Integer id;
	 private String nomeEqui;
	 private String modelo;
	 private String marcaEqui;
	 private String peso;
	


	public EquipamentoDto(Integer id, String nomeEqui, String modelo, String marcaEqui, String peso) {
		super();
		this.id = id;
		this.nomeEqui = nomeEqui;
		this.modelo = modelo;
		this.marcaEqui = marcaEqui;
		this.peso = peso;
	}


	public EquipamentoDto(Equipamento equipamento) {
		super();
		this.id = equipamento.getId();
		this.nomeEqui = equipamento.getNomeEqui();
		this.modelo = equipamento.getModelo();
		this.marcaEqui = equipamento.getMarcaEqui();
		this.peso = equipamento.getPeso();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNomeEqui() {
		return nomeEqui;
	}


	public void setNomeEqui(String nomeEqui) {
		this.nomeEqui = nomeEqui;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public String getMarcaEqui() {
		return marcaEqui;
	}


	public void setMarcaEqui(String marcaEqui) {
		this.marcaEqui = marcaEqui;
	}


	public String getPeso() {
		return peso;
	}


	public void setPeso(String peso) {
		this.peso = peso;
	}

}
