fetch('../../../clinicMember/manage', {
    method: 'POST',
    headers: {
       'Content-Type': 'application/json'
       }
  })
  .then(response => response.json())
  .then(data => {
    // 在这里处理返回的JSON数据
    console.log(data); // 将数据打印到控制台	`
    
    // 可以使用循环遍历数据进行处理
    data.forEach(clinicMember => {
      // 获取每个ClinicMember的属性值
      const clinicId = clinicMember.clinicId;
      const clinicName = clinicMember.clinicName;
      const clinicAddress = clinicMember.clinicAddress;
      const clinicPhone = clinicMember.clinicPhone;
      const clinicService = clinicMember.clinicService;
      
      // 在页面中动态生成HTML元素，并将属性值填充到对应位置
      const clinicElement = document.createElement('div');
      clinicElement.classList.add('staff');
      clinicElement.innerHTML = `
        <div class="img-wrap d-flex align-items-stretch">
          <div class="col-md-6 col-lg-3 img align-self-stretch"
            style="background-image: url(image/jpeg;base64,${clinicMember.clinicPhoto1})">
          </div>
          <div class="col-md-6 col-lg-9 text pt-3 px-3 pb-4 text-left">
            <h2 id="clinicName${clinicId}">${clinicName}</h2>
            <span class="flaticon-pawprint-1 mr-2"></span>
            <h3 class="position mb-2" id="clinicAddress${clinicId}">${clinicAddress}</h3>
            <br>
            <span class="flaticon-pawprint-1 mr-2"></span>
            <h3 class="position mb-2" id="clinicPhone${clinicId}">${clinicPhone}</h3>
            <div class="faded">
              <p id="clinicService${clinicId}">${clinicService}</p>
            </div>
          </div>
        </div>
      `;
      
      // 将动态生成的元素插入到页面中的适当位置
      const clinicContainer = document.getElementById('clinicContainer'); // 替换为实际的容器元素ID
      clinicContainer.appendChild(clinicElement);
    });
  })
  .catch(error => {
    console.error('Error:', error);
  });
  