package com.stefanini.service;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.stefanini.model.Telefone;
import com.stefanini.repository.TelefoneRepository;

@Stateless
public class TelefoneService {

	@Inject
	private TelefoneRepository telefoneRepository;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void incluir(Telefone telefone){
		telefoneRepository.incluir(telefone);
    }
	
}
