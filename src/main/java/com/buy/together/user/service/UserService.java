package com.buy.together.user.service;

import java.util.List;

import com.buy.together.domain.Dip;
import com.buy.together.user.model.User;
import com.buy.together.board.model.BuyTogetherDTO;
import com.buy.together.user.model.UserDTO;

public interface UserService {

	public String checkNickname(String nickName) throws Exception;

	public void registBasicInfo(UserDTO userDTO) throws Exception;

	public String removeBUser(User user) throws Exception;

	public String removeEUser(User user) throws Exception;

	public List<BuyTogetherDTO> myDipList(Integer user_number) throws Exception;

	public void removeDip(int user_number, String[] buytogether_numbers) throws Exception;

	public void registDip(Dip dip) throws Exception;
	
	public String findId(User user) throws Exception;
	
	public User findPassword(User user) throws Exception;
	
	public void setPassword(User user) throws Exception;

}
