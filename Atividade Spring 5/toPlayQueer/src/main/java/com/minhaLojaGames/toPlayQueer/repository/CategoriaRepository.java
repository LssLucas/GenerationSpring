package com.minhaLojaGames.toPlayQueer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minhaLojaGames.toPlayQueer.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	public List<Categoria> findAllBydescricaoCategoriaContainingIgnoreCase (String descricaoCategoria);
}
