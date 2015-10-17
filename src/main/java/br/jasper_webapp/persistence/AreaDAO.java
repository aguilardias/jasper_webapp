package br.jasper_webapp.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.jasper_webapp.entity.Area;

@PersistenceController
public class AreaDAO extends JPACrud<Area, Long> {

	private static final long serialVersionUID = 1L;

	/*public List<Area> find(String filter) {
		StringBuffer ql = new StringBuffer();
		ql.append("  from Bookmark b ");
		ql.append(" where lower(b.description) like :description ");
		ql.append("    or lower(b.link) like :link ");

		TypedQuery<Area> query = getEntityManager().createQuery(ql.toString(), Area.class);
		query.setParameter("description", "%" + filter.toLowerCase() + "%");
		query.setParameter("link", "%" + filter.toLowerCase() + "%");

		return query.getResultList();
	}*/
}
