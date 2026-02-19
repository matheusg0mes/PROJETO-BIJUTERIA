package br.com.projeto.ecommerce.service.categoria;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.projeto.ecommerce.dao.CategoriaDAO;
import br.com.projeto.ecommerce.model.Categoria;

@Component
public class CategoriaService implements ICategoriaService {
	@Autowired
	private CategoriaDAO dao;
	
	@Override
	public Categoria novaCategoria(Categoria novo) {
		 return dao.save(novo);
	}

	@Override
	public Categoria alterarCategoria(Categoria alterar) {
		return dao.save(alterar);
	}

	@Override
	public List<Categoria> todosAsCategorias() {
		return dao.findAllByOrderByNameAsc();
	}

	@Override
	public void apagarCategoria(Integer id) {
		dao.deleteById(id);
	}

}
