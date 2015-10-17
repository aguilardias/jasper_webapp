package br.jasper_webapp.rest;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import br.gov.frameworkdemoiselle.report.Report;
import br.gov.frameworkdemoiselle.report.Type;
import br.jasper_webapp.business.AreaBC;
import br.jasper_webapp.entity.ReportAreaDTO;

@Path("area")
public class AreaREST {

	@Inject
	private AreaBC bc;

	private static final String JASPER = "reports/4-com-tabela.jasper";

	@Inject
	@br.gov.frameworkdemoiselle.report.annotation.Path(JASPER)
	private Report relatorio;

	@GET
	@Path("listar")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response report1() {


		List<ReportAreaDTO> lista = new ArrayList<ReportAreaDTO>();
		ReportAreaDTO report = new ReportAreaDTO();
		report.setLinhas(bc.findAll());
		lista.add(report);


		byte[] buffer = relatorio.export(lista, new HashMap<String, Object>(), Type.PDF);
		ResponseBuilder response = Response.ok(buffer);

		response.type("application/pdf");
		response.header("Content-Disposition", "attachment; filename=newfile.pdf");
		
		return response.build();
	}


	
}
