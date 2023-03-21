<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

	<div class="container-fluid">
		<div class="row">
			<h1>마이 페이지</h1>
		</div>
		
		<div class="row">
			<h3>아이디 : ${dto.memberId}</h3>
			<h3>이름 : ${dto.memberName}</h3>
			<h3>휴대폰 : ${dto.memberPhone}</h3>
			<h3>이메일 : ${dto.memberEmail}</h3>
			<h3>성별 : ${dto.memberGender}</h3>
			<h3>자기소개 : ${dto.memberSI}</h3>
			<h3>나이 : ${dto.memberAge}</h3>
			<h3>Role : ${dto.roleDTO.roleName}</h3>
			<a href="./memberUpdate" class="btn btn-info">회원수정</a>
		</div>
	</div>
	

</body>
</html>