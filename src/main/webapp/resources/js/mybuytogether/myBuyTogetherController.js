$('head').append('<script src=\'/resources/js/mybuytogether/myBuyTogetherDao.js\'><\/script>');

function myBuyTogetherController() {

	var dao = new myBuyTogetherDao();

	//개설한 같이사냥 
	this.openBuyTogether = function(scri) {

		dao.openBuyTogether(scri);

	}

	//참여한 같이사냥
	this.joinBuyTogether = function(scri) {

		dao.joinBuyTogether(scri);

	}

	//완료한 같이사냥
	this.doneBuyTogether = function(scri) {

		dao.doneBuyTogether(scri);

	}
	
	//(개설한)평판매길 유저 정보 가져오기
	this.openReputationBtn = function(buyTogetherNumber){
		
		dao.openReputationBtn(buyTogetherNumber);
	} 
	
	//(개설한)평판매기기
	this.requestScoreUserInfo = function(scoreUserInfoList){
		
		dao.scoreUserInfo(scoreUserInfoList);
	}
	
	//같이사냥 완료하기
	this.requestFinishBuyTogether = function(buyTogetherNumber){
		
		dao.finishBuyTogether(buyTogetherNumber);
	}
	
	//(참여한)평판매길 유저 정보 가져오기
	this.joinReputationBtn = function(buyTogetherNumber){
		
		var html1 = dao.joinReputationBtn(buyTogetherNumber);
		return html1;
	} 
	
	//(참여한)평판매기기
	this.requestScoreUserInfoForJoiner = function(scored_user_number, score, score_user_number, buyTogetherNumber){
		
		dao.ScoreUserInfoForJoiner(scored_user_number, score, score_user_number, buyTogetherNumber);
	}
	
}
