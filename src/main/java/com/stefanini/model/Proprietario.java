package com.stefanini.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the proprietario database table.
 * 
 */
@Entity
@NamedQuery(name="Proprietario.findAll", query="SELECT p FROM Proprietario p")
public class Proprietario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProprietario;

	private String bairro;

	private String cidade;

	private int cpfProprietario;

	@Temporal(TemporalType.DATE)
	private Date dtNascimento;

	private String endereco;

	private String nome;

	private String sexo;

	private String uf;

	//bi-directional many-to-one association to Telefone
	@OneToMany(mappedBy="proprietario")
	private List<Telefone> telefones;

	
	//bi-directional many-to-one association to Veiculo
	@OneToMany(mappedBy="proprietario")
	private List<Veiculo> veiculos;

	public Proprietario() {
	}

	public int getIdProprietario() {
		return this.idProprietario;
	}

	public void setIdProprietario(int idProprietario) {
		this.idProprietario = idProprietario;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public int getCpfProprietario() {
		return this.cpfProprietario;
	}

	public void setCpfProprietario(int cpfProprietario) {
		this.cpfProprietario = cpfProprietario;
	}

	public Date getDtNascimento() {
		return this.dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getUf() {
		return this.uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public List<Telefone> getTelefones() {
		return this.telefones;
	}

	public void setTelefones1(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public Telefone addTelefones1(Telefone telefones) {
		getTelefones().add(telefones);
		telefones.setProprietario(this);

		return telefones;
	}

	public Telefone removeTelefones(Telefone telefones) {
		getTelefones().remove(telefones);
		telefones.setProprietario(null);

		return telefones;
	}

	

	
	public List<Veiculo> getVeiculos() {
		return this.veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

	public Veiculo addVeiculo(Veiculo veiculo) {
		getVeiculos().add(veiculo);
		veiculo.setProprietario(this);

		return veiculo;
	}

	public Veiculo removeVeiculo(Veiculo veiculo) {
		getVeiculos().remove(veiculo);
		veiculo.setProprietario(null);

		return veiculo;
	}

}