package com.fastacash.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.fastacash.dao.LinkDao;
import com.fastacash.entity.Link;

@Repository("LinkDao")
public class HibernateLinkDao extends HibernateDaoSupport implements LinkDao {

	public void save(Link link) {
		getHibernateTemplate().save(link);
	}
	
	public Long count() {
		Criteria cr = getSession().createCriteria(Link.class);
		cr.setProjection(Projections.rowCount());
		@SuppressWarnings("rawtypes")
		List list = cr.list();
		if(list != null && !list.isEmpty()) {
			return (Long) list.get(0);
		}
		return (long) 0;
	}

	public Link getLinkBySecureHash(String secureHash) {
		Criteria cr = getSession().createCriteria(Link.class);
		cr.add(Restrictions.eq("secureHash", secureHash));
		return (Link) cr.uniqueResult();
	}

	public Link getLinkById(Long id) {
		Link link = (Link) getSession().get(Link.class, id);
		return link;
	}

}
