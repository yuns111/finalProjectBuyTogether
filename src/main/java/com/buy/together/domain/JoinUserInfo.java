package com.buy.together.domain;

public class JoinUserInfo {

	private String joinUserNickName;
	private int joinUserReputation;
	private int joinUserNumber;
	private int buyTogetherNumber;
	
	public JoinUserInfo() {
		
	}

	public JoinUserInfo(int joinUserNumber, int buyTogetherNumber) {
		
		this.joinUserNumber = joinUserNumber;
		this.buyTogetherNumber = buyTogetherNumber;
	}

	public String getJoinUserNickName() {
		return joinUserNickName;
	}
	
	public void setNickName(String nickName) {
		this.joinUserNickName = nickName;
	}
	
	public int getJoinUserReputation() {
		return joinUserReputation;
	}
	
	public void setReputation(int reputation) {
		this.joinUserReputation = reputation;
	}

	public int getJoinUserNumber() {
		return joinUserNumber;
	}

	public void setUser_Number(int user_number) {
		this.joinUserNumber = user_number;
	}

	public int getBuyTogetherNumber() {
		return buyTogetherNumber;
	}

	public void setBuyTogetherNumber(int buyTogetherNumber) {
		this.buyTogetherNumber = buyTogetherNumber;
	}
	
	
	
	
}
