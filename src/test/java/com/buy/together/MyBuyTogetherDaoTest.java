package com.buy.together;

import java.util.List;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.buy.together.dao.BuyTogetherDao;
import com.buy.together.dao.MyBuyTogetherDao;
import com.buy.together.domain.AttachedPhoto;
import com.buy.together.domain.ListSearchCriteria;
import com.buy.together.domain.MySearchCriteria;
import com.buy.together.domain.ScoreUserInfo;
import com.buy.together.dto.BuyTogetherDTO;
import com.buy.together.dto.BuyTogetherUpdateDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})

public class MyBuyTogetherDaoTest {

	private static final Logger logger = LoggerFactory.getLogger(MyBuyTogetherDaoTest.class);

	@Inject
	MyBuyTogetherDao dao;

	// photoList Test
	@Test
	@Ignore
	public void testPhotoList1() throws Exception {

		logger.info("testPhotoList() 호출됨.");
		Integer buytogether_number = 2;

		dao.photoList(buytogether_number);

	}

	// searchOpenBuyTogether Test
	@Test
	@Ignore
	public void testSearchOpenBuyTogether() throws Exception {

		logger.info("testSearchOpenBuyTogether() 호출됨.");	
		MySearchCriteria cri = new MySearchCriteria();

		int user_number = 3;
		int page = 1;
		int perPageNum = 2;
		String keyword ="test";
		String searchType = "t";

		cri.setPage(page);
		cri.setPerPageNum(perPageNum);
		cri.setUser_number(user_number);
		cri.setKeyword(keyword);
		cri.setSearchType(searchType);

		List<BuyTogetherDTO> list = dao.searchOpenBuyTogether(cri);

		logger.info(list.toString());

	}

	// searchJoinBuyTogether Test
	@Test

	public void testSearchJoinBuyTogether() throws Exception {

		logger.info("testSearchJoinBuyTogether() 호출됨.");
		MySearchCriteria cri = new MySearchCriteria();

		int user_number = 2;
		int page = 1;
		int perPageNum = 2;
		String keyword ="test";
		String searchType = "t";

		cri.setPage(page);
		cri.setPerPageNum(perPageNum);
		cri.setUser_number(user_number);
		cri.setKeyword(keyword);
		cri.setSearchType(searchType);

		dao.searchOpenBuyTogether(cri);


	}

	// searchDoneBuyTogether Test
	@Ignore
	@Test
	public void testSearchDoneBuyTogether() throws Exception {

		logger.info("testSearchDoneBuyTogether() 호출됨.");
		MySearchCriteria cri = new MySearchCriteria();

		List<BuyTogetherDTO> list = dao.searchDoneBuyTogether(cri);

	}

	// searchMyBuyTogetherCount Test
	@Test
	@Ignore
	public void testSearchMyBuyTogetherCount() throws Exception {

		logger.info("testSearchMyBuyTogetherCount() 호출됨.");
		MySearchCriteria cri = new MySearchCriteria();

		int user_number = 2;

		cri.setUser_number(user_number);

		dao.searchMyBuyTogetherCount(cri);

	}

	// openReputation Test
	@Test
	@Ignore
	public void testOpenReputation() throws Exception {

		logger.info("testOpenReputation() 호출됨.");
		Integer buyTogetherNumber = 11;

		dao.openReputation(buyTogetherNumber);

	}

	/*// scoreReputation Test
	@Test
	public void testScoreReputation() throws Exception {

		logger.info("testScoreReputation() 호출됨.");	
		List<ScoreUserInfo> scoreUserInfo
		
		
		dao.scoreReputation(scoreUserInfo);

	}
*/






















}
