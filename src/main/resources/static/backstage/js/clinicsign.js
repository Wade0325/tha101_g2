const clinicbtn = document.querySelector('#clinicbtn'); //註冊
clinicbtn.addEventListener('click', () => {
	console.log("clinic")
});


(() => {
	const cliniclogin = document.querySelector('#cliniclogin');
	const clinicEmail = document.querySelector('#clinicEmail');
	const clinicPassword = document.querySelector('#clinicPassword');

	cliniclogin.addEventListener('click', () => {
		console.log("cliniclogin")

		const clinicEmailLength = clinicEmail.value.length;
		if (clinicEmailLength === 0) {
			alert('請輸入帳號');
			return;
		}

		const clinicPasswordLength = clinicPassword.value.length;
		if (clinicPasswordLength === 0) {
			alert('請輸入密碼');
			return;
		}

		fetch('../clinicMember/login', {
			method: 'post',
			headers: {
				'Content-Type': 'application/json',
			},
			body: JSON.stringify({
				clinicEmail: clinicEmail.value,
				clinicPassword: clinicPassword.value
			}),
		})
			.then(resp => resp.json())
			.then(body => {
				const { successful } = body;
				if (successful) {
					window.location.href = "http://localhost:8080/petpet/clinic/clinicAppointment/BackStage/clinicbusinessdate.html";
				} else {
					alert('登入失敗');
				}
			})




	});
})();