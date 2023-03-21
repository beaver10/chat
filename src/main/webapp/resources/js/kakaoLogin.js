methods: {
	function kakaoLogin() {
		window.Kakao.Auth.login({
			scope : 'profile, account_email',
			success : this.getKakaoAccount,
		});
	}
	function getKakaoAccount(){
		window.Kakao.API.request({
			url:'/v2/user/me',
			success : res=>{
				const kakao_account = res.kakao_account;
				const nickname = kakao_account.profile.nickname;
				const email = kakao_account.email;
				console.log('nickname', nickname);
				console.log('email', email);

				alert("로그인 성공!");
			},
			fail : error=>{
				console.log(error);
			}
		})
	}
}