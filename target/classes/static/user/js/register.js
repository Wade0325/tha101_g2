(() => {
	const btn1 = document.querySelector('#btn');
	const msg = document.querySelector('#msg');
	const email = document.querySelector('#email');
	const password = document.querySelector('#password');
	const checkPassword = document.querySelector('#checkPassword');
	const phone = document.querySelector('#phone');
	const address = document.querySelector('#address');
	const inputs = document.querySelectorAll('input');
	btn.addEventListener('click', () => {
		const accLength = email.value.length;
	console.log(accLength);
		if (accLength < 5 || accLength > 50) {
			msg.textContent = '帳號長度須介於5~50字元';
			return;
		}

		const pwdLength = password.value.length;
		if (pwdLength < 6 || pwdLength > 12) {
			msg.textContent = '密碼長度須介於6~12字元';
			return;
		}

		if (checkPassword.value !== password.value) {
			msg.textContent = '密碼與確認密碼不相符';
			return;
		}

		const phoneLength = phone.value.length;
		if (phoneLength != 10) {
			msg.textContent = '電話號碼長度錯誤';
			return;
		}

		msg.textContent = '';
		fetch('register', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json',
			},
			body: JSON.stringify({
				username: email.value,
				password: password.value,
				nickname: phone.value,
			}),
		})
			.then(resp => resp.json())
			.then(body => {
				const { successful } = body;
				if (successful) {
					for (let input of inputs) {
						input.disabled = true;
					}
					btn1.disabled = true;
					msg.className = 'info';
					msg.textContent = '註冊成功';
				} else {
					msg.className = 'error';
					msg.textContent = '註冊失敗';
				}
			});
	});

})();