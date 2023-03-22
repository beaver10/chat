package com.team.cwl.chat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team.cwl.member.MemberDTO;


@Repository
public class ChatDAOImpl implements ChatDAO {

    @Autowired
    private SqlSession sqlSession;

	private final String NAMESPACE="com.team.cwl.chat.ChatDAOImpl.";

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
        sqlSession.insert(NAMESPACE + "setSendMessage", chatDTO);
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
        return sqlSession.selectOne(NAMESPACE + "getCountUnreadMessage", chatDTO);
    }

    @Override
    public void setChangeMessageReadCheck(ChatDTO chatDTO) {
        sqlSession.update(NAMESPACE + "setChangeMessageReadCheck", chatDTO);
    }

    @Override
    public void setChangeMessageReadTime(ChatDTO chatDTO) {
        sqlSession.update(NAMESPACE + "setChangeMessageReadTime", chatDTO);
    }

    @Override
    public String getOtherProfile(ChatDTO chatDTO) {
        return sqlSession.selectOne(NAMESPACE + "getOtherProfile", chatDTO);
    }

    @Override
    public int getCountExitId(Long room) {
        return sqlSession.selectOne(NAMESPACE + "getCountExitId", room);
    }

    @Override
    public void setUpdateExitId(Long room, String exitId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("room", room);
        map.put("exitId", exitId);
        sqlSession.update(NAMESPACE + "setUpdateExitId", map);
    }
    

    @Override
    public void setDeleteRoom(Long room) {
        sqlSession.delete(NAMESPACE + "setDeleteRoom", room);
    }

    @Override
    public String getExitId(Long room) {
        return sqlSession.selectOne(NAMESPACE + "getExitId", room);
    }
}


