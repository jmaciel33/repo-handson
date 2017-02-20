package com.dasa.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.dasa.domain.DadoPopulacional;

@Transactional
public interface DadosPopulacionaisRepository extends CrudRepository<DadoPopulacional, Long> {

	/**
	 * Busca DadoPopulacional por ano 
	 * @param ano
	 * @return
	 */
    DadoPopulacional findByAno(final String ano);

}
