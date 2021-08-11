package br.com.triersistemas.cineminha.model;

public class CaracteristicasFilmesModel {
	
	private static long gerador = 0;
	
	private Long id;
	private EnumNomeFilmeModel nome;
	private EnumClassificacaoFilmeModel classi;

	public CaracteristicasFilmesModel(EnumNomeFilmeModel nome, EnumClassificacaoFilmeModel classi) {
		this.classi = classi;
		this.nome = nome;
		this.id = ++gerador;
		this.nome = nome;
	}

	public EnumNomeFilmeModel getNome() {
		return nome;
	}

	public EnumClassificacaoFilmeModel getClassi() {
		return classi;
	}

	public Long id() {
		return id;
	}
}
