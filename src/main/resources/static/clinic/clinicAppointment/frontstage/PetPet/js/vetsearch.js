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
			clinicElement.classList.add('staff');

			const clinicPhotoDiv = document.createElement('div');
			clinicPhotoDiv.classList.add('clinicphoto', 'col-md-6', 'col-lg-6', 'align-self-stretch');

			const clinicPhotoImg = new Image();
			clinicPhotoImg.src = `data:image/jpeg;base64,${clinicMember.clinicPhoto1}`;
			clinicPhotoImg.alt = 'Clinic Photo';
			clinicPhotoImg.classList.add('clinic-photo');

			clinicPhotoDiv.appendChild(clinicPhotoImg);

			clinicElement.innerHTML = `
  <div class="img-wrap d-flex align-items-stretch bg-light">
    ${clinicPhotoDiv.outerHTML}
    <div class="col-md-6 col-lg-6 text  text-left">
      <h2 id="clinicName${clinicMember.clinicId}">${clinicMember.clinicName}</h2>
      <span class="flaticon-pawprint-1 mr-2"></span>
      <h3 class="position mb-2" id="clinicAddress${clinicMember.clinicId}">${clinicMember.clinicAddress}</h3>
      <br>
      <span class="flaticon-pawprint-1 mr-2"></span>
      <h3 class="position mb-2" id="clinicPhone${clinicMember.clinicId}">${clinicMember.clinicPhone}</h3>
     <br>
      <div class="faded">
        <h4 id="clinicService${clinicMember.clinicId}">${clinicMember.clinicService}</h4>
      </div>
    </div>
  </div>
`;

			const staffContainer = document.querySelector('.staff');
			staffContainer.appendChild(clinicElement);
		});
	})
	.catch(error => {
		console.error('Error:', error);
	});

	
	