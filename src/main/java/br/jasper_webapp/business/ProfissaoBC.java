package br.jasper_webapp.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.jasper_webapp.entity.Profissao;
import br.jasper_webapp.persistence.ProfissaoDAO;

@BusinessController
public class ProfissaoBC extends DelegateCrud<Profissao, Long, ProfissaoDAO> {

	private static final long serialVersionUID = 1L;

	

}
