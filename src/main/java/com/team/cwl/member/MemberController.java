package com.team.cwl.member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/**")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "memberAgree", method = RequestMethod.GET)
	public void setMemberAgree() throws Exception {
		
	}
	
	@PostMapping("memberIdCheck")
	public ModelAndView getMemberIdCheck(MemberDTO memberDTO) throws Exception {
		boolean check = memberService.getMemberIdCheck(memberDTO);
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("result", check);
		modelAndView.setViewName("common/ajaxResult");
		return modelAndView;
	}
	
	@RequestMapping(value = "memberAdd", method = RequestMethod.GET)
	public ModelAndView setMemberAdd() throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/member/memberAdd");		
		return modelAndView;
	}
	
	@RequestMapping(value = "memberAdd", method = RequestMethod.POST)
	public ModelAndView setMemberAdd(MemberDTO memberDTO) throws Exception {
		ModelAndView modelAndView = new ModelAndView();		
		int result = memberService.setMemberAdd(memberDTO);
		modelAndView.setViewName("redirect:../");
		return modelAndView;
	}
	
	@RequestMapping(value = "memberLogin", method = RequestMethod.GET)
	public ModelAndView getMemberLogin(HttpServletRequest request) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/member/memberLogin");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "memberLogin", method = RequestMethod.POST)
	public ModelAndView getMemberLogin(MemberDTO memberDTO, HttpServletRequest request, String remember, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		if(remember != null && remember.equals("remember")) {
			Cookie cookie = new Cookie("rememberId", memberDTO.getMemberId());
			cookie.setMaxAge(60*60*24*7);
			response.addCookie(cookie);			
		} else {
			Cookie cookie = new Cookie("rememberId", "");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		
		memberDTO = memberService.getMemberLogin(memberDTO);
		if(memberDTO != null) {
			HttpSession session = request.getSession();
			session.setAttribute("member", memberDTO);
		}
		modelAndView.setViewName("redirect:../");		
		return modelAndView;
	}
	
	@RequestMapping(value = "memberLogout", method = RequestMethod.GET)
	public ModelAndView getMemberLogout(HttpSession session) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		session.invalidate();
		modelAndView.setViewName("redirect:../");		
		return modelAndView;
	}	
	
	@RequestMapping(value = "memberPage", method = RequestMethod.GET)
	public ModelAndView getMemberPage(HttpSession session) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		
		memberDTO = memberService.getMemberPage(memberDTO);
		modelAndView.addObject("dto", memberDTO);
		modelAndView.setViewName("/member/memberPage");
		return modelAndView;
	}
	
	@RequestMapping(value = "memberUpdate", method = RequestMethod.GET)
	public ModelAndView setMemberUpdate(HttpSession session) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		
		memberDTO = memberService.getMemberPage(memberDTO);
		modelAndView.addObject("dto", memberDTO);
		modelAndView.setViewName("/member/memberUpdate");		
		return modelAndView;
	}
	
	@RequestMapping(value = "memberUpdate", method = RequestMethod.POST)
	public ModelAndView setMemberUpdate(MemberDTO memberDTO, HttpSession session) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		MemberDTO sessionMemberDTO = (MemberDTO)session.getAttribute("member");
		memberDTO.setMemberId(sessionMemberDTO.getMemberId());
		int result = memberService.setMemberUpdate(memberDTO);
		modelAndView.setViewName("redirect:./memberPage");
		return modelAndView;
	}
}
