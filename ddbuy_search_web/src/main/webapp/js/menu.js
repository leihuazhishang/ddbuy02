// JavaScript Document
//使用 noConflict() 方法为 jQuery 变量规定新的名称：
var jq = jQuery.noConflict();
jQuery(function(){
	jq(".leftNav ul li").hover(
		function(){
			jq(this).find(".fj").addClass("nuw");
			jq(this).find(".zj").show();
		}
		,
		function(){
			jq(this).find(".fj").removeClass("nuw");
			jq(this).find(".zj").hide();
		}
	)
})
