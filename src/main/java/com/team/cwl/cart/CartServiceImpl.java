package com.team.cwl.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartDAOImpl cartDAOImpl;
	
	@Override
	public List<CartDTO> cartA() {
		return null;
	}
	
	@Override
	public void setCartAdd(CartDTO cartDTO) throws Exception {
		cartDAOImpl.setCartAdd(cartDTO);
	}
	
	@Override
	public List<CartDTO> getCartList(String memberId) throws Exception {
		return cartDAOImpl.getCartList(memberId);
	}
	
	@Override
	public void setCartDelete(Long cartNum) throws Exception {
		cartDAOImpl.setCartDelete(cartNum);
		
	}
	
	@Override
	public void setCartDeleteAll(String memberId) throws Exception {
		cartDAOImpl.setCartDeleteAll(memberId);
	}
	
	@Override
	public void update(Long cartNum) {
		
	}
	
	@Override
	public int sumMoney(String memberId) {
		return cartDAOImpl.sumMoney(memberId);
	}
	
	@Override
	public int cartCount(String memberId, Long productNum) {
		return 0;
	}
	
	@Override
	public void updateCart(CartDTO cartDTO) {
		
	}
	
	@Override
	public void modifyCart(CartDTO cartDTO) {
		cartDAOImpl.modifyCart(cartDTO);
	}
}
