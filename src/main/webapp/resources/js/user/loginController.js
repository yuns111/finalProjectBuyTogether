$('head').append('<script type="text/javascript" src="../js/user/loginDao.js"></script>')

function loginController() {
	
	var loginDao = new loginDao();
	
	this.requestFBLogin = function() {
		
		FB.login(function(response) {

			if (response.status === 'connected') { //페북로그인상태인 같이사냥 유저

				FB.api('/me?fields=email,first_name,last_name, id', function(response) { 
					
					if((dao.FBLoginDao(response))) { //첫 로그인이면
						
						self.location = "";
						
					} else { //첫 로그인이 아니면
						
						self.location = "/user/newUser";
						
					}

				});

			} else if (response.status === 'not_authorized') { //페북로그인상태지만 같이사냥 유저는 아님
				document.getElementById('status').innerHTML = 'Please log ' +
				'into this app.';
			} else { //페북로그아웃상태
				document.getElementById('status').innerHTML = 'Please log ' +
				'into Facebook.';
			}

		}, {scope: 'public_profile,email'});

	};

}
