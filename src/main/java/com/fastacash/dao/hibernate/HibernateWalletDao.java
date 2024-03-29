package com.fastacash.dao.hibernate;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.fastacash.dao.WalletDao;
import com.fastacash.entity.Wallet;

@Repository("WalletDao")
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

	public Wallet getWalletById(Long id) {
		Wallet wallet = (Wallet) getSession().get(Wallet.class, id);
		return wallet;
	}

}
