(() => {
	const btn1 = document.querySelector('#btn1');
	const msg = document.querySelector('#msg');
	const username = document.querySelector('#username');
	const password = document.querySelector('#password');
	const confirmPassword = document.querySelector('#confirmPassword');
	const nickname = document.querySelector('#nickname');
	const inputs = document.querySelectorAll('input');
	const image = document.querySelector('#image');
	btn1.addEventListener('click', () => {
		const accLength = username.value.length;
		if (accLength < 5 || accLength > 50) {
			msg.textContent = '帳號長度須介於5~50字元';
			return;
		}

		const pwdLength = password.value.length;
		if (pwdLength < 6 || pwdLength > 12) {
			msg.textContent = '密碼長度須介於6~12字元';
			return;
		}

		if (confirmPassword.value !== password.value) {
			msg.textContent = '密碼與確認密碼不相符';
			return;
		}


		const nicknameLength = nickname.value.length;
		if (nicknameLength < 1 || nicknameLength > 20) {
			msg.textContent = '暱稱長度須介於1~20字元';
			return;
		}

		msg.textContent = '';
		const fileReader = new FileReader();
		fileReader.addEventListener('load', e => {
			const imageBase64 = btoa(e.target.result);
			fetch('register', {
				method: 'POST',
				headers: { 'Content-Type': 'application/json' },
				body: JSON.stringify({
					username: username.value,
					password: password.value,
					nickname: nickname.value,
					image: imageBase64
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
		fileReader.readAsBinaryString(image.files[0]);
	});

	const img = document.querySelector('#img');
	image.addEventListener('change', () => {
		const file = image.files[0];
		if (file) {
			img.src = URL.createObjectURL(file);
		}
	});
})();