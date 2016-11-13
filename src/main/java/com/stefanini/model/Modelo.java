package com.stefanini.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the modelo database table.
 * 
 */
@Entity
@NamedQuery(name = "Modelo.findAll", query = "SELECT m FROM Modelo m")
public class Modelo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idModelo;

	private String descricaoModelo;

	// bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name = "idCategoria")
	private Categoria categoria;

	// bi-directional many-to-one association to Veiculo
	@OneToMany(mappedBy = "modelo")
	private List<Veiculo> veiculos;

	public Modelo() {
	}

	public int getIdModelo() {
		return this.idModelo;
	}

	public void setIdModelo(int idModelo) {
		this.idModelo = idModelo;
	}

	public String getDescricaoModelo() {
		return this.descricaoModelo;
	}

	public void setDescricaoModelo(String descricaoModelo) {
		this.descricaoModelo = descricaoModelo;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Veiculo> getVeiculos() {
		return this.veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

	public Veiculo addVeiculo(Veiculo veiculo) {
		getVeiculos().add(veiculo);
		veiculo.setModelo(this);

		return veiculo;
	}

	public Veiculo removeVeiculo(Veiculo veiculo) {
		getVeiculos().remove(veiculo);
		veiculo.setModelo(null);

		return veiculo;
	}

}