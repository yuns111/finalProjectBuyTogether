package com.buy.together.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.buy.together.domain.AttachedPhoto;
import com.buy.together.domain.BuyTogether;
import com.buy.together.domain.BuyTogetherAddress;
import com.buy.together.domain.Category;
import com.buy.together.domain.HuntingStatus;
import com.buy.together.domain.HuntingType;
import com.buy.together.domain.ListSearchCriteria;
import com.buy.together.dto.BuyTogetherDTO;
import com.buy.together.dto.BuyTogetherMapDTO;

@Repository
public class BuyTogetherDaoImpl implements BuyTogetherDao {
	
	@Inject
	private SqlSession sqlSession;
	private static final String namespace="com.buy.together.mappers.buyTogetherMapper";
	
	//유저 관심 카테고리 갯수
	@Override 
	public Integer userInterestDao(Integer user_number) throws Exception {

		return sqlSession.selectOne(namespace+".userInterestCount",user_number);
		
	}
	
	//유저 관심 카테고리 갯수
	@Override 
	public Integer searchBuyTogetherCount(ListSearchCriteria cri) throws Exception {
		
		return sqlSession.selectOne(namespace+".searchBuyTogetherCount", cri);
		
	}
	
	//유저 관심 지역 갯수
	@Override
	public Integer searchBuyTogetherMapCount(ListSearchCriteria cri) throws Exception {

		return sqlSession.selectOne(namespace+".searchBuyTogetherMapCount", cri);
		
	}
	
	//사냥지도 리스트
	@Override
	public List<BuyTogetherMapDTO> searchBuyTogetherMapList(ListSearchCriteria cri) throws Exception {

		return sqlSession.selectList(namespace+".searchBuyTogetherMapList", cri);
		
	}

	//같이사냥 전체 게시글 조회
	@Override 
	public List<BuyTogetherDTO> searchBuyTogetherList(ListSearchCriteria cri) throws Exception {

		return sqlSession.selectList(namespace+".searchBuyTogetherList",cri);
			
	}
	
	//같이사냥 게시글의 사진 리스트 조회
	@Override 
	public List<AttachedPhoto> photoList(Integer buytogether_number) throws Exception {
	
		return sqlSession.selectList(namespace+".photoList", buytogether_number);
		
	}
	
	//카테고리 리스트 조회
	@Override
	public List<Category> categoryList() throws Exception {

		return sqlSession.selectList(namespace+".categoryList");
		
	}
	
	//사냥방식 리스트 조회
	@Override
	public List<HuntingType> huntingTypeList() throws Exception {

		return sqlSession.selectList(namespace+".huntingTypeList");
		
	}
	
	//사냥상태 리스트 조회
	@Override
	public List<HuntingStatus> huntingStatusList() throws Exception {

		return sqlSession.selectList(namespace+".huntingStatusList");
		
	}
	
	//같이사냥 게시글 쓰기
	@Override 
	public void buyTogetherInsert(BuyTogether buyTogether) throws Exception {

		sqlSession.insert(namespace+".buytogetherInsert", buyTogether);
		
	}
	
	//방금 쓴 게시글 번호
	@Override 
	public Integer getBuyTogetherNumber(BuyTogether buyTogether) throws Exception {

		return sqlSession.selectOne(namespace+".buytogetherNumber", buyTogether);
		
	}
	
	//게시글과 함께 같이사냥 주소 저장
	@Override 
	public void buyTogetherAddressInsert(BuyTogetherAddress buyTogetherAddress) throws Exception {

		sqlSession.insert(namespace+".buytogetherAddressInsert", buyTogetherAddress);
		
	}
	
	//게시글과 함께 같이사냥 첨부사진 저장
	@Override 
	public void buyTogetherPhotoInsert(AttachedPhoto attachedPhoto) throws Exception {

		sqlSession.insert(namespace+".buytogetherPhotoInsert", attachedPhoto);
		
	}
}
