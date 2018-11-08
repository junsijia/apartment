<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  
  <body>
  	<div class="footer">
	  <div class="width1190">
	   <div class="fl"><a href="${pageContext.request.contextPath }/servlet/IndexServlet?method=index" ><strong>邻居大妈</strong></a><a href="${pageContext.request.contextPath }/jsp/about.jsp">关于我们</a><a href="${pageContext.request.contextPath }/jsp/contact.jsp">联系我们</a><a href="${pageContext.request.contextPath }/servlet/UserServlet?method=center">个人中心</a></div>
	   <div class="fr">
	    <dl>
	     <dt><img src="images/erweima.png" width="76" height="76" /></dt>
	     <dd>微信扫一扫<br />房价点评，精彩发布</dd>
	    </dl>
	    <dl>
	     <dt><img src="images/erweima.png" width="76" height="76" /></dt>
	     <dd>微信扫一扫<br />房价点评，精彩发布</dd>
	    </dl>
	    <div class="clears"></div>
	   </div>
	   <div class="clears"></div>
	  </div><!--width1190/-->
	</div><!--footer/-->
	 <div class="copy">Copyright@ 2015 邻居大妈 版权所有 沪ICP备1234567号-0&nbsp;&nbsp;&nbsp;&nbsp;技术支持：<a target="_blank" href="${pageContext.request.contextPath }/servlet/AdminServlet?method=tiaozhuan">后台管理</a> </div>
  </body>
</html>
