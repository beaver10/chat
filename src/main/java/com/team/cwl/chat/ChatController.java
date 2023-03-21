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

import com.team.cwl.member.MemberDTO;
import com.team.cwl.member.MemberService;



@RestController
public class ChatController {
	@Autowired
	ChatService chatService;
	@Autowired
	MemberService memberService;
	
	@PostMapping("/chat/personalChat")
	public String openPersonalChat(Model model, MemberDTO memberId) throws Exception {
		
		/* System.out.println(memberId); */
		MemberDTO dto = memberService.getAll(memberId);
		model.addAttribute("dto", dto);
		return "/chat/chat/personalChat";
	}
	
	
	@GetMapping("/chat/list")
	public String getChatList(Model model, HttpServletRequest request) {
		System.out.println("여기까지옴");
		System.out.println(request.getAttribute("memberId"));
		List<ChatDTO> list = chatService.getChatList((String)request.getAttribute("memberId"));
		for(ChatDTO dto:list) {
			dto.setMemberId((String)request.getAttribute("memberId"));
//			dto.setPhoto(chatService.getOtherProfile(dto));
//			dto.setUnread(chatService.countUnreadMessage(dto));
			/* System.out.println(dto.getPhoto()); */
		}
		
		
		model.addAttribute("list",list);
		
		System.out.println(list.size()+"리스트사이즈");
		return "/chat/chat/message";
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
	public int sendMessage(String sendId, String recvId, String content, Long room) {
		ChatDTO dto = new ChatDTO();
		Long roomNumber = room;
		dto.setRoom(roomNumber);
		dto.setSendId(sendId);
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
