<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="shortcut icon" href="images/icon4.jpg" />
	<link type="text/css" href="css/css.css" rel="stylesheet" />
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/js.js"></script>	
	<script type="text/javascript">
	 $(function(){
		 //导航定位
		 $(".nav li:eq(0)").addClass("navCur");
		 });
	</script>		
  </head>
  <body>
 <%@include file="/jsp/header.jsp" %>
 <div class="banner" style="background:url(images/ban.jpg) center center no-repeat;"></div>
 
 <div class="content">
  <div class="width1190">
   <h2 class="title">租房 <a href="${pageContext.request.contextPath }/servlet/PageServlet?method=findByRentPage&pageNumber=1&city=0&price=0&area=0&type=0">更多&gt;&gt;</a></h2>
   <div class="index-fang-list">
   <c:forEach items="${rlist }" var="r">
    <dl>
     <dt><a href="${pageContext.request.contextPath }/servlet/InfoServlet?method=getByRentId&id=${r.rentHouseId}"><img src="${pageContext.request.contextPath }/${r.rentHousePicture}" width="286" height="188" /></a></dt>
     <dd>
      <h3><a href="${pageContext.request.contextPath }/servlet/InfoServlet?method=getByRentId&id=${r.rentHouseId}"></a>${fn:substring(r.rentHouseAddress,0,10) }...</h3>
      <div class="hui">${r.rentHouseRoom } | ${r.rentHouseArea }m² | ${r.rentHouseDecoration }修</div>
     </dd>
    </dl>
   </c:forEach>
    
    
    <div class="clears"></div>
   </div><!--index-fang-list/-->
   
   
   
   <h2 class="title">二手房 <a href="${pageContext.request.contextPath }/servlet/PageServlet?method=findBySalePage&pageNumber=1&city=0&price=0&area=0&type=0">更多&gt;&gt;</a></h2>
   <div class="index-ershou">
    <div class="in-er-left">
     <a><img src="images/timg.jpg" width="380" height="285" /></a>
     <div class="in-er-left-text"><strong class="fl">精选二手房</strong></div>
    </div><!--in-er-left/-->
    <div class="in-er-right">
    <c:forEach items="${slist }" var="s">
     <dl>
      <dt><a href="${pageContext.request.contextPath }/servlet/InfoServlet?method=getBySaleId&id=${s.houseId}"><img src="${pageContext.request.contextPath }/${s.housePicture}" width="150" height="98" /></a></dt>
      <dd>
       <h3><a href="${pageContext.request.contextPath }/servlet/InfoServlet?method=getBySaleId&id=${s.houseId}">${fn:substring(s.houseAddress,0,10) }...</a></h3>
       <div class="in-er-right-text">
        ${fn:substring(s.describle,0,50) }...
       </div>
       <div class="price">¥<strong>${s.housePrice }</strong>万</div>
      </dd>
     </dl>
    </c:forEach>
     <div class="clears"></div>
    </div><!--in-er-right/-->
    <div class="clears"></div>
   </div><!--index-ershou/-->
  </div><!--width1190/-->
 </div><!--content/-->
 <div class="xinren">
  <div class="width1190">
   <dl style="background:url(images/icon1.jpg) left center no-repeat;">
    <dt>承诺</dt>
    <dd>真实可信100%真房源<br />链家承诺，假一赔百</dd>
   </dl>
   <dl style="background:url(images/icon2.jpg) left center no-repeat;">
    <dt>权威</dt>
    <dd>独家房源 覆盖全城<br />房源信息最权威覆盖最广</dd>
   </dl>
   <dl style="background:url(images/icon3.jpg) left center no-repeat;">
    <dt>信赖</dt>
    <dd>万名置业顾问 专业服务<br />百万家庭的信赖之选</dd>
   </dl>
   <dl style="background:url(images/icon4.jpg) left center no-repeat;">
    <dt>安全</dt>
    <dd>安心承诺 保驾护航<br />多重风险防范机制 无后顾之忧</dd>
   </dl>
   <div class="clears"></div>
  </div><!--width1190/-->
 </div><!--xinren/-->
 <%@include file="/jsp/foot.jsp" %>
  </body>
</html>
