package com.team.cwl.member;

public class MemberDTO {
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberPhone;
	private String memberEmail;
	private String memberGender;
	private String memberSI;
	private Long memberAge;
	private byte[] profileEmojiNum;
	private RoleDTO roleDTO;
	
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberGender() {
		return memberGender;
	}
	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}
	public String getMemberSI() {
		return memberSI;
	}
	public void setMemberSI(String memberSI) {
		this.memberSI = memberSI;
	}
	public Long getMemberAge() {
		return memberAge;
	}
	public void setMemberAge(Long memberAge) {
		this.memberAge = memberAge;
	}
	public byte[] getProfileEmojiNum() {
		return profileEmojiNum;
	}
	public void setProfileEmojiNum(byte[] profileEmojiNum) {
		this.profileEmojiNum = profileEmojiNum;
	}
	public RoleDTO getRoleDTO() {
		return roleDTO;
	}
	public void setRoleDTO(RoleDTO roleDTO) {
		this.roleDTO = roleDTO;
	}
	
	
	
}
