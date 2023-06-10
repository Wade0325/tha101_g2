let bussinessSn = 0;

$(document).ready(function() {
  var table = $('#example').DataTable({
    ajax: function (data, callback) {
      fetch("http://localhost:8080/petpet/businessall")
        .then((response) => response.json())
        .then((data) => {
          console.log(data);
          callback(data);
        });
    },
    columns: [
      { data: "weekDate" },
      { data: null, render: function (data, type, row) { return '可預約名額'; } },
      { data: "morningAppointMax", render: function(data, type, row) {
          if (data == 0) {
             return '<button class="appointDate full" ' + (data == 0 ? 'disabled' : '') + '>' + '已額滿' + '</button>';
          } else {
            return '<button class="appointDate">' + data + '</button>';
          }
        },
        className: "appointDate",
      },
      { data: null, render: function (data, type, row) { return '可預約名額'; } },
      { data: "afternoonAppointMax", render: function(data, type, row) {
          if (data == 0) {
            return '<button class="appointDate full" ' + (data == 0 ? 'disabled' : '') + '>' + '已額滿' + '</button>';
          } else {
            return '<button class="appointDate">' + data + '</button>';
          }
        },
        className: "appointDate",
      },
      { data: null, render: function (data, type, row) { return '可預約名額'; } },
      { data: "nightAppointMax", render: function(data, type, row) {
          if (data == 0) {
            return '<button class="appointDate full" ' + (data == 0 ? 'disabled' : '') + '>' + '已額滿' + '</button>';
          } else {
            return '<button class="appointDate">' + data + '</button>';
          }
        },
        className: "appointDate",
      },
    ],
    searching: false,
    language: {
      // 省略語言設定...
    },
  });

  $('#example_length').remove();

  $(document).on("click", ".appointDate", function () {
    let row = $(this).closest("tr");
    bussinessSn = table.row(row).data().businessSn;
    console.log("Clicked businessSn:", bussinessSn);

    fetch(`http://localhost:8080/petpet/business/${bussinessSn}`)
      .then((response) => response.json())
      .then((data) => {
        const clinicName = data.clinicName;
        const weekDate = data.weekDate;
        const morningBusiness = data.morningBusiness;
        const afternoonBusiness = data.afternoonBusiness;
        const nightBusiness = data.nightBusiness;

        document.getElementById("clinicName").value = clinicName;
        document.getElementById("weekDate").value = weekDate;
        document.getElementById("morningBusiness").textContent = morningBusiness;
        document.getElementById("afternoonBusiness").textContent = afternoonBusiness;
        document.getElementById("nightBusiness").textContent = nightBusiness;
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
    } else if (selectedValue === "結紮") {
      payInfoSelect.value = "預付2000元";
    } else if (selectedValue === "健康檢查") {
      payInfoSelect.value = "預付2000元";
    } else if (selectedValue === "洗牙") {
      payInfoSelect.value = "預付2000元";
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
    window.location.href = "http://localhost:8080/petpet/clinic/clinicAppointment/frontstage/PetPet/VetSearchResult.html";
    return; // 增加return语句，防止后续逻辑执行
  }


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
        petSituation: petSituation.value
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