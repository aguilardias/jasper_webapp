package br.jasper_webapp.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.jasper_webapp.entity.Area;
import br.jasper_webapp.persistence.AreaDAO;

@BusinessController
public class AreaBC extends DelegateCrud<Area, Long, AreaDAO> {

	private static final long serialVersionUID = 1L;

	
}
