package com.buy.together.service;

import com.buy.together.domain.User;

public interface LoginService {

	public String read(String id) throws Exception;
	
	public void regist(User user) throws Exception;
}
