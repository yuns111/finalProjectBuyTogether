function loginDao() {

//	페북로그인 dao 메서드
	this.FBLoginDao = function(response) {

		var isUser;

		try{
			
			$.ajax({
				type: 'post',
				url: '/user/login',
				async : false,			               
				data: JSON.stringify({
					id : response.id,
					name : response.last_name + response.first_name, 
					email : response.email
				}),
				dataType: 'text', //서버에서 보내오는 데이터 타입
				success:function(data){
					console.log("result: " + data);
					isUser = data;
				}

			});
			
		} catch(e) {
			console.log('loginDao예외 발생');
			console.log(e.message);
		}

		return isUser;
	}

}
