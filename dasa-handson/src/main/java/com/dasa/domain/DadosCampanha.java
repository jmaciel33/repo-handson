package com.dasa.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
@Table(name = "dados_campanhas")
public class DadosCampanha implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("id")
	private Long id;

	@JsonProperty("ano")
	private String ano;
	@JsonProperty("campanha")
	private int campanha;
	@JsonProperty("sexo")
	private String sexo;

	public DadosCampanha() {
		super();
	}

	public DadosCampanha(@JsonProperty("id") Long id, @JsonProperty("ano") String ano, @JsonProperty("campanha") int campanha, @JsonProperty("sexo") String sexo) {
		this.id = id;
		this.ano = ano;
		this.campanha = campanha;
		this.sexo = sexo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public int getCampanha() {
		return campanha;
	}

	public void setCampanha(int campanha) {
		this.campanha = campanha;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

}
