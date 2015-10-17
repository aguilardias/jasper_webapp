package br.jasper_webapp.rest;


import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriInfo;

import br.gov.frameworkdemoiselle.BadRequestException;
import br.gov.frameworkdemoiselle.NotFoundException;
import br.gov.frameworkdemoiselle.report.Report;
import br.gov.frameworkdemoiselle.report.Type;
import br.gov.frameworkdemoiselle.security.LoggedIn;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.Strings;
import br.gov.frameworkdemoiselle.util.ValidatePayload;
import br.jasper_webapp.business.BookmarkBC;
import br.jasper_webapp.entity.Bookmark;
import br.jasper_webapp.entity.Report1DTO;

@Path("bookmark")
public class BookmarkREST {

	@Inject
	private BookmarkBC bc;

	private static final String JASPER = "reports/4-com-tabela.jasper";

	@Inject
	@br.gov.frameworkdemoiselle.report.annotation.Path(JASPER)
	private Report relatorio;

	@GET
	@Path("report1")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response report1() {


		List<Report1DTO> lista = new ArrayList<Report1DTO>();
		Report1DTO report = new Report1DTO();
		report.setLinhas(bc.findAll());
		lista.add(report);


		byte[] buffer = relatorio.export(lista, new HashMap<String, Object>(), Type.PDF);
		ResponseBuilder response = Response.ok(buffer);

		response.header("Content-Disposition", "attachment; filename=newfile.pdf");
		return response.build();
	}


	@GET
	@Produces("application/json")
	public List<Bookmark> find(@QueryParam("q") String query) throws Exception {
		List<Bookmark> result;

		if (Strings.isEmpty(query)) {
			result = bc.findAll();
		} else {
			result = bc.find(query);
		}

		return result;
	}

	@GET
	@Path("{id}")
	@Produces("application/json")
	public Bookmark load(@PathParam("id") Long id) throws Exception {
		Bookmark result = bc.load(id);

		if (result == null) {
			throw new NotFoundException();
		}

		return result;
	}

	@POST
	@LoggedIn
	@Transactional
	@ValidatePayload
	@Produces("application/json")
	@Consumes("application/json")
	public Response insert(Bookmark body, @Context UriInfo uriInfo) throws Exception {
		checkId(body);

		String id = bc.insert(body).getId().toString();
		URI location = uriInfo.getRequestUriBuilder().path(id).build();

		return Response.created(location).entity(id).build();
	}

	@PUT
	@LoggedIn
	@Path("{id}")
	@Transactional
	@ValidatePayload
	@Produces("application/json")
	@Consumes("application/json")
	public void update(@PathParam("id") Long id, Bookmark body) throws Exception {
		checkId(body);
		load(id);

		body.setId(id);
		bc.update(body);
	}

	@DELETE
	@LoggedIn
	@Path("{id}")
	@Transactional
	public void delete(@PathParam("id") Long id) throws Exception {
		load(id);
		bc.delete(id);
	}

	@DELETE
	@LoggedIn
	@Transactional
	public void delete(List<Long> ids) throws Exception {
		bc.delete(ids);
	}

	private void checkId(Bookmark entity) throws Exception {
		if (entity.getId() != null) {
			throw new BadRequestException();
		}
	}
}
