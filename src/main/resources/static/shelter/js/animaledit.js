const urlParams = new URLSearchParams(window.location.search);
const id = urlParams.get('id');

const delaybtn = document.querySelector('#delaybtn');
const animalId = document.querySelector('#animalId');
const userId = document.querySelector('#userId');
const animalName = document.querySelector('#animalName');
const animalNumber = document.querySelector('#animalId');
const animalType = document.querySelector('#animalType');
const animalCategory = document.querySelector('#animalCategory');
const animalColor = document.querySelector('#animalColor');
const animalGender = document.querySelector('#animalGender');
const animalDate = document.querySelector('#animalDate');
const animalAge = document.querySelector('#animalAge');
const animalDescribe = document.querySelector('#animalDescribe');
const animalP1 = document.querySelector('#animalPhoto1');
const animalP2 = document.querySelector('#animalPhoto2');
const animalP3 = document.querySelector('#animalPhoto3');
const ifAdopted = document.querySelector('#ifAdopted');
const fileInputs = document.querySelectorAll('.fileupload');
fetch(`animalfindbyid/${id}`, {
	method: 'POST',
	headers: {
		'Content-Type': 'application/json'
	},
	body: {

	}
})
	.then(resp => resp.json())
	.then(ShelterAnimal => {
		animal = ShelterAnimal
		console.log(animal);
		animalName.value = animal.animalName;
		animalType.value = animal.animalType;
		animalCategory.value = animal.animalCategory;
		animalColor.value = animal.animalColor;
		animalGender.value = animal.animalGender;
		animalDate.value = animal.animalDate;
		animalAge.value = animal.animalAge;
		animalNumber.value = animal.animalNumber;
		animalDescribe.value = animal.animalDescribe;
		animalP1.src = animalP1.src + animal.animalPhoto1;
		animalP2.src = animalP2.src + animal.animalPhoto2;
		animalP3.src = animalP3.src + animal.animalPhoto3;


	})
	
	delaybtn.addEventListener('click', async () => {
		const nameLength = animalName.value.trim().length;
		const idLength = animalId.value.trim().length;
		const typeLength = animalType.value.trim().length;
		const categoryLength = animalCategory.value.trim().length;
		const colorLength = animalColor.value.trim().length;
		const genderLength = animalGender.value.trim().length;
		const ageLength = animalAge.value.trim().length;
	
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
//		let base64Data1 = animalPhoto1.src
//		let base64Data2 = animalPhoto2.src
//		let base64Data3 = animalPhoto3.src
//
//		var parts1 = base64Data1.split(",");
//		if (parts1.length > 1) {
//			base64Data1 = parts1[1]; // 去除前缀，保留编码数据部分
//		}
//		var parts2 = base64Data2.split(",");
//		if (parts2.length > 1) {
//			base64Data2 = parts2[1]; // 去除前缀，保留编码数据部分
//		}
//		var parts3 = base64Data3.split(",");
//		if (parts3.length > 1) {
//			base64Data3 = parts3[1]; // 去除前缀，保留编码数据部分
//		}
//	


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
			animalPhoto1: animal.animalPhoto1,
			animalPhoto2: animal.animalPhoto2,
			animalPhoto3: animal.animalPhoto3
		};





		fetch(`animaledit/${id}`, {
			method: 'PUT',
			headers: {
				'Content-Type': 'application/json',
			},
			body: JSON.stringify(shelteranimal),
		})
			.then((resp) => resp.json())
			.then((body) => {
				const {successful} = body;
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
				console.log(error.message);
			});

	});