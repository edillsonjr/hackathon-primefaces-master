package com.stefanini.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the infracao database table.
 * 
 */
@Entity
@NamedQuery(name="Infracao.findAll", query="SELECT i FROM Infracao i")
public class Infracao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idInfracao;

	//bi-directional many-to-one association to Veiculo
	@ManyToOne
	@JoinColumn(name="idVeiculo")
	private Veiculo veiculo;

	//bi-directional many-to-one association to TipoInfracao
	@ManyToOne
	@JoinColumn(name="idTipoInfracao")
	private TipoInfracao TipoInfracao;

	//bi-directional many-to-one association to Localinfracao
	@ManyToOne
	@JoinColumn(name="idLocalInfracao")
	private LocalInfracao localInfracao;

	//bi-directional many-to-one association to Agente
	@ManyToOne
	@JoinColumn(name="idAgente")
	private Agente agente;

	public Infracao() {
	}

	public int getIdInfracao() {
		return this.idInfracao;
	}

	public void setIdInfracao(int idInfracao) {
		this.idInfracao = idInfracao;
	}

	public Veiculo getVeiculo() {
		return this.veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public TipoInfracao getTipoInfracao() {
		return this.TipoInfracao;
	}

	public void setTipoInfracao(TipoInfracao TipoInfracao) {
		this.TipoInfracao = TipoInfracao;
	}

	public LocalInfracao getLocalInfracao() {
		return this.localInfracao;
	}

	public void setLocalInfracao(LocalInfracao localinfracao) {
		this.localInfracao = localinfracao;
	}

	public Agente getAgente() {
		return this.agente;
	}

	public void setAgente(Agente agente) {
		this.agente = agente;
	}

}