<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link href="../static/css/style2.css" rel="stylesheet" />
    <!-- navheader css -->
    <link href="../static/css/styles.css" rel="stylesheet" />
    <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous" ></script>
    <script src="../static/js/jquery-3.4.1.min.js"></script>
  </head>
  <body>
    <nav class="sb-topnav navbar navbar-expand navbar-dark color">
      <!-- Navbar Brand-->
      <img src="../static/images/petpet.png" width="70px" height="70px" />
      <img src="../static/images/Petword.png" width="40px" height="40px" />
      <a class="navbar-brand ps-3" href="#">首頁</a>
      <!-- Sidebar Toggle功能下拉選單-->
      <!-- <button
        class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0"
        id="sidebarToggle"
        href="#!"
      >
        <i class="fas fa-bars"></i>
      </button> 
      Navbar Search -->
      <form
        class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0"
      >
      </form>
      <!-- Navbar-->
      <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button"
            data-bs-toggle="dropdown"
            aria-expanded="false"
            ><i class="fas fa-user fa-fw"></i
          ></a>
          <ul
            class="dropdown-menu dropdown-menu-end"
            aria-labelledby="navbarDropdown"
          >
            <li><a class="dropdown-item" href="login">註冊</a></li>
            <li><a class="dropdown-item" href="login">登入</a></li>
            <li><hr class="dropdown-divider" /></li>
            <li><a class="dropdown-item" href="login">登出</a></li>
          </ul>
        </li>
      </ul>
    </nav>

    <div class="login-box">
      <div class="email-signup">
        <div class="lb-header">
          <h3>忘記密碼</h3>
        </div>
        <div class="forgot-text">
          <p>請輸入您的Email，我們將發送重設密碼連結</p>
        </div>
        <div class="u-form-group">
          <input type="text" id="txtForgot" />
        </div>
        <br />
        <div class="u-form-group">
          <button id="btnForgot">送出</button>
        </div>
      </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
  	<script>
	var btnForgot = $('#btnForgot');
	var txtForgot = $('#txtForgot');
	btnForgot.on('click', function(e){
		var emailData = {
				email: txtForgot.val()
		}
		console.log(emailData)
		alert("email: " + txtForgot.val());
		$.ajax({
			url : "/sendEmail2",
			data : JSON.stringify(emailData),
			type : "post",
			contentType: "application/json",
			success:function(res){
				console.log(res);
				window.location.href = "/admin/login";
			}
		});
	});
  	</script>
  </body>
</html>
