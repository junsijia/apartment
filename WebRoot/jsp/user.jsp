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
	           <a href="${pageContext.request.contextPath }/servlet/UserServlet?method=center" class="vipNavCur">我的资料</a>
	           <a href="${pageContext.request.contextPath }/servlet/UserServlet?method=user_pwd">账户密码设置</a>
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
			        <th>手机号：</th>
			        	<td> <strong>${user.telphone }</strong>
			        </td>
		        </tr>
		        <tr>
			        <th><span class="red">*</span> 姓 &nbsp; &nbsp;名：</th>
			        <td>
			        	<input class="inp inw" type="text" id="title" value="${user.linkPerson }" maxlength="14">
			        </td>
		        </tr>
		        <tr>
			        <th><span class="red">*</span> 性 &nbsp; &nbsp;别：</th>
			        <td>
			          <c:if test="${user.sex == '女'}">
				        <input type="radio" value="女" id="rbSex1" name="sex" checked>
				        <label for="rbSex1">女</label>
				        <input type="radio" value="男" id="rbSex2" name="sex" >
				        <label for="rbSex2">男</label>
				        <span id="Sex_Tip"></span>
				      </c:if>
				      <c:if test="${user.sex == '男'}">
				        <input type="radio" value="女" id="rbSex1" name="sex" >
				        <label for="rbSex1">女</label>
				        <input type="radio" value="男" id="rbSex2" name="sex" checked>
				        <label for="rbSex2">男</label>
				        <span id="Sex_Tip"></span>
				      </c:if>
			        </td>
		        </tr>
		        <tr>
			        <th><span class="red"></span> 年 &nbsp; &nbsp;龄：</th>
			        <td>
			        	<!-- onkeyup="this.value=this.value.replace(/[^\d]/g,'');" 限制只能输入数字 -->
			        	<input class="inp inw" type="text" id="age" value="${user.age }" onkeyup="this.value=this.value.replace(/[^\d]/g,'');">
			        </td>
		        </tr>
		        
		        
		        <tr>
			        <th>&nbsp;Q &nbsp; &nbsp;Q：</th>
			        <td>
			       		<input class="inp inw" type="text" maxlength="15" value="${user.qq }" id="qq" onkeyup="this.value=this.value.replace(/[^\d]/g,'');">
			        </td>
		        </tr>
		        
		        <tr>
			        <th valign="top">个性签名：</th>
			        <td>
				        <textarea id="sign" class="grtextarea" >${user.signature }</textarea>
				        <br>
				        <span class="fgrey">(128字符以内)</span>
			        </td>
		        </tr>
		        <tr>
			        <th>&nbsp;</th>
			        <td colspan="2">
			        <label class="butt" id="butt">
			        	<input type="submit" class="member_mod_buttom" onclick="mod_member('${user.userId}');" value="完成修改" />
			        </label>
			        </td>
		        </tr>
	        </tbody>
	      </table>
	    </div><!--vip-right/-->
	    <div class="clearfix"></div>
	  </div><!--width1190/-->
 	</div><!--content/-->
 	<script type="text/javascript">
 		function mod_member(id){
 			var title = document.getElementById("title");
 			var sex = $("input[name='sex']:checked").val();
 			var age = document.getElementById("age");
 			var qq = document.getElementById("qq");
 			var sign = document.getElementById("sign");
 			location.href="${pageContext.request.contextPath}/servlet/UserServlet?method=updataUser&userId="+id+"&linkPerson="+title.value+"&sex="+sex+"&age="+age.value+"&qq="+qq.value+"&signature="+sign.value;
 		};
 	</script>
	<%@include file="/jsp/foot.jsp" %>
  </body>
</html>
