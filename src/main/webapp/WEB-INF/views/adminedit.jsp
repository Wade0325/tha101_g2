<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!DOCTYPE html>
        <html>
          <head>
            <title>Report Form</title>
            <link
              rel="stylesheet"
              href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
            />
          </style>
          <link href="../static/assets/dist/css/bootstrap.min.css" rel="stylesheet" />
          <!-- css -->
          <link href="../static/css/product.css" rel="stylesheet" type="text/css" />
        
          <!-- boostarpstyle -->
          <link href="../static/css/styles.css" rel="stylesheet" />
        
          <script
            src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
            crossorigin="anonymous"
          ></script>
          <!-- footer CSS -->
          <link rel="stylesheet" type="text/css" href="../static/css/footer.css" />
        
          <link rel="preconnect" href="https://fonts.googleapis.com" />
          <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
          <link
            href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@500&display=swap"
            rel="stylesheet"
          />
            <style></style>
          </head>
          <body>
            <!-- start Header -->
            <nav class="sb-topnav navbar navbar-expand navbar-dark color">
              <!-- Navbar Brand-->
              <img src="../static/images/petpet.png" width="70px" height="70px" />
              <img src="../static/images/Petword.png" width="40px" height="40px" />
              <a class="navbar-brand ps-3" href="index">首頁</a>
              <!-- Navbar Search-->
              <form
                class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0"
              >
                <div class="input-group"></div>
              </form>
              <!-- Navbar-->
              <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
                <li class="nav-item dropdown">
                  <a
                    class="nav-link dropdown-toggle"
                    id="navbarDropdown"
                    href="#"
                    role="button"
                    data-bs-toggle="dropdown"
                    aria-expanded="false"
                  >
                    <i class="fas fa-user fa-fw"></i>
                  </a>
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
            <!-- end navbar -->
            
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
				<a class="nav-link" href="reportfirmform">
				  <div class="sb-nav-link-icon">
					<i class="fas fa-tachometer-alt"></i>
				  </div>
				  檢舉表單
				</a>
				<!-- 會員管理 -->
				<div class="sb-sidenav-menu-heading">會員管理</div>
				<a class="nav-link" href="reportuser">
				  <div class="sb-nav-link-icon">
					<i class="fas fa-tachometer-alt"></i>
				  </div>
				  檢舉清單
				</a>
				<a class="nav-link" href="reportuserform">
				  <div class="sb-nav-link-icon">
					<i class="fas fa-tachometer-alt"></i>
				  </div>
				  檢舉表單
				</a>
				<a class="nav-link" href="editadmin">
				  <div class="sb-nav-link-icon">
					<i class="fas fa-tachometer-alt"></i>
				  </div>
				  編輯管理員資訊
				</a>
			  </div>
			</div>
		  </nav>
		</div>
		
		<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid px-4">
					<h1 class="mt-4">管理員資訊</h1>
					<div class="row">
						<div class="col-xl-12 col-md-6">
            <div class="container">
              <div class="profile">
              	<img class="report-image" src="../static/images/manager.png" alt="Report Image" style="display:block; margin:auto"  />

               		<div class="form-group">
                  		<label for="reportId">管理員編號</label>
                  		<input type="text" class="form-control" id="adminId" placeholder="admin name" disabled/>
                	</div>
                	<div class="form-group">
                  		<label for="reportId">管理員名稱</label>
                  		<input type="text" class="form-control" id="adminName" placeholder="admin name"/>
                	</div>
                	<div class="form-group">
                  		<label for="userId">帳號</label>
                  	<input type="text" class="form-control" id="adminAccount" placeholder="admin account" disabled/>
                	</div>
                	<div class="form-group">
                  		<label for="merchantId">密碼</label>
                  		<input type="text"class="form-control" id="adminPassword" placeholder="admin password"/>
                	</div>
                	<button class="btn btn-primary" id="btnEdit">確認</button>

            	</div>
            </div>
     	</div>
	</div>
</main>
            <footer class="py-4 bg-light mt-auto">
        		<div class="container-fluid px-4">
          			<div class="d-flex align-items-center justify-content-between small">
            			<div class="text-muted">Copyright &copy;by | PETPET陪陪你 2023</div>
            				<div>
             	 			<a href="#">TOP</a>&middot;
              	 			<a href="#">置頂</a>
            			</div>
          			</div>
        		</div>
      </footer>
            <script src="../static/js/jquery-3.4.1.min.js"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
          </body>
        </html>
        
        <script>
       
        </script>
        
        
        <script>
        	var adminId = $('#adminId');
        	var adminName = $('#adminName');
        	var adminAccount = $('#adminAccount');
        	var adminPassword = $('#adminPassword');
        	var btnEdit = $('#btnEdit');
        	adminId.val("test");
        	adminName.val("test");
        	adminAccount.val("test");
        	adminPassword.val("test");
        		$.ajax({
        			url : "/admin/edit",
        			type : "post",
        			contentType : "application/json",
        			success : function(adminData){
        				console.log(adminData);
        				alert("成功抓取資料");
        				adminId.val(adminData.adminId);
        				adminAccount.val(adminData.adminAccount);
        				adminName.val(adminData.adminName);
        				adminPassword.val(adminData.adminPassword);
        				btnEdit.on('click', function(e){
                 			e.preventDefault(); //防止表單提交
                 			alert("準備提交資料");
                 			updatedAdminData ={
                 					adminId :adminId.val(),
                 				    adminName :adminName.val(),
                 				    adminPassword :adminPassword.val()
                 			};
        					console.log(updatedAdminData);
                 			$.ajax({
                 				url :"/admin/update",
                 				type :"POST",
                 				contentType :"application/json",
                 				data :JSON.stringify(updatedAdminData),
                 				success :function(Data){
                 				alert("編輯成功");
                 				console.log(Data);
                 				adminName.text(Data.adminName);
                 				adminPassword.text(Data.adminPassword);
                 				},
                 			});
                 		});
        			},
        		});
//         	function submitData() {
//              	var adminId = $('#adminId');
//          		var UpdatedAdminName = $('#adminName');
//          	var adminAccount = $('#adminAccount');
//          		var UpdatedAdminPassword = $('#adminPassword');
//              	var btnEdit = $('#btnEdit');
//              	var	updatedAdminData = {
//              			adminId : parseInt(adminID),
//              			adminName : UpdatedAdminName.val(),
//              			adminPassword : UpdatedAdminPassword.val(),
//              			};
             	        
//             		btnEdit.on('click', function(e){
//              		console.log(updatedAdminData);
//              		e.preventDefault(); //防止表單提交
//              		alert("準備提交資料");
//              		$.ajax({
//              			url :"/admin/update",
//              			type :"POST",
//              			contentType :"application/json",
//              			data :JSON.stringify(adminData),
//              			success :function(Data){
//              				alert("編輯成功");
//              				console.log(Data);
//              			},
//              		});
//              	});
//              }
        </script>
       
  </body>
</html>
