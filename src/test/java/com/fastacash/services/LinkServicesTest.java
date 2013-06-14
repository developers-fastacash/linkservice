package com.fastacash.services;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fastacash.AbstractHibernateTest;
import com.fastacash.dao.LinkDao;
import com.fastacash.entity.Link;
import com.fastacash.entity.Wallet;
import com.fastacash.service.LinkService;
import com.fastacash.utils.CommonUtils;
import com.fastacash.utils.WalletUtils;

public class LinkServicesTest extends AbstractHibernateTest {

	private LinkService linkService;
	private LinkDao linkDao;
	
	@Before
	public void setUp() throws Exception {
		linkService = (LinkService) appContext.getBean("LinkService");
		linkDao = (LinkDao) appContext.getBean("LinkDao");
	}

	@Test
	public void testCreateLinkService() {
		Wallet source = WalletUtils.createRandomWallet();
		WalletUtils.save(source);
		Link link = linkService.create(new Random().nextInt() % 100, CommonUtils.getPropertyValue("currency"), source.getId(), source.getId());
		
		Link dbLink = linkDao.getLinkById(link.getId());
		assertEquals(dbLink.getState(), link.getState());
		assertEquals(dbLink.getId(), link.getId());
		assertEquals(dbLink.getAmount(), link.getAmount());
	}
}
