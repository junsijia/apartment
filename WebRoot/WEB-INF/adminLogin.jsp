<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>后台管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<link rel="shortcut icon" href="images/icon4.jpg" />
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0">
	
	<style>
	body {
		background-color: #f4f4f4;
		margin: 0px;
		overflow: hidden;
	}
	.LoR {
		height:205px;
		width:164px;
		overflow:hidden;
		background:url(images/logo1.png) 0 0 no-repeat;
		position:absolute;
		top:50%;
		left:50%;
		margin:-102px auto auto -82px;
		z-index:2;
	}
	</style>
	
	<script type="text/javascript" src="js/three.min.js"></script>	
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
		
		<div class="LoR"></div>
		
			<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';">
			<p>适用浏览器：IE8、360、FireFox、Chrome、Safari、Opera、傲游、搜狗、世界之窗. </p>
			<p>来源：<a href="http://sc.chinaz.com/" target="_blank">站长素材</a></p>
		</div>
	</body>
</html>