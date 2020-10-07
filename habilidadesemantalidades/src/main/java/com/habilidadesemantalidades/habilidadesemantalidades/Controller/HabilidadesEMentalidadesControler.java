package com.habilidadesemantalidades.habilidadesemantalidades.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/atividade1")
public class HabilidadesEMentalidadesControler {
	@GetMapping
	public String HabilidadesEMentalidades() {
		return "As Habilidades e Mentalidades utilizadas para desenvolver essa atividade foram:\nAtenção aos detalhes;\nMentalidade de Crescimento;\nOrientação ao Futuro;\nPersistência;\nResponsabilidade Pessoal.";
	}
}
