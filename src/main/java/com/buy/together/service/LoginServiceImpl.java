package com.buy.together.service;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.buy.together.dao.LoginDao;
import com.buy.together.domain.User;

@Repository
public class LoginServiceImpl implements LoginService {

	@Inject
	private LoginDao loginDao;

	@Override
	public String read(String id) throws Exception {
		
		return loginDao.read(id);
		
	}

	@Override
	public void regist(User user) throws Exception {
	
		loginDao.create(user);
		
	}
	
	

}
