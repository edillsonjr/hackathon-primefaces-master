package com.stefanini.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.Agente;
import com.stefanini.service.AgenteService;
import com.stefanini.util.FacesUtil;

@Named("agenteMB")
@SessionScoped
public class AgenteBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Agente agente;
	
	@Inject
	private AgenteService agenteService;

	private void incluir() {
		try {
			agenteService.incluir(agente);
			FacesUtil.exibeSucesso("REGISTRO INSERIDO COM SUCESSO");
			FacesUtil.getContext().getExternalContext().invalidateSession();
		} catch (RuntimeException e) {
			FacesUtil.exibeErro("PROBLEMA AO INSERIR REGISTRO");
		}
		
		this.agente = new Agente();
	}
	
	public void alterar(){
		try{
			agenteService.alterar(agente);
			FacesUtil.exibeSucesso("REGISTRO ALTERADO COM SUCESSO");
			this.agente = new Agente();
		}catch (RuntimeException e) {
			FacesUtil.exibeErro("PROBLEMA AO ALTERAR REGISTRO");
		}
	}
	
	
	//Metodos Getters and Setters
	public Agente getAgente() {
		return agente;
	}

	public void setAgente(Agente agente) {
		this.agente = agente;
	}

	private List<Agente> agentes;
		
	
	
	public void excluir(Agente agente){
		try{
			agenteService.remover(agente);
			FacesUtil.exibeSucesso("REGISTRO REMOVIDO COM SUCESSO");
		}catch (Exception e) {
			FacesUtil.exibeErro("PROBLEMA AO REMOVER REGISTRO");
		}
	}

	public List<Agente> getAgentes() {
		return agenteService.lista();
	}

	public void setAgentes(List<Agente> agentes) {
		this.agentes = agentes;
	}
	
}
