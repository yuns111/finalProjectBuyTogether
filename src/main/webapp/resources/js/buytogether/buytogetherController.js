$('head').append('<script src=\'/resources/js/buytogether/buytogetherDao.js\'><\/script>');

function buytogetherController() {

	var dao = new buytogetherDao();

	//글쓰기 버튼 클릭시 글쓰기 뷰로 이동
	this.requestWrite = function() {

		document.location = '/buyTogether/write';
	}

	//유저의 관심카테고리 존재 여부 확인
	this.requestUserInterest = function(user_number) {

		return dao.listUserInterest(user_number);
	}

	//같이사냥 목록 요청
	this.requestListAll = function(scri) {

		//큐브를 삭제
		var cube = new cubphoto();
		cube.destory();
		$('.buyTogetherList').children().remove();
		
		var parsedResult = dao.listBuyTogetherDao(scri);
		var searchBuyTogether = parsedResult.searchBuyTogether;
		
		//초기화
		cube.init();
		
		//같이사냥 글이 없으면 해당 글 없음 화면에 표시
		if(searchBuyTogether.length == 0) {
			
			$("#noItem").show();
			$('.buyTogetherList').hide();
			$("#pagination").hide();

			return;
		}
		
		$('.buyTogetherList').show();
		
		//리스트 붙여줌
		for(var i=0; i<searchBuyTogether.length; i++){
			
			var str = "";
			
			if(searchBuyTogether[i].title.length > 14){
				searchBuyTogether[i].title = searchBuyTogether[i].title.substring(0,14);
				searchBuyTogether[i].title += "...";
			}
			if(searchBuyTogether[i].photo_path[0] == null){
				searchBuyTogether[i].photo_path[0] = '/resources/img/noImage.png';
			} else {
				var path = searchBuyTogether[i].photo_path[0].path;
				searchBuyTogether[i].photo_path[0] = "/restBuytogether/displayFile?fileName=" + path;
			}
			str = str + "<div class='cbp-item'>";
			str = str + "<a href='/buyTogether/read?buytogether_number=" + searchBuyTogether[i].buytogether_number;
			str = str + "'class='cbp-caption'>";
			str = str + "<div class='cbp-caption-defaultWrap'>";
			str = str + "<img src='"+searchBuyTogether[i].photo_path[0]+"' alt=''>";
			str = str + "</div> <div class='cbp-caption-activeWrap'>";
			str = str + "<div class='cbp-l-caption-alignLeft'>";
			str = str + "<div class='cbp-l-caption-body'>";
			str = str + "<div class='cbp-l-caption-title' id='title'>" + searchBuyTogether[i].title;
			str = str + "</div><div class='cbp-l-caption-desc' id='nickname'>by " + searchBuyTogether[i].nickname;
			str = str + "(" + searchBuyTogether[i].reputation + ")";
			str = str + "</div></div></div></div></a></div>";
			
			cube.addItem(str);
		}
		$("#noItem").hide();
		
		$("#pagination").show();
		var pageMaker = parsedResult.pageMaker;
		printPaging(pageMaker, $("#pagination"));//페이징
		
	}

	//카테고리 리스트 조회
	this.requestCategoryList = function() {

		dao.listCategoryDao();
	}

	//사냥방식 리스트 조회
	this.requestHuntingTypeList = function() {

		dao.listHuntingTypeDao();
	}

	//사냥상태 리스트 조회
	this.requestHuntingStatusList = function() {

		dao.listHuntingStatusDao();
	}

	//첨부사진 경로 받아옴
	this.requestPhotoPath = function(formData) {

		dao.savePhotoPath(formData);

	}

	//첨부사진 삭제
	this.requestPhotoDelete = function(photo) {

		var result = dao.deletePhotoDao(photo);
		
		if(result == 'deleted') {
			photo.parent().parent("div").remove();
			photo.parent().parent("span").remove();
		}
	}

	//같이사냥 게시글 저장
	this.requestSaveBuyTogether = function(buytogether) {

		dao.insertDao(buytogether);
	}
	
	//같이사냥 해당 글 정보를 가져옴
	this.requestReadOneBuyTogether = function(buytogether_number) {

		var data = dao.readOneDao(buytogether_number);
		console.log(data);
		var dateObj = new Date(data.buytogether.dueDate);
		var year = dateObj.getFullYear();
		var month = dateObj.getMonth() + 1;
		var date = dateObj.getDate();
		var duedate = year+"/"+month+"/"+date;
		
		$("#title").val(data.buytogether.title);
		if(data.buyTogetherAddress != null){
			$("#address").val(data.buyTogetherAddress.buyTogether_address_road_address);
			$("#address_detail").val(data.buyTogetherAddress.buyTogether_address_detail);
		}
		$("#duedate").val(duedate);
		$("#joinin_number").val(data.buytogether.joinin_number);
		$("#price").val(data.buytogether.price);
		$("#content").val(data.buytogether.content);
		$('#category_number option[value=' + data.buytogether.category_number + ']').attr('selected', true);
		$('#hunting_type_number option[value=' + data.buytogether.hunting_type_number + ']').attr('selected', true);
		Editor.modify({
			"content": data.buytogether.content
		});
		for(var i=0;i<data.buytogether.path.length; i++){
			
			var str="<div class='col-md-3'>";
			str = str + "<img src='/restBuytogether/displayFile?fileName=" + data.buytogether.path[i] +"'/>";
			str = str + "<div class='mailbox-attachment-info'>"+data.buytogether.path[i].substr(data.buytogether.path[i].indexOf("_",14)+1);
			str = str + " <small class='btn btn-default btn-xs delbtn' data-src=" + data.buytogether.path[i] + ">X</small></div></div>";

			$(".uploadedList").append(str);
		}
		
		return data;
	}
	
	//같이사냥 글 수정
	this.requestUpdateBuyTogether = function(buytogetherUpdate) {
	
		var result = dao.UpdateBuyTogetherDao(buytogetherUpdate);
		
		if(result == 'success') {
			
			window.location = '/buyTogether/read?buytogether_number=' + buytogetherUpdate.buyTogether_number;

		} else {
			
			$(".modal").modal({'show' : true});
		}
		
	}

	//같이사냥 리스트(map)
	this.requestBuyTogetherMap = function(scri) {

		var parsedResult = dao.listBuyTogetherDao(scri);
		var searchBuyTogether = parsedResult.searchBuyTogether;
		new geoLocation(searchBuyTogether);

	}

	//페이징
	var printPaging = function(pageMaker, target){

		var str = "<ul class='c-content-pagination c-theme' id='forRemove'>";

		if(pageMaker.prev){
			str += "<li><a href='"+(pageMaker.startPage-1)+"'> << </a></li>";
		}

		for(var i = pageMaker.startPage, len = pageMaker.endPage; i <= len; i++){
			var strClass = pageMaker.cri.page == i?'class = active':'';
			str += "<li "+strClass+" class='pageNumber'><a href = '"+i+"'>"+i+"</a></li>";
		}

		if(pageMaker.next){
			str += "<li><a href='"+(pageMaker.endPage+1)+"'> >> </a></li>";
		}

		str += "</ul>"
			target.html(str);
	};
}