package com.buy.together.dao;

import java.util.List;

import com.buy.together.domain.AttachedPhoto;
import com.buy.together.dto.BuyTogetherDTO;

public interface BuyTogetherDao {
	
	public List<BuyTogetherDTO> buyTogetherList() throws Exception;
	
	public List<AttachedPhoto> photoList(Integer buytogether_number) throws Exception;

}
