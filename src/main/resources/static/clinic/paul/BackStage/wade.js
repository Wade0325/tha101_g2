(() => {
	const btn = document.querySelector('#btn');
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
				userAccount: email.value,
				userPassword: password.value,
				userTel: phone.value,
				address: address.value
			}),
		})
			.then(resp => resp.json())
			.then(body => {
				//解構賦值 const successful = body.successful
				const { successful,message } = body; 
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



<script>
var submitButton = document.querySelector('.btn-danger');
submitButton.addEventListener('click', function(event) {
  console.log("有用到嗎")
  event.preventDefault();

  var form = document.getElementById('clinic_insert');
  var formData = new FormData(form);
  // 使用Fetch API進行表單提交
 
  fetch('clinicMember/clinic_pricelist_intsert', {
    method: 'POST',
    headers: {
		'Content-Type': 'application/json',
  },
  	body: JSON.stringify({
  		
		clinicServiceName: clinic_service_name.value,
		servicePrice: service_price.value
  	}),
  	}
  .then(function(response) {
    if (response.ok) {
      return response.text(); // 如果伺服器回應正常，獲取回應的內容
    } else {
      throw new Error('表單提交失敗');
    }
  })
  .then(function(data) {
    console.log(data); // 在這裡處理回應的資料
  })
  .catch(function(error) {
    console.error(error); // 處理錯誤
  });
});

  </script>
    