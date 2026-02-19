package br.com.projeto.ecommerce.service.categoria;

import java.util.List;

import br.com.projeto.ecommerce.model.Categoria;

public interface ICategoriaService {

	public Categoria novaCategoria(Categoria novo);
	public Categoria alterarCategoria(Categoria alterar);
	public List<Categoria> todosAsCategorias();
	public void apagarCategoria(Integer id);
}
