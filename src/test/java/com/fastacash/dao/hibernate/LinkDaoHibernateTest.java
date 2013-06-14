package com.fastacash.dao.hibernate;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.fastacash.AbstractHibernateTest;
import com.fastacash.dao.LinkDao;
import com.fastacash.entity.Link;
import com.fastacash.utils.LinkUtils;

public class LinkDaoHibernateTest extends AbstractHibernateTest {

	private LinkDao linkDao = null;
	@Before
	public void setUp() {
		linkDao = appContext.getBean(LinkDao.class);
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
		
		int count = linkDao.count();
		Link link = LinkUtils.createRandomLink();
		linkDao.save(link);
		
		assertEquals(linkDao.count(), count + 1);
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
		Long id = linkDao.save(link);
		
		Link dbLink = linkDao.getLinkById(id);
		assertEquals(dbLink.getState(), link.getState());
		assertEquals(dbLink.getId(), link.getId());
		assertEquals(dbLink.getAmount(), link.getAmount());
	}
}
