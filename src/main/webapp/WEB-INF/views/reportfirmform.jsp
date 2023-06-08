<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html lang="en">
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
          <head>
            <title>Report Form</title>
            <link
              rel="stylesheet"
              href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
            />
          </style>
          <!-- css -->
          <link href="../../static/css/product.css" rel="stylesheet" type="text/css" />
        
          <!-- boostarpstyle -->
          <link href="../../static/css/styles.css" rel="stylesheet" />
        
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
          <script src="../../static/js/jquery-3.4.1.min.js"></script>
          </head>
          <body>
            <!-- start Header -->
            <nav class="sb-topnav navbar navbar-expand navbar-dark color">
              <!-- Navbar Brand-->
              <img src="../../static/images/petpet.png" width="70px" height="70px" />
              <img src="../../static/images/Petword.png" width="40px" height="40px" />
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
                  <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
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
            <!-- end Header -->
            <div class="container">
              <div class="profile">
              <img class="report-image" src="../static/images/alert.png" alt="Report Image" style="display:block; margin:auto"  />
                <!-- <div class="form-group">
                  <label for="reportId">檢舉流水號</label>
                  <input
                    type="text"
                    class="form-control"
                    id="reportId"
                    placeholder="Enter report ID"
                  />
                </div> -->
                <div class="form-group">
                  <label for="userId">(檢舉人)商家ID</label>
                  <input type="text" class="form-control" id="companyId" placeholder="Enter user ID"/>
                </div>
                <div class="form-group">
                  <label for="companyId">被檢舉會員ID</label>
                  <input type="text" class="form-control" id="userId" placeholder="Enter merchant ID"/>
                </div>
                <div class="form-group">
                  <label for="reportContent">檢舉內容</label>
                  <textarea class="form-control" id="firmContent" rows="3" placeholder="Enter report content"></textarea>
                </div>
                <p>檢舉時間</p>
                <p id="currentContent"></p>
                <!-- <div class="form-group">
                  <label for="reportImage">檢舉圖片</label>
                  <input type="file" class="form-control-file" id="reportImage" />
                </div> -->
                <button id="btn" class="btn btn-primary">提交</button>
            </div>
            </div>
            <footer class="footer">            
                <p>&copy; 2023 Your Company. All rights reserved.</p>
            </footer>
    <!--         取的當前使用者資訊         -->
            <script>
            	var userId = $('#userId')val();
            	console.log(userId);
            	$.ajax({
    				url : '/getUser',
    				type : 'Get',
    				contentType : "application/json",
    				success: function(data){
    					userId.text(data.user_id)
    					alert("取得當前使用者資訊!!");
    					console.log(data);
//     					window.location.href = "/reportfirm/form"
    				},
    			});
            </script>
            <script>
	            var currentContent = $('#currentContent');
	            var currentTime = new Date();
	            currentContent.append(currentTime.getFullYear()+ " 年 " + (currentTime.getMonth()+ 1) + " 月 " + currentTime.getDate() + " 日");
            </script>
            <script>
		        var btn = $('#btn');
	            btn.on('click', function(e){
		            var companyId = $('#companyId').val();
		            var userId = $('#userId').val();
		            var firmContent = $('#firmContent').val();
		            var reportFirmData = {
		            		companyId : companyId,
		            		userId : userId,
		            		firmContent : firmContent
		            };
	            	console.log(companyId, userId, companyContent);
	            	$.ajax({
	    				url : 'reportfirm/form',
	    				type : 'POST',
	    				contentType : "application/json",
	    				data : JSON.stringify(reportFirmData),
	    				success: function(data){
	    					alert("你的檢舉單已經送出，感謝你寶貴的意見!!");
	    					console.log(data);
	//     					window.location.href = "/reportfirm/form"
	    				},
	    			});
	            });
            </script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
          </body>
        </html>
  </body>
</html>
