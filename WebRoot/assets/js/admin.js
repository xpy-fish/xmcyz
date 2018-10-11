/**
 * 后台管理用js
 */
$(function(){
	$("#cyz_admin_nav li").on("click",function(){
		$("#cyz_admin_nav li.active").removeClass("active");
		$(this).addClass("active");
	});
});
