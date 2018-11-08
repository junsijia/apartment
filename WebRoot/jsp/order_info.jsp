<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
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
	  <div class="width1190">
	   <div class="vip-left">
	       <div class="vipNav">
	        <h3 class="vipTitle">会员中心</h3>
	        <dl>
	         <dt class="vipIcon3">账户设置</dt>
	          <dd>
	           <a href="${pageContext.request.contextPath }/servlet/UserServlet?method=center">我的资料</a>
	           <a href="${pageContext.request.contextPath }/servlet/UserServlet?method=user_pwd">账户密码设置</a>
	          </dd>
	         <dt class="vipIcon1">我的邻居大妈</dt>
	          <dd>
	           <a href="${pageContext.request.contextPath }/servlet/UserServlet?method=attention">关注房源</a>
	           <a href="${pageContext.request.contextPath }/servlet/UserServlet?method=order" class="vipNavCur">我的订单</a>
	          </dd>
	        </dl>
	       </div><!--vipNav/-->
	    </div><!--vip-left/-->
	    <div class="vip-right">
	     
	     <h3 class="vipright-title">我的订单</h3>
	      <div class="guanzhulist">
		     <c:if test="${empty bean }">
			 	<h3>购物车空空如也,亲,请先去逛逛去吧~~~~~~~~~~~</h3>
			 </c:if>
			 <c:if test="${not empty bean}">
			   <c:forEach items="${bean }" var="bean">
			       <dl>
			        <dd>
			         <h3><a href="${pageContext.request.contextPath }/servlet/OrderServlet?method=find&id=${bean.id}&hid=${bean.hid}">${bean.adress}</a></h3>
			         <div class="guantext">订单编号：${bean.id}</div>
			         <div class="guantext">商品编号：${bean.hid} | 卖家：${bean.hname} </div>			         
			         <c:if test="${bean.state == 0 }">
				     	<div class="guantext">订单状态：未付款</div><br />	    
				     </c:if>
				     <c:if test="${bean.state == 1 }">
				     	<div class="guantext">订单状态：已付款</div><br />	    
				     </c:if>
			         <div class="guantext2">下单时间：${bean.ordertime }    <a href="${pageContext.request.contextPath }/servlet/OrderServlet?method=del_s&id=${bean.id }" class="qxgz">删除订单</a></div>
			        </dd>			  
			       	<div class="clearfix"></div>	       
		      	   </dl>
		       </c:forEach>
		     </c:if>      
	 	 </div><!--guanzhulist/-->
	    </div><!--vip-right/-->
	    <div class="clearfix"></div>
	  </div><!--width1190/-->
 	</div><!--content/-->
	<%@include file="/jsp/foot.jsp" %>
  </body>
</html>
