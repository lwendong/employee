$(function(){
	var $edit = $(".edit");
	var $close = $(".close");
	var $submit = $(".submit");
	var $list = $(".inner_center_info_list");

	$.ajax({
		url:"/employee/queryAll",
		type:"get",
		dataType:"json",
		contentType: "application/json;charset=utf-8",
		data:{
			pageNo:1,
			pageNum:9,
			search:null
		},
		success:function (result){
			$list.html("")
			for (var em of result.data) {
				var tmp = `<div class="inner_center_info_dept item" onclick="editEm(this)">
                                <span class="name">${em.name}</span>
                                <span class="toe">${em.birthday}</span>
                                <span class="code">${em.code}</span>
                                <span class="mana">${em.deptName != null ? em.deptName : "暂无部门"}</span>
                                <span class="count">￥ ${em.money != null ? em.money : 0}</span>
                            </div>`;
				$list.append(tmp);
			}
		}
	})

	$(document).keydown(function(e){
		if(13 === e.keyCode){
			var $searchEm = $(".search_em").val();
			$.ajax({
				url:"/employee/queryAll",
				type:"get",
				dataType:"json",
				contentType: "application/json;charset=utf-8",
				data:{
					pageNo:1,
					pageNum:9,
					search:$searchEm
				},
				success:function (result){
					$list.html("")
					for (var em of result.data) {
						var tmp = `<div class="inner_center_info_dept item" onclick="editEm(this)">
                                <span class="name">${em.name}</span>
                                <span class="toe"><fmt:formatDate value="${em.birthday}" pattern="yyyy.MM.dd"/></span>
                                <span class="code">${em.code}</span>
                                <span class="mana">${em.deptName != null ? em.deptName : "暂无部门"}</span>
                                <span class="count">￥ ${em.money != null ? em.money : 0}</span>
                            </div>`;
						$list.append(tmp);
					}
				}
			})
		}
	});

	$submit.on("click",function (){
		var code = $(".edit_code").val();
		var name = $(".edit_name").val();
		var birthday = $(".birthday").val();
		var sex = $(".sex").val();
		var work = $(".work").val();
		var workDate = $(".word_time").val();
		var money = $(".money").val();
		var moneyB = $(".money_b").val();
		var deptCode = $(".dept_code").val();


		$.ajax({
			url:"/employee/update",
			type:"post",
			dataType:"json",
			contentType: "application/json;charset=utf-8",
			data:JSON.stringify({
				code,name,birthday,sex,work,workDate,money,moneyB,deptCode
			}),
			success:function (result){
				window.location.reload();
			}
		})
	})



	$close.on("click",function(){
		$edit.css("display","none");
	})
})
function editEm(event){
	$(".edit").css("display","block");
	var code = $(event).children(".code").text();
	$(".edit_code").val(code);
}