package br.com.triersistemas.cineminha.controller;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.triersistemas.cineminha.model.EnumNomeFilmeModel;
import br.com.triersistemas.cineminha.model.EnumTipoFilmeModel;
import br.com.triersistemas.cineminha.model.FilmeModel;

@RestController
@RequestMapping("/cinema")
public class CinemaController {
	
//  escolher o filme
//	validar idade
//	pagar
//	mostrar assentos vagos
	@GetMapping("/escolher")
	public String escolher(@RequestParam EnumNomeFilmeModel nome,
							   @RequestParam EnumTipoFilmeModel tipo,
							   @RequestParam (value = "data") String dataNascimento) {
		FilmeModel f = new FilmeModel(nome, tipo, dataNascimento);
		return "O valor é: R$ "
				+ f.getValorTotal().scale(2, );
	}
}
