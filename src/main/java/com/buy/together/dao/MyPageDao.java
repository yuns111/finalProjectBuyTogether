package com.buy.together.dao;

import java.util.List;

import com.buy.together.domain.Interest;
import com.buy.together.domain.User;
import com.buy.together.domain.UserAddress;
import com.buy.together.dto.MyPageDTO;

public interface MyPageDao {

	public MyPageDTO read(int user_number) throws Exception;
	
	public List<Integer> readInterest(int user_number) throws Exception;

	public UserAddress userAddress(Integer user_number) throws Exception;

	public String checkEmail(String email) throws Exception;

	public void userUpdate(User user) throws Exception;
	
	public void userCategoryDelete(Integer user_number) throws Exception;
	
	public void userCategoryInsert(List<Interest> interestCategory) throws Exception;
	
	public void userAddressUpdate(UserAddress address) throws Exception;
	
	public String readPassword(User user) throws Exception;
	
	public void updatePassword(User user) throws Exception;
	
	public String readPhoneNumber(String phone_number) throws Exception;
	
	public void updatePhoneNumber(User user) throws Exception;
	
	public String readEmail(String string) throws Exception;
	
	public void updateEmail(User user) throws Exception;
	
	public void deleteInterest(int user_number) throws Exception;
	
	public void createInterest(MyPageDTO user) throws Exception;
	
	public void updateAddress(MyPageDTO user) throws Exception;
	
}
