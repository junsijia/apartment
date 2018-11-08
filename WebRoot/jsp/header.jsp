<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
		
	<link rel="stylesheet" type="text/css" href="css/normalize.css" />
	<link rel="stylesheet" type="text/css" href="css/default.css">
	-->
  </head>
   <body>
   	<div id="snowspawner"></div>
   	<script src="js/jquery-2.1.1.min.js"></script>
	<script src="js/jquery-ui.min.js" charset="utf-8"></script>
    <script src="js/letItSnow.js" charset="utf-8"></script>
	<div class="header">
		<div class="width1190">
		   	<div class="fl">您好，欢迎来到邻居大妈！</div>
		   	<div class="fr">
		   		<c:if test="${empty user }">
			   		<a href="${pageContext.request.contextPath}/servlet/UserServlet?method=loginUI">登录</a> | 
				    <a href="${pageContext.request.contextPath}/servlet/UserServlet?method=registUI">注册</a>  
		   		</c:if>
		   		<c:if test="${not empty user }">
		   			<a>您好，${user.userName }</a> |
					<a href="${pageContext.request.contextPath}/servlet/UserServlet?method=attention">我的关注</a> |
					<a href="${pageContext.request.contextPath }/servlet/UserServlet?method=order">我的订单</a> |
				    <a href="${pageContext.request.contextPath}/servlet/UserServlet?method=logout">退出</a>  
			    </c:if>  
		   	</div>
		   	<div class="clears"></div>
	  	</div><!--width1190/-->
	</div><!--header/-->
 	<div class="logo-phone">
  		<div class="width1190">
	   		<h1 class="logo"><a href="index.html"><img src="images/logo.png" width="163" height="59" /></a></h1>
	  		<div class="phones"><strong>021-63179891</strong></div>
	   		<div class="clears"></div>
  		</div><!--width1190/-->
 	</div><!--logo-phone/-->
 	<div class="list-nav">
  		<div class="width1190">
	   	<ul class="nav">
		    <li><a href="${pageContext.request.contextPath }/servlet/IndexServlet?method=index">首页</a></li>
		    <li><a href="${pageContext.request.contextPath }/servlet/PageServlet?method=findByRentPage&pageNumber=1&city=0&price=0&area=0&type=0">租房</a></li>
		    <li><a href="${pageContext.request.contextPath }/servlet/PageServlet?method=findBySalePage&pageNumber=1&city=0&price=0&area=0&type=0">二手房</a></li>		    
		    <li><a href="${pageContext.request.contextPath }/servlet/FaBuServlet?method=rentFaBu">发布出租房源</a></li>
		    <li><a href="${pageContext.request.contextPath }/servlet/FaBuServlet?method=saleFaBu">发布出售房源</a></li>
<!-- 		<li class="zhiding"><a href="javascript:;">发布求租信息</a></li>
		    <li class="zhiding"><a href="javascript:;">发布求购信息</a></li>  -->
		    <li><a href="${pageContext.request.contextPath }/jsp/about.jsp">关于我们</a></li>     						
	   	</ul><!--nav/-->
   		<div class="clears"></div>
  		</div><!--width1190/-->
 	</div><!--list-nav/-->
 	<script type="text/javascript">
      $(function launchSnowflakes() {
        $('#snowspawner').letItSnow({
          color: '#fff',
          size_min: 5,
          size_max: 15,
          zindex: 99999,
          maxcount: 100,
          wind: 250,
          easing_x: "easeInBack",
          easing_y: "easeInCubic",
          fall_time: 5000
        });
      });
    </script>
 	
  </body>
</html>
