package com.buy.together.user.service;

import com.buy.together.user.model.User;
import com.buy.together.user.model.LoginDTO;

public interface LoginService {

	public LoginDTO buyTogetherLogin(User user) throws Exception;
	
	public User facebookLogin(User user) throws Exception;
	
	public void regist(User user) throws Exception;
	
	public void NaverUserLogin(String state, String code) throws Exception;
	
}
