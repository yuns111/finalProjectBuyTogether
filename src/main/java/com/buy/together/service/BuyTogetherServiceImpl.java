package com.buy.together.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.buy.together.dao.BuyTogetherDao;
import com.buy.together.domain.AttachedPhoto;
import com.buy.together.dto.BuyTogetherDTO;

@Service
public class BuyTogetherServiceImpl implements BuyTogetherService {

	@Inject
	private BuyTogetherDao dao;
	
	@Override //같이사냥 게시판 리스트
	public List<BuyTogetherDTO> buyTogetherList() throws Exception {
		
		List<BuyTogetherDTO> buyTogether = dao.buyTogetherList();
		
		for(int i = 0; i<buyTogether.size(); i++) {
			
			List<AttachedPhoto> attachedPhotos = dao.photoList(buyTogether.get(i).getBuyTogether_number());
			
			buyTogether.get(i).setPhoto_path(attachedPhotos);
			
		}
		
		return buyTogether;
	}
}
