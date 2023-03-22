package com.team.cwl.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.team.cwl.member.MemberDAO.";
	
	public int setMemberAdd(MemberDTO memberDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setMemberAdd", memberDTO);
	}
	
	public int setMemberRoleAdd(MemberDTO memberDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setMemberRoleAdd", memberDTO);
	}
	
	public MemberDTO getMemberLogin(MemberDTO memberDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getMemberLogin", memberDTO);
	}
	
	public int setMemberUpdate(MemberDTO memberDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"setMemberUpdate", memberDTO);
	}
	
	public MemberDTO getAll(String memberId) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getAll", memberId);
	}
	
	
}
