package com.buy.together.user.dao;

import com.buy.together.domain.Admin;
import com.buy.together.user.model.User;

public interface LoginDao {

	public User buyTogetherUserLogin(User user) throws Exception;

	public Admin buyTogetherAdminLogin(Admin admin) throws Exception;
	
	public User externalLogin(User user) throws Exception;
	
	public void create(User user) throws Exception;
	
}
