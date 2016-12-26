package com.buy.together;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.buy.together.dao.BuyTogetherDao;
import com.buy.together.domain.ListSearchCriteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})

public class BuytogetherDaoTest {

	private static final Logger logger = LoggerFactory.getLogger(BuytogetherDaoTest.class);

	@Inject
	BuyTogetherDao dao;

	
	// userInterestDao Test
	@Ignore
	@Test
	public void testUserInterestDao() throws Exception {

		logger.info("testUserInterestDao() 호출됨.");
		Integer user_number = 2;
		dao.userInterestDao(user_number);

	}

	// searchBuyTogetherCount Test
	@Test
	public void testSearchBuyTogetherCount() throws Exception {

		logger.info("testSearchBuyTogetherCount() 호출됨.");
		ListSearchCriteria cri = new ListSearchCriteria();		
		dao.searchBuyTogetherCount(cri);

	}

	
	// userInterestDao Test
	@Ignore
	@Test
	public void zxc() throws Exception {

		logger.info("testUserInterestDao() 호출됨.");
		Integer user_number = 2;
		dao.userInterestDao(user_number);

	}


	// userInterestDao Test
	@Test
	@Ignore
	public void asd() throws Exception {

		logger.info("testUserInterestDao() 호출됨.");
		Integer user_number = 2;
		dao.userInterestDao(user_number);

	}


}
