package com.team.cwl.cart;

import java.util.List;

public interface CartDAO {
	
	public List<CartDTO> cartA() throws Exception;
	// 장바구니 추가
	public int setCartAdd(CartDTO cartDTO) throws Exception;
	// 장바구니 목록
	public List<CartDTO> getCartList(String memberId) throws Exception;
	// 장바구니 개별 삭제
	public void setCartDelete(Long cartNum) throws Exception;
	// 장바구니 비우기
	public void setCartDeleteAll(String memberId) throws Exception;
	
	public void setCartUpdate (Long cartNum) throws Exception;
	// 장바구니 금액 합계
	public int sumMoney(String memberId) throws Exception; 
	// 장바구니 상품 갯수
	public int carCount(String memberId, Long productNum) throws Exception;
	// 장바구니 수정
	public void updateCart(CartDTO cartDTO) throws Exception;
	
	public void modifyCart(CartDTO cartDTO) throws Exception;
	
}
