package com.stefanini.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TipoInfracao database table.
 * 
 */
@Entity
@NamedQuery(name="TipoInfracao.findAll", query="SELECT t FROM TipoInfracao t")
public class TipoInfracao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTipoInfracao;

	private String descricaoTipoInfracao;

	private double valor;

	//bi-directional many-to-one association to Infracao
	@OneToMany(mappedBy="TipoInfracao")
	private List<Infracao> infracaos;

	public TipoInfracao() {
	}

	public int getIdTipoInfracao() {
		return this.idTipoInfracao;
	}

	public void setIdTipoInfracao(int idTipoInfracao) {
		this.idTipoInfracao = idTipoInfracao;
	}

	public String getDescricaoTipoInfracao() {
		return this.descricaoTipoInfracao;
	}

	public void setDescricaoTipoInfracao(String descricaoTipoInfracao) {
		this.descricaoTipoInfracao = descricaoTipoInfracao;
	}

	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public List<Infracao> getInfracaos() {
		return this.infracaos;
	}

	public void setInfracaos(List<Infracao> infracaos) {
		this.infracaos = infracaos;
	}

	public Infracao addInfracao(Infracao infracao) {
		getInfracaos().add(infracao);
		infracao.setTipoInfracao(this);

		return infracao;
	}

	public Infracao removeInfracao(Infracao infracao) {
		getInfracaos().remove(infracao);
		infracao.setTipoInfracao(null);

		return infracao;
	}

}