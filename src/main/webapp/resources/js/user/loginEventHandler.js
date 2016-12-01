$('head').append('<script type="text/javascript" src="../js/user/loginController.js"></script>')

$(document).ready(function() {
	
	var loginController = new loginController();
	
	$('#FBlogin').on("click", function(event) {
		
		loginController.requestFBLogin();
		
	});

});
