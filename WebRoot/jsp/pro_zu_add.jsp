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
	<script type="text/javascript" src="js/distpicker.data.js"></script>
	<script type="text/javascript" src="js/distpicker.js"></script>
	<script type="text/javascript" src="js/js.js"></script>		
	<style type="text/css">
		#localImag {margin:0 0 10px 0;}

		.vip-touxiang p{margin:10px 0;}
	</style>
  </head>
  
  <body>
  	<%@include file="/jsp/header.jsp" %>
	 <div class="content">
	  <div class="width1190">
		  <div class="vip-left">
	       <div class="vipNav">
		     <h3 class="vipright-title">房间图片预览</h3>
		     <div class="vip-touxiang">
		      <div id="localImag"  ><img id="preview"  style="diplay:none"  src="images/tx.jpg" width="230px" /></div>		      	      
		      <div class="clearfix"></div>
		     </div><!--vip-touxiang/-->	   	        
	       </div><!--vipNav/-->
	      </div><!--vip-left/-->	  	  
	     <div class="vip-right">		     
	    <h3 class="vipright-title">上传资料</h3>
	    <form action="${pageContext.request.contextPath }/servlet/FaBuServlet?method=rentFaBuAdd" method="post" enctype="multipart/form-data">			     	   
	     <table class="grinfo">	     	
	        <tbody>
		        <tr>
			        <th>房源区域：</th>
			        <td>
				        <div id="distpicker5" data-toggle="distpicker" >
						  <select id="shen" name="shen"></select>
						  <select id="shi" name="shi"></select>
						  <select id="xian" name="xian"></select>
						</div>
			        </td>
		        </tr>
		        <tr>
			        <th>详细地址：</th>
			        <td>
			        	<input class="inp inw" type="text" id="address" name="address" value="" placeholder="例如：红花教师苑4栋302室" maxlength="14">
			        </td>
		        </tr>
		        <tr>
			        <th>居 &nbsp; &nbsp;室：</th>
			        <td>
				        <input type="radio" value="一室一厅" id="room" name="room">
				        <label for="rbSex1">一室一厅</label>
				        <input type="radio" value="二室一厅" id="room" name="room">
				        <label for="rbSex2">二室一厅</label>
				        <input type="radio" value="三室一厅" id="room" name="room">
				        <label for="rbSex1">三室一厅</label>
				        <input type="radio" value="三室二厅" id="room" name="room">
				        <label for="rbSex2">三室二厅</label>
				        <input type="radio" value="四室二厅" id="room" name="room">
				        <label for="rbSex2">四室二厅</label>
				        <span id="Sex_Tip"></span>
			        </td>
		        </tr>
		        <tr>
			        <th>面 &nbsp; &nbsp;积：</th>
			        <td>
			        	<input class="inp inw" type="number" id="area" name="area" value="" min="1" >平米
			        </td>
		        </tr>
		        
		        
		        <tr>
			        <th>装 &nbsp; &nbsp;修：</th>
			        <td>
						<input type="radio" value="未装修" id="decoration" name="decoration">
				        <label for="rbSex1">未装修</label>
				        <input type="radio" value="简装修" id="decoration" name="decoration">
				        <label for="rbSex2">简装修</label>
				        <input type="radio" value="精装修" id="decoration" name="decoration">
				        <label for="rbSex1">精装修</label>
				        <input type="radio" value="豪华装修" id="decoration" name="decoration">
				        <label for="rbSex1">豪华装修</label>				        
				   	</td>
		        </tr>
		        <tr>
			        <th>价 &nbsp; &nbsp;格：</th>
			        <td>
			        	<input class="inp inw" type="number" id="price" name="price" value="" min="1">元/月
			        </td>
		        </tr>
		        <tr>
			        <th>落成时间：</th>
			        <td>
			        	<input class="inp inw" type="date" id="date" name="date" >
			        </td>
		        </tr>
		        <tr>
			        <th>上传图片：</th>
			        <td>
			        	<input type="file" name="uploadFile" id="doc" onchange="javascript:setImagePreview();">
			    		<p>图片格式：GIF、JPG、JPEG、PNG，最适合尺寸286*188像素 </p>
			        </td>
		        </tr>
			    
			    
		       
		        
		        <tr>
			        <th>付款方式：</th>
			        <td>
						<input type="radio" value="现金" id="depoist" name="depoist">
				        <label for="rbSex1">现金</label>
				        <input type="radio" value="微信" id="depoist" name="depoist">
				        <label for="rbSex2">微信</label>
				        <input type="radio" value="支付宝" id="depoist" name="depoist">
				        <label for="rbSex1">支付宝</label>				        
				   	</td>
		        </tr>			        
		        <tr>
			        <th valign="top">描 &nbsp; &nbsp;述：</th>
			        <td>
			        	<textarea id="sign" name="sign" value="" class="grtextarea"></textarea><br>			        	
			        	<span class="fgrey">(128字符以内)</span>
			        </td>
		        </tr>
		        <tr>
			        <th>&nbsp;</th>
			        <td colspan="2">
				        <label class="butt" id="butt">
				        	<input type="submit" class="member_mod_buttom"  value="发布出租" />
				        </label>
			        </td>
		        </tr>
	        </tbody>
	      </table>
	      </form>
	    </div><!--vip-right/-->
	    <div class="clears"></div>
	    <div id="show"></div>
	  </div><!--width1190/-->
	 </div><!--content/--> 	 
	<script type="text/javascript">
		function setImagePreview() {
			var docObj = document.getElementById("doc");
			var imgObjPreview = document.getElementById("preview");
			
			//var arr=docObj.value.split('\\');//注split可以用字符或字符串分割
		   	//var my=arr[arr.length-1];//这就是要取得的图片名称
		    //alert(my);
		    
			if (docObj.files && docObj.files[0]) {
				//火狐下，直接设img属性
				imgObjPreview.style.display = 'block';
				imgObjPreview.style.width = '230px';
				//imgObjPreview.style.height = '40%';
				//imgObjPreview.src = docObj.files[0].getAsDataURL();
				//火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式
				imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);
			} else {
				//IE下，使用滤镜
				docObj.select();
				var imgSrc = document.selection.createRange().text;
				var localImagId = document.getElementById("localImag");
				//必须设置初始大小
				localImagId.style.width = "40%";
				//localImagId.style.height = "40%";
				//图片异常的捕捉，防止用户修改后缀来伪造图片
				try {
					localImagId.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
					localImagId.filters
							.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
				} catch (e) {
					alert("您上传的图片格式不正确，请重新选择!");
					return false;
				}
				imgObjPreview.style.display = 'none';
				document.selection.empty();
			}
			return true;
		}
		//插件
		$("#distpicker5").distpicker({
			  autoSelect: false
			});
		
		
		function aa(){
			var shen = $("#shen option:selected").val();
			var shi = $("#shi option:selected").val();
			var address = $("#address").val();
			//获取选中单选按钮的value
			var room = $('input:radio[name="room"]:checked').val();
			var area = $("#area").val();
			var decoration = $('input:radio[name="decoration"]:checked').val();
			var price = $("#price").val();
			var date = $("#date").val();
			var depoist=$('input:radio[name="depoist"]:checked').val();
			var sign = $("#sign").val();
			if(shen == null || shi == null || address == null || room == null || area == null || decoration == null || price == null || date == null || depoist == null){
			location.href="${pageContext.request.contextPath }/servlet/FaBuServlet?method=rentFaBuAdd&shen="+
					shen+"&shi="+shi+"&address="+address+"&room="+room+
					"&area="+area+"&decoration="+decoration+"&price="+
					price+"&date="+date+"&depoist="+depoist+"&sign="+sign;
			}
		}


	</script>
		  
	 <%@include file="/jsp/foot.jsp" %>
  </body>
</html>
