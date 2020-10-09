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

import com.minhaLojaGames.toPlayQueer.model.Usuario;
import com.minhaLojaGames.toPlayQueer.repository.UsuarioRepository;

@RestControllerAdvice
@RequestMapping("/usuario")
@CrossOrigin("*")
public class UsuarioController {

		@Autowired
		private UsuarioRepository repository;
		
		@GetMapping
		public ResponseEntity<List<Usuario>> getAll (){
			return ResponseEntity.ok(repository.findAll());
		}
		
		@GetMapping("/{id}")
		public ResponseEntity <Usuario> getById(@PathVariable long idUsuario){
			return repository.findById(idUsuario)
					.map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
		}
		
		@GetMapping("/nome/{nome}")//caminho URI
		public ResponseEntity<List<Usuario>> getByNome(@PathVariable String descricaoUsuario){
			return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(descricaoUsuario));
		}
		
		@PostMapping
		public ResponseEntity <Usuario> post (@RequestBody Usuario tb_usuario){
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tb_usuario));
		}
		
		@PutMapping
		public ResponseEntity <Usuario> put (@RequestBody Usuario tb_usuario){
			return ResponseEntity.status(HttpStatus.OK).body(repository.save(tb_usuario));
		}
		
		@DeleteMapping("/{idUsuario}")//para passar um parametro é constrida essa estrutura
		public void delete (@PathVariable long idUsuario) {
			repository.deleteById(idUsuario);
		}
}