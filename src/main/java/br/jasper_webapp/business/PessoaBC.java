package br.jasper_webapp.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.jasper_webapp.entity.Pessoa;
import br.jasper_webapp.persistence.PessoaDAO;

@BusinessController
public class PessoaBC extends DelegateCrud<Pessoa, Long, PessoaDAO> {

	private static final long serialVersionUID = 1L;

	

}
