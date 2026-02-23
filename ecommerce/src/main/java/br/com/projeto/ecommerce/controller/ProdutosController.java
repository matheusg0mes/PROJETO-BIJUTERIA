package br.com.projeto.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.ecommerce.model.Produtos;
import br.com.projeto.ecommerce.service.produto.IProdutosService;

@RestController
public class ProdutosController {
	
	@Autowired
	private IProdutosService produto;

	@GetMapping("/produtos")
	public ResponseEntity<List<Produtos>> todosOsProdutos(){
		return ResponseEntity.ok(produto.recuperarTodosOsProdutos());
	}
	
	@PostMapping("/produtos")
	public ResponseEntity<Produtos> criarNovoProduto(@RequestBody Produtos novo){
		return ResponseEntity.ok(produto.criarProduto(novo));
	}
	
	@PutMapping("/produtos/{id}")
	public ResponseEntity<Produtos> alterarProduto(@RequestBody Produtos alterar, @PathVariable Integer id){
		alterar.setId(id);
		try {
			Produtos novo = produto.alterarProduto(alterar);
			return ResponseEntity.status(201).body(novo);
		}catch(Exception ex) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/produtos/search")
	public ResponseEntity<List<Produtos>> retornarPorPalavra(@RequestParam(name = "key") String nome){
		try {
			List<Produtos> result = produto.recuperarPalavraSecreta(nome);
			return ResponseEntity.ok(result);
		}catch(Exception ex) {
			return ResponseEntity.notFound().build();
		}
	}
}
