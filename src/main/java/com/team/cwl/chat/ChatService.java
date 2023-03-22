package com.team.cwl.chat;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.cwl.member.MemberDTO;


@Service
public class ChatService {
	
	@Autowired
	ChatDAOImpl chatDAOImpl;
	
	public void setSendMessage(ChatDTO chatDTO) {
		chatDAOImpl.setSendMessage(chatDTO);
	}
	public List<ChatDTO>  getRoomContentList(ChatDTO chatDTO){
		List<ChatDTO> list = chatDAOImpl.getRoomContentList(chatDTO);
		return list;
	}
	public int getMaxRoom() {
		return chatDAOImpl.getMaxRoom();
	}
	public String getRoomNumber(ChatDTO chatDTO) {
		
		String room = chatDAOImpl.getRoomNumber(chatDTO);
		System.out.println("서비스 방"+room);
		
		//new room
		if(room==null) {
			long temp = chatDAOImpl.getMaxRoom()+1;
			room = String.valueOf(temp);
		}
		
		System.out.println("서비스 방2"+room);
		return room;
	}
	
	public List<ChatDTO> getChatList(String memberId){
		List<ChatDTO> list = chatDAOImpl.getChatList(memberId);
		System.out.println("서비스 :"+list);
		return list;
	}
	public int getCountUnreadMessage(ChatDTO chatDTO) {
		int unread = chatDAOImpl.getCountUnreadMessage(chatDTO);
		return unread;
	}
	
	public void setChangeMessageReadCheck(ChatDTO chatDTO) {
		chatDAOImpl.setChangeMessageReadCheck(chatDTO);
	}
	
	public void setChangeMessageReadTime(ChatDTO chatDTO) {
		chatDAOImpl.setChangeMessageReadTime(chatDTO);
	}
	
	public String getOtherProfile(ChatDTO chatDTO) {
		return chatDAOImpl.getOtherProfile(chatDTO);
	}
	
	public int getCountExitId(Long room) {
		return chatDAOImpl.getCountExitId(room);
	}
	
	public String getExitId(Long room) {
		return chatDAOImpl.getExitId(room);
	}
	
	public void setUpdateExitId(Long room, String exitId) {
		chatDAOImpl.setUpdateExitId(room, exitId);
	}
	
	public void setDeleteRoom(Long room) {
		chatDAOImpl.setDeleteRoom(room);
	}
}

	

