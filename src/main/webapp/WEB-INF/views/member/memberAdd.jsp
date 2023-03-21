<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.redResult{
		color: red;
	}

	.blueResult{
		color: blue;
	}

	.greenResult{
		color: green;
	}
</style>
</head>
<body>
<div class="container-fluid my-5">
	<div class="row justify-content-center">
		<h1 class="col-md-6 text-center fw-bold">MemberJoin Page</h1>
	</div>
	<div class = "row justify-content-center">
		<form class="col-md-6" id="frm" action="./memberAdd" method="post">
		<div class="mb-3">
			<label for="memberId" class="form-label fw-bold">아이디</label>
			<input type="text" name="memberId" class="form-control" id="memberId" placeholder="아이디 입력">
			<div id="idResult" class=""></div>
		</div>
		
		<div class="mb-3">
			<label for="memberPw" class="form-label fw-bold">비밀번호</label>
			<input type="password" name="memberPw" class="form-control" id="memberPw" placeholder="비밀번호 입력">
			<div id="pwResult"></div>
		</div>
		
		<div class="mb-3">
			<label for="pwCheck" class="form-label fw-bold">비밀번호 확인</label>
			<input type="password" name="pwCheck" class="form-control" id="pwCheck" placeholder="비밀번호 재입력">
			<div id="pwCheckResult"></div>
		</div>
		
		<div class="mb-3">
			<label for="memberName" class="form-label fw-bold">이름</label>
			<input type="text" name="memberName" class="form-control" id="memberName" placeholder="이름 입력">
			<div id="nameResult"></div>
		</div>
		
		<div class="mb-3">
			<label for="memberPhone" class="form-label fw-bold">전화번호</label>
			<input type="tel" name="memberPhone" class="form-control" id="memberPhone" placeholder="번호 입력">
			<div id="phoneResult"></div>
		</div>
		
		<div class="mb-3">
			<label for="memberEmail" class="form-label fw-bold ">이메일</label>
			<input type="email" name="memberEmail" class="form-control" id="memberEmail" placeholder="이메일 입력">
			<div id="emailResult"></div>
		</div>
		
		<div class="mb-3">
			<label for="memberGender" class="form-label fw-bold">성별</label>
			<input type="radio" name="memberGender" value="남성">남성
			<input type="radio" name="memberGender" value="여성">여성
			<div id="genderResult"></div>
		</div>
		
		<div class="mb-3">
			<label for="memberSI" class="form-label fw-bold">자기소개</label><br>
			<textarea rows="" cols="" name="memberSI"></textarea>
		</div>
		
		<div class="mb-3">
			<label for="memberAge" class="form-label fw-bold">나이</label>
			<input type="text" name="memberAge" class="form-control" id="memberAge" placeholder="나이 입력">
			<div id="ageResult"></div>
		</div>
		
		<div class="mb-3">
			<button class="btn btn-outline-success fw-bold" type="button" id="btn">등록</button>
		</div>
		</form>
	</div>
</div>
<script src="../resources/js/memberAdd.js"></script>
</body>
</html>