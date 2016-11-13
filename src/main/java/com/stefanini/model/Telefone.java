package com.stefanini.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the telefones database table.
 * 
 */
@Entity
@Table(name="telefones")
@NamedQuery(name="Telefone.findAll", query="SELECT t FROM Telefone t")
public class Telefone implements Serializable {
	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Integer ddd;
	private Integer numero;
	
	//bi-directional many-to-one association to Proprietario
	@ManyToOne
	@JoinColumn(name="idProprietario")
	private Proprietario proprietario;

	

	//bi-directional many-to-one association to TipoTelefone
	@ManyToOne
	@JoinColumn(name="idTipoTelefone")
	private TipoTelefone TipoTelefone;

	public Telefone() {
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDdd() {
		return ddd;
	}



	public void setDdd(Integer ddd) {
		this.ddd = ddd;
	}



	public Integer getNumero() {
		return numero;
	}



	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Proprietario getProprietario() {
		return this.proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	

	public TipoTelefone getTipoTelefone() {
		return this.TipoTelefone;
	}

	public void setTipoTelefone(TipoTelefone TipoTelefone) {
		this.TipoTelefone = TipoTelefone;
	}

}