<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	<link rel="shortcut icon" href="images/icon4.jpg" />
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">	
	<meta name="viewport" content="width=device-width, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0">
	
	<title>后台系统</title>
	<link href="${pageContext.request.contextPath }/style/authority/login_css.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="${pageContext.request.contextPath }/scripts/jquery/jquery-1.7.1.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/three.min.js"></script>	
	<script type="text/javascript">
		$(document).ready(function(){
			$("#login_sub").click(function(){
				if($("#name").val() === ""){
					alert("请输入管理员账号");
				}else if($("#pwd").val() === ""){
					alert("请输入管理员密码");
				}else{
					$("#submitForm").attr("action", "${pageContext.request.contextPath }/servlet/AdminServlet?method=login").submit();
				}
			});
		});
		
		/*回车事件*/
		function EnterPress(e){ //传入 event 
			var e = e || window.event; 
			if(e.keyCode == 13){ 
				$("#submitForm").attr("action", "${pageContext.request.contextPath }/servlet/AdminServlet?method=login").submit();
			} 
		} 
	</script>
</head>
<body>
	<script type="text/javascript">
	
	var container;
	var camera, scene, projector, renderer;
	
	var PI2 = Math.PI * 2;
	
	var programFill = function ( context ) {
	
		context.beginPath();
		context.arc( 0, 0, 1, 0, PI2, true );
		context.closePath();
		context.fill();
	
	};
	
	var programStroke = function ( context ) {
	
		context.lineWidth = 0.05;
		context.beginPath();
		context.arc( 0, 0, 1, 0, PI2, true );
		context.closePath();
		context.stroke();
	
	};
	
	var mouse = { x: 0, y: 0 }, INTERSECTED;
	
	init();
	animate();
	
	function init() {
	
		container = document.createElement( 'div' );
		container.id = 'bgc';
		container.style.position = 'relative';
		container.style.zIndex = '0';
		document.body.appendChild( container );
	
		camera = new THREE.PerspectiveCamera( 70, window.innerWidth / window.innerHeight, 1, 10000 );
		camera.position.set( 0, 300, 500 );
	
		scene = new THREE.Scene();
	
		for ( var i = 0; i < 100; i ++ ) {
	
			var particle = new THREE.Particle( new THREE.ParticleCanvasMaterial( { color: Math.random() * 0x808080 + 0x808080, program: programStroke } ) );
			particle.position.x = Math.random() * 800 - 400;
			particle.position.y = Math.random() * 800 - 400;
			particle.position.z = Math.random() * 800 - 400;
			particle.scale.x = particle.scale.y = Math.random() * 10 + 10;
			scene.add( particle );
	
		}
	
		projector = new THREE.Projector();
	
		renderer = new THREE.CanvasRenderer();
		renderer.setSize( window.innerWidth, window.innerHeight );
	
		container.appendChild( renderer.domElement );
	
	
	
		document.addEventListener( 'mousemove', onDocumentMouseMove, false );
	
		//
	
		window.addEventListener( 'resize', onWindowResize, false );
	
	}
	
	function onWindowResize() {
	
		camera.aspect = window.innerWidth / window.innerHeight;
		camera.updateProjectionMatrix();
	
		renderer.setSize( window.innerWidth, window.innerHeight );
	
	}
	
	function onDocumentMouseMove( event ) {
	
		event.preventDefault();
	
		mouse.x = ( event.clientX / window.innerWidth ) * 2 - 1;
		mouse.y = - ( event.clientY / window.innerHeight ) * 2 + 1;
	
	}
	
	//
	
	function animate() {
	
		requestAnimationFrame( animate );
	
		render();
	
	}
	
	var radius = 600;
	var theta = 0;
	
	function render() {
	
		// rotate camera
	
		theta += 0.2;
	
		camera.position.x = radius * Math.sin( theta * Math.PI / 360 );
		camera.position.y = radius * Math.sin( theta * Math.PI / 360 );
		camera.position.z = radius * Math.cos( theta * Math.PI / 360 );
		camera.lookAt( scene.position );
	
		// find intersections
	
		camera.updateMatrixWorld();
	
		var vector = new THREE.Vector3( mouse.x, mouse.y, 0.5 );
		projector.unprojectVector( vector, camera );
	
		var ray = new THREE.Ray( camera.position, vector.subSelf( camera.position ).normalize() );
	
		var intersects = ray.intersectObjects( scene.children );
	
		if ( intersects.length > 0 ) {
	
			if ( INTERSECTED != intersects[ 0 ].object ) {
	
				if ( INTERSECTED ) INTERSECTED.material.program = programStroke;
	
				INTERSECTED = intersects[ 0 ].object;
				INTERSECTED.material.program = programFill;
	
			}
	
		} else {
	
			if ( INTERSECTED ) INTERSECTED.material.program = programStroke;
	
			INTERSECTED = null;
	
		}
	
		renderer.render( scene, camera );
	
	}
	
	</script>




	<div id="login_center">
		<div id="login_area">
			<div id="login_box">
				<div id="login_form">
					<form id="submitForm" action="" method="post">
						<div id="login_tip">
							<span id="login_err" class="sty_txt2"></span>
						</div>
						<div>
							 用户名：<input type="text" name="name" class="username" id="name">
						</div>
						<div>
							密&nbsp;&nbsp;&nbsp;码：<input type="password" name="pwd" class="pwd" id="pwd" onkeypress="EnterPress(event)" onkeydown="EnterPress()">
						</div>
						<div id="btn_area">
							<input type="button" class="login_btn" id="login_sub"  value="登  录">
							<input type="reset" class="login_btn" id="login_ret" value="重 置">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>