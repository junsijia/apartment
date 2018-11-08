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
    <c:if test="${rentBean != null }">
	 <div class="content">
	  <div class="width1190" style="width:1000px;">
	   <div class="proImg fl">
	    <img src="${pageContext.request.contextPath }/${rentBean.house.rentHousePicture}" />
	   </div><!--proImg/-->
	   <div class="proText fr">
	    <h3 class="proTitle">${rentBean.adress } </h3>
	    <div class="proText1">
	     订单编号：${rentBean.id }<br />
	     商品编号：${rentBean.hid}<br />
	     商品售价：${rentBean.house.rentHousePrice }元/月<br />	     
	     下单时间：${rentBean.ordertime }<br />	       	
	     <c:if test="${rentBean.state == 0 }">
	     	订单状态：未付款<br />	    
	     </c:if>
	     <c:if test="${rentBean.state == 1 }">
	     	订单状态：已付款<br />	    
	     </c:if>
	    </div>
	    <div class="xun-car">
	     <a href="javascript:;" class="xwjg"><strong>去付款</strong></a>
	     <a href="${pageContext.request.contextPath }/servlet/OrderServlet?method=del&oid=${rentBean.id }&hid=${rentBean.hid}" class="projrgwc">取消订单</a>
	    </div><!--xun-car/-->
	   </div><!--proText/-->
	   <div class="clears"></div>
	  </div><!--width1190/--> 
	 </div><!--content/-->	
	 </c:if>
	 <c:if test="${saleBean != null }">
	 <div class="content">
	  <div class="width1190" style="width:1000px;">
	   <div class="proImg fl">
	    <img src="${pageContext.request.contextPath }/${saleBean.house1.housePicture}" />
	   </div><!--proImg/-->
	   <div class="proText fr">
	    <h3 class="proTitle">${saleBean.adress } </h3>
	    <div class="proText1">
	     订单编号：${saleBean.id }<br />
	     商品编号：${saleBean.hid}<br />
	     商品售价：${saleBean.house1.housePrice }元/月<br />	     
	     下单时间：${saleBean.ordertime }<br />	       	
	     <c:if test="${saleBean.state == 0 }">
	     	订单状态：未付款<br />	    
	     </c:if>
	     <c:if test="${saleBean.state == 1 }">
	     	订单状态：已付款<br />	    
	     </c:if>
	    </div>
	    <div class="xun-car">
	     <a href="javascript:;" class="xwjg"><strong>去付款</strong></a>
	     <a href="${pageContext.request.contextPath }/servlet/OrderServlet?method=del&oid=${saleBean.id }&hid=${saleBean.hid}" class="projrgwc">取消订单</a>
	    </div><!--xun-car/-->
	   </div><!--proText/-->
	   <div class="clears"></div>
	  </div><!--width1190/--> 
	 </div><!--content/-->	
	 </c:if>
	<%@include file="/jsp/foot.jsp" %>
  </body>
</html>
