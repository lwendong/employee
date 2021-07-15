$(function(){
	var $edit = $(".edit");
	var $item = $(".item");
	var $close = $(".close");
	var $submit = $(".submit");
	$item.on("click",function(){
		$edit.css("display","block");
	})
	$close.on("click",function(){
		$edit.css("display","none");
	})
})