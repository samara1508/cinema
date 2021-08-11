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
import br.com.triersistemas.cineminha.storage.SalvaDados;

@RestController
@RequestMapping("/cinema")
public class CinemaController {
	
//  faltou:
//	pagar
//	mostrar assentos vagos
	
	@GetMapping("/escolher")
	public String escolher(@RequestParam EnumNomeFilmeModel nome,
						   @RequestParam EnumTipoFilmeModel tipo,
						   @RequestParam (value = "data") String dataNascimento) {
		
		FilmeModel f = new FilmeModel(nome, tipo, dataNascimento);
		return "Nome do filme: "
			   + nome
			   + "Valor a Pagar: R$"
			   + f.getValorTotal();
	}
	
//	@GetMapping("/escolher")
//	public String escolher(@RequestParam EnumNomeFilmeModel nome,
//						   @RequestParam EnumTipoFilmeModel tipo,
//						   @RequestParam (value = "data") String dataNascimento) {
//		
//		for (int i = 0; i < SalvaDados.filmes.size(); i++) {
//			if(nome.equals(SalvaDados.filmes.get(i).getNome())) {
//				FilmeModel f = new FilmeModel(nome, tipo, dataNascimento);
//				return "Filme:............"
//					 + SalvaDados.filmes.get(i).getNome()
//					 + "\n"
//					 + "Classificação:...."
//					 + SalvaDados.filmes.get(i).getClassi()
//					 + "\n"
//					 + "O valor é: R$ "
//					 + f.getValorTotal();
//			}
//		}
//		return null;
//	}
}
