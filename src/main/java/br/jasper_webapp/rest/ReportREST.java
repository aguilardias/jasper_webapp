package br.jasper_webapp.rest;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import br.gov.frameworkdemoiselle.report.Report;
import br.gov.frameworkdemoiselle.report.Type;
import br.jasper_webapp.business.AreaBC;
import br.jasper_webapp.business.GastoBC;
import br.jasper_webapp.business.PessoaBC;
import br.jasper_webapp.dto.ReportAreaDTO;
import br.jasper_webapp.dto.ReportGastosDTO;

@Path("report")
public class ReportREST {

	@Inject
	private AreaBC areaBC;
	
	@Inject
	private GastoBC gastosBC;
	
	@Inject
	private PessoaBC pessoaBC;
	
	private static final String JASPER_PESSOAS = "reports/pessoas.jasper";

	private static final String JASPER_AREAS = "reports/areas.jasper";
	
	private static final String JASPER_GASTOS = "reports/gastos.jasper";	
	

	@Inject
	@br.gov.frameworkdemoiselle.report.annotation.Path(JASPER_PESSOAS)
	private Report relatorioPessoas;
	
	@Inject
	@br.gov.frameworkdemoiselle.report.annotation.Path(JASPER_AREAS)
	private Report relatorioAreas;
	
	@Inject
	@br.gov.frameworkdemoiselle.report.annotation.Path(JASPER_GASTOS)
	private Report relatorioGastos;
	
	private final String XLS = "xls";
	

	@GET
	@Path("pessoas")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response noticias(@QueryParam("filetype") String filetype, 
			@QueryParam("filename") String filename) {
		
		Type tipo = Type.PDF;
		String responseType = "application/pdf";		
		if (filetype.equals(XLS)) {
			tipo = Type.XLS;
			responseType =  "application/vnd.ms-excel";
		}
		
		byte[] buffer = relatorioPessoas.export(pessoaBC.findAll(), new HashMap<String, Object>(), tipo);
		ResponseBuilder response = Response.ok(buffer);		
		response.type(responseType);
		response.header("Content-Disposition", String.format("attachment; filename=%s", filename));
		
		return response.build();
	}
	
	@GET
	@Path("areas")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response areas(@QueryParam("filetype") String filetype, 
			@QueryParam("filename") String filename) {

		Type tipo = Type.PDF;
		String responseType = "application/pdf";		
		if (filetype.equals(XLS)) {
			tipo = Type.XLS;
			responseType =  "application/vnd.ms-excel";
		}
		
		List<ReportAreaDTO> lista = new ArrayList<ReportAreaDTO>();
		ReportAreaDTO report = new ReportAreaDTO();
		report.setLinhas(areaBC.findAll());
		lista.add(report);

		byte[] buffer = relatorioAreas.export(lista, new HashMap<String, Object>(), tipo);
		ResponseBuilder response = Response.ok(buffer);
		response.type(responseType);
		response.header("Content-Disposition", String.format("attachment; filename=%s", filename));
		
		return response.build();
	}
	
	@GET
	@Path("gastos")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response gastos(@QueryParam("filetype") String filetype, 
			@QueryParam("filename") String filename) {

		Type tipo = Type.PDF;
		String responseType = "application/pdf";		
		if (filetype.equals(XLS)) {
			tipo = Type.XLS;
			responseType =  "application/vnd.ms-excel";
		}
		
		List<ReportGastosDTO> lista = new ArrayList<ReportGastosDTO>();
		ReportGastosDTO report = new ReportGastosDTO();
		report.setLinhas(gastosBC.listarGastosPorPessoaMes());
		lista.add(report);

		byte[] buffer = relatorioGastos.export(lista, new HashMap<String, Object>(), tipo);
		ResponseBuilder response = Response.ok(buffer);
		response.type(responseType);
		response.header("Content-Disposition", String.format("attachment; filename=%s", filename));
		
		return response.build();
	}


	
}
