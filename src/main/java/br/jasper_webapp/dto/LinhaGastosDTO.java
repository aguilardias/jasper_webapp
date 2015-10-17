package br.jasper_webapp.dto;

import java.math.BigDecimal;

public class LinhaGastosDTO {

	private String data;
	private String nome;
	private BigDecimal valor;
	
	public LinhaGastosDTO(String data, String nome, BigDecimal valor) {		
		this.data = data;
		this.nome = nome;
		this.valor = valor;
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	
	

	
	
	
}
