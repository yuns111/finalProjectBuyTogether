package com.buy.together.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.buy.together.domain.User;

@Repository
public class LoginDaoImpl implements LoginDao {

	@Inject
	private SqlSession session;
	
	private static String namespace = "com.buy.together.mapper.LoginMapper";
	
	@Override
	public String read(String id) throws Exception {
		
		return session.selectOne(namespace + ".read", id);
		
	}

	@Override
	public void create(User user) throws Exception {
		
		session.insert(namespace + ".create", user);
		
	}

}
