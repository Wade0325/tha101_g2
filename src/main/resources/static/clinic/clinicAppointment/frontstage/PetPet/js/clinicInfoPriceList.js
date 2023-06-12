fetch('../../../../clinicMember/manage', {
	method: 'POST',
	headers: {
		'Content-Type': 'application/json'
	}
})
	.then(response => response.json())
	.then(data => {
		// 只處理第一筆資料
		const clinicMember = data[0];

		// 獲取該 ClinicMember 的屬性值
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
    <div class="row text-right">
 
</div>


    `;
		const staffContainer = document.querySelector('.store_box2');
		staffContainer.appendChild(clinicElement);
		//    ---------------------照片輪播---------------
		const clinicPhoto = document.createElement('div');
		clinicPhoto.classList.add('photoshift'); // Add class to the created div
		clinicPhoto.innerHTML = `
       <div id="custCarousel" class="carousel slide" data-ride="carousel" aligan="center">
                        <!-- slides -->
                           <!-- 自動生成照片輪播 開始 -->
                        <div class="carousel-inner">
						  <div class="carousel-item active">
						    <img class= "pic" id="clinicPhoto1${clinicMember.clinicId}" src="data:image/jpeg;base64,${clinicMember.clinicPhoto1}" />
						  </div>
						
						  <div class="carousel-item">
						    <img  class= "pic" id="clinicPhoto2${clinicMember.clinicId}" src="data:image/jpeg;base64,${clinicMember.clinicPhoto2}" />
						  </div>
						
						  <div class="carousel-item">
						    <img  class= "pic" id="clinicPhoto3${clinicMember.clinicId}" src="data:image/jpeg;base64,${clinicMember.clinicPhoto3}" />
						  </div>
						</div>
                            <!-- 自動生成照片輪播 結束 -->
                        <!-- Left right -->
                        <a class="carousel-control-prev" href="#custCarousel" data-slide="prev">
                          <span class="carousel-control-prev-icon"></span>
                        </a>
                        <a class="carousel-control-next" href="#custCarousel" data-slide="next">
                          <span class="carousel-control-next-icon"></span>
                        </a>
                
                        <!-- Thumbnails -->
                        <ol class="carousel-indicators list-inline">
                          <li class="list-inline-item active">
                            <a id="carousel-selector-0" class="selected" data-slide-to="0" data-target="#custCarousel">
                              <img src="https://i.imgur.com/weXVL8M.jpg" class="img-fluid">
                            </a>
                          </li>
                
                          <li class="list-inline-item">
                            <a id="carousel-selector-1" data-slide-to="1" data-target="#custCarousel">
                              <img src="https://i.imgur.com/Rpxx6wU.jpg" class="img-fluid">
                            </a>
                          </li>
                
                          <li class="list-inline-item">
                            <a id="carousel-selector-2" data-slide-to="2" data-target="#custCarousel">
                              <img src="https://i.imgur.com/83fandJ.jpg"  class="img-fluid">
                            </a>
                          </li>
                
                         </ol>
                      </div>
                    </div>
    `;
		const photoContainer = document.querySelector('.photoshift');
		photoContainer.appendChild(clinicPhoto);

	})
	.catch(error => {
		//    console.error('Error:', error);
	});
	
//--------價格表------------
//// 发起fetch请求获取数据
fetch('../../../../PriceList/manage', {
    method: 'GET',
    headers: {
        'Content-Type': 'application/json'
    }
})
    .then(response => response.json())
    .then(data => {
        // 获取价格列表容器元素
        const priceContainer = document.querySelector('.price');

        // 计数器，用于判断每行是否已显示三个价格列表项
        let count = 0;

        // 创建价格列表行元素
        let priceRow = document.createElement('div');
        priceRow.classList.add('row');

        // 遍历数据并生成对应的HTML元素
        data.forEach(priceList => {
            // 每三个价格列表项换行
            if (count === 3) {
                priceContainer.appendChild(priceRow); // 添加当前行到容器中
                priceRow = document.createElement('div'); // 创建新的行元素
                priceRow.classList.add('row');
                count = 0; // 重置计数器
            }

            // 创建价格列表元素
            const newPriceElement = document.createElement('div');
            newPriceElement.classList.add('col-md-4', 'ftco-animate', 'fadeInUp', 'ftco-animated');
            // 动态生成HTML内容
            newPriceElement.innerHTML = `
                <div class="block-7">
                	
                      <img class= "serviceImg" id="clinicPhoto1${priceList.serviceImg}" src="data:image/jpeg;base64,${priceList.serviceImg}" />
                    <div class="text-center p-4">
                        <h3 >${priceList.clinicServiceName}</h3>
                        <span class="price">
                        <br>
                            <sup>優惠價</sup>
                            <br>
                            <sup>$</sup><span class="number"">${priceList.serviceDiscountPrice}</span> <sub>元</sub>
                        </span>
                        <span>原價</span> <span class="number" id="service_price">${priceList.servicePrice}</span> <sub>元</sub></span>
                        <ul class="pricing-text mb-5 pt-5">
                            <li><span class="fa fa-check mr-2" id="service_item1"></span>${priceList.serviceItem1}</li>
                            <li><span class="fa fa-check mr-2" id="service_item2"></span>${priceList.serviceItem2}</li>
                            <li><span class="fa fa-check mr-2" id="service_item3"></span>${priceList.serviceItem3}</li>
                            <li><span class="fa fa-check mr-2" id="service_item4"></span>${priceList.serviceItem4}</li>
                        </ul>
                        <a href="http://localhost:8080/petpet/clinic/clinicAppointment/frontstage/PetPet/clinicReservationSpot.html" class="btn btn-primary d-block px-2 py-3">點我預約</a>
                    </div>
                </div>
            `;

            // 将价格列表元素添加到当前行中
            priceRow.appendChild(newPriceElement);
            count++; // 更新计数器
        });

        // 添加最后一行到容器中
        priceContainer.appendChild(priceRow);
    })
    .catch(error => {
        console.log(error);
    });
