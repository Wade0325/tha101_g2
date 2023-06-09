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
					檢舉單號: <input tpye="text" id="reportfirmsn"> 
					<input type="button" id="btnFirmsn" value="查詢">
					開始日期: <input type="date" id="startDate">結束時間:<input type="date" id="endDate">
					<input type="button" id="btnFirmdate" value="查詢">
					狀態: <select id="reportConfirmCode">
							<option value="審核成功">審核成功</option>
							<option value="審核失敗">審核失敗</option>
							<option value="審核中">審核中</option>
						</select>
					<input type="button" id="btnFirmCode" value="查詢">
					<div class="row">
						<div class="col-xl-12 col-md-6">
							<!-- ===============內容放入此處=============== -->
							<table class="table table-striped table-hover table align-middle">
								<thead>
									<tr>
										<th scope="col">檢舉單號</th>
										<th scope="col">(檢舉人)商家帳號</th>
										<th scope="col">被檢舉會員帳號</th>
										<th scope="col">檢舉內容</th>
										<th scope="col">檢舉時間</th>
										<th scope="col">檢舉狀態</th>
										<th scope="col">功能</th>
									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>
						</div>
					</div>
			</main>
			<footer class="footer">
				<p>&copy; by | PETPET陪陪你</p>
			</footer>
		</div>

<!--   ====================搜尋資料=================== -->
<script>
$('#btnFirmsn').on('click',function(e){
	e.preventDefault(); //防止表單提交
	var tbody = $('tbody');
	var reportfirmsn = document.getElementById('reportfirmsn');
	if(reportfirmsn.value.length === 0) {
		$.ajax({
			url:"reportfirm/all",
			dataType:"JSON",
			type:"GET",
			data:"",
			success: function(list){
				tbody.empty();
				for(var index = 0; index < list.length; index++){
					const id = list[index].firmSn;
					var select = '<select class="form-control" id="confirmCode" disabled>'
									+'<option value="'+  list[index].confirmCode +'">' + list[index].confirmCode + '</option>'
// 									+'<option value="審核失敗">'+ list[index].confirmCode + '</option>'
// 									+'<option value="審核中">'+ list[index].confirmCode + '</option>'
							    +'</select>';
							    
				    var button = '<button class="btn btn-primary" type="submit">修改</button>';
// 				    var button2 = '<button>刪除</button>';
					tbody.append('<tr>'
							+'<td data-id=' + list[index].firmSn + '>' + list[index].firmSn + '</td>'
							+'<td>' + list[index].userId + '</td>'
							+'<td>' + list[index].companyId + '</td>'
							+'<td>' + list[index].firmContent + '</td>'
							+'<td>' + list[index].firmDate + '</td>'
							+'<td>' + select + '</td>'
							+'<td>' + button + '</td>'
// 							+'<td>' + button2 + '</td>'
					+'</tr>');		
				}
			}
		});
	} else{
	$('tbody').empty();
		var reportfirmsn = $('#reportfirmsn').val();
		var reportFirmData ={
			firmSn :reportfirmsn,
		};
		alert("檢舉單號為: " + reportfirmsn);
		console.log(reportFirmData);
		$.ajax({
			url :"reportfirm/getone",
			contentType :"application/json",
			type :"post",
			data :JSON.stringify(reportFirmData),
			success :function(data){
				console.log(data);
				var button = '<button type="submit">修改</button>';
				var select = '<select class="form-control" id="confirmCode">'
								+'<option value="' + data.confirmCode + '" >' + data.confirmCode + '</option>'
// 								+'<option value="1">' + data.confirmCode + '</option>'
// 								+'<option value="2" selected>' + data.confirmCode + '</option>'
			    			 +'</select>';
				tbody.append('<tr>'
					+'<td>'+ data.firmSn +'</td>'
					+'<td>'+ data.userId +'</td>'
					+'<td>'+ data.companyId +'</td>'
					+'<td>'+ data.firmContent +'</td>'
					+'<td>'+ data.firmDate +'</td>'
					+'<td>'+ select +'</td>'
					+'<td>'+ button +'</td>'
					+'</tr>'
				);
			}
		});
	};
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
    
<!-- ====================搜尋日期 ==================== -->
	<script>
	var tbody = $('tbody');
	$('#btnFirmdate').on('click', function(){
		var startDate = $('#startDate').val();
		var endDate = $('#endDate').val();
		var button = '<button class="btn btn-primary" type="submit">修改</button>';
		console.log("val" , startDate);
		console.log("val" , endDate);
		var dateData = {
			startdate : startDate,
			enddate : endDate
		};
		console.log(dateData);
		$.ajax({
			url : "getreportfirmbydate",
			type : "post",
			contentType : "application/json",
			data : JSON.stringify(dateData),
			success : function(res){
				console.log(res);
				tbody.empty();
				for(var i = 0; i < res.length ; i++){
				var select = '<select class="form-control" id="confirmCode" disabled>'
								+'<option value="' + res[i].confirmCode + '">' + res[i].confirmCode + '</option>'
// 								+'<option value="審核失敗">'+ res[i].confirmCode + '</option>'
// 								+'<option value="審核中">'+ res[i].confirmCode + '</option>'
	    					+'</select>';
					tbody.append('<tr>'
							+ '<td>' + res[i].firmSn + '</td>' 
							+ '<td>' + res[i].companyId + '</td>' 
							+ '<td>' + res[i].userId + '</td>' 
							+ '<td>' + res[i].firmContent + '</td>' 
							+ '<td>' + res[i].firmDate + '</td>' 
							+ '<td>' + select + '</td>' 
							+ '<td>' + button+ '</td>' 
							+'</tr>');
				}
			}
		});
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
<!--=============== 舉檢表單審核=============== -->
<script>
$(document).ready(function() {
	  $('.btnReportForm').click(function() {
	    // 獲取表單的值
	    var formData = {
	      firmSn: $('#inptFirmSn').val(),
	      userId: $('#inptUserId').val(),
	      companyId: $('#inptCompanyId').val(),
	      firmContent: $('#inptFirmContent').val(),
	      firmDate: $('#inptFirmDate').val(),
	      confirmCode: $('#inptSelect').val()
	    };
	    console.log(formData.confirmCode);
	    $.ajax({
	      url: 'reportfirm/edit',
	      type: 'POST',
	      contentType: 'application/json',
	      data: JSON.stringify(formData),
	      success: function(data) {
	    	console.log(data);
	    	$('#confirmCode').val("111");
	    	tbody.empty();
	        console.log("編輯成功");
	       		$('#modal').modal('toggle');
				window.location.href = 'reportfirm';
	      },
	      error: function(error) {
	        console.log("編輯失敗");
	      }
	    });
	  });
	});
</script>
<!-- 查詢審核狀態 -->
<script>
var btnFirmCode = $('#btnFirmCode');
var reportConfirmCode = $('#reportConfirmCode').val();
var tbody = $('tbody');

$(document).ready(function() {
	  $('#reportConfirmCode').change(function() {
	    var selectedValue = $(this).val();
	    reportConfirmCode = selectedValue;
	  });
	});
btnFirmCode.on('click', function(){
	console.log(reportConfirmCode);
	codeData = {
			confirmCode : reportConfirmCode
	}
	$.ajax({
		url : "getreportfirmbycode",
		contentType : "application/json",
		type : "POST",
		data : JSON.stringify(codeData),
		success : function(res){
			tbody.empty();
			console.log(res);
			for(var i = 0; i < res.length ; i++){
				var select = '<select class="form-control" id="confirmCode" disabled>'
								+'<option value="' + res[i].confirmCode + '">' + res[i].confirmCode + '</option>'
// 								+'<option value="審核失敗">'+ res[i].confirmCode + '</option>'
// 								+'<option value="審核中">'+ res[i].confirmCode + '</option>'
							+'</select>';
				var button = '<button class="btn btn-primary" type="submit">修改</button>';
				tbody.append(
						'<tr>'
							+ '<td>' + res[i].firmSn + '</td>'
							+ '<td>' + res[i].companyId + '</td>'
							+ '<td>' + res[i].userId + '</td>'
							+ '<td>' + res[i].firmContent + '</td>'
							+ '<td>' + res[i].firmDate + '</td>'
							+ '<td>' + select + '</td>'
							+ '<td>' + button + '</td>'
						+'</tr>'
				);
			}
		}
	});
});
</script>
</body>
</html>
