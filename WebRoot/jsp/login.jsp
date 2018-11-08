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
	   <div class="reg-logo">
	   <form id="signupForm" method="post" action="" class="zcform">
	        <p class="clearfix">
	        	<label class="one" for="user">用户名：</label>
	        	<input id="user" name="user" type="text" class="required" value placeholder="请输入您的用户名" />
	        </p>
	        <p class="clearfix">
	         	<label class="one"  for="password">登录密码：</label>
	        	<input id="password" name="password" type="password" class="{required:true,rangelength:[8,20],}" value placeholder="请输入密码" />
	        </p>
	        <!--<p class="clearfix agreement">
	        	<input type="checkbox" />
	            <b class="left">已阅读并同意<a href="#">《用户协议》</a></b>
	        </p>-->
	       	<p class="clearfix"><input id="sub" class="submit" type="button" value="立即登录"/></p>
	    </form>
	    <div class="reg-logo-right">
	     <h3>如果您没有账号，请</h3>
	     <a href="${pageContext.request.contextPath }/servlet/UserServlet?method=registUI" class="logo-a">立即注册</a>
	    </div><!--reg-logo-right/.-->
	    <div class="clears"></div>
	  </div><!--reg-logo/-->
	  </div><!--width1190/-->
	 </div><!--content/-->
	 <script type="text/javascript">
	 	$(document).ready(function(){
	 		$("#sub").click(function(){
	 			if($("#user").val() === ""){
	 				alert("请输入登录名");
	 			}else if($("#password").val() === ""){
	 				alert("请输入密码");
	 			}else{
	 				$("#signupForm").attr("action","${pageContext.request.contextPath }/servlet/UserServlet?method=login").submit();
	 			} 			
	 		});
	 	});
	 </script>
	 <%@include file="/jsp/foot.jsp" %>
  </body>
</html>
