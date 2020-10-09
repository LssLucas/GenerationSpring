package com.minhaLojaGames.toPlayQueer.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tb_produto")
public class Produto {
	
	/*
	Código	2086827999
	Código de barras	0711719542261
	Fabricante	Insomniac Games
	Marca 
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigoId;
	
	@NotNull
	@Size()
	private String codigoBarras;
	
	@NotNull
	@Size(max=200)	
	private String fabricante;
	
	@NotNull
	@Size(max=200)
	private String marca;
	
	@NotNull
	@Size(max=200)
	private String nome;
	
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Categoria categoria;

	public long getCodigoId() {
		return codigoId;
	}

	public void setCodigoId(long codigoId) {
		this.codigoId = codigoId;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
