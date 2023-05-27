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
	const animalDescribe = document.querySelector('#animalDescribe');
	const ifAdopted = document.querySelector('#ifAdopted');
	const fileInputs = document.querySelectorAll('.fileupload');


	delaybtn.addEventListener('click', () => {
		console.log("aaa")
		const nameLength = animalName.value.trim().length;
		const idLength = animalId.value.trim().length;
		const typeLength = animalType.value.trim().length;
		const categoryLength = animalCategory.value.trim().length;
		const colorLength = animalColor.value.trim().length;
		const genderLength = animalGender.value.trim().length;
		const ageLength = animalAge.value.trim().length;
		const inputs = [animalId, userId, animalName, animalType, animalCategory, animalColor, animalGender, animalDate, animalAge, animalDescribe, ifAdopted];

		if (nameLength === 0) {
			msg.textContent = '名稱不可為空';
			return;
		} else if (idLength === 0) {
			msg.textContent = '收容編號不可為空';
			return;
		} else if (typeLength === 0) {
			msg.textContent = '種類不可為空';
			return;
		} else if (categoryLength === 0) {
			msg.textContent = '品種不可為空';
			return;
		} else if (colorLength === 0) {
			msg.textContent = '毛色不可為空';
			return;
		} else if (genderLength === 0) {
			msg.textContent = '請選擇性別';
			return;
		} else if (ageLength === 0) {
			msg.textContent = '請選擇年齡';
			return;
		}

		msg.textContent = '';

		var shelteranimal = {
			animalNumber: animalId.value,
			animalName: animalName.value,
			animalType: animalType.value,
			animalCategory: animalCategory.value,
			animalColor: animalColor.value,
			animalGender: animalGender.value,
			animalDate: animalDate.value,
			animalAge: animalAge.value,
			animalDescribe: animalDescribe.value,
			animalPhoto1: null,
			animalPhoto2: null,
			animalPhoto3: null
		};

		fileInputs.forEach((fileInput, index) => {
			const files = fileInput.files;
			if (files.length > 0) {
				const file = files[0];
				const reader = new FileReader();
				reader.onload = function(event) {
					const base64Data = event.target.result;
					shelteranimal['animalPhoto' + (index + 1)] = base64Data;
				console.log(base64Data)
				};
				reader.readAsDataURL(file);
			}
		});

		fetch('upload', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json',
			},
			body: JSON.stringify(shelteranimal),
		})
			.then((resp) => resp.json())
			.then((body) => {
				const { successful, message } = body;
				if (successful) {
					msg.className = 'info';
					msg.textContent = '送出成功';
				} else {
					msg.className = 'error';
					msg.textContent = '送出失敗' + message;
				}
			})
			.catch((error) => {
				msg.className = 'error';
				msg.textContent = '送出失敗' + error.message;
				console.log(error.message);
			});

	});
})();

