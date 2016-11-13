package com.stefanini.bean;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.Telefone;
import com.stefanini.service.TelefoneService;

@Named("telefoneMB")
@SessionScoped
public class TelefoneBean implements Serializable {

	private static final long serialVersionUID = 5153381058367853439L;

	@Inject
	private Telefone telefone;
	
	@Inject
	private TelefoneService telefoneService;

	public Telefone getTelefone() {
		if (telefone == null) {
			telefone = new Telefone();
		}
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}
	
	public void inserir() {
		telefoneService.incluir(telefone);
		telefone = new Telefone();
	}
	
}
