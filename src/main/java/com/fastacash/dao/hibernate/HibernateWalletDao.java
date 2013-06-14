package com.fastacash.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.fastacash.dao.WalletDao;
import com.fastacash.entity.Wallet;

public class HibernateWalletDao  extends HibernateDaoSupport implements WalletDao {

	public void save(Wallet wallet) {
		 getHibernateTemplate().save(wallet);
	}

	public Long count() {
		Criteria cr = getSession().createCriteria(Wallet.class);
		cr.setProjection(Projections.rowCount());
		@SuppressWarnings("rawtypes")
		List list = cr.list();
		if(list != null && !list.isEmpty()) {
			return (Long) list.get(0);
		}
		return (long) 0;
	}

}
