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

import br.com.projeto.ecommerce.model.Clientes;
import br.com.projeto.ecommerce.service.clientes.IClientesService;

@RestController
public class ClientesController {
	
	@Autowired
	private IClientesService cli;

	@GetMapping("/clientes")
	public ResponseEntity<List<Clientes>> getall(){
		return ResponseEntity.ok(cli.listaDeClientes());
	}
	
	@GetMapping("/clientes/{id}")
	public ResponseEntity<Clientes> getById(@PathVariable("id") Integer id){
		Clientes  cl = cli.buscarPorId(id);
		if(cl != null) {
			return ResponseEntity.ok(cl);
		}else
			return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/clientes")
	public ResponseEntity<Clientes> novoClientes(@RequestBody Clientes novo){
		try {
			Clientes cl = cli.cadastrarCliente(novo);
			return ResponseEntity.ok(cl);
		}catch(Exception e){
			System.out.println("Não foi possivel cadastrar novo cliente");
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/clientes/{id}")
	public ResponseEntity<Clientes> update(@RequestBody Clientes cliente, @PathVariable("id") Integer id){
		cliente.setId(id);
		try {
			Clientes result = cli.alterarCliente(cliente);
			if(result != null) {
				return ResponseEntity.status(201).body(result);
			}
		}catch(Exception ex) {
			System.out.println("Não foi possivel alterar o cliente "+ ex.getMessage());
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/clientes/busca")
	public ResponseEntity<Clientes> findByTelefone(@RequestParam(name="telefone") String telefone){
		Clientes result = cli.buascarPorTelefone(telefone);
		return ResponseEntity.ok(result);
	}
}

