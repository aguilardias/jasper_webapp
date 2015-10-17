package br.jasper_webapp.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.jasper_webapp.entity.Pessoa;

@PersistenceController
public class PessoaDAO extends JPACrud<Pessoa, Long> {

	private static final long serialVersionUID = 1L;

}
