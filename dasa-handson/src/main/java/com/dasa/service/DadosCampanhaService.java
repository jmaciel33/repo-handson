package com.dasa.service;

import java.util.List;
import java.util.Optional;

import com.dasa.domain.DadosCampanha;

public interface DadosCampanhaService {
	
	/**
	 * Lista dados campanha
	 * @param ano
	 * @return
	 */
    List<DadosCampanha> obterCampanhasPorAno(final Optional<String>  ano);
    
	/**
	 * Lista dados campanha
	 * @param ano
	 * @return
	 */
    List<DadosCampanha> obterCampamhasPorAnoECampanha(final String ano, final int campanha);

	/**
	 * Lista dados campanha PorAnoECampanhaESexo
	 * @param ano
	 * @return
	 */
    List<DadosCampanha> obterCampamhasPorAnoECampanhaESexo(final String ano, final int campanha, final String sexo);
    
    /**
     * Insere dados campanha
     * @param dadosCampanha
     * @return DadosCampanha
     */
    DadosCampanha inserirDadosCampanha(DadosCampanha dadosCampanha);

}
