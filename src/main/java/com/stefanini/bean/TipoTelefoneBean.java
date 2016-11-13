package com.stefanini.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.TipoTelefone;
import com.stefanini.service.TipoTelefoneService;

@Named("tipoTelefoneMB")
@SessionScoped
public class TipoTelefoneBean implements Serializable {

	private static final long serialVersionUID = -7806951621712030158L;

	@Inject
	private TipoTelefone tipoTelefone;
	
	@Inject
	private TipoTelefoneService tipoTelefoneService;
	
	private List<TipoTelefone> tiposTelefones;
	

	public TipoTelefone getTipoTelefone() {
		if (tipoTelefone == null){
			tipoTelefone = new TipoTelefone();
		}
		return tipoTelefone;
	}

	public void setTipoTelefone(TipoTelefone tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}
	
	public void inserir() {
		tipoTelefoneService.incluir(tipoTelefone);
		tipoTelefone = new TipoTelefone();
	}

	public List<TipoTelefone> getTiposTelefones() {
		if (tiposTelefones == null) {
			tiposTelefones = new ArrayList<TipoTelefone>();
			tiposTelefones = tipoTelefoneService.listar();
		}
		return tiposTelefones;
	}

	public void setTiposTelefones(List<TipoTelefone> tiposTelefones) {
		this.tiposTelefones = tiposTelefones;
	}
	
}
