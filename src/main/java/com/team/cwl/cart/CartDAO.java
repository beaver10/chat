package com.team.cwl.cart;

import java.util.List;

public interface CartDAO {
	
	public List<CartDTO> cartA() throws Exception;
	// ��ٱ��� �߰�
	public int setCartAdd(CartDTO cartDTO) throws Exception;
	// ��ٱ��� ���
	public List<CartDTO> getCartList(String memberId) throws Exception;
	// ��ٱ��� ���� ����
	public void setCartDelete(Long cartNum) throws Exception;
	// ��ٱ��� ����
	public void setCartDeleteAll(String memberId) throws Exception;
	
	public void setCartUpdate (Long cartNum) throws Exception;
	// ��ٱ��� �ݾ� �հ�
	public int sumMoney(String memberId) throws Exception; 
	// ��ٱ��� ��ǰ ����
	public int carCount(String memberId, Long productNum) throws Exception;
	// ��ٱ��� ����
	public void updateCart(CartDTO cartDTO) throws Exception;
	
	public void modifyCart(CartDTO cartDTO) throws Exception;
	
}
