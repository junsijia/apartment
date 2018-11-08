<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
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
	<script type="text/javascript">
	//创建ajax
	var xmlhttp = null;
	function createXMLHTTP() {			
		if (window.XMLHttpRequest)
		{
		    //  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
		    xmlhttp = new XMLHttpRequest();
		}
		else
		{
		    // IE6, IE5 浏览器执行代码
		    xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
	}
	function onCheck() {
		createXMLHTTP();
		var userName = document.getElementById("user");
		xmlhttp.open("post","${pageContext.request.contextPath }/servlet/CheckServlet?userName="+userName.value,true);
		xmlhttp.onreadystatechange = myStatechange;
		xmlhttp.send();
	}
	function myStatechange() {
		if (xmlhttp.readyState==4 && xmlhttp.status==200)
	    {
			document.getElementById("span1").innerHTML = xmlhttp.responseText;
	    }
	}
	</script>
  </head>
  
  <body>
  	<%@include file="/jsp/header.jsp" %>
	 <div class="content">
	  <div class="width1190">
	   <div class="reg-logo">
	   <form id="signupForm" method="post" action="" class="zcform">
	        <p class="clearfix">
	        	<label class="one" for="user">用户名：</label>
	        	<input id="user" name="user" type="text" class="required" onblur="onCheck();" value="" placeholder="请输入您的用户名" />
	        	<center><span id="span1" style="color:red;"></span></center>
	        </p>
	        
	        <p class="clearfix">
	         	<label class="one"  for="password">登录密码：</label>
	        	<input id="password" name="password" type="password" class="{required:true,rangelength:[8,20],}" value="" placeholder="请输入密码" />
	        </p>
	        <p class="clearfix">
	        	<label class="one" for="linkPerson">家人名字：</label>
	        	<input id="linkPerson" name="linkPerson" type="text" class="{required:true,equalTo:'#password'}" value="" placeholder="请输入家人名字" />
	        </p>
	        <p class="clearfix">
	        	<label class="one" for="telphone">电话：</label>
	        	<input id="telphone" name="telphone" type="text" class="{required:true,equalTo:'#password'}" value="" placeholder="请输入您的电话号码" />
	        </p>
	        <p class="clearfix">
	        	<label class="one" for="email">邮箱：</label>
	        	<input id="email" name="email" type="text" class="{required:true,equalTo:'#password'}" value="" placeholder="请输入您的邮箱地址" />
	        </p>
	        <!--<p class="clearfix agreement">
	        	<input type="checkbox" />
	            <b class="left">已阅读并同意<a href="#">《用户协议》</a></b>
	        </p>-->
	       	<p class="clearfix"><input id="register_sub" class="submit" type="button" value="立即注册"/ "></p>  
	    </form>
	    <div class="reg-logo-right">
	     <h3>如果您已有账号，请</h3>
	     <a href="${pageContext.request.contextPath }/servlet/UserServlet?method=loginUI" class="logo-a">立即登录</a>
	    </div><!--reg-logo-right/-->
	    <div class="clears"></div>
	  </div><!--reg-logo/-->
	  </div><!--width1190/-->
	 </div><!--content/-->
	 <script type="text/javascript">
	 	$(document).ready(function(){
 			$("#register_sub").click(function(){
 		 		if($("#user").val() === ""){
 		 			alert("请输入用户名");
 		 		}else if($("#password").val() === ""){
 		 			alert("请输入密码");
 		 		}else if($("#linkPerson").val() === ""){
 		 			alert("请输入家人名字");
 		 		}else if($("#telphone").val() === ""){
 		 			alert("请输入电话");
 		 		}else if($("#email").val() === ""){
 		 			alert("请输入邮箱");
 		 		}else{
					$("#signupForm").attr("action", "${pageContext.request.contextPath }/servlet/UserServlet?method=regist").submit();
 		 		}
 		 	});
	 			
		});
	 
	 </script>
	 <%@include file="/jsp/foot.jsp" %>
  </body>
</html>
