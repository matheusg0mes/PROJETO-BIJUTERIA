package br.com.projeto.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.ecommerce.model.Categoria;
import br.com.projeto.ecommerce.service.categoria.ICategoriaService;

@RestController
public class CategoriaController {

	@Autowired
	private ICategoriaService cate;
	
	@GetMapping("/categoria")
	public ResponseEntity<List<Categoria>> recuperarTodas(){
		
		return ResponseEntity.ok(cate.todosAsCategorias());
	}
	
	@PostMapping("/categoria")
	public ResponseEntity<Categoria> cadastrarCategoria(@RequestBody Categoria novo) {
		return ResponseEntity.ok(cate.novaCategoria(novo));
	}
	
	@DeleteMapping("/categoria/{id}")
	public ResponseEntity<String> deletarCategoria(@PathVariable("id") Integer id){
		try {
			cate.apagarCategoria(id);
			return ResponseEntity.ok("removido");
		}catch(Exception ex) {
		return ResponseEntity.notFound().build();
	}
	}
}
