package com.stefanini.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the veiculos database table.
 * 
 */
@Entity
@Table(name="veiculos")
@NamedQuery(name="Veiculo.findAll", query="SELECT v FROM Veiculo v")
public class Veiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idVeiculo;
	@Column(unique=true)
	private String placa;

	public Integer getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(Integer idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	private String uf;

	//bi-directional many-to-one association to Infracao
	@OneToMany(mappedBy="veiculo")
	private List<Infracao> infracaos;

	//bi-directional many-to-one association to Proprietario
	@ManyToOne
	@JoinColumn(name="idProprietario")
	private Proprietario proprietario;

	//bi-directional many-to-one association to Modelo
	@ManyToOne
	@JoinColumn(name="idModelo")
	private Modelo modelo;

	public Veiculo() {
	}

	public String getPlaca() {
		return this.placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getUf() {
		return this.uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public List<Infracao> getInfracaos() {
		return this.infracaos;
	}

	public void setInfracaos(List<Infracao> infracaos) {
		this.infracaos = infracaos;
	}

	public Infracao addInfracao(Infracao infracao) {
		getInfracaos().add(infracao);
		infracao.setVeiculo(this);

		return infracao;
	}

	public Infracao removeInfracao(Infracao infracao) {
		getInfracaos().remove(infracao);
		infracao.setVeiculo(null);

		return infracao;
	}

	public Proprietario getProprietario() {
		return this.proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	public Modelo getModelo() {
		return this.modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

}