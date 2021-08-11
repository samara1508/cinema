package br.com.triersistemas.cineminha.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.triersistemas.cineminha.storage.SalvaDados;

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

	public Integer calcularIdade() {
		LocalDate hoje = LocalDate.now();
		LocalDate nasc = this.dataNascimento;
		Integer idade = 0;
		if (nasc.getMonthValue() < hoje.getMonthValue()
				|| (nasc.getMonthValue() == hoje.getMonthValue() && nasc.getDayOfMonth() <= hoje.getDayOfMonth())) {
			idade = hoje.getYear() - nasc.getYear();
		} else {
			idade = (hoje.getYear() - nasc.getYear()) - 1;
		}
		return idade;
	}
	
	public void addFilmes () {
		CaracteristicasFilmesModel a = new CaracteristicasFilmesModel(EnumNomeFilmeModel.PRESSAGIO, EnumClassificacaoFilmeModel.MAIOR_DE_IDADE);
		SalvaDados.filmes.add(a);
		CaracteristicasFilmesModel b = new CaracteristicasFilmesModel(EnumNomeFilmeModel.ANNABELLE, EnumClassificacaoFilmeModel.MAIOR_DE_IDADE);
		SalvaDados.filmes.add(b);
		CaracteristicasFilmesModel c = new CaracteristicasFilmesModel(EnumNomeFilmeModel.FRAGMENTADO, EnumClassificacaoFilmeModel.MAIOR_DE_IDADE);
		SalvaDados.filmes.add(c);
		CaracteristicasFilmesModel d = new CaracteristicasFilmesModel(EnumNomeFilmeModel.MATILDA, EnumClassificacaoFilmeModel.MENOR_DE_IDADE);
		SalvaDados.filmes.add(d);
		CaracteristicasFilmesModel e = new CaracteristicasFilmesModel(EnumNomeFilmeModel.GARFIELD, EnumClassificacaoFilmeModel.MENOR_DE_IDADE);
		SalvaDados.filmes.add(e);
		CaracteristicasFilmesModel f = new CaracteristicasFilmesModel(EnumNomeFilmeModel.INTERESTELAR, EnumClassificacaoFilmeModel.MENOR_DE_IDADE);
		SalvaDados.filmes.add(f);
	}
}
