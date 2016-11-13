package com.stefanini.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the categoria database table.
 * 
 */
@Entity
@NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCategoria;

	private String descricaoCategoria;

	// bi-directional many-to-one association to Modelo
	@OneToMany(mappedBy = "categoria")
	private List<Modelo> modelos;

	public Categoria() {
	}

	public int getIdCategoria() {
		return this.idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getDescricaoCategoria() {
		return this.descricaoCategoria;
	}

	public void setDescricaoCategoria(String descricaiCategoria) {
		this.descricaoCategoria = descricaiCategoria;
	}

	public List<Modelo> getModelos() {
		return this.modelos;
	}

	public void setModelos(List<Modelo> modelos) {
		this.modelos = modelos;
	}

	public Modelo addModelo(Modelo modelo) {
		getModelos().add(modelo);
		modelo.setCategoria(this);

		return modelo;
	}

	public Modelo removeModelo(Modelo modelo) {
		getModelos().remove(modelo);
		modelo.setCategoria(null);

		return modelo;
	}

}