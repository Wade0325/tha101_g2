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
	const inputs = document.querySelectorAll('input');

	btn.addEventListener('click', () => {

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
					const { successful } = body;
					if (successful) {
						for (let input of inputs) {
							input.disabled = true;
						}
					}
				});
		}
		window.location.reload(); // 重新整理頁面
	});

})();



