<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberUpdate</title>

</head>
<body>
<div class="container-fluid">
		<div class="row">
			<h1>MemberUpdate Page</h1>
		</div>
		
		<div class="row">
			<form action="./memberUpdate" method="post">
				
				
				<div class="mb-3">
					<label for="memberName" class="form-label fw-bold">이름</label> 
					<input type="text" name="memberName" class="form-control" id="memberName" value="${dto.memberName}">
				</div>
				
				<div class="mb-3">
					<label for="memberPw" class="form-label fw-bold">비밀번호</label> 
					<input type="password" name="memberPw" class="form-control" id="memberPw" value="${dto.memberPw}">
				</div>	
			
				<div class="mb-3">
					<label for="memberPhone" class="form-label fw-bold">전화번호</label> 
					<input type="tel" name="memberPhone" class="form-control" id="memberPhone" value="${dto.memberPhone}">
				</div>
				
				<div class="mb-3">
					<label for="memberEmail" class="form-label fw-bold ">이메일</label> 
					<input type="email" name="memberEmail" class="form-control" id="memberEmail" value="${dto.memberEmail}">
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
				<button class="btn btn-outline-success fw-bold" type="submit">수정</button> 
			</div>
				
			</form>		
		</div>
	</div>
</body>
</html>