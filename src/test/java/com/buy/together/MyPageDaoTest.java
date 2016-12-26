package com.buy.together;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.buy.together.dao.EventDao;
import com.buy.together.dao.MyPageDao;
import com.buy.together.dao.QnaDao;
import com.buy.together.domain.MyCriteria;
import com.buy.together.domain.User;
import com.buy.together.dto.QnaDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MyPageDaoTest {

	@Inject
	MyPageDao dao;

	@Test
	@Ignore
	public void testRead() throws Exception {
		
		int user_number = 1;
		
		dao.read(user_number);

	}
	
	@Test
	@Ignore
	public void testReadInterest() throws Exception {
		
		int user_number = 1;
		
		dao.readInterest(user_number);
		
	}
	
	@Test
	@Ignore
	public void testReadPassword() throws Exception {
		
		User user = new User();
	
		Integer user_number = 2;
		String pw = "user2";
		
		user.setUser_number(user_number);
		user.setPw(pw);
		
		dao.readPassword(user);
	
	}
	
	@Test
	@Ignore
	public void testUpdatePassword() throws Exception {
		
		User user = new User();
		
		Integer user_number = 2;
		String pw = "user3";
		
		user.setUser_number(user_number);
		user.setPw(pw);
		
		dao.updatePassword(user);

	}
	
	@Test
	public void testReadPhoneNumber() throws Exception {
		
		String phone_number = "01010101";
		
		dao.readPhoneNumber(phone_number);
	}
	
	@Test
	@Ignore
	public void testRea1d() throws Exception {
		
		int user_number = 1;
		
		dao.read(user_number);

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}