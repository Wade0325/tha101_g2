//    錯誤提示 

		$("#btn").on("click", function(e) {
			e.preventDefault(); //防止表單提交
			var acc = document.getElementById("adminAccount");
			var pass = document.getElementById("adminPassword");
			var errorMsg = document.getElementById("errorMsg");
			var acclength = acc.value.length;
			var passlength = pass.value.length;
			console.log("取值和長度完成");
			if (acclength === 0 || passlength === 0) {
				errorMsg.classList.add("errortext");
				errorMsg.innerText = "帳號密碼不能為空";
			} else if (acclength < 6 || passlength < 6) {
				errorMsg.classList.add("errortext");
				errorMsg.innerText = "帳號密碼不能少於6位數";
			}else{
				$("#errorMsg").removeClass("errortext");
				console.log("清除完畢");
				$('#adminRegisterForm').submit();
			}
		});

//	   註冊動作


		$('#adminRegisterForm').on('submit', function(e) {
			e.preventDefault(); 

			// 取得表單數據
			var adminName = $("#adminName").val();
			var adminAccount = $("#adminAccount").val();
			var adminPassword = $("#adminPassword").val();

			// 創建一個包含管理員數據物件
			var adminData = {
				adminName : adminName,
				adminAccount : adminAccount,
				adminPassword : adminPassword,
			};

			// 發送Ajax请求
			$.ajax({
				url : "register",
				type : "POST",
				contentType : "application/json",
				data : JSON.stringify(adminData),
				success : function(response) {
// 					alert(response);
					if(response == 1){
						console.log("新增成功");
						alert("新增成功")
						window.location.href = "login";
					}else{
						console.log("新增失败，請重新申辦帳號");
						alert("帳號重複，新增失敗");
						window.location.href = "register";
					}
				},
				error : function(error) {
					// 處理錯誤反應
					console.log("新增失败");
					alert("新增失败")
					// 顯示錯誤消息執行其他錯誤
					},
			});
		});


//     註冊結束 
//     登入動作  


		$('#adminLoginForm').on('submit', function(e) {
			e.preventDefault(); // 阻止表单默认提交行为

			// 獲取輸入的值
			var adminAccount = $("#adminLoginAccount").val();
			var adminPassword = $("#adminLoginPassword").val();

			// 創建一个包含管理員數據物件
			var adminData = {
				adminAccount : adminAccount,
				adminPassword : adminPassword,
			};

			// 發送Ajax请求
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

//     登入結束 