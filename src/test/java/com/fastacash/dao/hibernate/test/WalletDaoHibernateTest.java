package com.fastacash.dao.hibernate.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fastacash.AbstractHibernateTest;
import com.fastacash.dao.LinkDao;
import com.fastacash.dao.WalletDao;
import com.fastacash.entity.Wallet;
import com.fastacash.utils.WalletUtils;

public class WalletDaoHibernateTest extends AbstractHibernateTest {

	private WalletDao walletDao;
	
	@Before
	public void setUp() {
		walletDao = (WalletDao) appContext.getBean("WalletDao");
	}

	@Test
	public void WalletTestSaveWallet() {
		
		Long count = walletDao.count();
		
		Wallet wallet = WalletUtils.createRandomWallet();
		walletDao.save(wallet);
		
		assertEquals(walletDao.count(), (Long)(count + 1));
	}
}
