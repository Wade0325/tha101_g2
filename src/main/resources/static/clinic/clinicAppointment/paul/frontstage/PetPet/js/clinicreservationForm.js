(() => {
	const btn = document.querySelector('#btn2');
	const clinicId = document.querySelector('#clinicId');
	const clinicName = document.querySelector('#clinicName');
	const vetName = document.querySelector('#vetName');
	const appointDate = document.querySelector('#appointDate');
	const appointTime = document.querySelector('#appointTime');
	const ownerName = document.querySelector('#ownerName');
	const ownerMobile = document.querySelector('#ownerMobile');
	const serviceItem = document.querySelector('#serviceItem');
	const petName = document.querySelector('#petName');
	const petType = document.querySelector('#petType');
	const petSituation = document.querySelector('#petSituation');
	const msg = document.querySelector('#msg');
	const inputs = document.querySelectorAll('input');

	btn.addEventListener('click', () => {
		
		const ownerNameLength = ownerName.value.length;
		if (ownerNameLength === 0){
			msg.textContent = '請輸入飼主姓名';
			return;
		}
	
		const ownerMobileLength = ownerMobile.value.length;
		if (ownerMobileLength === 0){
			msg.textContent = '請輸入連絡電話';
			return;
		}
	
		const petNameLength = petName.value.length;
		if (petNameLength === 0){
			msg.textContent = '請輸入寵物名稱';
			return;
		}
		
		const petTypeLength = petType.value.length;
		if (petTypeLength === 0){
			msg.textContent = '請輸入寵物類別';
			return;
		}
		
		const petSituationLength = petSituation.value.length;
		if (petSituationLength === 0){
			msg.textContent = '請簡述寵物概況';
			return;
		}
		
	
		if (confirm('確認預約嗎?')) {

			msg.textContent = '';
			fetch('../../../../../clinicAppointmentInsert', {
				method: 'POST',
				headers: {
					'Content-Type': 'application/json',
				},
				body: JSON.stringify({
					clinicId: clinicId.value,
					clinicName: clinicName.value,
					vetName: vetName.value,
					appointDate: appointDate.value,
					appointTime: appointTime.value,
					ownerName: ownerName.value,
					ownerMobile: ownerMobile.value,
					serviceItem: serviceItem.value,
					petName: petName.value,
					petType: petType.value,
					petSituation: petSituation.value
				}),
			})
				.then(resp => resp.json())
				.then(body => {
					//解構賦值 const successful = body.successful
					const { successful, message } = body;
					if (successful) {
						for (let input of inputs) {
							input.disabled = true;
						}
						btn.disabled = true;
						msg.className = 'info';
						msg.textContent = '預約成功';
						window.location.reload(); // 重新整理頁面
					} else {
						msg.className = 'error';
						msg.textContent = '預約失敗，' + message;
					}
				});
		}
	});

})();



