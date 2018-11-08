<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'proinfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="shortcut icon" href="images/icon4.jpg" />
	<link type="text/css" href="css/css.css" rel="stylesheet" />
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/js.js"></script>	
  </head>
  
  <body>
    <%@include file="/jsp/header.jsp" %>
	 <div class="content">
	  <div class="width1190" style="width:1000px;">
	   <div class="proImg fl">
	    <img src="${pageContext.request.contextPath }/${saleBean.housePicture}" />
	   </div><!--proImg/-->
	   <div class="proText fr">
	    <h3 class="proTitle">${saleBean.houseAddress } </h3>
	    <div class="proText1">
	     编号：${saleBean.houseId }<br />
	     用户：${saleBean.userName}<br />
	     售价：${saleBean.housePrice }万<br />
	     户型：${saleBean.houseRoom }<br />
		 楼层：${saleBean.floor}<br />	     
	     面积：${saleBean.houseArea }㎡<br />	     
	     装修：${saleBean.decoration }<br />
	     时间：${saleBean.builddate }
	    </div>
	    <div class="xun-car">
	     <a href="${pageContext.request.contextPath }/servlet/OrderServlet?method=saveRent&id=${saleBean.houseId }" class="xwjg">¥<strong>${saleBean.housePrice }</strong>万</a>
	     <a href="${pageContext.request.contextPath }/servlet/SaleAttentionServlet?method=add&id=${saleBean.houseId }" class="projrgwc">关注房源</a>
	    </div><!--xun-car/-->
	   </div><!--proText/-->
	   <div class="clears"></div>
	  </div><!--width1190/-->
	  <div class="proBox" style="width:1000px;margin:10px auto;">
	  <div class="proEq">
	   <ul class="fl">
	    <li class="proEqCur">房源详情</li>
	    <li>房源图片</li>
	    <li>小区介绍</li>
	   </ul>
	   <div class="lxkf fr"><a href="http://wpa.qq.com/msgrd?v=3&uin=1072631488&site=qq&menu=yes" target="_blank"></a></div>
	   <div class="clears"></div>
	  </div><!--proEq/-->
	  <div class="proList">
	  
	  	${saleBean.describle }<br />

	  </div><!--proList/-->
	  <div class="proList">
	   暂无图片信息...
	  </div><!--proList/-->
	  <div class="proList">
	   暂无信息...
	  </div><!--proList/-->
	 </div><!--proBox/-->	 
	 </div><!--content/-->	
	<%@include file="/jsp/foot.jsp" %>
  </body>
</html>
