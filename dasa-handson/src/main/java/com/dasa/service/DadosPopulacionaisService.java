package com.dasa.service;

import java.util.Optional;

import com.dasa.domain.DadoPopulacional;

public interface DadosPopulacionaisService {

	/**
	 * Obtem DadoPopulacional por ano
	 * 
	 * @param ano
	 * @return
	 */
	DadoPopulacional obterPopulacaoPorAno(final Optional<String> ano);

}
