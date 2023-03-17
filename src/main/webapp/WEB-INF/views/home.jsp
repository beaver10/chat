<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
	<title>학사관리</title>
	<link rel="stylesheet" href="/resources/home.css"/>
	<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script> 
</head>
<body>
	<div id="page">
		<div id="header">
			<a href="/"><img src="/resources/back.jpg" width=960/></a>
		</div>
		<div id="center">
			<div id="menu">
				<a href="/" style="margin-right:20px;">Home</a>
				<c:if test="${uid!=null}">
					<a href="#" id="chat">채팅</a>
					<span style="float:right;">
						<a href="#">${uid}</a>
						<a href="/logout">로그아웃</a>
					</span>
				</c:if>
				<c:if test="${uid==null}">
					<a href="/login" style="float:right">로그인</a>
				</c:if>
			</div>
			<div id="content">
				<jsp:include page="${pageName}"/>
			</div>
		</div>
		<div id="footer">
		</div>
	</div>
</body>
<script>
	$("#chat").on("click", function(e){
		e.preventDefault();
		window.open("/chat", "chat", "width=500, height=800, top=200, left=900");
	});
</script>
</html>