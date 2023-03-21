package com.team.cwl.cart;

import java.util.List;


public interface CartService {
	public List<CartDTO> cartA() throws Exception;
	
	public void setCartAdd (CartDTO cartDTO) throws Exception;
	
	public List<CartDTO> getCartList(String memberId) throws Exception;
	
	public void setCartDelete (Long cartNum) throws Exception;
	
	public void setCartDeleteAll(String memberId) throws Exception;
	
	public void update (Long cartNum) throws Exception;
	
	public int sumMoney(String memberId) throws Exception;
	
	public int cartCount(String memberId, Long productNum) throws Exception;
	
	public void updateCart(CartDTO cartDTO) throws Exception;
	
	public void modifyCart(CartDTO cartDTO) throws Exception;	
}
