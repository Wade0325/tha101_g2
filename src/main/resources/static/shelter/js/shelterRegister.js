
(() => {
	const btn = document.querySelector('#btn');
	const msg = document.querySelector('#msg');
	const shelterName = document.querySelector('#shelterName');
	const shelterPrincipal = document.querySelector('#shelterPrincipal');
	const shelterPhone = document.querySelector('#shelterPhone');
	const shelterEmail = document.querySelector('#shelterEmail');
	const shelterAddress = document.querySelector('#shelterAddress');
	const shelterPassword = document.querySelector('#shelterPassword');
	const checkPassword = document.querySelector('#checkPassword');
	const inputs = document.querySelectorAll('input');


	btn.addEventListener('click', () => {

		const nameLength = shelterName.value.length;
		if (nameLength === 0) {
			msg.textContent = '請填寫收容所名稱';
			return;
		}

		const PrincipalLength = shelterPrincipal.value.length;
		if (PrincipalLength === 0) {
			msg.textContent = '請填寫負責人名稱';
			return;
		}

		const phoneLength = shelterPhone.value.length;
		if (phoneLength !== 10) {
			msg.textContent = '電話號碼長度錯誤';
			return;
		}

		const accLength = shelterEmail.value.length;
		console.log(accLength);
		if (accLength < 5 || accLength > 50) {
			msg.textContent = '帳號長度須介於5~50字元';
			return;
		}

		const shelterAddressLength = shelterAddress.value.length;
		if (shelterAddressLength === 0) {
			msg.textContent = '請填寫收容所地址';
			return;
		}

		const pwdLength = shelterPassword.value.length;
		if (pwdLength < 6 || pwdLength > 12) {
			msg.textContent = '密碼長度須介於6~12字元';
			return;
		}

		if (checkPassword.value !== shelterPassword.value) {
			msg.textContent = '密碼與確認密碼不相符';
			return;
		}

	

		msg.textContent = '';
	
			fetch('register', {
				method: 'POST',
				headers: {
					'Content-Type': 'application/json',
				},
				body: JSON.stringify({
					shelterName: shelterName.value,
					shelterPrincipal: shelterPrincipal.value,
					shelterEmail: shelterEmail.value,
					shelterPassword: shelterPassword.value,
					shelterPhone: shelterPhone.value,
					shelterAddress: shelterAddress.value,
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