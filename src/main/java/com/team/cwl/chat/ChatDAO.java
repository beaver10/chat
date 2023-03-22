package com.team.cwl.chat;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.team.cwl.member.MemberDTO;

@Repository
public interface ChatDAO {
    List<ChatDTO> getChatList(String memberId);
    List<ChatDTO> getRoomContentList(ChatDTO chatDTO);
    void setSendMessage(ChatDTO chatDTO);
    String getRoomNumber(ChatDTO chatDTO);
    int getMaxRoom();
    int getCountUnreadMessage(ChatDTO chatDTO);
    void setChangeMessageReadCheck(ChatDTO chatDTO);
    void setChangeMessageReadTime(ChatDTO chatDTO);
    String getOtherProfile(ChatDTO chatDTO);
    int getCountExitId(Long room);
    void setUpdateExitId(Long room, String exitId);
    void setDeleteRoom(Long room);
    String getExitId(Long room);
}

