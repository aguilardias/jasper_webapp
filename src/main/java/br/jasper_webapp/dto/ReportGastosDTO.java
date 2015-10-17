package br.jasper_webapp.dto;

import java.util.List;

public class ReportGastosDTO {

	private List<LinhaGastosDTO> linhas;

	public List<LinhaGastosDTO> getLinhas() {
		return linhas;
	}

	public void setLinhas(List<LinhaGastosDTO> linhas) {
		this.linhas = linhas;
	}
	
	
}
