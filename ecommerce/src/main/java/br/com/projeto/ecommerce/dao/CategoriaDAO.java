package br.com.projeto.ecommerce.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.projeto.ecommerce.model.Categoria;

public interface CategoriaDAO extends CrudRepository<Categoria, Integer>{

	public List<Categoria> findAllByOrderByNameAsc();
}
