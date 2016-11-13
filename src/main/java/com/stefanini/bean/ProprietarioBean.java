package com.stefanini.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.Proprietario;
import com.stefanini.model.Telefone;
import com.stefanini.model.TipoTelefone;
import com.stefanini.service.ProprietarioService;
import com.stefanini.service.TipoTelefoneService;
import com.stefanini.util.FacesUtil;

@Named("proprietarioMB")
@SessionScoped
public class ProprietarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ProprietarioService proprietarioService;

	@Inject
	private Proprietario proprietario;
	private Integer idTipo;

	public ProprietarioService getProprietarioService() {
		return proprietarioService;
	}

	public void setProprietarioService(ProprietarioService proprietarioService) {
		this.proprietarioService = proprietarioService;
	}

	public TipoTelefoneService getTipoTelefoneService() {
		return tipoTelefoneService;
	}

	public void setTipoTelefoneService(TipoTelefoneService tipoTelefoneService) {
		this.tipoTelefoneService = tipoTelefoneService;
	}

	public Integer getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(Integer idTipo) {
		this.idTipo = idTipo;
	}

	public TipoTelefone getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(TipoTelefone tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}

	@Inject
	private Telefone telefone;
	@Inject
	private TipoTelefone tipoTelefone;
	@Inject
	private TipoTelefoneService tipoTelefoneService;

	List<TipoTelefone> tipoTelefones;

	public List<TipoTelefone> getTipoTelefones() {
		return tipoTelefoneService.listar();
	}

	public void setTipoTelefones(List<TipoTelefone> tipoTelefones) {
		this.tipoTelefones = tipoTelefones;
	}

	public void salvar() {
		try {
			proprietarioService.incluir(proprietario);
			FacesUtil.exibeSucesso("REGISTRO INSERIDO COM SUCESSO");
		} catch (RuntimeException e) {
			FacesUtil.exibeErro("PROBLEMA AO INSERIR REGISTRO");
		}

		this.proprietario = new Proprietario();
		this.telefone = new Telefone();
	}

	public void salvarTelefone() {
		if (this.proprietario != null) {
			this.proprietario.addTelefones1(telefone);
			FacesUtil.exibeSucesso("REGISTRO INSERIDO COM SUCESSO");
		} else {
			FacesUtil.exibeErro("PROBLEMA AO INSERIR REGISTRO");
			this.telefone = new Telefone();
		}

	}

	public void excluir(Proprietario proprietario) {
		try {
			proprietarioService.remover(proprietario);
			FacesUtil.exibeSucesso("REGISTRO REMOVIDO COM SUCESSO");
		} catch (RuntimeException e) {
			FacesUtil.exibeErro("PROBLEMA AO REMOVER REGISTRO");
		}
	}

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public List<Proprietario> proprietarios() {
		return proprietarioService.lista();
	}



}