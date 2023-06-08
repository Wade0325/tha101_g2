
(() => {
	const btn = document.querySelector('#btn2');
	const clinicName = document.querySelector('#clinicName');
	const vetSn = document.querySelector('#vetSn');
	const weekDate = document.querySelector('#weekDate');
	//	const appointDate = document.querySelector('#appointDate');
	const morningBusiness = document.querySelector('#morningBusiness');
	const morningAppointMax = document.querySelector('#morningAppointMax');
	const afternoonBusiness = document.querySelector('#afternoonBusiness');
	const afternoonAppointMax = document.querySelector('#afternoonAppointMax');
	const nightBusiness = document.querySelector('#nightBusiness');
	const nightAppointMax = document.querySelector('#nightAppointMax');
	//	const inputs = document.querySelectorAll('input');

	const morningBusinessSelect = document.querySelector('#morningBusiness');
	const morningAppointMaxSelect = document.querySelector('#morningAppointMax');

	const afternoonBusinessSelect = document.querySelector('#afternoonBusiness');
	const afternoonAppointMaxSelect = document.querySelector('#afternoonAppointMax');

	const nightBusinessSelect = document.querySelector('#nightBusiness');
	const nightAppointMaxSelect = document.querySelector('#nightAppointMax');

	morningBusinessSelect.addEventListener('change', () => {
		const selectedOption = morningBusinessSelect.value;

		if (selectedOption === '否') { // 如果选择了“否”
			morningAppointMaxSelect.value = 0; // 设置预约人数为0
			morningAppointMaxSelect.disabled = true; // 禁用预约人数下拉菜单
		} else {
			morningAppointMaxSelect.disabled = false; // 启用预约人数下拉菜单
		}
	});

	afternoonBusinessSelect.addEventListener('change', () => {
		const selectedOption = nightBusinessSelect.value;

		if (selectedOption === '否') {
			afternoonAppointMaxSelect.value = 0;
			afternoonAppointMaxSelect.disabled = true;
		} else {
			afternoonAppointMaxSelect.disabled = false;
		}
	});

	nightBusinessSelect.addEventListener('change', () => {
		const selectedOption = nightBusinessSelect.value;

		if (selectedOption === '否') {
			nightAppointMaxSelect.value = 0;
			nightAppointMaxSelect.disabled = true;
		} else {
			nightAppointMaxSelect.disabled = false;
		}
	});


	btn.addEventListener('click', () => {

		if (confirm('確認營業時間?')) {


			msg.textContent = '';
			fetch('../../../../business', {
				method: 'POST',
				headers: {
					'Content-Type': 'application/json',
				},
				body: JSON.stringify({
					clinicName: clinicName.value,
					vetSn: vetSn.value,
					weekDate: weekDate.value,
					//					appointDate: appointDate.value,
					morningBusiness: morningBusiness.value,
					morningAppointMax: morningAppointMax.value,
					afternoonBusiness: afternoonBusiness.value,
					afternoonAppointMax: afternoonAppointMax.value,
					nightBusiness: nightBusiness.value,
					nightAppointMax: nightAppointMax.value
				}),
			})
			//				.then(resp => resp.json())
			//				.then(body => {
			//					//解構賦值 const successful = body.successful
			//					const { successful } = body;
			//					if (successful) {
			//						for (let input of inputs) {
			//							input.disabled = true;
			//						}
			//					}
			//				});
		}
		window.location.reload(); // 重新整理頁面
	});

})();



