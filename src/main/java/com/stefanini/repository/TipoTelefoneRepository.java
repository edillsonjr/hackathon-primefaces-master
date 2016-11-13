package com.stefanini.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.stefanini.model.TipoTelefone;

public class TipoTelefoneRepository {

	@Inject
	private EntityManager manager;
	
	public void incluir(TipoTelefone tipoTelefone) {
		this.manager.persist(tipoTelefone);
	}

	public void altera(TipoTelefone tipoTelefone) {
		this.manager.merge(tipoTelefone);
	}

	public TipoTelefone busca(Integer id) {
		return this.manager.find(TipoTelefone.class, id);
	}

	public List<TipoTelefone> lista() {
		return this.manager.createQuery("select c from TipoTelefone c", TipoTelefone.class)
				.getResultList();
	}
	
	
}
