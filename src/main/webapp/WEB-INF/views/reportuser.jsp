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
				<a class="nav-link" href="../reportfirmform">
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
                                            <th>User Sn</th>
                                            <th>Company Id</th>
                                            <th>User Id</th>
                                            <th>User Content</th>
                                            <th>User Date</th>
                                            <th>Confirm Code</th>
                                            <th>Action</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>User Sn</th>
                                            <th>Company Id</th>
                                            <th>User Id</th>
                                            <th>User Content</th>
                                            <th>User Date</th>
                                            <th>Confirm Code</th>
                                            <th>Action</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <!-- Table data will be loaded dynamically -->
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </main>
        </div>
    </div>
    
    
    <!-- Edit Modal -->

    <div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="editModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="editModalLabel">Edit User</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <!-- Edit form elements -->
                    <div>
                    	<label>檢舉流水號</label>
	                    <input type="text" id="editUserSn" >
	                </div>
	                 <div>
	                 	<label>(檢舉人)會員ID</label>
	                    <input type="text" id="editCompanyId" >
	                 </div>
	                 <div>
	                 	<label>被檢舉商家ID	</label>
	                    <input type="text" id="editUserId" >
	                 </div>
	                 <div>
	                 	<label>檢舉內容</label>
	                    <input type="text" id="editUserContent" >
	                 </div>
	                 <div>
	                 	<label>檢舉時間</label>
	                    <input type="text" id="editUserDate" >
	                 </div>
	                 <div>
	                 	<label>審核</label>
	                    <input type="text" id="editConfirmCode" >
	                 </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" onclick="saveChanges()">Save changes</button>
                </div>
            </div>
        </div>
    </div>
    
    <script>
    
        $(document).ready(function() {
            $.ajax({
                url: "/reportuser/all",
                success: function(data) {
                    $('#reportUserTable').DataTable({
                        data: data,
                        columns: [
                            { data: "userSn" },
                            { data: "companyId" },
                            { data: "userId" },
                            { data: "userContent" },
                            { data: "userDate" },
                            { data: "confirmCode" },
                            {
                                data: null,
                                render: function(data, type, row) {
                                    return '<button class="btn btn-primary btn-sm" onclick="openEditModal(' + row.userSn + ')">Edit</button>';
                                }
                            }
                        ]
                    });
                },
                error: function(xhr, error, thrown) {
                    console.log("AJAX request error:", error);
                }
            });
        });
		
        function openEditModal(button) {
        	 	var userSn = $(this).data('user-sn');
        	    var companyId = $(this).closest('tr');
        	    var userId = $(this).closest('tr').find('td:nth-child(3)').text();
        	    var userContent = $(this).closest('tr').find('td:nth-child(4)').text();
        	    var userDate = $(this).closest('tr').find('td:nth-child(5)').text();
        	    var confirmCode = $(this).closest('tr').find('td:nth-child(6)').text();
        	    // 將值設置到編輯模態框中的表單元素中
        	    $('#editUserSn').val(userSn);
        	    $('#editCompanyId').val(companyId);
        	    $('#editUserId').val(userId);
        	    $('#editUserContent').val(userContent);
        	    $('#editUserDate').val(userDate);
        	    $('#editConfirmCode').val(confirmCode);

        	    // 打開編輯模態框
        	    $('#editModal').modal('show');
        }

        function saveChanges() {
            // 获取模态框中的表单数据并进行保存操作
            var userSn = $('#editUserSn').val();
            // Example: var userName = $('#editUserName').val();

            // 根据需要实现保存逻辑
            console.log("Save changes for user:", userSn);

            // 关闭模态框
            $('#editModal').modal('hide');
        }
    </script>
</body>
</html>

