package com.farmacia.milEUmMedicamnetos.controller;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

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

import com.farmacia.milEUmMedicamnetos.model.Categoria;
import com.farmacia.milEUmMedicamnetos.repository.CategoriaRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@RestControllerAdvice
@RequestMapping("/categoria")
@CrossOrigin("*")
public class CategoriaController {
	@Autowired
	private CategoriaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> GetAll (){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity <Categoria> GetById(@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nomeCategoria/{nomeCategoria}")//caminho URI
	public ResponseEntity<List<Categoria>> GetByTitulo(@PathVariable String nomeCategoria){
		return ResponseEntity.ok(repository.findAllByNomeCategoriaContainingIgnoreCase(nomeCategoria));
	}
	
	@PostMapping
	public ResponseEntity <Categoria> post (@RequestBody Categoria tb_categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tb_categoria));
	}
	
	@PutMapping
	public ResponseEntity <Categoria> put (@RequestBody Categoria tb_categoria){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(tb_categoria));
	}
	
	@DeleteMapping("/{id}")//para passar um parametro é constrida essa estrutura
	public void delete (@PathVariable long id) {
		repository.deleteById(id);
	}
	
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("categoria")//necessÃ¡rio digitar
	private List<Categoria> categoria;
	
}