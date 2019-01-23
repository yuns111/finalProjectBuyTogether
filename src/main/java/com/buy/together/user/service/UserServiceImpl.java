package com.buy.together.user.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.buy.together.user.dao.UserDao;
import com.buy.together.domain.AttachedPhoto;
import com.buy.together.domain.Dip;
import com.buy.together.domain.Interest;
import com.buy.together.user.model.User;
import com.buy.together.user.model.UserAddress;
import com.buy.together.board.model.BuyTogetherDTO;
import com.buy.together.user.model.UserDTO;
import com.buy.together.util.SHA256;

@Repository
public class UserServiceImpl implements UserService {

	@Inject 
	private UserDao userDao;
	SHA256 sha = SHA256.getInsatnce();

	//닉네임 중복 확인
	@Override
	public String checkNickname(String nickName) throws Exception {

		String isNicknameExist;

		isNicknameExist =  userDao.checkUserNickname(nickName);

		if(isNicknameExist == null) { //입력한 닉네임이 user 테이블에 존재하지 않는다면,

			isNicknameExist = userDao.checkAdminNickname(nickName); //입력한 닉네임 admin 테이블 조회

		}

		return isNicknameExist;

	}

	//필수 정보 DB 저장
	@Override
	public void registBasicInfo(UserDTO userDTO) throws Exception {

		User user = new User(userDTO.getUser_number(), userDTO.getNickname());
		userDao.registNickname(user); //닉네임 DB 저장

		if(userDTO.getCategory() != null) {

			Interest interest = new Interest();
			interest.setUser_number(userDTO.getUser_number());

			for(int i=0; i<userDTO.getCategory().size(); i++) { //회원이 선택한 카테고리 갯수만큼 반복

				interest.setCategory_number(Integer.parseInt(userDTO.getCategory().get(i)));
				userDao.registInterest(interest); //관심 카테고리 DB 저장

			}

		}

		if(userDTO.getUser_sido() != null) {

			UserAddress userAddress = new UserAddress(userDTO.getUser_sido(), userDTO.getUser_sigungu(), userDTO.getUser_number());
			userDao.registUserAddress(userAddress); //관심 지역 DB 저장 

		}

	}

	//같이사냥 회원 정보 DB 삭제
	@Override
	public String removeBUser(User user) throws Exception {

		String result = "false";

		String shaPass = sha.getSha256(user.getPw().getBytes());
		user.setPw(shaPass);

		user = userDao.readBUser(user);

		if(user != null) { //입력한 정보에 해당하는 회원이 있다면,

			userDao.delete(user.getUser_number());
			result = "success";
		}

		return result;

	}

	//페이스북/네이버 회원 정보 DB 삭제
	@Override
	public String removeEUser(User user) throws Exception {

		String result = "false";

		user = userDao.readEUser(user);

		if(user != null) { //입력한 정보에 해당하는 회원이 있다면,

			userDao.delete(user.getUser_number());
			result = "success";

		}

		return result;

	}

	//내 찜 목록
	@Override
	public List<BuyTogetherDTO> myDipList(Integer user_number) throws Exception {

		List<BuyTogetherDTO> myDipList = userDao.myDipList(user_number);
		List<AttachedPhoto> photo = null;

		for(int i=0; i<myDipList.size(); i++) {

			photo = userDao.myDipPhoto(myDipList.get(i).getBuytogether_number());
			myDipList.get(i).setPhoto_path(photo);;
		}

		return myDipList;

	}

	//필수 정보 DB 저장
	@Override
	public void registDip(Dip dip) throws Exception {

		userDao.registNewDip(dip); //선택한 찜 DB 저장

	}

	//찜 DB 삭제
	@Override
	public void removeDip(int user_number, String[] buytogether_numbers) throws Exception {

		for(int i=0; i<buytogether_numbers.length; i++) {

			int j = Integer.parseInt(buytogether_numbers[i]);
			userDao.deleteDip(user_number, j);

		}

	}

	@Override
	public String findId(User user) throws Exception {

		return userDao.findId(user);

	}

	@Override
	public User findPassword(User user) throws Exception {

		return userDao.findPassword(user);

	}

	//유저 비밀번호 디비에 입력
	@Override
	public void setPassword(User user) throws Exception {

		String shaPass = sha.getSha256(user.getPw().getBytes());
		user.setPw(shaPass);
		userDao.setPasswordDao(user);

	}

}
