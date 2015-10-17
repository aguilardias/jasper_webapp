package br.jasper_webapp.persistence;

import java.util.List;

import javax.persistence.TypedQuery;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.jasper_webapp.dto.LinhaGastosDTO;
import br.jasper_webapp.entity.Gasto;

@PersistenceController
public class GastoDAO extends JPACrud<Gasto, Long> {

	private static final long serialVersionUID = 1L;

	public List<LinhaGastosDTO> listarGastosPorPessoaMes() {
		String jpql = "select new br.jasper_webapp.dto.LinhaGastosDTO("
				+ "concat(year(g.data), month(g.data))"
				+ " , p.nome, g.valor)"
				+ " from Gasto g "
				+ " inner join g.pessoa p ";

		TypedQuery<LinhaGastosDTO> query = getEntityManager().createQuery(jpql, LinhaGastosDTO.class);
		
		return query.getResultList();
	}

}
