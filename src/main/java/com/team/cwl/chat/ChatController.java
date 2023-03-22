package com.team.cwl.chat;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.team.cwl.member.MemberDTO;
import com.team.cwl.member.MemberService;



@RestController
public class ChatController {
	@Autowired
	ChatService chatService;
	@Autowired
	MemberService memberService;
	
//	@GetMapping("/chat/personalChat")
//	public ModelAndView openPersonalChat(HttpSession session) throws Exception {
//		ModelAndView mv = new ModelAndView();
//		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
//		System.out.println(memberDTO.getMemberId()); 
//		/* System.out.println(memberId); */
//		MemberDTO dto = memberService.getAll(memberDTO.getMemberId());
//		mv.addObject("dto", dto);
//		mv.setViewName("/chat/personalChat");
//		return mv;
//	}
	
	
	@GetMapping("/chat/list")
	public ModelAndView getChatList(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		System.out.println(memberDTO.getMemberId()); 
		
		List<ChatDTO> list = chatService.getChatList(memberDTO.getMemberId());
		for(ChatDTO dto:list) {
			System.out.println(memberDTO.getMemberId());
			dto.setMemberId(memberDTO.getMemberId());
//			dto.setPhoto(chatService.getOtherProfile(dto));
//			dto.setUnread(chatService.countUnreadMessage(dto));
			/* System.out.println(dto.getPhoto()); */
		}
		
		System.out.println(list.size()+"리스트사이즈");
		
		mv.addObject("list",list);
		mv.setViewName("/chat/message");
		return mv;
	}
	

	@ResponseBody
	@PostMapping("/chat/chatList")
	public List<ChatDTO> list(String sendId, Long room) {
		ChatDTO dto = new ChatDTO();
		dto.setMemberId(sendId);
		dto.setSendId(sendId);
		dto.setRoom(room);
		chatService.setChangeMessageReadTime(dto);
		chatService.setChangeMessageReadCheck(dto);
		List<ChatDTO> list = chatService.getRoomContentList(dto);
		return list;
	}
	
	
	@ResponseBody
	@PostMapping("/chat/read")
	public void readMessage(String sendId, Long room) {
		System.out.println("읽음처리"+sendId+","+room);
		ChatDTO dto = new ChatDTO();
		
		dto.setMemberId(sendId);
		dto.setRoom(room);
		chatService.setChangeMessageReadTime(dto);
		chatService.setChangeMessageReadCheck(dto);
	}
	
	@ResponseBody
	@PostMapping("/chat/getRoomNumber")
	public String getRoomNumber(String sendId, String recvId) {
		ChatDTO dto = new ChatDTO();
		dto.setSendId(sendId);
		dto.setRecvId(recvId);
		String room = chatService.getRoomNumber(dto);
		return room;
	}
	
	@ResponseBody
	@PostMapping("/chat/send")
	public int setSendMessage(String sendId, String recvId, String content, Long room, HttpSession session) {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		ChatDTO dto = new ChatDTO();
		Long roomNumber = room;
		dto.setRoom(roomNumber);
		dto.setSendId(memberDTO.getMemberId());
		dto.setRecvId(recvId);
		dto.setContent(content);
		chatService.setSendMessage(dto);
		return 1;
		
		
	}
	
	@ResponseBody
	@PostMapping("/chat/exit")
	public void exitRoom(Long room, String exitId) {
		int num = chatService.getCountExitId(room);
		if(num == 0) {
			chatService.setUpdateExitId(room, exitId);
		}else {
			chatService.setDeleteRoom(room);
		}
	}

}
