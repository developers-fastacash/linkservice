package com.fastacash.dao.hibernate;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import com.fastacash.AbstractHibernateTest;
import com.fastacash.dao.LinkDao;
import com.fastacash.dao.WalletDao;
import com.fastacash.entity.Link;
import com.fastacash.entity.Wallet;
import com.fastacash.utils.LinkUtils;
import com.fastacash.utils.WalletUtils;

public class LinkDaoHibernateTest extends AbstractHibernateTest {

	private LinkDao linkDao = null;
	private WalletDao walletDao = null;

	@Before
	public void setUp() {
		linkDao = (LinkDao) appContext.getBean("LinkDao");
		walletDao = (WalletDao) appContext.getBean("WalletDao");
	}

	@Test
	public void LinkTestSaveLink() {

		Link link = LinkUtils.createRandomLink();
		linkDao.save(link);

		Link dbLink = linkDao.getLinkBySecureHash(link.getSecureHash());
		assertEquals(dbLink.getState(), link.getState());
		assertEquals(dbLink.getId(), link.getId());
		assertEquals(dbLink.getAmount(), link.getAmount());
	}

	@Test
	public void LinkTestCount() {

		Long count = linkDao.count();
		Link link = LinkUtils.createRandomLink();
		linkDao.save(link);

		assertEquals(linkDao.count(), (Long) (count + 1));
	}

	@Test
	public void LinkTestGetLinkBySecureHash() {

		Link link = LinkUtils.createRandomLink();
		linkDao.save(link);

		Link dbLink = linkDao.getLinkBySecureHash(link.getSecureHash());
		assertEquals(dbLink.getState(), link.getState());
		assertEquals(dbLink.getId(), link.getId());
		assertEquals(dbLink.getAmount(), link.getAmount());
	}

	@Test
	public void LinkTestGetLinkById() {
		Link link = LinkUtils.createRandomLink();
		linkDao.save(link);

		Link dbLink = linkDao.getLinkById(linkDao.getLinkBySecureHash(
				link.getSecureHash()).getId());
		assertEquals(dbLink.getState(), link.getState());
		assertEquals(dbLink.getId(), link.getId());
		assertEquals(dbLink.getAmount(), link.getAmount());
	}
}
