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
	   <div class="contleft">
	    <ul class="leftNav">
	     <li><a href="${pageContext.request.contextPath }/jsp/about.jsp">关于我们</a></li>
	     <li class="leftNavCur"><a href="${pageContext.request.contextPath }/jsp/contact.jsp">联系我们</a></li>
	    </ul><!--leftNav/-->
	   </div><!--contleft/-->
	   <div class="contright">
	    <h2 class="rightat">联系我们</h2>
	    <div class="about">
	     <img src="images/about.jpg" /><br />
	    </div>
	   </div><!--contright/-->
	   <div class="clears"></div>
	  </div><!--width1190/-->
	 </div><!--content/-->
	 <%@include file="/jsp/foot.jsp" %>
  </body>
</html>
