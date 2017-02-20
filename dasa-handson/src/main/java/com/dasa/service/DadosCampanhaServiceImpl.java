package com.dasa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dasa.domain.DadosCampanha;
import com.dasa.repository.DadosCampanhaRepository;

@Service
public class DadosCampanhaServiceImpl implements DadosCampanhaService {

	@Autowired
	private DadosCampanhaRepository dadosCampanhaRepository;

	@Override
	public List<DadosCampanha> obterCampanhasPorAno(Optional<String> ano) {
		final String anoCenso = ano.get();

		if (!ano.isPresent()) {
			throw new IllegalArgumentException("Parametro Ano obrigatorio");
		}

		return dadosCampanhaRepository.findByAno(anoCenso);
	}

	@Override
	public DadosCampanha inserirDadosCampanha(DadosCampanha dadosCampanha) {
		return dadosCampanhaRepository.save(dadosCampanha);
	}

	@Override
	public List<DadosCampanha> obterCampamhasPorAnoECampanha(String ano, int campanha) {
		return dadosCampanhaRepository.findByAnoAndCampanha(ano, campanha);
	}

	@Override
	public List<DadosCampanha> obterCampamhasPorAnoECampanhaESexo(String ano, int campanha, String sexo) {
		return dadosCampanhaRepository.findByAnoAndCampanhaAndSexo(ano, campanha, sexo);
	}

}
