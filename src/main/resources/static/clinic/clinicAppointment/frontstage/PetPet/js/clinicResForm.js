document.addEventListener("DOMContentLoaded", function() {
  var btn = document.getElementById("btn2");
  btn.addEventListener("click", function() {
    alert("已送出預約");
    window.location.href = "http://www.yahoo.com.tw";
  });

  var businessSn = 17; // 替换为实际的businessSn值

  fetch(`http://localhost:8080/petpet/business/${businessSn}`)
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
      
      
      
      
    })
//    .catch((error) => {
//      console.error("Error:", error);
//    });
});
