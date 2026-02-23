package br.com.projeto.ecommerce.service.variantes;

import java.util.List;

import br.com.projeto.ecommerce.model.Produtos;
import br.com.projeto.ecommerce.model.Variantes;

public interface IVariantesService {
	
	public Variantes cadastrarNova(Variantes novo);
	public Variantes alterarVariante(Variantes novo);
	public List<Variantes> recuperarPorProduto(Produtos produto);
}
