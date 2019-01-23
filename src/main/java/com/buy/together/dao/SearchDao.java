package com.buy.together.dao;

import java.util.List;

import com.buy.together.board.model.BuyTogetherDTO;

public interface SearchDao {
	
	public List<BuyTogetherDTO> searchBuyTogether(String keyWord) throws Exception;

}
