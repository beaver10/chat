package com.team.cwl.cart;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CartDAOImpl implements CartDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.team.cwl.cart.CartDAOImpl.";
	
	public List<CartDTO> cartA() {
		return null;
	}
	
	// 장바구니에 담기
	@Override
	public int setCartAdd(CartDTO cartDTO) {
		return sqlSession.insert(NAMESPACE+"setCartAdd", cartDTO);
	}
	
	@Override
	public List<CartDTO> getCartList(String memberId) {
		return sqlSession.selectList(NAMESPACE+"getCartList", memberId);
	}
	
	@Override
	public void setCartDelete(Long cartNum) {
		sqlSession.delete(NAMESPACE+"setCartDelete", cartNum);
	}
	
	@Override
	public void setCartDeleteAll(String memberId) {
		sqlSession.delete(NAMESPACE+"setCartDeleteAll", memberId);
		
	}
	
	@Override
	public void setCartUpdate(Long cartNum) {
		
	}
	
	@Override
	public int sumMoney(String memberId) {
		return sqlSession.selectOne(NAMESPACE+"sumMoney", memberId);
	}
	
	@Override
	public int carCount(String memberId, Long productNum) {
		return 0;
	}
	
	@Override
	public void updateCart(CartDTO cartDTO) {
		
	}
	
	@Override
	public void modifyCart(CartDTO cartDTO) {
		sqlSession.update(NAMESPACE+"cart.modify", cartDTO);
	}
}
