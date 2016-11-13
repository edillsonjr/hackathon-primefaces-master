package com.stefanini.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.stefanini.model.Categoria;

public class CategoriaRepository {

	@Inject
	private EntityManager manager;
	
	public void incluir(Categoria categoria) {
		this.manager.persist(categoria);
	}
	
	public void alterar(Categoria categoria) {
		this.manager.merge(categoria);
	}
	
	public Categoria buscar(Integer id) {
		return this.manager.find(Categoria.class, id);
	}
	
	public List<Categoria> lista() {
		return this.manager.createQuery("select a from Categoria a", Categoria.class).getResultList();
	}
	
}
