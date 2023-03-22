package com.team.cwl.chat;

import com.team.cwl.member.MemberDTO;

public class ChatDTO extends MemberDTO{

	private Long chatNum;
	// 방번호
	private Long room;
	// 발송자
	private String sendId;
	// 수신자
	private String recvId;
	// 보낸시간
	private String sendTime;
	// 읽은시간
	private String readTime;
	// 내용
	private String content;
	// 읽었는지 확인
	private String readCheck;
	// 현재 사용자의 메세지 상대 id저장
	private String otherId;
	// 안읽은 메세지 갯수 
	private Long unRead;
	// 방을 나간 회원 아이디
	private String exitId;
	// 방을 나간 회원수
	private Long exitCount;
	
	
	
	
	public Long getChatNum() {
		return chatNum;
	}
	public void setChatNum(Long chatNum) {
		this.chatNum = chatNum;
	}
	
	public Long getRoom() {
		return room;
	}
	public void setRoom(Long room) {
		this.room = room;
	}
	public String getSendId() {
		return sendId;
	}
	public void setSendId(String sendId) {
		this.sendId = sendId;
	}
	public String getRecvId() {
		return recvId;
	}
	public void setRecvId(String recvId) {
		this.recvId = recvId;
	}
	public String getSendTime() {
		return sendTime;
	}
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	public String getReadTime() {
		return readTime;
	}
	public void setReadTime(String readTime) {
		this.readTime = readTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getReadCheck() {
		return readCheck;
	}
	public void setReadCheck(String readCheck) {
		this.readCheck = readCheck;
	}
	public String getOtherId() {
		return otherId;
	}
	public void setOtherId(String otherId) {
		this.otherId = otherId;
	}
	public Long getUnRead() {
		return unRead;
	}
	public void setUnRead(Long unRead) {
		this.unRead = unRead;
	}
	public String getExitId() {
		return exitId;
	}
	public void setExitId(String exitId) {
		this.exitId = exitId;
	}
	public Long getExitCount() {
		return exitCount;
	}
	public void setExitCount(Long exitCount) {
		this.exitCount = exitCount;
	}	
	
	
	
	
	

}
