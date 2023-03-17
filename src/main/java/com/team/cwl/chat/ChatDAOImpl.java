package com.team.cwl.chat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class ChatDAOImpl implements ChatDAO {

    @Autowired
    private SqlSession sqlSession;

	private final String NAMESPACE="com.team.cwl.chat.ChatDAO.";

    @Override
    public List<ChatDTO> getChatList(String memberId) {
        return sqlSession.selectList(NAMESPACE + "getChatList", memberId);
    }

    @Override
    public List<ChatDTO> getRoomContentList(ChatDTO chatDTO) {
        return sqlSession.selectList(NAMESPACE + "getRoomContentList", chatDTO);
    }

    @Override
    public void setSendMessage(ChatDTO chatDTO) {
        sqlSession.insert(NAMESPACE + "sendMessage", chatDTO);
    }

    @Override
    public String getRoomNumber(ChatDTO chatDTO) {
        return sqlSession.selectOne(NAMESPACE + "getRoomNumber", chatDTO);
    }

    @Override
    public int getMaxRoom() {
        return sqlSession.selectOne(NAMESPACE + "getMaxRoom");
    }

    @Override
    public int getCountUnreadMessage(ChatDTO chatDTO) {
        return sqlSession.selectOne(NAMESPACE + "countUnreadMessage", chatDTO);
    }

    @Override
    public void setChangeMessageReadCheck(ChatDTO chatDTO) {
        sqlSession.update(NAMESPACE + "changeMessageReadCheck", chatDTO);
    }

    @Override
    public void setChangeMessageReadTime(ChatDTO chatDTO) {
        sqlSession.update(NAMESPACE + "changeMessageReadTime", chatDTO);
    }

    @Override
    public String getOtherProfile(ChatDTO chatDTO) {
        return sqlSession.selectOne(NAMESPACE + "getOtherProfile", chatDTO);
    }

    @Override
    public int getCountExitId(String room) {
        return sqlSession.selectOne(NAMESPACE + "countExitId", room);
    }

    @Override
    public void setUpdateExitId(String room, String exitId) {
        Map<String, String> map = new HashMap<>();
        map.put("room", room);
        map.put("exitId", exitId);
        sqlSession.update(NAMESPACE + "updateExitId", map);
    }

    @Override
    public void setDeleteRoom(String room) {
        sqlSession.delete(NAMESPACE + "setDeleteRoom", room);
    }

    @Override
    public String getExitId(String room) {
        return sqlSession.selectOne(NAMESPACE + "getExitId", room);
    }
}


