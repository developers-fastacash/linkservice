package com.fastacash.utils;

import java.util.Random;

import org.apache.commons.lang.RandomStringUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.fastacash.entity.Link;
import com.fastacash.entity.Wallet;

public class LinkUtils {

	public static Link createRandomLink() {
		Wallet wallet_source = WalletUtils.createRandomWallet();
		Wallet wallet_dest = WalletUtils.createRandomWallet();
		String currency = "SGD";
		int amount = new Random().nextInt() % 100;
		Link link = new Link(wallet_source, wallet_dest, amount,
				currency);
		return link;
	}
}
