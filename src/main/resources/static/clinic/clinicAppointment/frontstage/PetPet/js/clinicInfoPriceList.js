fetch('../../../../clinicMember/manage', {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json'
    }
})
    .then(response => response.json())
    .then(data => {
        // 在這裡處理返回的 JSON 數據
        console.log(data); // 將數據打印到控制台

        // 可以使用循環遍歷數據進行處理
        data.forEach(clinicMember => {
            // 獲取每個 ClinicMember 的屬性值
            const clinicId = clinicMember.clinicId;
            const clinicName = clinicMember.clinicName;
            const clinicAddress = clinicMember.clinicAddress;
            const clinicPhone = clinicMember.clinicPhone;
            const clinicService = clinicMember.clinicService;

            const clinicElement = document.createElement('div');
            clinicElement.classList.add('store_box2'); // Add class to the created div

            clinicElement.innerHTML = `
            <h1 id="clinicName${clinicMember.clinicId}">${clinicMember.clinicName} </h1>
            <dl>
              <dd>
                <span class="flaticon-pawprint-1 mr-2">醫院地址</span>
                <br>
                <p id="clinicAddress${clinicMember.clinicId}">${clinicMember.clinicAddress}
                  <br>
                  <a href="https://www.google.com.tw/maps/place/${clinicMember.clinicAddress}" target="_blank" class="icon fa fa-map"> GOOGLE MAP</a></p>
              </dd>
              <dd>
                <span class="flaticon-pawprint-1 mr-2">預約電話</span><p id="clinicPhone${clinicMember.clinicId}">${clinicMember.clinicPhone}</p>
              </dd>
              <dd>
                <span class="flaticon-pawprint-1 mr-2">門診時間</span>
                <p>門診時間會隨時調整，可點選預約查看詳情</p>
              </dd>
               <dd>
                <span class="flaticon-pawprint-1 mr-2">特色服務</span>
                <p id="clinicService${clinicMember.clinicId}">${clinicMember.clinicService}</p>
              </dd>
            </dl>
`;

            const staffContainer = document.querySelector('.store_box2');
            staffContainer.appendChild(clinicElement);
        });
    })
    .catch(error => {
        console.error('Error:', error);
    });
    
    fetch('../../../../clinicMember/manage', {
  method: 'POST',
  headers: {
    'Content-Type': 'application/json'
  }
})
  .then(response => response.json())
  .then(data => {
    // 在这里处理返回的 JSON 数据
    console.log(data); // 将数据打印到控制台

    // 创建轮播项的数组
    const carouselItems = [];

    // 遍历数据，生成轮播项
    data.forEach(clinicMember => {
      const clinicPhotoDiv = document.createElement('div');
      clinicPhotoDiv.classList.add('carousel-item');

      const clinicPhotoImg = document.createElement('img');
      clinicPhotoImg.src = `data:image/jpeg;base64,${clinicMember.clinicPhoto1}`;
      clinicPhotoImg.classList.add('img-fluid');
      clinicPhotoDiv.appendChild(clinicPhotoImg);

      carouselItems.push(clinicPhotoDiv);
    });

    // 获取轮播容器
    const carouselInner = document.querySelector('.carousel-inner');

    // 清空轮播容器
    carouselInner.innerHTML = '';

    // 添加轮播项到轮播容器
    carouselItems.forEach(item => {
      carouselInner.appendChild(item);
    });
  })
  .catch(error => {
    console.error('Error:', error);
  });

 