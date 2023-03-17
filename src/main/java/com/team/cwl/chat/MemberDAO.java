package com.team.cwl.chat;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	@Autowired
	private SqlSession sqlsession;
	
	private final String namespace="com.team.cwl.chat.MemberDAO.";
	
	public MemberDTO getMemberLogin(MemberDTO memberDTO) throws Exception {
		return sqlsession.selectOne(namespace + "getMemberLogin", memberDTO );
	}

}
