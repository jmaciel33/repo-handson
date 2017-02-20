package com.dasa.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.dasa.domain.DadosCampanha;

@Transactional
public interface DadosCampanhaRepository extends CrudRepository<DadosCampanha, Long>{
	/**
	 * Busca DadosCampanha por ano
	 * @param ano
	 * @return List<DadosCampanha>
	 */
	List<DadosCampanha> findByAno(final String ano);
	
	/**
	 * Busca dados por ano e campanha
	 * @param ano
	 * @param campanha
	 * @return List<DadosCampanha>
	 */
	List<DadosCampanha> findByAnoAndCampanha(final String ano, final int campanha);
	
	/**
	 * Busca por AnoAndCampanhaAndSexo
	 * @param ano
	 * @param campanha
	 * @param sexo
	 * @return
	 */
	List<DadosCampanha> findByAnoAndCampanhaAndSexo(final String ano, final int campanha,final String sexo);
}
