(() => {
	const btn = document.querySelector('#btn');
	const msg = document.querySelector('#msg');
	const clinicName = document.querySelector('#clinicName');
	const clinicPrincipal = document.querySelector('#clinicPrincipal');
	const clinicPhone = document.querySelector('#clinicPhone');
	const clinicEmail = document.querySelector('#clinicEmail');
	const clinicAddress = document.querySelector('#clinicAddress');
	const clinicPassword = document.querySelector('#clinicPassword');
	const checkPassword = document.querySelector('#checkPassword');
	const clinicService = document.querySelector('#clinicService');
	const inputs = document.querySelectorAll('input');

	btn.addEventListener('click', () => {

		const nameLength = clinicName.value.length;
		if (nameLength === 0) {
			msg.textContent = '請填寫診所名稱';
			return;
		}

		const PrincipalLength = clinicPrincipal.value.length;
		if (PrincipalLength === 0) {
			msg.textContent = '請填寫負責人名稱';
			return;
		}

		const phoneLength = clinicPhone.value.length;
		if (phoneLength !== 10) {
			msg.textContent = '電話號碼長度錯誤';
			return;
		}

		const accLength = clinicEmail.value.length;
		console.log(accLength);
		if (accLength < 5 || accLength > 50) {
			msg.textContent = '帳號長度須介於5~50字元';
			return;
		}

		const clinicAddressLength = clinicAddress.value.length;
		if (clinicAddressLength === 0) {
			msg.textContent = '請填寫診所地址';
			return;
		}

		const pwdLength = clinicPassword.value.length;
		if (pwdLength < 6 || pwdLength > 12) {
			msg.textContent = '密碼長度須介於6~12字元';
			return;
		}

		if (checkPassword.value !== clinicPassword.value) {
			msg.textContent = '密碼與確認密碼不相符';
			return;
		}

		const clinicServiceLength = clinicService.value.length;
		if (clinicServiceLength === 0) {
			msg.textContent = '請填寫診所簡介';
			return;
		}

		msg.textContent = '';
		fetch('register', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json',
			},
			body: JSON.stringify({
				clinicName: clinicName.value,
				clinicPrincipal: clinicPrincipal.value,
				clinicEmail: clinicEmail.value,
				clinicPassword: clinicPassword.value,
				clinicPhone: clinicPhone.value,
				clinicAddress: clinicAddress.value,
				clinicService: clinicService.value

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
					msg.textContent = '註冊成功';
				} else {
					msg.className = 'error';
					msg.textContent = '註冊失敗，' + message;

				}
			});
	});

})();