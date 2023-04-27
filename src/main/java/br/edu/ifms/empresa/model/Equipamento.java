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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
@Entity
public class Equipamento implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer id;
	 private String nomeEqui;
	 private String modelo;
	 private String marcaEqui;
	 private String peso;
	 @JsonIgnore
	 @ManyToMany
	 @JoinTable(			
				name="prod_equi",
				joinColumns = @JoinColumn(name="equipamento_id"),
				inverseJoinColumns = @JoinColumn(name= "produto_id")			
				)
	 private List<Produtos> produtos = new ArrayList<Produtos>();
	 
	 public Equipamento() {
		 
	 }

	public Equipamento(Integer id, String nomeEqui, String modelo, String marcaEqui, String peso) {
		super();
		this.id = id;
		this.nomeEqui = nomeEqui;
		this.modelo = modelo;
		this.marcaEqui = marcaEqui;
		this.peso = peso;
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

	public List<Produtos> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produtos> produtos) {
		this.produtos = produtos;
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
		Equipamento other = (Equipamento) obj;
		return Objects.equals(id, other.id);
	}

	 

}
