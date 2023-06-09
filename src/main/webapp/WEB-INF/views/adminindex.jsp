<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>PET PET陪陪你後台</title>
<link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
<link href="../static/css/styles.css" rel="stylesheet" />
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"	crossorigin="anonymous"></script>
<link href="../static/css/chat.css" rel="stylesheet" />
</head>
<body class="sb-nav-fixed" onload="connect();" onunload="disconnect();">
	
	<!-- chat modal -->
<div id="chatIcon" class="chat-icon" onclick="toggleChatModal()">
    <span>&#x1F4AC;</span>
  </div>

  <div id="chatModal" class="chat-modal">
    <h2>Chat Room</h2>
    <h3 id="statusOutput" class=""></h3>
    <textarea id="messagesArea" readonly></textarea>
    <input id="userName" type="text" placeholder="User name" />
    <input id="message" type="text" placeholder="Message" onkeydown="if (event.keyCode == 13) sendMessage();" />
    <button id="sendMessage" onclick="sendMessage()">Send</button>
  	<input type="button" id="connect" class="button" value="Connect" onclick="connect();" /> 
		<input type="button" id="disconnect" class="button" value="Disconnect" onclick="disconnect();" />
  </div>
<!-- chat modal -->
	
	<nav class="sb-topnav navbar navbar-expand navbar-dark color">
		<!-- Navbar Brand-->
		<img src="../static/images/petpet.png" width="70px" height="70px" />
		<img src="../static/images/Petword.png" width="40px" height="40px" />
		<a class="navbar-brand ps-3" href="index">首頁</a>
		<!-- Sidebar Toggle-->
		<button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0"	id="sidebarToggle" href="#!">
			<i class="fas fa-bars"></i>
		</button>
		<!-- Navbar Search-->
		<form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
			<div class="input-group"></div>
		</form>
		<!-- Navbar-->
		<ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
			<div class="navbar-brand ps-3" id="adminName">123</div>
			<li class="nav-item dropdown"><a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
				<ul class="dropdown-menu dropdown-menu-end"	aria-labelledby="navbarDropdown">
					<li><a class="dropdown-item" href="login">註冊</a></li>
					<li><a class="dropdown-item" href="login">登入</a></li>
					<li><hr class="dropdown-divider" /></li>
					<li><a class="dropdown-item" href="login">登出</a></li>
				</ul>
			</li>
		</ul>
	</nav>
	<!-- end NAVBAR -->
<!-- 	Side Bar -->
	<div id="layoutSidenav">
		<div id="layoutSidenav_nav">
			<nav class="sb-sidenav accordion sb-sidenav-dark"
				id="sidenavAccordion">
				<div class="sb-sidenav-menu">
					<div class="nav">
						<div class="sb-sidenav-menu-heading">功能導覽</div>
						<a class="nav-link" href="index">
							<div class="sb-nav-link-icon">
								<i class="fas fa-tachometer-alt"></i>
							</div> 首頁
						</a>
						<!-- 商家管理 -->
						<div class="sb-sidenav-menu-heading">商家管理</div>
						<a class="nav-link" href="reportfirm">
							<div class="sb-nav-link-icon">
								<i class="fas fa-tachometer-alt"></i>
							</div> 檢舉清單
						</a> 
						<a class="nav-link" href="reportfirmform">
							<div class="sb-nav-link-icon">
								<i class="fas fa-tachometer-alt"></i>
							</div> 檢舉表單
						</a>
						<!-- 會員管理 -->
						<div class="sb-sidenav-menu-heading">會員管理</div>
						<a class="nav-link" href="reportuser">
							<div class="sb-nav-link-icon">
								<i class="fas fa-tachometer-alt"></i>
							</div> 檢舉清單
						</a> 
						<a class="nav-link" href="reportuserform">
							<div class="sb-nav-link-icon">
								<i class="fas fa-tachometer-alt"></i>
							</div> 檢舉表單
						</a> 
						<a class="nav-link" href="edit">
							<div class="sb-nav-link-icon">
								<i class="fas fa-tachometer-alt"></i>
							</div> 編輯管理員資訊
						</a>
						<a class="nav-link" href="list">
							<div class="sb-nav-link-icon">
								<i class="fas fa-tachometer-alt"></i>
							</div> 會員管理
						</a>
					</div>
				</div>
			</nav>
		</div>
<!-- 		Side Bar    -->
		<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid px-4">
					<h1 class="mt-4">後台首頁</h1>
					<ol class="breadcrumb mb-4"></ol>
					<!-- 內容放置處 -->
					<div><img src="../static/images/qq.png" width="180px" height="180px" style="display:block; margin:auto;" /></div>
					<div>
						<p id ="indexName"></p>
						<p>管理員歡迎回到</p>
						<p>PETPET陪陪後台網站</p>
					</div>
				</div>
			</main>
<!-- 			<footer class="py-4 bg-light mt-auto"> -->
<!-- 				<div class="container-fluid px-4"> -->
<!-- 					<div -->
<!-- 						class="d-flex align-items-center justify-content-between small"> -->
<!-- 						<div class="text-muted">Copyright &copy; Your Website 2023</div> -->
<!-- 						<div> -->
<!-- 							<a href="#">TOP</a> &middot; <a href="#">置頂</a> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</footer> -->
		</div>
	</div>
	<script src="../static/js/jquery-3.4.1.min.js"></script>
	<script>
		var adminName = $('#adminName');
		var indexName = $('#indexName');
		console.log(adminName);
		alert("進入後台首頁取得登入者資訊");
// ========================進入後台首頁取得登入者資訊========================
		$.ajax({
			url : "edit",
			type : "POST",
			contentType : "applicaion/json",
			data : "",
			success : function(adminData) {
// 				alert("執行成功");
				alert(adminData.adminName)
				adminName.text("歡迎 " + adminData.adminName);
				indexName.text(adminData.adminName);
// 				console.log(adminData);
			},
		});
	</script>
	<script type="text/javascript" src="../static/js/chat.js"></script>
	<script	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
	<script src="../static/js/scripts.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
<!--<script src="../static/assets/demo/chart-area-demo.js"></script> -->
<!--<script src="../static/assets/demo/chart-bar-demo.js"></script> -->
	<script	src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
<!--<script src="js/datatables-simple-demo.js"></script> -->
</body>
</html>
