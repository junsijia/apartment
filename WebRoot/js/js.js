// JavaScript Document
$(function(){
	//������һ��Ԫ�صı߾�
	var $indexfang=$('.index-fang-list');
	 $indexfang.each(function(){
	     $(this).find("dl:last").css("margin-right","0");
	   })
	//ָ������
	$(".zhiding").click(function(){
		$(".bg100").show();
		$(".zhidinggoufang").fadeIn();
		})	
	$(".close").click(function(){
		$(".bg100").hide();
		$(".zhidinggoufang").fadeOut();
		})
	//��Ʒ����
	$(".pro-search td a").click(function(){
		 $(this).addClass("pro-cur").siblings("a").removeClass("pro-cur");
		})
	$(".paixu a").click(function(){
		 $(this).addClass("pai-cur").siblings("a").removeClass("pai-cur");
		})
	//��ע��Դ
	$(".guanzhulist:first").fadeIn();
	$(".guanzhueq li").click(function(){
		$(this).addClass("guanzhueqcur").siblings("li").removeClass("guanzhueqcur");
		var guan=$(this).index();
		$(".guanzhulist").eq(guan).fadeIn().siblings(".guanzhulist").hide();
		})
	//��Ʒ����ҳ
	$(".proList:first").fadeIn();
	$(".proEq li").click(function(){
		$(this).addClass("proEqCur").siblings("li").removeClass("proEqCur");
		var proeq=$(this).index();
		$(".proList").eq(proeq).fadeIn().siblings(".proList").hide();
		})	
	})
	
