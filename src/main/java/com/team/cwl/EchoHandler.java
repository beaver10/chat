package com.team.cwl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class EchoHandler extends TextWebSocketHandler{
    //세션 리스트
	List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();

    //클라이언트가 연결 되었을 때 실행
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// 연결되었을떄
		System.out.println("연결됨 : " + session.getId());
		sessionList.add(session);
		System.out.println("연결된갯수 : " + sessionList.size());
		super.afterConnectionEstablished(session);
    }

    //클라이언트가 웹소켓 서버로 메시지를 전송했을 때 실행
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// 메시지가 들어오는 부분
		String strMessage = message.getPayload();
		System.out.println("메시지 : " + strMessage);
		super.handleTextMessage(session, message);
        
    }

    //클라이언트 연결을 끊었을 때 실행
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// 연결끊겼을때
		System.out.println("연결끊김 : " + session.getId());
		super.afterConnectionClosed(session, status);
    }
}