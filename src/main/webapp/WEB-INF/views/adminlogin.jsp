<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Document</title>
<script src="../static/js/jquery-3.4.1.min.js"></script>
<link href="../static/css/style2.css" rel="stylesheet" />
<link href="../static/css/styles.css" rel="stylesheet" />
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"	crossorigin="anonymous"></script>
<script	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"	crossorigin="anonymous"></script>

</head>
<body>
	<nav class="sb-topnav navbar navbar-expand navbar-dark color">
		<!-- Navbar Brand-->
		<img src="../static/images/petpet.png" width="70px" height="70px" /> <img
			src="../static/images/Petword.png" width="40px" height="40px" /> <a
			class="navbar-brand ps-3" href="index">首頁</a>
		<form
			class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
			<div class="input-group"></div>
			<!-- 首頁按鈕圖片 -->
		</form>
		<!-- Navbar-->
		<ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
			<li class="nav-item dropdown">
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

	<div class="login-box">
		<div class="lb-header">
			<a href="#" class="active" id="login-box-link">Login</a> <a href="#"
				id="signup-box-link">Sign Up</a>
		</div>
		<form class="email-login" action="#" method="#" id="adminLoginForm">
			<div class="u-form-group">
				<img src="../static/images/petpet.png" style="width: 120px" />
			</div>
			<div class="u-form-group">
				<input type="text" placeholder="account" id="adminLoginAccount" />
			</div>
	
			<div class="u-form-group">
				<input type="password" placeholder="Password" id="adminLoginPassword" />
			</div>
			
      		<span id="captchaText"></span>
  			<div class="u-form-group">
     		 	<input type="text" id="captchaInput" placeholder="驗證碼">
   			</div>
			
			<div class="u-form-group" id="login-btn">
				<button type="submit">Log in</button>
			</div>
			<div class="u-form-group">
				<a href="forgot" class="forgot-password">Forgot password?</a>
			</div>
		</form>

		<!-- 註冊畫面 -->
		<form class="email-signup" id="adminRegisterForm">
			<div class="u-form-group">
				<img src="../static/images/petpet.png" style="width: 120px" />
			</div>
			<div class="u-form-group">
				<input type="text" placeholder="Name" id="adminName" />
			</div>
			<div class="u-form-group">
				<input type="text" placeholder="Email" id="adminAccount"
					name="adminAccount" />
			</div>
			<div class="u-form-group">
				<input type="password" placeholder="Password" id="adminPassword"
					name="adminPassword" />
			</div>
			<div id="errorMsg"></div>
			<div class="u-form-group">
				<button type="submit" id="btn">Sign Up</button>
			</div>
			<div class="u-form-group">
				<a href="forgotpss" class="forgot-password">Forgot password?</a>
			</div>
		</form>
	</div>
	<footer class="footer" style="font-size: 16px; height: 3.5em">
		<div class="container-fluid px-4">
			<div class="row">
				<div class="col-md-6">
					<p>&copy; by | PETPET陪陪你</p>
				</div>
				<div class="col-md-6 text-md-end">
					<ul class="list-inline">
						<li class="list-inline-item"><a href="#">置頂</a></li>
					</ul>
				</div>
			</div>
		</div>
	</footer>
	<script>
		$(".email-signup").hide();
		$("#signup-box-link").click(function() {
			$(".email-login").fadeOut(100);
			$(".email-signup").delay(100).fadeIn(100);
			$("#login-box-link").removeClass("active");
			$("#signup-box-link").addClass("active");
		});
		$("#login-box-link").click(function() {
			$(".email-login").delay(100).fadeIn(100);
			$(".email-signup").fadeOut(100);
			$("#login-box-link").addClass("active");
			$("#signup-box-link").removeClass("active");
		});
	</script>
	<!-- 錯誤提示 -->
	<script>
		$("#btn").on("click", function(e) {
			e.preventDefault(); //防止表單提交
			var acc = document.getElementById("adminAccount");
			var pass = document.getElementById("adminPassword");
			var errorMsg = document.getElementById("errorMsg");
			var acclength = acc.value.length;
			var passlength = pass.value.length;
			console.log("取值和長度完成");
			if (acclength === 0 || passlength === 0) {
				// 				$("#errorMsg").addClass("errortext");
				errorMsg.classList.add("errortext");
				errorMsg.innerText = "帳號密碼不能為空";
			} else if (acclength < 6 || passlength < 6) {
				errorMsg.classList.add("errortext");
				errorMsg.innerText = "帳號密碼不能少於6位數";
			}else{
				$("#errorMsg").removeClass("errortext");
				$('#adminRegisterForm').submit();
			}
		});
	</script>
	<!--   註冊動作  -->

	<script>
		$('#adminRegisterForm').on('submit', function(e) {
			e.preventDefault(); // 阻止表单默认提交行为

			// 获取表单数据
			var adminName = $("#adminName").val();
			var adminAccount = $("#adminAccount").val();
			var adminPassword = $("#adminPassword").val();

			// 创建一个包含管理员数据的对象
			var adminData = {
				adminName : adminName,
				adminAccount : adminAccount,
				adminPassword : adminPassword,
			};

			// 发送Ajax请求
			$.ajax({
				url : "register",
				type : "POST",
				contentType : "application/json",
				data : JSON.stringify(adminData),
				success : function(response) {
					// 处理成功响应
					alert(response);
					if(response == 1){
						console.log("新增成功");
						alert("新增成功")
						window.location.href = "login";
					}else{
						console.log("新增失败，請重新申辦帳號");
						alert("新增失败，請重新申辦帳號");
						window.location.href = "register";
					}
				},
				error : function(error) {
					// 处理错误响应
					console.log("新增失败");
					alert("新增失败")
					// 显示错误消息或执行其他错误处理逻辑
				},
			});
		});
	</script>

	<!--     註冊結束 -->
	<!--   登入動作  -->

	<script>
		$('#adminLoginForm').on('submit', function(e) {
			e.preventDefault(); // 阻止表单默认提交行为

			// 获取表单数据
			var adminAccount = $("#adminLoginAccount").val();
			var adminPassword = $("#adminLoginPassword").val();

			// 创建一个包含管理员数据的对象
			var adminData = {
				adminAccount : adminAccount,
				adminPassword : adminPassword,
			};

			// 发送Ajax请求
			$.ajax({
				url : "login",
				type : "POST",
				contentType : "application/json",
				data : JSON.stringify(adminData),
				success : function(response) {
					// 处理成功响应
					console.log("response" , response);
					if(response.code == 0000){
						alert(response.msg);
						window.location.href = "index";
					}else{
						alert(response.msg);
						window.location.href = "login";
					}
				},
				error : function(error) {			
					console.log("error" , error);
				},
			});
		});
	</script>
	<!--     登入結束 -->
<!-- 	<script src="../static/js/authcode.js"></script> -->
</body>
</html>
