package com.fastacash.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fastacash.dao.LinkDao;
import com.fastacash.dao.WalletDao;
import com.fastacash.entity.Link;
import com.fastacash.entity.Link.State;
import com.fastacash.entity.Wallet;
import com.fastacash.service.LinkService;

@Service("LinkService")
public class LinkServiceImpl implements LinkService {

	@Autowired
	private LinkDao linkDao;

	@Autowired
	private WalletDao walletDao;

	public Link create(int amount, String currency, Long sourceWalletId,
			Long destWalletId) {
		Wallet sourceWallet = walletDao.getWalletById(sourceWalletId);
		Wallet destWallet = walletDao.getWalletById(destWalletId);
		Link link = new Link(sourceWallet, destWallet, amount, currency);
		linkDao.save(link);
		return link;
	}

	public boolean accept(String secureHash) {
		Link link = linkDao.getLinkBySecureHash(secureHash);
		if (link.getAmount() < 500) {
			link.setState(State.ACCEPTED);
			linkDao.update(link);
			return true;
		}
		return false;
	}

}
