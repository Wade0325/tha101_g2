document.addEventListener("DOMContentLoaded", function () {
  var table = $("#price_list").DataTable({
    ajax: function (d, cb) {
      fetch("../../PriceList/init")
        .then((response) => response.json())
        .then((data) => {
          console.log(data);
          cb(data);
        });
    },
    columns: [
      { data: "clinicServiceId" }, //對應資料庫的欄位名稱
      { data: "clinicServiceName" },
      { data: "servicePrice" },
      { data: "serviceDiscountPrice" },
      { data: "serviceItem1" },
      { data: "serviceItem2" },
      { data: "serviceItem3" },
      { data: "serviceItem4" },
      {
        data: "serviceImg",
        render: function (data, type, row) {
          if (type === "display") {
            var imgElement =
              '<img id="serviceImg" src="data:image/jpge;base64,' +
              data +
              '"/>';
            return imgElement;
          }
          return data;
        },
      },
      {
        data: null,
        className: "dt-center editor-edit ",
        defaultContent: '<i class="fa fa-pencil"/>',
        
        orderable: false,
      },
      {
        data: null,
        className: "dt-center editor-delete",
        defaultContent: '<i class="fa fa-trash"/>',
        orderable: false,
      },
    ],

    //刪除功能-----------------------------------------------------------
    
    "drawCallback": function () {
      $(".editor-delete").on("click", function () {
        let row = $(this).closest("tr");
        
        var clinicServiceId = table.row(row).data().clinicServiceId;
        console.log("Clicked clinicServiceId:", clinicServiceId);
        // 在这里可以执行你想要的操作，使用clinicServiceId的值
        
          if (confirm('確定要刪除嗎？')) {
      // 發送刪除請求到後端 API
      fetch('../../PriceList/delete/' + clinicServiceId, {
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

/*  ----------------------------------------------- */
 
 
      $(".editor-edit").on("click", function () {
        console.log('有嗎');
        var row = $(this).closest("tr");
      var data = table.row(row).data();
      var clinicServiceId = data.clinicServiceId;
      var clinicServiceName = data.clinicServiceName;
      var servicePrice = data.servicePrice;
      var serviceDiscountPrice = data.serviceDiscountPrice;
  var serviceItem1 = data.serviceItem1;
  var serviceItem2 = data.serviceItem2;
  var serviceItem3 = data.serviceItem3;
  var serviceItem4 = data.serviceItem4;
  

 
 
 
 
 
 
      // 更新模态框中的表单字段值
      $("#clinicServiceId").val(clinicServiceId);
      $("#clinicServiceName").val(clinicServiceName);
      $("#servicePrice").val(servicePrice);
      $("#serviceDiscountPrice").val(serviceDiscountPrice);
      $("#serviceItem1").val(serviceItem1);    
      $("#serviceItem2").val(serviceItem2);
    $("#serviceItem3").val(serviceItem3);
  $("#serviceItem4").val(serviceItem4);

 
  

      // 显示模态框
      $("#updateModal").modal("show");
    });
    
     // 点击更新按钮的事件处理程序
$("#updateBtn").on("click", function () {
  var clinicServiceId = $("#clinicServiceId").val();
  var clinicServiceName = $("#clinicServiceName").val();
  var servicePrice = $("#servicePrice").val();
  var serviceDiscountPrice = $("#serviceDiscountPrice").val();
  var serviceItem1 = $("#serviceItem1").val();
  var serviceItem2 = $("#serviceItem2").val();
  var serviceItem3 = $("#serviceItem3").val();
  var serviceItem4 = $("#serviceItem4").val();
  
  
  
  // 在这里可以执行更新操作或发送更新请求到后端

  // 添加其他字段
  var data = {
    clinicServiceName: clinicServiceName,
    servicePrice: servicePrice,
    serviceDiscountPrice: serviceDiscountPrice,
    serviceItem1: serviceItem1,
    serviceItem2: serviceItem2,
    serviceItem3: serviceItem3,
    serviceItem4: serviceItem4,
  
    // 添加其他字段
  };
console.log("資料"+data);
// 发送Ajax请求
$.ajax({
  url: "../../PriceList/update/" + clinicServiceId, // 替换为实际的后端接口URL
  type: "PUT",
  contentType: "application/json",
  data: JSON.stringify(data),
  success: function (response) {
    // 更新成功的处理逻辑
    console.log('更新成功');
    table.ajax.reload()
  },
  error: function (xhr, status, error) {
    // 更新失败的处理逻辑
  }
});
  // 关闭模态框
  $("#updateModal").modal("hide");
});
    
    }
// ----------------------
  });
});


