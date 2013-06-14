package com.fastacash.utils;

import com.fastacash.AbstractHibernateTest;
import com.fastacash.dao.WalletDao;
import com.fastacash.entity.Wallet;

public class WalletUtils extends AbstractHibernateTest {

	
	public static Wallet createRandomWallet() {
		Wallet wallet = new Wallet();
		return wallet;
	}
	
	public static void save(Wallet wallet) {
		WalletDao walletDao = (WalletDao) appContext.getBean("WalletDao");
		walletDao.save(wallet);
	}

}
