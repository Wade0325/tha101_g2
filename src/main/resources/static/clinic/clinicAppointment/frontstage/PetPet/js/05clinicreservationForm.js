(() => {
	const btn = document.querySelector('#btn2');
	const clinicId	= document.querySelector('#clinicId');
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

		msg.textContent = '';
		fetch('http://localhost:8080/petpet/clinicAppointment', {
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
				} else {
					msg.className = 'error';
					msg.textContent = '預約失敗，' + message;

				}
			});
	});

})();



