package br.jasper_webapp.business;

import java.util.List;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.jasper_webapp.dto.LinhaGastosDTO;
import br.jasper_webapp.entity.Gasto;
import br.jasper_webapp.persistence.GastoDAO;

@BusinessController
public class GastoBC extends DelegateCrud<Gasto, Long, GastoDAO> {

	private static final long serialVersionUID = 1L;

	public List<LinhaGastosDTO> listarGastosPorPessoaMes() {
		return getDelegate().listarGastosPorPessoaMes();
	}

	

}
