package com.stefanini.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.stefanini.model.TipoInfracao;
import com.stefanini.repository.TipoInfracaoRepository;

@Stateless
public class TipoInfracaoService {


	@Inject
	private TipoInfracaoRepository tipoInfracaoRepository;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void incluir(TipoInfracao tipoInfracao){
		tipoInfracaoRepository.incluir(tipoInfracao);
    }
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<TipoInfracao> listar() {
		return tipoInfracaoRepository.lista();
	}

	public TipoInfracao buscar(Integer tipoId) {
		return tipoInfracaoRepository.busca(tipoId);
	}
	
}
