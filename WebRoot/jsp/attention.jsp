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
           <a href="${pageContext.request.contextPath }/servlet/UserServlet?method=attention" class="vipNavCur">关注房源</a>
           <a href="${pageContext.request.contextPath }/servlet/UserServlet?method=order">我的订单</a>
          </dd>
        </dl>
       </div><!--vipNav/-->
    </div><!--vip-left/-->
    <div class="vip-right">
     <h3 class="vipright-title">关注房源</h3>
     <div class="guanzhulist">
	     <c:if test="${empty attention.attentionItems }">
		 	<h3>关注空空如也,亲,请先去逛逛去吧~~~~~~~~~</h3>
		 </c:if>
		  <c:if test="${not empty attention.attentionItems}">
		   <c:forEach items="${attention.attentionItems }" var="ci">
		       <dl>
		        <dt><a href="${pageContext.request.contextPath }/servlet/InfoServlet?method=getByRentId&id=${ci.rentHouse.rentHouseId}"><img src="${pageContext.request.contextPath}/${ci.rentHouse.rentHousePicture}" width="190" height="124" /></a></dt>
		        <dd>
		         <h3><a href="${pageContext.request.contextPath }/servlet/InfoServlet?method=getByRentId&id=${ci.rentHouse.rentHouseId}">${ci.rentHouse.rentHouseAddress}</a></h3>
		         <div class="guantext">${ci.rentHouse.rentHouseCity} -  ${ci.rentHouse.rentHouseRoom}  </div>
		         <div class="guantext">${ci.rentHouse.rentHouseArea} |  ${ci.rentHouse.rentHouseDecoration} </div>
		         <div class="guantext2"><a href="javascript:;" onclick="removeFrom('${ci.rentHouse.rentHouseId}')"  class="qxgz">取消关注</a></div>
		        </dd>
		        <div class="price">¥ <strong>${ci.rentHouse.rentHousePrice}</strong><span class="font12"></span></div>
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
	<script type="text/javascript">
		function removeFrom(id){
			if(confirm("您忍心抛弃我吗?")){
				location.href="${pageContext.request.contextPath}/servlet/RentAttentionServlet?method=remove&id="+id;
			}
		}
	</script>
  </body>
</html>
