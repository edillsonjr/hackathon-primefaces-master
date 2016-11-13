package com.stefanini.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.stefanini.model.TipoTelefone;
import com.stefanini.repository.TipoTelefoneRepository;

@Stateless
public class TipoTelefoneService {
	
	@Inject
	private TipoTelefoneRepository tipoTelefoneRepository;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void incluir(TipoTelefone tipoTelefone){
		tipoTelefoneRepository.incluir(tipoTelefone);
    }

	public List<TipoTelefone> listar() {
		return tipoTelefoneRepository.lista();
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public TipoTelefone buscar(Integer id) {
		return tipoTelefoneRepository.busca(id);
	}


}
