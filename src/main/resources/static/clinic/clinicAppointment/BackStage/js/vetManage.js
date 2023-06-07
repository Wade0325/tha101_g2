document.addEventListener("DOMContentLoaded", function () {
    var table = $("#vet").DataTable({
		
      ajax: function (d, cb) {
        fetch("../../../vet/init")
          .then((response) => response.json())
          .then((data) => {
            console.log(data);
            cb(data);
          });
      },
      columns: [
        { data: "vetSn" }, //對應資料庫的欄位名稱
        { data: "clinicId" },
        { data: "vetName" },
        { data: "vetGender" },
        { data: "specialty" },
        { data: "seniority" },
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
          
          var vetSn = table.row(row).data().vetSn;
          console.log("Clicked vetSn:", vetSn);
          // 在这里可以执行你想要的操作，使用vetSn的值
          
            if (confirm('確定要刪除嗎？')) {
        // 發送刪除請求到後端 API
        fetch('../../../vet/delete/' + vetSn, {
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
        var vetSn = data.vetSn;
        var clinicId = data.clinicId;
        var vetName = data.vetName;
        var vetGender = data.vetGender;
        var specialty = data.specialty;
        var seniority = data.seniority;
    
    
  
        // 更新模态框中的表单字段值
        $("#vetSn").val(vetSn);
        $("#clinicId").val(clinicId);
        $("#vetName").val(vetName);
        $("#vetGender").val(vetGender);
        $("#specialty").val(specialty);    
        $("#seniority").val(seniority);

        // 显示模态框
        $("#updateModal").modal("show");
      });
      
       // 点击更新按钮的事件处理程序
  $("#updateBtn").on("click", function () {
    var vetSn = $("#vetSn").val();
    var clinicId =  $("#clinicId").val();
    var vetName =   $("#vetName").val();
    var vetGender =  $("#vetGender").val();
    var specialty =  $("#specialty").val();    
    var seniority =  $("#seniority").val();
   
    
    
    // 在这里可以执行更新操作或发送更新请求到后端
  
    // 添加其他字段
    var data = {
        vetSn : vetSn,
        clinicId :  clinicId,
        vetName :  vetName,
        vetGender :  vetGender,
        specialty :  specialty,   
        seniority :   seniority,
    
      // 添加其他字段
    };
  console.log("資料"+data);
  // 发送Ajax请求
  $.ajax({
    url: "../../../vet/update/" + vetSn, // 替换为实际的后端接口URL
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
  
  
  