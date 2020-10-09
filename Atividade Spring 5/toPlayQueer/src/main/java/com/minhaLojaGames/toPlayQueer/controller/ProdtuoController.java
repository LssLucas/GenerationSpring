package com.minhaLojaGames.toPlayQueer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.minhaLojaGames.toPlayQueer.model.Produto;
import com.minhaLojaGames.toPlayQueer.repository.ProdutoRepository;

@RestControllerAdvice
@RequestMapping("/produto")
@CrossOrigin("*")
public class ProdtuoController {
	@Autowired
	private ProdutoRepository repository;
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> getById(@PathVariable long id ){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")//caminho URI
	public ResponseEntity<List<Produto>> getByTitulo(@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity <Produto> post (@RequestBody Produto tb_produto){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tb_produto));
	}
	
	@PutMapping
	public ResponseEntity <Produto> put (@RequestBody Produto tb_produto){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(tb_produto));
	}
	
	@DeleteMapping("/{idUsuario}")//para passar um parametro é constrida essa estrutura
	public void delete (@PathVariable long idUsuario) {
		repository.deleteById(idUsuario);
	}
}
