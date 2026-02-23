package br.com.projeto.ecommerce.service.variantes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.projeto.ecommerce.dao.VariantesDAO;
import br.com.projeto.ecommerce.model.Produtos;
import br.com.projeto.ecommerce.model.Variantes;

@Component
public class VariantesServiceImple implements IVariantesService{
	
	@Autowired
	private VariantesDAO dao;

	public Variantes cadastrarNova(Variantes novo) {
		return dao.save(novo);
	}

	@Override
	public Variantes alterarVariante(Variantes novo) {
		return dao.save(novo);
	}

	@Override
	public List<Variantes> recuperarPorProduto(Produtos produto) {
		return dao.findByProduto(produto);
	}

}
