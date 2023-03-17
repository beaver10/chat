package com.team.cwl.chat;

import java.io.FileInputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;



@RestController
public class ChatController {
	@Autowired
	ChatService chatService;
	
//	
//	@PostMapping("/chat/personalChat")
//	public ModelAndView openPersonalChat(String memberId) {
//		//멤버클래스에 추가해야함 
//	    MemberDTO dto = memberService.getAll(memberId);
//	    ModelAndView mv = new ModelAndView("/chat/chat/personalChat");
//	    mv.addObject("dto", dto);
//	    return mv;
//	}
//	
	
	@GetMapping("/chat/list")
	public ModelAndView getChatList(HttpSession session) {
	    ModelAndView mv = new ModelAndView("/chat/chat/message");
	    List<ChatDTO> list = chatService.getChatList((String)session.getAttribute("memberId"));
	    for(ChatDTO dto:list) {
	        dto.setMemberId((String)session.getAttribute("memberId"));
	        dto.setProfileEmojiNum(chatService.getOtherProfile(dto));
	        dto.setUnRead((long) chatService.getCountUnreadMessage(dto));
	    }
	    mv.addObject("list",list);
	    System.out.println(list.size() + "리스트사이즈");
	    return mv;
	}
	
	
	@PostMapping("/chat/chatList")
	public ModelAndView list(String sendId, String room) {
	    ChatDTO dto = new ChatDTO();
	    dto.setMemberId(sendId);
	    dto.setSendId(sendId);
	    dto.setRoom(room);
	    chatService.setChangeMessageReadTime(dto);
	    chatService.setChangeMessageReadCheck(dto);
	    List<ChatDTO> list = chatService.getRoomContentList(dto);
	    ModelAndView mv = new ModelAndView("jsonView");
	    mv.addObject("list", list);
	    return mv;
	}

	
	@PostMapping("/chat/read")
	public ModelAndView readMessage(String sendId, String room) {
	    System.out.println("읽음처리" + sendId + "," + room);
	    ChatDTO dto = new ChatDTO();
	    dto.setMemberId(sendId);
	    dto.setRoom(room);
	    chatService.setChangeMessageReadTime(dto);
	    chatService.setChangeMessageReadCheck(dto);
	    ModelAndView mv = new ModelAndView("jsonView");
	    return mv;
	}
	
	@ResponseBody
	@PostMapping("/chat/getRoomNumber")
	public String getRoomNumber(String send_id, String recv_id) {
		ChatDTO dto = new ChatDTO();
		dto.setSend_id(send_id);
		dto.setRecv_id(recv_id);
		String room = chatService.getRoomNumber(dto);
		return room;
	}
	
	@ResponseBody
	@PostMapping("/chat/send")
	public int sendMessage(String send_id, String recv_id, String content, String room) {
		ChatDTO dto = new ChatDTO();
		int roomNumber = Integer.parseInt(room);
		dto.setRoom(roomNumber);
		dto.setSend_id(send_id);
		dto.setRecv_id(recv_id);
		dto.setContent(content);
		chatService.sendMessage(dto);
		return 1;
	}
	
	@ResponseBody
	@PostMapping("/chat/exit")
	public void exitRoom(String room, String exit_id) {
		int num = chatService.countExitId(room);
		if(num == 0) {
			chatService.updateExitId(room, exit_id);
		}else {
			chatService.deleteRoom(room);
		}
	}

}

