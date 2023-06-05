//(() => {
//	const btn = document.querySelector('#submitbtn');
//	//const file = document.querySelector('#file');
//
//	//file.addEventListener('change', () => {
//	//  const service_img = document.querySelector('#service_img');
//	//  service_img.src = URL.createObjectURL(file.files[0]);
//	//});
//
//	//document.querySelector('#submitbtn').addEventListener('click', (event) => {
//	//  event.preventDefault();
//
//	const clinic_id = document.querySelector('#clinicId');
//	const vet_name = document.querySelector('#vetName');
//	const vet_gender = document.querySelector('input[name="gender"]:checked').value;
//	const speciality = document.querySelector('#specialty');
//	const seniority = document.querySelector('#seniority');
//
//	btn.addEventListener('click', () => {
//
//
//		//   const fr = new FileReader();
//		//   fr.addEventListener('load', (e) => {
//		//     const base64Img = e.target.result.split(',')[1]; // 获取 base64 字符串部分
//		fetch('../../../../../PriceList', {
//			method: "POST",
//			headers: {
//				'Content-Type': 'application/json'
//			},
//			body: JSON.stringify({
//				clinicId: clinic_id.value,
//				vetName: vet_name.value,
//				vetGender: vet_gender.value,
//				speciality: speciality.value,
//				seniority: seniority.value,
//				// serviceImg: base64Img
//			}),
//		})
//		//	}
//	});
//
//	//   fr.readAsDataURL(file.files[0]);
//})();

(() => {
	const btn = document.querySelector('#submitbtn');
	const clinic_id = document.querySelector('#clinicId');
	const vet_name = document.querySelector('#vetName');
	const specialty = document.querySelector('#specialty');
	const seniority = document.querySelector('#seniority');
	const vet_gender = document.querySelector('input[name="gender"]:checked').value;

	btn.addEventListener('click', () => {
		if (!vet_gender) {
			// 如果沒有選擇性別，執行相應的錯誤處理邏輯
			return;
		}

		fetch('../../../../../vet', {
			method: "POST",
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify({
				clinicId: clinic_id.value,
				vetName: vet_name.value,
				vetGender: vet_gender,
				specialty: specialty.value,
				seniority: seniority.value
			})
		});
	});
})();

