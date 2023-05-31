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



	delaybtn.addEventListener('click', async () => {
		const nameLength = animalName.value.trim().length;
		const idLength = animalId.value.trim().length;
		const typeLength = animalType.value.trim().length;
		const categoryLength = animalCategory.value.trim().length;
		const colorLength = animalColor.value.trim().length;
		const genderLength = animalGender.value.trim().length;
		const ageLength = animalAge.value.trim().length;
		const inputs = [animalId, userId, animalName, animalType, animalCategory, animalColor, animalGender, animalDate, animalAge, animalDescribe, ifAdopted];
	
		if (nameLength === 0) {
			alert('名稱不可為空');
			return;
		} else if (idLength === 0) {
			alert('收容編號不可為空');
			return;
		} else if (typeLength === 0) {
			alert('種類不可為空');
			return;
		} else if (categoryLength === 0) {
			alert('品種不可為空');
			return;
		} else if (colorLength === 0) {
			alert('毛色不可為空');
			return;
		} else if (genderLength === 0) {
			alert('請選擇性別');
			return;
		} else if (ageLength === 0) {
			alert('請選擇年齡');
			return;
		} else if (uploadedCount < 3) {
			alert('請上傳三張圖片');
			return;
		}
		console.log(animalphoto1)
		let base64Data1 = animalPhoto1.src
		let base64Data2 = animalPhoto2.src
		let base64Data3 = animalPhoto3.src

		var parts1 = base64Data1.split(",");
		if (parts1.length > 1) {
			base64Data1 = parts1[1]; // 去除前缀，保留编码数据部分
		}
		var parts2 = base64Data2.split(",");
		if (parts2.length > 1) {
			base64Data2 = parts2[1]; // 去除前缀，保留编码数据部分
		}
		var parts3 = base64Data3.split(",");
		if (parts3.length > 1) {
			base64Data3 = parts3[1]; // 去除前缀，保留编码数据部分
		}
	


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
			animalPhoto1: base64Data1,
			animalPhoto2: base64Data2,
			animalPhoto3: base64Data3
		};





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
					msg.textContent = '送出失敗';
				}
			})
			.catch((error) => {
				msg.className = 'error';
				msg.textContent = '送出失敗';
				console.log(error.message);
			});

	});
})();

