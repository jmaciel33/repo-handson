package com.dasa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dasa.domain.DadosCampanha;
import com.dasa.service.DadosCampanhaService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/parteDois")
public class CampanhaController {

	@Autowired
	private DadosCampanhaService service;

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = boolean.class), @ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 403, message = "Forbidden"), @ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
	@RequestMapping(value = "/inserirDadoCampanha", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public DadosCampanha inserirDadosCampanha(@RequestBody DadosCampanha dadosCampanha) {
		return service.inserirDadosCampanha(dadosCampanha);
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = boolean.class), @ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 403, message = "Forbidden"), @ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
	@RequestMapping(value = "/buscaAnoCampanha", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public List<DadosCampanha> buscaFiltroCampanhaEAno(@RequestParam String ano, int campanha) {
		return service.obterCampamhasPorAnoECampanha(ano, campanha);
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = boolean.class), @ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 403, message = "Forbidden"), @ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
	@RequestMapping(value = "/buscaAnoCampanhaSexo", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public List<DadosCampanha> buscaFiltroCampanhaEAnoESexo(@RequestParam String ano, @RequestParam int campanha, @RequestParam String sexo) {
		return service.obterCampamhasPorAnoECampanhaESexo(ano, campanha, sexo);
	}

}
