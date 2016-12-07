
function buytogetherDao() {

	this.listAllDao = function() {
		
		$.getJSON("/restBuytogether/list", function(data) {
			
			var template = Handlebars.compile($('#listTemplate').html());

			var html1 = template(data);

			console.log(data);
			
			$(".buyTogetherLi").remove();
			
			$("#buyTogetherList").html(html1);
		});
	}
}