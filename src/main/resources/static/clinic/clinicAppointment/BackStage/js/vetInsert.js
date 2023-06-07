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