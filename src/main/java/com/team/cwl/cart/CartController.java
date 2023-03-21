package com.team.cwl.cart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.team.cwl.member.MemberDTO;
import com.team.cwl.member.MemberService;


@Controller
@RequestMapping("/cart/*")
public class CartController { 
	
	@Autowired//(required=false)
	private CartServiceImpl cartServiceImpl;
	
	@RequestMapping(value = "add")
	public ModelAndView setCartAdd(@ModelAttribute CartDTO cartDTO, HttpSession session) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		String memberId = (String)session.getAttribute("memberId");
		
		String message = "";
		
		if(memberId == null) {
			message = "�α��� �� �̿��� �����մϴ�.";
			
		}
		cartDTO.setMemberId(memberId);
		cartServiceImpl.setCartAdd(cartDTO);
		
		modelAndView.addObject("result", message);
		modelAndView.setViewName("redirect:/cart/list");
		return modelAndView;
	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView getCartList(HttpSession session) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		Map<String, Object> map = new HashMap<String, Object>();
		
//		MemberDTO memberDTO=(MemberDTO)session.getAttribute("member");
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		String memberId = memberDTO.getMemberId();
		System.out.println(memberId);
		System.out.println(memberDTO.getMemberId());
//		System.out.println(memberId+"Login");
//		System.out.println(cartDTO.getMemberId()+"Login");
		
		
		if(memberId != null) {
			List<CartDTO> list = cartServiceImpl.getCartList(memberId); // ��ٱ��� ���
			int sumMoney = cartServiceImpl.sumMoney(memberId); // �ݾ� �հ�
			int fee = sumMoney >= 30000 ? 0 : 2500; // 3���� �̻��̸� ��۷� 0��, �̸��̸� 2500��
			
			// HashMap�� ��ٱ��Ͽ� ���� ���� ������ ����
			map.put("sumMoney", sumMoney);
			map.put("fee", fee); // ��۷�
			map.put("sum", sumMoney+fee); // ��ü �ݾ�
			map.put("list", list); // ��ٱ��� ���
			map.put("count", list.size()); // ���ڵ� ����
			
			modelAndView.addObject("map", map); // ������ ����
			modelAndView.setViewName("/cart/list"); // �̵��� �������� �̸�
			
			return modelAndView;
		} else {
			// �α����� ���� �ʾ����� �α��� �������� �̵�
			System.out.println("�α��� ����");
			modelAndView.setViewName("member/memberLogin");
		}
		return modelAndView;
		
		
	}
	
	@RequestMapping(value = "delete")
	public String delete(@RequestParam Long cartNum) throws Exception {
		cartServiceImpl.setCartDelete(cartNum);
		return "redirect:/cart/list";
	}
	
	@RequestMapping(value = "deleteAll")
	public String deleteAll(HttpSession session) throws Exception {
		String memberId = (String)session.getAttribute("memberId");
		if(memberId != null) {
			cartServiceImpl.setCartDeleteAll(memberId);
		}
		return "redirect:/cart/list";
	}
	
	@RequestMapping(value = "update")
	public ModelAndView update() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("cart/update");
		return modelAndView;
	}
	
}
