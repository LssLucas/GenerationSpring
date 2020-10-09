package com.minhaLojaGames.toPlayQueer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minhaLojaGames.toPlayQueer.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	public List<Usuario> findAllByNomeContainingIgnoreCase (String nome);
}
