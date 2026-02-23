package br.com.projeto.ecommerce.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.projeto.ecommerce.model.Produtos;
import br.com.projeto.ecommerce.model.Variantes;

public interface VariantesDAO extends CrudRepository<Variantes,Integer>{

	public List<Variantes> findByProduto(Produtos p);
}
