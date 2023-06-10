<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>PET PET陪陪你後台</title>
<link href="../static/css/styles.css" rel="stylesheet" />
<script src="../static/js/fontawesome.js"></script>
<script src="../static/js/jquery-3.4.1.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body class="sb-nav-fixed">
	<!-- 	<script src="js/header.js"></script> -->
	
	<!-- start Header -->
	<nav class="sb-topnav navbar navbar-expand navbar-dark color">
		<!-- Navbar Brand-->
		<img src="../static/images/petpet.png" width="70px" height="70px" />
		<img src="../static/images/Petword.png" width="40px" height="40px" />
		<a class="navbar-brand ps-3" href="index">首頁</a>
		<!-- Navbar Search-->
		<form
			class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
			<div class="input-group"></div>
		</form>
		<!-- Navbar-->
		<ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
			<li class="nav-item dropdown"><a class="nav-link dropdown-toggle" id="navbarDropdown" href="#"	role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
				<ul class="dropdown-menu dropdown-menu-end"
					aria-labelledby="navbarDropdown">
					<li><a class="dropdown-item" href="login">註冊</a></li>
					<li><a class="dropdown-item" href="login">登入</a></li>
					<li><hr class="dropdown-divider" /></li>
					<li><a class="dropdown-item" href="login">登出</a></li>
				</ul>
			</li>
		</ul>
	</nav>
	<!-- end Header -->

	  
      <div id="layoutSidenav">
		<div id="layoutSidenav_nav">
		  <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
			<div class="sb-sidenav-menu">
			  <div class="nav">
				<div class="sb-sidenav-menu-heading">功能導覽</div>
				<a class="nav-link" href="index">
				  <div class="sb-nav-link-icon">
					<i class="fas fa-tachometer-alt"></i>
				  </div>
				  首頁
				</a>
				<!-- 商家管理 -->
				<div class="sb-sidenav-menu-heading">商家管理</div>
				<a class="nav-link" href="reportfirm">
				  <div class="sb-nav-link-icon">
					<i class="fas fa-tachometer-alt"></i>
				  </div>
				  檢舉清單
				</a>
				<a class="nav-link" href="../reportfirmform">
				  <div class="sb-nav-link-icon">
					<i class="fas fa-tachometer-alt"></i>
				  </div>
				  檢舉表單
				</a>
				<a class="nav-link" href="#">
				  <div class="sb-nav-link-icon">
					<i class="fas fa-tachometer-alt"></i>
				  </div> 訂單管理
				</a> 
				<!-- 會員管理 -->
				<div class="sb-sidenav-menu-heading">會員管理</div>
				<a class="nav-link" href="reportuser">
				  <div class="sb-nav-link-icon">
					<i class="fas fa-tachometer-alt"></i>
				  </div>
				  檢舉清單
				</a>
				<a class="nav-link" href="../reportuserform">
				  <div class="sb-nav-link-icon">
					<i class="fas fa-tachometer-alt"></i>
				  </div>
				  檢舉表單
				</a>
				<a class="nav-link" href="edit">
				  <div class="sb-nav-link-icon">
					<i class="fas fa-tachometer-alt"></i>
				  </div>
				  編輯管理員資訊
				</a>
				<a class="nav-link" href="#">
					<div class="sb-nav-link-icon">
						<i class="fas fa-tachometer-alt"></i>
					</div> 會員管理
				</a>
			  </div>
			</div>
		  </nav>
		</div>
		<div id="layoutSidenav_content">
			
			<main>
				
				<div class="container-fluid px-4">
					<h1 class="mt-4">後台首頁</h1>
					<div class="row">
						<div class="col-xl-12 col-md-6">
							<!-- ===============內容放入此處=============== -->
							<table class="table table-striped table-hover table align-middle">
								<thead>
									<tr>
										<th scope="col">會員編號</th>
										<th scope="col">名稱</th>
										<th scope="col">帳號</th>
										<th scope="col">密碼</th>
									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>
						</div>
					</div>
			</main>
<!-- 			<footer class="footer"> -->
<!-- 				<p>&copy; by | PETPET陪陪你</p> -->
<!-- 			</footer> -->
		</div>
<!--   ====================搜尋資料=================== -->
<script>
	var tbody = $('tbody');
	var reportfirmsn = document.getElementById('reportfirmsn');

		$.ajax({
			url:"all",
			dataType:"JSON",
			type:"GET",
			success: function(list){
				tbody.empty();
				console.log(list);
				for(var index = 0; index < list.length; index++){
					var select = '<select  class="form-select" >'
									+'<option value="未停權">未停權</option>'
									+'<option value="停權">停權</option>'
								 '</select>';		    
// 				    var button = '<button class="btn btn-primary" type="submit">修改</button>';
					tbody.append('<tr>'
							+'<td>' + list[index].adminId + '</td>'
							+'<td>' + list[index].adminName + '</td>'
							+'<td>' + list[index].adminAccount + '</td>'
							+'<td>*******</td>'
							+'<td>' + select  + '</td>'
// 							+'<td>' + button + '</td>'
					+'</tr>');		
				}
			}
		});
</script>

</body>
</html>
