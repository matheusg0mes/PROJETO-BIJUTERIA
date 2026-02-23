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
import br.com.projeto.ecommerce.model.Variantes;
import br.com.projeto.ecommerce.service.variantes.IVariantesService;

@RestController
public class VariantesController {
	
	@Autowired
	private IVariantesService var;
	
	@PostMapping("/variantes")
	public ResponseEntity<Variantes> cadastrarVariante(@RequestBody Variantes novo){
		Variantes result = var.cadastrarNova(novo);
		return ResponseEntity.ok(result);
	}

	@PutMapping("/variantes/{id}")
	public ResponseEntity<Variantes> alterarVariante(@RequestBody Variantes alterar,@PathVariable Integer id){
		Variantes novo = alterar;
		novo.setId(id);
		Variantes result = var.alterarVariante(novo);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/variantes")
	public ResponseEntity<List<Variantes>> recuperarLista(@RequestParam(name = "id") Integer id){
		Produtos novo = new Produtos();
		novo.setId(id);
		try {
			List<Variantes> test = var.recuperarPorProduto(novo);
			return ResponseEntity.ok(test);
		}catch(Exception ex) {
			return ResponseEntity.notFound().build();
		}
	}
}
