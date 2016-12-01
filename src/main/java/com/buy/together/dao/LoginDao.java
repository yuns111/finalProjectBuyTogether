package com.buy.together.dao;

import com.buy.together.domain.User;

public interface LoginDao {

	public String read(String id) throws Exception;

	public void create(User user) throws Exception;
	
}
