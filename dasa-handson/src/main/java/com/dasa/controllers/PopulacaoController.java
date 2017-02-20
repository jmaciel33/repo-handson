package com.dasa.controllers;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dasa.domain.DadoPopulacional;
import com.dasa.domain.EstatisticaAnoResponse;
import com.dasa.service.DadosPopulacionaisService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/parteUm")
public class PopulacaoController {

	@Autowired
	private DadosPopulacionaisService service;

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = BigDecimal.class), @ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 403, message = "Forbidden"), @ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
	@RequestMapping(value = "populacaoTotal/{year}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public BigDecimal getPopulacaoTotalAno(@PathVariable(value = "year") String year) {
		DadoPopulacional pop = service.obterPopulacaoPorAno(Optional.of(year));
		return pop.getPopulacaoTotal();
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = EstatisticaAnoResponse.class), @ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 403, message = "Forbidden"), @ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
	@RequestMapping(value = "percentual/{year}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public EstatisticaAnoResponse getPercentualAno(@PathVariable(value = "year") String year) {
		DadoPopulacional pop = service.obterPopulacaoPorAno(Optional.of(year));
		EstatisticaAnoResponse estatisticaAnoResponse = new EstatisticaAnoResponse(pop);
		BigDecimal homens = estatisticaAnoResponse.calcPorcentagem(pop.getTotalHomens(), pop.getPopulacaoTotal().longValue());
		BigDecimal mulheres = estatisticaAnoResponse.calcPorcentagem(pop.getTotalMulheres(), pop.getPopulacaoTotal().longValue());
		estatisticaAnoResponse.setTotalHomens(homens.longValue());
		estatisticaAnoResponse.setTotalMulheres(mulheres.longValue());
		return estatisticaAnoResponse;
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = EstatisticaAnoResponse.class), @ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 403, message = "Forbidden"), @ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
	@RequestMapping(value = "crescimentoPopulacional/2017", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public EstatisticaAnoResponse getCrescimentoPopulacional2017() {
		DadoPopulacional pop = service.obterPopulacaoPorAno(Optional.of("2000"));
		DadoPopulacional pop2016 = service.obterPopulacaoPorAno(Optional.of("2016"));

		EstatisticaAnoResponse a = new EstatisticaAnoResponse(pop);

		a.setAno("2017");
		BigDecimal popTotal2017 = a.crescimentoPopulacional(pop.getPopulacaoTotal().longValue(), pop2016.getPopulacaoTotal().longValue());
		BigDecimal homensTotal2017 = a.crescimentoPopulacional(pop.getTotalHomens().longValue(), pop2016.getTotalHomens().longValue());
		BigDecimal mulheresTotal2017 = a.crescimentoPopulacional(pop.getTotalMulheres().longValue(), pop2016.getTotalMulheres().longValue());

		a.setPopulacaoTotal(popTotal2017);
		a.setTotalHomens(homensTotal2017.longValue());
		a.setTotalMulheres(mulheresTotal2017.longValue());

		return a;
	}

}
