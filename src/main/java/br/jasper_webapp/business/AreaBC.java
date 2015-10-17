package br.jasper_webapp.business;

import br.gov.frameworkdemoiselle.lifecycle.Startup;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.jasper_webapp.entity.Area;
import br.jasper_webapp.persistence.AreaDAO;

@BusinessController
public class AreaBC extends DelegateCrud<Area, Long, AreaDAO> {

	private static final long serialVersionUID = 1L;

	@Startup
	@Transactional
	public void load() {
		if (findAll().isEmpty()) {
			insert(new Area("Exatas"));			
			insert(new Area("Humanas"));			
		}
	}

	/*public List<Area> find(String filter) {
		return getDelegate().find(filter);
	}*/
}
