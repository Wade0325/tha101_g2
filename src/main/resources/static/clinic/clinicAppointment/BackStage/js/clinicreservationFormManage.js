document.addEventListener("DOMContentLoaded", function() {
	var table = $("#example").DataTable({

		ajax: function(d, cb) {
			fetch("../../../Appointment/all")
				.then((response) => response.json())
				.then((data) => {
					console.log(data);
					cb(data);
				});
		        },
		columns: [
			{ data: "reservationNumber" }, //對應資料庫的欄位名稱
			{ data: "clinicName" },
			{ data: "vetName" },
			{ data: "appointDate" },
			{ data: "appointTime" },
			{ data: "ownerName" },
			{ data: "ownerMobile" },
			{ data: "petType" },
			{ data: "petName" },
			{ data: "serviceItem" },
			{ data: "petSituation" },
			{ data: "payInfo" },
			{
          data: null,
          className: "dt-center editor-delete",
          defaultContent: '<i class="fa fa-trash"/>',
          orderable: false,
        },
	
		        ],
                "language": {
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
		//刪除功能-----------------------------------------------------------

		"drawCallback": function() {
			$(".editor-delete").on("click", function() {
				console.log("刪除鍵")
				let row = $(this).closest("tr");
				var reservationNumber = table.row(row).data().reservationNumber;
				console.log("Clicked reservationNumber:", reservationNumber);
				// 在这里可以执行你想要的操作，使用vetSn的值

				if (confirm('確定要刪除嗎？')) {
					// 發送刪除請求到後端 API
					fetch('../../../clinicAppointment/' + reservationNumber, {
						method: 'DELETE'
					})
						.then(function(response) {
							if (response.ok) {
								// 刪除成功，從前端移除該行
								row.remove();
								table.ajax.reload()/* 将触发重新加载数据并更新表格。 */
								console.log('刪除成功');
							} else {
								// 處理刪除失敗的情況
								console.log('刪除失敗');
							}
						})
						.catch(function(error) {
							// 處理錯誤情況
							console.log('錯誤：', error);
						});
				}
			});
			
			}//"drawCallback
		
        });
    })
			
			//  <!-- datetable --> 
//			$(document).ready(function() {
//				$('#example').DataTable({
//					"autoWidth": true,
//
//					// 中文化
//					"language": {
//						"processing": "處理中...",
//						"loadingRecords": "載入中...",
//						"lengthMenu": "顯示 _MENU_ 項結果",
//						"zeroRecords": "沒有符合的結果",
//						"info": "顯示第 _START_ 至 _END_ 項結果，共 _TOTAL_ 項",
//						"infoEmpty": "顯示第 0 至 0 項結果，共 0 項",
//						"infoFiltered": "(從 _MAX_ 項結果中過濾)",
//						"search": "找關鍵字:",
//						"paginate": {
//							"first": "第一頁",
//							"previous": "上一頁",
//							"next": "下一頁",
//							"last": "最後一頁"
//						},
//						"aria": {
//							"sortAscending": ": 升冪排列",
//							"sortDescending": ": 降冪排列"
//						},
//						"emptyTable": "目前沒有資料",
//						"datetime": {
//							"previous": "上一頁",
//							"next": "下一頁",
//							"hours": "時",
//							"minutes": "分",
//							"seconds": "秒",
//							"amPm": [
//								"上午",
//								"下午"
//							]
//						},
//						"searchBuilder": {
//							"add": "新增條件",
//							"condition": "條件",
//							"deleteTitle": "刪除過濾條件",
//							"button": {
//								"_": "複合查詢 (%d)",
//								"0": "複合查詢"
//							},
//							"clearAll": "清空",
//							"conditions": {
//								"array": {
//									"contains": "含有",
//									"empty": "為空",
//									"equals": "等於",
//									"not": "不為",
//									"notEmpty": "不為空"
//								},
//								"date": {
//									"after": "大於",
//									"before": "小於",
//									"between": "在其中",
//									"empty": "為空",
//									"equals": "等於",
//									"not": "不為",
//									"notBetween": "不在其中",
//									"notEmpty": "不為空"
//								},
//								"number": {
//									"between": "在其中",
//									"empty": "為空",
//									"equals": "等於",
//									"gt": "大於",
//									"gte": "大於等於",
//									"lt": "小於",
//									"lte": "小於等於",
//									"not": "不為",
//									"notBetween": "不在其中",
//									"notEmpty": "不為空"
//								},
//								"string": {
//									"contains": "含有",
//									"empty": "為空",
//									"endsWith": "字尾為",
//									"equals": "等於",
//									"not": "不為",
//									"notEmpty": "不為空",
//									"startsWith": "字首為"
//								}
//							},
//							"data": "欄位",
//							"leftTitle": "群組條件",
//							"logicAnd": "且",
//							"logicOr": "或",
//							"rightTitle": "取消群組",
//							"title": {
//								"_": "複合查詢 (%d)",
//								"0": "複合查詢"
//							},
//							"value": "內容"
//						},
//						"editor": {
//							"close": "關閉",
//							"create": {
//								"button": "新增",
//								"title": "建立新項目",
//								"submit": "建立"
//							},
//							"edit": {
//								"button": "編輯",
//								"title": "編輯項目",
//								"submit": "更新"
//							},
//							"remove": {
//								"button": "刪除",
//								"title": "刪除",
//								"submit": "刪除",
//								"confirm": {
//									"_": "您確定要刪除 %d 筆資料嗎？",
//									"1": "您確定要刪除 %d 筆資料嗎？"
//								}
//							},
//							"multi": {
//								"restore": "回復修改",
//								"title": "每行有不同的價值",
//								"info": "您選擇了多個項目，每項目都有不同的價值。如果您想所有選擇的項目都用同一個價值，可以在這裏輸入一個價值。要不然它們會保留原本各自的價值",
//								"noMulti": "此列不容許同時編輯多個項目"
//							},
//							"error": {
//								"system": "系統發生錯誤(更多資訊)"
//							}
//						},
//						"autoFill": {
//							"cancel": "取消"
//						},
//						"buttons": {
//							"copySuccess": {
//								"_": "複製了 %d 筆資料",
//								"1": "複製了 1 筆資料"
//							},
//							"copyTitle": "已經複製到剪貼簿",
//							"excel": "Excel",
//							"pdf": "PDF",
//							"print": "列印",
//							"copy": "複製"
//						},
//						"searchPanes": {
//							"collapse": {
//								"_": "搜尋面版 (%d)",
//								"0": "搜尋面版"
//							},
//							"emptyPanes": "沒搜尋面版",
//							"loadMessage": "載入搜尋面版中...",
//							"clearMessage": "清空"
//						},
//						"select": {
//							"rows": {
//								"_": "%d 列已選擇",
//								"1": "%d 列已選擇"
//							}
//						}
//					}
//
//				});
//
//			});
//
//
//


			//---------------------
//			const tbody = document.querySelector('#tbody');
//			fetch('../../../../clinicAppointment/all',
//				{
//					method: 'POST',
//					headers: {
//						'Content-Type': 'application/json'
//					},
//					body: {
//
//					}
//				})
//				.then(resp => resp.json())
//				.then(ClinicAppointment => {
//					for (let appointment of ClinicAppointment) {
//						console.log(appointment);
//
//						tbody.innerHTML += `
//				<tr>
//					<td>${appointment.reservationNumber}</td>
//					<td id="clinicName${appointment.reservationNumber}">${appointment.clinicName}</td>
//					<td id="vetName${appointment.reservationNumber}">${appointment.vetName}</td>
//					<td>${appointment.appointDate}</td>
//					<td id="appointTime${appointment.reservationNumber}">${appointment.appointTime}</td>
//					<td id="ownerMobile${appointment.reservationNumber}">${appointment.ownerMobile}</td>
//					<td id="petType${appointment.reservationNumber}">${appointment.petType}</td>
//					<td id="petName${appointment.reservationNumber}">${appointment.petName}</td>
//					<td id="serviceItem${appointment.reservationNumber}">${appointment.serviceItem}</td>
//					<td id="ownerName${appointment.reservationNumber}">${appointment.ownerName}</td>
//					<td id="petSituation${appointment.reservationNumber}">${appointment.petSituation}</td>
//					
//					<td>
//<!--						<button type="button" class="btn-edit" onclick="saveClick(${appointment.reservationNumber})">儲存</button> -->
//						<button type="button" class="btn-delete" onclick="deleteClick(${appointment.reservationNumber})">刪除</button>
//					</td>
//				</tr>`
//					}
//				})
//
//
//			//------------------
//
//			function deleteClick(reservationNumber) {
//				if (!confirm('是否刪除?')) {
//					return;
//					//		console.log(${ reservationNumber });
//				}
//				fetch(`../../../../clinicAppointment/${reservationNumber}`, {
//					method: `DELETE`,
//				})
//				window.location.reload();
//			}
