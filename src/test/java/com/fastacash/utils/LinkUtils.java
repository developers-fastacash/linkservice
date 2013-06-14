package com.fastacash.utils;

import java.util.Random;

import com.fastacash.AbstractHibernateTest;
import com.fastacash.dao.LinkDao;
import com.fastacash.entity.Link;
import com.fastacash.entity.Wallet;

public class LinkUtils extends AbstractHibernateTest {

	public static Link createRandomLink() {
		Wallet wallet_source = WalletUtils.createRandomWallet();
		Wallet wallet_dest = WalletUtils.createRandomWallet();
		WalletUtils.save(wallet_source);
		WalletUtils.save(wallet_dest);
		String currency = "SGD";
		int amount = new Random().nextInt() % 100;
		Link link = new Link(wallet_source, wallet_dest, amount,
				currency);
		return link;
	}
	
	public static void save(Link link) {
		LinkDao linkDao = (LinkDao) appContext.getBean("LinkDao");
		linkDao.save(link);
	}
}
