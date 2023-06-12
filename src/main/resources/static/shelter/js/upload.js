const fileuploadInput = document.getElementById('fileupload');
		const uploadShowDiv = document.getElementById('upload_show_div');
		let uploadedCount = 0;
		var a = 0;
		fileuploadInput.addEventListener('change', function() {
			const files = fileuploadInput.files;

			if (uploadedCount + files.length > 3) {
				alert('最多只能上傳三張照片！');
				return;
			}

			for (let i = 0; i < files.length; i++) {
				const file = files[i];
				const reader = new FileReader();

				reader.onload = function(event) {
					const imageSrc = event.target.result;
					const imageElement = document.createElement('div');
					imageElement.setAttribute('class', 'col-md-4 text-center');

					const imgElement = document.createElement('img');
					imgElement.setAttribute('src', imageSrc);
					imgElement.setAttribute('class', 'uploaded-image');
					imgElement.setAttribute('name', 'animalPhoto'
							+ uploadedCount);
					imageElement.appendChild(imgElement);
					a++;

					const deleteButton = document.createElement('button');
					deleteButton.textContent = '删除';
					deleteButton.setAttribute('class',
							'delete-button btn btn-success');
					deleteButton.addEventListener('click', function() {
						imageElement.parentNode.removeChild(imageElement);
						uploadedCount--;
						a--;
					});
					imageElement.appendChild(deleteButton);
					uploadShowDiv.appendChild(imageElement);
					if(a==1){
					animalphoto1 = imageSrc;}
					if(a==2){
					animalphoto2 = imageSrc;}
					if(a==3){
					animalphoto3 = imageSrc;}
				};
				reader.readAsDataURL(file);
			}

			uploadedCount += files.length;
		});





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
	const animalArea = document.querySelector('#animalArea');
	const ifAdopted = document.querySelector('#ifAdopted');
	


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
		} else if (animalArea.value === "") {
			alert('請選擇區域');
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

		var parts1 = animalphoto1.split(",");
		if (parts1.length > 1) {
			animalphoto1 = parts1[1]; // 去除前缀，保留编码数据部分
		}
		var parts2 = animalphoto2.split(",");
		if (parts2.length > 1) {
			animalphoto2 = parts2[1]; // 去除前缀，保留编码数据部分
		}
		var parts3 = animalphoto3.split(",");
		if (parts3.length > 1) {
			animalphoto3 = parts3[1]; // 去除前缀，保留编码数据部分
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
			animalArea:animalArea.value,
			animalPhoto1: animalphoto1,
			animalPhoto2: animalphoto2,
			animalPhoto3: animalphoto3
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
					alert('送出成功');
					window.location.href = 'animalmanage.html';
				} else {
					alert('送出失敗');
				}
			})

	});
})();

