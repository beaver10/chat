package com.team.cwl.chat;

import java.util.List;

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
    int getCountExitId(String room);
    void setUpdateExitId(String room, String exitId);
    void setDeleteRoom(String room);
    String getExitId(String room);
}

