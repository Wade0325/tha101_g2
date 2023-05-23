(() => {
	const delaybtn = document.querySelector('#delaybtn');
	const animalId = document.querySelector('#animalId');
	const userId = document.querySelector('#userId');
	const animalName = document.querySelector('#animalName');
	const animalType = document.querySelector('#animalType');
	const animalCategory = document.querySelector('#animalCategory');
	const animalColor = document.querySelector('#animalColor');
	const animalGender = document.querySelector('#animalGender');
	const animalDate = document.querySelector('#animalDate');
	const animalAge = document.querySelector('#animalAge');
	const animalPhoto1 = document.querySelector('#animalPhoto1');
	const animalPhoto2 = document.querySelector('#animalPhoto2');
	const animalPhoto3 = document.querySelector('animalPhoto1');
	const animalDescribe = document.querySelector('#animalDescribe');
	const ifAdopted = document.querySelector('#ifAdopted');
	delaybtn.addEventListener('click', () => {
		const nameLength = animalName.value.trim().length;
		const idLength = animalId.value.trim().length;
		const typeLength = animalType.value.trim().length;
		const categoryLength = animalCategory.value.trim().length;
		const colorLength = animalColor.value.trim().length;
		const genderLength = animalGender.value.trim().length;
		const ageLength = animalAge.value.trim().length;
		if (nameLength == 0) {
			msg.textContent = '名稱不可為空';
			return;
			console.log(msg.textContent)
		}
		else if (idLength === 0) {
			msg.textContent = '收容編號不可為空';
			return;
		}
		else if (typeLength === 0) {
			msg.textContent = '種類不可為空';
			return;
		}
		else if (categoryLength === 0) {
			msg.textContent = '品種不可為空';
			return;
		}
		else if (colorLength === 0) {
			msg.textContent = '毛色不可為空';
			return;
		}
		else if (genderLength === 0) {
			msg.textContent = '請選擇性別';
			return;
		}
		else if (ageLength === 0) {
			msg.textContent = '請選擇年齡';
			return;
		}
		msg.textContent = '';
		const fileReader = new FileReader();
		fileReader.addEventListener('load', e => {
			const imageBase64 = btoa(e.target.result);
			fetch('shelterupload', {
				method: 'POST',
				headers: { 'Content-Type': 'application/json' },
				body: JSON.stringify({
					animalId: animalId.value,
					userId: userId.value,
					animalName: animalName.value,
					animalType: animalType.value,
					animalCategory: animalCategory.value,
					animalColor: animalColor.value,
					animalGender: animalGender.value,
					animalDate: animalDate.value,
					animalAge: animalAge.value,
					animalDescribe: animalDescribe.value,
					ifAdopted: ifAdopted.value
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
	

	
		
	});


})();