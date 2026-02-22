package br.com.projeto.ecommerce.service.produto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projeto.ecommerce.model.Produtos;

public interface IProdutosService {
	
	public Produtos criarProduto(Produtos novo);
	public Produtos alterarProduto(Produtos alterar);
	public List<Produtos> recuperarTodosOsProdutos();
	public List<Produtos> recuperarPalavraSecreta(String palavra);
	

}
