<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
</head>
<body>
<div class="container-fluid">
	<div class="row justify-content-center">
		<h1 class="col-md-7 my-5">Member Login</h1>
	</div>
	<div class="row justify-content-center my-5">
		<form class="col-md-7" action="memberLogin" method="post">
			<div class="mb-3">
	    		<label for="memberId" class="form-label">ID</label>
	    		<input type="text" class="form-control" id="memberId" name="memberId" value="${cookie.rememberId.value}">
		  	</div>
		  	<div class="mb-3">
				<label for="memberPw" class="form-label">Password</label>
			  	<input type="password" class="form-control" id="memberPw" name="memberPw">
			</div>
			<div class="mb-3 form-check">
			  	<input type="checkbox" name="remember" value="remember" class="form-check-input" id="remember">
			  	<label class="form-check-label" for="remember">ID 기억하기</label>
			</div>
	  		<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</div>


<ul>
	<li onclick="kakaoLogin();">
      <a href="javascript:void(0)">
          <span>카카오 로그인</span>
      </a>
	</li>
	<li onclick="kakaoLogout();">
      <a href="javascript:void(0)">
          <span>카카오 로그아웃</span>
      </a>
	</li>
</ul>
<!-- 카카오 스크립트 -->
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script>
Kakao.init('60ad1b0c58cc84deaec58ed95f33f648');
console.log(Kakao.isInitialized()); // sdk초기화여부판단
//카카오로그인


function kakaoLogin() {
    Kakao.Auth.login({
      success: function (response) {
        Kakao.API.request({
          url: '/v2/user/me',
          success: function (response) {
        	  console.log(response)
          },
          fail: function (error) {
            console.log(error)
          },
        })
      },
      fail: function (error) {
        console.log(error)
      },
    })
  }

//카카오로그아웃  
function kakaoLogout() {
    if (Kakao.Auth.getAccessToken()) {
      Kakao.API.request({
        url: '/v1/user/unlink',
        success: function (response) {
        	console.log(response)
        },
        fail: function (error) {
          console.log(error)
        },
      })
      Kakao.Auth.setAccessToken(undefined)
    }
  }  
</script>

<!-- <template>
	<div>
		<a id="custom-login-btn" click="kakaoLogin()">
			<img src="//k.kakaocdn.net/14/dn/btqCn0WEmI3/nijroPfbpCa4at5EIsjyf0/o.jpg" width="222" />
</a>
	</div>
</template> -->


<!-- <script src="/resources/js/kakaoLogin.js"></script> -->

</body>
</html>