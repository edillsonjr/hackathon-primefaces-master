package com.stefanini.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.TipoInfracao;
import com.stefanini.service.TipoInfracaoService;
import com.stefanini.util.FacesUtil;

@Named("tipoinfracaoMB")
@RequestScoped
public class TipoInfracaoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private TipoInfracao tipo;
	
	@Inject
	private TipoInfracaoService tipoService;

	public TipoInfracao getTipo() {
		return tipo;
	}

	public void setTipo(TipoInfracao tipo) {
		this.tipo = tipo;
	}

	public void cadastrar() {
		try {
			tipoService.incluir(tipo);
			FacesUtil.exibeSucesso("REGISTRO INSERIDO COM SUCESSO");
		} catch (RuntimeException e) {
			e.printStackTrace();
			FacesUtil.exibeErro("PROBLEMA AO INSERIR REGISTRO");
		}
		
		this.tipo = new TipoInfracao();
	}
	
	public List<TipoInfracao> tiposInfracoes(){
		return tipoService.listar();
	}

}
