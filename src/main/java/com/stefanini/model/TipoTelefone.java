package com.stefanini.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TipoTelefone database table.
 * 
 */
@Entity
@NamedQuery(name="TipoTelefone.findAll", query="SELECT t FROM TipoTelefone t")
public class TipoTelefone implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTipoTelefone;

	private String descricaoTipoTelefone;

	//bi-directional many-to-one association to Telefone
	@OneToMany(mappedBy="TipoTelefone")
	private List<Telefone> telefones;

	public TipoTelefone() {
	}

	public int getIdTipoTelefone() {
		return this.idTipoTelefone;
	}

	public void setIdTipoTelefone(int idTipoTelefone) {
		this.idTipoTelefone = idTipoTelefone;
	}

	public String getDescricaoTipoTelefone() {
		return this.descricaoTipoTelefone;
	}

	public void setDescricaoTipoTelefone(String descricaoTipoTelefone) {
		this.descricaoTipoTelefone = descricaoTipoTelefone;
	}

	public List<Telefone> getTelefones() {
		return this.telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public Telefone addTelefone(Telefone telefone) {
		getTelefones().add(telefone);
		telefone.setTipoTelefone(this);

		return telefone;
	}

	public Telefone removeTelefone(Telefone telefone) {
		getTelefones().remove(telefone);
		telefone.setTipoTelefone(null);

		return telefone;
	}

}