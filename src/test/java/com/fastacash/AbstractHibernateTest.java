package com.fastacash;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class AbstractHibernateTest {

	protected static ApplicationContext appContext = null;
	protected SessionFactory sessionFactory;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		appContext = new FileSystemXmlApplicationContext("/src/test/resources/applicationContext.xml");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		appContext = null;
	}

	@After
	public void tearDown() throws Exception {
		if(sessionFactory != null)
			sessionFactory.close();
	}
	
	@Test
	public void TestAppContextNotNull() {
		assertTrue(appContext != null);
	}
}
