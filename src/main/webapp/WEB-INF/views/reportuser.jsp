<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Report User Table</title>
    
    <link href="../static/css/styles.css" rel="stylesheet" />
	<script src="../static/js/fontawesome.js"></script>
    
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.25/css/jquery.dataTables.css">
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.13.4/css/dataTables.bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="../static/js/fontawesome.js"></script>

  	
</head>
<body class="sb-nav-fixed">
    <nav class="sb-topnav navbar navbar-expand navbar-dark color">
        <!-- Navbar Brand-->
        <img src="../static/images/petpet.png" width="70px" height="70px" />
        <img src="../static/images/Petword.png" width="40px" height="40px" />
        <a class="navbar-brand ps-3" href="index">首頁</a>
        <!-- Navbar Search-->
        <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
            <div class="input-group"></div>
        </form>
        <!-- Navbar-->
	      <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" id="navbarDropdown" href="#"
					role="button" data-bs-toggle="dropdown" aria-expanded="false"><i
						class="fas fa-user fa-fw"></i></a>
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
				<a class="nav-link" href="edit">
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
                    <h1 class="mt-4">Report User</h1>
                    <ol class="breadcrumb mb-4">
                        <li class="breadcrumb-item active">Report User</li>
                    </ol>
                    <div class="card mb-4">
                        <div class="card-header">
                            <i class="fas fa-flag me-1"></i>
                            Report User
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="reportUserTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>檢舉單號</th>
                                            <th>(檢舉人)會員帳號</th>
                                            <th>被檢舉商家帳號</th>
                                            <th>檢舉內容</th>
                                            <th>檢舉時間</th>
                                            <th>檢舉狀態</th>
                                            <th>功能</th>
                                        </tr>
                                    </thead>
                                     <tbody>
                                        <!-- Table data will be loaded dynamically -->
                                        <tr>
                                            <td>1</td>
                                            <th>alan123</td>
                                            <td>aries456</td>
                                            <td>惡意不取貨</td>
                                            <td>2023-06-02T03:57:53.000+00:00</th>
											<td>
	                                          	<select class="form-control" id="confirmCode" disabled>'
													<option value="審核成功" selected>審核成功</option>
		 											<option value="審核失敗">審核失敗</option>
													<option value="審核中"> 審核中</option>
								    			</select>
							    			</td>
                                        </tr>
                                        <tr>
                                            <td>2</td>
                                            <td>Company Id</td>
                                            <td>User Id</td>
                                            <td>User Content</td>
                                            <td>User Date</td>
                                            <td>Confirm Code</td>
                                            <td>Action</td>
                                        </tr>
                                        <tr>
                                            <td>3</th>
                                            <td>Company Id</td>
                                            <td>User Id</td>
                                            <td>User Content</td>
                                            <td>User Date</td>
                                            <td>Confirm Code</td>
                                            <td>Action</td>
                                        </tr>
                                        <tr>
                                            <td>4</td>
                                            <td>Company Id</td>
                                            <td>User Id</td>
                                            <td>User Content</td>
                                            <td>User Date</td>
                                            <td>Confirm Code</td>
                                            <td>Action</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </main>
        </div>
    </div>
<!--   ====================搜尋資料=================== -->
<script>
	var tbody = $('tbody');
	var reportfirmsn = document.getElementById('reportfirmsn');

		$.ajax({
			url:"reportuser/all",
			dataType:"JSON",
			type:"GET",
			success: function(list){
				tbody.empty();
				console.log(list);
				for(var index = 0; index < list.length; index++){
					const id = list[index].firmSn;
					var select = '<select class="form-control" id="confirmCode" disabled>'
									+'<option value="審核成功">審核成功</option>'
									+'<option value="審核失敗">審核失敗</option>'
									+'<option value="審核中">審核中</option>'
							    +'</select>';
							    
				    var button = '<button class="btn btn-primary" type="submit">修改</button>';
					tbody.append('<tr>'
							+'<td data-id=' + list[index].userSn + '>' + list[index].userSn + '</td>'
							+'<td>' + list[index].companyId + '</td>'
							+'<td>' + list[index].userId + '</td>'
							+'<td>' + list[index].userContent + '</td>'
							+'<td>' + list[index].userDate + '</td>'
							+'<td>' + select + '</td>'
							+'<td>' + button + '</td>'
					+'</tr>');		
				}
			}
		});
</script>
<!--     ====================編輯修改取值=================== -->
<script>
   	$(document).on('click','tbody button',function(){
   		var firmSn = $(this).parent().parent().children().eq(0).text();
   		var userId = $(this).parent().parent().children().eq(1).text();
   		var companyId = $(this).parent().parent().children().eq(2).text();
   		var firmContent = $(this).parent().parent().children().eq(3).text();
   		var firmDate = $(this).parent().parent().children().eq(4).text();
   		var select = $(this).parent().parent().children().eq(5).children().val();
		console.log("test2" , $(this).parent().parent().children().eq(5).children().val());
   		console.log(firmSn);
   		console.log(userId);
   		console.log(companyId);
   		console.log(firmContent);
   		console.log(firmDate);
   		console.log(select);
   		$('#inptFirmSn').val(firmSn);
   		$('#inptUserId').val(userId);
   		$('#inptCompanyId').val(companyId);
   		$('#inptFirmContent').val(firmContent);
   		$('#inptFirmDate').val(firmDate);
   		$('#inptSelect').val(select);
   		console.log("test", $(this).parent().parent().children().eq(0).text());
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
        <h5 class="modal-title">舉檢審核</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <div>
        	<label>檢舉流水號</label>
        	<input type="text" id="inptFirmSn" disabled />
        </div>
        <div>
        	<label>(檢舉人)商家ID</label>
        	<input type="text" id="inptUserId" disabled />
        </div>
        <div>
        	<label>被檢舉會員ID	</label>
        	<input type="text" id="inptCompanyId" disabled />
        </div>
        <div>
        	<label>檢舉內容</label>
        	<input type="text" id="inptFirmContent" disabled />
        </div>
        <div>
        	<label>檢舉時間</label>
        	<input type="text" id="inptFirmDate" disabled />
        </div>
        <div>
        	<label>審核</label>
        	<select class="form-control" id="inptSelect">
				<option value="審核成功">審核成功</option>
				<option value="審核失敗">審核失敗</option>
				<option value="審核中">審核中</option>
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

