package br.com.triersistemas.cineminha.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FilmeModel {

	private EnumNomeFilmeModel nome;
	private EnumTipoFilmeModel tipo;
	private BigDecimal valor;
	private EnumClassificacaoFilmeModel classificacao;
	private LocalDate dataNascimento;

	public FilmeModel(EnumNomeFilmeModel nome, EnumTipoFilmeModel tipo, String dataNascimento) {
		this.nome = nome;
		this.tipo = tipo;
		this.dataNascimento = LocalDate.parse(dataNascimento, DateTimeFormatter.ISO_LOCAL_DATE);
		this.tipo = tipo;
		this.valor = BigDecimal.valueOf(20);
	}

	public EnumNomeFilmeModel getNome() {
		return nome;
	}

	public EnumTipoFilmeModel getTipo() {
		return tipo;
	}

	public EnumClassificacaoFilmeModel getClassificacao() {
		return classificacao;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public BigDecimal getValorTotal() {
		BigDecimal valorTotal = BigDecimal.ZERO;
		valorTotal = getValor();

		if (getTipo().equals(EnumTipoFilmeModel.TRIDIMENSIONAL)) {
			valorTotal = valorTotal.add(BigDecimal.valueOf(5));
		}

		if (calcularIdade().compareTo(18) < 0) {
			valorTotal = valorTotal.divide(BigDecimal.valueOf(2));
		}
		return valorTotal;
	}

//	public String[] nomeFilme () {
//		String[] filmes = {"O presságio", "Interestelar", "Harry Potter", 
//							"Matilda", "O chamado", "Jogos Mortais"};
//		if (super.getNome().equals(EnumNomeFilmeModel.PRESSAGIO)) {
//			return filmes[0];
//		}
//	}

	public Integer calcularIdade() {
		LocalDate hoje = LocalDate.now();
		LocalDate nasc = this.dataNascimento;
		Integer idade = 0;
		Boolean maioridade = false;
		if (nasc.getMonthValue() < hoje.getMonthValue()
				|| (nasc.getMonthValue() == hoje.getMonthValue() && nasc.getDayOfMonth() <= hoje.getDayOfMonth())) {
			idade = hoje.getYear() - nasc.getYear();
		} else {
			idade = (hoje.getYear() - nasc.getYear()) - 1;
		}
		return idade;
	}
}
