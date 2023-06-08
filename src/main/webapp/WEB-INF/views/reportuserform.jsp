<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <!DOCTYPE html>
        <html>
          <head>
            <title>Report Form</title>
	          <link  rel="stylesheet"  href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"/>
	          <link href="../static/assets/dist/css/bootstrap.min.css" rel="stylesheet" />
	          <!-- css -->
	          <link href="../static/css/product.css" rel="stylesheet" type="text/css" />
	          <!-- boostarpstyle -->
	          <link href="../static/css/styles.css" rel="stylesheet" />
	          <script  src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
	          <script src="../static/js/jquery-3.4.1.min.js"></script>
	          <!-- footer CSS -->
	          <link rel="stylesheet" type="text/css" href="../static/css/footer.css" />
	          <link rel="preconnect" href="https://fonts.googleapis.com" />
	          <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
	          <link  href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@500&display=swap" rel="stylesheet" />
            <style>
              /* Add custom CSS styles here */
              .container {
                width: 350px;
                margin-top: 50px;
              }
        
              .form-group {
                margin-bottom: 20px;
              }
        
              .report-image {
                max-width: 200px;
                margin-bottom: 20px;
              }
        
              .footer {
                background-color: #f8f9fa;
                padding: 20px;
                text-align: center;
              }
        
              /* Adjust table column size */
              table {
                table-layout: fixed;
              }
        
              th,
              td {
                white-space: nowrap;
                overflow: hidden;
                text-overflow: ellipsis;
              }
            </style>
          </head>
          <body>
            <!-- start Header -->
            <nav class="sb-topnav navbar navbar-expand navbar-dark color">
              <!-- Navbar Brand-->
              <img src="../static/images/petpet.png" width="70px" height="70px" />
              <img src="../static/images/Petword.png" width="40px" height="40px" />
              <a class="navbar-brand ps-3" href="/admin/index">首頁</a>
              <!-- Navbar Search-->
              <form
                class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0"
              >
                <div class="input-group"></div>
              </form>
              <!-- Navbar-->
              <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
                <li class="nav-item dropdown">
                  <a  class="nav-link dropdown-toggle" id="navbarDropdown"  href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    <i class="fas fa-user fa-fw"></i>
                  </a>
                  <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                    <li><a class="dropdown-item" href="login">註冊</a></li>
                    <li><a class="dropdown-item" href="login">登入</a></li>
                    <li><hr class="dropdown-divider" /></li>
                    <li><a class="dropdown-item" href="login!">登出</a></li>
                  </ul>
                </li>
              </ul>
            </nav>
            <!-- end Header -->
            <div class="container">
              <div class="profile">
              <img class="report-image" src="../static/images/alert.png" alt="Report Image" style="display:block; margin:auto"  />
                <div class="form-group">
                  <label for="userId">(檢舉人)會員ID</label>
                  <input type="text" class="form-control" id="userId"  placeholder="Enter user ID"/>
                </div>
                <div class="form-group">
                  <label for="merchantId">被檢舉商家ID</label>
                  <input type="text" class="form-control" id="companyId" placeholder="Enter merchant ID"/>
                </div>
                <div class="form-group">
                  <label for="reportContent">檢舉內容</label>
                  <textarea class="form-control" id="userContent" rows="3" placeholder="Enter report content"></textarea>
                </div>
                 <button class="btn btn-primary" id="btn">提交</button>
            </div>
            </div>
            <footer class="footer">            
                <p>&copy; 2023 Your Company. All rights reserved.</p>
            </footer>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
             <script>
                $('#btn').on('click', function(e){
        			e.preventDefault(); //防止表單提交
        			var userId = $('#userId').val();
        			var companyId = $('#companyId').val();
        			var userContent = $('#userContent').val();
        			var reportUserData = {
        					userId : userId,
        					companyId : companyId,
        					userContent : userContent,
        			};
        			$.ajax({
        				url : 'reportuser/form',
        				type : 'POST',
        				contentType : "application/json",
        				data : JSON.stringify(reportUserData),
        				success: function(data){
        					alert("你的檢舉單已經送出，感謝你寶貴的意見!!");
        					console.log(data);
        					window.location.href = "/reportuser/form"
        				},
        			});
                });
        	</script>
        	<script	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
			<script src="../static/js/scripts.js"></script>
			<script	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
			<script src="../static/assets/demo/chart-area-demo.js"></script>
			<script src="../static/assets/demo/chart-bar-demo.js"></script>
			<script	src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
     </body>
</html>
