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
	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
	
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
 
	 <div class="content">
	  <div class="width1190">
	   <form action="#" method="get" class="pro-search">
	    <table>
	     <tr>
	      <th>房源区域：</th>
	      <td>
	       <a data-nav-sign="on" data-nav-name="city" data-nav-value="0" >不限</a>
	       <c:forEach items="${city }" var="city">
	        <a data-nav-sign="on" data-nav-name="city" data-nav-value="${city.houseCity }"  href="javascript:;">${city.houseCity }</a>	       
	       </c:forEach>
	      </td>
	     </tr>
	     <tr>
	      <th>价格：</th>
	      <td>
	       <a data-nav-sign="on" data-nav-name="price" data-nav-value="0" >不限</a>
	       <a data-nav-sign="on" data-nav-name="price" data-nav-value="40-60" href="javascript:;">40-60</a>
	       <a data-nav-sign="on" data-nav-name="price" data-nav-value="61-80" href="javascript:;">61-80</a>
	       <a data-nav-sign="on" data-nav-name="price" data-nav-value="81-100" href="javascript:;">81-100</a>
	       <a data-nav-sign="on" data-nav-name="price" data-nav-value="101-120" href="javascript:;">101-120</a>
	       <a data-nav-sign="on" data-nav-name="price" data-nav-value="121" href="javascript:;">121以上</a>	       
	      </td>
	     </tr>
	     <tr>
	      <th>面积：</th>
	      <td>
	       <a data-nav-sign="on" data-nav-name="area" data-nav-value="0" >不限</a>
	       <a data-nav-sign="on" data-nav-name="area" data-nav-value="19"  href="javascript:;">10平方</a>
	       <a data-nav-sign="on" data-nav-name="area" data-nav-value="20-40"  href="javascript:;">20-40平方</a>
	       <a data-nav-sign="on" data-nav-name="area" data-nav-value="41-60"  href="javascript:;">41-60平方</a>
	       <a data-nav-sign="on" data-nav-name="area" data-nav-value="61-80"  href="javascript:;">61-80平方</a>
	       <a data-nav-sign="on" data-nav-name="area" data-nav-value="81-100"  href="javascript:;">81-100平方</a>	       
	       <a data-nav-sign="on" data-nav-name="area" data-nav-value="100"  href="javascript:;">100平方以上</a>

	      </td>
	     </tr>
	     <tr>
	      <th>房型：</th>
	      <td>
	       <a data-nav-sign="on" data-nav-name="type" data-nav-value="0" >不限</a>
	       <c:forEach items="${type }"  var="type">
	        <a data-nav-sign="on" data-nav-name="type" data-nav-value="${type.houseRoom }"  href="javascript:;">${type.houseRoom }</a>
		   </c:forEach>
	      </td>
	     </tr>
	    </table>
<!-- 	    <div class="paixu">
	     <strong>排序：</strong>
	     <a href="javascript:;" class="pai-cur">默认</a>
	     <a href="javascript:;">价格 &or;</a>
	     <a href="javascript:;">最新 &or;</a>
	    </div> -->
	   </form><!--pro-search/-->
	  </div><!--width1190/-->
	  <div class="width1190">
	   <div class="pro-left">
	   <c:if test="${ empty pb.data }">
	   	<p>暂无房源</p>
	   </c:if>
	   <c:if test="${not empty pb.data }">
	   	<c:forEach items="${pb.data}" var="p">
	    <dl>
	     <dt><a href="${pageContext.request.contextPath }/servlet/InfoServlet?method=getBySaleId&id=${p.houseId}"><img src="${pageContext.request.contextPath }/${p.housePicture}" width="286" height="188" /></a></dt>
	     <dd>
	      <h3><a href="${pageContext.request.contextPath }/servlet/InfoServlet?method=getBySaleId&id=${p.houseId}">${fn:substring(p.houseAddress,0,10) }...</a></h3>
	      <div class="pro-wei">
	       <strong class="red">${p.houseCity }</strong>
	      </div>
	      <div class="pro-fang">${p.houseRoom } | ${p.houseArea }平 </div>
	      <div class="pra-fa">发布人：${p.userName }  发布时间：${p.publishdate }</div>
	     </dd>
	     <div class="price">¥ <strong>${p.housePrice }</strong><span class="font12">万</span></div>
	     <div class="clears"></div>
	    </dl>
	   </c:forEach>
	   
	   	<!--分页 -->
		<div style="width:380px;margin:0 auto;margin-top:50px;">
			<ul class="pagination" style="text-align:center; margin-top:10px;">
				
				<!-- 判断是否是第一页 -->
				<c:if test="${pb.pageNumber == 1 }">
					<li class="disabled">
						<a href="javascript:void(0)" aria-label="Previous">
							<span aria-hidden="true">&laquo;</span>
						</a>
					</li>
				</c:if>
				
				<!-- 不是第一页 -->
				<c:if test="${pb.pageNumber != 1 }">
					<li>
						<a data-nav-onclick data-nav-name="pageNumber" data-nav-value="${pb.pageNumber-1 }"  href="" aria-label="Previous">
							<span aria-hidden="true">&laquo;</span>
						</a>
					</li>
				</c:if>
				
				<!-- 展示所有页码 -->
				<c:forEach begin="1" end="${pb.totalPage }" var = "n">
					<!-- 判断是否是当前页 -->
					<c:if test="${pb.pageNumber == n }">
						<li class="active"><a href="javascript:void(0)">${n }</a></li>
					</c:if>
					<c:if test="${pb.pageNumber != n }">
						<li><a data-nav-onclick data-nav-name="pageNumber" data-nav-value="${n }"  href="">${n }</a></li>
					</c:if>
				</c:forEach>
				
				<!-- 判断是否是最后一页 -->
				<c:if test="${pb.pageNumber == pb.totalPage }">
					<li  class="disabled">
						<a href="javascript:void(0)" aria-label="Next">
							<span aria-hidden="true">&raquo;</span>
						</a>
					</li>
				</c:if>
				<c:if test="${pb.pageNumber != pb.totalPage }">
					<li>
						<a data-nav-onclick data-nav-name="pageNumber" data-nav-value="${pb.pageNumber+1 }"   href="" aria-label="Next">
							<span aria-hidden="true">&raquo;</span>
						</a>
					</li>
				</c:if>
				
			</ul>
		</div>
		<!-- 分页结束=======================        -->
	   </c:if>
	   
	       
	   </div><!--pro-left/-->
	   
	   <div class="pro-right">
	    <h2 class="right-title">新上房源</h2>
	    <div class="right-pro">
	     <c:forEach items="${house }" var="h">
	      <dl>
	      	<dt><a href="${pageContext.request.contextPath }/servlet/InfoServlet?method=getBySaleId&id=${h.houseId}"><img src="${pageContext.request.contextPath }/${h.housePicture}" width="135" height="88" /></a></dt>
	      	<dd>
	      	 <h3><a href="${pageContext.request.contextPath }/servlet/InfoServlet?method=getBySaleId&id=${h.houseId}">${fn:substring(h.houseAddress,0,10)}...</a></h3>
	      	 <div class="pro-fang">${h.houseRoom } ${h.houseArea }平 ${h.decoration }</div>
	      	 <div class="right-price">${h.housePrice }万</div>
	      	</dd>
	      </dl>
	     </c:forEach>
	    </div><!--right-pro/-->
	   </div><!--pro-right/-->
	   <div class="clears"></div>
	  </div><!--width1190/-->
	 </div><!--content/-->
	 <%@include file="/jsp/foot.jsp" %>
	 	<script>
		function getParams() {
			/*
			处理？后面的地址，以二维数组的方式存储key，value
			*/
			return location.search.split('?')[1].split('&').map(function(i) { return [i.split('=')[0], i.split('=')[1]]; });
		}
		function makeUrl(name, value) {
			var params = getParams();
			/*查找name将结果，返回target*/
			var target = params.find(function (i) { return i[0] === name; });
			if (target) {
				/*给name添加value*/
				target[1] = value;
			} else {
				/*不存在则添加*/
				params.push([name, value]);
			}
			/*将地址进行拼接，拆顺序的倒拼接*/
			var query = params.map(function (i) { return i.join('='); }).join('&');
			return location.href.split('?')[0] + '?' + query;
		}
		window.onload = function () {
			/*返回文档中匹配data-nav-name选择器的所有元素。*/
			var navs = document.querySelectorAll("a[data-nav-name]");
			var params = getParams();			
			navs.forEach(function (item) {
				/*encodeURI，为了解决汉字问题*/
				var name = encodeURI(item.getAttribute('data-nav-name'));
				var value = encodeURI(item.getAttribute('data-nav-value'));
				
				item.href = makeUrl(name, value);
				/*给选中的字段添加css样式*/
				var sign = item.getAttribute('data-nav-sign');
				if (sign=='on' && params.find(function (i) { return i[0]==name && i[1]==value; })) {
					item.setAttribute('data-nav-sign', 'selected');
				}
			});
			var onclick = document.querySelectorAll("a[data-nav-onclick]");
			onclick.forEach(function (item) {
				/*encodeURI，为了解决汉字问题*/
 				var name = encodeURI(item.getAttribute('data-nav-name'));
				var value = encodeURI(item.getAttribute('data-nav-value')); 
				item.href = makeUrl(name, value);				
			});
		};
	</script>
  </body>
</html>
