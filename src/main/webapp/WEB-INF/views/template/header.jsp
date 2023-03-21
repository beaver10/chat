<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar bg-dark navbar-expand-lg bg-body-tertiary" data-bs-theme="dark">
  <div class="container-fluid">
  	
  	<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
    	<ul class="navbar-nav me-auto mb-2 mb-lg-0">
			<li class="nav-item"><a class="nav-link active" href="/notice/list">공지사항</a></li>
			<li class="nav-item"><a class="nav-link active" href="/product/list">제품</a></li>
			<li class="nav-item"><a class="nav-link active" href="/bankBook/list">저축상품</a></li>
			<li class="nav-item"><a class="nav-link active" href="/qna/list">QnA</a></li>
			<li class="nav-item"><a class="nav-link active" href="/chat/list">CHAT</a></li>
		</ul>
		
		<ul class="navbar-nav">
			<c:if test="${empty member}">
			<li class="nav-item"><a class="nav-link" href="/member/memberLogin">LOGIN</a></li>
			<li class="nav-item"><a class="nav-link" href="/member/memberAgree">JOIN</a></li>
			</c:if>
			<c:if test="${not empty member}">		
			<li class="nav-item"><a class="nav-link" href="/member/memberPage">MYPAGE</a></li>
			<li class="nav-item"><a class="nav-link" href="/member/memberLogout">LOGOUT</a></li>
			</c:if>
			<li class="nav-item"><a class="nav-link" href="/cart/list">장바구니</a></li>
			<li class="nav-item"><a class="nav-link" href="#">EN</a></li>
			<li class="nav-item"><a class="nav-link" href="#">JP</a></li>
			<li class="nav-item"><a class="nav-link" href="#">CN</a></li>
		</ul>
    </div>
  </div>
</nav>
