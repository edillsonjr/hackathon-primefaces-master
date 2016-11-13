package com.stefanini.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the agente database table.
 * 
 */
@Entity
@NamedQuery(name = "Agente.findAll", query = "SELECT a FROM Agente a")
public class Agente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idAgente;

	private String cpfAgente;

	@Temporal(TemporalType.DATE)
	private Date dtContratacao;

	private String nome;

	private int tempoServico;

	// bi-directional many-to-one association to Infracao
	@OneToMany(mappedBy = "agente")
	private List<Infracao> infracaos;

	public Agente() {
	}

	

	public String getCpfAgente() {
		return this.cpfAgente;
	}

	public void setCpfAgente(String cpfAgente) {
		this.cpfAgente = cpfAgente;
	}

	public Date getDtContratacao() {
		return this.dtContratacao;
	}

	public void setDtContratacao(Date dtContratacao) {
		this.dtContratacao = dtContratacao;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTempoServico() {
		return this.tempoServico;
	}

	public void setTempoServico(int tempoServico) {
		this.tempoServico = tempoServico;
	}

	public List<Infracao> getInfracaos() {
		return this.infracaos;
	}

	public void setInfracaos(List<Infracao> infracaos) {
		this.infracaos = infracaos;
	}

	public Infracao addInfracao(Infracao infracao) {
		getInfracaos().add(infracao);
		infracao.setAgente(this);

		return infracao;
	}

	public Infracao removeInfracao(Infracao infracao) {
		getInfracaos().remove(infracao);
		infracao.setAgente(null);

		return infracao;
	}



	public Integer getIdAgente() {
		return idAgente;
	}



	public void setIdAgente(Integer idAgente) {
		this.idAgente = idAgente;
	}

}