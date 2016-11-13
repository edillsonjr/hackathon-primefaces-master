package com.stefanini.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.stefanini.model.TipoInfracao;

public class TipoInfracaoRepository {

	@Inject
	private EntityManager manager;
	
	public void incluir(TipoInfracao tipoInfracao) {
		this.manager.persist(tipoInfracao);
	}

	public void altera(TipoInfracao tipoInfracao) {
		this.manager.merge(tipoInfracao);
	}

	public TipoInfracao busca(Integer id) {
		return this.manager.find(TipoInfracao.class, id);
	}

	public List<TipoInfracao> lista() {
		return this.manager.createQuery("select c from TipoInfracao c", TipoInfracao.class)
				.getResultList();
	}
	
	
}
