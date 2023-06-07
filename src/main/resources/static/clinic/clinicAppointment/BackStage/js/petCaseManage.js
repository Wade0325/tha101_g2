document.addEventListener("DOMContentLoaded", function () {
    var table = $("#petCase").DataTable({
      ajax: function (d, cb) {
        fetch("http://localhost:8080/petpet/petcases")
          .then((response) => response.json())
          .then((data) => {
            console.log(data);
            cb(data);
          });
      },
      columns: [
        { data: "casesSn" }, //對應資料庫的欄位名稱
        { data: "vetSn" },
        { data: "userId" },
        { data: "appointDate" },
        { data: "ownerMobile" },
        { data: "petType" },
        { data: "petName" },
        { data: "petGender" },
        { data: "petAge" },
        { data: "petSituation" },
         { data: "treatment" },
        { data: "result" },
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
          
          var casesSn = table.row(row).data().casesSn;
          console.log("Clicked casesSn:", casesSn);
          // 在这里可以执行你想要的操作，使用vetSn的值
          
            if (confirm('確定要刪除嗎？')) {
        // 發送刪除請求到後端 API
        fetch('../../../petcases/delete/' + casesSn, {
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
        var casesSn = data.casesSn;
        var vetSn = data.vetSn;
        var userId = data.userId;
        var appointDate= data.appointDate;
        var ownerMobile = data.ownerMobile;
        var petType = data.petType;
        var petName = data.petName;
        var petGender = data.petGender;
        var petAge = data.petAge;
        var petSituation = data.petSituation;
         var treatment =data.treatment;
        var result = data.result;
    
        // 更新模态框中的表单字段值
        $("#casesSn").val(casesSn);
        $("#vetSn").val(vetSn);
        $("#userId").val(userId);
        $("#appointDate").val(appointDate);
        $("#ownerMobile").val(ownerMobile);
        $("#petType").val(petType);
        $("#petName").val(petName);
        $("#petGender").val(petGender);
        $("#petAge").val(petAge);
        $("#petSituation").val(petSituation);  
         $("#treatment").val(treatment);  
        $("#result").val(result);

        // 显示模态框
        $("#updateModal").modal("show");
      });
      
       // 点击更新按钮的事件处理程序
  $("#updateBtn").on("click", function () {
   
        var casesSn =  $("#casesSn").val();
        var vetSn =  $("#vetSn").val();
        var userId = $("#userId").val();
        var appointDate= $("#appointDate").val();
        var ownerMobile = $("#ownerMobile").val();
        var petType = $("#petType").val();
        var petName =  $("#petName").val();
        var petGender =  $("#petGender").val();
        var petAge = $("#petAge").val();
        var petSituation = $("#petSituation").val();
          var treatment= $("#treatment").val();  
        var result =  $("#result").val();   
    
    // 在这里可以执行更新操作或发送更新请求到后端
  
    // 添加其他字段
    var data = {
      casesSn:casesSn,
        vetSn : vetSn,
        userId:userId,
        appointDate:appointDate,
        ownerMobile: ownerMobile,
        petType:petType,
        petName:petName,
        petAge:petAge,
        petGender:petGender,
        petSituation:petSituation,
  		 treatment: treatment,
        result:result,
    
      // 添加其他字段
    };
  console.log("資料"+data);
  // 发送Ajax请求
  $.ajax({
    url: "../../../petcases/update/" + casesSn, // 替换为实际的后端接口URL
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
  
  
  