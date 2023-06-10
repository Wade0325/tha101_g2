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
										<th scope="col">審核狀態</th>
										<th scope="col">功能</th>
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

		$.ajax({
			url:"all",
			dataType:"JSON",
			type:"GET",
			success: function(list){
				tbody.empty();
				console.log(list);
				for(var index = 0; index < list.length; index++){
					var select = '<select  class="form-select" disabled="disabled">'
									+'<option value="未停權"selected>未停權</option>'
									+'<option value="停權">停權</option>'
								 '</select>';
					var button = '<button class="btn btn-success">'+'<i class="fa-regular fa-pen-to-square fa-fade"></i>'+'</button>'
					tbody.append('<tr>'
							+'<td>' + list[index].adminId + '</td>'
							+'<td>' + list[index].adminName + '</td>'
							+'<td>' + list[index].adminAccount + '</td>'
							+'<td>' + select  + '</td>'
							+'<td>' + button + '</td>'
					+'</tr>');		
				}
			}
		});
</script>

<!--     ====================編輯修改取值=================== -->
<script>
   	$(document).on('click','tbody button',function(){
   		var userId = $(this).parent().parent().children().eq(0).text();
   		var userName = $(this).parent().parent().children().eq(1).text();
   		var userAcc = $(this).parent().parent().children().eq(2).text();
   		var userPss = $(this).parent().parent().children().eq(3).text();
   		var userStatus = $(this).parent().parent().children().eq(4).text();
// 		console.log("test2" , $(this).parent().parent().children().eq(5).children().val());
//    		console.log(userId);
//    		console.log(userName);
//    		console.log(userAcc);
//    		console.log(userPss);
//    		console.log(userStatus);

   		$('#userId').val(userId);
   		$('#userName').val(userName);
   		$('#userAcc').val(userAcc);
   		$('#userPss').val(userPss);

   		console.log(userStatus);
//    		console.log("test", $(this).parent().parent().children().eq(0).text());
   		//
   		$('#myModal').modal("show")
   	})
</script>


<!-- 	彈窗Modal  -->
<script	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<script src="../static/js/scripts.js"></script>
<div id ="myModal" class="modal" tabindex="-1">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">會員權限</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <div>
        	<label>會員編號</label>
        	<input type="text" id="userId" disabled />
        </div>
        <div>
        	<label>名稱</label>
        	<input type="text" id="userName" disabled />
        </div>
        <div>
        	<label>帳號	</label>
        	<input type="text" id="userAcc" disabled />
        </div>
        <div>
        	<label>審核</label>
        	<select class="form-control" id="userStatus">
				<option value="未停權">未停權</option>
				<option value="停權">停權</option>
			</select>
        </div>
        
      </div>
      <div class="modal-footer">
        <button type="button" data-bs-dismiss="modal">取消</button>
        <button type="button" class="btnReportForm">提交</button>
      </div>
    </div>
  </div>
</div>
</body>
</html>
