let bussinessSn = 0;

$(document).ready(function() {
	var table = $('#example').DataTable({
		ajax: function(data, callback) {
			fetch("http://localhost:8080/petpet/businessall")
				.then((response) => response.json())
				.then((data) => {
					console.log(data);
					callback(data);
				});
		},
		columns: [
			{ data: "weekDate" },
			{ data: null, render: function(data, type, row) { return '可預約名額'; } },
			{
				data: "morningAppointMax", render: function(data, type, row) {
					if (data == 0) {
						return '<button class="appointDate full" ' + (data == 0 ? 'disabled' : '') + '>' + '已額滿' + '</button>';
					} else {
						return '<button id="morning" class="appointDate">' + data + '</button>';
					}
				},
				className: "appointDate",
			},
			{ data: null, render: function(data, type, row) { return '可預約名額'; } },
			{
				data: "afternoonAppointMax", render: function(data, type, row) {
					if (data == 0) {
						return '<button class="appointDate full" ' + (data == 0 ? 'disabled' : '') + '>' + '已額滿' + '</button>';
					} else {
						return '<button id="afternoon" class="appointDate">' + data + '</button>';
					}
				},
				className: "appointDate",
			},
			{ data: null, render: function(data, type, row) { return '可預約名額'; } },
			{
				data: "nightAppointMax", render: function(data, type, row) {
					if (data == 0) {
						return '<button class="appointDate full" ' + (data == 0 ? 'disabled' : '') + '>' + '已額滿' + '</button>';
					} else {
						return '<button id="night" class="appointDate">' + data + '</button>';
					}
				},
				className: "appointDate",
			},
		],
		searching: false,
		language: {
			   "processing": "處理中...",
                        "loadingRecords": "載入中...",
                        "lengthMenu": "顯示 _MENU_ 項結果",
                        "zeroRecords": "沒有符合的結果",
                        "info": "顯示第 _START_ 至 _END_ 項結果，共 _TOTAL_ 項",
                        "infoEmpty": "顯示第 0 至 0 項結果，共 0 項",
                        "infoFiltered": "(從 _MAX_ 項結果中過濾)",
                        "search": "找關鍵字:",
                        "paginate": {
                            "first": "第一頁",
                            "previous": "上一頁",
                            "next": "下一頁",
                            "last": "最後一頁"
                        },
                        "aria": {
                            "sortAscending": ": 升冪排列",
                            "sortDescending": ": 降冪排列"
                        },
                        "emptyTable": "目前沒有資料",
                        "datetime": {
                            "previous": "上一頁",
                            "next": "下一頁",
                            "hours": "時",
                            "minutes": "分",
                            "seconds": "秒",
                            "amPm": [
                                "上午",
                                "下午"
                            ]
                        },
                        "searchBuilder": {
                            "add": "新增條件",
                            "condition": "條件",
                            "deleteTitle": "刪除過濾條件",
                            "button": {
                                "_": "複合查詢 (%d)",
                                "0": "複合查詢"
                            },
                            "clearAll": "清空",
                            "conditions": {
                                "array": {
                                    "contains": "含有",
                                    "empty": "為空",
                                    "equals": "等於",
                                    "not": "不為",
                                    "notEmpty": "不為空"
                                },
                                "date": {
                                    "after": "大於",
                                    "before": "小於",
                                    "between": "在其中",
                                    "empty": "為空",
                                    "equals": "等於",
                                    "not": "不為",
                                    "notBetween": "不在其中",
                                    "notEmpty": "不為空"
                                },
                                "number": {
                                    "between": "在其中",
                                    "empty": "為空",
                                    "equals": "等於",
                                    "gt": "大於",
                                    "gte": "大於等於",
                                    "lt": "小於",
                                    "lte": "小於等於",
                                    "not": "不為",
                                    "notBetween": "不在其中",
                                    "notEmpty": "不為空"
                                },
                                "string": {
                                    "contains": "含有",
                                    "empty": "為空",
                                    "endsWith": "字尾為",
                                    "equals": "等於",
                                    "not": "不為",
                                    "notEmpty": "不為空",
                                    "startsWith": "字首為"
                                }
                            },
                            "data": "欄位",
                            "leftTitle": "群組條件",
                            "logicAnd": "且",
                            "logicOr": "或",
                            "rightTitle": "取消群組",
                            "title": {
                                "_": "複合查詢 (%d)",
                                "0": "複合查詢"
                            },
                            "value": "內容"
                        },
                        "editor": {
                            "close": "關閉",
                            "create": {
                                "button": "新增",
                                "title": "建立新項目",
                                "submit": "建立"
                            },
                            "edit": {
                                "button": "編輯",
                                "title": "編輯項目",
                                "submit": "更新"
                            },
                            "remove": {
                                "button": "刪除",
                                "title": "刪除",
                                "submit": "刪除",
                                "confirm": {
                                    "_": "您確定要刪除 %d 筆資料嗎？",
                                    "1": "您確定要刪除 %d 筆資料嗎？"
                                }
                            },
                            "multi": {
                                "restore": "回復修改",
                                "title": "每行有不同的價值",
                                "info": "您選擇了多個項目，每項目都有不同的價值。如果您想所有選擇的項目都用同一個價值，可以在這裏輸入一個價值。要不然它們會保留原本各自的價值",
                                "noMulti": "此列不容許同時編輯多個項目"
                            },
                            "error": {
                                "system": "系統發生錯誤(更多資訊)"
                            }
                        },
                        "autoFill": {
                            "cancel": "取消"
                        },
                        "buttons": {
                            "copySuccess": {
                                "_": "複製了 %d 筆資料",
                                "1": "複製了 1 筆資料"
                            },
                            "copyTitle": "已經複製到剪貼簿",
                            "excel": "Excel",
                            "pdf": "PDF",
                            "print": "列印",
                            "copy": "複製"
                        },
                        "searchPanes": {
                            "collapse": {
                                "_": "搜尋面版 (%d)",
                                "0": "搜尋面版"
                            },
                            "emptyPanes": "沒搜尋面版",
                            "loadMessage": "載入搜尋面版中...",
                            "clearMessage": "清空"
                        },
                        "select": {
                            "rows": {
                                "_": "%d 列已選擇",
                                "1": "%d 列已選擇"
                            }
                        }
		},
	});

	$('#example_length').remove();

	$(document).on("click", "#morning", function() {
		console.log("你很煩哎");
		// 将"早上"填入appointTime输入框
		$("#appointTime").val("上午");
	});

	$(document).on("click", "#afternoon", function() {
		console.log("你很煩哎");
		// 将"早上"填入appointTime输入框
		$("#appointTime").val("下午");
	});

	$(document).on("click", "#night", function() {
		console.log("你很煩哎");
		// 将"早上"填入appointTime输入框
		$("#appointTime").val("晚上");
	});



	$(document).on("click", ".appointDate", function() {
		let row = $(this).closest("tr");
		bussinessSn = table.row(row).data().businessSn;
		console.log("Clicked businessSn:", bussinessSn);

		fetch(`http://localhost:8080/petpet/business/${bussinessSn}`)
			.then((response) => response.json())
			.then((data) => {
				const clinicName = data.clinicName;
				const weekDate = data.weekDate;
//				const morningBusiness = data.morningBusiness;
//				const afternoonBusiness = data.afternoonBusiness;
//				const nightBusiness = data.nightBusiness;

				document.getElementById("clinicName").value = clinicName;
				document.getElementById("weekDate").value = weekDate;
//				document.getElementById("morningBusiness").textContent = morningBusiness;
//				document.getElementById("afternoonBusiness").textContent = afternoonBusiness;
//				document.getElementById("nightBusiness").textContent = nightBusiness;
				//        
				//        const formElement = document.getElementById("res");
				//        formElement.scrollIntoView({ behavior: "smooth" });
			});
		const formElement = document.getElementById("res");
		formElement.scrollIntoView({ behavior: "smooth" });
	});
});

document.addEventListener("DOMContentLoaded", function() {
	var btn = document.getElementById("btn2");
	var serviceItem = document.getElementById("serviceItem");
	var clinicId = document.getElementById("clinicId");
	var clinicName = document.getElementById("clinicName");
	var vetName = document.getElementById("vetName");
	var appointDate = document.getElementById("appointDate");
	var appointTime = document.getElementById("appointTime");
	var ownerName = document.getElementById("ownerName");
	var ownerMobile = document.getElementById("ownerMobile");
	var petName = document.getElementById("petName");
	var petType = document.getElementById("petType");
	var petSituation = document.getElementById("petSituation");
	var msg = document.getElementById("msg");
	var inputs = document.querySelectorAll("input");
	//	點擊預約項目會show出需付款金額
	var serviceItemSelect = document.getElementById("serviceItem");
	var payInfoSelect = document.getElementById("payInfo");
	serviceItemSelect.addEventListener("change", function() {
		var selectedValue = serviceItemSelect.value;

		// 根据所选的预约类别更新预付款项的选项
		if (selectedValue === "一般診療") {
			payInfoSelect.value = "無需付款";
		} else  {
		payInfoSelect.value = "待付款";
		}
	});


	btn.addEventListener("click", function() {
		var selectedValue = serviceItem.value;


		var ownerNameLength = ownerName.value.length;
		if (ownerNameLength === 0) {
			msg.textContent = "請輸入飼主姓名";
			return;
		}

		var ownerMobileLength = ownerMobile.value.length;
		if (ownerMobileLength === 0) {
			msg.textContent = "請輸入連絡電話";
			return;
		}

		var petNameLength = petName.value.length;
		if (petNameLength === 0) {
			msg.textContent = "請輸入寵物名稱";
			return;
		}

		var petTypeLength = petType.value.length;
		if (petTypeLength === 0) {
			msg.textContent = "請輸入寵物類別";
			return;
		}

		var petSituationLength = petSituation.value.length;
		if (petSituationLength === 0) {
			msg.textContent = "請簡述寵物概況";
			return;
		}
		if (selectedValue === "結紮" || selectedValue === "健康檢查" || selectedValue === "洗牙") {
			// 直接跳转到指定页面
			if (confirm("確認預約嗎?")) {
			msg.textContent = "";
			fetch("../../../../clinicAppointmentInsert", {
				method: "POST",
				headers: {
					"Content-Type": "application/json"
				},
				body: JSON.stringify({
					clinicName: clinicName.value,
					vetName: vetName.value,
					appointDate: weekDate.value,
					appointTime: appointTime.value,
					ownerName: ownerName.value,
					ownerMobile: ownerMobile.value,
					serviceItem: serviceItem.value,
					petName: petName.value,
					petType: petType.value,
					petSituation: petSituation.value,
					payInfo: payInfo.value
				})
			})
				.then(function(resp) {
					return resp.json();
				})
				.then(function(body) {
					var successful = body.successful;
					var message = body.message;

					if (successful) {
						for (var i = 0; i < inputs.length; i++) {
							inputs[i].disabled = true;
						}
						btn.disabled = true;
						msg.className = "info";
						msg.textContent = "預約成功";
						alert("預約成功");
						alert("即將前往付款頁面");
						setTimeout(function() {
					      payClick();
					    }, 10000); // 5秒钟后执行payClick函数
											
						
//						
//						payClick();
					} else {
						msg.className = "error";
						msg.textContent = "預約失敗，時段未營業或人數已滿";
					}
				});
		}
	
		}else{
		if (confirm("確認預約嗎?")) {
			msg.textContent = "";
			fetch("../../../../clinicAppointmentInsert", {
				method: "POST",
				headers: {
					"Content-Type": "application/json"
				},
				body: JSON.stringify({
					clinicName: clinicName.value,
					vetName: vetName.value,
					appointDate: weekDate.value,
					appointTime: appointTime.value,
					ownerName: ownerName.value,
					ownerMobile: ownerMobile.value,
					serviceItem: serviceItem.value,
					petName: petName.value,
					petType: petType.value,
					petSituation: petSituation.value,
					payInfo: payInfo.value
				})
			})
				.then(function(resp) {
					return resp.json();
				})
				.then(function(body) {
					var successful = body.successful;
					var message = body.message;

					if (successful) {
						for (var i = 0; i < inputs.length; i++) {
							inputs[i].disabled = true;
						}
						btn.disabled = true;
						msg.className = "info";
						msg.textContent = "預約成功";
						alert("預約成功");
						redirectToSearchResult();
					} else {
						msg.className = "error";
						msg.textContent = "預約失敗，時段未營業或人數已滿";
					}
				});
		}
		}
	});

	// 預約成功後的跳轉
	function redirectToSearchResult() {
		alert("已預約成功");
		window.location.href = "http://localhost:8080/petpet/clinic/clinicAppointment/frontstage/PetPet/VetSearchResult.html";
	}
});

// 預約成功後的跳轉
function redirectToSearchResult() {
	alert("已預約成功");
	window.location.href = "http://localhost:8080/petpet/clinic/clinicAppointment/frontstage/PetPet/VetSearchResult.html";
}

		function payClick() {
			$.ajax({
				url: "../../../../ecpayCheck",
				type: "POST",
				success: function (response) {
					const form = response;
					$("body").append(form); //將接收到資料插入頁面body中
					$("#ecpayForm").submit(); //假設表單的 id 屬性設為ecpayForm。
				}
			})
		}