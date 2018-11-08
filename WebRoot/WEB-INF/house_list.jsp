<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script type="text/javascript" src="${pageContext.request.contextPath }/scripts/jquery/jquery-1.7.1.js"></script>
	<link href="${pageContext.request.contextPath }/style/authority/basic_layout.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath }/style/authority/common_style.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="${pageContext.request.contextPath }/scripts/authority/commonAll.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/scripts/fancybox/jquery.fancybox-1.3.4.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/scripts/fancybox/jquery.fancybox-1.3.4.pack.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/style/authority/jquery.fancybox-1.3.4.css" media="screen"></link>
	<script type="text/javascript" src="${pageContext.request.contextPath }/scripts/artDialog/artDialog.js?skin=default"></script>

	<style>
		.alt td{ background:black !important;}
	</style>
   </head>
  <body>
		<input type="hidden" name="allIDCheck" value="" id="allIDCheck"/>
		<input type="hidden" name="fangyuanEntity.fyXqName" value="" id="fyXqName"/>
		<div id="container">
			<div class="ui_content">
				<div class="ui_tb">
					<table class="table" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
						<tr>
							<th>位置</th>
							<th>房源</th>
							<th>房源面积</th>
							<th>计租面积</th>
							<th>户型</th>
							<th>装修情况</th>
							<th>订单状态</th>
							<th>操作</th>
						</tr>
						<c:forEach items="${rh}" var="r">
						<tr>
							<td>${r.rentHouseShen }-${r.rentHouseCity }</td>
							<td>${r.rentHouseAddress }</td>
							<td>${r.rentHouseArea}</td>
							<td>${r.rentHouseArea}</td>
							<td>${r.rentHouseRoom}</td>
							<td>${r.rentHouseDecoration}</td>
							<c:if test="${r.verify == 0 }">
						    	<td>未审核</td>	    
						    </c:if>
						    <c:if test="${r.verify == 1 }">
						    	<td>已审核</td>    
						    </c:if>
							<td>
								<c:if test="${r.verify == 0 }">
							    	<a href="${pageContext.request.contextPath }/servlet/AdminServlet?method=update&id=${r.rentHouseId}" class="edit">通过</a> 
							    </c:if>	
							    <c:if test="${r.verify == 1 }">
							    	<a href="${pageContext.request.contextPath }/servlet/AdminServlet?method=update1&id=${r.rentHouseId}" class="edit">下架</a> 
							    </c:if>							
								<a href="${pageContext.request.contextPath }/servlet/AdminServlet?method=del&id=${r.rentHouseId }">删除</a>
							</td>
						</tr>
						</c:forEach>						
					</table>
				</div>
			</div>
		</div>
  </body>
</html>
