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
	           <a href="${pageContext.request.contextPath }/servlet/UserServlet?method=center" >我的资料</a>
	           <a href="${pageContext.request.contextPath }/servlet/UserServlet?method=user_pwd" class="vipNavCur">账户密码设置</a>
	          </dd>
	         <dt class="vipIcon1">我的邻居大妈</dt>
	          <dd>
	           <a href="${pageContext.request.contextPath }/servlet/UserServlet?method=attention">关注房源</a>
	           <a href="${pageContext.request.contextPath }/servlet/UserServlet?method=order">我的订单</a>
	          </dd>
	        </dl>
	       </div><!--vipNav/-->
	    </div><!--vip-left/-->
	    <div class="vip-right">
	     
	     <h3 class="vipright-title">修改资料</h3>
	     <table class="grinfo">
	      <tbody>
	        <tr>
		        <th>原手机号：</th>
		        <td> <strong>${user.telphone }</strong></td>
	        </tr>
	        <tr>
	        <th>账号：</th>
	        <td> 
	        	<input class="inp inw" type="text" id="new_username" maxlength="15" value="${user.userName }" onkeyup="checkName();">	        
	        	<span id="checkname" style="color:red;"></span>
	        </td>
	        </tr>
	        <tr>
		        <th>新密码：</th>
		        <td>
		        	<input class="inp inw" type="password" id="new_password" placeholder="输入新密码" >
		        </td>
	        </tr>
	        <tr>
		        <th>重复新密码：</th>
		        <td>
		        	<input class="inp inw" type="password" id="new_password1" placeholder="再次输入新密码" onblur="checkPwd();">
		        	<span id="checkpwd" style="color:red;"></span>
		        </td>
	        </tr>
	        <tr>
		        <th>&nbsp;</th>
		        <td colspan="2">
		        <label class="butt" id="butt"></label>
		        <div class="member_mod_buttom"  onclick="sub_username('${user.userId}')" >完成修改</div>		        
		        </td>
	        </tr>
	        </tbody>
		   </table>  
	     
	    </div><!--vip-right/-->
	    <div class="clearfix"></div>
	  </div><!--width1190/-->
 	</div><!--content/-->
	<%@include file="/jsp/foot.jsp" %>
	<script type="text/javascript">
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
		};
		function checkName() {
			createXMLHTTP();
			var name = document.getElementById("new_username");
			xmlhttp.open("post","${pageContext.request.contextPath }/servlet/CheckServlet?userName="+name.value,true);
			xmlhttp.onreadystatechange = myStatechange;
			xmlhttp.send();
		};
		function myStatechange() {
			if (xmlhttp.readyState==4 && xmlhttp.status==200)
		    {
				document.getElementById("checkname").innerHTML = xmlhttp.responseText;
		    }
		};
			

		function checkPwd(){
			var pwd = document.getElementById("new_password");
			var pwd1 = document.getElementById("new_password1");
			if(pwd.value == null || pwd1.value == null){
				document.getElementById("checkpwd").innerHTML = "请输入密码";
			}else if(pwd.value != pwd1.value){				
				document.getElementById("checkpwd").innerHTML = "密码输入不一致";
			}else{
				document.getElementById("checkpwd").innerHTML = "";
			}
		};
		function sub_username(id){
			var name = document.getElementById("new_username");
			var password = document.getElementById("new_password");
			name=name.value;
			password=password.value;
			location.href="${pageContext.request.contextPath}/servlet/UserServlet?method=nameAndPwd&userId="+id+"&name="+name+"&password="+password;
		};

	</script>
  </body>
</html>
