package com.buy.together.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.buy.together.domain.AttachedPhoto;
import com.buy.together.dto.BuyTogetherDTO;

@Repository
public class BuyTogetherDaoImpl implements BuyTogetherDao {

	private static final String namespace="com.buy.together.mappers.buyTogetherMapper";
	
	@Inject
	private SqlSession sqlSession;
	
	@Override //같이사냥 전체 게시글 조회
	public List<BuyTogetherDTO> buyTogetherList() throws Exception {

		return sqlSession.selectList(namespace+".buyTogetherList");
			
	}
	
	@Override //게시글의 사진 리스트 조회
	public List<AttachedPhoto> photoList(Integer buytogether_number) throws Exception {
	
		return sqlSession.selectList(namespace+".photoList", buytogether_number);
	}
}
