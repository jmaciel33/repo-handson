package com.dasa.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

import lombok.Data;

@Data
public class EstatisticaAnoResponse {

	private String ano;
	private BigDecimal populacaoTotal;
	private Long totalHomens;
	private Long totalMulheres;

	public EstatisticaAnoResponse(DadoPopulacional pop) {
		this.ano = pop.getAno();
		this.populacaoTotal = pop.getPopulacaoTotal();
		this.totalHomens = pop.getTotalHomens();
		this.totalMulheres = pop.getTotalMulheres();
	}

	public String getAno() {
		return ano;
	}

	public BigDecimal getPopulacaoTotal() {
		return populacaoTotal;
	}

	public void setPopulacaoTotal(BigDecimal populacaoTotal) {
		this.populacaoTotal = populacaoTotal;
	}

	public Long getTotalHomens() {
		return totalHomens;
	}

	public void setTotalHomens(Long totalHomens) {
		this.totalHomens = totalHomens;
	}

	public Long getTotalMulheres() {
		return totalMulheres;
	}

	public void setTotalMulheres(Long totalMulheres) {
		this.totalMulheres = totalMulheres;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public BigDecimal calcPorcentagem(long totalPessoas, long populacaoTotal) {
		BigDecimal proportion = (BigDecimal.valueOf(totalPessoas)).divide(BigDecimal.valueOf(populacaoTotal), 2, RoundingMode.HALF_UP);
		return proportion.multiply(new BigDecimal(100));
	}

	public BigDecimal crescimentoPopulacional(long populacaoAntiga, long populacaoAtual) {
		BigDecimal proportion = (BigDecimal.valueOf(populacaoAtual)).divide(BigDecimal.valueOf(populacaoAntiga), 2, RoundingMode.HALF_UP);
		BigDecimal propPow = proportion.pow(10);

		return propPow.subtract(new BigDecimal(1));
	}

}
