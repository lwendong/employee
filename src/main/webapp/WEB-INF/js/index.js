$(function(){

	var $date = $(".date");
	var $time = $(".time");
	var $queryDept = $(".query_dept");
	var $addDept = $(".add_dept");
	var $userInfo = $(".user_info");
	var $iframe = $("#iframe");
	var $li = $("li");

	updateTime($date,$time);


	$queryDept.on("click",function(){
		$(this).toggleClass("selected_bgc");
		$(this).siblings().each(function(i){
			$(this).removeClass("selected_bgc");
			$(this).children("*").removeClass("select_color");
		});

		$iframe.attr("src","/dept");
		$(this).children("*").toggleClass("select_color");
	})

	$addDept.on("click",function(){
		$(this).toggleClass("selected_bgc");
		$(this).siblings().each(function(i){
			$(this).removeClass("selected_bgc");
			$(this).children("*").removeClass("select_color");
		});
		$iframe.attr("src","/addDept");
		$(this).children("*").toggleClass("select_color");
	})

	$userInfo.on("click",function(){
		$(this).toggleClass("selected_bgc");
		$(this).siblings().each(function(i){
			$(this).removeClass("selected_bgc");
			$(this).children("*").removeClass("select_color");
		});
		$iframe.attr("src","/employeeList");
		$(this).children("*").toggleClass("select_color");
	})

	$queryDept.trigger("click");



})
function updateTime($date,$time){
	setInterval(function(){
		var myDate = new Date;
		var year = myDate.getFullYear(); //获取当前年
		var mon = myDate.getMonth() + 1; //获取当前月
		var date = myDate.getDate();
		var h = myDate.getHours();//获取当前小时数(0-23)
		var m = myDate.getMinutes();//获取当前分钟数(0-59)
		var s = myDate.getSeconds();
		var ampm;
		if(h >= 12){
			ampm = "PM"
		}else{
			ampm = "AM"
		}
		if(m < 10){
			m = "0"+m
		}
		if(s < 10){
			s = "0"+s
		}
		$date.text(year+"年,"+mon+"月,"+date+"日");
		$time.text(h+":"+m+":"+s+"  PM");
	},1000);
}
