package br.edu.ifms.empresa.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Produtos implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String marca;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_secoes")
	private Secoes secoes;
	@JsonIgnore
	@ManyToMany(mappedBy = "produtos")
	private List<Equipamento> equipamentos = new ArrayList<Equipamento>();

	public Produtos() {

	}

	

	public Produtos(Integer id, String nome, String marca, Secoes secoes) {
		super();
		this.id = id;
		this.nome = nome;
		this.marca = marca;
		this.secoes = secoes;
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



	public List<Equipamento> getEquipamentos() {
		return equipamentos;
	}



	public void setEquipamentos(List<Equipamento> equipamentos) {
		this.equipamentos = equipamentos;
	}



	@Override
	public int hashCode() {
		return Objects.hash(id);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produtos other = (Produtos) obj;
		return Objects.equals(id, other.id);
	}



	

}
