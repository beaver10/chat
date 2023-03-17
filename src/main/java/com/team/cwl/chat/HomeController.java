package com.team.cwl.chat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class HomeController {
	@Autowired
	MemberDAO memberDAO;
	
	@RequestMapping(value = "/chat", method = RequestMethod.GET)
	public String chat() {
		return "chat";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("pageName", "about.jsp");
		return "home";
	}
	
	@RequestMapping("/login")
	public String login(Model model){
		model.addAttribute("pageName", "login.jsp");
		return "home";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	@ResponseBody
	public int loginPost(MemberDTO memberDTO, HttpSession session) throws Exception{
		int result=0;
		memberDTO = memberDAO.getMemberLogin(memberDTO);

		if(memberDTO!=null){
			if(memberDTO.getMemberPw().equals(memberDTO.getMemberPw())){
				session.setAttribute("memberId", memberDTO.getMemberId());
				result=1;
			}else{
				result=2;
			}
		}
		return result;
	}
}





